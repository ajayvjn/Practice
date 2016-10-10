package Concepts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class collection_example {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		//***************************************************************
		//Insertion of duplicate number in SET {"One", 1, new Integer(1)}
		Set s = new HashSet();
		s.add("One");
		s.add(1);
		s.add(new Integer(1));
		
		for(Object a: s){
			System.out.println(a);
		}
		
		//***************************************************************
		//Iterating a HashMap
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("a", "Concepts.A");
		hm.put("b", "B");
		hm.put("c", "C");
		//through keySet()
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()){
			System.out.println(hm.get(it.next()));
		}
		//through Map.Entry
		Iterator it2 = hm.entrySet().iterator();
		while(it2.hasNext()){
			Map.Entry entry= (Map.Entry) it2.next();
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
		//***************************************************************
	}
}
