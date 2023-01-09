package Generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericType<T> {

    /*
       E ---> Element   Collection gibi yapilarda kullanilir
       K ---> Key
       V ---> Value     Map<K,V>
       N ---> Number
       T ---> Type
       S,U,v,... vb  ---> 2.,3. ve 4. tipler icin
     */

    private T type ;

    // GETTER -- SETTER
    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    // MAIN METHOD
    public static void main(String[] args) {
        // generic yapi kullanilarak ayni classdan 2 farkli data turunde obje olusturalim
        GenericType<String> obj1 = new GenericType<>();
        // Trick : Diomand icine non-primitive type kullanabiliriz
        obj1.setType("Generic Types");
        GenericType<String> obj2 = new GenericType<>();
        //obj1.setType(65);    String girmem gerekirken int data turunu girince CTE verdi

        //Not: Cast probleminden nasil kurtuluruz?
        GenericType<Integer> obj3 = new GenericType<>();
        obj3.setType(65);
        int a = obj3.getType();  // !!! CAST probleminden kurtulduk

        // Not: ClassCastException(RTE) probleminden nasil kurtuluruz?
        List<String> list = new ArrayList<>();
        list.add("Alper");
        list.add("Halide");
        //list.add(22);   // !!! ClassCastException dan kurtulduk

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Generic");
        //map.put("Generic",1);  // RTE almadık CTE aldık iyi oldu :)


    }
}
