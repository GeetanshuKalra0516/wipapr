//package com.wip.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import com.wip.model.Product;
//import com.wip.util.MyDBConnection;
//
//public class ProductDao {
//
//	Connection con;
//	Statement stmt;
//	PreparedStatement ps;
//	ResultSet rs;
//
//	public void insertProduct(Product pr) {
//		try {
//			con = MyDBConnection.getMyDBConnection();
//			ps = con.prepareStatement("insert into product values(?,?)");
//			ps.setInt(1, pr.getPid());
//			ps.setString(2, pr.getPname());
//			int noofrows = ps.executeUpdate();
//			System.out.println(noofrows + " inserted successfully !!!!");
//
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//
//	}
//
//	public void retrieveProducts() {
//		try {
//			con = MyDBConnection.getMyDBConnection();
//			stmt = con.createStatement();
//			rs = stmt.executeQuery("select * from product");
//			while (rs.next()) {
//				System.out.println(rs.getInt(1) + " -- " + rs.getString(2));
//
//			}
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//
//	}
//
//	public void updateProduct() {
//update Product set pname=? where pid=?
//		try {
//			con = MyDBConnection.getMyDBConnection();
//
//			ps = con.prepareStatement(
//					"update product set pname=? where pid=?");
//
//			ps.setString(1, pr.getPname());
//			ps.setInt(2, pr.getPid());
//
//			int noofrows = ps.executeUpdate();
//
//			System.out.println(noofrows + " updated successfully !!!!");
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void deleteProduct() {
//delete from product where pid=?;
//		try {
//			con = MyDBConnection.getMyDBConnection();
//
//			ps = con.prepareStatement(
//					"delete from product where pid=?");
//
//			ps.setInt(1, pid);
//
//			int noofrows = ps.executeUpdate();
//
//			System.out.println(noofrows + " deleted successfully !!!!");
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}
package com.wip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wip.model.Product;
import com.wip.util.MyDBConnection;

public class ProductDao {

    // Insert product
    public void insertProduct(Product pr) {
        try (Connection con = MyDBConnection.getMyDBConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO product VALUES(?,?)")) {

            ps.setInt(1, pr.getPid());
            ps.setString(2, pr.getPname());
            int noofrows = ps.executeUpdate();
            System.out.println(noofrows + " row(s) inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve all products
    public void retrieveProducts() {
        try (Connection con = MyDBConnection.getMyDBConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM product")) {

            while (rs.next()) {
                System.out.println(rs.getInt("pid") + " -- " + rs.getString("pname"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update product by ID
    public void updateProduct(int pid, String newName) {
        try (Connection con = MyDBConnection.getMyDBConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE product SET pname=? WHERE pid=?")) {

            ps.setString(1, newName);
            ps.setInt(2, pid);
            int noofrows = ps.executeUpdate();
            System.out.println(noofrows + " row(s) updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete product by ID
    public void deleteProduct(int pid) {
        try (Connection con = MyDBConnection.getMyDBConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM product WHERE pid=?")) {

            ps.setInt(1, pid);
            int noofrows = ps.executeUpdate();
            System.out.println(noofrows + " row(s) deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

