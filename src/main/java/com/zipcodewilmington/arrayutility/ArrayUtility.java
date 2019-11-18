package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] array;

    public ArrayUtility(T[] inputArray) {

        array = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        return Stream.concat(Arrays.stream(array), Arrays.stream(arrayToMerge)).filter(z -> z == valueToEvaluate).collect(Collectors.reducing(0, e -> 1, Integer::sum));

    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        long num = 0;
        int newMax = 0;
        T word = null;
        T[] newArray = Stream.concat(Arrays.stream(array), Arrays.stream(arrayToMerge)).toArray(newSize -> Arrays.copyOf(array, newSize));
        Map<T, Long>map = Arrays.stream(newArray).collect(Collectors.groupingBy(x ->x,Collectors.counting()));

        for (Map.Entry<T, Long> v: map.entrySet()) {
            if(v.getValue() > num){
                num = v.getValue();
                word = v.getKey();
            }


           // int num = getNumberOfOccurrences(t);
           //System.out.println(num);

           //max = max < num ? max : num;
            //word = max < num ? word : t;




        }
        return word;
    }
    public Integer getNumberOfOccurrences(T valueToEvaluate) {

        return Arrays.stream(array).filter(z -> z == valueToEvaluate).collect(Collectors.reducing(0, e -> 1, Integer::sum));
    }

    public T[] removeValue(T valueToRemove) {
        return Arrays.stream(array).filter(z -> z != valueToRemove).toArray(newSize ->Arrays.copyOf(array, newSize));


    }

}
