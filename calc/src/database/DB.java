package database;

import java.sql.*;

public class DB {
    private Connection connect() {
        final String DATABASE = "jdbc:mysql://localhost:3306/calcolatricepolacca";
        final String USERNAME = "root";
        final String PASSWORD = "";
        Connection conn;

        try{
            conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return conn;
    }

    public int login(String username, String password) {
        Connection conn = connect();

        try {

                Statement state = conn.createStatement();
                String sql = "SELECT * FROM utenti WHERE username =? AND password =?";

                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    System.out.println(("Login effettuato. Ciao " + username));
                    state.close();
                    conn.close();
                    return 1;
                }

                else {
                    state.close();
                    conn.close();
                    System.out.println("Username o password errati");
                    return -1;
                }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Login fallito");
            return -1;
        }
    }

    public int CronologiaIN(String espressione, String risultato) {
        if(espressione.isEmpty()){
            return -1;
        }

        Connection conn = connect();
        String ris = "";
        try {
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO cronologia(espressione, risultato) VALUES" + "(?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, espressione);
            preparedStatement.setString(2, risultato);
            preparedStatement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return 1;
    }
}