package com.springorm;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("config.xml");
        StudentDao student = con.getBean("studentDao", StudentDao.class);
        Student st= new Student();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean b= true;
        while(b)
        {
        	System.out.println("Press 1 to insert Student: ");
            System.out.println("Press 2 to update Student: ");
            System.out.println("Press 3 to show student by id: ");
            System.out.println("Press 4 to show all students: ");
            System.out.println("Press 5 to delete student by id: ");
            System.out.println("Press 6 to exit ");
            
            try {
            	int input=Integer.parseInt(br.readLine());
            	switch (input) {
				case 1:
					//insert user
					
					System.out.println("enter the id of student: ");
					int id=Integer.parseInt(br.readLine());
					System.out.println("enter the name of student: ");
					String name= br.readLine();
					System.out.println("enter the city of student: ");
					String city=br.readLine();
					
					st.setId(id);
					st.setName(name);
					st.setCity(city);
					student.insert(st);
					System.out.println("***********************************");
					System.out.println("------------"+st.getName()+" added------------");
					System.out.println("***********************************");
					System.out.println();
					break;
				case 2:
					//update student by id.....
					System.out.println("enter id of student to update: ");
					int uId= Integer.parseInt(br.readLine());
					System.out.println("enter the name of student: ");
					String uName= br.readLine();
					System.out.println("enter the city of student: ");
					String uCity=br.readLine();
					
					st.setId(uId);
					st.setName(uName);
					st.setCity(uCity);
					student.updateStudent(uId);
					System.out.println("***********************************");
					System.out.println("------------"+st.getName()+" Updated------------");
					System.out.println("***********************************");
					System.out.println();
					
					
					break;
				case 3:
					//show a student by id...
					System.out.println("enter id of student: ");
					int sId=Integer.parseInt(br.readLine());
					student.getStudent(sId);
					System.out.println("***********************************");
					System.out.println("------------ Details of "+st.getName()+"------------");
					System.out.println("Student Id : "+st.getId());
					System.out.println("Student Name : "+st.getName());
					System.out.println("Student City : "+st.getCity());
					System.out.println("------------------------------------------------------");
					System.out.println();
					
					break;
				case 4:
					//show all students...
					List<Student> allStudents = student.getAllStudents();
					for (Student student2 : allStudents) {
						
						System.out.println("Student Id : "+student2.getId());
						System.out.println("Student Name : "+student2.getName());
						System.out.println("Student City : "+student2.getCity());
						System.out.println("------------------------------------------------------");
						System.out.println();
					}
					
					break;
				case 5:
					//delete student...
					System.out.println("enter the id of student: ");
					int dId=Integer.parseInt(br.readLine());
					student.deleteStudent(dId);
					System.out.println("***********************************");
					System.out.println("------------"+st.getName()+" Deleted------------");
					System.out.println("***********************************");
					break;
				case 6:
					//exit
					b=false;
					break;

				
				}
				
			} catch (Exception e) {
				System.out.println("Invalid Option!!! Please Try Again...");
				System.out.println(e.getMessage());
			}
        }
     System.out.println("Thank You For Visiting, see you again........");
        
        con.close();
    }
}
