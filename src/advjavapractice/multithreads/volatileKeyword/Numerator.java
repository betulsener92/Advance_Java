package advjavapractice.multithreads.volatileKeyword;

public class Numerator {

    private volatile static int counter =0;
    //volatile keywordu degiskenin main memoryde saklanmasini garanti eder ancak
    //tum threadlerin degiskene ayni anda ulasmasindan kaynakli cakismayi cozme garantisi yoktur
    //bunun icin synchronized keywordu de kullanilmali

    public void getOrder(){
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (this){
            counter++;
            System.out.println("Sayin "+name+" siraniz: "+counter);
        }

    }
}
