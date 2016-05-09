/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eshop.dao;

import com.mycompany.eshop.entities.CartBean;
import com.mycompany.eshop.entities.CartItemBean;
import com.mycompany.eshop.entities.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dan
 */
@Repository
public class ProductDAO {

    @PersistenceContext
    EntityManager em;

    String dbName = "<vir2all/>";
    Connection conn = null;
    String connURL = "jdbc:mysql://localhost:3306/" + dbName;
    String connUser = "root";
    String connPass = "root";
    ResultSet rsProduse = null;
    ResultSet rsCartItem = null;
    Statement sqlStatement = null;

    public List<Product> extrageListaProdusePromotionalePeCategorie(String categorie) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

        Query query = em.createQuery("from Product p where p.category = :category and p.price<300");
        query.setParameter("category", categorie);

//        Class.forName("com.mysql.jdbc.Driver").newInstance();
//        conn = DriverManager.getConnection(connURL, connUser, connPass);
//
//        PreparedStatement pst = conn.prepareStatement("select * from products where category=? and price<300");
//        // PreparedStatement pst= conn.prepareStatement("SELECT * FROM products"); 
//        pst.setString(1, categorie);
//        List<Product> list = new ArrayList<>();
//
//        //  sqlStatement = conn.createStatement();
//        rsProduse = pst.executeQuery();
//
//        while (rsProduse.next()) {
//            Product product = new Product();
//            product.setId(rsProduse.getInt("id"));
//            product.setName(rsProduse.getString("name"));
//            product.setDescription(rsProduse.getString("description"));
//            product.setPrice(rsProduse.getDouble("price"));
//
//            list.add(product);
//        }
        return query.getResultList();
    }

    public List<Product> extrageListaProdusePeCategorie(String categorie) throws Exception {

        Query query = em.createQuery("from Product p where p.category = :category");
        query.setParameter("category", categorie);
        return query.getResultList();

//        Class.forName("com.mysql.jdbc.Driver").newInstance();
//        conn = DriverManager.getConnection(connURL, connUser, connPass);
//
//        PreparedStatement pst = conn.prepareStatement("SELECT * FROM products where category=?");
//        // PreparedStatement pst= conn.prepareStatement("SELECT * FROM products"); 
//        pst.setString(1, categorie);
//        List<Product> list = new ArrayList<>();
//
//        //  sqlStatement = conn.createStatement();
//        rsProduse = pst.executeQuery();
//
//        while (rsProduse.next()) {
//            Product product = new Product();
//            product.setId(rsProduse.getInt("id"));
//            product.setName(rsProduse.getString("name"));
//            product.setDescription(rsProduse.getString("description"));
//            product.setPrice(rsProduse.getDouble("price"));
//
//            list.add(product);
//        }
//        return list;
    }

    public ArrayList<CartItemBean> recoverCart(int idUser) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

//        Query query = em.createNativeQuery("SELECT b.id as colA, a.id as colB, a.name as colC, a.description as colD,a.price as colE, c.quantity as colF FROM products a, users b, cart c WHERE c.id_user = b.id and c.id_prod=a.id and c.id_user=" + idUser);
//        List<Object> results = query.getResultList();
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(connURL, connUser, connPass);

        PreparedStatement pst = conn.prepareStatement("SELECT b.id as colA, a.id as colB, a.name as colC, a.description as colD,a.price as colE, c.quantity as colF FROM products a, users b, cart c WHERE c.id_user = b.id and c.id_prod=a.id and c.id_user=?");

        pst.setInt(1, idUser);
        ArrayList<CartItemBean> list = new ArrayList<>();

        //  sqlStatement = conn.createStatement();
        rsCartItem = pst.executeQuery();

        while (rsCartItem.next()) {
            CartItemBean cartItem = new CartItemBean();
            cartItem.setIdUser(rsCartItem.getInt("colA"));
            cartItem.setIdProduct(rsCartItem.getInt("colB"));
            cartItem.setName(rsCartItem.getString("colC"));
            cartItem.setDescription(rsCartItem.getString("colD"));
            cartItem.setDblUnitCost(rsCartItem.getDouble("colE"));
            cartItem.setQuantity(rsCartItem.getInt("colF"));
            list.add(cartItem);
        }
        return list;
    }

    public boolean saveCart(CartBean cart, int idUser) throws Exception {
        boolean isSaved = false;

        Query query = em.createNativeQuery("DELETE FROM cart WHERE id_user = " + idUser);
        query.executeUpdate();
        ArrayList<CartItemBean> alCartItems = cart.getCartItems();
        for (int i = 0; i < alCartItems.size(); i++) {
            em.persist(alCartItems.get(i));
        }
        if (alCartItems.size() > 0) {
            isSaved = true;
        }

//        Class.forName("com.mysql.jdbc.Driver").newInstance();
//        conn = DriverManager.getConnection(connURL, connUser, connPass);
//        boolean isSaved = false;
//        int iInsertCounter = 0;
//        int idUser = cart.getCartItem(0).getIdUser();
//        PreparedStatement pstDel = conn.prepareStatement("DELETE FROM cart WHERE id_user=?");
//        pstDel.setInt(1, idUser);
//        int nrDel = pstDel.executeUpdate();
//
//        ArrayList<CartItemBean> alCartItems = cart.getCartItems();
//        if (alCartItems.size() > 0) {
//            for (int i = 0; i < alCartItems.size(); i++) {
//                String queryCreateUser = "INSERT INTO cart (`id_user`, `id_prod`, `quantity`)"
//                        + " VALUES ('" + alCartItems.get(i).getIdUser() + "', '" + alCartItems.get(i).getIdProduct() + "', '" + alCartItems.get(i).getQuantity() + "')";
//                sqlStatement = conn.createStatement();
//
//                int iInsert = sqlStatement.executeUpdate(queryCreateUser);
//                iInsertCounter += iInsert;
//            }
//            sqlStatement.close();
//
//            if (iInsertCounter == alCartItems.size()) {
//                isSaved = true;
//            }
//        }
        return isSaved;
    }

}
