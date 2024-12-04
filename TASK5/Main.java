// CODSOFT NOVEMBER BATCH 2024
// JAVA PROGRAMMING
// Sehrish Kazmi
// TASK 5: Student Course Registration System
// Course Database: Store course information, including course code, title, description, capacity, and schedule.
// Student Database: Store student information, including student ID, name, and registered courses.
// Course Listing: Display available courses with details and available slots.
// Student Registration: Allow students to register for courses from the available options.
// Course Removal: Enable students to drop courses they have registered for.
import java.util.Scanner;
public class Main{ // default class
    public static void main(String[] args){ //entry point
        String name;
        int id;

        // Scanner to take user input
        Scanner cred = new Scanner(System.in);

        // Getting student's credentials
        System.out.println("Enter your Name:");
        name = cred.nextLine();
        System.out.println("Enter your registration id:");
        id = cred.nextInt();
        cred.nextLine(); // consume newline character

        //Student and Course DB objects created upon sign in to student portal
        Student_Database Stu1 = new Student_Database();
        Course_Database CourseDB = new Course_Database();

        //Setting credentials of the object in Student_Database
        Stu1.setCredentials(name,id);

        //Welcome message is displayed
        System.out.println("\nWelcome to Students Portal, "+Stu1.getName()+ " - "+Stu1.getID());

        boolean menu = true;

        //Main menu
        while(menu) {
            System.out.println("\nMAIN MENU");
            System.out.println("\n1. Display Course Catalogue" + //with the capacity...max is 40
                    "\n2. Display My Courses" + // my enrolled courses
                    "\n3. Enroll in Course" + //show available courses with remaining capacity
                    "\n4. Drop a Course" +  //show my courses and help me choose which to delete
                    "\n5. Exit Student Portal"); //exit the while loop
            System.out.println("Select an option: ");
            // User's choice
            int option = cred.nextInt();
            cred.nextLine();

            switch (option){
                case 1: //1. Access Course class to display
                    System.out.println("\nAll Courses:");
                    CourseDB.allCourses();
                    break;

                case 2: //2. Access Student class to display my courses
                    System.out.println("\nYour Enrolled Courses:");
                    Stu1.listCourses();
                    break;
                case 3: //3. Add course to Student class, enrolled_courses array, reduce capacity for that course in the Course database class
                    System.out.println("\nAvailable Courses:");
                    CourseDB.availableCourses();
                    System.out.println("Enter the course code to enroll:");
                    String courseCode = cred.nextLine();
                    CourseDB.enrollCourse(courseCode,Stu1); //enroll the student
                    break;

                case 4: // Drop a course
                    System.out.println("\nYour Enrolled Courses: ");
                    Stu1.listCourses(); // Displaying student's enrolled courses
                    System.out.println("Enter the course code to drop: ");
                    String courseCodeDrop = cred.nextLine();
                    CourseDB.removeFromCourse(courseCodeDrop, Stu1); // Remove from the course
                    break;
                case 5: //time to exit
                    System.out.println("Exiting the Student Portal. Goodbye!");
                    menu=false; // End the loop
                    break;

                default: // Invalid option
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        cred.close();
    }
}