package br.com.elo7.probe.model.plateau;

/**
 * The interface Plateau domain model.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
public interface PlateauDomainModel {

    PlateauDomainModel create(Integer vertical, Integer horizontal);
    Integer getVertical();
    Integer getHorizontal();

}
