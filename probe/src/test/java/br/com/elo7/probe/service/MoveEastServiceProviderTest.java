package br.com.elo7.probe.service;

import br.com.elo7.probe.model.sonda.Position;
import br.com.elo7.probe.model.enums.CardinalDirectionEnum;
import br.com.elo7.test.support.MoveServiceTestSuport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * The type Move east service provider test.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@RunWith(MockitoJUnitRunner.class)
public class MoveEastServiceProviderTest extends MoveServiceTestSuport {

    private MoveService moveEastServiceProvider = new MoveEastServiceProvider();
    private Position position =  new Position(1, 2, CardinalDirectionEnum.E);

    @Override
    public void setUp() {
        //not to do
    }

    @Test
    public void testMove() throws Exception {
        Position movement = moveEastServiceProvider.move(position);
        assertThat(movement, equalTo(getExpectedPosition(2, 2, CardinalDirectionEnum.E)));
    }

    @Test
    public void testMoveToMaxPosition() throws Exception {
        position =  new Position(5, 2, CardinalDirectionEnum.E);
        Position movement = moveEastServiceProvider.move(position);
        assertThat(movement, equalTo(getExpectedPosition(5, 2, CardinalDirectionEnum.E)));
    }
}