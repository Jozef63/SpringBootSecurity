package com.sulek.bezpecnost.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sulek.bezpecnost.data.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	
}
