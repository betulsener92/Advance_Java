package Generics.bounding;

public class GenericUpperBound<T extends Number> {   //!!! ustten sinirliyorum
    private T[] numberArray;

    //constructor
     public GenericUpperBound(T[] numberArray) {
        this.numberArray = numberArray;
    }

    // array in icindeki degerlerin ortalamasini bulan method:
    public double getAverage(){
         double sum = 0;
         for (T t : numberArray){
             sum += t.doubleValue();  //double tipine donduruyor
         }
         double avg = sum/ numberArray.length;
         return avg;
    }

    //main method
    public static void main(String[] args) {
        Integer[] intArray = {2, 4, 7, 33};
        GenericUpperBound<Integer> obj1 = new GenericUpperBound<>(intArray);
        System.out.println(obj1.getAverage());

        Double[] doubleArray = {2.5, 4.6, 7.8};
        GenericUpperBound<Double> obj2 = new GenericUpperBound<>(doubleArray);
        System.out.println(obj2.getAverage());

        // !!! ClassCastException almami onluyor
//        String[] strArray = {"Java","Cok","Kolay","Hele","Generics","Tadından","Yenmez"};
//        GenericUpperBound<String> obj2 = new GenericUpperBound(strArray);
    }
}
