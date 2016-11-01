package Java0706_statement;
/*각 월의 마지막일
 * 1 3 5 7 8 10 12 => 31
 * 4 6 9 11 => 30
 * 2 => 28
 * 
 * [출력결과]
 * 4월의 마지막 일은 30입니다.
 */
public class Java022_if {

	public static void main(String[] args) {
		int month = 11;
		int lastDay=30;
		
		if (month==2){
			lastDay= lastDay - 2
		}else{if (month== 4 || month ==6 ||month == 9 ||month ==11)
		lastDay=lastDay
		}else{
		lastDay+=1
		}
		
		System.out.printf("%d월의 마지막 일은 %d입니다.", month, lastDay);
		
		
	}//end main()
}//end class


	//if(!(mont>=1 && month <=12))




/*
int lastday = -1
if(month~1 3 5 7 8 10 12)
	lastday = 31
	else if 4 6 9 11
	lastday = 30
	else if 2
	lasdaty = 38
	
if(lastDay==-1{
sysout("잘못입력되었습니다. 다시 시작하세요
else
sysout(마지막 일은 %d입니다. ,	)
	
	
sysout(%d월의 마미작일은 %d입니다. , month, lastday)	


*
*
*/