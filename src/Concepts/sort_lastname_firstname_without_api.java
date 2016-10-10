package Concepts;

//Sorting a 2D array by last name (by first name if last name is same) without using any API.
public class sort_lastname_firstname_without_api {
	public static void main(String[] args) {
		String [][] person = {
				{"anuraj","vijayan"},
				{"aviral","varshney"},
				{"ajay","vijayan"},
				{"ankit","bhati"},
				{"amit","bhardwaj"},
				{"shreyas","sinha"},
				{"shreyas","vijayan"}
		};
		System.out.println(person.length);
		String name1 = "";
		String name2 = "";
		String temp1 = "";
		String temp2 = "";
		int pos=0;
		for (int i = 0; i < person.length-1; i++) {
			name1 = person[i][0];
			name2 = person[i][1];
			pos = i;
			for (int j = i+1; j < person.length; j++) {
				if(lessThan(name1,name2,  person[j][0],person[j][1])){
					name1 = person[j][0];
					name2 = person[j][1];
					pos = j;
				}
			}
			temp1 = person[pos][0];
			temp2 = person [pos][1];
			person[pos][0] = person[i][0];
			person[pos][1] = person[i][1];
			person[i][0] = temp1;
			person[i][1] = temp2;
			
		}
		
		for (int i = 0; i < person.length; i++) {
			System.out.println(person[i][1] +" "+person[i][0]);
		}
		
	}

	private static boolean lessThan(String p10, String p11, String n10, String n11) {
		if(p11.compareTo(n11)<=0){
			return false;
		}
		else if(p11.compareTo(n11)>0) {
			return true;
		}
		
		if(p10.compareTo(n10)<=0){
			return false;
		}
		else{
			return true;
		}
	}
	
}
