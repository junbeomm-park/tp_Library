package hotel.room;

public class RoomInformation implements RoomService {
	
	public RoomInformation() {
		
	}
	
	@Override
	public void show(Room room[]) {
		System.out.println("===========객실 목록===========");
		for(int i = 0; i < room.length; i++) {
			room[i].show();
		}
		System.out.println("===================");
	}

}
