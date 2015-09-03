package br.com.elo7.test.support;

import br.com.elo7.probe.model.sonda.Position;
import br.com.elo7.probe.model.enums.CardinalDirectionEnum;
import br.com.elo7.probe.repository.PlateauRepository;

/**
 * The type Move service test suport.
 *
 * @author Felipe Adorno (felipeads@gmail.com)
 */
public abstract class MoveServiceTestSuport extends TestSupport {

    @Override
    public void setUpTest() throws Exception {
        createPlateauRepository();
        setUp();
    }

    public abstract void setUp();

    public Position getExpectedPosition(final Integer positionX,
                                         final Integer positionY, final CardinalDirectionEnum direction) {
        return new Position(positionX, positionY, direction);
    }

    public PlateauRepository createPlateauRepository() {
        return PlateauRepository.newInstance(5, 5);
    }
}
