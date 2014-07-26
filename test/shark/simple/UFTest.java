package shark.simple;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UFTest  {

    private UF uf;
    private static final int N = 10;

    @Before
    public void setUp() throws Exception {
        uf = new UF(N);
        uf.union(1, 2);
        uf.union(1, 3);
        uf.union(1, 4);

        uf.union(0, 5);
        uf.union(0, 6);
    }

    @Test
    public void testUnion() throws Exception {
        assertTrue(uf.connected(1, 2));
        assertTrue(uf.connected(2, 3));
        assertFalse(uf.connected(0, 1));
        assertFalse(uf.connected(0, 2));

        assertTrue(uf.connected(0, 5));
        assertTrue(uf.connected(0, 6));
        assertTrue(uf.connected(5, 6));
    }

    @Test
    public void testFind() throws Exception {
        assertEquals(uf.find(1), uf.find(1));

        assertEquals(uf.find(1), uf.find(2));
        assertEquals(uf.find(1), uf.find(3));
        assertEquals(uf.find(2), uf.find(3));

        assertEquals(uf.find(0), uf.find(5));
        assertEquals(uf.find(0), uf.find(6));
        assertEquals(uf.find(5), uf.find(6));

        assertFalse(uf.find(0) == uf.find(1));
        assertFalse(uf.find(0) == uf.find(2));
        assertFalse(uf.find(0) == uf.find(3));
        assertFalse(uf.find(0) == uf.find(4));
        assertFalse(uf.find(2) == uf.find(5));

        assertFalse(uf.find(7) == uf.find(4));

    }

    @Test
    public void testConnected() throws Exception {
        // do nothing
    }

    @Test
    public void testCount() throws Exception {
        assertEquals(5, uf.count());
    }
}