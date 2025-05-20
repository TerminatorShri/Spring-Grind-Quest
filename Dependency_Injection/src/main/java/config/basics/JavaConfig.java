package config.basics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This class is used to define Java-based configuration for the Spring application.
 * It enables component scanning and registers beans manually using @Bean.
 */
@Configuration // Marks this class as a source of Spring bean definitions
@ComponentScan("config.basics") // Enables component scanning in the specified package (i.e., looks for @Component, @Service, etc.)
public class JavaConfig {

    /**
     * Defines a Spring bean of type Temp2.
     * This method will be executed by Spring, and the returned object will be managed as a bean.
     * The bean name will be "getTemp2" by default, or can be customized with @Bean("customName").
     *
     * @return a new instance of Temp2
     */
    @Bean
    public Temp2 getTemp2() {
        return new Temp2(); // Manual bean creation without needing @Component annotation on Temp2
    }

    /**
     * Defines a Spring bean of type Temp3.
     * This bean depends on Temp2, which will be automatically injected by calling getTemp2().
     * Spring manages the dependency and ensures Temp2 is created before Temp3.
     *
     * @return a new instance of Temp3 with Temp2 injected through constructor
     */
    @Bean
    public Temp3 getTemp3() {
        return new Temp3(getTemp2()); // Manual constructor injection of Temp2 into Temp3
    }
}
