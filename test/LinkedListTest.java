import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    @Test
    void testCreateEmptyList() {
        LinkedList<String> emptyList = new LinkedList<>();
        assertTrue(emptyList.isEmpty());
    }

    @Test
    void testAddElementToEmptyList() {
        LinkedList<Object> listWithOneElement = new LinkedList<>();
        listWithOneElement.add("aString");
        assertFalse(listWithOneElement.isEmpty());
    }
}