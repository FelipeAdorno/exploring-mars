package br.com.elo7.probe.service;

import br.com.elo7.probe.model.sonda.Position;
import org.springframework.stereotype.Service;

/**
 * The type Move west service provider.
 *
 * @author Felipe Adorno (felipeads@gmail.com)
 */
@Service
public class MoveWestServiceProvider implements MoveService {
    @Override
    public Position move(final Position position) {
        position.setPositionX(position.getPositionX() - 1 < 0 ? 0 : position.getPositionX() - 1);
        return position;
    }
}
