package br.com.elo7.probe.service;

import br.com.elo7.probe.model.sonda.Position;

/**
 * The interface Move service.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
public interface MoveService {
    Position move(Position position);
}
