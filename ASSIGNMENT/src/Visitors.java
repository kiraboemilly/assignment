import java.util.Random;
/**
 * Student Name: Emilly Kirabo
 * Student Number: 3108102
 */
public class Visitors implements Runnable {
	private Classroom[] classroomList;
	private Classroom classroom;
	public Visitors(Classroom[] classroomList) {
		this.classroomList = classroomList;
	}
	public void enter() {
		if (!classroom.isFull()) {
			this.classroom.getCapacitySem().tryAcquire();
			this.classroom.setNumVisitors();
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
		// This gives a visitor to any random classroom.
		classroom = this.classroomList[randomNum];
		if (!classroom.getInSession()) {
			enter();
			sitDown();
		}
		leave();
	}
}