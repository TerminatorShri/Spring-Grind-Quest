package org.ambiguity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ambiguityConfig.xml");

        Sum sum1 = (Sum) context.getBean("sum1");
        System.out.println("Sum1: Using String " + sum1.getSum());

        Sum sum2 = (Sum) context.getBean("sum2");
        System.out.println("Sum2: Using Int " + sum2.getSum());
    }
}
