package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "genDiff", version = "genDiff 1.0",mixinStandardHelpOptions = true, description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {
    public static void main(String[] args) {
        int exitCode =new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {

    }
}
