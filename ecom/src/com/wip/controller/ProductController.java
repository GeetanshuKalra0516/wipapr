//package com.wip.controller;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Scanner;
//
//import com.wip.dao.ProductDao;
//import com.wip.model.Product;
//
//public class ProductController implements ProductInterface {
//
//	Product pr; // Class Instantiation
//	Scanner sc = new Scanner(System.in);
//	List<Product> prList = new ArrayList<>();
//	ProductDao dao = new ProductDao();
//
//	public void addProduct() {
//		pr = new Product();
//		System.out.println("Enter the Prod ID:");
//		int prid = sc.nextInt();
//		pr.setPid(prid);
//
//		System.out.println("Enter the Prod Name:");
//		String prName = sc.next();
//		pr.setPname(prName);
//		// pr = new Product(prid,prName);
//
//		prList.add(pr);
//		dao.insertProduct(pr);
//		System.out.println("Product Added Successfully !!!");
//
//	}
//
//	public void viewProduct() {
//		System.out.println(pr.getPid() + " -- " + pr.getPname());
//		System.out.println(prList);
//		Iterator itlist  = prList.iterator();
//		while(itlist.hasNext()) {
//			System.out.println(itlist.next());
//		}
//		dao.retrieveProducts();
//	}
//
//	public void updateProduct() {
//		dao.updateProduct();
//	}
//
//	public void deleteProduct() {
//		dao.deleteProduct();
//	}
//
//}
package com.wip.controller;

import java.util.List;
import java.util.Scanner;
import com.wip.dao.ProductDao;
import com.wip.model.Product;

public class ProductController implements ProductInterface {

    private Scanner sc = new Scanner(System.in);
    private ProductDao dao = new ProductDao();

    public void addProduct() {
        System.out.println("Enter the Prod ID:");
        int prid = sc.nextInt();

        System.out.println("Enter the Prod Name:");
        String prName = sc.next();

        Product pr = new Product(prid, prName);
        dao.insertProduct(pr);
        System.out.println("Product Added Successfully!");
    }

    public void viewProduct() {
        dao.retrieveProducts(); // DAO prints products directly
    }

    public void updateProduct() {
        System.out.println("Enter Product ID to update:");
        int pid = sc.nextInt();

        System.out.println("Enter new Product Name:");
        String newName = sc.next();

        dao.updateProduct(pid, newName);
        System.out.println("Product Updated Successfully!");
    }

    public void deleteProduct() {
        System.out.println("Enter Product ID to delete:");
        int pid = sc.nextInt();

        dao.deleteProduct(pid);
        System.out.println("Product Deleted Successfully!");
    }
}
