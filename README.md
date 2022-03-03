

# 📘 도서 대여 프로그램 (Java OOP) 📗





##  ✏ 개발 목적



디테일한 시스템 개발 구현 목적이 아닌, KOSTA에서 주관하는 Spring 기반 Cloud 서비스 개발자 양성 과정 수료 중  Java 객체 지향 프로그래밍(OOP) 에 대해 공부 및 복습 하기 위해 개발 하였습니다.  



## 📆 개발 기간 

22/ 02/ 14 ~ 22/ 03/ 03

평일에 강의를 병행 하면서 1 ~ 2시간씩 코딩 했으며, 주말엔 3 ~ 4 시간씩 진행 했습니다. 



## 🖥 개발 환경

- IDE : Eclipse 2020-09 (4.17.0)
- PL(Programming Language) : JDK 11.0.11 
- etc : Git, diagrams.net





##  😀 UseCase

![usecase](C:\Toy_Project\tp_Library\readme_img\usecase.PNG)



## 📉 Class Diagram



![클래스 다이어그램](C:\Toy_Project\tp_Library\readme_img\클래스 다이어그램.PNG)



## 👨‍💻 도서 대여 프로그램 Info



#### Packaging



![패키징](C:\Toy_Project\tp_Library\readme_img\패키징.PNG)



#### 시작 화면



![시작](C:\Toy_Project\tp_Library\readme_img\시작.PNG)

#### 사용자





![회원가입](C:\Toy_Project\tp_Library\readme_img\회원가입.PNG)



이메일에 정규표현식(Regular expression)을 적용하여 정의한 형식에 맞지 않으면, 다시 재입력을 하게 구현 했습니다.





![회원가입2](C:\Toy_Project\tp_Library\readme_img\회원가입2.PNG)



비밀번호 재입력을 요구 하고 동일 비밀번호를 입력시 회원가입이 완료 됩니다.







![회원정보 리스트](C:\Toy_Project\tp_Library\readme_img\회원정보 리스트.PNG)

DB없이 Java 로만 구현하는것이 목적이기에 직렬화(Serializable)를 사용하여 회원가입한 정보를 파일로 저장을 했습니다.







![사용자 도서 대여](C:\Toy_Project\tp_Library\readme_img\사용자 도서 대여.PNG)



사용자가 로그인후 도서 전체 보기 검색후 대여 하는 상황입니다. 이때 도서 번호와 대여일을 입력해서 마이페이지에서 대여 내역을 확인을 할 수 있습니다.



![캡처](C:\Toy_Project\tp_Library\readme_img\캡처.PNG)



마이페이지 에서 개인정보, 비밀번호 변경, 대여한 도서 목록을 볼 수 있습니다.

개인정보는 회원가입시 등록한 일부 정보를 확인 할 수 있습니다.





![비밀번호 변경](C:\Toy_Project\tp_Library\readme_img\비밀번호 변경.PNG)



비밀번호 변경에 성공한 화면 입니다.



![대여 도서 목록](C:\Toy_Project\tp_Library\readme_img\대여 도서 목록.PNG)

대여한 도서 목록 입니다.

도서 정보와 대여 날짜, 반납한 날짜, 연체료 등을 확인 할 수 있습니다.





![도서 반납](C:\Toy_Project\tp_Library\readme_img\도서 반납.PNG)



![반납 후 마이페이지](C:\Toy_Project\tp_Library\readme_img\반납 후 마이페이지.PNG)



대여한 도서를 반납 후 마이페이지에서 대여 도서 목록을 확인 하면 반납한 날짜와 연체료를 확인 할 수 있습니다.

연체료는 대여시 입력한 대여일 이후 일당 200원씩 책정 되게 코딩 하였습니다.







![연체료](C:\Toy_Project\tp_Library\readme_img\연체료.PNG)



연체료가 책정된 화면 입니다.





## 관리자







![관리자 로그인](C:\Toy_Project\tp_Library\readme_img\관리자 로그인.PNG)



``admin`` 으로 로그인시 관리자 화면으로 이동 하며 도서 목록 보기, 도서 추가,삭제,검색 등을 할 수 있습니다.





![관리자 도서 목록](C:\Toy_Project\tp_Library\readme_img\관리자 도서 목록.PNG)

저장된 도서 목록을 볼 수 있으며 바로 삭제 할 수 있습니다.





![도서 추가](C:\Toy_Project\tp_Library\readme_img\도서 추가.PNG)



![책정보 리스트](C:\Toy_Project\tp_Library\readme_img\책정보 리스트.PNG)



도서도 회원과 마찬가지로 직렬화(Serializable)를 사용하여 파일로 저장 했습니다.





![도서 검색](C:\Toy_Project\tp_Library\readme_img\도서 검색.PNG)



![도서 검색2](C:\Toy_Project\tp_Library\readme_img\도서 검색2.PNG)



도서 검색 시 도서명 또는 카테고리로 조회 할 수 있습니다.





## 🕵️‍♀️ 자문자답



Q. 개발 하게 된 계기 ?

A.  강의 만으로는 객체 지향 프로그래밍을 이해하기 어려운 부분이 많아, 직접 Usecase, Class Diagram 부터 설계하면서 객체 지향 프로그래밍에 이해하고 익숙해 지기 위해 시작 하게 되었습니다.



Q. 가장 어려웠던 부분 ?

A. 대여일자 및 반납일자 와 이를 계산 하여 연체료 청구 하는 기능을 구현 할 때 가장 어려웠습니다.



Q. 어떻게 해결 했는지 ?

A.  구글링을 통해 Java 내의 Calender 클래스를 활용하면 구현이 가능하다는 것을 깨달아 기술블로그와 자바의 정석 책을 참고 하면서 해결 했습니다.



Q. 느낀점 

A.  객체 지향 프로그래밍으로 인해 각 객체 간의 결합도를 낮추는 흐름은 익숙하나, Java 내의 API를 활용 하는 것이 아직 부족하다는 것을 느꼈습니다. Calender 클래스 또는 I.O 활용 등에 좀 더 익숙해질 필요가 있고 공부를 더 디테일하게 해야 될 것 같습니다.

