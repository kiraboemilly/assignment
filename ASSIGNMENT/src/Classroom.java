import java.util.concurrent.Semaphore;
/**
 * Student Name: Emilly Kirabo
 * Student Number: 3108102
 */
public class Classroom {
	private String className;
	private int capacity;
	private Semaphore lecturerSem = new Semaphore(1);
	private Semaphore capacitySem = new Semaphore(capacity);
	private boolean inSession;
	private String lecturer;
	private int studentInClass = 0;
	private int visitorsInClass = 0;

	public Classroom(String className, int capacity) {
		this.className = className;
		this.capacity = capacity;
	}
	public boolean getInSession() {
		if (lecturerSem.availablePermits() < 1) {
			return inSession = true;
		}
		return inSession;
	}
	public boolean isFull() {
		return studentInClass + visitorsInClass == capacity;
	}

	public String getClassName() {
		return className;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String name) {
		this.lecturer = name;
	}

	public Semaphore getLecturerSem() {
		return this.lecturerSem;
	}

	public Semaphore getCapacitySem() {
		return this.capacitySem;
	}

	public int getNumStudents() {
		return this.studentInClass;
	}

	public void setNumStudents() {
		this.studentInClass++;
	}
	
	public int getNumVisitors() {
		return this.visitorsInClass;
	}

	public void setNumVisitors() {
		this.visitorsInClass++;
	}

}
