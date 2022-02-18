package hotel.reservation;

import java.util.Scanner;

import hotel.room.Room;



public class ReservationInfo implements ReservationService {
	Scanner sc = new Scanner(System.in);
	Reservation rv[] = new Reservation[10];
	int count = 0;
	
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
        for (int i = 0; i < room.length; i++) {
           if (room[i].getRoomGrade().equals(r2)) {
              rv[count++] = new Reservation(room[i].getRoomNo(),room[i].getRoomGrade(),room[i].getPrice(),name,people,days);
              
           }
        }
        
        
        
       
	}

	@Override
	public void cancle() {
		// TODO Auto-generated method stub

	}

	

}
