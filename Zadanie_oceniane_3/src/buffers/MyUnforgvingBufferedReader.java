package buffers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class MyUnforgvingBufferedReader extends BufferedReader {
    private final Map<String, Integer> linesOccurances = new HashMap<>();
    private boolean lastLineDublicated;

    public MyUnforgvingBufferedReader(Reader in) {
        super(in);
    }

    @Override
    public String readLine() throws IOException {
        String result = super.readLine();
        int currentOccurances = 1;
        this.lastLineDublicated = false;

        if (linesOccurances.containsKey(result)) {
            currentOccurances += linesOccurances.get(result);
            this.lastLineDublicated = true;
        }
        linesOccurances.put(result, currentOccurances);

        return result;
    }

    public String myReadLine() throws IOException {
        String result = readLine();

        if (lastLineDublicated) {
            System.out.println("Ta linijka sie potworzyla - wystepuje po raz " + linesOccurances.get(result) + ":");
            System.out.println(result);
        }

        return result;
    }
}
