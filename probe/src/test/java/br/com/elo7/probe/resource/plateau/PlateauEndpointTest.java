package br.com.elo7.probe.resource.plateau;

import br.com.elo7.probe.configuration.Application;
import br.com.elo7.test.support.TestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * The type Plateau endpoint test.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=8000", "management.port=0" })
@DirtiesContext
public class PlateauEndpointTest extends TestSupport {

    @Value("${server.port}")
    private int port;
    @Value("${management.port}")
    private int managementPort;
    private String apiContext = "/probe-api";

    @Override
    public void setUp() {
        //not to do
    }

    @Test
    public void testCreate() throws Exception {
        PlateauResource plateauResource = new PlateauResource();
        plateauResource.setPositionX(5);
        plateauResource.setPositionY(5);
        ResponseEntity<PlateauResource> entity = new TestRestTemplate().postForEntity(
                "http://localhost:" + this.port + apiContext +"/plateaus", plateauResource, PlateauResource.class);
        assertThat(HttpStatus.CREATED, equalTo(entity.getStatusCode()));
        assertThat(entity.getBody(), equalTo(plateauResource));
    }
}