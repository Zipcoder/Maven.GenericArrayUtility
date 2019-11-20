package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E> {
    E[] inputArr;
    //    E[] arrayToMerge;
    List<E> al = new ArrayList<>();

    public ArrayUtility(E[] inputArr) {
        this.inputArr = inputArr;
//        this.arrayToMerge = arrayToMerge;


    }

    public Integer getNumberOfOccurrences(E valueToEvaluate) {
        // ArrayList<E> easyArr= new ArrayList<E>(Arrays.asList(inputArr));
        int count = 0;
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == valueToEvaluate) {
                count++;
            }
        }


        return count;
    }

    public E[] removeValue(E valueToRemove) {
        int m = getNumberOfOccurrences(valueToRemove);
        E[]filtered= Arrays.copyOf(inputArr,inputArr.length-m);
        int k=0;
for(int i=0;i<inputArr.length;i++){
    if(inputArr[i]!=valueToRemove){
        filtered[k]=inputArr[i];
        k++;
    }
}



            return filtered;
    }

    public E getMostCommonFromMerge(E[] arrayToMerge) {
        E mostlyOccured = arrayToMerge[0];
        for(int i=1;i<arrayToMerge.length;i++){
            if(getNumberOfOccurrences(arrayToMerge[i]) > getNumberOfOccurrences(mostlyOccured)){
                mostlyOccured=(arrayToMerge[i]);
            }
        }
        return mostlyOccured;
    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToEvaluate) {
        ArrayList<E> al1 = new ArrayList<E>(Arrays.asList(inputArr));
        ArrayList<E> al2 = new ArrayList<E>(Arrays.asList(arrayToMerge));
        for (E obj : arrayToMerge) {
            al1.add(obj);
        }
        E[] result = al1.toArray(inputArr);
        int count = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == valueToEvaluate) {
                count++;
            }
        }


        return count;
    }

}