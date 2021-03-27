package bonus.problem;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import optional.school.School;
import optional.student.Student;

import java.util.*;

/**
 * Problem class contains problem data like
 * number of students, number of schools, lists of students and schools and matrix of preferences.
 * Matrix of preferences:
 * Each student from studentList has a corresponding line in the matrix with the same index from the list. (0...numberStudents)
 * The line contains the student's preferences, the indexes of the schools from schoolList in the
 * order of preferences and -1 for filling in the matrix.
 * And the remaining lines are for schools following the same principle (numberStudents...numberStudents+numberSchools)
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Problem {
    protected int numberStudents;
    protected int numberSchools;
    protected List<Student> studentList;
    protected List<School> schoolList;
    protected int[][] preferences;

    /**
     * constructor
     *
     * @param studentList        list of students
     * @param schoolList         list of schools
     * @param studentPreferences school order for each student
     * @param schoolPreferences  student order for each school
     */
    public Problem(List<Student> studentList, List<School> schoolList, Map<Student, LinkedList<School>> studentPreferences, Map<School, LinkedList<Student>> schoolPreferences) {
        this.numberStudents = studentList.size();
        this.numberSchools = schoolList.size();
        this.studentList = studentList;
        this.schoolList = schoolList;
        createPreferenceMatrix(studentPreferences, schoolPreferences);
    }

    /**
     * create matrix of preferences
     *
     * @param studentPreferences school order for each student
     * @param schoolPreferences  student order for each school
     */
    private void createPreferenceMatrix(Map<Student, LinkedList<School>> studentPreferences, Map<School, LinkedList<Student>> schoolPreferences) {
        this.preferences = new int[numberStudents + numberSchools][Math.max(numberSchools, numberStudents)];
        for (int i = 0; i < numberStudents + numberSchools; i++)
            for (int j = 0; j < Math.max(numberSchools, numberStudents); j++) {
                preferences[i][j] = -1;
            }
        addStudentPref(studentPreferences);
        addSchoolPref(schoolPreferences);
    }

    /**
     * Each student from studentList has a corresponding line in the matrix with the same index from the list. (0...numberStudents)
     * The line contains the student's preferences, the indexes of the schools from schoolList in the
     * order of preferences and -1 for filling in the matrix.
     *
     * @param studentPreferences school order for each student
     */
    private void addStudentPref(Map<Student, LinkedList<School>> studentPreferences) {
        int i = -1;
        for (Map.Entry<Student, LinkedList<School>> e : studentPreferences.entrySet()) {
            i++;
            int j = 0;
            for (School s : e.getValue()) {
                for (int k = 0; k < schoolList.size(); k++) {
                    if (s == schoolList.get(k)) {
                        preferences[i][j] = k;
                        j++;
                        break;
                    }
                }
            }
        }
    }

    /**
     * Each school from schoolList has a corresponding line in the matrix with index=numberStudents+i,
     * where i is the index from the list. (numberStudents...numberStudents+numberSchools)
     * The line contains the school's preferences, the indexes of the students from studentList in
     * order of preferences and -1 for filling in the matrix.
     *
     * @param schoolPreferences student order for each school
     */
    private void addSchoolPref(Map<School, LinkedList<Student>> schoolPreferences) {
        int i = numberStudents - 1;
        for (Map.Entry<School, LinkedList<Student>> e : schoolPreferences.entrySet()) {
            i++;
            int j = 0;
            for (Student s : e.getValue()) {
                for (int k = 0; k < studentList.size(); k++) {
                    if (s == studentList.get(k)) {
                        preferences[i][j] = k;
                        j++;
                        break;
                    }
                }
            }
        }
    }

    /**
     * display matrix of preferences
     */
    public void displayPreferenceMatrix() {
        for (int a = 0; a < numberSchools + numberStudents; a++) {
            for (int b = 0; b < Math.max(numberSchools, numberStudents); b++)
                System.out.print(preferences[a][b] + " ");
            System.out.println();
        }
    }
}
