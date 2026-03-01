import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        StringBuilder ans = new StringBuilder();



        System.out.print(ans);
    }

    private static int[] getIntArray(FastScanner sc, int num) throws IOException {
        int[] resultArray = new int[num];
        for(int i = 0; i < num; i++) {
            resultArray[i] = sc.nextInt();
        }
        return resultArray;
    }

    private static long[] getLongArray(FastScanner sc, int num) throws IOException {
        long[] resultArray = new long[num];
        for(int i = 0; i < num; i++) {
            resultArray[i] = sc.nextLong();
        }
        return resultArray;
    }

    private static double[] getDoubleArray(FastScanner sc, int num) throws IOException {
        double[] resultArray = new double[num];
        for(int i = 0; i < num; i++) {
            resultArray[i] = sc.nextDouble();
        }
        return resultArray;
    }
}

class FastScanner {
    private final BufferedReader br;
    private StringTokenizer st;

    FastScanner(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
    }

    String next() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if(line == null) { throw new NoSuchElementException("No more elements available."); }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    int nextInt() throws IOException { return Integer.parseInt(next()); }
    long nextLong() throws IOException { return Long.parseLong(next()); }
    double nextDouble() throws IOException { return Double.parseDouble(next()); }
}
