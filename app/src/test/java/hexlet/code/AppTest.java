package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    private static final String FILE_1 = "src/test/resources/fixtures/file1";
    private static final String FILE_2 = "src/test/resources/fixtures/file2";
    private static String stylish;
    private static String plain;
    private static String json;

    private static Path getFixturesPath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName).toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws IOException {
        Path path = getFixturesPath(fileName);
        return Files.readString(path);
    }

    @BeforeAll
    public static void beforeAll() throws IOException {
        stylish = readFixture("resultStylish.txt");
        plain = readFixture("resultPlain.txt");
        json = readFixture("resultJson.json");
    }

    @ParameterizedTest
    @ValueSource(strings = {".json", ".yml"})
    public void testStylishFormat(String s) throws IOException {
        var actual = Differ.generate(FILE_1 + s, FILE_2 + s, "stylish");
        assertEquals(stylish, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {".json", ".yml"})
    public void testPlainFormat(String s) throws IOException {
        var actual = Differ.generate(FILE_1 + s, FILE_2 + s, "plain");
        assertEquals(plain, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {".json", ".yml"})
    public void testJsonFormat(String s) throws IOException {
        var actual = Differ.generate(FILE_1 + s, FILE_2 + s, "json");
        assertEquals(json, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {".json", ".yml"})
    public void testDefaultFormat(String s) throws IOException {
        var actual = Differ.generate(FILE_1 + s, FILE_2 + s);
        assertEquals(stylish, actual);
    }
}




