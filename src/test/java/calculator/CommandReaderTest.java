package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;



class CommandReaderTest {

    public static final class MockStreamTest implements Io {

        private final Reader stream;


        public MockStreamTest() {
            this.stream = new StringReader("PwSH 100");
        }

        @Override
        public void onNewLineProcessingStart() {

        }

        @Override
        public boolean doneProcessing(Scanner scanner) {
            return !scanner.hasNextLine();
        }

        @Override
        public Scanner getSource() {
            return new Scanner(stream);
        }

        @Override
        public String readLine(Scanner scanner) {
            return scanner.nextLine();
        }
    }

    @Test
    public void readCommandCorrectCommandIsEmpty() throws CalculatorException, FileNotFoundException {
        final CalculatorContext context = new CalculatorContext();
        final MockStreamTest mockStreamTest = new MockStreamTest();
        final CommandReader commandReader = new CommandReader();
        commandReader.parseCommand(mockStreamTest);


        Assertions.assertTrue(context.getCommandAndValue().isEmpty());
    }


}