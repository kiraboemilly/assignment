import java.util.concurrent.Semaphore;

public class Classroom {

    private final String classroomName;
    private String lecturerName = "";
    private static final int MAX_VISITORS = 5;
    private final int max_students;
    private boolean lecturerPresent;
    private int numStudentsInside;
    private int numVisitorsInside;
    private Semaphore studentSemaphore;
    private Semaphore visitorSemaphore;
    private Semaphore lecturerSemaphore;
    

    public Classroom(String classroomName, int capacity) {
        this.classroomName = classroomName;
        max_students = capacity - MAX_VISITORS;
        studentSemaphore = new Semaphore(max_students);
        visitorSemaphore = new Semaphore(MAX_VISITORS);
        lecturerSemaphore = new Semaphore(1);
        lecturerPresent = false;
        numStudentsInside = 0;
        numVisitorsInside = 0;
    }

    public boolean isLecturerPresent() {
        return lecturerPresent;
    }

    public String getClassroomName(){
        return classroomName;
    }

    public int getNumStudentsInside(){
        return numStudentsInside;
    }

    public int getNumVisitorsInside(){
        return numVisitorsInside;
    }

    public String getLecturerName(){
        return lecturerName;
    }

    public void enterStudent() throws InterruptedException {
        studentSemaphore.acquire();
        synchronized (this) {
            while (lecturerPresent || numStudentsInside == max_students) {
                wait();
            }
            numStudentsInside++;
        }
    }

    public void leaveStudent() throws InterruptedException  {
        synchronized (this) {
            while (lecturerPresent) {
                wait();
            }
            numStudentsInside--;
            notifyAll();
        }
        studentSemaphore.release();
    }

    public void enterVisitor() throws InterruptedException {
        visitorSemaphore.acquire();
        synchronized (this) {
            while (lecturerPresent || numVisitorsInside == MAX_VISITORS) {
                wait();
            }
            numVisitorsInside++;
        }
    }

    public void leaveVisitor() {
        synchronized (this) {
            numVisitorsInside--;
            notifyAll();
        }
        visitorSemaphore.release();
    }

    public void enterLecturer(String name) throws InterruptedException {
        lecturerSemaphore.acquire();
        synchronized (this) {
            while (!lecturerPresent) {
                wait();
            }
            lecturerPresent = true;
            lecturerName = name;
        }
    }

    public void startLecture() throws InterruptedException {
        // Lecture is conducted
        Thread.sleep(5000);
    }

    public void leaveLecturer() {
        synchronized (this) {
            lecturerPresent = false;
            notifyAll();
        }
        lecturerSemaphore.release();
    }
}
