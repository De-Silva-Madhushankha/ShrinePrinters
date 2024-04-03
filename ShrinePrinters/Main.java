public class Main {

    public static void main(String[] args) {

        TextFile toPrint1 = new TextFile("pdf","Sample1");
        toPrint1.readAFile("Sample01.txt");
        TextFile toPrint2 = new TextFile("txt","Sample2");
        toPrint2.readAFile("Sample02.txt");
        TextFile toPrint3 = new TextFile("java","Sample3");
        toPrint3.readAFile("Sample03.txt");

        SharedQueue printQueue = new SharedQueue();

        Thread com1 = new Computer(toPrint1,printQueue);
        com1.setName("Computer1");
        com1.setPriority(8);

        Thread com2 = new Computer(toPrint2,printQueue);
        com2.setName("Computer2");
        com2.setPriority(8);

        Thread com3 = new Computer(toPrint3,printQueue);
        com3.setName("Computer3");
        com3.setPriority(8);

        Thread printer1 = new Printer(printQueue);
        printer1.setName("Printer1");
        printer1.setPriority(2);

        Thread printer2 = new Printer(printQueue);
        printer2.setName("Printer2");
        printer2.setPriority(2);

        com1.start();
        com2.start();
        com3.start();
        printer1.start();
        printer2.start();

        try{
            com1.join();
            com2.join();
            com3.join();
            printer1.join();
            printer2.join();
        } catch (InterruptedException e) {
            System.out.println("Error!");
        }
    }
}
