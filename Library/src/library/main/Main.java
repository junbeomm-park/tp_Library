package library.main;

import java.util.ArrayList;
import java.util.List;

import library.Rent.RentDTO;
import library.Rent.RentImpl;

public class Main {
	public static void main(String[] args) throws Exception{
		LibraryIndexView library = new LibraryIndexView();
		library.index();
		
		
//		FileUtil latefeeTest = new FileUtil("reservationInfoList");
//		RentImpl impl = new RentImpl();
//		List<RentDTO> test = impl.allUserReservationInfoList();
//		
//		if(test == null) {
//			test = new ArrayList<RentDTO>();
//		}
//		
//		RentDTO dto = new RentDTO();
//		dto.setReservationIndex(100);
//		dto.setId("123");
//		dto.setIndex(1);
//		dto.setReservationDate("2022-02-27");
//		test.add(dto);
//		
//		latefeeTest.fileWriter(test);
		
	}
}
