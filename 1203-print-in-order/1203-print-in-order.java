class Foo {
    volatile int counter = 1;
    public Foo() {
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Runnable first = () -> System.out.println("first"); 
        Runnable second = () -> System.out.println("second"); 
        Runnable third = () -> System.out.println("third"); 
        executor.execute(first);
        executor.execute(second);
        executor.execute(third);
        executor.shutdown();

    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        counter++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(counter != 2){

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        counter++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(counter != 3){
            
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}