package br.com.elo7.probe.model;

import br.com.elo7.probe.model.enums.CardinalDirectionEnum;
import br.com.elo7.test.support.TestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * The type Cardinal direction enum test.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@RunWith(MockitoJUnitRunner.class)
public class CardinalDirectionEnumTest extends TestSupport {

    private static final String NORTH = "N";
    private static final String WEST = "W";
    private static final String SOUTH = "S";
    private static final String EAST = "E";

    @Override
    public void setUp() {
        //not to do
    }

    @Test
    public void testGetLeftFromNorth() throws Exception {
        CardinalDirectionEnum leftFromNorth = CardinalDirectionEnum.N.getLeft();
        assertThat(leftFromNorth, equalTo(CardinalDirectionEnum.W));
    }

    @Test
    public void testGetRightFromNorth() throws Exception {
        CardinalDirectionEnum rightFromNorth = CardinalDirectionEnum.N.getRight();
        assertThat(rightFromNorth, equalTo(CardinalDirectionEnum.E));
    }

    @Test
    public void testGetLeftFromWest() throws Exception {
        CardinalDirectionEnum leftFromNorth = CardinalDirectionEnum.W.getLeft();
        assertThat(leftFromNorth, equalTo(CardinalDirectionEnum.S));
    }

    @Test
    public void testGetRightFromWest() throws Exception {
        CardinalDirectionEnum rightFromNorth = CardinalDirectionEnum.W.getRight();
        assertThat(rightFromNorth, equalTo(CardinalDirectionEnum.N));
    }

    @Test
    public void testGetLeftFromSouth() throws Exception {
        CardinalDirectionEnum leftFromNorth = CardinalDirectionEnum.S.getLeft();
        assertThat(leftFromNorth, equalTo(CardinalDirectionEnum.E));
    }

    @Test
    public void testGetRightFromSouth() throws Exception {
        CardinalDirectionEnum rightFromNorth = CardinalDirectionEnum.S.getRight();
        assertThat(rightFromNorth, equalTo(CardinalDirectionEnum.W));
    }

    @Test
    public void testGetLeftFromEast() throws Exception {
        CardinalDirectionEnum leftFromNorth = CardinalDirectionEnum.E.getLeft();
        assertThat(leftFromNorth, equalTo(CardinalDirectionEnum.N));
    }

    @Test
    public void testGetRightFromEast() throws Exception {
        CardinalDirectionEnum rightFromNorth = CardinalDirectionEnum.E.getRight();
        assertThat(rightFromNorth, equalTo(CardinalDirectionEnum.S));
    }

    @Test
    public void testGetNorthByDirection() throws Exception {
        CardinalDirectionEnum north = CardinalDirectionEnum.getEnumByDirection(NORTH);
        assertThat(north, equalTo(CardinalDirectionEnum.N));
    }

    @Test
    public void testGetWestByDirection() throws Exception {
        CardinalDirectionEnum north = CardinalDirectionEnum.getEnumByDirection(WEST);
        assertThat(north, equalTo(CardinalDirectionEnum.W));
    }

    @Test
    public void testGetSouthByDirection() throws Exception {
        CardinalDirectionEnum north = CardinalDirectionEnum.getEnumByDirection(SOUTH);
        assertThat(north, equalTo(CardinalDirectionEnum.S));
    }

    @Test
    public void testGetEastByDirection() throws Exception {
        CardinalDirectionEnum north = CardinalDirectionEnum.getEnumByDirection(EAST);
        assertThat(north, equalTo(CardinalDirectionEnum.E));
    }
}