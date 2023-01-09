package advjavapractice.multithreads.waitNotify;

/*
TASK: Bir marketteki stok miktarını takip eden bir uygulama tasarlayınız.
      Markette yeterli ürün yoksa yeni ürün gelmesi beklensin.
      Yeni ürün eklenince ürün satışı gerçekleşsin.
*/
public class ShopWaitNotify {

    public volatile static  int stock = 0;

    public static void main(String[] args) {

        ShopWaitNotify shop = new ShopWaitNotify();
        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                shop.consumeProduct(3);
            }
        });
        consumerThread.setName("Tuketici");
        consumerThread.start();


        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                shop.produceProduct(5);
            }
        });
        producerThread.setName("Uretici");
        producerThread.start();

    }

    public synchronized void consumeProduct(int amount){
        if (amount>stock){
            System.out.println(Thread.currentThread().getName()+" urun satin almak istiyor");
            System.out.println("Stokta yeterli urun yok, Guncel urun stogu: "+stock);
            System.out.println("Tuketici urun girisi yapilmasini bekliyor...");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (amount<=stock){
            System.out.println(Thread.currentThread().getName()+" urun satin almak istiyor");
            System.out.println("Urun satin alindi, stok dusuluyor");
            stock=stock-amount;
            System.out.println("Guncel stok: "+stock);
        }else {
            System.out.println(Thread.currentThread().getName()+" urun satin almak istiyor");
            System.out.println("Yeterli urun yok, Guncel stok: "+stock);
            System.out.println("bugun git yarin gel");
        }

    }
    public synchronized void produceProduct(int amount){
        System.out.println();
        System.out.println(Thread.currentThread().getName()+" urun eklemek istiyor");
        System.out.println("Yeni urun eklendi, stok guncelleniyor");
        stock = stock + amount;
        System.out.println("Guncel stok: "+stock);
        notify();
        System.out.println();
    }
}
