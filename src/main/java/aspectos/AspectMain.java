package aspectos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public final class AspectMain {

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
        ServiceOne serviceOne = context.getBean(ServiceOne.class);
        serviceOne.method();
        serviceOne.argOneString("cadena");
        serviceOne.returnInt();
        try {
            serviceOne.exception();
        } catch (Exception e) {
        }
        serviceOne.annotation();
        serviceOne.timeAnnotation();
        ((AbstractApplicationContext) context).close();
    }
}
