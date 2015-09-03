package br.com.elo7.probe.model.plateau;

import br.com.elo7.probe.repository.PlateauRepository;
import br.com.elo7.test.support.TestSupport;
import org.junit.Test;

/**
 * The type Plateau domain model impl test.
 */
public class PlateauDomainModelImplTest extends TestSupport {

    private PlateauDomainModel plateauDomainModel = new PlateauDomainModelImpl();

    @Override
    public void setUp() {
        //not to do
    }

    @Test
    public void testCreate() throws Exception {
        plateauDomainModel.create(5, 5);
        assertThat(PlateauRepository.getInstance().getVertical(), equalTo(5));
        assertThat(PlateauRepository.getInstance().getHorizontal(), equalTo(5));
        assertThat(plateauDomainModel.getVertical(), equalTo(5));
        assertThat(plateauDomainModel.getHorizontal(), equalTo(5));
    }

    @Test
    public void testGetVertical() throws Exception {
        plateauDomainModel.create(5, 5);
        assertThat(plateauDomainModel.getVertical(), equalTo(5));
    }

    @Test
    public void testGetHorizontal() throws Exception {
        plateauDomainModel.create(5, 5);
        assertThat(plateauDomainModel.getHorizontal(), equalTo(5));
    }

}