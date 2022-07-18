package calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class FileIo implements Io {

    private final File file;

    public FileIo(final String fileName) {
        assert null != fileName;
        file = new File(fileName);
    }

    @Override
    public void onNewLineProcessingStart() {
    }

    @Override
    public boolean doneProcessing(final Scanner scanner) {
        return !scanner.hasNextLine();
    }

    @Override
    public Scanner getSource() throws FileNotFoundException {
        return new Scanner(file);
    }

    @Override
    public String readLine(final Scanner scanner) {
        return scanner.nextLine();
    }

}
