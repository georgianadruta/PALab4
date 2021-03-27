package compulsory.school;

import com.sun.istack.internal.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
/**
 * school class which contains a name of school and a number of available places (its capacity)
 * no setters because I don't want anyone to change the data of a school object after creating the object
 */
public class School {
    private final String name;
    private final int capacity;

    // constructors
    public School(@NotNull String name) {
        this.name = name;
        this.capacity = 0;
    }

    public School(@NotNull String name, int capacity) {
        this.name = name;
        this.capacity = Math.max(capacity, 0);
    }

}
