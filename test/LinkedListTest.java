import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    @Test
    void testCreateEmptyList() {
        LinkedList<String> emptyList = new LinkedList<>();
        assertTrue(emptyList.isEmpty());
    }
}