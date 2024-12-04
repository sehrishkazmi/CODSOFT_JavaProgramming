// CODSOFT NOVEMBER BATCH 2024
// JAVA PROGRAMMING
// Sehrish Kazmi
// TASK 2: Student_Grade_Calculator
import java.util.Arrays;
import java.util.Scanner;
public class Student_Grade_Calculator {
    public static void main(String[] args){
        Scanner cred = new Scanner(System.in); //getting ready to ask for credentials
        System.out.println("Enter your name: "); //Enter student name
        String name = cred.nextLine();
        System.out.println("Enter your roll no."); //Enter roll no.
        int roll_no = cred.nextInt();

        // System verifies student's credentials
        System.out.println("\nVerifying credentials...\n");
        System.out.println("Welcome, "+name+" Roll no. "+roll_no+" Degree: BS PSY - Semester 01"+"\nYour courses this semester are as follows:");

        String[] courses = {"1. Introduction to Psychology", "2. Philosophy of Social Sciences", "3. IT", "4. Mathematics","5. Pakistan Studies","6. Communication Skills"};
        for (String i: courses){
            System.out.println(i); //Printing array of course names
        }
        //total marks obtained
        float total_marks = 0.0f;

        //this part of the code can be done better
        System.out.println("Enter the marks for each subject one by one");
        float[] marks = new float[6]; //initializing a marks array
        for (int i=0;i<6;i++){
            marks[i] = cred.nextFloat();
            total_marks+=marks[i];
        }
        System.out.println("\nProcessing Grades...\n");
        System.out.println("\t\tSTUDENT GRADE CALCULATOR\nName: "+name+ "\t\tRoll no: "+roll_no);

        //average percentage scored
        float percentage = total_marks/6.0f;
        String grade = getString(percentage);
        System.out.println("\nSemester GPA: "+grade+"\nTotal marks obtained: "+total_marks+"\nAverage Percentage: "+percentage);
        System.out.println("\nGrading Scale:\n\tA  = 85.0-100.0\n\tA- = 80.0-84.99\n\tB+ = 75.0-79.99\n\tB  = 70.0-74.99\n\tB- = 65.0-69.99\n\tC+ = 61.0-64.99\n\tC  = 58.0-60.99\n\tC- = 55.0-57.99\n\tD  = 50.0-54.99\n\tF  = 0.0-49.99");
    }
    private static String getString(float percentage) {
        String grade;
        if (percentage >=85.0f){ grade  = "A";
        } else if (percentage <85.0f && percentage >=80.0f){
            grade = "A-";
        } else if (percentage <80.0f && percentage >=75.0f) {
            grade = "B+";
        } else if (percentage <75.0f && percentage >=70.0f){
            grade = "B";
        } else if (percentage <70.0f && percentage >=65.0f) {
            grade = "B-";
        } else if (percentage <65.0f && percentage >=61.0f){
            grade = "C+";
        } else if (percentage <61.0f && percentage >=58.0f) {
            grade = "C";
        } else if (percentage <58.0f && percentage >=55.0f) {
            grade = "C-";
        } else if (percentage <55.0f && percentage >=50.0f) {
            grade = "D";
        } else {
            grade = "F";
        }
        return grade;
    }
}