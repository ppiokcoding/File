package file;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class file02 {
	
	public static void main(String[] args) {
		
		//[File02]
		/*
		 
		 1. 파일, 디렉토리 조작
		 - 파일 자체, 디렉토리 자체
		 
		 2. 파일 입출력
		 - 파일 입출력
		 - 파일의 내용 조작
		 - 메모장 기능 
		 
		 파일 입출력
		 - 자바 프로그램(주기억 저장장치(메모리)) <--(데이터)--> 외부 저장장치(보조 기억 장치, HDD, SDD, USB Storage...)
		 - 파일 읽기, 파일 쓰기
		 
		 a. 텍스트 입출력
		 	- 문자(열) 읽기/쓰기
		 	- 자바("홍길동")<====>(변환)<===>텍스트파일(10101010100)
		 	
		 b. 바이너리 입출력
		 	- 이미지, 동영상, 실행파일, 압축파일 읽기/쓰기
		 	- 비(非) 텍스트 데이터
		 
		 
		 하드 디스크
		 - 프로그래밍 개념(x), 자료형 존재(x)
		 - 순수한 1,0 만 존재
		 자바 프로그램("홍길동", String) --> 텍스트 파일("1010101001(O) / "홍길동", String (x))	
		
		인코딩, Encoding
		- 문자 코드를 부호화(0,1) 하는 작업
		- 자바 프로그램("홍길동", String) --> 텍스트 파일("1010010100")
		- 내보내기(쓰기)
		
		디코딩, Decoding
		- 부호 데이터를 문자 코드로 변환하는 작업
		- 복호화
		- 텍스트 파일("10010101001") --> 자바 프로그램("홍길동", String)
		- 가져오기(읽기)
		
		인코딩/디코딩 규칙(******)
		1. ISO-8859-1
		2. EUC-KR
		3. ANSI
		4. MS949
		5. UTF-8
		6. UTF-16
		
		
		ANSI(ISO--8859-1, EUC-KR, MS949)
		1. 영어: 1byte
		2. 한글: 2byte
		
		UTF-8
		- 대다수 환경 표준 인코딩 방식으로 채택
		- JAVA 인코딩
		- Oracle 인코딩 
		1. 영어: 1byte
		2. 한글: 3byte
		
		UTF-16
		1. 영어: 2byte
		2. 한글: 2byte
		
		
		네이버 서버(페이지) -> 인코딩(UTF-8) -> 네트워크 -> 디코딩 -> 내 컴퓨터(브라우저)
		 
		 */
	
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		m8();
		
		
	}//main

	private static void m8() {

		//읽기
		try {

			String path = "D:\\class\\java\\JavaTest\\src\\com\\test\\java\\Ex07_Output.java";
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = null;
			int n = 1;
			
			while ((line = reader.readLine()) != null) {
				System.out.printf("%03d: %s\r\n", n, line);
				n++;
			}
			
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m7() {

		try {
			
			//BufferedWrite == FileWriter 동일한 기능 제공
			
			
			String path = "D:\\class\\java\\file\\memo.txt";
			BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
			
			writer.write("안녕하세요.");
			writer.newLine();
			writer.write("반갑습니다.");
			writer.write("\r\n");

			writer.close();
	
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
	}

	private static void m6() {

		try {
			
			//Stream -> Wrapper Class
			//- BufferedReader
			//- BufferedWriter
			
			
			String path = "D:\\class\\java\\file\\memo.txt";
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			//- reader.read() : 문자 읽기
			//- reader.readLine() : 문장 읽기
			
//			System.out.println((char)reader.read());
//			System.out.println(reader.readLine);
//			System.out.println(reader.readLine);
//			System.out.println(reader.readLine);
//			System.out.println(reader.readLine);
//			System.out.println(reader.readLine);

			String line = null;
			
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			
			
			reader.close(); //스트림 닫기
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	private static void m5() {

		try {
			
			//읽기
			//- 문자 단위 읽기(2byte)
			//- 모든 문자를 읽을 수 있다.(한글 포함)
			
			//FileOutputStream <-> FileInputStream
			//FileWriter <-> FileReader
			
			FileReader reader = new FileReader("D:\\class\\java\\file\\memo.txt");
			
			
			//int code = reader.read();
			//System.out.println((char)code);
			
			int code = -1;
			
			while ((code = reader.read()) != 1) {
			
				System.out.print((char)code);
			
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	private static void m4() {

		try {
			
			FileWriter writer = new FileWriter("D:\\class\\java\\file\\memo.txt");
			Scanner scan = new Scanner(System.in);
			
			for (int i=0; i<5; i++) {
				System.out.print("입력: ");
				String line = scan.nextLine();
				writer.write(line);
				writer.write("\r\n");
			}
			
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	private static void m3() {

		//쓰기
		//- 문자 단위 쓰기(2byte)
		//-  모든 문자를 지원(한글 포함)
		try {
			
			//FileOutputStream > FileWriter(향상된 스트림)
			FileWriter writer = new FileWriter("D:\\class\\java\\file\\list2.txt");
			
			writer.write(65);
			writer.write(66);
			writer.write(67);
			writer.write(44550);
			writer.write('가');
			writer.write("뾹이 안녕!!!!");
		
			
			writer.close();
			
			//Error : Stream closed
			//writer.write("추가 데이터");
			//한번 닫은 스트림은 재사용이 불가능;; > 또 다른 스트림을 열어야한다.
			writer = new FileWriter("D:\\class\\java\\file\\list2.txt", true); //Append모드
			
			writer.write("추가 데이터");
			
			writer.close();
			//왠만하면 스트림 하나로 작업할것. 통제하기 어려움..
			
			System.out.println("종료");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m2() {

		//읽기
		//- 바이트 단위 읽기
		//- 1바이트 읽기 > 한글 불가능
		
		//FileOutputStream
		//FileInputStream
		
		try {
			
			FileInputStream stream 
				= new FileInputStream("D:\\class\\java\\file\\list.txt");
			
			//System.in.read()
//			int code = stream.read(); //문자 1개 읽기
//			System.out.println((char)code);
//			
//			code = stream.read();
//			System.out.println((char)code);
//			
//			code = stream.read();
//			System.out.println((char)code);
//			
//			code = stream.read();
//			System.out.println((char)code);
		
			int code = -1;
			
			//-1: 파일의 끝(EOF, End Of File)
			while ((code = stream.read()) != -1) {

				System.out.print((char)code);
				//아직 한글은 깨짐
				
			}
			
			stream.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	private static void m1() {

		//쓰기
		//- 바이트 단위 쓰기
		//- 1바이트 저장 > 2바이트 문자 저장 불가능 > ASCII 문자만 저장, 한글 저장 불가
		
		//파일에 데이터 쓰기
		//1. 스트림 객체 생성하기(열기)
		//2. 스트림 객체 사용하기 + 파일 쓰기
		//3. 스트림 객체 닫기(필수 + 저장)
		
		//쓰기 전용 스트림(빨대)
		//- 프로그램 -> 파일
		try {
			
			//쓰기 스트림 모드
			//1. 생성 모드, Create Mode
			//	- 기본 방식
			//	a. 파일이 존재하지 않으면 자동으로 생성한다. 
			//	b. 항상 파일을 덮어쓰기 한다. (더 많이 사용)
			
			//2. 추가 모드, Append Mode
			//	- 선택 방식
			//	a. 파일이 존재하지 않으면 자동으로 생성한다. 
			//	b. 기존 내용을 그대로 둔 채 추가로 데이터를 저장한다.
			
			//1. 스트림 객체 생성
			//FileOutputStream stream 
			//	= new FileOutputStream("D:\\class\\java\\file\\list.txt");
		
			
			File file = new File("D:\\class\\java\\file\\list.txt");
			FileOutputStream stream = new FileOutputStream(file, true);
			//true : Append 모드
			//false or 미입력 : Create 모드
			
			
			
			//2. 사용하기 > 문자코드 > 출력 버퍼에 기록한다.(= 임시저장)
			//stream.write(65); //A
			//stream.write(66); //B
			//stream.write(67); //C
			
			
			
			//2.5
			Scanner scan = new Scanner(System.in);
			System.out.print("쓰기: ");
			String line = scan.nextLine();
			
			for (int i=0; i<line.length(); i++) {
				char c = line.charAt(i);
				stream.write(c); //'A' == 65
			}
			
			stream.write('\r');
			stream.write('\n');
			
			
			//3. 스트림 닫기 > 실제로 파일에 저장된다.
			stream.close();
			
			System.out.println("완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
