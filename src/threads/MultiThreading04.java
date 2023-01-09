package threads;

public class MultiThreading04 {
    public static void main(String[] args) {
        Brackets2 brackets2 = new Brackets2();

        long startTime = System.currentTimeMillis();

        //thread 1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<8;i++){
                    brackets2.generateBrackets();
                }
            }
        });
        thread1.start();


        //thread 2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<8;i++){
                    brackets2.generateBrackets();
                }
            }
        });
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Toplam gecen sure: "+(endTime-startTime));
    }
}

class Brackets2{
    public void generateBrackets(){
        synchronized (this){
            for (int i=1;i<11;i++){
                if (i<=5){
                    System.out.print("[");
                }else {
                    System.out.print("]");
                }
            }
            System.out.println("");
        }


        for (int i=1;i<=5;i++){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
