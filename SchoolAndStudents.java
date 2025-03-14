import java.util.ArrayList;
import java.util.List;

class Course {
    private String name;
    private List<Student> enrolledStudents;

    public Course(String name) {
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            student.addCourse(this); // Ensure bidirectional association
        }
    }

    public void listEnrolledStudents() {
        System.out.println("Students enrolled in " + name + ":");
        for (Student student : enrolledStudents) {
            System.out.println(" - " + student.getName());
        }
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void listEnrolledCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println(" - " + course.getName());
        }
    }
}

class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void listStudents() {
        System.out.println("Students in " + name + ":");
        for (Student student : students) {
            System.out.println(" - " + student.getName());
        }
    }
}

public class SchoolAndStudents {
    public static void main(String[] args) {
        School school = new School("Greenwood High");

        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        Course math = new Course("Math");
        Course science = new Course("Science");

        school.addStudent(alice);
        school.addStudent(bob);

        math.enrollStudent(alice);
        math.enrollStudent(bob);
        science.enrollStudent(alice);

        school.listStudents();
        alice.listEnrolledCourses();
        bob.listEnrolledCourses();

        math.listEnrolledStudents();
        science.listEnrolledStudents();
    }
}
