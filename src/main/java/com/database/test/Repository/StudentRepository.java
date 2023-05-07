package com.database.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.database.test.Entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
