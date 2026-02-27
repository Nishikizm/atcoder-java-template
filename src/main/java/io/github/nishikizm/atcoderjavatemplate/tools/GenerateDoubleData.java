package io.github.nishikizm.atcoderjavatemplate.tools;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GenerateDoubleData {
     public static void main(String[] args) {
        Random rand = new Random();
        try(PrintWriter pw = new PrintWriter(new FileWriter("benchmark-data/generated/double.txt"))) {
            for(int i = 0; i < 200_000; i++) {
                for(int j = 0; j < 5; j++) {
                    pw.print(rand.nextDouble());
                    pw.print(" ");
                }
                pw.println();
            }   
        } catch(IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
