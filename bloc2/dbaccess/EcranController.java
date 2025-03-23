package fr.pgah.controllers;

import java.sql.SQLException;
import java.util.List;
import fr.pgah.database.DBAccess;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class EcranController {

  DBAccess dbAccess;

  @FXML
  private ListView<String> lvAgents;  // Composant d'affichage des agents

  public PrimaryController() {
    // Le constructeur instancie un objet DBAccess
    // qui sera accessible et utilisable dans toute la classe
    dbAccess = new DBAccess();
  }

  @FXML
  private void btnRecupererAgents(ActionEvent event) {
    try {
      // Toutes les interactions avec la BDD passent par l'intermédiaire
      // d'un objet de la classe DBAccess
      List<String> agentsStr = dbAccess.recupererAgents();
      ObservableList<String> agentsList = FXCollections.observableArrayList(agentsStr);
      lvAgents.setItems(agentsList);
    } catch (SQLException e) {
      System.out.println("Erreur dans la récupération de la liste des agents");
      e.printStackTrace();
    }
  }
}
