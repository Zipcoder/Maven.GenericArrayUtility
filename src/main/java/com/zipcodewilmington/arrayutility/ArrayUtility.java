package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T>  {
    T[] arr;
    List<T> arrList = new ArrayList<T>();


    public ArrayUtility(T[] inputArr){
        arr = inputArr;
    }

    public T[] removeValue(T valueToRemove){
        ArrayList <T> newGenericArr = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(valueToRemove != arr[i]){
                newGenericArr.add(arr[i]);
            }
        }
        return  newGenericArr.toArray(Arrays.copyOf(arr,newGenericArr.size()));
    }

    public T[] merge(T[] arrToMerge1){
        T[] newArr = (T[]) new Object [arr.length + arrToMerge1.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        for (int i = 0; i < arrToMerge1.length; i++) {
            newArr[i + arr.length] = arrToMerge1[i];
        }
        arr = newArr;
        return newArr;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate){
    int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valueToEvaluate) {
                counter++;
            }
        }
            return counter;
    }

    public Integer countDuplicatesInMerge(T[] arrAy, T valueToEvaluate){
        merge(arrAy);
        return getNumberOfOccurrences(valueToEvaluate);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge){
        int counter = 0;
        int max = 0;
        T gen = null;
        merge(arrayToMerge);
        for (int i = 0; i < arr.length; i++) {
            counter = getNumberOfOccurrences(arr[i]);
            if(counter > max){
                max = counter;
                gen = arr[i];
            }
        }
        return gen;
    }
    
}
