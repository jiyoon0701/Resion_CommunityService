# 지역 커뮤니티

## 🍀 소개
<aside>
같은 구에 거주하는 사람들끼리 각종 정보를 주고 받는 것을 목적으로 이 아이디어를 선택하게 되었습니다. 

회원가입 시 자신이 거주하는 지역을 선택하게 되면 그 지역의 커뮤니티 공간에만 접속이 가능합니다.

옛날과 달리 이웃 사이가 가깝지 않은데, 커뮤니티를 통해 이웃과 가깝게 지내보는건 어떨까요? 😊
</aside>

<br>

## 📌 시스템 아키텍처

![Group 6](https://user-images.githubusercontent.com/83527046/218445711-25ac3ff5-2ccb-43e2-9dbb-fc020391c235.png)

<br>

## 🔍 화면 소개

**회원가입**
<br>

<img src="https://user-images.githubusercontent.com/83527046/218446514-b9900477-1a9d-4ef3-8937-4ec1e9dacf1e.png">

- 회원가입 시 자신이 거주하는 구를 선택

<br>

**커뮤니티 글 작성 및 보기**

![localhost_8085_board_board_write_ residence=%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C residenceGu=%EC%A4%91%EA%B5%AC (1)](https://user-images.githubusercontent.com/83527046/218447583-04e05318-f93f-4ff6-ae37-bf61ac8a620e.png)|![Untitled5](https://user-images.githubusercontent.com/83527046/218447603-e5b7dd98-0f34-492b-a6f6-e75e2f5ac53c.png)
--- | --- |

<br>

**게시글 작성**
<br>

![localhost_8085_board_modify_num=4](https://user-images.githubusercontent.com/83527046/218448021-1976dcc7-cfd8-454c-8213-3768bc8539c4.png)

## 💻 담당한 기능

- DI 설정
- AspectJ 라이브러리를 이용한 Proxy 객체 생성 및 AOP 설정
- 사용자와 시스템 사이에 실수를 방지하기 위해 트랜잭션 적용
- 게시글 작성, 수정, 삭제 Controller와 Service Interface 구현
- 댓글 작성, 삭제 Controller와 Service Interface 구현
- 자동 매핑 기능을 위해 Mybatis를 사용하여 DB에 접근

