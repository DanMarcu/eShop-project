/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eshop.controllers;

import com.mycompany.eshop.entities.CartBean;
import com.mycompany.eshop.dao.ProductDAO;
import com.mycompany.eshop.service.ProductService;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dan
 */
@Controller
public class CartController {
      @Autowired
    private ProductService productService;

    @RequestMapping(value = "ListaProduseServ", method = RequestMethod.GET)
    public ModelAndView listaProduse(HttpServletRequest request) throws Exception {
        String categorie = request.getParameter("select");
        //ProductDAO listaProduse = new ProductDAO();
        return new ModelAndView("listaProduse", "listaProduse", productService.extrageListaProdusePeCategorie(categorie));
    }

    @RequestMapping(value = "CartControl", method = RequestMethod.POST)
    public String cart(HttpServletRequest request) throws Exception {
        String strAction = request.getParameter("action");
        HttpSession sessionLog = request.getSession();
        String userLogat = (String) sessionLog.getAttribute("username");
        if (userLogat != null && !userLogat.equals("")) {
            // if (strAction != null || !strAction.equals("")) {
            int idUserLog = (Integer) sessionLog.getAttribute("idUser");
            if (strAction.equals("add")) {
                addToCart(request, idUserLog);
            } else if (strAction.equals("Update")) {
                updateCart(request);
            } else if (strAction.equals("Delete")) {
                deleteCart(request);
            }
        } else {
            request.setAttribute("result", "Va rugam sa va inregistrati ca utilizator !");
            return "confirmation";
        }
        return "ShoppingCart";

    }

    protected void deleteCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String strItemIndex = request.getParameter("itemIndex");
        CartBean cartBean = null;
        Object objCartBean = session.getAttribute("cart");
        if (objCartBean != null) {
            cartBean = (CartBean) objCartBean;
        } else {
            cartBean = new CartBean();
        }
        cartBean.deleteCartItem(strItemIndex);
    }

    protected void updateCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String strQuantity = request.getParameter("quantity");
        String strItemIndex = request.getParameter("itemIndex");
        CartBean cartBean = null;
        Object objCartBean = session.getAttribute("cart");
        if (objCartBean != null) {
            cartBean = (CartBean) objCartBean;
        } else {
            cartBean = new CartBean();
        }
        cartBean.updateCartItem(strItemIndex, strQuantity);
    }

    protected void addToCart(HttpServletRequest request, int idUser) {
        HttpSession session = request.getSession();
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        String strName = request.getParameter("name");
        String strDescription = request.getParameter("description");
        String strPrice = request.getParameter("price");
        String strQuantity = request.getParameter("quantity");
        CartBean cartBean = null;
        Object objCartBean = session.getAttribute("cart");
        if (objCartBean != null) {
            cartBean = (CartBean) objCartBean;
        } else {
            cartBean = new CartBean();
            session.setAttribute("cart", cartBean);
        }
        cartBean.addCartItem(idUser, idProduct, strName, strDescription, strPrice, strQuantity);
    }

    @RequestMapping(value = "/ShoppingCart")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
       return "ShoppingCart";
    }
}
