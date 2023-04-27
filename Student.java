import java.util.Random;

public class Student extends Thread {
    
    private Classroom[] classrooms;

    public Student(Classroom[] classrooms) {
        this.classrooms = classrooms;
    }

    public void start() {
        try {
            Random random = new Random();
            int randomIndex = random.nextInt(classrooms.length);
            Classroom classroom = classrooms[randomIndex];
            classroom.enterStudent();
            //Thread.sleep(2000);
            //classroom.leaveStudent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}