package com.zipcodewilmington.arrayutility;


import org.jooq.lambda.Seq;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {

    T[] inputArray;
    //T[] arrayToMerge;
    //T numToLookFor;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T numToLookFor) {
        Long first = Arrays.stream(this.inputArray).filter(x -> x == numToLookFor).count();
        Integer firstInt = first.intValue();
        Long second = Arrays.stream(arrayToMerge).filter(x -> x == numToLookFor).count();
        Integer secondInt = second.intValue();
        return firstInt + secondInt;
    }

    public <T> T[] removeValue(T valueToRemove) {
        //Integer count = 0
        List removedVals = Arrays.stream(this.inputArray).filter(x -> x != valueToRemove).collect(Collectors.toList());
        return  (T[])removedVals.toArray(Arrays.copyOf(inputArray,removedVals.size()));

//          This MIGHT be another possible way to cast this or get an Array.
//        removedVals.toArray((T[])Array.newInstance()
//        public static <T> T[] toArray(Collection<T> c, T[] a) {
//            return c.size()>a.length ?
//                    c.toArray((T[])Array.newInstance(a.getClass().getComponentType(), c.size())) :
//                    c.toArray(a);
    }

    public T getMostCommonFromMerge(T [] arrayToMerge) {
        ArrayList<T> toMerge = new ArrayList<T>(Arrays.asList(arrayToMerge));
        ArrayList<T> input = new ArrayList<T>(Arrays.asList(inputArray));
        toMerge.addAll(input);

        return toMerge.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey).orElse(null);
    }
    //At third line of another option is .entrySet().stream.max((o1, o2) -> o1.getValue().compareTo(o2.getValue()))

    public Integer getNumberOfOccurrences (T valueToEvaluate){
        Long numOfOccurences =  Arrays.stream(inputArray).filter(z -> z==valueToEvaluate).count();
        return numOfOccurences.intValue();
    }

}



