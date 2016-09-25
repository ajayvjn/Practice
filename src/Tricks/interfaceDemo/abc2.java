package Tricks.interfaceDemo;

interface demoInterface2{
	int i=0;
	void aa();
}

interface demoInterface3{
	int i=2;
	void aa();
}

public class abc2 implements demoInterface2, demoInterface3{
	public static void main(String[] args) {
		//System.out.println(i);  //field is ambiguous
	}

	@Override
	public void aa() {
		// This case works as method body is not defined in both interfaces		
	}
}
