package auto.usingXML;

public class Student {
    private String studentName;
    private Address studentAddress;

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public Student(String studentName, Address studentAddress) {
        this.studentName = studentName;
        this.studentAddress = studentAddress;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Address getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(Address studentAddress) {
        this.studentAddress = studentAddress;
    }

    @Override
    public String toString() {
        return "Student{ " +
                "studentName='" + studentName + '\'' +
                ", studentAddress=" + studentAddress +
                " }";
    }
}
