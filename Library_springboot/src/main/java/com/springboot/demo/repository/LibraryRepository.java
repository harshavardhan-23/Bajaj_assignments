package com.springboot.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.model.*;
public interface LibraryRepository extends JpaRepository<Book,Long>{

}
