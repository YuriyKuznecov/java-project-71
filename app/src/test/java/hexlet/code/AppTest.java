package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
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
    public void testCall() throws Exception {
        var expectedJson = readFixture("result.json");
        var actual = Differ.generate("file1.json", "file2.json", "stylish");
        assertEquals(expectedJson, actual );
    }

}