package com.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.school.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer>{
	
@Query(value="select * from student where sid =?1",nativeQuery = true)
	public StudentEntity getStudentbyID(Integer id);

}
