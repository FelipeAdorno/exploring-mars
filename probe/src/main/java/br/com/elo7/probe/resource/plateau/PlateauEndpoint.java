package br.com.elo7.probe.resource.plateau;

import br.com.elo7.probe.model.plateau.PlateauDomainModelImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/plateaus")
public class PlateauEndpoint {

    @RequestMapping(value = "/plateaus", method = RequestMethod.POST)
    public HttpEntity<PlateauResource> create(@RequestBody PlateauResource plateauResource) {
        new PlateauDomainModelImpl().create(plateauResource.getPositionX(),plateauResource.getPositionY());
        return new ResponseEntity<PlateauResource>(plateauResource, HttpStatus.CREATED);
    }

}
