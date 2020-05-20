package com.sulek.bezpecnost.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sulek.bezpecnost.Exceptions.BookNotFoundException;
import com.sulek.bezpecnost.data.Book;
import com.sulek.bezpecnost.repo.BookRepository;

@RestController
public class ZobrazenieRest {

	@Autowired
	BookRepository knihaRepo;
	
	// Find All
    @GetMapping("/books")
    List<Book> findAll() {
        return (List<Book>) knihaRepo.findAll();
    }
    
    // Save all books from Json body
    @PostMapping("/books")
	@ResponseStatus(HttpStatus.CREATED)
    Book newBook(@Valid @RequestBody Book newBook) {
        return knihaRepo.save(newBook);
    }
    
 // Find by ID
    @GetMapping("/books/{id}")
    Book findOne(@PathVariable @Min(1) Long id) {
        Optional<Book> vysledok = knihaRepo.findById(id);
        return vysledok.get();
    }

//    @PutMapping("/books/{id}")
//    Book saveOrUpdate(@RequestBody Book newBook, @PathVariable Long id) {
//    	if (knihaRepo.findById(id).isPresent()) {
//    		knihaRepo.findById(id).get();
//    	}
//    }
//    
//    // update author only
//    @PatchMapping("/books/{id}")
//    Book patch(@RequestBody Map<String, String> update, @PathVariable Long id) {
//
//      
//
//    }
// 	Delete by ID
    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
    	knihaRepo.deleteById(id);
    }
}
