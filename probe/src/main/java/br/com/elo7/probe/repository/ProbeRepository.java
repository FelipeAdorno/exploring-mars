package br.com.elo7.probe.repository;

import br.com.elo7.probe.model.sonda.Position;
import br.com.elo7.probe.model.exception.ProbeNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Probe repository.
 *
 * @author Felipe Adorno
 */
public class ProbeRepository {

    private static ProbeRepository probeRepository = null;
    private static Map<String, Position> probes = new HashMap<>();

    private ProbeRepository() {
        //not to do
    }

    public static ProbeRepository getInstance() {
        if(probeRepository == null) {
            probeRepository = new ProbeRepository();
        }
        return probeRepository;
    }

    public Position getPositionByProbeName(final String name) {
        if(!probes.containsKey(name)) {
            throw new ProbeNotFoundException();
        }
        return probes.get(name);
    }

    public void save(final String name, final Position position) {
        if(!probes.containsKey(name)) {
            probes.remove(name);
        }
        probes.put(name, position);
    }

    public Boolean exist(final String name) {
        return probes.containsKey(name);
    }
}
