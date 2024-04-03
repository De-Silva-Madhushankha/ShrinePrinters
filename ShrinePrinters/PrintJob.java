import java.util.ArrayList;
public class PrintJob {

    public static ArrayList<String> supportedTypes = new ArrayList<>() ;
    private TextFile toPrint;

    static{
        supportedTypes.add("pdf");
        supportedTypes.add("txt");
        supportedTypes.add("docx");
    }

    public PrintJob(TextFile toPrint) {
        this.toPrint = toPrint;
    }

    public boolean isSupportedType(){
        return supportedTypes.contains(toPrint.getType());
    }

    public TextFile getToPrint() {
        return toPrint;
    }

}
