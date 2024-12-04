import java.util.ArrayList;
public class Student_Database{
    private int id;
    private String name;
    private final ArrayList<String> enrolled_courses;

    //Constructor
    public Student_Database(){
        enrolled_courses = new ArrayList<>();
    }

    //Setting student credentials
    public void setCredentials(String name, int id){
        this.name = name;
        this.id = id;
    }

    //Printing name
    public String getName(){
        return name;
    }
    //Printing id
    public int getID(){
        return id;
    }
    public void addCourse(String courseName){
        if (!courseName.equals("null")){
            if (!enrolled_courses.contains(courseName)){
                enrolled_courses.add(courseName);
                System.out.println("You have been enrolled in "+ courseName);
            } else {
                System.out.println("You are already enrolled in "+courseName);
            }

        } else {
            System.out.println("Invalid Course.");
        }
    }
    public void dropCourse(String courseName){
        if (enrolled_courses.contains(courseName)) {
            enrolled_courses.remove(courseName); // Remove course from the list
            System.out.println("You have been unenrolled from " + courseName);
        } else {
            System.out.println("You are not enrolled in " + courseName);
        }
    }
    public void listCourses(){
        if (enrolled_courses.isEmpty()){
            System.out.println("You are not enrolled in any courses.");
        } else {
            System.out.println("Your Enrolled Courses:\n");
            for (String myCourse : enrolled_courses){
                System.out.println(myCourse);
            }
        }
    }
    public ArrayList<String> getEnrolledCourses() {
        return enrolled_courses;
    }
}