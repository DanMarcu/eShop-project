/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eshop.Classes;

import com.mycompany.eshop.entities.CartBean;
import com.mycompany.eshop.dao.ProductDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Dan
 */
public class SessionCartSavingListener implements HttpSessionListener {

    private static int totalActiveSessions;

    public static int getTotalActiveSession() {
        return totalActiveSessions;
    }

    public void sessionCreated(HttpSessionEvent arg0) {
        totalActiveSessions++;
        System.out.println("sessionCreated - cart recovered");
    }

    /**
     *
     * @param arg0
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        totalActiveSessions--;
        boolean isSaved = false;
        CartBean cartBean = null;
        boolean isSaved2 = false;
        HttpSession session = arg0.getSession();
        boolean iSaved = (Boolean) session.getAttribute("cartSaved");
//        if (!isSaved) {
//            try {
//                Object objCartBean = session.getAttribute("cart");
//                cartBean = (CartBean) objCartBean;
//                ProductDAO dao = new ProductDAO();
//                isSaved2 = dao.saveCart(cartBean);
//                if (isSaved2) {
//                    System.out.println("sessionDestroyed - cart saved");
//                } else {
//                    System.out.println("sessionDestroyed - cart not saved");
//                }
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(SessionCartSavingListener.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (InstantiationException ex) {
//                Logger.getLogger(SessionCartSavingListener.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IllegalAccessException ex) {
//                Logger.getLogger(SessionCartSavingListener.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (SQLException ex) {
//                Logger.getLogger(SessionCartSavingListener.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }

    }

}
