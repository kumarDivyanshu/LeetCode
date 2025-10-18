class FooBar {
    private int n;
    AtomicBoolean flag = new AtomicBoolean(false);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        
        for (int i = 0; i < n; i++) {
            
            while(flag.get()){
                // this.wait();
            }
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            flag.set(true);
            // this.notifyAll();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(!flag.get()){
                // this.wait();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            flag.set(false);
            // this.notifyAll();
        }
    }
}