package java0725_collection.prob;

import java.util.ArrayList;

public class BookManager {
	public static int getRentalPrice(ArrayList<BookDTO> bookList, String kind) {
		// 구현하세요.
		
		
		int data=0;//누적 낼 수 있는 변수
		for(BookDTO dto : bookList){
			if(dto.getKind()==kind)
				data+=dto.getRentalPrice();
		}
		

	
		
		
		
		
		return data;
	}//end getRentalPrice()
}//end class






