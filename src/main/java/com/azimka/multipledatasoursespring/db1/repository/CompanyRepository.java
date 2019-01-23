package com.azimka.multipledatasoursespring.db1.repository;

import com.azimka.multipledatasoursespring.db1.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{
}
