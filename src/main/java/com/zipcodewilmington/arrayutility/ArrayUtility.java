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
    private ArrayList<T> temp;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        int counter = 0;
        temp = new ArrayList<>();

        mergeArrays(arrayToMerge);

        for (T eachElement : temp){
            if (eachElement.equals(valueToEvaluate)) counter++;
        }
        return counter;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        int counter = 0;
        int max = 0;
        T mostCommon = null;

        for (T eachElement : arrayToMerge){
            counter = getNumberOfOccurrences(eachElement);
            if (counter > max){
                max = counter;
                mostCommon = eachElement;
            }
        }

        return mostCommon;
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

    private void mergeArrays (T[] firstArray){
        for (T eachElement : firstArray){
            temp.add(eachElement);
        }
        for (T eachElement : this.inputArray){
            temp.add(eachElement);
        }
    }
}
