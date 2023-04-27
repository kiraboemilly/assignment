import java.util.Random;
/**
 * Student Name: Emilly Kirabo
 * Student Number: 3108102
 */
public class Students implements Runnable {
	private Classroom[] classroomList;
	private Classroom classroom;
	public Students(Classroom[] classroomList) {
		this.classroomList = classroomList;
	}
	public void enter() {
		if (!classroom.isFull()) {
			this.classroom.getCapacitySem().tryAcquire();
			this.classroom.setNumStudents();
		}
	}
	public void sitDown() {
	}
	public void leave() {
		classroom.getCapacitySem().release();
	}
	@Override
	public void run() {
		Random random = new Random();
		int randomNum = random.nextInt(this.classroomList.length);
		this.classroom = this.classroomList[randomNum];
		if (!this.classroom.getInSession()) {
			enter();
			sitDown();
			leave();
		}
	}
}
