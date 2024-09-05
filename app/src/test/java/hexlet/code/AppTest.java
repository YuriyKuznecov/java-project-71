package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    private static Path getFixturesPath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName).toAbsolutePath()
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws IOException {
        Path path = getFixturesPath(fileName);
        return Files.readString(path);
    }

    @Test
    public void testStylish() throws IOException {
        var expected = readFixture("resultStylish.txt");
        var actualJson = Differ.generate("file1.json", "file2.json", "stylish");
        assertEquals(expected, actualJson);

        var actualYaml = Differ.generate("file1.yaml", "file2.yaml", "stylish");
        assertEquals(expected, actualYaml);
    }

    @Test
    public void testPlain() throws IOException {
        var expected = readFixture("resultPlain.txt");
        var actualJson = Differ.generate("file1.json", "file2.json", "plain");
        assertEquals(expected, actualJson);

        var actualYaml = Differ.generate("file1.yaml", "file2.yaml", "plain");
        assertEquals(expected, actualYaml);


    }

}
