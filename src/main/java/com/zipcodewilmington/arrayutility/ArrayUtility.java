package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T>{

    /*
    Added <T> to the class signature
    Created constructor with the generic input
    Changed the countDup method to accept T type

    Return generic for getMostCommon/remove as it it used with different types
     */

    private T[] inputArray;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        return null;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        return null;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int counter = 0;
        for (T eachElement : this.inputArray){
            if (eachElement.equals(valueToEvaluate)) counter++;
        }
        return counter;
    }

    public T[] removeValue(T valueToRemove) {
        ArrayList<T> newArray = new ArrayList<>();

        for (T eachElement : this.inputArray){
            if (eachElement.equals(valueToRemove)){

            } else {
                newArray.add(eachElement);
            }
        }

        return newArray.toArray(Arrays.copyOf(inputArray,newArray.size()));
    }
}
