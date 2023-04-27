import java.util.Random;

public class Visitor extends Thread {
    
    private Classroom[] classrooms;

    public Visitor(Classroom[] classrooms) {
        this.classrooms = classrooms;
    }

    public void start() {
        try {
            Random random = new Random();
            int randomIndex = random.nextInt(classrooms.length);
            Classroom classroom = classrooms[randomIndex];
            classroom.enterVisitor();
            //Thread.sleep(2000);
            //classroom.leaveVisitor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}