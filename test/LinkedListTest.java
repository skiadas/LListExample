import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private static final String ELEMENT_0 = "firstIn";
    private static final String ELEMENT_1 = "secondIn";
    private static final String ELEMENT_2 = "thirdIn";

    @Test
    void testCreateEmptyList() {
        LinkedList<String> emptyList = emptyList();
        assertTrue(emptyList.isEmpty());
    }

    @Test
    void testAddElementToEmptyList() {
        LinkedList<String> listWithOneElement = listWithOneElement(ELEMENT_0);
        assertFalse(listWithOneElement.isEmpty());
        String storedValue = listWithOneElement.front();
        assertEquals(ELEMENT_0, storedValue);
    }

    @Test
    void testAddElementToNonEmptyList() {
        LinkedList<String> listWithTwoElements = listWithTwoElements(ELEMENT_0, ELEMENT_1);
        assertFalse(listWithTwoElements.isEmpty());
        String valueAtFront = listWithTwoElements.front();
        assertEquals(ELEMENT_0, valueAtFront);
        String valueAtBack = listWithTwoElements.back();
        assertEquals(ELEMENT_1, valueAtBack);
    }

    @Test
    void testCanGetArbitraryElement() {
        LinkedList<String> listWithThreeElements = listWithThreeElements(ELEMENT_0, ELEMENT_1, ELEMENT_2);
        assertEquals(ELEMENT_0, listWithThreeElements.get(0));
        assertEquals(ELEMENT_1, listWithThreeElements.get(1));
        assertEquals(ELEMENT_2, listWithThreeElements.get(2));
    }

    @Test
    void testCanRemoveFromFront() {
        LinkedList<String> aList = listWithThreeElements(ELEMENT_0, ELEMENT_1, ELEMENT_2);
        aList.removeFront();
        assertEquals(ELEMENT_1, aList.get(0));
        assertEquals(ELEMENT_2, aList.get(1));
    }

    @Test
    void testCanRemoveFromBack() {
        LinkedList<String> threeElemList = listWithThreeElements(ELEMENT_0, ELEMENT_1, ELEMENT_2);
        threeElemList.removeBack();
        assertEquals(ELEMENT_0, threeElemList.get(0));
        assertEquals(ELEMENT_1, threeElemList.get(1));
        LinkedList<String> twoElemList = listWithTwoElements(ELEMENT_0, ELEMENT_1);
        twoElemList.removeBack();
        assertEquals(ELEMENT_0, threeElemList.get(0));
        LinkedList<String> oneElemList = listWithOneElement(ELEMENT_0);
        oneElemList.removeBack();
        assertTrue(oneElemList.isEmpty());

    }

    @Test
    void testSize() {
        assertEquals(0, emptyList().size());
        assertEquals(1, listWithOneElement(ELEMENT_0).size());
        assertEquals(2, listWithTwoElements(ELEMENT_0, ELEMENT_1).size());
        assertEquals(3, listWithThreeElements(ELEMENT_0, ELEMENT_1, ELEMENT_2).size());
    }


    private LinkedList<String> emptyList() {
        return new LinkedList<>();
    }

    private LinkedList<String> listWithOneElement(String element0) {
        LinkedList<String> listWithOneElement = emptyList();
        listWithOneElement.addToFront(element0);
        return listWithOneElement;
    }

    private LinkedList<String> listWithTwoElements(String element0, String element1) {
        LinkedList<String> listWithTwoElements = listWithOneElement(element1);
        listWithTwoElements.addToFront(element0);
        return listWithTwoElements;
    }

    private LinkedList<String> listWithThreeElements(String element0, String element1, String element2) {
        LinkedList<String> listWithThreeElements = listWithTwoElements(element1, element2);
        listWithThreeElements.addToFront(element0);
        return listWithThreeElements;
    }
}