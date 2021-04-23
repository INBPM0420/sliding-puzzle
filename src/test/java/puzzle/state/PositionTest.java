package puzzle.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    Position position;

    void assertPosition(int expectedRow, int expectedCol, Position position) {
        assertAll("position",
                () -> assertEquals(expectedRow, position.row()),
                () -> assertEquals(expectedCol, position.col())
        );
    }

    @BeforeEach
    void init() {
        position = new Position(0, 0);
    }

    @Test
    void getTarget() {
        assertPosition(-1, 0, position.getTarget(Direction.UP));
        assertPosition(0, 1, position.getTarget(Direction.RIGHT));
        assertPosition(1, 0, position.getTarget(Direction.DOWN));
        assertPosition(0, -1, position.getTarget(Direction.LEFT));
    }

    @Test
    void getUp() {
        assertPosition(-1, 0, position.getUp());
    }

    @Test
    void getRight() {
        assertPosition(0, 1, position.getRight());
    }

    @Test
    void getDown() {
        assertPosition(1, 0, position.getDown());
    }

    @Test
    void getLeft() {
        assertPosition(0, -1, position.getLeft());
    }

    @Test
    void setTarget_up() {
        position.setTarget(Direction.UP);
        assertPosition(-1, 0, position);
    }

    @Test
    void setTarget_right() {
        position.setTarget(Direction.RIGHT);
        assertPosition(0, 1, position);
    }

    @Test
    void setTarget_down() {
        position.setTarget(Direction.DOWN);
        assertPosition(1, 0, position);
    }

    @Test
    void setTarget_left() {
        position.setTarget(Direction.LEFT);
        assertPosition(0, -1, position);
    }

    @Test
    void setUp() {
        position.setUp();
        assertPosition(-1, 0, position);
    }

    @Test
    void setRight() {
        position.setRight();
        assertPosition(0, 1, position);
    }

    @Test
    void setDown() {
        position.setDown();
        assertPosition(1, 0, position);
    }

    @Test
    void setLeft() {
        position.setLeft();
        assertPosition(0, -1, position);
    }

    @Test
    void testEquals() {
        assertTrue(position.equals(position));
        assertTrue(position.equals(new Position(position.row(), position.col())));
        assertFalse(position.equals(new Position(Integer.MIN_VALUE, position.col())));
        assertFalse(position.equals(new Position(position.row(), Integer.MAX_VALUE)));
        assertFalse(position.equals(new Position(Integer.MIN_VALUE, Integer.MAX_VALUE)));
        assertFalse(position.equals(null));
        assertFalse(position.equals("Hello, World!"));
    }

    @Test
    void testHashCode() {
        assertTrue(position.hashCode() == position.hashCode());
        assertTrue(position.hashCode() == new Position(position.row(), position.col()).hashCode());
    }

    @Test
    void testClone() {
        var clone = position.clone();
        assertTrue(clone.equals(position));
        assertNotSame(position, clone);
    }

    @Test
    void testToString() {
        assertEquals("(0,0)", position.toString());
    }

}
