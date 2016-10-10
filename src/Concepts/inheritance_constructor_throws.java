package Tricks;

import java.io.IOException;

class demo {
	public demo() throws IOException{
	}
}

public class inheritance_constructor_throws extends demo{

	//Inheriting exception can be generic not specific

	/*public Tricks.inheritance_constructor_throws(){
	}*/
	/*public Tricks.inheritance_constructor_throws() throws FileNotFoundException{
	}*/

	public inheritance_constructor_throws() throws IOException{
	}
	
	public static void main(String[] args) throws Exception {
		new inheritance_constructor_throws();
	}
}
