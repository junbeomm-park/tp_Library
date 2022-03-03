

# 📘 도서 대여 프로그램 (Java OOP) 📗

<br>
<br>
<br>



##  ✏ 개발 목적



디테일한 시스템 개발 구현 목적이 아닌, KOSTA에서 주관하는 Spring 기반 Cloud 서비스 개발자 양성 과정 수료 중  Java 객체 지향 프로그래밍(OOP) 에 대해 공부 및 복습 하기 위해 개발 하였습니다.  
<br>
<br>
<br>



## 📆 개발 기간 

22/ 02/ 14 ~ 22/ 03/ 03

평일에 강의를 병행 하면서 1 ~ 2시간씩 코딩 했으며, 주말엔 3 ~ 4 시간씩 진행 했습니다. 

<br>
<br>
<br>


## 🖥 개발 환경

- IDE : Eclipse 2020-09 (4.17.0)
- PL(Programming Language) : JDK 11.0.11 
- etc : Git, diagrams.net

<br>
<br>
<br>




##  😀 UseCase

![usecase](https://user-images.githubusercontent.com/88473491/156572497-6206e794-799c-4286-b2de-69ad2386a70f.PNG)

<br>
<br>
<br>


## 📉 Class Diagram



![클래스 다이어그램](https://user-images.githubusercontent.com/88473491/156572658-8b2e83ba-c0e8-461c-a494-fe9fcf60386e.PNG)

<br>
<br>
<br>


## 👨‍💻 도서 대여 프로그램 Info



#### Packaging



![패키징](https://user-images.githubusercontent.com/88473491/156572766-c0221502-60e3-45bd-a9d5-236e4430e8d0.PNG)

<br>
<br>
<br>


#### 시작 화면



![시작](https://user-images.githubusercontent.com/88473491/156572806-eced9ea5-49d6-4d41-b606-983aafc55fd9.PNG)

<br>
<br>
<br>

#### 사용자





![회원가입](https://user-images.githubusercontent.com/88473491/156572833-f34e2c59-0433-484f-96cc-4248c2e5eefd.PNG)



이메일에 정규표현식(Regular expression)을 적용하여 정의한 형식에 맞지 않으면, 다시 재입력을 하게 구현 했습니다.
https://github.com/junbeomm-park/tp_Library/blob/be826d379ba3a2db41ce6dd50cf4105caa27be1b/Library/src/library/member/MemberImpl.java#L33-L44


<br>
<br>
<br>


![회원가입2](https://user-images.githubusercontent.com/88473491/156572846-e40d367d-e40a-4e99-9daf-cd425f9c24d4.PNG)



비밀번호 재입력을 요구 하고 동일 비밀번호를 입력시 회원가입이 완료 됩니다.
https://github.com/junbeomm-park/tp_Library/blob/be826d379ba3a2db41ce6dd50cf4105caa27be1b/Library/src/library/member/MemberImpl.java#L83-L91



<br>
<br>
<br>


![회원정보 리스트](https://user-images.githubusercontent.com/88473491/156572876-991919b4-f793-4b93-b31c-3b60ac93b971.PNG)

DB없이 Java 로만 구현하는것이 목적이기에 직렬화(Serializable)를 사용하여 회원가입한 정보를 파일로 저장을 했습니다.
https://github.com/junbeomm-park/tp_Library/blob/b4236c01d4b4911c8a43920b707a7cdd895c62a6/Library/src/library/main/FileUtil.java#L16-L98
https://github.com/junbeomm-park/tp_Library/blob/b4236c01d4b4911c8a43920b707a7cdd895c62a6/Library/src/library/member/MemberImpl.java#L93-L115





<br>
<br>
<br>


![사용자 도서 대여](https://user-images.githubusercontent.com/88473491/156573043-80944e3b-5bb2-447a-85b5-4c9d7335ccb1.PNG)



사용자가 로그인후 도서 전체 보기 검색후 대여 하는 상황입니다. 이때 도서 번호와 대여일을 입력해서 마이페이지에서 대여 내역을 확인을 할 수 있습니다.
https://github.com/junbeomm-park/tp_Library/blob/b4236c01d4b4911c8a43920b707a7cdd895c62a6/Library/src/library/Rent/RentImpl.java#L47-L94


<br>
<br>
<br>

![캡처](https://user-images.githubusercontent.com/88473491/156573064-3878ea79-89b3-466f-a185-a7a3695cf910.PNG)



마이페이지 에서 개인정보, 비밀번호 변경, 대여한 도서 목록을 볼 수 있습니다.

개인정보는 회원가입시 등록한 일부 정보를 확인 할 수 있습니다.




<br>
<br>
<br>

![비밀번호 변경](https://user-images.githubusercontent.com/88473491/156573087-4eafa606-8950-472a-b53a-050e90aa2ee9.PNG)



비밀번호 변경에 성공한 화면 입니다.
https://github.com/junbeomm-park/tp_Library/blob/b4236c01d4b4911c8a43920b707a7cdd895c62a6/Library/src/library/member/MemberImpl.java#L184-L198

<br>
<br>
<br>

![대여 도서 목록](https://user-images.githubusercontent.com/88473491/156573126-06a60a01-fad7-4427-9cf1-c10e79de1e72.PNG)

대여한 도서 목록 입니다.

도서 정보와 대여 날짜, 반납한 날짜, 연체료 등을 확인 할 수 있습니다.

https://github.com/junbeomm-park/tp_Library/blob/b4236c01d4b4911c8a43920b707a7cdd895c62a6/Library/src/library/Rent/RentImpl.java#L117-L212


<br>
<br>
<br>

![도서 반납](https://user-images.githubusercontent.com/88473491/156573262-9115d8be-abca-48c8-b89a-3f09cab23d4c.PNG)

https://github.com/junbeomm-park/tp_Library/blob/b4236c01d4b4911c8a43920b707a7cdd895c62a6/Library/src/library/Rent/RentImpl.java#L225-L307

![반납 후 마이페이지](https://user-images.githubusercontent.com/88473491/156573272-1f5145c7-66e8-4e80-85e3-2f08a3c60e00.PNG)



대여한 도서를 반납 후 마이페이지에서 대여 도서 목록을 확인 하면 반납한 날짜와 연체료를 확인 할 수 있습니다.

연체료는 대여시 입력한 대여일 이후 일당 200원씩 책정 되게 코딩 하였습니다.





<br>
<br>
<br>

![연체료](https://user-images.githubusercontent.com/88473491/156573309-f9923630-8c90-473c-a450-82c3e60afba1.PNG)



연체료가 책정된 화면 입니다.

https://github.com/junbeomm-park/tp_Library/blob/b4236c01d4b4911c8a43920b707a7cdd895c62a6/Library/src/library/Rent/RentImpl.java#L117-L212

<br>
<br>
<br>

#### 관리자







![관리자 로그인](https://user-images.githubusercontent.com/88473491/156573350-c2ad071c-b07e-40eb-b0ee-9be0f6229dfc.PNG)



``admin`` 으로 로그인시 관리자 화면으로 이동 하며 도서 목록 보기, 도서 추가,삭제,검색 등을 할 수 있습니다.
https://github.com/junbeomm-park/tp_Library/blob/3cd9d735b611563b7ca75e2db910a08935b2d192/Library/src/library/manage/ManageImpl.java#L23-L38


<br>
<br>
<br>


![관리자 도서 목록](https://user-images.githubusercontent.com/88473491/156573369-6129c0f4-d850-41e1-b2ca-7c3034185878.PNG)

저장된 도서 목록을 볼 수 있으며 바로 삭제 할 수 있습니다.
https://github.com/junbeomm-park/tp_Library/blob/3cd9d735b611563b7ca75e2db910a08935b2d192/Library/src/library/manage/ManageImpl.java#L99-L119



<br>
<br>
<br>

![도서 추가](https://user-images.githubusercontent.com/88473491/156573402-a6601d79-647c-4021-ac1b-5cc11f4656f2.PNG)

https://github.com/junbeomm-park/tp_Library/blob/3cd9d735b611563b7ca75e2db910a08935b2d192/Library/src/library/manage/ManageImpl.java#L66-L97

![책정보 리스트](https://user-images.githubusercontent.com/88473491/156573426-36f636ff-dec1-469f-830b-af5edbda7207.PNG)

https://github.com/junbeomm-park/tp_Library/blob/3cd9d735b611563b7ca75e2db910a08935b2d192/Library/src/library/book/BookImpl.java#L24-L32

도서도 회원과 마찬가지로 직렬화(Serializable)를 사용하여 파일로 저장 했습니다.



<br>
<br>
<br>

![도서 검색](https://user-images.githubusercontent.com/88473491/156573457-d8a5c3b7-81fa-4bc8-bed0-e8e0d686273f.PNG)



![도서 검색2](https://user-images.githubusercontent.com/88473491/156573475-f5c28f9b-56ff-4b2f-92b3-8fb1628ad431.PNG)



도서 검색 시 도서명 또는 카테고리로 조회 할 수 있습니다.


https://github.com/junbeomm-park/tp_Library/blob/3cd9d735b611563b7ca75e2db910a08935b2d192/Library/src/library/book/BookImpl.java#L94-L138


## 🕵️‍♀️ 자문자답



Q. 개발 하게 된 계기 ?

A.  강의 만으로는 객체 지향 프로그래밍을 이해하기 어려운 부분이 많아, 직접 Usecase, Class Diagram 부터 설계하면서 객체 지향 프로그래밍에 이해하고 익숙해 지기 위해 시작 하게 되었습니다.

<br>
<br>
<br>

Q. 가장 어려웠던 부분 ?

A. 대여일자 및 반납일자 와 이를 계산 하여 연체료 청구 하는 기능을 구현 할 때 가장 어려웠습니다.

<br>
<br>
<br>

Q. 어떻게 해결 했는지 ?

A.  구글링을 통해 Java 내의 Calender 클래스를 활용하면 구현이 가능하다는 것을 깨달아 기술블로그와 자바의 정석 책을 참고 하면서 해결 했습니다.
<br>
<br>
<br>


Q. 느낀점 

A.  객체 지향 프로그래밍으로 인해 각 객체 간의 결합도를 낮추는 흐름은 익숙하나, Java 내의 API를 활용 하는 것이 아직 부족하다는 것을 느꼈습니다. Calender 클래스 또는 I.O 활용 등에 좀 더 익숙해질 필요가 있고 공부를 더 디테일하게 해야 될 것 같습니다.

