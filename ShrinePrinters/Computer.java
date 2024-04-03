public class Computer extends Thread {

    TextFile toPrint;
    SharedQueue printQueue;

    Computer(TextFile toPrint,SharedQueue printQueue){
        this.toPrint = toPrint;
        this.printQueue = printQueue;
    }

    public void run(){
        try{
            PrintJob toPrintObj = new PrintJob(toPrint);
            String currentComputer = Thread.currentThread().getName();

            if(toPrintObj.isSupportedType()){
                printQueue.addToQueue(toPrintObj);
                System.out.println(currentComputer + " added job for file: " + toPrint.getName());
            }
            else{
                throw new TypeNotSupportedException(currentComputer +" failed to add job for file : "+ toPrint.getName() + "(Unsupported File Type)");
            }
        } catch (TypeNotSupportedException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }
}
