package tw.org.iii.mytest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Brad74 {

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "Brad");
		map.put("stage", 2);
		map.put("sound", false);
		map.put("other", 2);
		System.out.println(map);
		System.out.println(map.get("name"));
		System.out.println(map.get("stage"));
		System.out.println(map.get("sound"));
		System.out.println("-----");
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(map.get(key));
		}
		System.out.println("-----");
		Collection<Object> vs=  map.values();
		for (Object obj : vs) {
			System.out.println(obj);
		}
		
	}

}
