package uz.data.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import uz.data.services.MyConnection;
import uz.data.services.StudentService;

@Configuration
@ComponentScan("uz.data.services")
public class DataConfiguration {
    @Bean
    public MyConnection myConnection(){
        return new MyConnection();
    }

    @Bean
    public StudentService students(){
        return new StudentService(myConnection());
    }
}
