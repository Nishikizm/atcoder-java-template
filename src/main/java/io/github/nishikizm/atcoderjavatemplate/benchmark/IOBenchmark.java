package io.github.nishikizm.atcoderjavatemplate.benchmark;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import io.github.nishikizm.atcoderjavatemplate.io.BufferedReaderIO;
import io.github.nishikizm.atcoderjavatemplate.io.InputReader;
import io.github.nishikizm.atcoderjavatemplate.io.ScannerIO;

public class IOBenchmark {

    @FunctionalInterface
    private interface IOSupplier<T> {
        T get(FileInputStream fis) throws IOException;
    }

    @FunctionalInterface
    private interface IOConsumer<T> {
        void accept(T t) throws IOException;
    }

    public static void main(String[] args) {

        List<String> type = List.of("int", "long", "double");
        List<IOConsumer<InputReader>> ioConsumers = List.of(
            reader -> reader.nextInt(), 
            reader -> reader.nextLong(), 
            reader -> reader.nextDouble()
        );
        List<String> paths = List.of(
            "benchmark-data/generated/int.txt", 
            "benchmark-data/generated/long.txt", 
            "benchmark-data/generated/double.txt"
        );
        
        try {
            runBenchMark(type, ioConsumers, paths);
        } catch(IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    private static void runBenchMark(
        List<String> type, 
        List<IOConsumer<InputReader>> ioConsumers, 
        List<String> paths) throws IOException {

        for(int i = 0; i < type.size(); i++) {
            System.out.println("=== " + type.get(i) + " ===");
            for(int j = 0; j < 5; j++) {
                System.out.print((j + 1) + ": ");
                calculate(ScannerIO::new, ioConsumers.get(i), paths.get(i), "Scanner");
                calculate(BufferedReaderIO::new, ioConsumers.get(i), paths.get(i), "BufferedReader");
                System.out.println();
            }
        }
    }

    private static <T extends InputReader> void calculate(
        IOSupplier<T> supplyReader, IOConsumer<T> read, String path, String type) throws IOException {
            
        try(FileInputStream fis = new FileInputStream(path)) {
            T reader = supplyReader.get(fis);

            long start = System.nanoTime();
            read.accept(reader);
            long end = System.nanoTime();

            long diff = end - start;
            System.out.print(type + ": " + (diff / 1_000_000) + "ms  ");
        }
    }
}
