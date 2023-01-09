package threads;

public class Volatile {
    volatile public static int flag = 0;

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (flag == 0) {
                        System.out.println("Thread1 calisiyor");
                    } else {
                        break;
                    }
                }
            }
        });
        thread1.start();


        //thread 2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag=1;
                System.out.println("Flag değeri 1 olarak değiştirildi");
            }
        });
        thread2.start();
    }
}