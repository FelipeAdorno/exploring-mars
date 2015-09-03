package br.com.elo7.probe.service;

import br.com.elo7.probe.model.sonda.Position;
import org.springframework.stereotype.Service;

/**
 * The type Move south service provider.
 *
 * @author Felipe Adorno (felipeads@gmail.com)
 */
@Service
public class MoveSouthServiceProvider implements MoveService {
    @Override
    public Position move(final Position position) {
        position.setPositionY(position.getPositionY() - 1 < 0 ? 0 : position.getPositionY() - 1);
        return position;
    }
}
