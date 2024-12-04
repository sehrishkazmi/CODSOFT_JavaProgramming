import java.util.HashMap;
import java.util.Map;
public class Course_Database {
    private final HashMap<String, Integer> courseCatalog = new HashMap<>(); // final means course catalog cannot be assigning to a different hashmap

    //Constructor to initialize course database
    public Course_Database() {
        courseCatalog.put("CS370 Artificial Intelligence", 25);
        courseCatalog.put("EE353 Computer Networks", 33);
        courseCatalog.put("EE322 Wireless Networks", 26);
        courseCatalog.put("CS432 Information Security", 38);
        courseCatalog.put("CS381 Network Security", 40);
        courseCatalog.put("CS471 Machine Learning", 39);
        courseCatalog.put("CS474 Computer Vision", 28);
        courseCatalog.put("CS472 Natural Language Processing", 23);
        courseCatalog.put("EE430 Telecommunication Systems", 12);
        courseCatalog.put("EE433 Digital Image Processing", 15);
        courseCatalog.put("CS342 Mobile Computing", 21);
        courseCatalog.put("CS344 Web Engineering", 20);
        courseCatalog.put("CS361 Computer Graphics", 10);
        courseCatalog.put("CS364 Game Development", 37);
    }

    //list entire course catalog
    public void allCourses() {
        System.out.println("Course Catalogue: ");
        for (Map.Entry<String, Integer> entry : courseCatalog.entrySet()) {
            System.out.println(entry.getKey() + " | Capacity: " + entry.getValue() + "/40");
        }
    }

    //list available courses
    public void availableCourses() {
        System.out.println("Available Courses (Max Capacity: 40)");
        for (Map.Entry<String, Integer> entry : courseCatalog.entrySet()) {
            if (entry.getValue() < 40) {
                System.out.println(entry.getKey() + " | Remaining Slots: " + (40 - entry.getValue()));
            }
        }
    }

    //get added to course
    public void enrollCourse(String courseCode, Student_Database student) {
        for (String courseKey : courseCatalog.keySet()) { // going through course catalog
            if (courseKey.startsWith(courseCode)) { // finding course code match in the catalog
                if (student.getEnrolledCourses().contains(courseKey)){
                    System.out.println("You are already enrolled in "+courseKey);
                    return;
                }
                int currentCapacity = courseCatalog.get(courseKey); //get course's capacity
                if (currentCapacity < 40) { //check if there is capacity for 1 more student
                    courseCatalog.put(courseKey, currentCapacity + 1); //enroll student in course
                    student.addCourse(courseKey); // Adding course to student's enrolled list
                    System.out.println("Enrolled in " + courseKey);
                } else {
                    System.out.println("Course " + courseKey + " is full.");
                }
                return;
            }
        }
        System.out.println("Invalid Course Code.");
    }

    public void removeFromCourse(String courseCode, Student_Database student) {
        for (String courseKey : courseCatalog.keySet()) {
            if (courseKey.startsWith(courseCode)) {
                if (student.getEnrolledCourses().contains(courseKey)) {  // Check if the student is enrolled
                    int capacity = courseCatalog.get(courseKey);
                    courseCatalog.replace(courseKey, capacity - 1);  // Decrease course capacity
                    student.dropCourse(courseKey); // Remove course from student's enrolled list
                    System.out.println("You have been removed from " + courseCode);
                    return;  // Exit the loop once the course is found and processed
                }
            }
        }
        System.out.println("Invalid course code - not enrolled.");
    }
}