package com.zipcodewilmington.arrayutility;

import org.omg.CORBA.Object;

import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    T[] inputArray;

    public ArrayUtility(T[] array){
        this.inputArray = array;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        Integer counter = getNumberOfOccurrences(valueToEvaluate);
        for(T t: arrayToMerge){
            if(t == valueToEvaluate){ counter++; }
        }   return counter;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T mostOccuring = null, temp;
        int counter = 0, holder = 0;
        for(int i = 0; i < arrayToMerge.length; i++ ){
            temp = arrayToMerge[i];
            for(int j = 0; j < arrayToMerge.length; j++){
                if(temp.equals(arrayToMerge[j])){
                    counter++;
                }
            }
            if(counter > holder){
                holder = counter;
                mostOccuring = arrayToMerge[i];
            }
            counter = 0;
        }
        return mostOccuring;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer counter = 0;
        for(T t: inputArray){
            if(t == valueToEvaluate){
                counter++;
            }
        }
        return counter;
    }

    public T[] removeValue(T valueToRemove) {
        Integer occurs = inputArray.length - getNumberOfOccurrences(valueToRemove);
        T[] newT = Arrays.copyOf(inputArray,occurs);
        int j = 0;
        for(T t: inputArray){
            if(t != valueToRemove){
                newT[j] = t;
                j++;
            }
        } return newT;
    }
}
