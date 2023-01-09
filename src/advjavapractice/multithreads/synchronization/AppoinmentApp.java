package advjavapractice.multithreads.synchronization;

public class AppoinmentApp {

//Multithreading programlamada birden fazla Thread aynı anda ortak bir kaynağa erişmeye çalışırsa
//istenmeyen sonuçlar oluşacaktır. Bu durumda threadlere sırayla erişim vermek gerekecektir.
// Bir thread kaynağı kullanıyorken diğerleri onu beklemelidirler. Bu "synchronized" keywordü ile sağlanır.
//synchronized keywordu method ve bloklarda kullanilir degiskenlerde kullanilamaz
/*
Task: Bir randevu oluşturma uygulaması tasarlayınız.(AppoinmentCenter)
      Uygulama herbir talep için bir gün sonrasına tarih
      vermelidir.
*/

    public static void main(String[] args) {

        String[] users = {"Tolstoy","VictorHugo","Balzac","Dostoyevski","JohnSteinbeck"};
        AppoinmentCenter appoinmentCenter = new AppoinmentCenter();

        for (String user:users){
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().setName(user);
                    String name = Thread.currentThread().getName();
                    System.out.format("Sayin %-16s, Randevu tarihiniz : %10s %n",name,appoinmentCenter.getAppoinmentDate());
                }
            });
            thread1.start();
        }


    }
}
