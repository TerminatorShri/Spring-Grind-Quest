package org.reference;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("referenceConfig.xml");

        Car car1 = (Car) context.getBean("car1");
        System.out.println(car1);

        Car car2 = (Car) context.getBean("car2");
        System.out.println(car2);
    }
}
