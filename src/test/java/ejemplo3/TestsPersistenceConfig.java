package ejemplo3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ejemplo3.PackageNames;

@Configuration
@ComponentScan(basePackages = PackageNames.DAOS)
public class TestsPersistenceConfig {
    
}