package io.github.nishikizm.atcoderjavatemplate.tools;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GenerateIntData {
     public static void main(String[] args) {
        Random rand = new Random();
        try(PrintWriter pw = new PrintWriter(new FileWriter("benchmark-data/generated/int.txt"))) {
            for(int i = 0; i < 200_000; i++) {
                for(int j = 0; j < 5; j++) {
                    pw.print(rand.nextInt());
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
