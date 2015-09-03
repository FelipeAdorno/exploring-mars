package br.com.elo7.probe.model.sonda;

import br.com.elo7.probe.model.enums.CardinalDirectionEnum;
import br.com.elo7.probe.model.enums.ProbeDirectionEnum;
import br.com.elo7.probe.model.exception.ProbeNotFoundException;
import br.com.elo7.probe.repository.ProbeRepository;
import br.com.elo7.probe.service.MoveServiceAdapter;
import br.com.elo7.test.support.TestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

/**
 * The type Probe domain model impl test.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@RunWith(MockitoJUnitRunner.class)
public class ProbeDomainModelImplTest extends TestSupport {

    @Mock
    private MoveServiceAdapter moveServiceAdapter;
    @InjectMocks
    private ProbeDomainModel probeDomainModel = new ProbeDomainModelImpl(
            "probe1", new Position(1, 2, CardinalDirectionEnum.N));
    @InjectMocks
    private ProbeDomainModel probeDomainModelWithInstructions = new ProbeDomainModelImpl(
            "probe2", new Position(1, 2, CardinalDirectionEnum.N),
            Arrays.asList(ProbeDirectionEnum.L,ProbeDirectionEnum.M,ProbeDirectionEnum.L,
                    ProbeDirectionEnum.M,ProbeDirectionEnum.L,ProbeDirectionEnum.M,
                    ProbeDirectionEnum.L,ProbeDirectionEnum.M,ProbeDirectionEnum.M));

    @Override
    public void setUp() {
        ProbeRepository.getInstance().save("probe1", new Position(1, 2, CardinalDirectionEnum.N));
        ProbeRepository.getInstance().save("probe2", new Position(1, 2, CardinalDirectionEnum.N));
    }

    @Test
    public void testRunInstructions() throws Exception {
        when(moveServiceAdapter.move(new Position(1, 2, CardinalDirectionEnum.W)))
                .thenReturn(new Position(0, 2, CardinalDirectionEnum.W));
        when(moveServiceAdapter.move(new Position(0, 2, CardinalDirectionEnum.S)))
                .thenReturn(new Position(0, 1, CardinalDirectionEnum.S));
        when(moveServiceAdapter.move(new Position(0, 1, CardinalDirectionEnum.E)))
                .thenReturn(new Position(1, 1, CardinalDirectionEnum.E));
        when(moveServiceAdapter.move(new Position(1, 1, CardinalDirectionEnum.N)))
                .thenReturn(new Position(1, 2, CardinalDirectionEnum.N));
        when(moveServiceAdapter.move(new Position(1, 2, CardinalDirectionEnum.N)))
                .thenReturn(new Position(1, 3, CardinalDirectionEnum.N));

        ProbeDomainModel expectedProbeDomainModel = probeDomainModelWithInstructions.runInstructions();
        assertThat(expectedProbeDomainModel.getPosition(), equalTo(new Position(1, 3, CardinalDirectionEnum.N)));
    }

    @Test
    public void testRunInstructionsWithoutInstructions() throws Exception {
        ProbeDomainModel expectedProbeDomainModel = probeDomainModel.runInstructions();
        assertThat(expectedProbeDomainModel, equalTo(probeDomainModel));
    }

    @Test
    public void testMove() throws Exception {
        ProbeRepository.getInstance().save("probe1", new Position(1, 2, CardinalDirectionEnum.N));

        when(moveServiceAdapter.move(probeDomainModel.getPosition())).thenReturn(getExpectedPostion());
        ProbeDomainModel expectedProbeDomainModel = probeDomainModel.move();

        InOrder inOrder = inOrder(moveServiceAdapter);
        inOrder.verify(moveServiceAdapter, times(1)).move(new Position(1, 2, CardinalDirectionEnum.N));
        inOrder.verifyNoMoreInteractions();

        assertThat(expectedProbeDomainModel, equalTo(probeDomainModel));
        assertThat(ProbeRepository.getInstance().getPositionByProbeName("probe1"), equalTo(getExpectedPostion()));
    }

    @Test(expected = ProbeNotFoundException.class)
    public void testMoveWithOutProbe() throws Exception {
        ProbeDomainModel probeDomainModel = new ProbeDomainModelImpl("xxxx", new Position(1, 2, CardinalDirectionEnum.N));
        probeDomainModel.move();
    }

    @Test(expected = ProbeNotFoundException.class)
    public void testTurnLeftWithOutProbe() throws Exception {
        ProbeDomainModel probeDomainModel = new ProbeDomainModelImpl("xxxx", new Position(1, 2, CardinalDirectionEnum.N));
        probeDomainModel.turnLeft();
    }

    @Test
    public void testTurnLeft() throws Exception {
        probeDomainModel.turnLeft();
        assertThat(probeDomainModel.getPosition().getDirection(), equalTo(CardinalDirectionEnum.W));
        assertThat(ProbeRepository.getInstance()
                .getPositionByProbeName("probe1").getDirection(), equalTo(CardinalDirectionEnum.W));
    }

    @Test
    public void testTurnRight() throws Exception {
        probeDomainModel.turnRight();
        assertThat(probeDomainModel.getPosition().getDirection(), equalTo(CardinalDirectionEnum.E));
        assertThat(ProbeRepository.getInstance()
                .getPositionByProbeName("probe1").getDirection(), equalTo(CardinalDirectionEnum.E));
    }

    @Test(expected = ProbeNotFoundException.class)
    public void testTurnRightWithOutProbe() throws Exception {
        ProbeDomainModel probeDomainModel = new ProbeDomainModelImpl("xxxx", new Position(1, 2, CardinalDirectionEnum.N));
        probeDomainModel.turnRight();
    }

    private Position getExpectedPostion() {
        return new Position(1 ,3, CardinalDirectionEnum.N);
    }

}