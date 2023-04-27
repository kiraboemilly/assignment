import java.util.Random;
/**
 * Student Name: Emilly Kirabo
 * Student Number: 3108102
 */
public class Lecturer implements Runnable {
	private String name;
	private Classroom[] classroomList;
	private Classroom classroom;

	public Lecturer(String name, Classroom[] classroomList) {
		this.name = name;
		this.classroomList = classroomList;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void enter() {
		try {
			this.classroom.getLecturerSem().acquire();
			this.classroom.setLecturer(this.name);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void startLecture() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void leave() {
		classroom.getLecturerSem().release();
	}
	@Override
	public void run() {
		Random random = new Random();
		int randomNum = random.nextInt(this.classroomList.length);
		// assigns the visitor to a random classroom
		classroom = this.classroomList[randomNum];
		enter();
		startLecture();
		leave();

	}

}