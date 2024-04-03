import java.util.concurrent.LinkedBlockingQueue;

public class SharedQueue {

    private int currentSize;
    private LinkedBlockingQueue<PrintJob> queue = new LinkedBlockingQueue<>(5);

    public void addToQueue(PrintJob toPrint) throws InterruptedException {
        queue.put(toPrint);
    }

    public synchronized PrintJob fetch() throws InterruptedException {
        return queue.take();
    }

    public int getCurrentSize() {
        return queue.size();
    }
}
