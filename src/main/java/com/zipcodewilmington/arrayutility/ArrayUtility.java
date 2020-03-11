package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    public T []genArray;

    public ArrayUtility(T[] array) {
        this.genArray = array;
    }

    @SuppressWarnings("unchecked")
    public T [] removeValue(T remValue) {

        int remCount = getNumberOfOccurrences(remValue);

        T[] newArray = (T[]) Array.newInstance(genArray[0].getClass(),genArray.length - remCount);
        int index = 0;
        for (int j = 0; j < genArray.length; j++) {
            if (!genArray[j].equals(remValue)) {
                newArray[index] = genArray[j];
                index++;
            }
        }
        return newArray;
    }

    public Integer getNumberOfOccurrences(T value) {
        Integer occurrenceCount = 0;
        for (int i = 0; i < genArray.length; i++) {
            if (genArray[i].equals(value)) {
                occurrenceCount++;
            }
        }
        return occurrenceCount;
    }


    public T getMostCommonFromMerge(T []mergeArray) {
        Integer lengthA = genArray.length;
        Integer lengthB = mergeArray.length;
        T [] newArray = (T[]) new Object [lengthA + lengthB];

        System.arraycopy(genArray, 0, newArray, 0, lengthA);
        System.arraycopy(mergeArray, 0, newArray, lengthA,lengthB );

        Integer count = 1;
        T mostPop = newArray[0];
        Integer tempCount;

        for (int i = 0; i < newArray.length; i++) {
            T temp = newArray[i];
            tempCount = 0;
            for (int j = 0; j < newArray.length; j++) {
                if (temp == newArray[j]) {
                    tempCount++;
                }
                if ((tempCount > count)){
                    mostPop = temp;
                    count = tempCount;
                }
            }
        }
        return mostPop;
    }

    public Integer countDuplicatesInMerge(T []mergeArray, T value) {
        Integer lengthA = genArray.length;
        Integer lengthB = mergeArray.length;
        T[] newArray = (T[]) new Object[lengthA + lengthB];

        System.arraycopy(genArray, 0, newArray, 0, lengthA);
        System.arraycopy(mergeArray, 0, newArray, lengthA, lengthB);
          HashMap<T, Integer> dupCounter = new HashMap<>();
          for (int i = 0; i < newArray.length; i++) {
              if (!dupCounter.containsKey(newArray[i])) {
                  dupCounter.put(newArray[i], 1);
              } else {
                  Integer count = dupCounter.get(newArray[i]) + 1;
                  dupCounter.put((newArray[i]), count);
              }
          }
              Integer max = 0;
              Iterator itr = dupCounter.entrySet().iterator();
              for (T key : dupCounter.keySet()) {
                  if (dupCounter.get(key) > max) {
                      max = dupCounter.get(key);
                  }
              }
              return max;
    }
}
