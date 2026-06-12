import java.util.concurrent.Semaphore;

class FizzBuzz{
    private int n;
    private int current = 1;
    private Semaphore sem = new Semaphore(1);

    public FizzBuzz(int n){
        this.n = n;
    }

    public void Fizz(Runnable printFizz){
        try {
            while (true) { 
                sem.acquire();
                if(current>n){
                    sem.release();
                    break;
                }
                if(current%3==0 && current%5!=0){
                    printFizz.run();
                    current++;
                }
                sem.release();
            }}
            catch (InterruptedException i) {} 
    }

    public void Buzz(Runnable printBuzz){
        try {
            while (true) { 
                sem.acquire();
                if(current>n){
                    sem.release();
                    break;
                }
                if(current%5==0 && current%3!=0){
                    printBuzz.run();
                    current++;
                }
                sem.release();
            }}
            catch (InterruptedException i) {} 
    }

    public void FizzBuzz(Runnable printFizzBuzz){
        try {
            while (true) { 
                sem.acquire();
                if(current>n){
                    sem.release();
                    break;
                }
                if(current%3==0 && current%5==0){
                    printFizzBuzz.run();
                    current++;
                }
                sem.release();
            }}
            catch (InterruptedException i) {} 
    }

    public void Number(Runnable printNumber){
        try {
            while (true) { 
                sem.acquire();
                if(current>n){
                    sem.release();
                    break;
                }
                if(current%3!=0 && current%5!=0){
                    printNumber.run();
                    current++;
                }
                sem.release();
            }}
            catch (InterruptedException i) {} 
    }
}

public class DemoFizzBuzz{
    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz(15);
        Thread t1 = new Thread(()->fb.Fizz(()->System.out.println("Fizz")));
        Thread t2 = new Thread(()->fb.Buzz(()->System.out.println("Buzz")));
        Thread t3 = new Thread(()->fb.FizzBuzz(()->System.out.println("FizzBuzz")));
        Thread t4 = new Thread(()->fb.Number(()->System.out.println()));
        t1.start(); t2.start(); t3.start(); t4.start();
    }
}