package bonus.solution;

import bonus.problem.Problem;
import optional.school.School;
import optional.student.Student;

import java.util.*;

/**
 * use Gale–Shapley algorithm in order to find a stable matching.
 */
public class Solution extends Problem {
    public Solution(List<Student> studentList, List<School> schoolList, Map<Student, LinkedList<School>> studentPreferences, Map<School, LinkedList<Student>> schoolPreferences) {
        super(studentList, schoolList, studentPreferences, schoolPreferences);
    }

    /**
     * Prints stable matching
     * Note that the students numbers between 0 and numberStudents and
     * the schools numbers between numberStudents and schoolStudents.
     * Go through the lines corresponding to the students and find out the ranking of the students
     * according to the lines corresponding to the schools
     */
    public void searchStableMatching() {
        Map<Student, LinkedList<School>> rank = new HashMap<>();
        for (int i = 0; i < numberStudents; i++) {
            List<School> schools = new LinkedList<>();
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < numberSchools; j++) {
                if (preferences[i][j] > -1) {
                    for (int p = 0; p < numberStudents; p++)
                        if (preferences[numberStudents + preferences[i][j]][p] == i && schoolList.get(preferences[i][j]).isNotFull()) {
                            if (p < min) {
                                ((LinkedList<School>) schools).addFirst(schoolList.get(preferences[i][j]));
                                min = p;
                            } else {
                                ((LinkedList<School>) schools).addLast(schoolList.get(preferences[i][j]));
                            }
                        }
                }
            }
            rank.put(studentList.get(i), (LinkedList<School>) schools);
        }
        printSolution(rank);
    }

    /**
     * Displays the lists of students with the school they accepted, then the other best options from left to right
     * @param rank sorted list of schools for each student according to the preferences
     */
    private void printSolution(Map<Student, LinkedList<School>> rank) {
        for (Map.Entry<Student, LinkedList<School>> e : rank.entrySet()) {
            System.out.print("\n Student " + e.getKey().getName() + " : " + e.getValue().get(0).getName()+"  ");
            System.out.print("[ ");
            for (School s : e.getValue()) {
                if (e.getValue().get(0) != s)
                    System.out.print(s.getName() + " ");
            }
            System.out.print("]");
        }
    }
}
