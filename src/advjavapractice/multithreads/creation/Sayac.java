package advjavapractice.multithreads.creation;

public class Sayac extends Thread {

    private String name;

    public Sayac(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        for (int i=0;i<=100;i++){
            System.out.println(this.name+" - "+i);
        }
        System.out.println(this.name+" bitirdi.");
    }
}
