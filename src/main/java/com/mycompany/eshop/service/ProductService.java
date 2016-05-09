/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eshop.service;

import com.mycompany.eshop.dao.ProductDAO;
import com.mycompany.eshop.entities.CartBean;
import com.mycompany.eshop.entities.CartItemBean;
import com.mycompany.eshop.entities.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dan
 */
@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public List<Product> extrageListaProdusePromotionalePeCategorie(String categorieRandom) throws Exception {
        return productDAO.extrageListaProdusePromotionalePeCategorie(categorieRandom);
    }

    public List<Product> extrageListaProdusePeCategorie(String categorie) throws Exception {
        return productDAO.extrageListaProdusePeCategorie(categorie);
    }

    public boolean saveCart(CartBean cartBean,int idUser) throws Exception {
        return productDAO.saveCart(cartBean,idUser);
    }
    
   public ArrayList<CartItemBean> recoverCart(int idUser) throws Exception{
       return productDAO.recoverCart(idUser);
   }

}
