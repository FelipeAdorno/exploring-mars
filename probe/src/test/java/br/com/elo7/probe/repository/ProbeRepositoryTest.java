package br.com.elo7.probe.repository;

import br.com.elo7.test.support.TestSupport;
import org.junit.Assert;
import org.junit.Test;

/**
 * The type Probe repository test.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
public class ProbeRepositoryTest extends TestSupport {

    @Override
    public void setUp() {
        //not to do
    }

    @Test
    public void testGetInstance() throws Exception {
        ProbeRepository probeRepository = ProbeRepository.getInstance();
        Assert.assertNotNull(probeRepository);
    }

    @Test
    public void testGetPositionByProbeName() throws Exception {

    }
}