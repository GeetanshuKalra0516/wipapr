//package com.wip.view;
//
//import java.util.Scanner;
//
//import com.wip.controller.ProductController;
//import com.wip.controller.ProductInterface;
//
//public class MainClass {
//
//	public static void main(String[] args) {
//
//		System.out.println("Welcome to Ecom - App !!");
//		ProductInterface pc = new ProductController();
//		Scanner sc = new Scanner(System.in);
//		String continueChoice=null;
//		
//		do {
//			System.out.println("Enter your choice:");
//			System.out.println("1. Add Product");
//			System.out.println("2. View Product");
//			System.out.println("3. Add Elec. Product");
//			System.out.println("4. View Elec. Product");
//			System.out.println("5. Update Product");
//			System.out.println("6. Delete Product");
//			int choice = sc.nextInt();
//			switch (choice) {
//			case 1: {
//				pc.addProduct();
//				break;
//			}
//			case 2: {
//
//				pc.viewProduct();
//				break;
//			}
//			case 3: {
//
//				pc.viewProduct();
//				break;
//			}
//			case 4: {
//
//				pc.viewProduct();
//				break;
//			}
//			case 5: {
//
//				pc.updateProduct();
//				break;
//			}
//			case 6: {
//
//				pc.deleteProduct();
//				break;
//			}
//			default: {
//				System.out.println("Choose the right choice ....");
//			}
//			}
//			System.out.println("Do u wanna to continue? Y or y");
//			continueChoice = sc.next();
//		} while (continueChoice.equals("Y") || continueChoice.equals("y"));
//		
//		System.out.println("Thanks for using the system...");
//		System.exit(0);
//	}
//}
package com.wip.view;

import java.util.Scanner;
import java.util.function.BiPredicate;

import com.wip.controller.ProductController;
import com.wip.controller.ProductInterface;

public class MainClass {

    public static void main(String[] args) {

        System.out.println("Welcome to Ecom - App !!");
        ProductInterface pc = new ProductController();
        Scanner sc = new Scanner(System.in);
        String continueChoice = null;

    
        BiPredicate<String, String> shouldContinue = 
                (input, valid) -> input.equalsIgnoreCase(valid);

        do {
            System.out.println("Enter your choice:");
            System.out.println("1. Add Product");
            System.out.println("2. View Product");
            System.out.println("3. Add Elec. Product");
            System.out.println("4. View Elec. Product");
            System.out.println("5. Update Product");
            System.out.println("6. Delete Product");

            int choice = sc.nextInt();
            switch (choice) {
                case 1: pc.addProduct(); break;
                case 2: pc.viewProduct(); break;
                case 3: pc.addProduct(); break; // corrected
                case 4: pc.viewProduct(); break; // corrected
                case 5: pc.updateProduct(); break;
                case 6: pc.deleteProduct(); break;
                default: System.out.println("Choose the right choice ....");
            }

            System.out.println("Do u wanna to continue? Y or y");
            continueChoice = sc.next();

        } while (shouldContinue.test(continueChoice, "Y"));

        System.out.println("Thanks for using the system...");
        System.exit(0);
    }
}
