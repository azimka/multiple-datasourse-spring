package com.azimka.multipledatasoursespring.db2.repository;

import com.azimka.multipledatasoursespring.db2.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{
}
