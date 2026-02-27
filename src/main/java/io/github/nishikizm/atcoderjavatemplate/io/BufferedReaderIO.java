package io.github.nishikizm.atcoderjavatemplate.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class BufferedReaderIO implements InputReader {
    private final BufferedReader br;
    private StringTokenizer st;

    public BufferedReaderIO(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
    }

    @Override
    public String next() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if(line == null) { throw new NoSuchElementException("No more elements available."); }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    @Override
    public int nextInt() throws IOException { return Integer.parseInt(next()); }

    @Override
    public long nextLong() throws IOException { return Long.parseLong(next()); }

    @Override
    public double nextDouble() throws IOException { return Double.parseDouble(next()); }
}
