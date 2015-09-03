package br.com.elo7.probe.model.sonda;

/**
 * The interface Sonda domain model.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
public interface ProbeDomainModel {

    ProbeDomainModel create();
    ProbeDomainModel runInstructions();
    ProbeDomainModel move();
    ProbeDomainModel turnLeft();
    ProbeDomainModel turnRight();
    String getName();
    Position getPosition();

}
