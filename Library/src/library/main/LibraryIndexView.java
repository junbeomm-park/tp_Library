package library.main;

import java.util.Scanner;

import library.Rent.RentImpl;
import library.book.BookImpl;
import library.manage.ManageDTO;
import library.manage.ManageImpl;
import library.member.MemberDTO;
import library.member.MemberImpl;





public class LibraryIndexView {
	Scanner sc;
	MemberDTO memDTO ;
	ManageDTO manageDTO;
	
	public LibraryIndexView() {
		sc = new Scanner(System.in);
		memDTO = new MemberDTO();
		manageDTO = new ManageDTO();
	}
	
	//숫자 받기
	public int getNum(String str) {
		System.out.print(str);
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}
	
	//문자열 받기
	public String getString(String str) {
		System.out.print(str);
		String result = sc.nextLine();
		return result;
	}
	
	//============================================
	// index 화면
	//============================================
	public void index() {
		MemberImpl memImpl = new MemberImpl();
		//전체 회원정보 가져오기
		
		System.out.println("[[ 도서 대여 프로그램에 오신 것을 환영합니다. ]] \n");
		System.out.println("1. 회원 로그인");
		System.out.println("2. 회원 가입");
		System.out.println("3. 관리자 로그인");
		int num = getNum("\n메뉴를 선택하세요 : ");
		
		
		String id = "";
		String pass = "";
		
		switch (num) {
		case 1: //로그인
			System.out.println("\n[[ 로그인 ]] \n");
			int loginCheck = 0;
			do {
				id = getString("\n아이디를 입력하세요 : ");
				pass = getString("비밀번호를 입력하세요 : ");
				loginCheck = memImpl.login(id, pass);
				
				switch (loginCheck) {
				case 1: //로그인 성공
					System.out.println("\n로그인 되었습니다.");
					MemberDTO dto = memImpl.getMemInfo(id);
					memDTO.setName(dto.getName());
					memDTO.setEmail(dto.getEmail());
					memDTO.setId(dto.getId());
					memDTO.setPass(dto.getPass());
					memDTO.setAddress(dto.getAddress());
					memDTO.setPhone_num(dto.getPhone_num());
					
					main();
					break;
					
				case 2: 
					System.out.println("\n아이디와 비밀번호가 일치하지 않습니다.");
					break;
	
				default:
					System.out.println("\n아이디가 존재하지 않습니다.");
					break;
				}
			} while(loginCheck != 1);
			
			break;
			
		case 2: //회원 가입
			System.out.println("\n[[ 회원가입 ]] \n");
			
			//파일 존재여부 확인
			memImpl.fileExists(); //파일 없다면 생성
			
			String name = getString("이름을 입력하세요 : "); 
			
			boolean isValidEmail = false; //이메일 형식 확인
			boolean emailCheckBool = false; //이메일 중복 확인
			boolean idCheckBool = false; //아이디 중복 확인
			
			do {
				String email = getString("\n이메일을 입력하세요 : "); 
				
				//*****이메일***** 
				//유효성 검사
				isValidEmail = memImpl.isValidEmail(email); //형식 확인
				emailCheckBool = memImpl.emailCheck(email); //중복 아닌지 확인
				
				if(isValidEmail && emailCheckBool) { //이메일 유효성 검사 통과
					
					//*****아이디*****
					id = getString("\n아이디를 입력하세요 : "); 
					idCheckBool = memImpl.idCheck(id);
					if( !idCheckBool ) {
						do {
							id = getString("\n이미 존재하는 아이디입니다. 다시 입력해주세요. : ");
							idCheckBool = memImpl.idCheck(id);
						}while(!idCheckBool) ;
					}
					
					//*****비밀번호*****
					
					boolean confirmPW = false;
					pass = getString("비밀번호를 입력하세요 : ");
						do {
						String repass = getString("동일한 비밀번호를 한 번 더 입력해주세요 : ");
						confirmPW = memImpl.confirmPW(pass, repass);
						if(confirmPW) {
							System.out.println("\n비밀번호가 일치합니다.");
						}else {
							System.out.println("\n비밀번호가 일치하지 않습니다.");
						}
					}while(! confirmPW);
					String address = getString("주소를 입력 하세요 : ") ;
					String phone_num = getString("핸드폰 번호를 입력 하세요 : ");
					
					memDTO.setName(name);
					memDTO.setEmail(email);
					memDTO.setId(id);
					
					boolean result = memImpl.memInfoWrite(id, pass, name, address, email, phone_num); //회원정보 파일에 저장
					
					if(result) {
						System.out.println("\n **회원가입 완료!!**");
						//회원가입 성공 시 main 페이지로 이동
						main();
					}
					
				
				}else if(! isValidEmail){
					System.out.println("\n잘못된 이메일 형식입니다. 다시 입력해주세요. ");
				}else if(! emailCheckBool) {
					System.out.println("\n이미 존재하는 이메일입니다. 다시 입력해주세요. ");
				}
			} while (!isValidEmail || ! emailCheckBool);
				
			break;
			
		case 3:  //관리자 화면
			//관리자 로그인
			ManageImpl manageImpl = new ManageImpl();
			int managerLoginCheck = 0;
			do {
				String managerId = getString("\n아이디를 입력하세요 : ");
				String managerPw = getString("비밀번호를 입력하세요 : ");
				managerLoginCheck = manageImpl.managerLoginCheck(managerId, managerPw);
				
				switch (managerLoginCheck) {
				case 1: //로그인 성공
					System.out.println("\n로그인 되었습니다.");
					manage();
					break;
					
				case 2: 
					System.out.println("\n아이디와 비밀번호가 일치하지 않습니다.");
					break;
	
				default:
					System.out.println("\n아이디가 존재하지 않습니다.");
					break;
				}
			} while(managerLoginCheck != 1);
			
			break;
			
		default :
			System.out.println("\n메뉴를 제대로 선택해줘...\n");
			index();
		}
	}
	
	
	
	
	
