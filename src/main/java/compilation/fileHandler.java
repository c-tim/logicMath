package compilation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class fileHandler {

    public static String lastFileUsed;

    public static String readFile(String inputFile) throws IOException {
        String input = null;
        try {
            input = Thread.currentThread().getContextClassLoader().getResource(inputFile).getPath();

            System.setIn(new java.io.FileInputStream(input));
            Printer.printLogFileAccess(true, inputFile);

        } catch (java.io.FileNotFoundException e) {
            Printer.printLogFileAccess(false, inputFile);
        } catch (NullPointerException e) {
            Printer.printLogFileAccess(false, inputFile);
        }

        return convertFileInputStreamToString(new java.io.FileInputStream(input));
    }

    private static String convertFileInputStreamToString(FileInputStream f) throws IOException {
        BufferedReader br;
        StringBuilder sb;

        br = new BufferedReader(new InputStreamReader(f, "UTF-8"));

        sb = new StringBuilder();
        String line;

        if ((line = br.readLine()) != null) {
            sb.append(line);
        }

        while ((line = br.readLine()) != null) {
            sb.append('\n');
            sb.append(line);
        }

        return sb.toString();

    }
}
