package config.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Loads the Spring context using the JavaConfig class (Java-based configuration)
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        Temp1 temp1 = (Temp1) context.getBean("temp1");
        System.out.println(temp1);

        Temp2 temp2 = context.getBean("getTemp2", Temp2.class);
        System.out.println(temp2);

        Temp3 temp3 = context.getBean("getTemp3", Temp3.class);
        System.out.println(temp3);
    }
}