	//============================================
	// 회원 메인 화면
	//============================================
	public void main() {
		BookImpl bookImpl = new BookImpl();
		MemberImpl memImpl = new MemberImpl();
		RentImpl reservationImpl = new RentImpl();
		
		
		System.out.println("\n[[ 안녕하세요. " + memDTO.getName() + "님 반갑습니다. ]]");
		System.out.println("\n1. 도서 전체 보기");
		System.out.println("2. 도서 검색 ");
		System.out.println("3. 도서 반납");
		System.out.println("4. 마이페이지");
		System.out.println("5. 로그아웃");
		int num = getNum("\n메뉴를 선택하세요 : ");
		
		switch (num) {
		case 1: //도서 전체 보기
			System.out.println("==============================================================");
			System.out.println("                           전체 도서 리스트");
			System.out.println("==============================================================");
			bookImpl.bookInfoPrint(0);
			
			reservation();
			
			main();
			break;
			
		case 2: //도서 검색
			System.out.println("==============================================================");
			System.out.println("                           도서 검색");
			System.out.println("==============================================================");
			String keyword = getString("도서명을 입력해주세요. : ") ;
			bookImpl.selectBookListPrint(keyword);
			
			reservation();
			
			main();
			break;
			
		case 3: //도서 반납
			reservationImpl.returnInfoPrint(memDTO.getId());
			int returnResult = 0;
			do {
				int returnBookId = getNum("\n반납할 도서 번호를 입력해주세요(메인 화면으로 돌아가시려면 -1을 입력해주세요) : ");
				if(returnBookId == -1) { 
					main();
					break;
				}
				
				returnResult = reservationImpl.bookReturn(returnBookId, memDTO.getId());
				if(returnResult == 3) {
					System.out.println("반납이 완료되었습니다.");
				}else if(returnResult == 2){
					System.out.println("시스템 상의 오류로 반납에 실패하였습니다. 다시 한 번 시도해주세요.");
				}else if(returnResult ==1){
					System.out.println("도서 번호를 잘못입력하셨습니다.");
					
				}
			} while(returnResult != 3);
			main();
			break;
			
		case 4: //마이페이지
			System.out.println("\n1. 개인정보");
			System.out.println("2. 비밀번호 변경");
			System.out.println("3. 대여 도서 목록");
			int mypageMenuSelect = getNum("\n메뉴를 선택하세요 : ");
			
			switch (mypageMenuSelect) {
			case 1: //개인정보
				
				memImpl.myInfoPrint(memDTO.getId());
				main();
				break;
				
			case 2: //비번 번경
				int idPwCheck = 0;
				
				do {
					String pw = getString("\n비밀번호를 입력하세요 : ");
					idPwCheck = memImpl.login(memDTO.getId(), pw);
					
					if(idPwCheck == 2) {
						System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
					}
					
				} while(idPwCheck != 1);
				
				//비밀번호 재확인
				boolean confirmPW = false;
				String updatePW = getString("\n변경할 비밀번호를 입력하세요 : ");
				
					do {
						
					String repw = getString("\n변경할 비밀번호를 한 번 더 입력해주세요 : ");
					confirmPW = memImpl.confirmPW(updatePW, repw);
					
					if(confirmPW) {
						boolean updatePwCheck = memImpl.updatePW(memDTO.getId(), updatePW);

						if(updatePwCheck) {
							System.out.println("\n!!!!!!!비밀번호 변경 완료!!!!!!!");
						}
						else {
							System.out.println("\n비밀번호 변경에 실패하였습니다.");
							main();
						}
						
					}else {
						System.out.println("\n비밀번호가 일치하지 않습니다. T-T");
					}
				}while(! confirmPW);
				
				main();
				break;
			case 3: //대여 도서 목록
				reservationImpl.reservationInfoPrint(memDTO.getId());
				main();
				break;
			
			
			default:
				System.out.println("잘못 선택하셨습니다. 메인 화면으로 이동하겠습니다.");
				main();
				break;
			}
			
			break;
			
		case 5: //로그아웃
			String answer = getString("로그아웃 하시겠습니까???(Y or N 입력) ");
			if(answer.equalsIgnoreCase("Y")) {
				memDTO.setId(null);
				memDTO.setPass(null);
				memDTO.setName(null);
				memDTO.setAddress(null);
				memDTO.setEmail(null);
				memDTO.setPhone_num(null);
				index();
			}else {
				main();
			}

			break;
			
		default:
			System.out.println("\n제대로 입력해주세요!!!");
			main();
			break;
		}
		
	}
	
	
	
	
	
