package myPractice;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics <T>{

    T[] arrayList;



    int capacity;

    public Generics() {
    }

    public Generics(int capacity) {
        this.capacity = capacity;
    }

    public void size(){
      List<T> myList = new ArrayList<>(Arrays.asList(arrayList));
        System.out.println(myList.size());
    }

    public void getCapacity(){

    }
}
