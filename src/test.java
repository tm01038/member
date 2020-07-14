import org.apache.commons.lang.StringUtils;

public class test {

	
		public static void main(String[] args) {
			
			String str = "11";
			str = StringUtils.leftPad(str, 3, "0");
			System.out.println(str);
		}

}
