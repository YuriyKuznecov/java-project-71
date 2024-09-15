package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;


public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        String content1 = readFile(filePath1);
        String content2 = readFile(filePath2);

        String fileFormat1 = getFileType(filePath1);
        String fileFormat2 = getFileType(filePath2);

        Map<String, Object> fileParsed1 = Parser.parse(content1, fileFormat1);
        Map<String, Object> fileParsed2 = Parser.parse(content2, fileFormat2);


        List<Map<String, Object>> compareResult = Comparator.compare(fileParsed1, fileParsed2);

        return Formatter.format(compareResult, format);
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }

    private static String readFile(String filePath) throws IOException {
        Path path = Paths.get("src", "test", "resources", "fixtures", filePath).toAbsolutePath().normalize();
        return Files.readString(path);
    }

    private static String getFileType(String filePath) {
        var results = filePath.split("\\.");
        return results[results.length - 1].toLowerCase();
    }
}
