package auto.usingAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student {

    private String studentName;

    // -------------------- FIELD INJECTION --------------------
    // 🔹 Option 1: Field Injection using @Autowired
    // 🔹 Optional: Use @Qualifier("beanName") to resolve multiple beans
    // 🔹 Activate this block to test field injection

    // @Autowired
    // @Qualifier("secondaryAddress") // Optional: Choose which Address to inject
    private Address studentAddress;

    // -------------------- CONSTRUCTOR INJECTION --------------------
    // 🔹 Option 2: Constructor Injection using @Autowired
    // 🔹 Preferred for mandatory dependencies
    // 🔹 Only ONE constructor can be @Autowired

    @Autowired  // 🔸 Comment this line to disable constructor injection
    public Student(Address studentAddress) {
        System.out.println("Inside constructor injection");
        this.studentAddress = studentAddress;
    }

    // 🔸 This overloaded constructor is NOT used unless manually wired in XML
    public Student(String studentName, Address studentAddress) {
        System.out.println("Inside overloaded constructor");
        this.studentName = studentName;
        this.studentAddress = studentAddress;
    }

    public Student() {
        System.out.println("Inside default constructor");
    }

    // -------------------- SETTER INJECTION --------------------
    // 🔹 Option 3: Setter Injection using @Autowired
    // 🔹 Will only work if constructor injection is disabled (commented out)
    // 🔹 Allows optional dependencies using `required = false`

    // @Autowired  // 🔸 Uncomment to enable setter injection
    public void setStudentAddress(Address studentAddress) {
        System.out.println("Inside setter injection");
        this.studentAddress = studentAddress;
    }

    // -------------------- GETTERS/SETTERS --------------------

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Address getStudentAddress() {
        return studentAddress;
    }

    @Override
    public String toString() {
        return "Student{ " +
                "studentName='" + studentName + '\'' +
                ", studentAddress=" + studentAddress +
                " }";
    }
}
