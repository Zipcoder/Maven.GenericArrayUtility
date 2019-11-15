package com.zipcodewilmington.arrayutility;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E> {
    private E[] array;

    public ArrayUtility (E[] array) {
        this.array = array;
    }

    // TODO figure out how to prevent casting to Object
    public E[] removeValue(E valueToRemove) {
        E[] arr = Arrays.copyOf(array, array.length-getNumberOfOccurrences(valueToRemove));
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(valueToRemove)) {
                arr[index] = array[i];
                index++;
            }
        }
        return arr;
    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToCheck) {
        return (int) Arrays.stream(merge(arrayToMerge))
                .filter(val -> val == valueToCheck)
                .count();
    }

    public E getMostCommonFromMerge(E[] arrayToMerge) {
        array = merge(arrayToMerge);
        E mostCommon = null;
        int num = 0;
        for (E item : array) {
            Integer occur = getNumberOfOccurrences(item);
            mostCommon = occur > num ? item : mostCommon;
            num = occur > num ? occur : num;
        }
        return mostCommon;
    }

    public Integer getNumberOfOccurrences(E valueToCheck) {
        return ((int) Arrays.stream(array)
                .filter(val -> val == valueToCheck)
                .count());
    }

    public E[] merge(E[] arrayToMerge) {
        E[] bigArr = Arrays.copyOf(array, array.length + arrayToMerge.length);
        for (int i = array.length; i < bigArr.length; i++) {
            bigArr[i] = arrayToMerge[i-array.length];
        }
        return bigArr;
    }
}
