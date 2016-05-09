/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eshop.controllers;

import com.mycompany.eshop.entities.CartBean;
import com.mycompany.eshop.entities.CartItemBean;
import com.mycompany.eshop.entities.User;
import com.mycompany.eshop.dao.ProductDAO;
import com.mycompany.eshop.dao.UserDAO;
import com.mycompany.eshop.service.ProductService;
import com.mycompany.eshop.service.UserService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
public class HomePageController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

//    @RequestMapping("/")
//    public String homepage() {
//        return "HomePage";
//    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homepage(HttpServletRequest request, HttpServletResponse response) throws Exception {

       // ProductDAO listaProdusePromotionale = new ProductDAO();
     

        String categorieRandom = "pc";
        int nr = (int) (Math.random() * 3);
        switch (nr) {
            case 0:
                categorieRandom = "pc";
                break;
            case 1:
                categorieRandom = "notebook";
                break;
            case 2:
                categorieRandom = "smartphone";
                break;
            case 3:
                categorieRandom = "tv";
                break;
        }
        HttpSession session = request.getSession();
        session.setAttribute("listaProdusePromotionale", productService.extrageListaProdusePromotionalePeCategorie(categorieRandom));
        //request.setAttribute("listaProdusePromotionale", listaProduse.extrageListaProdusePromotionalePeCategorie(categorieRandom));
        request.setAttribute("categorieRandom", categorieRandom);
        String uuid = "";
        String username = "";
        int id = 0;
        Cookie ck[] = request.getCookies();
        if (ck != null) {
            for (Cookie ck1 : ck) {
                if (ck1.getName().equals("uuid")) {
                    uuid = ck1.getValue();
                }
            }
        }
        if (uuid != null) {
            // UserDAO userdao = new UserDAO();

            List<User> dbUserUuid = userService.selectUsername(uuid);
            username = dbUserUuid.get(0).getUsername();
            id = dbUserUuid.get(0).getId();
        }
        if (!username.equals("") || !username.equals(null)) {
            // request.setAttribute("username", "User " + username);
            request.setAttribute("username", username);
            session.setAttribute("idUser", id);
            session.setAttribute("username", username);
           // ProductDAO dao = new ProductDAO();
            ArrayList<CartItemBean> list = productService.recoverCart(id);
            CartBean cartBean = new CartBean(list);
            cartBean.updateCart();
            cartBean.calculateOrderTotal();
            session.setAttribute("cart", cartBean);
        }

        return new ModelAndView("HomePage", "listaProdusePromotionale", productService.extrageListaProdusePromotionalePeCategorie(categorieRandom));
    }

//    @RequestMapping(value = "/login")
//    public ModelAndView login(User user, HttpServletRequest request) {
//        return new ModelAndView("login");
//    }
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/createAccountPage")
    public String createAccount() {
        return "createAccountPage";
    }

//     @RequestMapping(value = "/editUsers")
//    public String listUsers() {
//        return "editUsers";
//    }
}
