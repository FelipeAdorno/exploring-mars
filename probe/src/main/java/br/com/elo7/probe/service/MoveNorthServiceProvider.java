package br.com.elo7.probe.service;

import br.com.elo7.probe.model.sonda.Position;
import br.com.elo7.probe.repository.PlateauRepository;
import org.springframework.stereotype.Service;

/**
 * The type Move north service provider.
 *
 * @author Felipe Adorno (felipeads@gmail.com)
 */
@Service
public class MoveNorthServiceProvider implements MoveService {
    @Override
    public Position move(final Position position) {
        position.setPositionY(
                position.getPositionY() + 1 < PlateauRepository.getInstance().getVertical() ?
                        position.getPositionY() + 1 : PlateauRepository.getInstance().getVertical()
        );
        return position;
    }
}
