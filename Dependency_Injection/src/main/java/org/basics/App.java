package org.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("basicsConfig.xml");

        Temp temp1 = (Temp) context.getBean("usingCallbacks1");
        System.out.println(temp1);
        System.out.println(temp1.getTempValues());

        Temp temp2 = (Temp) context.getBean("usingCallbacks2");
        System.out.println(temp2);
        System.out.println(temp2.getTempValues());

        Temp temp3 = (Temp) context.getBean("temp1");
        System.out.println(temp3);
        System.out.println(temp3.getTempValues());
    }
}
