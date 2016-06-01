package org.airbnb.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ilebedyuk
 */
@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(CountryNotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Country")
    public void notFoundExceptionHandler(CountryNotFoundException e) {}

    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public void badRequestExceptionHandler(IllegalArgumentException e) {}
}
