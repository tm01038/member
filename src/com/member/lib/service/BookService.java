package com.member.lib.service;

import java.util.List;
import java.util.Map;

public interface BookService {
	Map<String,Object> insertBook(Map<String, Object> book);
	Map<String,Object> updateBook(Map<String, Object> book); // update 
	Map<String,Object> deleteBook(int bNum); //delete from book where b_num = ?
	List<Map<String,Object>> selectBookList(Map<String, Object> book);
	Map<String,Object> selectBook(int bNum);

}
