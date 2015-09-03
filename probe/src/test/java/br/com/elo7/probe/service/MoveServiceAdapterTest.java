package br.com.elo7.probe.service;

import br.com.elo7.probe.model.sonda.Position;
import br.com.elo7.probe.model.enums.CardinalDirectionEnum;
import br.com.elo7.test.support.TestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * The type Move service adapter test.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@RunWith(MockitoJUnitRunner.class)
public class MoveServiceAdapterTest extends TestSupport {

    @Mock
    private MoveService moveNorthServiceProvider;
    @Mock
    private MoveService moveEastServiceProvider;
    @Mock
    private MoveService moveSouthServiceProvider;
    @Mock
    private MoveService moveWestServiceProvider;
    @InjectMocks
    private MoveServiceAdapter moveServiceAdapter;
    private Position position;

    @Override
    public void setUp() {
        //not to do
    }

    @Test
    public void testMoveNorth() throws Exception {
        position = new Position(1, 2, CardinalDirectionEnum.N);
        when(moveNorthServiceProvider.move(position)).thenReturn(position);

        Position movement = moveServiceAdapter.move(position);

        InOrder inOrder = inOrder(moveNorthServiceProvider);
        inOrder.verify(moveNorthServiceProvider, times(1)).move(position);
        inOrder.verifyNoMoreInteractions();

        assertThat(movement, equalTo(position));
    }

    @Test
    public void testMoveEast() throws Exception {
        position = new Position(1, 2, CardinalDirectionEnum.E);
        when(moveEastServiceProvider.move(position)).thenReturn(position);

        Position movement = moveServiceAdapter.move(position);

        InOrder inOrder = inOrder(moveEastServiceProvider);
        inOrder.verify(moveEastServiceProvider, times(1)).move(position);
        inOrder.verifyNoMoreInteractions();

        assertThat(movement, equalTo(position));
    }

    @Test
    public void testMoveSouth() throws Exception {
        position = new Position(1, 2, CardinalDirectionEnum.S);
        when(moveSouthServiceProvider.move(position)).thenReturn(position);

        Position movement = moveServiceAdapter.move(position);

        InOrder inOrder = inOrder(moveSouthServiceProvider);
        inOrder.verify(moveSouthServiceProvider, times(1)).move(position);
        inOrder.verifyNoMoreInteractions();

        assertThat(movement, equalTo(position));
    }

    @Test
    public void testMoveWest() throws Exception {
        position = new Position(1, 2, CardinalDirectionEnum.W);
        when(moveWestServiceProvider.move(position)).thenReturn(position);

        Position movement = moveServiceAdapter.move(position);

        InOrder inOrder = inOrder(moveWestServiceProvider);
        inOrder.verify(moveWestServiceProvider, times(1)).move(position);
        inOrder.verifyNoMoreInteractions();

        assertThat(movement, equalTo(position));
    }
}