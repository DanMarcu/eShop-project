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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "LoginServlet", method = RequestMethod.POST)
    public String Login(User user, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();;
        // UserDAO userDAO = new UserDAO();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user = new User(username, password);
        List<User> dbUsers = userService.checkLoginUser(user);
        if (dbUsers.size() != 1 || user.getPassword() == null || !user.getPassword().equals(dbUsers.get(0).getPassword())) {
            request.setAttribute("result", "Wrong username or password.");
        } else {
            request.setAttribute("result", "Successfully logged in.");
            session.setAttribute("username", dbUsers.get(0).getUsername());
            session.setAttribute("idUser", dbUsers.get(0).getId());
          //  ProductDAO dao = new ProductDAO();
            ArrayList<CartItemBean> list = (ArrayList)productService.recoverCart(dbUsers.get(0).getId());
            if (list != null) {
                CartBean cartBean = new CartBean(list);
                cartBean.updateCart();
                cartBean.calculateOrderTotal();
                session.setAttribute("cart", cartBean);
            }
        }
        return "confirmation";
    }

    @RequestMapping(value = "CreateUserServlet", method = RequestMethod.POST)
    public ModelAndView create(User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sessionLogin = request.getSession();
        Object objUsername = sessionLogin.getAttribute("username");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String city = request.getParameter("city");

        if (objUsername == null) {
            // UserDAO userDAO = new UserDAO();
            String uuid = UUID.randomUUID().toString();
            user = new User(username, password, email, firstName, lastName, city, uuid);
            boolean isCreated;
            isCreated = userService.createUser(user);
            if (isCreated) {
                request.setAttribute("result", "Account created.");
                sessionLogin.setAttribute("username", user.getUsername());
                Cookie ckUser = new Cookie("uuid", uuid);
                ckUser.setMaxAge(60 * 60 * 24);
                response.addCookie(ckUser);
            } else {
                request.setAttribute("result", "Username already exists.");
            }
            return new ModelAndView("confirmation", "result", request.getAttribute("result"));
        } else {
            return new ModelAndView("redirect:/HomePage");
        }
    }

    @RequestMapping(value = "showUsers", method = RequestMethod.GET)
    public ModelAndView listUser(User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
       //UserDAO userDAO = new UserDAO();   
        request.setAttribute("usersList",  userService.showUsersList());
        return new ModelAndView("showUsers", "usersList",  userService.showUsersList());
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editUser(HttpServletRequest request, HttpServletResponse response) throws Exception, ClassNotFoundException, InstantiationException, IllegalAccessException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.selectUserById(id);
        return new ModelAndView("editUser", "user", user);
    }

    @RequestMapping(value = "UpdateUserServlet", method = RequestMethod.POST)
    public String updateAndDelete(User user, HttpServletRequest request) throws Exception {
        int idx = Integer.parseInt(request.getParameter("id"));

//        UserDAO userDAO = new UserDAO();
//        String newUsername = request.getParameter("newUsername");
//        String newEmail = request.getParameter("newEmail");
//        String newFirstName = request.getParameter("newFirstName");
//        String newLastName = request.getParameter("newLastName");
//        String newCity = request.getParameter("newCity");
//        request.getParameter("action");
        if (request.getParameter("action").equals("Update")) {
            // User userUpdate = new User(idx, newUsername, newEmail, newFirstName, newLastName, newCity);
            if (userService.updateUser(idx)) {
                request.setAttribute("result", "User succesfully updated !");
            } else {
                request.setAttribute("result", "User does not updated !");
            }
        }

        if (request.getParameter("action").equals("Delete")) {
            if (userService.deleteUser(idx)) {
                request.setAttribute("result", "User succesfully deleted !");
            } else {
                request.setAttribute("result", "User does not deleted !");
            }
        }
        return "confirmation";
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CartBean cartBean = null;
        HttpSession session = request.getSession();
        int idUser=(Integer)session.getAttribute("idUser");
        session.setAttribute("username", null);
        Object objCartBean = session.getAttribute("cart");
        cartBean = (CartBean) objCartBean;
    //    ProductDAO dao = new ProductDAO();
        if (cartBean != null) {
            boolean isSaved = productService.saveCart(cartBean,idUser);
            if (isSaved) {
                session.setAttribute("cartSaved", isSaved);
            }
            cartBean = null;
            session.setAttribute("cart", null);
        }
        request.setAttribute("result", "You are logout.Your shopping cart was saved.");
        return new ModelAndView("confirmation", "result", request.getAttribute("result"));
    }
}
