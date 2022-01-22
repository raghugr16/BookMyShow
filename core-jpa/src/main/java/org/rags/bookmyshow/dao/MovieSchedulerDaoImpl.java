package org.rags.bookmyshow.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MovieSchedulerDaoImpl implements MovieSchedulerDao {

    private static String sql = "create table :";
    @Autowired
    private DataSource dataSource;

    @Override
    public boolean createTable(String tableName) {
        Connection connection = null;

        try  {
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
