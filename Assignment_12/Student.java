package Assignment_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {
    int studentId;
    String studentName;
    int studentAge;
    String studentGender;
    String engDepartment;
    int yearOfEnrollment;
    double percentageTillDate;

    public Student(int studentId, String studentName, int studentAge, String studentGender, String engDepartment, int yearOfEnrollment, double percentageTillDate) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentGender = studentGender;
        this.engDepartment = engDepartment;
        this.yearOfEnrollment = yearOfEnrollment;
        this.percentageTillDate = percentageTillDate;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public String getEngDepartment() {
        return engDepartment;
    }

    public int getYearOfEnrollment() {
        return yearOfEnrollment;
    }

    public double getPercentageTillDate() {
        return percentageTillDate;
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        studentList.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        studentList.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        studentList.add(new Student(144, "Murali Gowda", 18, "Male","Electrical",2018,80));
        studentList.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        studentList.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        studentList.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        studentList.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        studentList.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        studentList.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        studentList.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        studentList.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        studentList.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        studentList.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        studentList.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        studentList.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        studentList.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));


//        1. Print the name of all departments in the college?
        System.out.println("Name of the departments : ");
        studentList.stream()
                .map(Student::getEngDepartment)
                .forEach(System.out::println);



//      2. Get the names of all students who have enrolled after 2018?
        System.out.println("\nStudents who enrolled after 2018 :");
        studentList.stream()
                .filter(year -> year.getYearOfEnrollment() > 2018)
                .map(Student::getStudentName)
                .forEach(System.out::println);



//      3. Get the details of all male student in the computer sci department
        System.out.println("\nDetails of all Male students in computer science");
        studentList.stream()
                .filter(a->a.studentGender.equalsIgnoreCase("male") && a.getEngDepartment().equalsIgnoreCase("computer science"))
                .map(Student::getStudentName)
                .forEach(System.out::println);



//        4.How many male and female student are there ? (HINT:use Collectors.groupingBy() for grouping based on gender)
//        System.out.println("\n");
        Map<String,List<Student>> gender = studentList.stream()
                .collect(Collectors.groupingBy(Student::getStudentGender));
        System.out.println("Male : "+gender.get("Male").size()+" Female : "+gender.get("Female").size());


        //
        Optional<Integer> totalMales = gender.get("Male").stream()
                .map(Student::getStudentAge)
                .reduce((a,b)->a+b);

    }
}
