package java0725_collection;

import java.util.Arrays;
import java.util.List;

public class Java178_ArrayList {

	public static void main(String[] args) {
		String[] arr={"oracle","mysql","mssql"};
		
		//배열 -> 컬렉션(list)
		List<String> list=Arrays.asList(arr);
		for(String sn : list)
			System.out.println(sn);
		
		//add() 삽입 set()업데이트
		
	}//end main()
}