	//============================================
	// 도서 예약 화면 
	//============================================
	public void reservation() {
		boolean reservationCheck = false;
		do {
			String answer = getString("\n도서를 대여하시겠습니까????( Y / N ) : ");
			
			if(answer.equals("Y") || answer.equals("y")) {
				reservationCheck = true;
				
			}else if(answer.equals("N") || answer.equals("n")) {
				main();
				
			}else {
				System.out.println("Y 또는 N을 입력해주세요 ! ");
			}
		} while(! reservationCheck);
		
		RentImpl reservationImple = new RentImpl();
		int bookIndex = getNum("대여할 도서 번호를 입력해주세요 : ");
		int rentDay = getNum("대여일 입력하세요 : ");
		boolean reservationResult = reservationImple.bookReservation(bookIndex, rentDay, memDTO.getId());
		
		
		if(reservationResult) {
			System.out.println("\n!!!대여가 완료되었습니다. 마이페이지에서 확인해주세요.!!!");
		}
		
	}
	
	//============================================
	//관리자 화면
	//============================================
	public void manage() {
		ManageImpl manageImpl = new ManageImpl();
		BookImpl bookImpl = new BookImpl();
		bookImpl.bookFileExists();
		
		System.out.println("\n[[ 안녕하세요. 관리자 화면입니다. ]]");
		System.out.println("\n1. 전체 도서 정보 보기");
		System.out.println("2. 도서 추가");
		System.out.println("3. 도서 삭제");
		System.out.println("4. 도서 검색");
		System.out.println("5. 로그아웃");
		int num = getNum("\n메뉴를 선택하세요 : ");
		
		switch (num) {
		case 1: 
			System.out.println("==============================================================");
			System.out.println("                           전체 도서 리스트");
			System.out.println("==============================================================");
			bookImpl.bookInfoPrint(0);
			System.out.println();
			int anw = getNum("원하는 메뉴를 입력해주세요. (1. 도서 삭제하기 2. 메인 화면으로 이동) : ");
			do {
				if(anw == 1) {
					boolDelete();
				}
				else if(anw == 2) {
					manage();				
				}else {
					System.out.println("제대로 입력해주세요..!");
				}
			}while(anw < 1 || anw > 3);
			
			break;
			
		case 2: 
			System.out.println("==============================================================");
			System.out.println("                           도서 정보 추가");
			System.out.println("==============================================================");
			
			int index = getNum("도서 번호를 입력하세요. : ");
			String b_name = getString("도서 이름을 입력하세요. : ");
			int b_price = getNum("도서 가격을 입력하세요. : ");
			String category = getString("도서의 카테고리를 입력하세요. : ");
			int amount = getNum("도서의 수량을 입력하세요. : ");
			
			boolean bookAddResult = manageImpl.bookInfoAdd(index, b_name, b_price, category, amount);
			
			if(bookAddResult) {
				System.out.println("\n도서 추가 완료");
			}
			manage();
			break;
		case 3:
			System.out.println("==============================================================");
			System.out.println("                           도서 삭제");
			System.out.println("==============================================================");
			bookImpl.bookInfoPrint(0);
			boolDelete();
			break;
		case 4: //도서 검색
			System.out.println("==============================================================");
			System.out.println("                           도서 검색");
			System.out.println("==============================================================\n\n");
			String keyword = getString("도서명을 입력해주세요. : ") ;
			bookImpl.selectBookListPrint(keyword);
			manage();
			break;
		case 5: //로그아웃
			String answer = getString("로그아웃 하시겠습니까???(Y or N 입력) ");
			if(answer.equalsIgnoreCase("Y"))
				index();
			manage();
		default:
			System.out.println("\n제대로 입력해주세요!!!");
			manage();
			break;
		}
		
	}
	
	//도서 삭제
	public void boolDelete() {
		ManageImpl manageimpl = new ManageImpl();
		
		int deleteIndex = getNum("\n삭제할 도서의 번호를 입력해주세요 : ");
		boolean result = manageimpl.bookInfoDelete(deleteIndex);
		if(result) {
			System.out.println("*****성공적으로 도서가 삭제되었습니다*****");
		}else {
			System.out.println("*****도서 번호를 잘못 입력하셨거나 삭제 중 오류가 발생했습니다****");
		}
		manage();
	}
	
	
}//class
