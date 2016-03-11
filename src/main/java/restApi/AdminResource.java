package restApi;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restApi.exceptions.ByCeroException;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.ADMINS)
public class AdminResource {

    @RequestMapping(value = Uris.CALCULADORA, method = RequestMethod.GET)
    public String start(@RequestParam int dividendo, @RequestParam int divisor ) {
        return "{división:"+dividendo/divisor +"}";
    }
    
    @RequestMapping(value = Uris.CALCULADORA2, method = RequestMethod.POST)
    public String start(@RequestBody Wrapper wrapper) throws ByCeroException{
    	if (wrapper.getDenominador() == 0) {
            throw new ByCeroException("denominador=0");
        }
        return "{división:"+wrapper.getNumerador()/wrapper.getDenominador() +"}";
    }
}
