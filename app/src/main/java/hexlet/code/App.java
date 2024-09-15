package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.util.concurrent.Callable;

@Command(name = "genDiff",
        version = "1.0",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public final class App implements Callable<Integer> {
    @Option(names = { "-f", "--format"}, paramLabel = "format", defaultValue = "stylish",
            description = "output format [default: stylish]") private String format;
    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private  String filePath1;
    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private  String filePath2;

    @Override
    public Integer call() {
        try {
            System.out.println(Differ.generate(filePath1, filePath2, format));
            return 0;
        } catch (IOException e) {
            return 1;
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
