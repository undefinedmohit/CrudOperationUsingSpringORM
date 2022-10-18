package com.springorm.dao;


import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.springorm.entities.Student;

	
public class StudentDao {
	
	private HibernateTemplate ht;
	
	@Transactional
	public int insert(Student student)
	{
		Integer i = (Integer)this.ht.save(student);
		
		
		return i;
	}
	
	/* reading data from DB */
	
	public Student getStudent(int studentId)
	{
		Student student=this.ht.get(Student.class, studentId);
		return student;
	}
	
	
	public List<Student> getAllStudents()
	{
		 List<Student> students = this.ht.loadAll(Student.class);
		 return students;
	}
	
	/* updating data from the DB */
	@Transactional
	public void updateStudent(int studentId)
	{
		Student student = this.ht.get(Student.class, studentId);
		this.ht.update(student);
	}
	
	@Transactional
	public void deleteStudent(int studentId)
	{
		Student student = this.ht.get(Student.class, studentId);
		this.ht.delete(student);
	}
	
	public HibernateTemplate getHt() {
		return ht;
	}
	
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	@Override
	public String toString() {
		return "StudentDao [ht=" + ht + ", getAllStudents()=" + getAllStudents() + ", getHt()=" + getHt()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
}
