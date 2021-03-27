package compulsory.student;

import com.sun.istack.internal.NotNull;
import lombok.*;

@Data
/**
 * student class which contains student's name
 */
public class Student {
    private String name;

    public Student(@NotNull String name) {
        this.name = name;
    }
}
