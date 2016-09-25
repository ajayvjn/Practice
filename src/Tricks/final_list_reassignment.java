package Tricks;

import java.util.ArrayList;
import java.util.List;


public class final_list_reassignment {
	public static void main(String[] args) {
		final List<String> a = new ArrayList<String>();		
		a.add("abc");
		a.add("cba");
		
		for(String s: a){
			System.out.println(s);
		}
		
		//a = new ArrayList<String>(); // re-assignment of final variables are not allowed
		
	}
}
