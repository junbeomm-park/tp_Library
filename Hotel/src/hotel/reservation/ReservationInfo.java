package hotel.reservation;

import java.util.Scanner;

import hotel.room.Room;



public class ReservationInfo implements ReservationService {
	Scanner sc ;
	Reservation[] rv;
	int count ;
	
	public ReservationInfo() {
		rv = new Reservation[10];
		sc = new Scanner(System.in);
	}
	@Override
	public void show() {
		System.out.print("예약자 이름 입력하세요 : ");
		String name = sc.nextLine();
		for(int i = 0; i < count; i++) {
			if(name.equals(rv[i].getName())) {
				rv[i].show();
			}
		}

	}

	@Override
	public void add(Room room[]) {
		System.out.println("예약하려는 방 선택 1.Twin room(2명이하), 2.Triple room(3명이하), 3.Suite room(4명이상)");
        System.out.print("선택 : ");
        String r = sc.nextLine();
        String r2 = "";
        switch (r) {
        case "1":
           r2 = "Twin room";
           break;
        case "2":
           r2 = "Triple room";
           break;
        case "3":
           r2 = "Suite room";
           break;
        }
        System.out.print("예약자이름 : ");
        String name = sc.nextLine();
        System.out.print("인원수 : ");
        int people = sc.nextInt();
        System.out.print("숙박일 : ");
        int days = sc.nextInt();
        sc.nextLine();
        int resernum = (int)(Math.random()*1000)+1;
        System.out.println("예약번호가 발급 되었습니다. "+resernum);
        for (int i = 0; i < room.length; i++) {
           if (room[i].getRoomGrade().equals(r2)) {
              rv[count++] = new Reservation(room[i].getRoomNo(),room[i].getRoomGrade(),room[i].getPrice(),name,people,days,resernum);
              
           }
        }
       
	}

	@Override
	public void cancle() {
		System.out.print("예약자 이름을 입력하세요 : ");
		String name = sc.nextLine();
		for(int i = 0; i < count; i++) {
			if(rv[i].getName().equals(name)) {
				System.out.println("예약취소 완료");
				for(int j = i; j < count-1; j++) {
					rv[j] = rv[j+1];
				}
				count--;
			}
		}
	}

	

}
