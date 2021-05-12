package lambda;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferReaderProcessor {
    String bufferReaderProcessor(BufferedReader br) throws IOException;
}
