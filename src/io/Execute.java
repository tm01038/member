package io;

import java.util.List;
import java.util.Map;

public class Execute {
	public static void main(String[] args) {
		String str = ReadText.readTest("c:\\read.txt");
		List<Map<String,String>> phList = ReadText.parse(str);
		System.out.println(phList);
	}
	

}
