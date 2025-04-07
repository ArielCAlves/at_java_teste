package org.example;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Aitor Fidalgo (https://github.com/aitorfi)
 * @see BubbleSort
 */
public class BubbleSortTest {

    private BubbleSort bubbleSort = new BubbleSort();

    @Test
    public void bubbleSortEmptyArray() {
        Integer[] inputArray = {};
        Integer[] outputArray = bubbleSort.sort(inputArray);
        Integer[] expectedOutput = {};
        assertArrayEquals(outputArray, expectedOutput);
    }

    @Test
    public void bubbleSortSingleIntegerElementArray() {
        Integer[] inputArray = {4};
        Integer[] outputArray = bubbleSort.sort(inputArray);
        Integer[] expectedOutput = {4};
        assertArrayEquals(outputArray, expectedOutput);
    }

    @Test
    public void bubbleSortSingleStringElementArray() {
        String[] inputArray = {"s"};
        String[] outputArray = bubbleSort.sort(inputArray);
        String[] expectedOutput = {"s"};
        assertArrayEquals(outputArray, expectedOutput);
    }

    @Test
    public void bubbleSortIntegerArray() {
        Integer[] inputArray = {4, 23, -6, 78, 1, 54, 23, -6, -231, 9, 12};
        Integer[] outputArray = bubbleSort.sort(inputArray);
        Integer[] expectedOutput = {
                -231,
                -6,
                -6,
                1,
                4,
                9,
                12,
                23,
                23,
                54,
                78,
        };
        assertArrayEquals(outputArray, expectedOutput);
    }

    @Test
    public void bubbleSortStringArray() {
        String[] inputArray = {
                "cbf",
                "auk",
                "ó",
                "(b",
                "a",
                ")",
                "au",
                "á",
                "cba",
                "auk",
                "(a",
                "bhy",
                "cba",
        };
        String[] outputArray = bubbleSort.sort(inputArray);
        String[] expectedOutput = {
                "(a",
                "(b",
                ")",
                "a",
                "au",
                "auk",
                "auk",
                "bhy",
                "cba",
                "cba",
                "cbf",
                "á",
                "ó",
        };
        assertArrayEquals(outputArray, expectedOutput);
    }

    @Test
    public void bubbleSortArrayComElementoNulo() {
        Integer[] inputArray = {3, null, 2};
        assertThrows(NullPointerException.class, () -> bubbleSort.sort(inputArray));
    }


    @Test
    public void bubbleSortArrayJaOrdenado() {
        Integer[] inputArray = {1, 2, 3, 4, 5};
        Integer[] outputArray = bubbleSort.sort(inputArray.clone());
        assertArrayEquals(inputArray, outputArray);
    }

    @Test
    public void bubbleSortArrayElementosIguais() {
        Integer[] inputArray = {7, 7, 7, 7, 7};
        Integer[] outputArray = bubbleSort.sort(inputArray.clone());
        Integer[] expectedOutput = {7, 7, 7, 7, 7};
        assertArrayEquals(expectedOutput, outputArray);
    }

    @Test
    public void bubbleSortArrayDecrescente() {
        Integer[] inputArray = {5, 4, 3, 2, 1};
        Integer[] expectedOutput = {1, 2, 3, 4, 5};
        Integer[] outputArray = bubbleSort.sort(inputArray.clone());
        assertArrayEquals(expectedOutput, outputArray);
    }

    @Test
    public void bubbleSortNullNoFim() {
        Integer[] inputArray = {1, 2, null};
        assertThrows(NullPointerException.class, () -> bubbleSort.sort(inputArray));
    }

    @Test
    public void bubbleSortDoisElementosDesordenados() {
        Integer[] inputArray = {9, 2};
        Integer[] expectedOutput = {2, 9};
        assertArrayEquals(expectedOutput, bubbleSort.sort(inputArray));
    }

    @Test
    public void bubbleSortLetrasMaiusculasMinusculas() {
        String[] inputArray = {"b", "A", "C", "a"};
        String[] expectedOutput = {"A", "C", "a", "b"};
        assertArrayEquals(expectedOutput, bubbleSort.sort(inputArray));
    }

    @Test
    public void bubbleSortCaracteresEspeciais() {
        String[] inputArray = {"@", "!", "#", "$"};
        String[] expectedOutput = {"!", "#", "$", "@"};
        assertArrayEquals(expectedOutput, bubbleSort.sort(inputArray));
    }

}