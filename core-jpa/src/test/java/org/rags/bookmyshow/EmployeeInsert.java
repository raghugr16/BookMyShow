package org.rags.bookmyshow;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeInsert {
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";

    public static void main(String[] args)  {

        List<Employee> result = new ArrayList<>();

        String SQL_SELECT = "Select * from EMPLOYEE";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        // auto close connection and preparedStatement
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres");


            for (int i=0; i<10; i++){
                preparedStatement = conn.prepareStatement(SQL_INSERT);
                preparedStatement.setString(1, "raghu");
                preparedStatement.setBigDecimal(2, new BigDecimal(799.88));
                preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                int row = preparedStatement.executeUpdate();
            }
            preparedStatement = conn.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                long id = resultSet.getLong("ID");
                String name = resultSet.getString("NAME");
                BigDecimal salary = resultSet.getBigDecimal("SALARY");
                Timestamp createdDate = resultSet.getTimestamp("CREATED_DATE");

                Employee obj = new Employee();
                obj.setId(id);
                obj.setName(name);
                obj.setSalary(salary);
                // Timestamp -> LocalDateTime
                obj.setCreatedDate(createdDate.toLocalDateTime());
                result.add(obj);
            }
            result.forEach(x -> System.out.println(x));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            //System.err.format("SQL State: %s\n%s", , e.getMessage());
        } catch (SQLException sq){
            sq.getSQLState();
        } finally {
            try {
                if(resultSet!=null)
                    resultSet.close();
                if(preparedStatement!=null){
                    preparedStatement.close();
                }
                if(conn!=null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
