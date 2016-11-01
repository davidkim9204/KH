package java0725_collection;

import java.util.ArrayList;

public class Java176_ArrayList {
	public static void main(String[] args) {
		ArrayList<String> aList=new ArrayList<String>();
		aList.add(new String("java"));
		aList.add(new String("jsp"));
		aList.add(new String("spring"));
		prnDisplay(aList);
		
	}//end main()
	
	public static void prnDisplay(ArrayList<String> aList){
		//aList의 요소에서 'j'가 포함되어 있는 요소만 출력하는 프로그램을 구현하세요.
		
//		for (int i=0;i<aList.size();i++){
//			for(int j=0;j<aList.get(i).length();j++){ 	//가져온 한개의 스트링에서의 길이
//				if(aList.get(i).charAt(j)=='j'){
//					System.out.println(aList.get(i));
//					break;
//				}
//			}
//		}
		
		
		for(int i=0; i<aList.size();i++){
			if(aList.get(i).contains("j"))
				System.out.println(aList.get(i));
			
		}
		
		
		
		
		
		
		
	}//end prnDisplay
	
}//end class
