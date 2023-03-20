package com.jetbrains.firstpr.Connection;


import antlr.collections.List;
import com.jetbrains.firstpr.Models.User;

import javax.persistence.*;
import javax.persistence.Query;
import java.sql.*;

public class LoginDao {
    @PersistenceContext(unitName = "persistence")
    public User check(String email, String password) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();

        User user = null;
        Query requete = em.createNativeQuery("SELECT * FROM user WHERE email = ? and password = ? ", User.class);
        requete.setParameter(1, email);
        requete.setParameter(2, password);

        try {
            return (User) requete.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

//    public User validate(String email,String password) throws SQLException,ClassNotFoundException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        Connection connection = DriverManager
//                .getConnection("jdbc:mysql://localhost:3306/apptp", "root", "");
//
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection
//                     .prepareStatement("select * from user where email = ? and password = ? ");
//
//            preparedStatement.setString(1, email);
//            preparedStatement.setString(2, password);
//
//            System.out.println(preparedStatement);
//            ResultSet rs = preparedStatement.executeQuery();
//
//           User user = null;
//            if (rs.next()) {
//                user=new User();
//                user.setFull_name(rs.getString("full_name"));
//            }
//        connection.close();
//        return user;
//    }
}

