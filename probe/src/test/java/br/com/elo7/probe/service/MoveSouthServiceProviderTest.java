package br.com.elo7.probe.service;

import br.com.elo7.probe.model.sonda.Position;
import br.com.elo7.probe.model.enums.CardinalDirectionEnum;
import br.com.elo7.test.support.MoveServiceTestSuport;
import org.junit.Test;


/**
 * The type Move south service provider test.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
public class MoveSouthServiceProviderTest extends MoveServiceTestSuport {

    private MoveService moveSouthServiceProvider = new MoveSouthServiceProvider();
    private Position position =  new Position(1, 3, CardinalDirectionEnum.S);

    @Override
    public void setUp() {
        //not to do
    }

    @Test
    public void testMove() throws Exception {
        Position movement = moveSouthServiceProvider.move(position);
        assertThat(movement, equalTo(getExpectedPosition(1, 2, CardinalDirectionEnum.S)));
    }

    @Test
    public void testMoveToLessThenOnePosition() throws Exception {
        position =  new Position(1, -1, CardinalDirectionEnum.S);
        Position movement = moveSouthServiceProvider.move(position);
        assertThat(movement, equalTo(getExpectedPosition(1, 0, CardinalDirectionEnum.S)));
    }
}