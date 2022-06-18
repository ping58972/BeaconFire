package PureAnnotationDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"PureAnnotationDemo"})
public class DependencyConfig {

    // bean id: dependencyTwo
    @Bean
    public DependencyTwo dependencyTwo(){
        return new DependencyTwo();
    }

    // bean id: three
    @Bean("three")
    public DependencyThree dependencyThree(){
        return new DependencyThree();
    }



}
