package compulsory.school;

import java.util.Comparator;

/**
 * a helpful class for the sort schools by name
 */
public class CompareSchools implements Comparator<School> {
    @Override
    public int compare(School school, School anotherSchool) {
        return school.getName().compareTo(anotherSchool.getName());
    }
}
