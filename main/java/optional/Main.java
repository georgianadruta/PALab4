package optional;

import optional.data.ProblemData;
import optional.solution.Solution;

public class Main {
    public static void main(String[] args) {
        ProblemData data = new ProblemData();
        Solution sol = new Solution(data.getStudentList(), data.getSchoolList(), data.getStudentPreferences(), data.getSchoolPreferences());
        sol.displayStudAccepted(data.getSchoolList());
        sol.displaySchools(data.getStudents()[0]); // the schools that have a given student as their top preference.
        sol.displayStudentPreferences();
        sol.displaySchoolPreferences();
        sol.printStableMatching();
    }
}
