package aspectos;

import org.springframework.stereotype.Service;

@Service
@GenericAnnotation
public class ServiceOne {

    public void method() {
        System.out.println("-----------------> ServiceOne:method");
    }

    public void argOneString(String name) {
        System.out.println("-----------------> ServiceOne:argOneString(name=" + name + ")");
    }

    public int returnInt() {
        int result = 666;
        System.out.println("-----------------> ServiceOne:returnInt return= " + result);
        return result;
    }

    public void exception() throws Exception {
        System.out.println("-----------------> ServiceOne:exception");
        throw new Exception(">:o(");
    }

    @MethodAnnotation
    public void annotation() {
        System.out.println("-----------------> ServiceOne:annotation");
    }
    
    @TimeAnnotation
    public void timeAnnotation() {
        System.out.println("-----------------> ServiceOne:TimeAnnotation");
    }

}
