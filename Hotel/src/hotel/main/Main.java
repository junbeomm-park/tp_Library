package hotel.main;

import java.util.Scanner;

import hotel.reservation.ReservationInfo;
import hotel.room.Room;
import hotel.room.RoomInformation;
import hotel.user.User;
import hotel.user.UserInformation;

public class Main {
	
	
//	public static void roomAdd() {
//		Room[] room = {
//				 new Room("1","Twin room",10),
//			     new Room("2","Triple room",20),
//			     new Room("3","Suite room",40)
//			};
//	}

	public static void main(String[] args) {
		UserInformation u = new UserInformation();
		Main m = new Main();
		Scanner sc = new Scanner(System.in);
		
		User[] ua = new User[10];
		
		
		while(true) {
			System.out.println("===============3조 호텔 예약시스템=========");
			System.out.println("1. 회원가입  2. 로그인");
			System.out.print("선택 : ");
			String menu = sc.nextLine();
			
			switch (menu) {
			case "1":
			
				
				
				u.sign();
				break;

			case "2":
				int loginCheck = 0;
				do {
					
					loginCheck = u.login();
					
					switch (loginCheck) {
					case 1:
						m.loginView();
						break;
					case 2:
						System.out.println("비밀번호를 다시 입력하세요");
						break;
					case 3:
						System.out.println("등록된 회원이 아닙니다");
						break;

					
					}
					
				} while (loginCheck != 1);
				
				break;
			}
		}
		
	}
	
	public void loginView() {
		Room[] room = {
				 new Room("1","Twin room",50000,2),
			     new Room("2","Triple room",70000,3),
			     new Room("3","Suite room",100000,5)
			};
		RoomInformation roomlist = new RoomInformation();
		ReservationInfo rv = new ReservationInfo();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. 객실조회  2.예약  3.예약조회  4.예약취소  5.마이페이지");
			System.out.print("선택 : ");
			String menu = sc.nextLine();
			
			switch (menu) {
			case "1":
				roomlist.show(room);
				break;
			case "2":
				rv.add(room);
				
				break;
			case "3":
				
				rv.show();
				break;
			case "4":
				
				break;
			case "5":
				
				break;

		}
		
		
		}
		
		
	}
}
