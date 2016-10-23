package Concepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*If any letter or substring repeats immediately-Password not accepted
	APPLE -		 Not accepted Concepts.A repeats
	CUCUMBER -	 Nor Accepted CU repeats
	APRICOT -	 Accepted*/

class PasswordBean implements Comparable<PasswordBean>{
	String value;
	int key;

	public PasswordBean(int key, String value){
		this.key = key;
		this.value = value;
	}

	/*@Override		if we implement Comparator
	public int compare(Concepts.PasswordBean o1, Concepts.PasswordBean o2) {*/

	
	@Override
	public int compareTo(PasswordBean o) {

		return this.value.compareTo(o.value);
	}
}

public class Comparable_Password_Acceptance{
	public static void main(String[] args) {
		new Comparable_Password_Acceptance().checkPwd("apple");
	}

	private void checkPwd(String s) {
		List<PasswordBean> l = new ArrayList<PasswordBean>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				l.add(new PasswordBean(i, s.substring(i,j+1)));
			}
		}
		Collections.sort(l);
		/*for(Concepts.PasswordBean b:l){
			System.out.println(b.value);
		}*/

		PasswordBean b1 = null;
		PasswordBean b2 = null;
		int flag = 0;
		for(int i=1;i<l.size();i++){
			b1 = l.get(i-1);
			b2 = l.get(i);

			if(b1.value.equals(b2.value)){
				if((b1.key+b1.value.length())-b2.key == 0){
					flag++;
					break;
				}
			}
		}

		if(flag>0)
			System.out.println("Password not accepted");
		else
			System.out.println("Password accepted");
	}
}
