package exercise1;

import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import oracle.sql.DATE;
import javafx.scene.control.ComboBox;
import javafx.fxml.FXML;
import java.util.concurrent.atomic.AtomicReference;
import javafx.scene.control.TableColumn;

public class Controller {

	
	@FXML
	TextField GameTitleField;
	@FXML
	TextArea txtAreaSummaryField;
	@FXML
	TextField FirstNameField;
	@FXML
	TextField LastNameField;
	@FXML
	TextField PhoneNumberField;
	@FXML
	TextField AddressField;
	@FXML
	TextField ProvinceField;
	@FXML
	TextField PostalCodeField;
	
	@FXML
	TextField GamePlayedIdField;
	
	@FXML
	TextField PlayedDateField;
	
	@FXML
	TextField ScoreField;

	@FXML
	ComboBox<Integer> cbxPlayersIds;
	@FXML
	ComboBox<Integer> cbxPlayerId;
	@FXML
	ComboBox<Integer> cbxPlayerIdsToPrint;

	// initialize cbx with with player ids
	@FXML
	private void initialize() {
		ObservableList<Integer> ids = DBOracle.getPlayersIds();
		cbxPlayerId.setItems(ids);
		cbxPlayersIds.setItems(ids);
		cbxPlayerIdsToPrint.setItems(ids);
	}

	// to monitor if a player has been selected
	boolean playerSelected = false;

	// when player id is selected, fill from fields
	public void fieldsToUpdate() {
		if (cbxPlayerId.getValue() != null) {
			ObservableList<String> playerInfo = DBOracle
					.getPlayerInfoById(cbxPlayerId.getValue());
			//System.out.println(playerInfo);
			FirstNameField.setText(playerInfo.get(0));
			LastNameField.setText(playerInfo.get(1));
			AddressField.setText(playerInfo.get(2));
			PostalCodeField.setText(playerInfo.get(3));
			ProvinceField.setText(playerInfo.get(4));
			PhoneNumberField.setText(playerInfo.get(5));
			playerSelected = true;
		}
	}

	// UPDATE player info inside db if it haves any chaDnges
	public void updatePlayer() {
		if (!playerSelected) {
			return;
		}
		DBOracle.updatePlayerInfo(cbxPlayerId.getValue(), FirstNameField.getText(),
				LastNameField.getText(), AddressField.getText(), PostalCodeField.getText(), ProvinceField.getText(),
				PhoneNumberField.getText());
		if (cbxPlayerId.getValue() != null) {
			cbxPlayerId.getSelectionModel().clearSelection();
		}
	}

	// INSERT new player info to db
	public void insertPlayerInfo() {
		DBOracle.insertPlayerInfo(FirstNameField.getText(), LastNameField.getText(), AddressField.getText(),
				PostalCodeField.getText(), ProvinceField.getText(), PhoneNumberField.getText());
		cbxPlayerId.setItems(DBOracle.getPlayersIds());
		txtAreaSummaryField.setText(DBOracle.getPlayersList());

	}
	
	// INSERT data into player and game table
		public void insertPlayerAndGameInfo() {
			//debug
			//System.out.printf("%d %d %s %d",Integer.parseInt(GamePlayedIdField.getText()),cbxPlayersIds.getValue(), PlayedDateField.getText(),Integer.parseInt(ScoreField.getText()));
			DBOracle.insertPlayerAndGameInfo(Integer.parseInt(GamePlayedIdField.getText()),cbxPlayersIds.getValue(), PlayedDateField.getText(),Integer.parseInt(ScoreField.getText()));
					
			cbxPlayerId.setItems(DBOracle.getPlayersIds());
			txtAreaSummaryField.setText(DBOracle.getPlayersList());
		}

	// INSERT new game title info to db
	public void insertGameTitle() {
		DBOracle.insertGameInfo(GameTitleField.getText());
		GameTitleField.setText(" ");
	}

	// READ the contents of the db
	public void printGames() {
		txtAreaSummaryField.setText("");
		txtAreaSummaryField.setText(DBOracle.getGames());
	}

	public void printPlayers() {
		txtAreaSummaryField.setText("id | First Name | Last Name | Address | Postal Code | Province | Phone Number "+"\n"+ DBOracle.getPlayersList());
	}

	public void printPlayerAndGameReport() {
		if (cbxPlayerIdsToPrint.getValue() != null) {
			txtAreaSummaryField.setText("");
			AtomicReference<String> contents = new AtomicReference<>("");

			DBOracle.getPlayerGameReportById(cbxPlayersIds.getValue())
					.forEach(item -> {
						contents.updateAndGet(v -> v + item.playerGameId + " | " + item.gameId + " | " + item.playerId
								+ " | " + item.playDate + " | " + item.score + "\n");
					});
			if (contents.toString() == "") {
				contents.set("The player that matches the ID haven't played videogames recently");
			}
			txtAreaSummaryField.setText(contents.toString());
		} else {
			txtAreaSummaryField.setText("");
			AtomicReference<String> contents = new AtomicReference<>("");

			DBOracle.GetPlayerGameReport().forEach(item -> {
				contents.updateAndGet(v -> v + item.playerGameId + " | " + item.gameId + " | " + item.playerId + " | "
						+ item.playDate + " | " + item.score + "\n");
			});
			txtAreaSummaryField.setText(contents.toString());
		}

	}

	public void clearFields() {
		txtAreaSummaryField.setText("");
		FirstNameField.setText("");
		LastNameField.setText("");
		AddressField.setText("");
		PostalCodeField.setText("");
		ProvinceField.setText("");
		PhoneNumberField.setText("");
		cbxPlayerId.getSelectionModel().clearSelection();
		cbxPlayersIds.getSelectionModel().clearSelection();
	}
}