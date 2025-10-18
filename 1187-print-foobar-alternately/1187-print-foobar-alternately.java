class FooBar {
    // idea from chat gpt
    private int n;
    // Start with foo allowed ( 1 permit), bar blocked (0 permits)
    private final Semaphore fooPermit;
    private final Semaphore barPermit;


    public FooBar(int n) {
        this.n = n;
        this.fooPermit = new Semaphore(1);
        this.barPermit = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            this.fooPermit.acquire(); // wait until it's foo's trun
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            barPermit.release(); // hand off turn to bar
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            this.barPermit.acquire(); // wait until it's bar's trun
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            this.fooPermit.release();
        }
    }
}