package calculator;

import java.io.FileNotFoundException;
import java.util.Scanner;

public interface Io {

    void onNewLineProcessingStart();

    boolean doneProcessing(final Scanner scanner);

    Scanner getSource() throws FileNotFoundException;

    String readLine(Scanner scanner);

}
