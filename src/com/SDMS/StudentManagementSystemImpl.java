package com.SDMS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import costomSorting.SortStudentByAge;
import costomSorting.SortStudentById;
import costomSorting.SortStudentByMarks;
import costomSorting.SortStudentByName;
import customexception.InvalidChoiceException;
import customexception.StudentNotFoundException;

public class StudentManagementSystemImpl implements StudentManagementSystem 
{
	Scanner scan=new Scanner(System.in);
	Map<String,Student> db=new LinkedHashMap<String,Student>(); // key is Student id & value is Student object
	@Override
	public void addStudent()
	{
		// Accepting Age,Name&Marks from user
		System.out.println("Enter Age"); // Acccepting age
		int age=scan.nextInt();
		System.out.println("Enter Name"); // Acccepting Name
		String name=scan.next();
		System.out.println("Enter Marks"); // Acccepting maeks
		int marks=scan.nextInt();
		
		// Create a Student object
		Student std=new Student( age,name,marks);
		// Add Student Id as key & Student object as values in db
		db.put(std.getId(), std);
		System.out.println(" Student Record Inserted Successfully!!");
		System.out.println("your Student Id is "+std.getId()); //  Desplaying the Student Id
		
	}
	@Override
	public void displayStudent()
	{
		System.out.println("Enter Student Id");
		// accepting the Student id
		String id=scan.next();
		id=id.toUpperCase();                  // OR String id=scan.next().toUpperCase
		if(db.containsKey(id))                // checking the id is present or not . Id=key
		{
			Student std=db.get(id);           //  getting the Student object
			
			System.out.println("Student Details: ");
			System.out.println("----------------------------------");
			System.out.println("Id: "+std.getId());
			System.out.println("Age: "+std.getAge());
			System.out.println("Name: "+std.getName());
			System.out.println("Marks: "+std.getMarks());
			
		}
		else
		{
			try
			{
				String message="Student with the Id "+id+" is NotFound";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void displayAllStudent()
	{
		if(db.size()>0) 
		{
			System.out.println("Student Records are as follows");
			System.out.println("----------------------------------");
			Set<String> keys=db.keySet();  // it returns  only Id
			for(String key:keys)
			{
				System.out.println(db.get(key));
			}
		}
		else
		{
			try {
			String message="No Suffcient Record to Desplay";
			throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeStudent()
	{
		System.out.println("Enter Student Id");
		// accepting the Student id
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id))                // checking the id is present or not . Id=key
		{
			System.out.println("Student Record found: ");
			System.out.println(db.get(id));          //  getting the Student id
			db.remove(id);
			System.out.println(" Student Record Removed Successfully");
			
		}
		else
		{
			try
			{
				String message="Student with the Id "+id+" is NotFound";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeAllStudent()
	{
		if(db.size()>0)
		{
			System.out.println("No of Student Records:"+db.size());
			db.clear();
			System.out.println("All Student Records Deleted Successfully!");
		}
		else
		{
			try
			{
				String message="No Student Records to Delete";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void updateStudent()
	{
		System.out.println(" Enter Student Id: ");
		String id=scan.next().toUpperCase();
		
		if(db.containsKey(id))
		{
			Student std=db.get(id);    // getting the Student object based on id
			
			System.out.println(" 1: Update Age\n 2: Update Name\n 3: Update Marks\n Enter Choice");
			int choice=scan.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter Age: ");
				int age=scan.nextInt();
				std.setAge(age);
				System.out.println(" Age is Updated Successfully");
				break;
			case 2:
				System.out.println("Enter Name: ");
				String name=scan.next();
				std.setName(name);
				System.out.println("Name is Updated Successfully");
				break;
			case 3:
				System.out.println("Enter Marks: ");
				String marks=scan.next();
				std.setName(marks);
				System.out.println("Marks is Updated Successfully");
				break;
	
			}
		}else
		{
			try
			{
				String message="No Student Records to Update ";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
	}
	@Override
	public void countStudent()
	{
		System.out.println("Number Of Student Records: "+db.size());
	}
	@Override
	public void sortStudent()
	{
		// converting Map into Set using KeySet()
		Set<String> keys= db.keySet();
		
		//reference of List & object Arralist sorting student object
		List<Student> list=new ArrayList<Student>();
		
		// traversing the keys
		for(String key: keys)
		{
			list.add(db.get(key)); // getting Studnet object and adding in List
		}
		
		System.out.println("1:Sort Student By Id\n2:Sort Student By Age\n3:Sort Student By Name\n4:Sort Student By Marks\n");
		System.out.println("Enter Choice");
		int choice=scan.nextInt();
		
		switch(choice)
		{
		case 1:
			Collections.sort(list,new SortStudentById());
			for(Student s: list)
			{
				System.out.println(s);
			}
			break;
		case 2:
			Collections.sort(list,new SortStudentByAge());
			for(Student s: list)
			{
				System.out.println(s);
			}	
			break;
		case 3:
			Collections.sort(list,new SortStudentByName());
			for(Student s: list)
			{
				System.out.println(s);
			}	
			break;
		case 4:
			Collections.sort(list,new SortStudentByMarks());
			for(Student s: list)
			{
				System.out.println(s);
			}	
			break;
		default:
			try
			{
				String message="Invalid choice, kindly enter valid choice";
				throw new InvalidChoiceException(message);
			}
			catch(InvalidChoiceException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	
	// TRAVERSING A LIST OF STUDENT OBJECT
	 private static void display(List<Student>list)
	 {
		 for(Student student:list)
		 {
			 System.out.println(student);
		 }
	 }
	 
	 
	@Override
	public void findStudentWithHighestMarks()
	{
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key :keys)
		{
			list.add(db.get(key)); // getting student object and adding list
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println("Student with the highest marks:");
		System.out.println(list.get(list.size()-1));
	}
	
	@Override
	public void findStudentWithLowestMarks()
	{
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key :keys)
		{
			list.add(db.get(key)); // getting student object and adding list
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println("Student with the lowest marks:");
		System.out.println(list.get(0));
	}

}
