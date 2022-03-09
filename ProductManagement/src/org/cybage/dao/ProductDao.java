package org.cybage.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.cybage.DBConnect.DBConnection;
import org.cybage.bean.Product;
public class ProductDao {
  public boolean addProduct(Product product) {
    // TODO Auto-generated method stub
    Connection con = DBConnection.getConn();
    String sql = "insert into Product (id,name,price) values (NULL,?,?) ";
    int i = 0;
    try {
      PreparedStatement preparedStatement = con.prepareStatement(sql);
      preparedStatement.setString(1, product.getName());
      preparedStatement.setString(2, product.getPrice());
      
      i = preparedStatement.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (i == 0) {
      return false;
    } else {
      return true;
    }
  }
  public boolean editProduct(Product product) {
    Connection connection = DBConnection.getConn();
    String sql = "update Product set name=?, price=?";
    sql += " where id=? ";
    int i = 0;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, product.getId());
      preparedStatement.setString(2, product.getName());
      preparedStatement.setString(3, product.getPrice());
      
      i = preparedStatement.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (i == 0) {
      return false;
    } else {
      return true;
    }
  }
  public void deleteProduct(int id) {
    Connection connection = DBConnection.getConn();
    String sql = "delete from Product where id=?";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}