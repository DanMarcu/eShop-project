/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eshop.service;

import com.mycompany.eshop.dao.UserDAO;
import com.mycompany.eshop.entities.User;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dan
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserDAO userDAO;

//    public User updateUserById(int idx, String newUsername, String newEmail, String newFirstName, String newLastName, String newCity) throws Exception {
//       // UserDAO userDAO = new UserDAO();
//       User user = userDAO.selectUserById(idx);
//        user.setUsername(newUsername);
//        user.setEmail(newEmail);
//        user.setFirstName(newFirstName);
//        user.setLastName(newLastName);
//        user.setCity(newCity);
//        return user;
//    }
    @Transactional
    public boolean updateUser(int id) throws Exception {
        return userDAO.updateUser(id);
    }

    public boolean deleteUser(int id) throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return userDAO.deleteUser(id);
    }

    public User selectUserById(int id) throws Exception {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
        return userDAO.selectUserById(id);
    }

    public boolean createUser(User user) throws Exception {

        return userDAO.createUser(user);
    }

    public List<User> checkLoginUser(User user) throws Exception {
        return userDAO.checkLoginUser(user);
    }

    public List<User> showUsersList() throws Exception {
        return userDAO.showUsersList();
    }

    public List<User> selectUsername(String uuid) throws Exception {
        return userDAO.selectUsername(uuid);
    }
}
