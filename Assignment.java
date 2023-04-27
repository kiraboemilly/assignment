public class Assignment {
    
    public static void main(String[] args) {

        Classroom[] classroomList = {
            new Classroom("W201", 60),
            new Classroom("W202", 60),
            new Classroom("W101", 20),
            new Classroom("W102", 30)
        };
        
        Visitor[] visitorList = new Visitor[15];
        for (int i = 0; i < visitorList.length; i++) {
            visitorList[i] = new Visitor(classroomList);
            visitorList[i].start();
        }
        
        Student[] studentList = new Student[200];
        for (int i = 0; i < studentList.length; i++) {
            studentList[i] = new Student(classroomList);
            studentList[i].start();
        }
        
        Lecturer[] lecturerList = {
            //Osama, Barry, Faheem, Alex, Aqeel, Waseem
            new Lecturer("Osama", classroomList),
            new Lecturer("Barry", classroomList),
            new Lecturer("Faheem", classroomList),
            new Lecturer("Alex", classroomList),
            new Lecturer("Aqeel", classroomList),
            new Lecturer("Waseem", classroomList)
        };
        for (Lecturer lecturer: lecturerList)
            lecturer.start();
        
        Monitor monitor = new Monitor(classroomList);
        monitor.start();
        
    }
}