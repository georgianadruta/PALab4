package optional;

import optional.school.School;
import optional.solution.Solution;
import optional.student.CompareGrades;
import optional.student.CompareNames;
import optional.student.Student;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    private Solution sol;
    private Student[] students;
    private School[] schools;
    private List<Student> studentList;
    private List<School> schoolList;
    private Map<Student, LinkedList<School>> studentPreferences;
    private Map<School, LinkedList<Student>> schoolPreferences;

    /**
     * helpful method to create the student list
     *
     * @param student list of students
     */
    private void createStudentList(Student... student) {
        this.students = new Student[student.length];
        System.arraycopy(student, 0, this.students, 0, student.length);
        this.studentList = new LinkedList<>(Arrays.asList(students));
    }

    /**
     * helpful method to create the school list
     *
     * @param school list of schools
     */
    private void createSchoolList(School... school) {
        this.schools = new School[school.length];
        System.arraycopy(school, 0, this.schools, 0, school.length);
        this.schoolList = new LinkedList<>(Arrays.asList(schools));
    }

    /**
     * helpful method to create the student preferences list
     *
     * @param pref list of preferences
     */
    private void createStudentPreferences(LinkedList... pref) {
        this.studentPreferences = new TreeMap<>(new CompareNames());
        for (int i = 0; i < pref.length; i++) {
            this.studentPreferences.put(students[i], pref[i]);
        }
    }

    /**
     * helpful method to create the school preferences list
     *
     * @param pref list of preferences
     */
    private void createSchoolPreferences(LinkedList... pref) {
        this.schoolPreferences = new HashMap<>();
        for (int i = 0; i < pref.length; i++) {
            LinkedList<Student> list = pref[i];
            list.sort(new CompareGrades());
            this.schoolPreferences.put(schools[i], list);
        }
    }

    // TEST 1

    /**
     * constructor for C.N.S.H. is full case
     */
    private void createCNSHIsFull() {
        createStudentList(new Student("Vasile Ana", 10), new Student("Marin Alina", 6), new Student("Ilie David", 8), new Student("Gheorghe Alex", 9));
        createSchoolList(new School("C.N.S.H.", 0), new School("C.N.C.H.", 8), new School("C.N.A.E.", 10));
        createStudentPreferences(new LinkedList<>(Arrays.asList(schools[0], schools[1], schools[2])), new LinkedList<>(Arrays.asList(schools[0], schools[1], schools[2])), new LinkedList<>(Arrays.asList(schools[0], schools[1])), new LinkedList<>(Arrays.asList(schools[0], schools[2])));
        createSchoolPreferences(new LinkedList<>(Arrays.asList(students[0], students[1], students[2], students[3])), new LinkedList<>(Arrays.asList(students[0], students[1], students[2])), new LinkedList<>(Arrays.asList(students[1], students[3], students[0])));
    }

    /**
     * create solution for C.N.S.H. is full case
     *
     * @return the solution
     */
    private Map<String, String> solutionForCNSHIsFull() {
        Map<String, String> map = new HashMap<>();
        map.put(this.students[0].getName(), this.schools[1].getName());
        map.put(this.students[1].getName(), this.schools[1].getName());
        map.put(this.students[2].getName(), this.schools[1].getName());
        map.put(this.students[3].getName(), this.schools[2].getName());
        return map;
    }

    /**
     * test for C.N.S.H. is full case
     */
    @Test
    public void testForCNSHIsFull() {
        createCNSHIsFull();
        this.sol = new Solution(this.studentList, this.schoolList, this.studentPreferences, this.schoolPreferences);
        assertEquals(solutionForCNSHIsFull(), sol.getSolution());
    }


    // TEST 2

    /**
     * constructor for C.N.S.H. is full and C.N.C.H. has only one place case
     */
    private void createCNSHIsFullCNCHHasOnlyOnePlace() {
        createStudentList(new Student("Vasile Ana", 10), new Student("Marin Alina", 6), new Student("Ilie David", 8), new Student("Gheorghe Alex", 9));
        createSchoolList(new School("C.N.S.H.", 0), new School("C.N.C.H.", 1), new School("C.N.A.E.", 10));
        createStudentPreferences(new LinkedList<>(Arrays.asList(schools[0], schools[1], schools[2])), new LinkedList<>(Arrays.asList(schools[0], schools[1], schools[2])), new LinkedList<>(Arrays.asList(schools[0], schools[1])), new LinkedList<>(Arrays.asList(schools[0], schools[2])));
        createSchoolPreferences(new LinkedList<>(Arrays.asList(students[3], students[0], students[1], students[2])), new LinkedList<>(Arrays.asList(students[0], students[2], students[1])), new LinkedList<>(Arrays.asList(students[0], students[1], students[3])));
    }

    /**
     * solution for C.N.S.H. is full and C.N.C.H. has only one place case
     * @return solution
     */
    private Map<String, String> solutionForCNSHIsFullCNCHHasOnlyOnePlace() {
        Map<String, String> map = new HashMap<>();
        map.put(this.students[0].getName(), this.schools[2].getName());
        map.put(this.students[1].getName(), this.schools[2].getName());
        map.put(this.students[2].getName(), this.schools[1].getName());
        map.put(this.students[3].getName(), this.schools[2].getName());
        return map;
    }

    /**
     * test for C.N.S.H. is full and C.N.C.H. has only one place case
     */
    @Test
    public void testForCNSHIsFullCNCHHasOnlyOnePlace() {
        createCNSHIsFullCNCHHasOnlyOnePlace();
        this.sol = new Solution(this.studentList, this.schoolList, this.studentPreferences, this.schoolPreferences);
        assertEquals(solutionForCNSHIsFullCNCHHasOnlyOnePlace(), sol.getSolution(), "Should work");
    }

    // TEST 3

    /**
     * constructor for just C.N.A.E. is not full case
     */
    private void createCNAEIsNotFull() {
        createStudentList(new Student("Vasile Ana", 10), new Student("Marin Alina", 6), new Student("Ilie David", 8), new Student("Gheorghe Alex", 9));
        createSchoolList(new School("C.N.S.H.", 0), new School("C.N.C.H.", 0), new School("C.N.A.E.", 10));
        createStudentPreferences(new LinkedList<>(Arrays.asList(schools[0], schools[1], schools[2])), new LinkedList<>(Arrays.asList(schools[0], schools[1], schools[2])), new LinkedList<>(Arrays.asList(schools[0], schools[1])), new LinkedList<>(Arrays.asList(schools[0], schools[2])));
        createSchoolPreferences(new LinkedList<>(Arrays.asList(students[3], students[0], students[1], students[2])), new LinkedList<>(Arrays.asList(students[0], students[2], students[1])), new LinkedList<>(Arrays.asList(students[0], students[1], students[3])));
    }

    /**
     * solution for just C.N.A.E. is not full case
     * @return solution
     */
    private Map<String, String> solutionForCNAEIsNotFull() {
        Map<String, String> map = new HashMap<>();
        map.put(this.students[0].getName(), this.schools[2].getName());
        map.put(this.students[1].getName(), this.schools[2].getName());
        map.put(this.students[2].getName(), null);
        map.put(this.students[3].getName(), this.schools[2].getName());
        return map;
    }

    /**
     * test for just C.N.A.E. is not full case
     */
    @Test
    public void testForCNAEIsNotFull() {
        createCNAEIsNotFull();
        this.sol = new Solution(this.studentList, this.schoolList, this.studentPreferences, this.schoolPreferences);
        assertEquals(solutionForCNAEIsNotFull(), sol.getSolution(),
                "Should work");
    }
}
