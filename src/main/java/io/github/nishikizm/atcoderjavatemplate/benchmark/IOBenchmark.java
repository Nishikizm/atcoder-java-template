package io.github.nishikizm.atcoderjavatemplate.benchmark;

import java.io.FileInputStream;
import java.io.IOException;
import io.github.nishikizm.atcoderjavatemplate.io.BufferedReaderIO;
import io.github.nishikizm.atcoderjavatemplate.io.ScannerIO;

public class IOBenchmark {

    @FunctionalInterface
    private interface IOConsumer<T> {
        void accept(T t) throws IOException;
    }

    public static void main(String[] args) {

        String intFile = "benchmark-data/generated/int.txt";
        String longFile = "benchmark-data/generated/long.txt";
        String doubleFile = "benchmark-data/generated/double.txt";
        
        try {
            calculate(sc -> sc.nextInt(), br -> br.nextInt(), intFile);
            System.out.println();
            calculate(sc -> sc.nextLong(), br -> br.nextLong(), longFile);
            System.out.println();
            calculate(sc -> sc.nextDouble(), br -> br.nextDouble(), doubleFile);
            System.out.println();
        } catch(IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    private static void calculate(IOConsumer<ScannerIO> slow, 
                                    IOConsumer<BufferedReaderIO> fast, 
                                    String path) throws IOException {
        try(FileInputStream sFis = new FileInputStream(path)) {
            ScannerIO sc = new ScannerIO(sFis);

            long scStart = System.nanoTime();
            slow.accept(sc);
            long scEnd = System.nanoTime();
            long scDiff = scEnd - scStart;
            System.out.print("Scanner: " + (scDiff / 1_000_000) + "ms ");
        }

        try(FileInputStream bFis = new FileInputStream(path)) {
            BufferedReaderIO br = new BufferedReaderIO(bFis);

            long brStart = System.nanoTime();
            long brEnd = System.nanoTime();
            fast.accept(br);
            long brDiff = brEnd - brStart;
            System.out.print("BufferedReader: " + (brDiff / 1_000_000) + "ms ");
        }
    }
}
