package library.manage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import library.book.BookDTO;
import library.book.BookImpl;
import library.main.FileUtil;
import library.member.MemberDTO;
import library.member.MemberImpl;





public class ManageImpl implements Manage{
	MemberImpl memImpl = new MemberImpl();
	BookImpl bookImpl = new BookImpl();
	FileUtil bookFile = new FileUtil("bookInfoList");
	
	//관리자 로그인
	@Override
	public int managerLoginCheck(String id, String pw) {
		int result = 0;
		if(id.equals("admin")) {
			if(pw.equals("admin")) {
				result = 1;
			}else {
				result = 2;
			}
			
		}else { //아이디가 존재하지 않음
			result = 3;
		}
		return result;
	}
	
	
	//회원정보 출력
	@Override
	public void memInfoListPrint() {
		List<MemberDTO> meminfoList = new ArrayList<MemberDTO>();
		
		meminfoList = memImpl.getMemInfoList();
		
		
		System.out.println("번호\t아이디\t이름\t\t\t이메일");
		if(meminfoList == null) {
			System.out.println();
			System.out.println("       *** 회원 정보가 존재하지 않습니다. ***       ");
			return;
		}
		
		int no = 1;
		for(MemberDTO memInfo : meminfoList) {
			System.out.print(no++ + "\t");
			System.out.print(memInfo.getId() + "\t\t");
			System.out.print(memInfo.getName() + "\t");
			System.out.print(memInfo.getEmail() + "\t");
		}
		System.out.println();
	}
	
	//도서 정보 추가
	@Override
	public boolean bookInfoAdd(int index, String b_name, int b_price, String category,  int amount) {
		boolean result = false;
		List<BookDTO> bookInfoList = null;
		BookDTO bookDTO = new BookDTO();
		
		//전체 도서 리스트 가져와서 새로운 도서 정보 리스트에 add
		bookInfoList = bookImpl.getBookInfoList();
		if(bookInfoList == null) {
			bookInfoList = new ArrayList<BookDTO>();
		}
		
		bookDTO.setIndex(index);
		bookDTO.setB_name(b_name);
		bookDTO.setCategory(category);
		bookDTO.setIsAvailable(0);
		bookDTO.setB_price(b_price);
		bookDTO.setAmount(amount);
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar time = Calendar.getInstance();
		bookDTO.setRegisterDate(format.format(time.getTime()));
		
		bookInfoList.add(bookDTO);
		
		//도서 리스트 파일 update
		result = bookFile.fileWriter(bookInfoList);
		
		return result ;
	}
	
	//책 삭제
	@Override
	public boolean bookInfoDelete(int index) {
		boolean result = false;
		
		//전체 도서 리스트
		List<BookDTO> bookInfoList = bookImpl.getBookInfoList();
		
		for(BookDTO bookInfo : bookInfoList) {
			if(bookInfo.getIndex() == index) {
				bookInfoList.remove(bookInfo);
				result = bookFile.fileWriter(bookInfoList);
				break;
			}
		}
		
		//도서 리스트 파일 update
		
		
		return result ;
	}
	
	
	
}
