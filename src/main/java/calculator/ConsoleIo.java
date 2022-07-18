package calculator;


import java.io.InputStream;
import java.util.Scanner;

public final class ConsoleIo implements Io {
    private static final String WELCOME = "Введите необходимые параметры. Для завершения введите EXIT";
    public static final String EXIT = "EXIT";

    private final InputStream in;
    private String lastReadLine;

    public ConsoleIo() {
        this.in = System.in;
        this.lastReadLine = "";
    }

    @Override
    public void onNewLineProcessingStart() {
        if (!lastReadLine.equalsIgnoreCase(EXIT))
            System.out.println(WELCOME);
    }

    @Override
    public boolean doneProcessing(final Scanner scanner) {
        return EXIT.equalsIgnoreCase(lastReadLine);
    }

    @Override
    public Scanner getSource() {
        return new Scanner(in);
    }

    @Override
    public String readLine(final Scanner scanner) {
        lastReadLine = scanner.nextLine();
        return lastReadLine;
    }
}
