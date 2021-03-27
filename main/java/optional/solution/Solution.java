package optional.solution;

import lombok.Getter;
import lombok.ToString;
import optional.problem.Problem;
import optional.school.School;
import optional.student.Student;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Solution class to find a stable matching.
 */
@Getter
@ToString
public class Solution extends Problem {

    /**
     * constructor
     *
     * @param studentList        list of students
     * @param schoolList         list of schools
     * @param studentPreferences list of students' preferences
     * @param schoolPreferences  list of schools' preferences
     */
    public Solution(List<Student> studentList, List<School> schoolList, Map<Student, LinkedList<School>> studentPreferences, Map<School, LinkedList<Student>> schoolPreferences) {
        super(studentList, schoolList, studentPreferences, schoolPreferences);
    }

    /**
     * print the stable matching
     */
    public void printStableMatching() {
        Map<Student, School> map = new HashMap<>();
        for (Map.Entry<Student, LinkedList<School>> student : studentPreferences.entrySet()) {
            map.put(student.getKey(), null);
            searchBestOption(student.getKey(), student.getValue(), map);
        }
        displaySolution(map);
    }

    /**
     * looking for the most suitable school: a school of the student's preferences in which he ranks among the first
     *
     * @param student current student from printStableMatching method
     * @param schools list of student' preferences
     * @param map     update the school for student if a better option is found
     */
    private void searchBestOption(Student student, LinkedList<School> schools, Map<Student, School> map) {
        int min = Integer.MAX_VALUE;
        for (School school : schools) {
            int i = -1;
            for (Map.Entry<School, LinkedList<Student>> preference : schoolPreferences.entrySet()) {
                if (school == preference.getKey()) {
                    for (Student anotherStudent : preference.getValue()) {
                        i++;
                        if (student == anotherStudent && i < min && school.isNotFull()) {
                            min = i;
                            map.put(student, school);
                            break;
                        }
                    }
                    break;
                }
            }
        }
        updateCapacity(map);
    }

    /**
     * decreases a place in school's capacity for each appearance of that school
     *
     * @param map contain the stable matching
     */
    private void updateCapacity(Map<Student, School> map) {
        for (Map.Entry<Student, School> e : map.entrySet()) {
            e.getValue().addStudent();
        }
    }

    /**
     * print the stable matching
     *
     * @param map contain the stable matching
     */
    public void displaySolution(Map<Student, School> map) {
        System.out.println("The stable matching found is:");
        for (Map.Entry<Student, School> e : map.entrySet()) {
            System.out.println("Student " + e.getKey().getName() + " will go to school " + e.getValue().getName());
        }
    }

    /**
     * helpful getter for test
     *
     * @return map with the stable matching
     */
    public Map<String, String> getSolution() {
        Map<Student, School> map = new HashMap<>();
        for (Map.Entry<Student, LinkedList<School>> student : studentPreferences.entrySet()) {
            map.put(student.getKey(), new School());
            searchBestOption(student.getKey(), student.getValue(), map);
        }
        Map<String, String> sol = new HashMap<>();
        for (Map.Entry<Student, School> e : map.entrySet()) {
            sol.put(e.getKey().getName(), e.getValue().getName());
        }
        return sol;
    }
}
