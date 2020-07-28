package io;

import java.io.File;

public class FolderTest {

	public static void main(String[] args) {
		File path = new File("C:\\java_jeong\\address");
		if (path.isDirectory()) {
			File[] files = path.listFiles();
			for (File file : files) {
				if (file.getName().indexOf("build_") == 0 && !file.isDirectory()) {
					System.out.println(path+"\\"+file.getName());
				}
			}
		}
	}
}
