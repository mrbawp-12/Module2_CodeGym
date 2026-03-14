package database;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private static final File file = new File("data/user.csv");

    public static ArrayList<User> getList() {
        ArrayList<User> list = new ArrayList<>();
        try {
            FilterReader filterReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(filterReader);
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                String[] lineSplit = data.split(","); // ["1", "Ning", "123456"]
                int id = Integer.parseInt(lineSplit[0]);
                String name = lineSplit[1];
                String password = lineSplit[2];
                User user = new User(id, name, password);
                list.add(user);
            }
            return  list;
        }catch ( IOException e){
            System.out.println("ReadAndWriteFile.getList.errorMessage: " + e.getMessage());
        }
        return list;
    }

    public static void saveData(List<User> list) {
        try {
            String lines = "";
            for (User s : list) {
                  lines += s.getId() + "," + s.getUsername() + "," + s.getPassword() + "\n";
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(lines);
            bufferedWriter.close();
        }catch (IOException e){
            System.out.println("saveData: " + e.getMessage());
        }
    }
}
