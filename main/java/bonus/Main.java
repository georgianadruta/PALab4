package bonus;

import bonus.data.ProblemData;
import bonus.solution.Solution;

public class Main {
    public static void main(String[] args) {
        ProblemData data=new ProblemData();
        Solution sol = new Solution(data.getStudentList(),data.getSchoolList(),data.getStudentPreferences(),data.getSchoolPreferences());
        sol.searchStableMatching();
    }
}
