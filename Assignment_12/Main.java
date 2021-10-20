package Assignment_12;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

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
                .distinct()
                .forEach(System.out::println);


//      2. Get the names of all students who have enrolled after 2018?
        System.out.println("\nStudents who enrolled after 2018 :");
        List<String> studentNames = studentList.stream()
                .filter(a->a.getYearOfEnrollment() > 2018)
                .map(Student::getStudentName)
                .collect(Collectors.toList());
        studentNames.forEach(System.out::println);


//      3. Get the details of all male student in the computer sci department
        System.out.println("\nDetails of all Male students in computer science");
        Stream<Student> studentDetails = studentList.stream()
                .filter(a->a.getStudentGender().equalsIgnoreCase("male"));
        studentDetails.map(Student::getStudentName)
                .forEach(System.out::println);



//        4.How many male and female student are there ? (HINT:use Collectors.groupingBy() for grouping based on gender)
        System.out.println("\nTotal number of males and females are : ");
        Map<String,List<Student>> gender = studentList.stream().collect(Collectors.groupingBy(Student::getStudentGender));
        System.out.println("Male : "+gender.get("Male").size()+", Female : "+gender.get("Female").size());


//     5.What is the average age of male and female students
        System.out.println("\nThe Average of ages based on genders");
        OptionalDouble maleAverage = gender.get("Male")
                .stream()
                .mapToDouble(a->a.studentAge)
                .average();
        OptionalDouble femaleAverage = gender.get("Female")
                .stream()
                .mapToDouble(a->a.studentAge)
                .average();
        System.out.println("Avg age of Male : "+maleAverage.getAsDouble()+", Avg age of Female : "+femaleAverage.getAsDouble());



//      6. Get the details of  highest percentage
        OptionalDouble studentWithHighPercentage = studentList.stream()
                .mapToDouble(Student::getPercentageTillDate)
                .max();
        System.out.println("Highest percentage is : "+studentWithHighPercentage.getAsDouble());


//        7.Count the number of students in each department?
        System.out.println("count of students in each dept : ");
        Map<String,List<Student>> noOfStudentsDept = studentList.stream().collect(Collectors.groupingBy(Student::getEngDepartment));
        for(String dept : noOfStudentsDept.keySet()){
            System.out.println(dept+" : "+noOfStudentsDept.get(dept).size());

        }

//      8. What is the average percentage achieved in each department?
        System.out.println("Average percentage of each department : ");
        for (String dept : noOfStudentsDept.keySet()){
            System.out.println(dept+" : "+noOfStudentsDept.get(dept).stream().mapToDouble(Student::getPercentageTillDate).average().getAsDouble());
        }

//      9.Get the details of youngest male student in the Electronic department?
        System.out.println("\nThe youngest male student in Electronic department is : ");
        Optional<Student> youngestStudent = studentList.stream()
                .filter(a->a.getStudentGender().equalsIgnoreCase("Male"))
                .filter(a->a.getEngDepartment().equalsIgnoreCase("Electronic"))
                .min((a,b)->a.getStudentAge()>b.getStudentAge()?1:-1);
        youngestStudent.stream().map(Student::getStudentName).forEach(System.out::println);



//      10.How many male and female students are there in the computer science department?
        System.out.print("\nTotal no. of ");
        Map<String,List<Student>> maleFemaleCse = studentList
                .stream()
                .filter(a -> a.getEngDepartment().equals("Computer Science"))
                .collect(Collectors.groupingBy(Student::getStudentGender));
        System.out.println("Males : "+maleFemaleCse.get("Male").stream().count()+", Females : "+maleFemaleCse.get("Female").stream().count());
    }
}
