package br.com.elo7.probe.resource.probe;

import br.com.elo7.probe.model.sonda.Position;
import br.com.elo7.probe.model.sonda.ProbeDomainModelImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/probes")
public class ProbeEndpoint {

    @RequestMapping(value = "/probes", method = RequestMethod.POST)
    public HttpEntity<ProbeResource> create(@RequestBody ProbeResource probeResource) {
        new ProbeDomainModelImpl(probeResource.getName(),
                new Position(probeResource.getPositionX(),
                        probeResource.getPositionY(), probeResource.getCardinalDirection())).create();
        return new ResponseEntity<ProbeResource>(probeResource, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/probes/{probeName}/instructions", method = RequestMethod.POST)
    public HttpEntity<ProbeResource> move(@PathVariable("probeName") String probeName,
                                          @RequestBody InstructionResource instructions) {

        return new ResponseEntity<ProbeResource>(
                mapProbeDomainModelToProbeResource(new ProbeDomainModelImpl(probeName,
                        instructions.getInstructions()).runInstructions())
                , HttpStatus.OK);
    }

    private ProbeResource mapProbeDomainModelToProbeResource(final ProbeDomainModelImpl probeDomainModel) {
        ProbeResource probeResource = new ProbeResource();
        probeResource.setName(probeDomainModel.getName());
        probeResource.setCardinalDirection(probeDomainModel.getPosition().getDirection());
        probeResource.setPositionX(probeDomainModel.getPosition().getPositionX());
        probeResource.setPositionY(probeDomainModel.getPosition().getPositionY());
        return probeResource;
    }

}
