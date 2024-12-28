package free;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class index2 {
    public static void main(String[] args) {
        String inputFileName = "src/free/index.java"; 
        String outputFileName = "src/free/output.java";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            ArrayList<String> lines = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            Collections.sort(lines, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() != o2.length()) {
                        return Integer.compare(o1.length(), o2.length());
                    }
                    return o1.compareTo(o2);
                }
            });

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            for (String sortedLine : lines) {
                writer.write(sortedLine);
                writer.newLine();
            }
            writer.close();

            System.out.println("ソートが完了し、" + outputFileName + " に書き出しました。");

        } catch (IOException e) {
            System.out.println("ファイル操作中にエラーが発生しました: " + e.getMessage());
        }
    }
}
