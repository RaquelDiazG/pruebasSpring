package ejemplo2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"ejemplo2"})
@Import(PersistenceConfig.class)
public class ControllerConfig {
}
