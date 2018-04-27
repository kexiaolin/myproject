package com.sub.dbtable.mapper;

import com.sub.dbtable.pojo.Book;


public interface BookMapper {
	 int insertBook(Book book);
	 Book selectByBookName(Book book);
}
