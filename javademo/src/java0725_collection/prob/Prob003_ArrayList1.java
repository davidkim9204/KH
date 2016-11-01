package java0725_collection.prob;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



/*
 * [문제]
 * phone.txt파일에 저장된 값들을  phoneProduct()메서드에서
 * SmartPhone에 저장한 후 ArrayList에 추가한후 리턴하고,
 * phoneList()메소드에서 프로그램 실행결과처럼 출력하는 프로그램을
 * 구현하시오.
 * 
 * [프로그램 실행결과]
 * << 1 번째 상품 >>
	제품 아이디 : PROD-00001
	제품명 : 아이폰5
	가격 : 940000
	수량 : 4
	제조사 : 애플
   << 2 번째 상품 >>
	제품 아이디 : PROD-00002
	제품명 : 갤럭시S
	가격 : 860000
	수량 : 3
	제조사 : 삼성전자

 */
public class Prob003_ArrayList1 {

	public static void main(String[] args) {
		String pathFile=".\\src\\java0725_collection\\prob\\phone.txt";
		ArrayList<SmartPhone> phoneList = phoneProduct(pathFile);
		prnDisplay(phoneList);
	}//end main()
	
	private static ArrayList<SmartPhone> phoneProduct(String pathFile) {
		// phone.txt파일의 데이터를 ArrayList에 저장한후 리턴하는 프로그램을 구현하시오.
		ArrayList<SmartPhone> v= new ArrayList<SmartPhone>();
		File file=new File(pathFile);
		Scanner sc =null;
		try{
		sc=new Scanner(file);
		while(sc.hasNextLine()){
			String arr [] = sc.nextLine().split(":");
			SmartPhone sn = new SmartPhone();
			sn.setProductId(arr[0]);
			sn.setName(arr[1]);
			sn.setPrice(Integer.parseInt(arr[2]));
			sn.setAmount(Integer.parseInt(arr[3]));
			sn.setMaker(arr[4]);
		
			v.add(sn);
		}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}finally{
			sc.close();
		}
			
			
			
			
	
		
		
		
		
		return v;
	}//end phoneProduct( )
	
	private static void prnDisplay(ArrayList<SmartPhone> phoneList){
		//phoneList매개변수의 저장된 값을 출력하는 프로그램을 구현하시오.	
		
		for(SmartPhone data : phoneList){
			System.out.println(data);
		}
		
//		<< 1 번째 상품 >>
//		제품 아이디 : PROD-00001
//		제품명 : 아이폰5
//		가격 : 940000
//		수량 : 4
//		제조사 : 애플
//		
		

	}//end prnDisplay( )

}//end class











