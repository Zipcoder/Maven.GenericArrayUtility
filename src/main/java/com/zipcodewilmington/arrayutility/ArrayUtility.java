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
//        E[] arr = (E[]) new Object[array.length-getNumberOfOccurrences(valueToRemove)];
//        ArrayList<E> listo = new ArrayList<>();
//        for (E item: array) {
//            if (!(valueToRemove).equals(item)) listo.add(item);
//        }
        return null;
    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToCheck) {
        return null;
    }

    public E getMostCommonFromMerge(E[] arrayToMerge) {
        return null;
    }

    public Integer getNumberOfOccurrences(E valueToCheck) {
        return ((int) Arrays.stream(array)
                .filter(val -> val == valueToCheck)
                .count());
    }
}
