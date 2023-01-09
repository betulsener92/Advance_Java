package threads;

public class WaitNotify {

    public static int balance = 0;

    public static void main(String[] args) {
        WaitNotify obj = new WaitNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(800);
            }
        });
        thread1.setName("Witdraw thread");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(2000);
            }
        });
        thread2.setName("Deposit thread");
        thread2.start();

    }

    //para cekme methodu
    public void withdraw(int amount){
        synchronized (this){
            if (balance<=0 || balance<amount){
                System.out.println("Balance degeri degisesiye kadar bekliyoruz");
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } //synchronized blog sonu

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // wait islemi bittikten sonra veye balance degeri zaten degerli ise
        balance = balance-amount;
        System.out.println("Para cekim islemi basariyla gerceklesmistir");

    }

    public void deposit(int amount){
        balance = balance+amount;
        System.out.println("Para yatirma isleminiz basariyla gerceklesmistir");

        synchronized (this){
            notify();
        }
    }
}
