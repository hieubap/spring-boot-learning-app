package spring.boot.learning.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"spring.boot.core","spring.boot.learning","spring.boot.file"})
public class SpringBootLearningAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootLearningAppApplication.class, args);
  }

}
