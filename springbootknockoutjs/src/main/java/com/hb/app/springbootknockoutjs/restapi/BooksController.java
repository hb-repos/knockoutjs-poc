package com.hb.app.springbootknockoutjs.restapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
	
	private static Map<Integer, Book> books = new HashMap<>();

	@GetMapping
	public List<Book> home() {
		loadData();
		List<Book> list = new ArrayList<Book>();
		books.entrySet().forEach(entry -> {
			list.add(new Book(entry.getValue().getTitle(), entry.getValue().getAuthor()));
		});
		return list;
	}

	private void loadData() {
		books.put(1, new Book("abcd", "oxford"));
		books.put(2, new Book("atlas", "oxford"));
		books.put(3, new Book("sherlock", "conan doyle"));
		books.put(4, new Book("bongo", "congo"));
		books.put(5, new Book("deep focus", "ray"));
		
	}
}
