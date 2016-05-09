/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eshop.dao;

import com.mycompany.eshop.entities.User;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

    //   @Autowired private ApplicationContext applicationContext; sa vada in galeata
    @PersistenceContext
    EntityManager em;

//    ResultSet resultSqlSelectUsers = null;
//    Statement sqlStatement = null;
    //   Connection conn = null;
//    public void conectDB() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
//        String dbName = "<vir2all/>";
//        String connURL = "jdbc:mysql://localhost:3306/" + dbName;
//        String connUser = "root";
//        String connPass = "root";
//        Class.forName("com.mysql.jdbc.Driver").newInstance();
//        conn = DriverManager.getConnection(connURL, connUser, connPass);
//    }
    public List<User> selectUsername(String uuid) throws Exception {

        Query query = em.createQuery("from User u where u.uuid = :uuid");
        query.setParameter("uuid", uuid);

//        String username = "";
//        conectDB();
//        PreparedStatement pst = conn.prepareStatement("SELECT username FROM users WHERE uuid=?");
//        pst.setString(1, uuid);
//
//        resultSqlSelectUsers = pst.executeQuery();
//        if (resultSqlSelectUsers.next()) {
//            username = resultSqlSelectUsers.getString("username");
//        }
        return query.getResultList();
    }

    public List<User> checkLoginUser(User user) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        // boolean isValid = false;
        Query query = em.createQuery("from User u where u.username = :username");
        query.setParameter("username", user.getUsername());

//        String userName = user.getUsername();
//        String userPass = user.getPassword();
//
//        conectDB();
//        PreparedStatement pst = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
//        pst.setString(1, userName);
//        pst.setString(2, userPass);
//        // sqlStatement = conn.createStatement();
//        resultSqlSelectUsers = pst.executeQuery();
//        resultSqlSelectUsers.next();
//        idUser = resultSqlSelectUsers.getInt("id");
        return query.getResultList();
    }

    public boolean createUser(User user) throws Exception {

        boolean isCreated = false;

      //  em.getTransaction().begin();
        em.persist(user);
       // em.getTransaction().commit();
        if (user.getId() > 0) {
            isCreated = true;
        }
//        conectDB();
//
//        String queryCheckIfExists = "SELECT * FROM users WHERE username = '" + user.getUsername() + "'";
//        String queryCreateUser = "INSERT INTO users (`username`, `password`, `email`, `first_name`, `last_name`, `city`, `uuid`)"
//                + " VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getEmail()
//                + "', '" + user.getFirstName() + "', '" + user.getLastName() + "', '" + user.getCity() + "', '" + user.getUuid() + "')";
//
//        sqlStatement = conn.createStatement();
//        resultSqlSelectUsers = sqlStatement.executeQuery(queryCheckIfExists);
//
//        if (!resultSqlSelectUsers.next()) {
//            int nrInsert = sqlStatement.executeUpdate(queryCreateUser);
//            if (nrInsert > 0) {
//                isCreated = true;
//            }
//            sqlStatement.close();
//        }
        return isCreated;
    }

    public List showUsersList() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Query query = em.createQuery("from User ");

//        String querySelectAll = "SELECT * FROM users";
//        List<User> list = new ArrayList<>();
//
//        conectDB();
//        sqlStatement = conn.createStatement();
//        resultSqlSelectUsers = sqlStatement.executeQuery(querySelectAll);
//
//        while (resultSqlSelectUsers.next()) {
//
//            User user = new User();
//            user.setId(Integer.valueOf(resultSqlSelectUsers.getString("id")));
//            user.setUsername(resultSqlSelectUsers.getString("username"));
//            user.setEmail(resultSqlSelectUsers.getString("email"));
//            user.setFirstName(resultSqlSelectUsers.getString("first_name"));
//            user.setLastName(resultSqlSelectUsers.getString("last_name"));
//            user.setCity(resultSqlSelectUsers.getString("city"));
//            list.add(user);
//        }
        return query.getResultList();
    }

    public boolean updateUser(int id) throws Exception {
        boolean isUpdated = false;

        User userUpdate = em.find(User.class, id);
        if (userUpdate instanceof User) {
            em.persist(userUpdate);
            isUpdated = true;
        }
//        conectDB();
//        String queryUpdateUser = "UPDATE users SET username=?,email=?,first_name=?,last_name=?,city=? WHERE id=?";
//        PreparedStatement pst = conn.prepareStatement(queryUpdateUser);
//        pst.setString(1, user.getUsername());
//        pst.setString(2, user.getEmail());
//        pst.setString(3, user.getFirstName());
//        pst.setString(4, user.getLastName());
//        pst.setString(5, user.getCity());
//        pst.setInt(6, user.getId());
//        int nr = pst.executeUpdate();
//        if (nr > 0) {
//            isUpdated = true;
//        }
        return isUpdated;
    }

    public boolean deleteUser(int id) throws Exception {
        boolean isDeleted = false;
        User userDel = em.find(User.class, id);
        if (userDel instanceof User) {
            em.remove(userDel);
            isDeleted = true;
        }

//        conectDB();
//        String queryUpdateUser = "delete from `users` WHERE `id`=?";
//        PreparedStatement pst = conn.prepareStatement(queryUpdateUser);
//        pst.setInt(1, id);
//        int nr = pst.executeUpdate();
//        if (nr > 0) {
//            isDeleted = true;
//        }
        return isDeleted;
    }

    public User selectUserById(int idSelect) throws Exception {

//        Query query = em.createQuery("from User user where user.id=:id ");
//        query.setParameter("id", idSelect);
//        return (User) query.getSingleResult();
        return em.find(User.class, idSelect);

//        ResultSet resultUserSelected;
//        User user = null;
//        conectDB();
//        PreparedStatement pst = conn.prepareStatement("SELECT * FROM users WHERE id=?");
//        pst.setInt(1, idSelect);
//        resultUserSelected = pst.executeQuery();
//        if (resultUserSelected.next()) {
//            int id = resultUserSelected.getInt("id");
//            String username = resultUserSelected.getString("username");
//            String password = resultUserSelected.getString("password");
//            String email = resultUserSelected.getString("email");
//            String firstName = resultUserSelected.getString("first_name");
//            String lastName = resultUserSelected.getString("last_name");
//            String city = resultUserSelected.getString("city");
//            user = new User(id, username, password, email, firstName, lastName, city);
//        }
//        return user;
    }
}
