package springDemo.annotationbased.vehicles;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("springDemo.annotationbased.vehicles")
@PropertySource("/vehicle.properties")
public class Config {
}
