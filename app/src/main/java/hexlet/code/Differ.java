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


        List<Difference> compareResult = Comparator.compare(fileParsed1, fileParsed2);

        return format(compareResult, format);
    }

    public static String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath).normalize();
        if (!path.isAbsolute()) {
            path = Paths.get("src", "main", "resources", filePath).toAbsolutePath().normalize();
        }
        return Files.readString(path);
    }

    private static String getFileType(String filePath) {
        var results = filePath.split("\\.");
        return results[results.length - 1];
    }

    private static String format(List<Difference> compareResult, String format) {
        return switch (format) {
            case "stylish" -> StylishFormater.format(compareResult);
            case null -> "";
            default -> throw new RuntimeException("format not supported");
        };
    }
}
