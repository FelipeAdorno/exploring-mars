package br.com.elo7.probe.service;

import br.com.elo7.probe.model.sonda.Position;
import br.com.elo7.probe.model.enums.CardinalDirectionEnum;
import br.com.elo7.test.support.MoveServiceTestSuport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * The type Move north service provider test.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@RunWith(MockitoJUnitRunner.class)
public class MoveNorthServiceProviderTest extends MoveServiceTestSuport {

    private MoveService moveNorthServiceProvider = new MoveNorthServiceProvider();
    private Position position =  new Position(1, 2, CardinalDirectionEnum.N);

    @Override
    public void setUp() {
        //not to do
    }

    @Test
    public void testMove() throws Exception {
        Position movement = moveNorthServiceProvider.move(position);
        assertThat(movement, equalTo(getExpectedPosition(1, 3, CardinalDirectionEnum.N)));
    }

    @Test
    public void testMoveToMaxPosition() throws Exception {
        position =  new Position(1, 5, CardinalDirectionEnum.N);
        Position movement = moveNorthServiceProvider.move(position);
        assertThat(movement, equalTo(getExpectedPosition(1, 5, CardinalDirectionEnum.N)));
    }
}