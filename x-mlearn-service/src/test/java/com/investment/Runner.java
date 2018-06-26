package com.investment;

import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.*;

public class Runner {

    @Test
    public void splitFile() throws IOException, ParseException {
        String testFilePath = "C:\\work02\\antd-train-server\\x-mlearn-service\\src\\test\\resources\\atec_anti_fraud_train.csv";
        FileReader reader = new FileReader(testFilePath);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        line = bufferedReader.readLine();
        Map<String, List<String>> lines = new HashMap<>();
        while (line != null) {
            String content = line.substring(1, line.length() - 1);
            String[] items = content.split("\",\"");
            String month = items[2].substring(0, 6);
            List<String> list = lines.get(month);
            if (list == null) {
                list = new LinkedList<>();
                lines.put(month, list);
            }
            list.add(line);
            if (list.size() > 5000) {
                for (String key : lines.keySet()) {
                    File file = new File("C:\\work02\\antd-train-server\\x-mlearn-service\\src\\test\\resources\\" + key + ".csv");
                    Files.asCharSink(file, Charset.defaultCharset(), FileWriteMode.APPEND).writeLines(lines.get(key));
                    lines.get(key).clear();
                }
            }
            line = bufferedReader.readLine();
        }
        for (String key : lines.keySet()) {
            File file = new File("C:\\work02\\antd-train-server\\x-mlearn-service\\src\\test\\resources\\" + key + ".csv");
            Files.asCharSink(file, Charset.defaultCharset(), FileWriteMode.APPEND).writeLines(lines.get(key));
            lines.get(key).clear();
        }
    }

    @Test
    public void test() throws IOException {
        String testFilePath = "C:\\work02\\antd-train-server\\x-mlearn-service\\src\\test\\resources\\201711.csv";
        FileReader reader = new FileReader(testFilePath);
        BufferedReader bufferedReader = new BufferedReader(reader);
        int index = 0;
        BitSet[] columnBitSet = new BitSet[99500];
        long[] dateArray = new long[99500];
        int[] labelArray = new int[99500];
        double[][] lineModelList = new double[99000][301];
        String line = bufferedReader.readLine();
        line = bufferedReader.readLine();
        while (line != null) {
            String content = line.substring(1, line.length() - 1);
            String[] items = content.split("\",\"");
            dateArray[index] = (Long.parseLong(items[1]));
            labelArray[index] = (Integer.parseInt(items[2]));
            for (int i = 3; i < items.length; i++) {
                String item = items[i];
                if (StringUtils.isNotBlank(item)) {
                    BitSet bitSet = columnBitSet[index];
                    if (bitSet == null) {
                        bitSet = new BitSet();
                        columnBitSet[index] = bitSet;
                    }
                    bitSet.set(i);
                    lineModelList[index][i] = Double.parseDouble(item);
                }
            }
            line = bufferedReader.readLine();
            index++;
            System.out.println(index);
        }
        System.out.println(index + "#" + lineModelList.length);
    }
}
