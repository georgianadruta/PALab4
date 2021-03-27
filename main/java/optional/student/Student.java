package optional.student;

import com.sun.istack.internal.NotNull;
import lombok.*;

 /**
 * student class which contains student's name
 */
@Data
public class Student {
    private String name;
    private int grade;

    public Student(@NotNull String name, int grade) {
        this.name = name;
        if (grade > 0)
            this.grade = grade;
        else
            System.err.println("Invalid grade.");
    }
}
