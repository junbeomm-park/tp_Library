package hotel.user;

import java.util.Scanner;

public class UserInformation  implements UserSevice {
	User[] arr;
	int count;
	Scanner sc;
	
	public UserInformation() {
		arr = new User[10];
		sc = new Scanner(System.in);
	}
	
	
	public UserInformation(User[] arr, int count, Scanner sc) {
		this.arr = arr;
		this.count = count;
		this.sc = sc;
	}


	@Override
	public void show() {
		for(int i = 0; i < count; i++) {
			arr[i].show();
		}
	}
	

	@Override
	public void sign() {
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String pass = sc.nextLine();
		arr[count++] = new User(name, id, pass);
		
		System.out.println("\n---------------------");
		System.out.println("회원가입 완료 !!!");
		System.out.println("---------------------\n");
		
		

	}

	@Override
	public void modify(String id, String pass) {
		for(int i = 0; i < count; i++) {
			if(id.equals(arr[i].getId())) {
				System.out.print("비밀 번호 수정 : ");
				String modify_pass = pass;
				
				arr[i].setPass(modify_pass);
			}
		}
	}





	@Override
	public int login() {
		int check = 0;
		
		System.out.print("아이디 입력 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 입력 : ");
		String pass = sc.nextLine();
		
		for(int i = 0 ; i < count; i++) {
			if(id.equals(arr[i].getId()) && pass.equals(arr[i].getPass())) {
				System.out.println("\n---------------");
				System.out.println("로그인 성공 !!");
				System.out.println(arr[i].getId()+"님 반갑습니다.");
				System.out.println("---------------\n");
				check = 1;
			}else if(id.equals(arr[i].getId()) && !pass.equals(arr[i].getPass())){
				check = 2;
			}else {
				check = 3;
			}
		}
		return check;
	}





	

	
}
