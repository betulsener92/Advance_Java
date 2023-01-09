package Generics.bounding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenericLowerBoundAndWildCard {
    public static void main(String[] args) {

        //*********** addElements *********
        List<Object> ol = new ArrayList<>();
        addElements(ol);

        List<Integer> nl = new ArrayList<>();
        addElements(nl);

//        List<Double> dl = new ArrayList<>();
//        addElements(dl);  // CTE ,  Generic oncesi yapilarda RunTE olurdu


        //****** printElements ********
//        List<String> st = new ArrayList<>();
//        printElements(st);
        printElements(new ArrayList<String>());


        //****** printObj ********
        List<String> strList = new ArrayList<>();
        //printObj(strList);  // CTE

        List<Object> objectList = new ArrayList<>();
        printObj(objectList);

    }



    // super Integer ---> Bana Integer in parentlarini getir
    public static void addElements(List<? super Integer> list){
        // ? : WildCard (tipi bilinmeyen)
        for (int i=1; i<=10; i++){
            list.add(i);
        }
    }



    //WildCard dezavantajlari(sinirlamalari)
    public static void printElements(List<?> listOfUnknown){
        //listOfUnknown.add("Java");  -->? dan dolayi Data türü netlesmeden add methodu gibi islemleri yaptirmaz
        //listOfUnknown.add(null);  // illa eklenecekse null eklenebilir

        for (Object object : listOfUnknown){
            System.out.println(object);
        }
    }

    // ? -->Object
    public static void printObj(List<Object> listOfObject){
        listOfObject.add("Java");
        for (Object object : listOfObject){
            System.out.println(object);
        }
    }
}
