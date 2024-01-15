package manager;

import io.ProductIO;
import io.Product_IO_Binary;
import model.Product;
import validate.ValidateProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageProduct {
    List<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void add(Product p) {
        products.add(p);
    }

    public void read() {
        products = Product_IO_Binary.read();
    }
    public void write() {
        Product_IO_Binary.write(products);
    }


    public Product create() {
        int id = ValidateProduct.id(products);
        String name = ValidateProduct.name(products);
        double price = ValidateProduct.price();
        int quantity = ValidateProduct.quantity();
        System.out.println("Nhập mô tả sản phẩm");
        String content = scanner.nextLine();
        return new Product(id, name, price, quantity, content);
    }

    public void edit() {
        try {
            System.out.println("Nhập id muốn sửa");
            int id = Integer.parseInt(scanner.nextLine());
            int index = findIndexById(id);
            if (index != -1) {
                products.set(index, create());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete() {
        try {
            System.out.println("Nhập id muốn xóa");
            int id = Integer.parseInt(scanner.nextLine());
            int index = findIndexById(id);
            if (index != -1) {
                products.remove(index);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void display() {
        System.out.println("ID, Name, Price, Quantity, Content");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public int findIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void sortProduct() {
        for (int i = 0; i < products.size(); i++) {
            for (int j = 0; j < products.size() - i - 1; j++) {
                if (products.get(j).getPrice() > products.get(j + 1).getPrice()) {
                    Product temp = products.get(j);
                    products.set(j, products.get(j + 1));
                    products.set(j + 1, temp);
                }
            }
        }
    }

    public Product findProductMax() {
        if (products.size() > 0) {
            Product max = products.get(0);
            for (Product p : products) {
                if (p.getPrice() > max.getPrice()) {
                    max = p;
                }
            }
            return max;

        } else {
            return null;
        }
    }
}
