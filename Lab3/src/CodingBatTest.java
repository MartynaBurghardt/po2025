import org.junit.Test;
import static org.junit.Assert.*;


public class CodingBatTest {

    @Test
    public void testDoubleSum() {
        CodingBat cb = new CodingBat();
        assertEquals(10, cb.doubleSum(2, 3));
        assertEquals(0, cb.doubleSum(0, 0));
        assertEquals(-8, cb.doubleSum(-2, -2));
    }

    @Test
    public void testLastDigit() {
        CodingBat cb = new CodingBat();
        assertTrue(cb.lastDigit(7, 17));
        assertFalse(cb.lastDigit(6, 17));
        assertTrue(cb.lastDigit(123, 3));
    }

    @Test
    public void testFront22() {
        CodingBat cb = new CodingBat();
        assertEquals("kikittenki", cb.front22("kitten"));
        assertEquals("HaHaHa", cb.front22("Ha"));
        assertEquals("AAA", cb.front22("A"));
    }

    @Test
    public void testEndsLy() {
        CodingBat cb = new CodingBat();
        assertTrue(cb.endsLy("oddly"));
        assertFalse(cb.endsLy("oddy"));
        assertFalse(cb.endsLy("y"));
    }

    @Test
    public void testMakeEnds() {
        CodingBat cb = new CodingBat();
        assertArrayEquals(new int[]{1, 3}, cb.makeEnds(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{7, 2}, cb.makeEnds(new int[]{7, 4, 6, 2}));
        assertArrayEquals(new int[]{5, 5}, cb.makeEnds(new int[]{5}));
    }
}
