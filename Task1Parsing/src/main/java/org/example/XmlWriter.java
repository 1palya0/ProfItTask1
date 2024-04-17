package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class XmlWriter {
    public static void writeStatisticsToXml(Map<String, Long> statistics, String param, String outputFile) throws IOException {
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<statistics>\n");
            for (Map.Entry<String, Long> entry : statistics.entrySet()) {
                writer.write("  <item>\n");
                writer.write("    <value>" + entry.getKey() + "</value>\n");
                writer.write("    <count>" + entry.getValue() + "</count>\n");
                writer.write("  </item>\n");
            }
            writer.write("</statistics>");
        }
    }
}