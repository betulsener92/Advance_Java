package myPractice;

public class Main {
    public static void main(String[] args) {
        Sinif_Generics obj = new Sinif_Generics();
        obj.myList.add(10);
        obj.myList.add(10);
        obj.myList.add(10);
        obj.myList.add(10);
        obj.myList.add(10);
        obj.myList.add(10);
        obj.myList.add(10);
        obj.myList.add(10);
        obj.myList.add(10);
        obj.myList.add(10);
        obj.myList.add(10);
        obj.setCapacity(20);
        System.out.println(obj.getCapacity());
        System.out.println(obj.myList.size());
    }
}
