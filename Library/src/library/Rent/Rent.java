package library.Rent;

import java.util.List;

public interface Rent {
	public int bookReturn(int index,  String id); //도서 반납
	public List<RentDTO> allUserReservationInfoList(); //모든 유저의 예약 내역
	public void returnInfoPrint(String id) ; //반납 정보 출력
	public void reservationInfoPrint(String id) ; //예약 정보 출력
	public List<RentDTO> getReservationInfo(String id); //해당 유저의 예약 정보
	public boolean bookReservation(int index, int rentDay, String id); //도서 대여
	public int calDate(String reservationDate, String returnDate); //날짜 차이 계산
}
