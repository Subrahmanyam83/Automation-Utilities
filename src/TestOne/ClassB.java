package TestOne;

public class ClassB implements ClassA {

	@Override
	public void getA(String a) {
		System.out.println(a+"hello");
		
	}

	@Override
	public void getB(String b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getC(String c) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String args[])
	{
		ClassB  b= new ClassB();
		b.getA("5");
	}

}
