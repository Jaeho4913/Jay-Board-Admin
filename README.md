# Jay-Board-Admin

Jay-Board 게시판 서비스의 관리자 애플리케이션입니다.
사용자 서비스와 인증 주체가 달라 별도 프로젝트로 분리했습니다.

사용자 서비스 및 전체 설계 문서: [Jay-Board](https://github.com/Jaeho4913/Jay-Board)

- [사용자 게시판](http://3.35.138.85/)
- [관리자 로그인](http://3.35.138.85:8081/admin/login)

## 기술 스택

- Java 17
- Spring Boot 3.5.8
- Spring Security
- MyBatis
- MariaDB
- JSP / jQuery
- Maven / WAR
- Ubuntu / systemd

## 프로젝트를 분리한 이유

관리자 기능을 Jay-Board 안에 함께 두었을 때, SecurityConfig가 사용자 인증과
관리자 인증을 동시에 처리하면서 설정이 얽혔습니다.
AuthenticationProvider를 분리해 보았으나 유지보수 비용이 줄지 않아,
프로젝트 자체를 나누는 방향으로 결정했습니다.

관리자 계정은 일반 회원 테이블(members)과 분리된 tb_admin_member로 관리하며,
등급과 상태에 대한 상세 설계는 Jay-Board 저장소의 4장을 따릅니다. 설계에 포함된 모든 권한·운영 기능이 구현된 것은 아닙니다.

## 개발 진행 현황

완료

- 관리자 로그인
- 관리자 홈
- 대시보드
- 회원 관리
- 카테고리 관리
  - 게시판 그룹 목록 조회, 생성 및 수정
  - 활성 상태·정렬 순서 및 NORMAL/GALLERY/LIVE 유형 관리
  - 일반 글과 라이브 글이 모두 없는 게시판 그룹만 삭제
  - LIVE와 다른 유형 사이의 전환은 일반 글·라이브 글이 모두 없는 경우에만 허용
  - GALLERY로 전환할 때 이미지 없는 일반 글이 있으면 차단
  - 생성·수정 입력값 검증 및 존재하지 않는 게시판 그룹 예외 처리

진행 중

- 게시글 관리
- 댓글 관리

예정

- 통계
- 관리자 관리
- 운영 로그

## EC2 배포

사용자 게시판과 관리자 애플리케이션은 별도의 WAR와 systemd 서비스로 실행합니다. 사용자 WAR를 교체해도 관리자 코드는 갱신되지 않으므로, 변경된 프로젝트를 각각 빌드·배포합니다.

- AWS EC2의 Ubuntu ARM64 환경에서 운영합니다.
- Java 17과 MariaDB를 사용합니다.
- 관리자 애플리케이션은 WAR 파일로 빌드하며, 서버의 `/opt/jay-board-admin/admin.war`에 배포합니다.
- 애플리케이션 설정값은 `/etc/jay-board-admin.env`에서 환경 변수로 관리합니다.
- `jay-board-admin.service` systemd 서비스로 애플리케이션을 실행하고 재시작합니다.
- 배포 전 기존 WAR 파일을 백업한 뒤 새 파일로 교체하고, 서비스 상태와 관리자 로그인 화면을 확인합니다.
- 비밀번호와 같은 민감정보는 저장소에 포함하지 않습니다.

### LIVE 배포 전 DB 준비

사용자·관리자 애플리케이션은 같은 게시판 DB를 사용합니다. 관리자 게시판 변경·삭제 검증에서도 `tb_live_post`를 조회하므로, 관리자 새 버전 배포 전에 테이블이 존재해야 합니다.

테이블이 없는 경우 사용자 프로젝트의 [LIVE 테이블 생성 SQL](https://github.com/Jaeho4913/Jay-Board/blob/main/sql/2026-10-04-create-live-post.sql)을 확인해 적용합니다. 부모 테이블 `tb_board_group`, `members`의 외래키 대상 컬럼과 문자셋이 호환되어야 합니다.

### 빌드 및 업로드

프로젝트 루트의 Windows PowerShell에서 실행합니다.

```powershell
.\mvnw.cmd clean package
```

`BUILD SUCCESS`와 WAR 생성 시각을 확인한 뒤 업로드합니다.

```powershell
scp -i "<SSH_KEY_PATH>" .\target\jay-board-admin-0.0.1-SNAPSHOT.war <DEPLOY_USER>@<SERVER_HOST>:/tmp/jay-board-admin-new.war
```

### 백업 및 교체

SSH 접속 후 서비스의 실제 실행 경로를 확인합니다.

```bash
sudo systemctl show jay-board-admin -p ExecStart -p WorkingDirectory --no-pager
ls -lh /tmp/jay-board-admin-new.war
```

실행 경로가 `/opt/jay-board-admin/admin.war`인 경우 다음 순서로 배포합니다. 각 명령의 성공을 확인하고 다음 명령을 실행합니다.

```bash
sudo cp -p /opt/jay-board-admin/admin.war /opt/jay-board-admin/admin.war.bak-$(date +%Y%m%d-%H%M%S)
sudo systemctl stop jay-board-admin
sudo cp /tmp/jay-board-admin-new.war /opt/jay-board-admin/admin.war
sudo systemctl start jay-board-admin
sudo systemctl status jay-board-admin --no-pager -l
sudo journalctl -u jay-board-admin -n 60 --no-pager
```

`active (running)`과 함께 현재 실행의 `Tomcat started on port 8081`, `Started JayBoardAdminApplication` 로그를 확인합니다. 이후 관리자 로그인, 라이브형 선택 및 게시판 생성 동작을 확인합니다.

사용자 화면의 WebSocket 연결은 사용자 애플리케이션의 Nginx 설정에서 처리합니다. 관리자 애플리케이션은 게시판 유형을 관리하며, WebSocket 알림을 직접 제공하지 않습니다.

## 설계 원칙

- 관리자 계정은 일반 회원과 분리합니다.
- 게시판 유형 변경·삭제 시 일반 글뿐 아니라 라이브 글의 존재 여부도 검증합니다.
- 등급(MASTER / MANAGER / VIEWER)과 상태(ACTIVE / BLOCKED)에 따른 세부 접근 통제는 설계 기준으로 관리합니다.
- 메뉴 노출 여부와 무관한 서버 권한 검증을 지향합니다.
- 관리자 작업 이력의 변경 전후 값 기록은 운영 로그 확장 계획에 포함합니다.
