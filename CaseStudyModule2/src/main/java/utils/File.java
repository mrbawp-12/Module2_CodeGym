package utils;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class File {
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    //dan file - sửa đường dẫn
    public static final String userFile = "data/users.txt";
    public static final String roomFile = "data/rooms.txt";
    public static final String invoiceFile = "data/invoices.txt";

    public File(String filePath) {}

    //doc file
    public static List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();
        java.io.File file = new java.io.File(filePath);

        if (!file.exists()) return lines;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
        return lines;
    }

    //ghi file - sửa lỗi tạo thư mục
    public static void writeFile(String filePath, List<String> lines) {
        try {
            java.io.File file = new java.io.File(filePath);
            java.io.File parentDir = file.getParentFile();

            // Kiểm tra và tạo thư mục nếu cần
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    //chuyen ngay thang
    public static LocalDate parseDate(String dateStr) {
        return LocalDate.parse(dateStr, dateFormat);
    }

    public static String formatDate(LocalDate date) {
        return date.format(dateFormat);
    }

    public static boolean isValidDate(String dateStr) {
        try {
            parseDate(dateStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}