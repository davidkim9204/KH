package answer;

class Card{
	static int cnt;
	int data;
	++cnt;
	Card(int data){
	this.data=data;
		cnt++;
	
	}
}

public class test {
public static void main(String[] args) {
	Card cd= new Card(2);
	System.out.println(Card.cnt);
	
}
}
