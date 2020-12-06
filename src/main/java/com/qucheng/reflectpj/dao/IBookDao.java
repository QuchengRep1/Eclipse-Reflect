package com.qucheng.reflectpj.dao;

import java.util.List;

import com.qucheng.reflectpj.entity.Book;

public interface IBookDao {
		
		Book findBookById(int id);
		
		List<Book> findAllBooks();
		
		void saveBook(Book book);

		
		

}
