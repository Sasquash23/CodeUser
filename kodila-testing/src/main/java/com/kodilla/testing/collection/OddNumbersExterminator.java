package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    public OddNumbersExterminator(){
    }

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers){
        //numbers.remove
        //return Arrays.stream(numbers).allMatch(num -> num%2==0);

        ArrayList<Integer> mResult = new ArrayList<Integer>();
        /**Iterator<MyObject> iterator = numbers.iterator();
        while(iterator.hasNext()){
            if (numbers.nextElement() % 2 == 0 ){

            }

        }*/

        for (Integer temp : numbers) {
            if (temp%2==0){
                mResult.add(temp);
            }
        }
        return mResult;

    }
}
