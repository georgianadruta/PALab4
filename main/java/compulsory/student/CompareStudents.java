package compulsory.student;

import java.util.Comparator;

/**
 * a helpful class for the sort students by name
 */
public class CompareStudents implements Comparator<Student> {
    @Override
    public int compare(Student student, Student anotherStudent) {
        return student.getName().compareTo(anotherStudent.getName());
    }
}
