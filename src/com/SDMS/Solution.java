package com.SDMS;

import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution 
{
	public static void main(String[]args)
	{
		System.out.println("Welcome to Student Database Management System");
		System.out.println("-----------------------------------------------");
		Scanner scan =new Scanner(System.in);
		// up casting --> Abstraction
		StudentManagementSystem sms= new StudentManagementSystemImpl(); 
		
		while(true)
		{
			System.out.println(" MENU DRIVEN PROGRAMM");
			System.out.println(" 1: Add the Student\n 2: Display the Student\n 3: Display All Student\n"
					+ " 4: Remove the Student\n 5: Remove All Student\n 6: Update Student\n 7: Count Student\n 8: Sort Student\n"
					+ " 9: Get Student with Highest Marks\n 10: GEt Student with lowest marks\n 11: EXITE Enter Choice ");
			int choice =scan.nextInt();
			switch(choice)
			{
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.displayStudent();
				break;
			case 3:
				sms.displayAllStudent();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudent();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudent();
				break;
			case 8:
				sms.sortStudent();
				break;
			case 9:
				sms.findStudentWithHighestMarks();
				break;
			case 10:
				sms.findStudentWithLowestMarks();
				break; 
			case 11:
				System.out.println("Thank you");
			default:
				try {
					String message="Invalid Choice, kindly enter valid choice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				} 
			}
			System.out.println("--------------------------------------------");
		}
	}
}
