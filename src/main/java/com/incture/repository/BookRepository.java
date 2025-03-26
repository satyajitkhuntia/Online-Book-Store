package com.incture.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.incture.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
}
