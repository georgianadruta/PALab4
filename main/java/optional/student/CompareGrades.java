package optional.student;

import java.util.Comparator;

/**
 * helpful class to order the student list by grades in descending order for schoolPreferences map.
 */
public class CompareGrades implements Comparator<Student> {
    @Override
    public int compare(Student student, Student anotherStudent) {
        return -1*(student.getGrade()-anotherStudent.getGrade());
    }
}
