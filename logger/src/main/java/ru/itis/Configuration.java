package ru.itis;

import ru.itis.aspects.AnnotationLogging;
import ru.itis.group.listener.Listener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@org.springframework.context.annotation.Configuration
@ComponentScan("ru.itis")
@EnableAspectJAutoProxy
public class Configuration {

    @Bean
    Listener listener(){
        return new Listener("Jackob");
    }

    @Bean
    Audition audition(){
        return new Audition();
    }

    @Bean
    AnnotationLogging annotationLogging(){
        return new AnnotationLogging();
    }
}
