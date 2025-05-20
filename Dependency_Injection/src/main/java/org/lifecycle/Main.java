package org.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Using AbstractApplicationContext to access registerShutdownHook()
        AbstractApplicationContext abstractContext = new ClassPathXmlApplicationContext("lifecycleConfig.xml");

        // Getting bean of Temp which uses XML-based init and destroy methods
        UsingCallbacks usingCallbacks1 = (UsingCallbacks) abstractContext.getBean("usingCallbacks1");
        System.out.println(usingCallbacks1);

        // Fetching the same bean again (will be same object in singleton scope)
        UsingCallbacks usingCallbacks2 = (UsingCallbacks) abstractContext.getBean("usingCallbacks1");
        System.out.println(usingCallbacks2);

        // Registering a shutdown hook to ensure destroy-method gets called
        abstractContext.registerShutdownHook();

        // Getting bean of UsingInterface which uses InitializingBean and DisposableBean lifecycle methods
        UsingInterface temp3 = (UsingInterface) abstractContext.getBean("usingInterface");
        System.out.println(temp3);

        // Getting bean of UsingAnnotation which uses @PostConstruct and @PreDestroy lifecycle methods
        UsingAnnotation temp4 = (UsingAnnotation) abstractContext.getBean("usingAnnotation");
        System.out.println(temp4);
    }
}
