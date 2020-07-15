import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class test {

	
		public static void main(String[] args) {
			
			Map<String, Object> map = new HashMap<>();
			map.put("7", 8);
			map.put("2", 7);
			map.put("6", 3);
			map.put("4", 4);
			
			for(String key : map.keySet()) {
				System.out.println(key);
			}
			Iterator<String> it = map.keySet().iterator();
			for(int i = 0 ; i<map.size(); i++) {
				System.out.println(map.keySet());
			}
//			
//			String test = "1,2,3,4,5,6,7,where";
//			int result = test.lastIndexOf("where");
//			System.out.println(result);
		}

}
