package library.manage;

public interface Manage {
	public int managerLoginCheck(String id, String pw); //로그인
	public void memInfoListPrint(); //회원정보 출력
	public boolean bookInfoAdd(int index, String b_name, int b_price, String category,  int amount); //도서 추가
	public boolean bookInfoDelete(int bookIndex); //도서 삭제
}
