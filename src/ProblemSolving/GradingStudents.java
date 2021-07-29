package ProblemSolving;
/*
 * ketnakhalasi created on 7/29/21
 * */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GradingStudents {
    public static void main(String[] args) {
        int[] intArr = {73, 67, 38, 33};
        List<Integer> grades = new ArrayList<Integer>();
        for(int i : intArr) {
            grades.add(i);
        }
        System.out.println(gradeStudents(grades));
    }

    public static List<Integer> gradeStudents(List<Integer> grades) {
        List<Integer> updatedGrades = new ArrayList<>();
        for(int grade : grades) {

            if ((grade % 5) >= 3 && grade >= 38) {
                int gradeN = grade + (5 - (grade % 5));
                updatedGrades.add(gradeN);
            }
            else{
                updatedGrades.add(grade);
            }
        }
        return updatedGrades;
    }
}
