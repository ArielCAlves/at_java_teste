package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class SortUtilsTest {

    @Test
    void testSwapDifferentIndexes() {
        Integer[] array = {1, 2, 3};
        SortUtils.swap(array, 0, 2);
        assertArrayEquals(new Integer[]{3, 2, 1}, array);
    }

    @Test
    void testSwapSameIndexes() {
        Integer[] array = {1, 2, 3};
        SortUtils.swap(array, 1, 1);
        assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }

    @Test
    void testLessTrue() {
        assertTrue(SortUtils.less(1, 2));
    }

    @Test
    void testLessFalse() {
        assertFalse(SortUtils.less(3, 2));
    }

    @Test
    void testGreaterTrue() {
        assertTrue(SortUtils.greater(5, 2));
    }

    @Test
    void testGreaterFalse() {
        assertFalse(SortUtils.greater(1, 3));
    }

    @Test
    void testGreaterOrEqualTrueEqual() {
        assertTrue(SortUtils.greaterOrEqual(2, 2));
    }

    @Test
    void testGreaterOrEqualTrueGreater() {
        assertTrue(SortUtils.greaterOrEqual(3, 2));
    }

    @Test
    void testGreaterOrEqualFalse() {
        assertFalse(SortUtils.greaterOrEqual(1, 2));
    }

    @Test
    void testFlipNormalCase() {
        Integer[] array = {1, 2, 3, 4};
        SortUtils.flip(array, 1, 3);
        assertArrayEquals(new Integer[]{1, 4, 3, 2}, array);
    }

    @Test
    void testFlipEqualIndexes() {
        Integer[] array = {1, 2, 3};
        SortUtils.flip(array, 1, 1);
        assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }

    @Test
    void testIsSortedArrayTrue() {
        Integer[] array = {1, 2, 3};
        assertTrue(SortUtils.isSorted(array));
    }

    @Test
    void testIsSortedArrayFalse() {
        Integer[] array = {3, 2, 1};
        assertFalse(SortUtils.isSorted(array));
    }

    @Test
    void testIsSortedListTrue() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        assertTrue(SortUtils.isSorted(list));
    }

    @Test
    void testIsSortedListFalse() {
        List<Integer> list = Arrays.asList(3, 2, 1);
        assertFalse(SortUtils.isSorted(list));
    }
    @Test
    void testFlipLeftGreaterThanRight() {
        Integer[] array = {1, 2, 3, 4};
        SortUtils.flip(array, 3, 1);
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, array);
    }

    @Test
    void testIsSortedArrayEmpty() {
        Integer[] array = {};
        assertTrue(SortUtils.isSorted(array));
    }

    @Test
    void testIsSortedListEmpty() {
        List<Integer> list = List.of();
        assertTrue(SortUtils.isSorted(list));
    }

    @Test
    void testPrintArray() {
        SortUtils.print(new Integer[]{1, 2, 3});
    }

    @Test
    void testPrintList() {
        SortUtils.print(List.of("a", "b", "c"));
    }

}
