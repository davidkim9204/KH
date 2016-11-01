package java0727_inner_thread;

class User2 implements Runnable{
	@Override
	public void run(){
		for (int j=0; j<=5;j++)
			System.out.printf("%s j=%d\n",Thread.currentThread().getName(),j);
	}
	
}
public class Java193_Thread {

	public static void main(String[] args) {
		User2 user=new User2();
		Thread th=new Thread(user);//start가 없어서
		th.start();
		
		System.out.println("main thread out");
		
	}//end main()
		
}//end class
