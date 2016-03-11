package restApi;

import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import restApi.exceptions.ByCeroException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ByCeroException.class})
    @ResponseBody
    public ErrorMessage notFoundRequest(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception);
        LogManager.getLogger(this.getClass()).info("  ERROR: BY_CERO, " + errorMessage);
        return errorMessage;
    }
    
}
