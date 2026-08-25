# Jay-Board-Admin

Jay-Board 게시판 서비스의 관리자 애플리케이션입니다.
사용자 서비스와 인증 주체가 달라 별도 프로젝트로 분리했습니다.

사용자 서비스 및 전체 설계 문서: https://github.com/Jaeho4913/Jay-Board

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

진행 중
- 게시글 관리
- 댓글 관리

예정
- 카테고리 관리
- 통계
- 관리자 관리
- 운영 로그

## 설계 원칙

- 관리자 계정은 일반 회원과 분리합니다.
- 등급(MASTER / MANAGER / VIEWER)과 상태(ACTIVE / BLOCKED)로 접근을 통제합니다.
- 메뉴 노출 여부와 무관하게 서버에서 권한을 다시 검증합니다.
- 관리자 작업 이력은 변경 전후 값과 함께 기록합니다.
