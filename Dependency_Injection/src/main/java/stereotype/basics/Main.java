package stereotype.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("stereotypeConfig.xml");
        Temp temp = context.getBean("customBeanName", Temp.class);
        System.out.println(temp);
        System.out.println(temp.getTempValues().getClass().getName());
    }
}
