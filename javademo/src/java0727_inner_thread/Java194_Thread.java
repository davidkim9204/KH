package java0727_inner_thread;

/*스레드 생명주기 (life cycle)
 * start() -실행준비상태 (Runnable) - run() - dead
 */

class User3 extends Thread{
	
	public User3(){
		
	}
	
	public User3(String name){
		super(name);
	}
	
	@Override
	public void run() {  //override기 때문에throws불가
		System.out.println(getState());	//runnable
		
		for(int i=1; i<=10; i++){
			try {
				//1000은 1초를 의미한다.
				Thread.sleep(1000); //waitting not runnable 일시정지상태 wait()메소드는 반드시 깨워줘야한다.
				System.out.printf("%s i=%d\n",getName(),i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //여기서 1000은 1초
		}
	}
	
	
}//end User3


public class Java194_Thread {

	public static void main(String[] args) {
		User3 user = new User3("user");
		System.out.println(user.getState()); //현재 스레드의 상태값 가져올 수 있다. //NEW
		
		user.start();
		
		try {
			//지정된 시간동안 스레드가 실행되도록 한다. 지정된 시간이 
			//지나거자 종료가 되면 join()을 호출한 스레드로 다시 돌아와 실행을
			//계속수행한다.
			user.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(user.getState());
		System.out.println("main end");
		
		
//		user.start();
		
		
	}//end main()
}//end class
