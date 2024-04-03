public class Printer extends Thread {

    private SharedQueue printQueue;

    Printer (SharedQueue printQueue){
        this.printQueue = printQueue;
    }

    public void run(){
       while (true) {
            try {
                PrintJob job = printQueue.fetch();
                if (job.isSupportedType()) {
                    String currentThread = Thread.currentThread().getName();
                    System.out.println(currentThread + " : PROCESSING");
                    System.out.println(currentThread + " : Successfully Printed " + job.getToPrint().getName());
                } else {
                    throw new TypeNotSupportedException("Unsupported file type.");
                }

            } catch (TypeNotSupportedException ex) {
                System.out.println(ex.getMessage());
            } catch (InterruptedException e) {
                System.out.println("error!");
            }
       }
    }
}
