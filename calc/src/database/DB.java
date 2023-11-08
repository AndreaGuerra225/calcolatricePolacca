package database;

import java.sql.*;

public class DB {

    public String stampa(String utente){
        Connection conn = connect();
        String stamp = "";
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM cronologia WHERE utente = ?";
            PreparedStatement preparedStatement = conn.prepareStatement((sql));
            preparedStatement.setString(1, utente);
            ResultSet resultSet = preparedStatement.executeQuery();

            while ((resultSet.next())){
                stamp += "User: " + resultSet.getString("utente") + "\n" + "equazione: " + resultSet.getString("espressione") + " = " + resultSet.getString("risultato") + "\n";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stamp;
    }
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

    public int CronologiaIN(String espressione, String risultato, String utente) {
        if(espressione.isEmpty()){
            return -1;
        }

        Connection conn = connect();
        String ris = "";
        try {
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO cronologia(espressione, risultato, utente) VALUES" + "(?, ?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, espressione);
            preparedStatement.setString(2, risultato);
            preparedStatement.setString(3, utente);
            preparedStatement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return 1;
    }

    public int Register(String utente, String password) {
        if(password.isEmpty()){
            return -1;
        }

        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO utenti(username, password) VALUES" + "(?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, utente);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return 1;
    }
}