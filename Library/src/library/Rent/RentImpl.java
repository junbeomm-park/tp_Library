package library.Rent;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import library.book.BookDTO;
import library.book.BookImpl;
import library.main.FileUtil;





public class RentImpl implements Rent{
	FileUtil bookFileUtil = new FileUtil("bookInfoList");
	FileUtil reservationFileUtil = new FileUtil("reservationInfoList");
	BookImpl bookImpl = new BookImpl();
	
	//두 날짜 차이(반납일 - 대여일)
	@Override
	public int calDate(String reservationDate, String returnDate){
	    
	    int result = 0;
	    try { 
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	       
	        Date FirstDate = format.parse(reservationDate);
	        Date SecondDate = format.parse(returnDate);
	        
	        
	        long calDate = FirstDate.getTime() - SecondDate.getTime(); 
	        
	       
	        long calDateDays = calDate / ( 24*60*60*1000); 
	 
	        result = (int) Math.floor(calDateDays);
	        } catch(Exception e) {
	            
	        }
	    
	    return result;
	}    
	
	//도서 대여
	@Override
	public boolean bookReservation(int index, int rentDay, String id) {
		boolean result = false;
		List<BookDTO> bookInfoList = (List<BookDTO>) bookFileUtil.fileReader();
		RentDTO reservationDTO = new RentDTO();
		List<RentDTO> reservationInfoList = null;
		
		for(BookDTO bookInfo : bookInfoList) {
			if(bookInfo.getIndex() == index) {
				
				int bookAmount = bookInfo.getAmount() - 1;
				if(bookAmount == 0) {
					bookInfo.setIsAvailable(1); //대여 불가 상태로 변경
				}
				//남은 수량 변경
				bookInfo.setAmount(bookAmount);
		
				
				//도서 예약 파일에 추가
				reservationFileUtil.fileExists(); //파일 존재 여부 확인
				
				reservationInfoList = (List<RentDTO>) reservationFileUtil.fileReader();
				if(reservationInfoList == null) {
					reservationInfoList = new ArrayList<RentDTO>();
				}
				
				//예약 정보 추가
				reservationDTO.setReservationIndex(reservationInfoList.size() + 1);
				reservationDTO.setId(id);
				reservationDTO.setIndex(index);
				reservationDTO.setRentDay(rentDay);
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Calendar time = Calendar.getInstance();
				reservationDTO.setReservationDate(format.format(time.getTime()));
				
				reservationInfoList.add(reservationDTO);
				
				break;
			}
		}
		
		//파일 다시 저장
		result = bookFileUtil.fileWriter(bookInfoList);
		result = reservationFileUtil.fileWriter(reservationInfoList);
		return result;
	}
	
