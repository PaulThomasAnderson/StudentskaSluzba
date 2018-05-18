package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Student;

/**
Created By Luka
*/

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
