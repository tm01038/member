package com.member.lib.dao;

import java.util.List;
import java.util.Map;

public interface BookDAO {

	int insertBook(Map<String, Object> book);
	int updateBook(Map<String, Object> book); // update 
	int deleteBook(int bNum); //delete from book where b_num = ?
	List<Map<String,Object>> selectBookList(Map<String, Object> book);
	Map<String,Object> selectBook(int bNum);
}