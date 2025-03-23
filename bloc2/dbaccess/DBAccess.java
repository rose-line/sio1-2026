package fr.pgah.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBAccess {

  private String dbURL = "jdbc:postgresql://localhost:5432/gsb";
  private String nomUtilisateur = "dev";
  private String mdp = "lemotdepasseducomptedev";

  // Méthode établissant une connexion à la BDD
  // Renvoie l'objet Connection ainsi créé
  // La méthode est privée car elle n'est utilisable que par
  // les méthodes de cette classe
  private Connection getConnection() {
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(dbURL, nomUtilisateur, mdp);
      if (connection != null) {
        System.out.println("Connexion réussie !");
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return connection;
  }

  // Méthode récupérant la liste de tous les agents depuis la BDD
  // Renvoie une liste de strings, chacune représentant un agent
  // ex : "Agent no. 1 : 123456 : Dupont, azerty"
  public List<String> recupererAgents() throws SQLException {
    List<String> agents = new ArrayList<>();
    Connection connection = getConnection();
    String sql = "SELECT ag_matricule, ag_nom, ag_pwd FROM agent";
    Statement requete = connection.createStatement();
    ResultSet rs = requete.executeQuery(sql);

    int compteur = 0;
    while (rs.next()) {
      compteur++;
      String matricule = rs.getString("ag_matricule");
      String nom = rs.getString("ag_nom");
      String mdp = rs.getString("ag_pwd");
      String agentString = "Agent no. " + compteur + " : " + matricule + " : " + nom + ", " + mdp;
      System.out.println(agentString); // DEBUGGING
      agents.add(agentString);
    }
    return agents;
  }

  // La classe contiendrait d'autres méthodes permettant d'accéder
  // à d'autres données, de faire des insertions, des modifications, etc.
  // ...
}