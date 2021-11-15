import java.util.*;

public class CountingScoreBord implements ScoreBord{
    @Override
    public void sort(List<Student> studenten, int max) {
        int[] counter = new int[max + 1];  // Create new array full of zeroes.

        for (Student student : studenten) {
            counter[student.getScore()]++;
        }

        for (int i = 1; i <= max; i++){
            counter[i] = counter[i] + counter[i-1];
        }

        Student[] tempList = new Student[studenten.size()];
        for (int i = studenten.size() - 1; i >= 0; i--){
            tempList[counter[studenten.get(i).getScore()] - 1] = studenten.get(i);
            counter[studenten.get(i).getScore()]--;
        }

        for (int i = 0; i < studenten.size(); i++){
            studenten.set(i, tempList[i]);
        }
    }
}
