package hotel.reservation;

import hotel.room.Room;
import hotel.room.RoomService;
import hotel.user.UserSevice;

public interface ReservationService {
	public void show();
	public void add(Room room[]);
	public void cancle();
}
