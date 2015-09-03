package br.com.elo7.probe.model.exception;

/**
 * The type Probe not found exception.
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
public class ProbeNotFoundException extends RuntimeException {

    public ProbeNotFoundException() {
        super("The probe not found");
    }
}
