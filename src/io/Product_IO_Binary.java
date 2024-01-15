package io;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Product_IO_Binary {
    static File file = new File("products.txt");

    // Nhanh nhưng không nhìn thấy được DL đã lưu.
    public static void write(List<Product> products) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> read() {
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (List<Product>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
