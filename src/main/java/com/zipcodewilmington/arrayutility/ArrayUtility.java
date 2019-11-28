package com.zipcodewilmington.arrayutility;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<D extends  Object> {
    protected D[] inputArray;

    public ArrayUtility(D[] inputArray){
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(D[] arrayToMerge, D valueToEvaluate){
        Integer count = 0;
        for(D element : inputArray){if(element == valueToEvaluate){ count++;}}
        for(D element : arrayToMerge){if(element == valueToEvaluate){ count++;}}
        return count;
    }
}
