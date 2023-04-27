import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Monitor extends Thread {
    
    private Classroom[] classrooms;

    public Monitor(Classroom[] classrooms) {
        this.classrooms = classrooms;
    }

    public void start() {
        System.out.printf("Classroom Lecturer InSession Students Visitors");
        while (true) {
            for (int i = 0; i < classrooms.length; i++) {
                Classroom classroom = classrooms[i];
                System.out.println(getClassroomStatus(classroom));
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String getClassroomStatus(Classroom classroom) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d10s", classroom.getClassroomName()));
        sb.append(String.format("%d9s", classroom.getLecturerName()));
        if (classroom.isLecturerPresent()) {
            sb.append(String.format("%d10s", "True"));
        }
        else {
            sb.append(String.format("%d10s", "False"));
        }
        sb.append(String.format("%d9s", classroom.getNumStudentsInside()));
        sb.append(String.format("%d8s", classroom.getNumVisitorsInside()));
        return sb.toString();
    }
}