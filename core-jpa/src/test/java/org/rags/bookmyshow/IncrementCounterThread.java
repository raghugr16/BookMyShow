package org.rags.bookmyshow;

import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IncrementCounterThread implements Runnable{
    private static final String SQL_SELECT = "Select * from Counter where id = 1 FOR UPDATE";
    private static final String SQL_INSERT = "INSERT INTO Counter (count) VALUES (?)";
    private static final String UPDATE_COUNTER = "update counter set count = ? where id = ?";
    private static final String LOCK_TABLE = "lock counter in ACCESS EXCLUSIVE MODE";


    @Override
    public void run() {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres");

            conn.setAutoCommit(false);
            conn.beginRequest();
            preparedStatement = conn.prepareStatement(LOCK_TABLE);
            boolean res = preparedStatement.execute();

            preparedStatement = conn.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            int count = 1;

            while (resultSet.next()) {

                long id = resultSet.getLong("ID");
                count = resultSet.getInt("count");
                Counter counter = new Counter();
                counter.setCount(count);
                System.out.println("Counter = " +count);

            }

            preparedStatement = conn.prepareStatement(UPDATE_COUNTER);
            preparedStatement.setInt(1, count+1);
            preparedStatement.setInt(2,1);

            int row = preparedStatement.executeUpdate();

            preparedStatement = conn.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                long id = resultSet.getLong("ID");
                count = resultSet.getInt("count");
                Counter counter = new Counter();
                counter.setCount(count);
                System.out.println("Counter after update = " + count);

            }
            conn.commit();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            //System.err.format("SQL State: %s\n%s", , e.getMessage());
        } catch (SQLException sq){
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sq.getSQLState();
            sq.printStackTrace();
        } finally {
            try {
                if(resultSet!=null){
                    resultSet.close();
                }
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

    public static void main(String[] args) {
        Thread thread = new Thread(new IncrementCounterThread());
        thread.start();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            System.out.println("Thread "+ i);
            executorService.submit(new IncrementCounterThread());
        }
    }
}