	//특정 회원의 대여한 도서 정보(id 하나)
	@Override
	public List<RentDTO> getReservationInfo(String id) {
		reservationFileUtil.fileExists();
		List<RentDTO> allUserReservationInfoList = (List<RentDTO>) reservationFileUtil.fileReader();
		List<RentDTO> reservationInfoList = new ArrayList<RentDTO>();
		
		if(allUserReservationInfoList == null) {
			return allUserReservationInfoList;
		}
		
		for(RentDTO reservationInfo: allUserReservationInfoList) {
			if(reservationInfo.getId().equals(id)) {
				reservationInfoList.add(reservationInfo);
			}
		}
		
		return reservationInfoList;
	}
	
	
	//도서 목록 프린트(id가 있는 경우 1명의 도서 목록, all인 경우 전체 도서 목록)
	@Override
	public void reservationInfoPrint(String id) {
		List<RentDTO> reservationInfoList = null;
		BookDTO bookDTO = null;
		
		if(id.equalsIgnoreCase("all")) { //전체 회원 대여 목록
			reservationInfoList = allUserReservationInfoList();
		}else { //한명 대여 목록
			reservationInfoList = getReservationInfo(id);
		}
		
		if(reservationInfoList == null) {
			System.out.println();
			System.out.println("       *** 대여한 도서가 존재하지 않습니다. ***       ");
			return;
		}
		
		System.out.println("\n도서번호\t\t도서명\t도서 대여 가격\t\t분류\t\t대여 날짜\t\t반납한 날짜\t\t연체료");
		System.out.println("===================================================================================================");
		for(RentDTO reservationInfo : reservationInfoList) {
			System.out.print(reservationInfo.getIndex() + "\t\t" );
			
			bookDTO = bookImpl.getBookInfo(reservationInfo.getIndex());
			if(bookDTO == null) {
				System.out.println();
				System.out.println("       *** 대여한 도서가 존재하지 않습니다. ***       ");
				return;
			}
			System.out.print(bookDTO.getB_name() + "\t\t" );
			System.out.print(bookDTO.getB_price()+ "\t\t");
			System.out.print(bookDTO.getCategory() + "\t\t" );
			System.out.print(reservationInfo.getReservationDate()+ "\t" );
			if(reservationInfo.getReturnDate() != null) {
				System.out.print(reservationInfo.getReturnDate() + "\t");
				System.out.print(reservationInfo.getLateFee()+"원");
				
			}else {
				System.out.print("");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	//반납해야 하는 도서 목록 프린트(id가 있는 경우 1명의 반납 도서 목록, all인 경우 전체 반납 도서 목록)
	@Override
	public void returnInfoPrint(String id) {
		List<RentDTO> reservationInfoList = null;
		BookDTO bookDTO = null;
		
		if(id.equalsIgnoreCase("all")) { //전체 회원 대여 목록
			reservationInfoList = allUserReservationInfoList();
		}else { //한명 대여 목록
			reservationInfoList = getReservationInfo(id);
		}
		
		if(reservationInfoList == null) {
			System.out.println();
			System.out.println("       *** 반납해야하는 도서가 존재하지 않습니다. ***       ");
			return;
		}
		
		int cnt = 1;
		System.out.println("\n도서번호\t\t도서명\t\t도서 대여 가격\t\t분류\t\t대여 날짜");
		System.out.println("===================================================================================================");
		for(RentDTO reservationInfo : reservationInfoList) {
			if(reservationInfo.getReturnDate() != null && reservationInfoList.size()==cnt) {
				System.out.println();
				System.out.println("       *** 반납해야하는 존재하지 않습니다. ***       ");
				return;
			}else if(reservationInfo.getReturnDate() != null) {
				++cnt;
				continue;
			}
			
			System.out.print(reservationInfo.getIndex() + "\t\t" );
			
			bookDTO = bookImpl.getBookInfo(reservationInfo.getIndex());
			
			System.out.print(bookDTO.getB_name() + "\t\t" );
			System.out.print((bookDTO.getB_price()*reservationInfo.getRentDay())+"\t\t\t");
			System.out.print(bookDTO.getCategory() + "\t\t" );
			System.out.print(reservationInfo.getReservationDate()+ "\t" );
			if(reservationInfo.getReturnDate() != null) {
				System.out.print(reservationInfo.getReturnDate() + "\t");
				System.out.print(reservationInfo.getLateFee()+"원");
				
			}else {
				System.out.print("");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	
	
	//전체 회원의 대여한 도서 목록 가져오기
	@Override
	public List<RentDTO> allUserReservationInfoList(){
		List<RentDTO> allUserReservationInfoList = (List<RentDTO>) reservationFileUtil.fileReader();

		return allUserReservationInfoList;
	}
	
	//========================================================
	// 도서 반납
	//========================================================
	@Override
	public int bookReturn(int index, String id) {
		int result = 1; //1. 도서 번호를 잘못 입력 2. 시스템 상의 오류로 반납 실패 3. 반납 성공
		int reservationIndex = 0;
		
		//특정 유저의 대여 리스트 가져오기
		List<RentDTO> reservationInfoList = getReservationInfo(id);
		//마지막에 전체 회원 reservation 파일 update
		List<RentDTO> allUserReservationInfoList = allUserReservationInfoList();
		//bookInfoList 파일 update
		List<BookDTO> bookInfoList = bookImpl.getBookInfoList();
		
		for(RentDTO reservationDTO : reservationInfoList) {
			if(reservationDTO.getIndex() == index && reservationDTO.getReturnDate() == null) {
				result = 2;
				reservationIndex = reservationDTO.getReservationIndex();
				break;
			}else if(reservationDTO.getIndex() == index && reservationDTO.getReturnDate() != null){
				return result;
			}
		}
		
		if(result == 1) {
			return result;
		}
		
		for(RentDTO reservationInfo : allUserReservationInfoList) {
			if(reservationInfo.getReservationIndex() == reservationIndex) {
				
				//1. reservationInfoList에 도서 반납 날짜 찍기
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Calendar time = Calendar.getInstance();
				reservationInfo.setReturnDate(format.format(time.getTime()));
				
				BookDTO savaBookInfo = new BookDTO();
				//2. 책 정보에 도서 수량 변경
				for(BookDTO bookInfo : bookInfoList) {
					if(bookInfo.getIndex() == index) {
						savaBookInfo = bookInfo;
						int bookAmount = bookInfo.getAmount();
						bookInfo.setAmount(bookAmount + 1);
						
						//3. 책 정보에서 대여 상태 변경 (만약 원래 대여불가였다면 대여 가능으로)
						if(bookAmount == 0) {
							bookInfo.setIsAvailable(0);
						}
						break;
					}
				}
				
				//4. 대여 날짜랑 반납 날짜랑 비교해서 연체되었는지 확인
				int calDateDays = calDate(reservationInfo.getReservationDate(), reservationInfo.getReturnDate());
				if(calDateDays < -reservationInfo.getRentDay()) {
					int lateFee = (Math.abs(calDateDays) - reservationInfo.getRentDay()) * 200; 
					reservationInfo.setLateFee(lateFee);
					
				}else {
					reservationInfo.setLateFee(0);
				}
				
				result = 3;
				break;
			}
			
			
		}
		
		if (result == 3) {
			// 도서 정보 저장
			boolean result1 = bookFileUtil.fileWriter(bookInfoList);
			
			// 예약 내역 저장
			boolean result2 = reservationFileUtil.fileWriter(allUserReservationInfoList);
			if(! result1 && ! result2) {
				result = 2;
			}
		}
		return result;
		
	}
	
	
}
