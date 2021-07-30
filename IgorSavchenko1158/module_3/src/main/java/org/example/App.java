package org.example;

import org.example.controller.MainController;
import org.example.utils.HibernateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        log.info("App started");

        MainController.start(HibernateUtils.createSessionFactory(System.getenv("username"), System.getenv("password")), System.getenv("email"));
//        Connection connection = JDBCUtils.getConnection(args[1], args[2]);
//        try {
//            System.out.println(connection.isClosed());
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        log.info("App finished");
    }
}
