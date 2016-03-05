package ejemplo3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"controllers"})
@Import(PersistenceConfig.class)
public class ControllerConfig {
}
