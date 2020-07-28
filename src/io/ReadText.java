package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadText {

	public static String readTest(String path) {
		File f = new File(path);
		try {
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			StringBuffer sb = new StringBuffer();
			String str;
			while ((str = br.readLine()) != null) {
				sb.append(str + "\r\n");
			}
			return sb.toString();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static List<Map<String, String>> parse(String str) {

		String[] strs = str.split("\\|");
		String[] keys = null;
		List<Map<String, String>> list = new ArrayList<>();
		for (int i = 0; i < strs.length; i++) {
			if (i == 0) {
				keys = strs[i].split(",");
			} else {
				String[] values = strs[i].split(",");
				Map<String, String> map = new HashMap<>();
				if (keys.length == values.length) {
					for (int idx = 0; idx < keys.length; idx++) {
						map.put(keys[idx], values[idx]);
					}
				}
				list.add(map);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		String str = ReadText.readTest("c:\\read.txt");
		List<Map<String,String>> phList = ReadText.parse(str);
		System.out.println(phList);
	}
}
