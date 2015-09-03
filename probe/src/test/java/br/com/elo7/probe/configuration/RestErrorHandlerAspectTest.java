package br.com.elo7.probe.configuration;

import br.com.elo7.probe.model.exception.DuplicateProbeException;
import br.com.elo7.probe.model.exception.ProbeNotFoundException;
import br.com.elo7.test.support.TestSupport;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
 * The type Rest error handler aspect test.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
public class RestErrorHandlerAspectTest extends TestSupport {

    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_JSON = "application/json; charset=utf-8";

    private RestErrorHandlerAspect restErrorHandler = new RestErrorHandlerAspect();
    private HttpHeaders responseHeaders = new HttpHeaders();

    @Override
    public void setUp() {
        responseHeaders.add(CONTENT_TYPE, CONTENT_TYPE_JSON);
    }

    @Test
    public void testHandlerBadRequest() throws Exception {
        ResponseEntity<String> expectedError =
                new ResponseEntity<String>("Bad request error", responseHeaders, HttpStatus.BAD_REQUEST);
        ResponseEntity<String> error = restErrorHandler.handlerBadRequest(new Exception("Bad request error"));
        assertThat(error, equalTo(expectedError));
    }

    @Test
    public void testHandlerDuplicateProbeException() throws Exception {
        ResponseEntity<String> expectedError =
                new ResponseEntity<String>(new DuplicateProbeException().getMessage(), responseHeaders, HttpStatus.CONFLICT);
        ResponseEntity<String> error = restErrorHandler.handlerDuplicateProbeException(new DuplicateProbeException());
        assertThat(error, equalTo(expectedError));
    }

    @Test
    public void testHandlerProbeNotFoundException() throws Exception {
        ResponseEntity<String> expectedError =
                new ResponseEntity<String>(new ProbeNotFoundException().getMessage(), responseHeaders, HttpStatus.NOT_FOUND);
        ResponseEntity<String> error = restErrorHandler.handlerProbeNotFoundException(new ProbeNotFoundException());
        assertThat(error, equalTo(expectedError));
    }

    @Test
    public void testHandlerException() throws Exception {
        ResponseEntity<String> expectedError =
                new ResponseEntity<String>("Internal error", responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        ResponseEntity<String> error = restErrorHandler.handlerException(new Exception("Internal error"));
        assertThat(error, equalTo(expectedError));
    }
}