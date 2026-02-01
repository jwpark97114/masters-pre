import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class Student{
    String name;
    String studentID;
    String major;
    int korean = -1;
    int math = -1;
    int english = -1;
    int subjectCount = 0;

    public Student(String studentName, String studentIDNumber, String majorSubject, int scoreKorean, int scoreMath,int scoreEnglish){
        this.name = studentName;
        this.studentID=studentIDNumber;
        this.major=majorSubject;
        this.korean=scoreKorean;
        this.math=scoreMath;
        this.english=scoreEnglish;

        if (this.korean != -1){
            this.subjectCount++;
        }
        if (this.math != -1){
            this.subjectCount++;
        }
        if (this.english != -1){
            this.subjectCount++;
        }
    }

    private int scoreSum(){
        int sum = 0;
        if (this.korean != -1) {
            sum += this.korean;
        }
        if (this.math != -1) {
            sum += this.math;
        }
        if (this.english != -1) {
            sum += this.english;
        }
        return sum;
    }

    public void printReport(){

        System.out.printf(this.name + " 학생은 %d 과목을 수강했습니다.\n",this.subjectCount);
        System.out.printf("총점은 %d 점이고 평균은 %.2f 점입니다.\n", this.scoreSum(), this.scoreSum() / (float)this.subjectCount);

    }
}

class School{
    ArrayList<Student> students = new ArrayList<Student>();

    public School(String dir){
        try(BufferedReader studentLoader = new BufferedReader(new FileReader(dir + "input.txt"))){
            String tmp;
            while((tmp = studentLoader.readLine()) != null){
                String[] studentInfo = tmp.split(",");
                String name = studentInfo[0];
                String id = studentInfo[1];
                String major = studentInfo[2];
                int[] scores = {-1,-1,-1};
                for(int i =0; i < studentInfo.length-3; i ++){
                    scores[i] = Integer.parseInt(studentInfo[3+i]);
                }
                students.add(new Student(name,id,major,scores[0],scores[1],scores[2]));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void studentReports(){
        for(Student student : this.students){
            student.printReport();
        }
    }


}

public class N2 {
    public static void main(String[] args) {
        School newSchool = new School("");
        newSchool.studentReports();
        System.out.println("");
    }
}
