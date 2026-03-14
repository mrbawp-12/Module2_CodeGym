package database;

import model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHandler {

    private static final String FILE_PATH = "data/contacts.csv";

    // doc danh ba tu file CSV
    public static List<Contact> readFromCsv() throws IOException {
        List<Contact> list = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            throw new IOException("Khong tim thay file: " + FILE_PATH);
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        boolean isHeader = true;

        while ((line = reader.readLine()) != null) {
            // bo qua dong tieu de
            if (isHeader) {
                isHeader = false;
                continue;
            }
            if (line.trim().isEmpty()) continue;

            String[] parts = line.split(",", -1);
            if (parts.length < 7) continue;

            Contact c = new Contact(
                    parts[0].trim(),
                    parts[1].trim(),
                    parts[2].trim(),
                    parts[3].trim(),
                    parts[4].trim(),
                    parts[5].trim(),
                    parts[6].trim()
            );
            list.add(c);
        }

        reader.close();
        return list;
    }

    // ghi danh ba vao file CSV
    public static void writeToCsv(List<Contact> contacts) throws IOException {
        File dir = new File("data");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
        writer.write("phone,group,fullName,gender,address,birthDate,email");
        writer.newLine();

        for (Contact c : contacts) {
            writer.write(c.toCsvLine());
            writer.newLine();
        }

        writer.close();
    }
}