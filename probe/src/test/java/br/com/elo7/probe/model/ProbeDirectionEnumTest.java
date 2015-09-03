package br.com.elo7.probe.model;

import br.com.elo7.probe.model.enums.ProbeDirectionEnum;
import br.com.elo7.test.support.TestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


/**
 * The type Probe direction enum test.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@RunWith(MockitoJUnitRunner.class)
public class ProbeDirectionEnumTest extends TestSupport {

    private static final String MOVE = "M";
    private static final String LEFT_90_DEGREES = "L";
    private static final String RIGHT_90_DEGREES = "R";

    @Override
    public void setUp() {
        //not to do
    }

    @Test
    public void testGetMoveByDirection() throws Exception {
        ProbeDirectionEnum move = ProbeDirectionEnum.getEnumByDirection(MOVE);
        assertThat(move, equalTo(ProbeDirectionEnum.M));
    }

    @Test
    public void testGetLeft90DegreesByDirection() throws Exception {
        ProbeDirectionEnum move = ProbeDirectionEnum.getEnumByDirection(LEFT_90_DEGREES);
        assertThat(move, equalTo(ProbeDirectionEnum.L));
    }

    @Test
    public void testGetRight90DegreesByDirection() throws Exception {
        ProbeDirectionEnum move = ProbeDirectionEnum.getEnumByDirection(RIGHT_90_DEGREES);
        assertThat(move, equalTo(ProbeDirectionEnum.R));
    }
}