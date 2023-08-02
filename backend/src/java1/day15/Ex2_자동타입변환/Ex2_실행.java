package java1.day15.Ex2_자동타입변환;

public class Ex2_실행 {
	
	public static void main(String[] args) {
		
		// 부모객체 : 힙 영역에 1개 생성
		Parent parent = new Parent();
		
		// 자식객체 : 힙 영역에 2개 생성
		Child child = new Child();
		
		// 자식객체를 부모객체에 대입??
		
		Parent parent2 = child; // 대입 가능 : 자식객체는 부모객체가 될 수 있다.
		// 자식객체가 부모 객체로 대입후에 부모객체는 자식 객체의 멤버를 가져다 쓸 수 없다
		// 하지만 오버라이딩 된 메소드는 사용이 가능하다
		
		// 자식은 부모꺼 다 갖다 씀// 근데 부모님 못씀// 하지만 부모 객체에 자식 객체를 대입한다면, 오버라이딩 된 자식 멤버를 쓸 수 있다
		
		
		// 부모객체를 자식객체에 대입 ??
//		Child child2 = parent2; // 대입 불가능 : 부모 객체는 자식 객체가 될 수 없다.
		
		Child child2 = (Child) parent2; // 강제 타입 변환
		// 부모 객체가 자식 객체로 대입 후에 변환된 자식 객체는 부모객체의 멤버를 사용할 수 있다.
		
	}

}


