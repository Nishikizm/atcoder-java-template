package io.github.nishikizm.atcoderjavatemplate.io;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerIO implements InputReader {
    private final Scanner sc;

    public ScannerIO(InputStream is) {
        sc = new Scanner(is);
    }

    @Override
    public String next() { 
        try{
            return sc.next(); 
        } catch(NoSuchElementException e) {
            throw new NoSuchElementException("No more elements available.");
        }
    }

    @Override
    public int nextInt() {
        try{
            return sc.nextInt(); 
        } catch(NoSuchElementException e) {
            throw new NoSuchElementException("No more elements available.");
        }
    }

    @Override
    public long nextLong() {
        try{
            return sc.nextLong(); 
        } catch(NoSuchElementException e) {
            throw new NoSuchElementException("No more elements available.");
        }
    }

    @Override
    public double nextDouble() {
        try{
            return sc.nextDouble(); 
        } catch(NoSuchElementException e) {
            throw new NoSuchElementException("No more elements available.");
        }
    }
}
