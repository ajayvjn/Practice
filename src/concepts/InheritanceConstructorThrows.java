package concepts;

import java.io.IOException;

class Demo {
	public Demo() throws IOException{
	}
}

public class InheritanceConstructorThrows extends Demo {

	//Inheriting exception can be generic not specific

	/*public concepts.InheritanceConstructorThrows(){
	}*/
	/*public concepts.InheritanceConstructorThrows() throws FileNotFoundException{
	}*/

	public InheritanceConstructorThrows() throws IOException{
	}
	
	public static void main(String[] args) throws Exception {
		new InheritanceConstructorThrows();
	}
}
