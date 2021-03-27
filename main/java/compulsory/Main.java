package compulsory;

import compulsory.school.CompareSchools;
import compulsory.school.School;
import compulsory.student.CompareStudents;
import compulsory.student.Student;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // create students using stream
        Student[] students = Stream.of("Gheorghe Ioana", "Vasile Ana", "Ion Alin", "Marin Andrei").map(Student::new).toArray(Student[]::new);
        System.out.println("Name students:");
        for (Student student : students)
            System.out.println(student+"\n");

        // create schools using stream
        School[] schools = Stream.of("C.N.S.H.", "C.N.C.H.", "C.N.A.E.").map(i -> new School(i, (int) (Math.random() * 100))).toArray(School[]::new);
        System.out.println("Name schools:");
        for (School school : schools)
            System.out.println(school+"\n");

        // student list
        List<Student> studentList = new LinkedList<>(Arrays.asList(students));
        studentList.sort(new CompareStudents());
        System.out.println("Sort student list by name: ");
        System.out.println(studentList+"\n");

        // school set
        Set<School> schoolSet = new TreeSet<>(new CompareSchools());
        schoolSet.add(schools[0]);
        schoolSet.add(schools[1]);
        schoolSet.add(schools[2]);
        System.out.println("Sort school list by name:");
        System.out.println(schoolSet+"\n");


        // Create two maps (having different implementations) describing the students and the school preferences and print them on the screen.
        // student preferences map
        Map<Student, LinkedList<String>> studentPreferences = new HashMap<>();
        studentPreferences.put(students[0], new LinkedList<>(Arrays.asList(schools[0].getName(), schools[1].getName(), schools[2].getName())));
        studentPreferences.put(students[1], new LinkedList<>(Arrays.asList(schools[0].getName(), schools[1].getName(), schools[2].getName())));
        studentPreferences.put(students[2], new LinkedList<>(Arrays.asList(schools[0].getName(), schools[1].getName())));
        studentPreferences.put(students[3], new LinkedList<>(Arrays.asList(schools[1].getName(), schools[2].getName())));
        System.out.println("The preferences for each student:");
        for (Map.Entry<Student, LinkedList<String>> preferences : studentPreferences.entrySet()) {
            System.out.println("The student " + preferences.getKey().getName() + " has the next preferences: " + preferences.getValue());
        }

        // school preferences map
        Map<String, LinkedList<String>> schoolPreferences = new TreeMap<>();
        schoolPreferences.put(schools[0].getName(),new LinkedList<>(Arrays.asList(students[3].getName(),students[0].getName(),students[1].getName(),students[2].getName())));
        schoolPreferences.put(schools[1].getName(),new LinkedList<>(Arrays.asList(students[0].getName(),students[1].getName(),students[2].getName())));
        schoolPreferences.put(schools[2].getName(),new LinkedList<>(Arrays.asList(students[0].getName(),students[1].getName(),students[3].getName())));
        System.out.println("\nThe preferences for each school:");
        for (Map.Entry<String, LinkedList<String>> preferences : schoolPreferences.entrySet()) {
            System.out.println("The preferences of the  " + preferences.getKey() + " school are: " + preferences.getValue());
        }
    }
}
