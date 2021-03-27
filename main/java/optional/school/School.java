package optional.school;

import com.sun.istack.internal.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * school class which contains a name of school and a number of available places (its capacity)
 * no setters because I don't want anyone to change the data of a school object after creating the object
 */
@Getter
@ToString
@EqualsAndHashCode
public class School implements Comparable<School> {
    private String name;
    private int capacity;

    // constructors
    public School(@NotNull String name) {
        this.name = name;
        this.capacity = 0;
    }

    public School(@NotNull String name, int capacity) {
        this.name = name;
        this.capacity = Math.max(capacity, 0);
    }

    public School(){

    }
    /**
     * checks if the school has remaining places
     * @return true if capacity>0, else false
     */
    public boolean isNotFull() {
        return this.capacity>0;
    }

    /**
     * decreases a place in capacity because the school has accepted a new student
     */
    public void addStudent(){
        this.capacity--;
    }

    /**
     * compare by capacity
     * @param other the other school to compare with
     * @return 0 if this.capacity=other.capacity, >0 if this.capacity>other.capacity else -1
     */
    @Override
    public int compareTo(School other) {
        return this.getCapacity() - other.getCapacity();
    }
}
