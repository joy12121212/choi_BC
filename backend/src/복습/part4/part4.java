package 복습.part4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class part4 {
	public static void main(String[] args) throws IOException {
		
		
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String filePath = "./src/과제/과제5/재고파일.txt";
			FileOutputStream fileOutputStream = new FileOutputStream(filePath , true);
			FileInputStream fileInputStream  = new FileInputStream(filePath);
			File file = new File(filePath);
			
			byte[] ibtArray = new byte[(int) file.length()];
			fileInputStream.read(ibtArray);
			String fileInfo = new String(ibtArray);
			
			
			String[] 재고관리 = fileInfo.split("\n");
			
			
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("-1:제품등록 0:결제");
			
			for (int i = 0; i < 재고관리.length; i++) {
				if (!재고관리[i].equals("")) {
					
					String product = 재고관리[i];
					String name = product.split(",")[0];
					int stock = Integer.parseInt(재고관리[i].split(",")[1]);
					int price = Integer.parseInt(재고관리[i].split(",")[2]);
					int basket = Integer.parseInt(재고관리[i].split(",")[3]);
					
					if (stock == 0) {System.out.print((i+1)+""+name+""+"[재고없음]");
					}else {
						System.out.print((i+1)+"."+name+""+"["+price+"원] ");
					}
					
				}//if
			}//for
			
			System.out.println(">>>>>>> 선택 : "); int sc = scanner.nextInt();
			
			if (sc == -1) {
				System.out.print("제품명 : "); String name = scanner.next();
				System.out.println("초기재고 : "); int stock = scanner.nextInt();
				System.out.println("가격 : "); int price = scanner.nextInt();
				int basket = 0;
			
				String outStr = name+","+stock+","+price+","+basket+"\n";
			
				fileOutputStream.write(outStr.getBytes());
				System.out.println("안내) 제품이 등록 되었습니다.");
			}
			else if (sc > 0 && sc <= 재고관리.length) {
				
				String name = 재고관리[sc-1].split(",")[0];
				int stock = Integer.parseInt(재고관리[sc-1].split(",")[1]);
				int price = Integer.parseInt(재고관리[sc-1].split(",")[2]);
				int basket = Integer.parseInt(재고관리[sc-1].split(",")[3]);
				
				if (stock > 0) {
					stock--; basket++; System.out.println("제품을 담았습니다");
				}else {
					System.out.println(name + "재고가 부족 합니다");
				}
				
				재고관리[sc-1] = name + "," + stock + ","+price+","+basket;
				
				String outStr = "";
				
				for (int i = 0; i < 재고관리.length; i++) {
					outStr += 재고관리[i].split(",")[0]+","+재고관리[i].split(",")[1]+","+
							재고관리[i].split(",")[2]+","+재고관리[i].split(",")[3]+","+"\n";
				}// for
				
				FileOutputStream fileOutputStream2 = new  FileOutputStream(filePath);
				fileOutputStream2.write(outStr.getBytes());
				System.out.println("안내) 정보 최신화");
			}//else
			
			/*----------------------------결제--------------------------*/
			
			
			else if (sc == 0) {
				System.out.printf("%10s %10s %10s \n" , "제품명" , "수량" , "가격");
				
				for (int i = 0; i < 재고관리.length; i++) {
				
					int basket = Integer.parseInt(재고관리[i].split(",")[3]);
					int price = Integer.parseInt(재고관리[i].split(",")[2]);
					String name = 재고관리[i].split(",")[0];
					
					if (basket >0) {
						System.out.printf("%10s %10s %10s \n" , name , basket , basket * price);
					}
				
				}			
			
			}//else
			
		}//while
		
		
	}//main

}//class
