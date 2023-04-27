/**
 * Student Name: Emilly Kirabo
 * Student Number: 3108102
 */
public class CollegeSimulation {
	public static void main(String[] args) {
		for (int run = 0; run < 5; run++) {
			Classroom[] classroomList = {
					new Classroom("W201", 60),
					new Classroom("W202", 60),
					new Classroom("W101", 20),
					new Classroom("W102", 30)
			};
			Visitors[] visitorList = new Visitors[15];
			for (int i = 0; i < visitorList.length; i++) {
				visitorList[i] = new Visitors(classroomList);
				new Thread(visitorList[i]).start();
			}
			Students[] studentList = new Students[200];
			for (int i = 0; i < studentList.length; i++) {
				studentList[i] = new Students(classroomList);
				new Thread(studentList[i]).start();
			}
			Lecturer[] lecturerList = {
					new Lecturer("Osama", classroomList),
					new Lecturer("Barry", classroomList),
					new Lecturer("Faheem", classroomList),
					new Lecturer("Alex", classroomList),
					new Lecturer("Aqeel", classroomList),
					new Lecturer("Waseem", classroomList)
			};
			for (Lecturer lecturer : lecturerList)
				new Thread(lecturer).start();
			Monitor monitor = new Monitor(classroomList);
			new Thread(monitor).start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}