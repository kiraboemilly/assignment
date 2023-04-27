/**
 * Student Name: Emilly Kirabo
 * Student Number: 3108102
 */
public class Monitor implements Runnable {
	Classroom[] classroomList;
	Lecturer lecturer;
	public Monitor(Classroom[] classroomList) {
		this.classroomList = classroomList;
	}
	@Override
	public synchronized void run() {
		for (int i = 0; i < 80; i++) System.out.print("=");
		System.out.printf("\nClassroom\tLecturer\tInSession\tStudents\tVisitors\n");
		for (int i = 0; i < 80; i++) System.out.print("=");
		System.out.println();
			for (int i = 0; i < classroomList.length; i++) {
				System.out.println(classroomList[i].getClassName() + "\t\t" + classroomList[i].getLecturer() + "\t\t" + 
						classroomList[i].getInSession() + "\t\t" + classroomList[i].getNumStudents() + "\t\t" + 
						classroomList[i].getNumVisitors());
			}
	}
}
