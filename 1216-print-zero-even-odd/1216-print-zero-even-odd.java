class ZeroEvenOdd {
    private int n;
    Semaphore start = new Semaphore(1);
    Semaphore eve = new Semaphore(0);
    Semaphore od = new Semaphore(0);
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            start.acquire();
            printNumber.accept(0);
            if(i%2==0){
                eve.release();
            }
            else if(1%2 != 0){
                od.release();
            }

            
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            eve.acquire();
            int finalI = i;
            printNumber.accept(finalI);
            start.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            od.acquire();
            int finalI = i;
            printNumber.accept(finalI);
            start.release();
        }
    }
}