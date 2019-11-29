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

    public D getMostCommonFromMerge(D[] arrayToMerge) {
        D currentAns = null;
        Integer highestCount = 0;
        Integer otherCount = 0;

        for (D element : inputArray) {
            if (countDuplicatesInMerge(arrayToMerge, element) > highestCount) {
                currentAns = element;
                highestCount = countDuplicatesInMerge(arrayToMerge, element);
            }
        }

        for (D element : arrayToMerge) {
            if (countDuplicatesInMerge(arrayToMerge, element) > highestCount) {
                currentAns = element;
                highestCount = countDuplicatesInMerge(arrayToMerge, element);
            }
        }
        return currentAns;
    }
}
