package br.com.elo7.probe.model.exception;

/**
 * The type Duplicate probe exception.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
public class DuplicateProbeException extends RuntimeException {
    public DuplicateProbeException() {
        super("This probe exist please use instructions endpoint");
    }
}
