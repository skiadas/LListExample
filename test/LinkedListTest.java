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
        String testString = "aString";
        LinkedList<String> listWithOneElement = new LinkedList<>();
        listWithOneElement.addToFront(testString);
        assertFalse(listWithOneElement.isEmpty());
        String storedValue = listWithOneElement.front();
        assertEquals(testString, storedValue);
    }

    @Test
    void testAddElementToNonEmptyList() {
        String firstToAdd = "stringAtBack";
        String secondToAdd = "stringAtFront";
        LinkedList<String> listWithTwoElements = new LinkedList<>();
        listWithTwoElements.addToFront(firstToAdd);
        listWithTwoElements.addToFront(secondToAdd);
        assertFalse(listWithTwoElements.isEmpty());
        String valueAtFront = listWithTwoElements.front();
        assertEquals(secondToAdd, valueAtFront);
        String valueAtBack = listWithTwoElements.back();
        assertEquals(firstToAdd, valueAtBack);
    }

    @Test
    void testCanGetArbitraryElement() {
        String firstIn = "firstIn";
        String secondIn = "secondIn";
        String thirdIn = "thirdIn";
        LinkedList<Object> listWithThreeElements = new LinkedList<>();
        listWithThreeElements.addToFront(firstIn);
        listWithThreeElements.addToFront(secondIn);
        listWithThreeElements.addToFront(thirdIn);
        assertEquals(firstIn, listWithThreeElements.get(2));
        assertEquals(secondIn, listWithThreeElements.get(1));
        assertEquals(thirdIn, listWithThreeElements.get(0));
    }
}