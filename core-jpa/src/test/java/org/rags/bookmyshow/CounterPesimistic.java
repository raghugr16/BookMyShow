package org.rags.bookmyshow;

import java.sql.*;

public class CounterPesimistic {
    private static final String SQL_INSERT = "INSERT INTO Counter (count) VALUES (?)";

    public static void main(String[] args) {

        String SQL_SELECT = "Select * from Counter";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres");

            preparedStatement = conn.prepareStatement(SQL_INSERT);
            preparedStatement.setInt(1, 1);
            int row = preparedStatement.executeUpdate();

            preparedStatement = conn.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                long id = resultSet.getLong("ID");
                int count = resultSet.getInt("count");
                Counter counter = new Counter();
                counter.setCount(count);
                System.out.println("Counter = " +count);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException sq){
            sq.getSQLState();
        } finally {
            try {
                if(resultSet!=null)
                    resultSet.close();
                if(preparedStatement!=null){
                    preparedStatement.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
