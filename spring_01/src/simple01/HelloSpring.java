package simple01;

/*
 * 결합도
 * 1. 클래스간의 상호 연결성 측정을 의미한다.
 * 2. 낮은 결합도를 가지려면 하나의 객체 변경이 다른 객체에 영향을 미쳐서는 안된다.
 */



public class HelloSpring {

	public static void main(String[] args) {
		//MessageBean클래스 이름을 직접적으로 사용하고 있기 때문에 높은 결합도를 갖고 있음.(MessageBean에서 변경을 하면 HelloSpring에 영향이 직접적으로 끼침)
		//결합도가 높으면 유지 보수 할 때 수정해야 되는게 많아짐.
		MessageBean bean=new MessageBean();
		bean.sayHello("spring");
	}
}
