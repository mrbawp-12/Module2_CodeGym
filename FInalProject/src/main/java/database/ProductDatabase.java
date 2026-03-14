package database;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private static final File file = new File("data/product.csv");

    public static ArrayList<Product> getList(){
        ArrayList<Product> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data;
            while ((data =  bufferedReader.readLine()) != null) {
                String[] lineSplit = data.split(",");
                int id = Integer.parseInt(lineSplit[0]);
                String name = lineSplit[1];
                int quantity = Integer.parseInt(lineSplit[2]);
                double price = Double.parseDouble(lineSplit[3]);
                int idCategory = Integer.parseInt(lineSplit[4]);
                Product product = new Product(id, name, quantity, price, idCategory);
                list.add(product);
            }
            return  list;
        } catch (IOException e) {
            System.out.println("ReadAndWriteFile.getList.errorMessage: " + e.getMessage());
        }
        return list;
    }

    public static void saveData(List<Product> list){
     try {
         String lines = "";
         for (Product s : list) {
             lines += s.getId() + "," + s.getName() + "," + s.getQuantity() + "," + s.getPrice() + "," + s.getIdCategory() + "\n";
         }
         FileWriter fileWriter = new FileWriter(file);
         BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
         bufferedWriter.write(lines);
         bufferedWriter.close();
     }catch (IOException e) {
         System.out.println("saveData: " + e.getMessage());
        }
    }
}
