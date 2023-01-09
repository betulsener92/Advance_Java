package threads;

public class ThreadCreationWays {
    public static void main(String[] args) {
        // İlk calisan thread main thread dir, kontrol edelim:
        System.out.println("Current Thread : " + Thread.currentThread().getName());  //main

        MyThread thread1 = new MyThread();
        //thread1.run();
        thread1.start(); //thread sinifinda run() methodunda yazilanlar islenmeye baslar

        // run() diyerekte çağırdığımızda method yine çalışıyor , start() ile çağırmamız
        // arasındaki fark : run() ile çağırıldığında thread değişmez sadece method çalışır
        // start() da ise önce thread ayağa kalkar daha sonra içindeki run() metodu çalışır

        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();

        // !!!1.YOL :  isimsiz olarak thread olusturma , annonymous (Interface)

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000); //5 saniye uyu
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Current Thread : " + Thread.currentThread().getName());
                System.out.println("Bu isimsiz sinif yoluyla olusturulan is parcacigidir");
            }
        });

        thread3.setName("Thread3");  //burayı isim atamak icin yaptık istersek yazmayabilirdik kendi bi isim atardi
        thread3.start();

        // !!!2.YOL : isimsiz olarak thread olusturalim
        Thread thread4 = new Thread(()->{
            System.out.println("Lambda ile yazildi");
        });
        thread4.start();

        System.out.println("Main methodu bitti");   // bu yazinin ciktinin neresinde gozukecegi ile ilgili kesin bir sey diyemeyiz

        Thread thread5 = new Thread(()->{
            System.out.println("Thread5 calisti");
        });
        thread5.start();


    }
}
    // 1.YOL: Threads class ini extends ederek
    class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("MyThread threadi calisiyor");
        }
    }

    // 2.YOL: Runnable Interface i implements ederek
    class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("Runnable Interfaceden uretilen thread calisti");
        }
    }

