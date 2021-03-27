package optional.problem;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import optional.school.School;
import optional.student.Student;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Problem class contains problem data like
 * lists of students and schools and lists of students' preferences and school's preferences.
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Problem {
    protected List<Student> studentList;
    protected List<School> schoolList;
    protected Map<Student, LinkedList<School>> studentPreferences;
    protected Map<School, LinkedList<Student>> schoolPreferences;

    /**
     * constructor
     *
     * @param studentList        list of students
     * @param schoolList         list of schools
     * @param studentPreferences list of students' preferences
     * @param schoolPreferences  list of schools' preferences
     */
    public Problem(List<Student> studentList, List<School> schoolList, Map<Student, LinkedList<School>> studentPreferences, Map<School, LinkedList<Student>> schoolPreferences) {
        this.studentList = studentList;
        this.schoolList = schoolList;
        this.studentPreferences = studentPreferences;
        this.schoolPreferences = schoolPreferences;
    }

    /**
     * display list of students
     */
    public void displayStudentList() {
        System.out.println("\nStudent list:");
        studentList.stream()
                .map(Student::getName)
                .forEach(System.out::println);
    }

    /**
     * display list of schools
     */
    public void displaySchoolList() {
        System.out.println("\nSchool list:");
        schoolList.stream()
                .map(School::getName)
                .forEach(System.out::println);
    }

    /**
     * display list of students' preferences
     */
    public void displayStudentPreferences() {
        System.out.println("\nStudent preferences map: ");
        for (Map.Entry<Student, LinkedList<School>> e : studentPreferences.entrySet()) {
            System.out.print(e.getKey().getName() + ": ");
            for (School school : e.getValue())
                System.out.print(school.getName() + " ");
            System.out.println();
        }
    }

    /**
     * display list of schools' preferences
     */
    public void displaySchoolPreferences() {
        System.out.println("\nSchool preferences map: ");
        for (Map.Entry<School, LinkedList<Student>> e : schoolPreferences.entrySet()) {
            System.out.print(e.getKey().getName() + ": ");
            for (Student student : e.getValue())
                System.out.print(student.getName() + ", ");
            System.out.println();
        }
        System.out.println();
    }

    /**
     * display the students who find acceptable a given list of schools
     * @param schools list of schools
     */
    public void displayStudAccepted(List<School> schools) {
        List<Student> result = this.studentList.stream()
                .filter(std -> this.studentPreferences.get(std).containsAll(schools))
                .collect(Collectors.toList());
        System.out.println("\nStudents who find acceptable of " + schools + ": " + result);
    }

    /**
     * display the schools that have a given student as their top preference
     * @param student list of students
     */
    public void displaySchools(Student student) {
        List<School> res = this.schoolList.stream()
                .filter(e -> this.schoolPreferences.get(e).get(0).getName().equals(student.getName()))
                .collect(Collectors.toList());
        System.out.println("\nSchools that have the student " + student.getName() + " as their top preference: " + res);
    }
}