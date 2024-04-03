import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFile {
    private StringBuilder content;
    private String type;
    private String name;

    public TextFile(String type,String name) {
        this.content = new StringBuilder();
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void readAFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public String getContent() {
        return content.toString();
    }

    public String getName() {
        return name;
    }
}
