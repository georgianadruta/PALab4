package bonus.data;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import optional.school.School;
import optional.student.CompareGrades;
import optional.student.CompareNames;
import optional.student.Student;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Data
@ToString
@EqualsAndHashCode
public class ProblemData {
    private Student[] students;
    private School[] schools;
    private List<Student> studentList;
    private List<School> schoolList;
    private Map<Student, LinkedList<School>> studentPreferences;
    private Map<School, LinkedList<Student>> schoolPreferences;

    public ProblemData() {
        createStudentList();
        createSchoolList();
        createStudentPreferences();
        createSchoolPreferences();
    }

    /**
     * create students using stream
     */
    private void createStudentList() {
        Faker faker = new Faker();
        this.students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student(faker.name().fullName(), 5 + (int) (Math.random() * 6)))
                .toArray(Student[]::new);
        this.studentList = new LinkedList<>(Arrays.asList(students));
    }

    /**
     * create schools using stream
     */
    private void createSchoolList() {
        Faker faker = new Faker();
        this.schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School(faker.university().name(), (int) (Math.random() * 100)))
                .toArray(School[]::new);
        this.schoolList = new LinkedList<>(Arrays.asList(schools));
    }


    /**
     * create student preferences map
     */
    private void createStudentPreferences() {
        this.studentPreferences = new TreeMap<>(new CompareNames());
        this.studentPreferences.put(students[0], new LinkedList<>(Arrays.asList(schools[0], schools[1], schools[2])));
        this.studentPreferences.put(students[1], new LinkedList<>(Arrays.asList(schools[0], schools[1], schools[2])));
        this.studentPreferences.put(students[2], new LinkedList<>(Arrays.asList(schools[0], schools[1])));
        this.studentPreferences.put(students[3], new LinkedList<>(Arrays.asList(schools[0], schools[2])));
    }

    /**
     * create school preferences map
     */
    private void createSchoolPreferences() {
        this.schoolPreferences = new TreeMap<>();
        LinkedList<Student> list = new LinkedList<>(Arrays.asList(students[3], students[0], students[1], students[2]));
        list.sort(new CompareGrades()); // rank the students based on grades
        this.schoolPreferences.put(schools[0], list);
        list = new LinkedList<>(Arrays.asList(students[0], students[2], students[1]));
        list.sort(new CompareNames()); // rank the students based on names
        this.schoolPreferences.put(schools[1], list);
        list = new LinkedList<>(Arrays.asList(students[0], students[1], students[3]));
        list.sort(new CompareGrades()); // rank the students based on grades
        this.schoolPreferences.put(schools[2], list);
    }
}
