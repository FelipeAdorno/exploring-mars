package br.com.elo7.probe.service;

import br.com.elo7.probe.model.sonda.Position;
import br.com.elo7.probe.model.enums.CardinalDirectionEnum;
import br.com.elo7.test.support.MoveServiceTestSuport;
import org.junit.Test;


/**
 * The type Move west service provider test.
 *
 * @author Felipe Adorno (felipeads@gmail.com)
 */
public class MoveWestServiceProviderTest extends MoveServiceTestSuport {

    private MoveService moveWestServiceProvider = new MoveWestServiceProvider();
    private Position position =  new Position(2, 1, CardinalDirectionEnum.W);

    @Override
    public void setUp() {
        //not to do
    }

    @Test
    public void testMove() throws Exception {
        Position movement = moveWestServiceProvider.move(position);
        assertThat(movement, equalTo(getExpectedPosition(1, 1, CardinalDirectionEnum.W)));
    }

    @Test
    public void testMoveToLessThenOnePosition() throws Exception {
        position =  new Position(-1, 1, CardinalDirectionEnum.W);
        Position movement = moveWestServiceProvider.move(position);
        assertThat(movement, equalTo(getExpectedPosition(0, 1, CardinalDirectionEnum.W)));
    }
}