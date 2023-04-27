import java.util.Random;

public class Lecturer extends Thread {
    
    private String name;
    private Classroom[] classrooms;

    public Lecturer(String name, Classroom[] classrooms) {
        this.classrooms = classrooms;
    }

    public void start() {
        try {
            Random random = new Random();
            int randomIndex = random.nextInt(classrooms.length);
            Classroom classroom = classrooms[randomIndex];
            classroom.enterLecturer(name);
            classroom.startLecture();
            //Thread.sleep(2000);
            //classroom.leaveLecturer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}