package br.com.elo7.probe.configuration;

import br.com.elo7.probe.model.exception.DuplicateProbeException;
import br.com.elo7.probe.model.exception.ProbeNotFoundException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * The type Rest error handler aspect.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@ControllerAdvice
public class RestErrorHandlerAspect {

    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_JSON = "application/json; charset=utf-8";

    @ExceptionHandler({ServletRequestBindingException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            MissingServletRequestPartException.class,
            HttpMediaTypeNotSupportedException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<String> handlerBadRequest(final Exception ex) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, CONTENT_TYPE_JSON);
        return new ResponseEntity<String>(ex.getMessage(), responseHeaders, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(DuplicateProbeException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ResponseEntity<String> handlerDuplicateProbeException(final DuplicateProbeException ex) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, CONTENT_TYPE_JSON);
        return new ResponseEntity<String>(ex.getMessage(), responseHeaders, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ProbeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<String> handlerProbeNotFoundException(final ProbeNotFoundException ex) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, CONTENT_TYPE_JSON);
        return new ResponseEntity<String>(ex.getMessage(), responseHeaders, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<String> handlerException(final Exception ex) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, CONTENT_TYPE_JSON);
        return new ResponseEntity<String>(ex.getMessage(), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
