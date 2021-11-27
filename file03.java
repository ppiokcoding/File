package file;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class file03 {
	
	private static Scanner scan;
	private static int num;
	
	static {
		scan = new Scanner(System.in);
		
		//num = 1;
		
		try {
			
			BufferedReader reader 
				= new BufferedReader(new FileReader(Path.DATA));
			
			String line = null;
			
			//스트림 읽기: 원하는 라인만 읽기가 불가능하다. 무조건 처음 ~ 끝
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				num = Integer.parseInt(temp[0]);
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	} 
	//이 class안에서는 스캐너 더이상 만들필요 없다.
	
	public static void main(String[] args) {
		
		//1. 절대 경로
		// - 드라이브명으로 시작
		
		//2. 상대 경로
		// - 현재 폴더로(.) 시작
		// - 현재 폴더 == 프로젝트 폴더
		
		//D:\\class\\java\\JavaTest\\data\\user.dat
		//File file = new File(MyPath.DATA);
		//System.out.println(file.exists());
		
		
	
	//Ex73_File.java
	
	//회원 정보 관리 시스템
	//1. 기능 설계
	//	a. 회원 정보 추가하기
	//	b. 회원 정보 목록보기
	//	c. 회원 정보 삭제하기
	//	d. 회원 정보 검색하기
	//	e. 회원 정보 수정하기(손이 많이 감)
	
	//2. 데이터 설계(***)
	//	- 어디 + 어떤 파일 : JavaTest > data > user.dat
	//	- 데이터 포맷(형식) *****
	//	- 회원(이름, 번호, 나이, 주소)
	
	//3. 구현하기
		
		//이모티콘은 직접 출력해봐서 오류안나는지 확인하기
		//윈도우 + ; 
		System.out.println("😃💕❤😃💕❤");
		System.out.println("시작 화면(메세지)");
	
		boolean loop = true;
		
		while (loop) {
			
			menu();
			
			
			System.out.print("선택: ");
			String sel = scan.nextLine();
			
			//CRUD
			try {
				
			if (sel.equals("1")) {
				add(); //새로운 데이터 추가하기(Create)
			} else if (sel.equals("2")) {
				list(); //데이터 읽기(Read)
			} else if (sel.equals("3")) {
				delete(); //데이터 삭제하기(Delete)
			} else if (sel.equals("4")) {
				search(); //검색하기(Search)
			} else if (sel.equals("5")) {
				edit(); //데이터 수정하기(Update)
			} else {
				loop = false;
			}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
					
		}//while
		
		System.out.println("종료 화면(메세지)");
	
	
	}//main

	//****해석해보기
	private static void edit() throws Exception {
		
		header("회원 수정");
		
		System.out.println("수정할 회원번호: ");
		String num = scan.nextLine();
		
		
		BufferedReader reader
			 = new BufferedReader(new FileReader(Path.DATA));
		
		String line = null;
		
		while ((line = reader.readLine()) != null) {
			
			if (num.equals(line.split(",")[0])) {
				//이 회원 정보를 수정해야 한다.
				break;
			}
		}
		
		//System.out.println(line);
		String[] temp = line.split(",");
		
		System.out.println("기존 이름: " + temp[1]);
		System.out.print("수정 이름(수정하지 않으려면 그냥 엔터): ");
		String name = scan.nextLine();
		if (name.equals("")) {
			name = temp[1];
		}
		
		//이름 수정하던, 안하던...name 변수에는 텍스트 파일에 저장할 최조 이름이 들어있다.
		System.out.println(name);
		
		
		System.out.println("기존 나이: " + temp[2]);
		System.out.println("수정 나이: ");
		String age = scan.nextLine();
		if (age.equals("")) {
			age = temp[2];
		}
		
		System.out.println("기존 주소: " + temp[3]);
		System.out.println("수정 주소: ");
		String address = scan.nextLine();
		if (address.equals("")) {
			address = temp[3];
		}
		
		reader.close();
		
		
		//BufferedReader reader = new BufferedReader(new FileReader(MyPath.DATA));
		
		String txt = ""; //누적변수
		line = null;
		
		while ((line = reader.readLine()) != null) {
			if (num.equals(line.split(",")[0]) ) {
				txt += String.format("%s,%s,%s,%s\r\n"
									, num
									, name
									, age
									, address);
			} else {
				txt += line + "\r\n";
			}
		}
		
		reader.close();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(Path.DATA));
		
		writer.write(txt);
		writer.close();
		
		
		pause("회원을 수정완료");
		
	}

	private static void search() throws Exception {

		header("회원 검색하기");

		// 1. 검색어 입력
		// 2. 목록 출력 + 검색에 부합되는 항목

		System.out.print("검색어(주소 일부분): ");
		String word = scan.nextLine();

		BufferedReader reader = new BufferedReader(new FileReader(Path.DATA));

		String line = null;

		System.out.println("[번호]\t[이름]\t[나이]\t[주소]");

		while ((line = reader.readLine()) != null) {
			
			String[] temp = line.split(","); //위 데이터를 4조각내게 됨
			
			if (temp[3].indexOf(word) > -1) {
				
			System.out.printf("%5s\t%s\t%5s\t%s\r\n"
							, temp[0]
							, temp[1]		
							, temp[2]		
							, temp[3]);
			}
			
			
		}
		
		reader.close();
		
		
		pause("회원을 검색했습니다.");
		
	}

	private static void delete() throws Exception{

		header("회원 삭제하기");
		
		//1. 삭제할 회원?
		//2. 번호 입력
		//3. 삭제 처리   ==> 스트림의 성질은 덮어쓰기개념밖에 없다.
		
		//목록 출력하기...(보통의 사람들은 회원 번호 안외우고 다님)
		System.out.print("삭제할 회원 번호: ");
		String num = scan.nextLine();
		
		
		BufferedReader reader 
		= new BufferedReader(new FileReader(Path.DATA));
		
		String txt = ""; //누적 변수
		String line = null;
		
		
		
		while((line = reader.readLine()) != null) {
			if (!num.equals(line.split(",")[0])) {
			txt += line + "\r\n";
			}
		}
		
		reader.close();
		
		//System.out.println(txt);
		
		//덮어쓰기 모드: 삭제할 사람의 내용만 쏙 빠진 전체 내용을 덮어쓰기
		BufferedWriter writer = new BufferedWriter(new FileWriter(Path.DATA));
		
		writer.write(txt); //삭제
		writer.close();
		
		pause("회원을 삭제했습니다.");
		
	}

	
	private static void list() throws Exception {

		header("회원 목록보기");
		
		//1. BufferedReader
		//2. 라인 > 읽기
		//3. 라인 > 분리
		//4. 출력
		BufferedReader reader = new BufferedReader(new FileReader(Path.DATA));
		
		String line = null;
		
		System.out.println("[번호]\t[이름]\t[나이]\t[주소]");
		
		while ((line = reader.readLine()) != null) {
			//1회전 == 유저 1명
			//0, 홍길동, 21, 서울 강남 역삼동
			//System.out.println(line);
			
			//출력 정렬
			//1. 숫자
			// - 가운데 	: 고정폭
			// - 우측(**)	: 수치로서의 숫자
			//2. 문자열
			// - 가운데 	: 고정폭
			// - 좌측 	: 가변폭
			
			String[] temp = line.split(","); //위 데이터를 4조각내게 됨
			System.out.printf("%5s\t%s\t%5s\t%s\r\n"
							, temp[0]
							, temp[1]		
							, temp[2]		
							, temp[3]);
		}
		
		//자원 해제 코드 -> Clean up Code
		reader.close();
		
		
		pause("회원 목록을 출력했습니다.");
		
	}

	private static void add() {

		header("회원 추가하기");
		
		//System.out.print("번호: "); > 자동 입력
		//int num = 0;
		//num++; //지역변수이므로 이방식은 탈락 소용없다!
		
		System.out.print("이름: ");
		String name =scan.nextLine();
		
		System.out.print("나이: ");
		String age =scan.nextLine();
		
		System.out.print("주소: ");
		String address =scan.nextLine();
		
		try {
			
			BufferedWriter writer 
			= new BufferedWriter(new FileWriter(Path.DATA, true)); //누적으로 가야함!
			
			num++;
			
			//번호, 이름, 나이, 주소
			writer.write(String.format("%s,%s,%s,%s\r\n"
					 , num, name, age, address));
			
			
			writer.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		pause("회원을 추가했습니다.");
		
	}//add
	
	

	private static void pause(String msg) {
		//잠시 휴식... 프로그램 잠시 중지
		System.out.println(msg);
		System.out.println("계속하시려면 엔터키를 누르세요...");
		scan.nextLine();
	}

	private static void menu() {

		System.out.println("=======================");
		System.out.println("	회원관리");
		System.out.println("-----------------------");
		System.out.println("1. 회원 추가하기");
		System.out.println("2. 회원 목록보기");
		System.out.println("3. 회원 삭제하기");
		System.out.println("4. 회원 검색하기");
		System.out.println("5. 회원 수정하기");
		System.out.println("6. 종료");
		System.out.println("=======================");
		
	}
	
	private static void header(String title) {
		System.out.printf("[%s]\r\n", title);
	}
	
	

}
