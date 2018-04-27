package com.sub.dbtable.service;

import com.sub.dbtable.pojo.Book;


public interface BookService {
	 int insertBook(Book book);
	 Book selectByBookName(Book book);
}
