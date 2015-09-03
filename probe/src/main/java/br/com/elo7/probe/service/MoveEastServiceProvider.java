package br.com.elo7.probe.service;

import br.com.elo7.probe.model.sonda.Position;
import br.com.elo7.probe.repository.PlateauRepository;
import org.springframework.stereotype.Service;

/**
 * The type Move east service provider.
 *
 * @author Felipe Adorno (felipeads@gmail.com)
 */
@Service
public class MoveEastServiceProvider implements MoveService {
    @Override
    public Position move(final Position position) {
        position.setPositionX(
                position.getPositionX() + 1 < PlateauRepository.getInstance().getHorizontal() ?
                        position.getPositionX() + 1 : PlateauRepository.getInstance().getHorizontal()
        );
        return position;
    }
}
