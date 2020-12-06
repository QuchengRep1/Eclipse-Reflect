package com.qucheng.reflectpj.service;

import java.util.List;

import com.qucheng.reflectpj.entity.Book;
import com.qucheng.reflectpj.entity.User;

public interface BookService {
	
	void borrow(User user,List<Book> books);

}
