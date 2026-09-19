# Jay-Board-Admin

Jay-Board 게시판 서비스의 관리자 애플리케이션입니다.
사용자 서비스와 인증 주체가 달라 별도 프로젝트로 분리했습니다.

사용자 서비스 및 전체 설계 문서: https://github.com/Jaeho4913/Jay-Board

- [사용자 게시판](http://3.35.138.85/)
- [관리자 로그인](http://3.35.138.85:8081/admin/login)

## 기술 스택
- Java 17
- Spring Boot 3.5.8
- Spring Security
- MyBatis
- MariaDB
- JSP / jQuery

## 프로젝트를 분리한 이유

관리자 기능을 Jay-Board 안에 함께 두었을 때, SecurityConfig가 사용자 인증과
관리자 인증을 동시에 처리하면서 설정이 얽혔습니다.
AuthenticationProvider를 분리해 보았으나 유지보수 비용이 줄지 않아,
프로젝트 자체를 나누는 방향으로 결정했습니다.

관리자 계정은 일반 회원 테이블(members)과 분리된 tb_admin_member로 관리하며,
등급과 상태에 대한 상세 설계는 Jay-Board 저장소의 4장을 따릅니다.

## 개발 진행 현황

완료
- 관리자 로그인
- 관리자 홈
- 대시보드
- 회원 관리
- 카테고리 관리
  - 게시판 그룹 목록 조회, 생성 및 수정
  - 활성 상태 변경 및 게시글이 없는 게시판 그룹 삭제
  - 생성·수정 입력값 검증 및 존재하지 않는 게시판 그룹 예외 처리

진행 중
- 게시글 관리
- 댓글 관리

예정
- 통계
- 관리자 관리
- 운영 로그

## EC2 배포

- AWS EC2의 Ubuntu ARM64 환경에서 운영합니다.
- Java 17과 MariaDB를 사용합니다.
- 관리자 애플리케이션은 WAR 파일로 빌드하며, 서버의 `/opt/jay-board-admin/admin.war`에 배포합니다.
- 애플리케이션 설정값은 `/etc/jay-board-admin.env`에서 환경 변수로 관리합니다.
- `jay-board-admin.service` systemd 서비스로 애플리케이션을 실행하고 재시작합니다.
- 배포 전 기존 WAR 파일을 백업한 뒤 새 파일로 교체하고, 서비스 상태와 관리자 로그인 화면을 확인합니다.
- 비밀번호와 같은 민감정보는 저장소에 포함하지 않습니다.

## 설계 원칙

- 관리자 계정은 일반 회원과 분리합니다.
- 등급(MASTER / MANAGER / VIEWER)과 상태(ACTIVE / BLOCKED)로 접근을 통제합니다.
- 메뉴 노출 여부와 무관하게 서버에서 권한을 다시 검증합니다.
- 관리자 작업 이력은 변경 전후 값과 함께 기록합니다.
