package duckson.zombiesiege;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: mathijs
 * Date: 02/09/2013
 * Time: 22:32
 * To change this template use File | Settings | File Templates.
 */
public class PlayingFieldTest {
    @Test
    public void testParticleCountDummyThing() throws Exception {
        PlayingField pf = new PlayingField();

        // Nutteloze tests...
        assertTrue(pf.getParticleCount() > 10);
        assertFalse(pf.getParticleCount() < 10);
        assertTrue(pf.getParticleCount() < 1000000);
    }
}
