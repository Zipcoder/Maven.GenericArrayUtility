package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<D extends  Object> {
    protected D[] inputArray;

    public ArrayUtility(D[] inputArray){
        this.inputArray = inputArray;
    }

    public Integer count(D[] array, D valueToCount){
        Integer count = 0;
        for(D element : array){if(element == valueToCount){ count++;}}
        return count;
    }


    public Integer getNumberOfOccurrences(D valueToEvaluate){
        return count(inputArray, valueToEvaluate);
    }

    public D[] removeValue(D valueToRemove){
        return removeValue(inputArray, valueToRemove);
    }

    public D[] removeValue(D[] array, D valueToRemove){
        Integer newSize = array.length - count(array,valueToRemove);
        D[] newArray = (D[]) Array.newInstance(valueToRemove.getClass(),newSize);
        Integer w = 0;
        for (int i = 0; i < array.length; i++){
            if(array[i] != valueToRemove){
                newArray[w] = array[i];
                w++;
            }
        }
        return newArray;
    }

    public Integer countDuplicatesInMerge(D[] arrayToMerge, D valueToEvaluate){
        return count(arrayToMerge, valueToEvaluate) + getNumberOfOccurrences(valueToEvaluate);
    }

    public D getMostCommonFromMerge(D[] arrayToMerge) {
        D inputMostCommon = getMostCommon(inputArray);
        Integer inputCommonCount = count(inputArray,inputMostCommon);
        D arrayMostCommon = getMostCommon(arrayToMerge);
        Integer arrayCommonCount = count(arrayToMerge, arrayMostCommon);
        return (inputCommonCount > arrayCommonCount) ? inputMostCommon : arrayMostCommon;
    }

    public D getMostCommon(D[] array){
        Integer highestCount = 0;
        D mostCommon = null;
        for(D element : array){
            if(count(array,element) > highestCount){
                mostCommon = element;
                highestCount = count(array,element);
            }
        }
        return mostCommon;
    }


}
