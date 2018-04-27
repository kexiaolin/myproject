package com.sub.dbtable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.sub.dbtable.pojo.Book;
import com.sub.dbtable.router.DbContextHolder;
import com.sub.dbtable.service.BookService;


@Controller

public class BookController {
	  @Autowired
      private  BookService bookService;
	  @RequestMapping(value="/querybook",produces="text/html;charset=UTF-8")
	  @ResponseBody
	  public String findBook(Book book){
	
		  Book userDb = this.bookService.selectByBookName(book);
		  System.out.println("插入库："+DbContextHolder.getDb()+",在该库中的表为："+DbContextHolder.getTableIdx());
		  return userDb.toString();
	  }
}
