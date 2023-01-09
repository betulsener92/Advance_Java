package advjavapractice.multithreads.creation;

public class ThreadCreation2 {

    //Task2:Runnable interfaceni implement eden Counter isminde sınıf oluşturup
    // bu sınıftan harfleri a dan z ye kadar yazdıran iki tane thread oluşturunuz.

    //Task3: Threadler başlamadan önce Yarış başlasın ve bitince Yarış bitti
    //yazdırın.

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Yarıs Baslasinnnn");

        Counter c1 = new Counter("RoadRunner");
        Counter c2 = new Counter("SpeedyGonzales");
        Thread thread1 = new Thread(c1);
        Thread thread2 = new Thread(c2);


        thread1.start();
        thread2.start();

        //thread1 ve thread2 bitene kadar main thread i uyutmak istedik ama kesin çözüm değil
//        thread1.sleep(10);

        //thread1 ve thread2 bitene kadar main thread i beklet
        thread1.join();
        thread2.join();

        System.out.println("Yaris Bittiiii");

    }
}


