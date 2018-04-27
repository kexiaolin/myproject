package com.sub.dbtable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sub.dbtable.mapper.BookMapper;
import com.sub.dbtable.pojo.Book;
import com.sub.dbtable.service.BookService;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    
    private BookMapper bookMapper;
	@Override
	public int insertBook(Book book) {
		return bookMapper.insertBook(book);
	}

	@Override
	public Book selectByBookName(Book book) {
	   
		return bookMapper.selectByBookName(book);
	}

}
