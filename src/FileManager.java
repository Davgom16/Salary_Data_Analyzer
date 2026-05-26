import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> readFile(String fileName) throws Exception {

        List<String> data = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileReader(fileName))) {

            while (scanner.hasNext()) {
                data.add(scanner.nextLine());
            }
        }

        return data;
    }
}