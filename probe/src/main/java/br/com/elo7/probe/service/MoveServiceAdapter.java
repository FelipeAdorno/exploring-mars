package br.com.elo7.probe.service;

import br.com.elo7.probe.model.sonda.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static org.springframework.util.Assert.notNull;

/**
 * The type Move service factory.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@Service
public class MoveServiceAdapter implements MoveService {

    @Autowired
    private MoveService moveNorthServiceProvider;
    @Autowired
    private MoveService moveEastServiceProvider;
    @Autowired
    private MoveService moveSouthServiceProvider;
    @Autowired
    private MoveService moveWestServiceProvider;

    @Override
    public Position move(final Position position) {
        notNull(position.getDirection(), "invalid position");

        Position positionToReturn = null;

        switch (position.getDirection()) {
            case N:
                positionToReturn = moveNorthServiceProvider.move(position);
                break;
            case W:
                positionToReturn = moveWestServiceProvider.move(position);
                break;
            case S:
                positionToReturn = moveSouthServiceProvider.move(position);
                break;
            case E:
                positionToReturn = moveEastServiceProvider.move(position);
                break;
        }

        return positionToReturn;
    }
}
