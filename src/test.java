import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class test {

	
		public static void main(String[] args) {
			
			Map<String, Object> map = new HashMap<>();
			
			map.put("요", 4);
			map.put("하", 7);
			map.put("안녕", 8);
			map.put("세", 3);
			
			
			for(String key : map.keySet()) {
				System.out.println(key);
			}
			
		
			
//			Iterator<String> it = map.keySet().ijterator();
//			for(int i = 0 ; i<map.size(); i++) {
//				System.out.println(map.keySet());
//			}
//			
//			String test = "1,2,3,4,5,6,7,where";
//			int result = test.lastIndexOf("where");
//			System.out.println(result);
		}

		
//		select l.l_num from lent l, member m,book b where  l.b_num = m.m_NUM  and b.b_NUM = l.m_num;
		
}
