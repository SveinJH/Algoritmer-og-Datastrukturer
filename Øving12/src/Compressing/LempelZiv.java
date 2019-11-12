package Compressing;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LempelZiv {
    private final int MAXIMUM_REWIND = 127;
    private final int MIN_LENGTH = 6;

    private String filenameIn;
    private String filenameOut;


    public LempelZiv (String filenameIn, String filenameOut) {
        this.filenameIn = filenameIn;
        this.filenameOut = filenameOut;
    }

    private byte[] readBytesFromFile() {
        try {
            return Files.readAllBytes(Paths.get(this.filenameIn));
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    private void writeDataToFile(byte[] output) {
        try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(this.filenameOut)))){
            dos.write(output);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void compressFile() {
        byte[] input = readBytesFromFile();
        byte[] output = new byte[input.length];
        int outputLength = output.length;

        byte uncompressedCount = 0;
        int uncompressedStartIndex = -1;

        if(input == null || input.length == 0) return;

        // The 'main' loop
        for(int i = 0; i < input.length; i++) {
            byte matchLength = 0;
            int matchIndex = -1;
            int newOutputLength = outputLength + 2;

            int searchStart = Math.max(0, i - MAXIMUM_REWIND);
            for(int j = searchStart; j < i; j++) {
                if(i + matchLength >= input.length) break;

                if(input[j] == input[i + matchLength]) {
                    if(matchIndex == -1) matchIndex = j;
                    matchLength++;
                    if(newOutputLength >= input.length) {
                        System.out.println("Error");
                    }
                    if(j >= input.length) {
                        System.out.println("Error");
                    }
                    output[newOutputLength++] = input[j];

                } else if(matchIndex != -1) {
                    if(matchLength >= MIN_LENGTH) {
                        break;
                    }

                    matchIndex = -1;
                    matchLength = 0;
                }
            }

            if(matchIndex != -1 && matchLength >= MIN_LENGTH) {

                if(uncompressedCount > 0) {
                    output[uncompressedStartIndex] = (byte)-uncompressedCount;
                    uncompressedStartIndex = -1;
                    uncompressedCount = 0;
                    outputLength++;
                }
                output[outputLength++] = (byte)(i - matchIndex);
                output[outputLength++] = matchLength;

                System.out.println("Found match! '" + convertToString(input, i, matchLength) + "' (" + i + ")"
                    + " with '" + convertToString(input, matchIndex, matchLength) + "' (" + matchIndex + ")");

                i += matchLength - 1;
            } else {
                if(uncompressedStartIndex == -1) {
                    uncompressedStartIndex = outputLength;
                }
                uncompressedCount++;
                System.out.println(output.length);
                output[++outputLength] = input[i];
            }

            if(uncompressedCount == 127) {
                output[uncompressedStartIndex] = -127;
                uncompressedStartIndex = -1;
                uncompressedCount = 0;
                outputLength++;
            }

        }

        if(uncompressedCount > 0) {
            output[uncompressedStartIndex] = (byte)-uncompressedCount;
            outputLength++;
        }

        writeDataToFile(output);
    }

    private String convertToString(byte[] buffer, int startIndex, int count) {
        String text = "";
        for(int i = startIndex; i < startIndex + count; i++) {
            text += (char)(buffer[i]);
        }
        return text;
    }
}
