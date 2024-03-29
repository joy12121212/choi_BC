package 과제.과제5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class 과제5_키오스크_파일처리 {

	public static void main(String[] args) throws IOException {

			
			
			
		while(true) {
			
			
			Scanner scanner = new Scanner(System.in);
			String filePath = "./src/과제/과제5/재고파일.txt"; // 재고파일의 경로를 filePath 에 대입 한다
			FileOutputStream fileOutputStream = new FileOutputStream(filePath, true); // fileOutputStream 변수에 filePath 파일출력 객체 생성 // true 로 이어쓰기 
			FileInputStream fileInputStream = new FileInputStream(filePath); // fileInputStream 변수에 filePath 파일입력 객체 생성 하여 대입
			File file = new File(filePath); // 파일 정보 객체 / 용량, 경로, 파일명 등등 알려주는 메소드
			/* ----------- */
			
			/* ------ 파일내 제품정보 --->스트림[바이트]---> 바이트배열로 저장---->문자열 변환-----*/		
			byte[] inByteArray = new byte[(int)file.length()]; // 파일의 용량 만큼의 배열 선언 // 알아서 바이트 값 확인
			fileInputStream.read(inByteArray); //연결될 파일의 바이트 읽어오기 // 어디에 저장할건지 inByteArray 지정 해줘야된다
			String fileInfo = new String(inByteArray); // 바이트를 -> 문자열 변환
//			System.out.println(fileInfo);
			
			/* ------ 파일내 제품정보 문자열 --> 배열 저장-----*/
				// 1. 하나의 문자열로 모든 ㅈ품의 문자열을 각 제품별로 분리
				String[] 재고관리 = fileInfo.split("\n");// fileInfo 에서 \n (줄바꿈 엔터) 로 구분지어서 재고관리 배열에 대입한다
//				System.out.println(Arrays.toString(재고관리));
				//System.out.println("제품별 분리 " + Arrays.toString(재고관리));//재고관리 배열의 모든 내용을 호출/출력 한다
				// 각 제품별로 각 필드/정보 분리
				
				
				
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("-1:제품등록 0:결제");
				//재고관리 배열에 있는 제품만 선택 가능 하도록 출력
			for (int i = 0; i < 재고관리.length; i++) { // 0부터 재고관리 길이 전까지 for문 실행
				if (!재고관리[i].equals("")) {//만약에 재고관리의 i번째 인덱스의 문자값이 ""(공백) 이 아니라면
				
				String product = 재고관리[i]; // 재고관리의 i 번째 인덱스 값을 product 변수에 대입
				String name = product.split(",")[0]; // product 배열의 , 구분지었을때 0번째 인덱스값을 name 변수에 대입
				int stock = Integer.parseInt(재고관리[i].split(",")[1]); //문자열로 되어있으니 integer.parseint 활영하여 인트자료형으로 변환 후 변수에 대입
				int price = Integer.parseInt(재고관리[i].split(",")[2]);
				int basket = Integer.parseInt(재고관리[i].split(",")[3]);
			
				if ( stock == 0) {System.out.print((i+1) + "" + name + " " + "[재고없음]");} // 만약에 stock 이 0 이라면 i+1 name 재고 없음 출력
				else {System.out.print((i+1) + "" + name + "["+price+"]");} // 아니면 i+ name 가격 출력 // i+1은 제품의 번호를 출력하기위해 적었음
				}//if
			}//for
			
			
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
		
			
			if (ch == -1 ) { // 만약에 -1번을 입력 한다면 제품등록 기능
					// 추가할 제품의 정보를 입력받아 각 변수에 저장
				System.out.print("제품명 : "); String name = scanner.next();   //응 스캐너
				System.out.print("초기재고 : "); int stock = scanner.nextInt();   //응 스캐너
				System.out.print("가격 : "); int price = scanner.nextInt();   //응 스캐너
				int basket = 0;
				// 해당 변수들을 하나의 데이터 구성
				
				String outStr = name+","+stock+","+price+","+basket+"\n"; // \n으로 데이터들을 구분 지어준다 // 그리고 배열 내에서 , 로 구분 지어 준다
				
				// 파일에 내보내기
					// 1. 파일출력스트림객체 2. 문자열 ->바이트배열로 변환 3. 바이트배열 내보내기

				fileOutputStream.write(outStr.getBytes());  // 2,3
				// 연결되어있는 파일(재고파일.txt)로 outStr 의 값을들 바이트로 변환하여 내보내기 한다 // 그럼 다시 맨 위로 올라가서 파일 연결 후 inByteArray 작업이 반복된다
				
				System.out.println("안내 제품이 등록 됨");
			}//if
			else if (ch > 0 && ch <=재고관리.length) {// 입력한 값이 0보다 크고 , 입력한 값이 재고관리 길이 보다 작거나 클때 // ex)입력한값3 재고관리 길이 6 // 3<=6 참 으로 실행 

				String name/*제품명*/ = 재고관리[ch-1].split(",")[0]; // name 변수에 재고관리 배열의 [ch(입력된값)-1 = (인덱스) ] 에서 , 구분 된것중 0번째 인덱스 값을 대입
				int stock/*재고*/= Integer.parseInt(재고관리[ch-1].split(",")[1]); // 문자열로 되어있으니 integer.parseint 활영하여 인트자료형으로 변환 후 변수에 대입
				int price/*가격*/ = Integer.parseInt(재고관리[ch-1].split(",")[2]); // 상동
				int basket/*바구니*/ = Integer.parseInt(재고관리[ch-1].split(",")[3]); // 상동
				
				if (stock > 0) {
					stock--; basket++; System.out.println(name + "제품을 담앗슴");
				}else {System.out.println(name + "제고 엄슴");}
				
				재고관리[ch-1]=name+","+stock+","+price+","+basket; // 재고 상태 현행화
				
				String outStr = ""; // 공백 변수 생성
				
				for (int i = 0; i < 재고관리.length; i++) {
					outStr += 재고관리[i].split(",")[0]+","+재고관리[i].split(",")[1]+","+재고관리[i].split(",")[2]+","+재고관리[i].split(",")[3]+"\n";
				}//for e
				
				//4. 재고관리 배열을 하나의 문자열로 변환, 문자열을 바이트배열로 변환 후 내보내기
					//덮어쓰기 , 기존꺼 말고 새로 선언
				FileOutputStream fileOutputStream2 = new FileOutputStream(filePath); // 첫글자 대문자로 해야된다
				fileOutputStream2.write(outStr.getBytes());
				System.out.println("안내` 데이터베이스 상태 최신화");
			}//if 끝

						
			/*-----------------------결제-----------------------------------*/
			
			else if (ch ==0) {
				System.out.printf("%10s %10s %10s \n" , "제품명" , "수량" , "가격");
//				System.out.println(Arrays.toString(재고관리));
				for (int i = 0; i < 재고관리.length; i++) {
					
					int basket = Integer.parseInt(재고관리[i].split(",")[3]);
					int price = Integer.parseInt(재고관리[i].split(",")[2]);
					String name = 재고관리[i].split(",")[0];
					if (basket > 0) {
						System.out.printf("%10s %10s %10s \n" , name , basket , basket*price);
					}
				}//for
			}// ch 0 if
			
			
			
			
			/* ----------- */
			
		} // while end 
	} // main end 
} // class end 



