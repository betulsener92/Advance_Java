package myPractice;

import java.util.ArrayList;
import java.util.List;

public class Sinif_Generics<T> {

    public static void main(String[] args) {

    }

    List<T> myList = new ArrayList<>(10);



    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Sinif_Generics() {
    }

    public Sinif_Generics(int capacity) {
        this.capacity = capacity;
    }
}
