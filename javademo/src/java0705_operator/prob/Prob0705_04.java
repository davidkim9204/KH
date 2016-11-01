package java0705_operator.prob;

/*
 1  사과를 담는데 필요한 바구니의 수를 구하는 코드이다. 
 2  만일 사과의 수가 123개이고 하나의 바구니에는 10개의 사과를 담을 수 있다면,
    13개의 바구니가 필요하다
 3  [실행결과]
     필요한 바구니의 수 : 13
 */
public class Prob0705_04 {
	
	public static void main(String[] args) {
           //여기에 작성하시오
        int apple = 154;
        int b = apple/10;
        int basket =   apple%10 == 0 ?   b   : b +1;
		System.out.println(basket);
		
        //솔루션
		int numofapple = 123;
		int sizeofbucket =10;
		
		int numofbucket= numofapple%sizeofbucket == 0 ?
					numofapple/sizeofbucket : numofapple/sizeofbucket +1;
		System.out.println("필요한 바구니의 수:" + numofbucket);
		
		
		
		
		
	}

}
