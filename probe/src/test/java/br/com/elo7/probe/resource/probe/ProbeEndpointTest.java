package br.com.elo7.probe.resource.probe;

import br.com.elo7.probe.configuration.Application;
import br.com.elo7.probe.model.enums.CardinalDirectionEnum;
import br.com.elo7.probe.model.enums.ProbeDirectionEnum;
import br.com.elo7.probe.resource.plateau.PlateauResource;
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

import java.util.Arrays;
import java.util.List;

/**
 * The type Probe endpoint test.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=8000", "management.port=0" })
@DirtiesContext
public class ProbeEndpointTest extends TestSupport {

    private static final String API_CONTEXT = "/probe-api/";
    private static final String LOCALHOST = "http://localhost:";
    private static final String PROBES = "probes";
    private static final String INSTRUCTIONS = "instructions";
    private static final String PLATEAUS = "plateaus";


    @Value("${server.port}")
    private int port;
    @Value("${management.port}")
    private int managementPort;

    @Override
    public void setUp() {
        //not to do
    }

    @Test
    public void testCreate() throws Exception {
        ProbeResource probeToCreate = createProbe(CardinalDirectionEnum.N, "probe", 1, 2);
        ResponseEntity<ProbeResource> createProbeResponse = callAPItoSaveProbe(probeToCreate);
        assertThat(HttpStatus.CREATED, equalTo(createProbeResponse.getStatusCode()));
        assertThat(createProbeResponse.getBody(), equalTo(probeToCreate));
    }

    /**
     * Test move.
     *
     * @throws Exception the exception
     */
    @Test
    public void testMove() throws Exception {
        InstructionResource instructionResource =
                createInstructionResource(Arrays.asList(ProbeDirectionEnum.L,
                        ProbeDirectionEnum.M,
                        ProbeDirectionEnum.L,
                        ProbeDirectionEnum.M,
                        ProbeDirectionEnum.L,
                        ProbeDirectionEnum.M,
                        ProbeDirectionEnum.L,
                        ProbeDirectionEnum.M,
                        ProbeDirectionEnum.M));


        ProbeResource probeToCreateAndMove = createProbe(CardinalDirectionEnum.N, "probe1Test", 1, 2);
        ProbeResource expectedProbe = createProbe(CardinalDirectionEnum.N, "probe1Test", 1, 3);

        createDefaultPlateauAndCallAPI();

        ResponseEntity<ProbeResource> createProbeResponse = callAPItoSaveProbe(probeToCreateAndMove);
        assertThat(HttpStatus.CREATED, equalTo(createProbeResponse.getStatusCode()));
        assertThat(createProbeResponse.getBody(), equalTo(probeToCreateAndMove));


        ResponseEntity<ProbeResource> probeResponse = callAPIToExecuteInstructions("probe1Test", instructionResource);
        assertThat(HttpStatus.OK, equalTo(probeResponse.getStatusCode()));
        assertThat(probeResponse.getBody(), equalTo(expectedProbe));

    }

    private InstructionResource createInstructionResource(final List<ProbeDirectionEnum> directions) {
        InstructionResource instructionResource = new InstructionResource();
        instructionResource.setInstructions(directions);
        return instructionResource;
    }

    private ProbeResource createProbe(final CardinalDirectionEnum cardinalDirectionEnum,
                                      final String name, final Integer positionX, final Integer positionY) {
        ProbeResource probeResource = new ProbeResource();
        probeResource.setCardinalDirection(cardinalDirectionEnum);
        probeResource.setName(name);
        probeResource.setPositionX(positionX);
        probeResource.setPositionY(positionY);
        return probeResource;
    }

    private ResponseEntity<ProbeResource> callAPItoSaveProbe(final ProbeResource probeResource) {
        return new TestRestTemplate().postForEntity(
                LOCALHOST + this.port + API_CONTEXT + PROBES, probeResource, ProbeResource.class);
    }

    private ResponseEntity<ProbeResource> callAPIToExecuteInstructions(final String probeName,
                                                                       final InstructionResource instructionResource) {
        return new TestRestTemplate().postForEntity(
                LOCALHOST + this.port + API_CONTEXT + PROBES +"/"+ probeName +"/"+ INSTRUCTIONS,
                instructionResource, ProbeResource.class, probeName);
    }

    private void createDefaultPlateauAndCallAPI() {
        PlateauResource plateauResource = new PlateauResource();
        plateauResource.setPositionX(5);
        plateauResource.setPositionY(5);

        ResponseEntity<PlateauResource> entity = new TestRestTemplate().postForEntity(
                LOCALHOST + this.port + API_CONTEXT + PLATEAUS, plateauResource, PlateauResource.class);

        assertThat(HttpStatus.CREATED, equalTo(entity.getStatusCode()));
        assertThat(entity.getBody(), equalTo(plateauResource));
    }
}