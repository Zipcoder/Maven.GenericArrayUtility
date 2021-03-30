package com.zipcodewilmington.arrayutility;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by leon on 3/6/18.
 */


// created a generic class
public class ArrayUtility<T> {// created a generic class
    private T[] inputArray;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        Integer counter = 0;
       for (int i = 0; i < inputArray.length; i++){
           if  (inputArray[i].equals(valueToEvaluate)) {
               counter++;
           }
       }
       for (int j = 0; j < arrayToMerge.length; j++) {
           if (arrayToMerge[j].equals(valueToEvaluate)) {
               counter++;
           }

       }
       return counter;
    }

    public T getMostCommonFromMerge (T[] arrayToMerge) {
        T mostCommon = null;

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < arrayToMerge.length;j++){
                if(inputArray[i] == arrayToMerge[j]){
                    mostCommon = inputArray[i];
                }
            }
        }
        return mostCommon;
    }

    public Integer getNumberOfOccurrences( T valueToEvaluate) {
        Integer  counter = 0;

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].equals(valueToEvaluate)){
                counter++;
            }
        }
        return counter;

    }

    public T[] removeValue( T valueToRemove) {
       T[] newArray;
       Integer counter = 0;
       Integer remove = getNumberOfOccurrences(valueToRemove);
       Integer newSize = inputArray.length - remove;

       newArray = Arrays.copyOf(inputArray, newSize);
       for (int i = 0; i < inputArray.length; i++) {
           if(inputArray[i] != valueToRemove){
               newArray[counter] = inputArray[i];
               counter++;
           }
       }
        return newArray;

    }













}
