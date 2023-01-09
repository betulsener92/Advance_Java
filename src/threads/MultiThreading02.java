package threads;

public class MultiThreading02 {

    //thread ler ayni kaynaga erismek isterlerse ne olacak?

    public static int counter =0;

    public static void main(String[] args) {
        // !!! ayri 2 thread olusturup ayni kaynaga erismesini saglayalim
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("Thread1 calisti");
            }
        });
        thread1.start();


            //thread1.join();


        //2.thread olusturuyoruz
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("Thread2 calisti");
            }
        });
        thread2.start();


    }
}

class Counter{
    public synchronized static void count(){  //synchronized ile bu methoda giren threadleri siraya koymuş olduk
                                              //Method icine ayni anda sadece 1 thread girebilecek
        for (int i=1;i<=1000;i++){
            MultiThreading02.counter++;
        }
        System.out.println("Counter: "+MultiThreading02.counter);  //1000
    }
}
