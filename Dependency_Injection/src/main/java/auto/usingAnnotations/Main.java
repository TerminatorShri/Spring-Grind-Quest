package auto.usingAnnotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("autowiringAnnotationConfig.xml");

        Student student = (Student) context.getBean("student1");
        System.out.println(student);
    }
}
