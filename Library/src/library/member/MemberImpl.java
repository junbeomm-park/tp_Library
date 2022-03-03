package library.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import library.main.FileUtil;



public class MemberImpl implements Member{
	Random r = new Random();
	int ran = 0;
	FileUtil memFile = new FileUtil("memberInfoList");
	FileUtil reservationFile = new FileUtil("reservationInfoList");
	
	//=========================================
	//회원가입
	//=========================================o
	
	//멤버 파일 존재 여부 확인
	@Override
	public boolean fileExists() {
		boolean result = false;
		result = memFile.fileExists();
		
		return result ;
	}
	
	
	//이메일 형식 확인
	@Override
	public boolean isValidEmail(String email) {
		boolean bool = false;
		String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		if(m.matches()) {
			bool = true;
		}
		return bool;
	}
	
	
	//존재하지 않는 이메일인지 확인
	@Override
	public boolean emailCheck(String newEmail) {
		boolean result = true;
		List<MemberDTO> memInfoList = getMemInfoList();
		
		if(memInfoList == null) return result;
		
		for (MemberDTO memInfo : memInfoList) {
			if(memInfo.getEmail().equals(newEmail)) {
				result = false;
			}
		}
		
		return result;
	}

	
	//아이디 중복 확인
	@Override
	public boolean idCheck(String id) {
		boolean result = true;
		List<MemberDTO> memInfoList = new ArrayList<>();
		memInfoList = (List<MemberDTO>) memFile.fileReader();
		
		if(memInfoList == null) return result;
		
		for(MemberDTO memInfo : memInfoList) {
			if(memInfo.getId().equals(id)) {
				result = false;
			}
		}
		
		return result;
	}
	
	//비밀번호 재확인
	@Override
	public boolean confirmPW(String pw, String repw) {
		boolean result = false;
		if(pw.equals(repw)) 
			result = true;
		
		return result;
	}
	
	// 회원가입 시 회원 정보 파일에 쓰기
	@Override
	public boolean memInfoWrite(String id, String pass, String name, String address, String email, String phone_num) {
		boolean result = false;
		List<MemberDTO> memInfoList = (List<MemberDTO>) memFile.fileReader();
		MemberDTO memDTO = new MemberDTO();
		
//		memDTO.setName(name);
//		memDTO.setEmail(email);
//		memDTO.setId(id);
//		memDTO.setPw(pw);
//		memDTO.setGender(gender);
		
		memDTO.setId(id);
		memDTO.setPass(pass);
		memDTO.setName(name);
		memDTO.setAddress(address);
		memDTO.setEmail(email);
		memDTO.getPhone_num();
		
		
		if( memInfoList == null ) {
			memInfoList = new ArrayList<MemberDTO>();
		}
		memInfoList.add(memDTO);
		
		result = memFile.fileWriter(memInfoList);
		return result ; 
	}
	
	
	//=========================================
	// 로그인
	//=========================================
	//로그인
	@Override
	public int login(String id, String pw) {
		int result = 0; //아이디가 존재하지 않음
		
		List<MemberDTO> memInfoList = getMemInfoList();
		if(memInfoList == null) {
			result = 0;
			return result;
		}
		for(MemberDTO memInfo : memInfoList) {
			if(memInfo.getId().equals(id)) { //아이디가 존재
				if(memInfo.getPass().equals(pw)) {
					result = 1; //로그인 성공
				}else {
					result = 2; //아이디와 비밀번호가 일치하지 않음
				}
				
			}
		}
		return result;
	}
	

	//회원 정보 가져오기(한 명)
	@Override
	public MemberDTO getMemInfo(String id){
		List<MemberDTO> meminfoList = getMemInfoList();
		MemberDTO memInfo = new MemberDTO();
		
		for(MemberDTO info : meminfoList) {
			if (info.getId().equals(id) ) {
				memInfo = info;
			}
		}
		return memInfo;
	}

	//회원정보 전체 가져오기
	@Override
	public List<MemberDTO> getMemInfoList() {
		List<MemberDTO> memberinfoList = new ArrayList<MemberDTO>();
		memberinfoList = (List<MemberDTO>) memFile.fileReader();
		
		return memberinfoList;
	}
	
	//=========================================
	// 마이페이지
	//=========================================
	
	//개인정보
	@Override
	public void myInfoPrint(String id) {
		MemberDTO memInfo = getMemInfo(id);
		System.out.println("\n이름\t이메일\t\t\t아이디");
		System.out.println("=========================================================\n");
		System.out.print(memInfo.getName() + "\t");
		System.out.print(memInfo.getEmail() + "\t");
		System.out.print(memInfo.getId() + "\t\t");
		System.out.println();
	}
	
	//비밀번호 변경
	@Override
	public boolean updatePW(String id, String updatePW) {
		boolean result = false;
		List<MemberDTO> memInfoList = getMemInfoList();
		for(MemberDTO memInfo : memInfoList) {
			if(memInfo.getId().equals(id)) {
				memInfo.setPass(updatePW);
				break;
			}
		}
		result = memFile.fileWriter(memInfoList);
		
		return result;
	}
	
}
