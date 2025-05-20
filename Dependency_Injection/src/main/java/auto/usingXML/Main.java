package auto.usingXML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("autowiringXMLConfig.xml");

        Student student1 = (Student) context.getBean("student1");
        System.out.println(student1);
    }
}
