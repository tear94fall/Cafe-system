<!-- PROJECT LOGO -->
<br />
<div align="center">
  <img src="./images/modu_cafe_icon.png" alt="Logo" width="100" height="100">
  <h3 align="center">Modu-Cafe</h3>

  <p align="center">
    모두의 카페 프로젝트의 통합 저장소 입니다.<br>
    개발 내용에 관한 내용은 아래의 문서에서 확인 가능합니다.<br>
    <a href="./android/ModuCafe/README.md"><strong>안드로이드 문서</strong></a><br>
    <a href="./backend/ModuCafe/README.md"><strong>백엔드 문서</strong></a><br>
  </p>
</div>

---

## 프로젝트 구조

### 프로젝트 구성 요소

- 백엔드 서버
  - 회원, 상품, 주문 등을 저장하고 관리하는 역할
- 안드로이드 앱
  - 사용자 앱
    - 상품, 주문의 상태 변경을 불가
    - 주문을 제외한 나머지 데이터들을 조회 하는 기능 위주
  - 관리자 앱
    - 상품을 추가 하거나 상태 변경 가능, 주문의 상태를 변경 가능
    - 주문을 관리하고 회원이 주문한 상품을 회원에게 전달

### 프로젝트 구조도

---

## 모두의 카페 어플리케이션

---

## 주요 도메인 모델

### 앱 사용자 관련 도메인 모델 구조

![architecture](./images/domain_model.jpg)

---

## 브랜치 관리 전략

### 브랜치 종류

깃플로우를 사용하나, release 브랜치는 사용하지 않음  
작업시에 feature/<작업 내용> 으로 feature 브랜치 생성후 작업한뒤  
develop 브랜치에 풀리퀘스트 요청(아래의 커밋 컨벤션대로 작성)  
develop에서 개발이 완료된 기능 단위를 묶어서 master 브랜치로 풀리퀘스트 요청  

`feature` -> `develop` 의 풀리퀘스트 내용에는 커밋 컨벤션을 그대로 따라감  
`develop` -> `master` 의 풀리퀘스트 내용에는 아래와 같이 커밋 첫줄만 모아서 작성함  

`master` 에는 릴리즈가능한 버전 상태를 유지 (feature에서 master로의 풀리퀘스트 금지)  
`develop` 에는 개발중인 상태가 유지될수 있음 (때로는 기능이 제대로 작동하지 않을수 있음)  

master 에 풀리퀘스트 내용 작성 예시

```
Feat: "회원 dto에 프로필 아미지 추가" #21
Feat: "친구 이름에 공백 생기는 문제 수정" #22
Feat: "친구 찾기 실패 오류 메시지 추가" #23
```

---

## 커밋 컨벤션

### 커밋 작성

첫번째줄 - 태그 이름 작성 [Feat|Fix|Mod|Refactor|Docs|Test] 및 간랸한 내용 작성  
두번쨰줄 - 자세한 작업 내용 기록  
세번째줄 - 수정시 해결 버전, 참조 버전, 관련 버전 (버전은 깃허브 풀리퀘스트 넘버링)  

### 커밋 예시

```
Feat: "로그인 관련 api 추가"

회원 로그인 api 추가
  - oauth 기반 로그인 코드 추가
  - 로그인시 패스워드 암호화 처리 로직 추가

Resolves: #321
Ref: #456
Related to: #391, #312
```

---