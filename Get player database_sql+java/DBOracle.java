package exercise1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oracle.sql.DATE;

import java.sql.*;



public class DBOracle {
	// JDBC driver name and database URL

	//static final String DRIVER = "oracle.jdbc.driver.OracleDriver";  
	static final String USER = "";
	static final String PASS = "";
	static final String DATABASE_URL = "";
	
	// allows user to update a players profile
	public static void updatePlayerInfo(int userId, String firstName, String lastName, String address,
			String postalCode, String province, String phoneNumber) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DATABASE_URL,USER,PASS);
			Statement st = conn.createStatement();
			String insertSt = String.format(
					"UPDATE player SET first_name = '%s', last_name = '%s', address = '%s', postal_code = '%s', province = '%s', phone_number = '%s' WHERE player_id = %d",
					firstName, lastName, address, postalCode, province, phoneNumber, userId);
			st.executeUpdate(insertSt);
			System.out.println("Player information updated!");
		} catch (SQLException throwable) {
			System.out.println("Error: Cannot connect to database");
			throwable.printStackTrace();
		} finally {
			// connection is closed
			try {
				if (conn != null)
					conn.close();
				System.out.println("Connection Closed!");
			} catch (SQLException e) {
				// close failed
				System.err.println(e.getMessage());
			}
		}

	}

	// insert a game title into the database
	public static void insertGameInfo(String title) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DATABASE_URL, USER, PASS);
			Statement statement = conn.createStatement();
			String insertStatement = String.format("INSERT INTO game (game_title) VALUES('%s')", title);
			statement.executeUpdate(insertStatement);
			System.out.println("Game title added to the database!");
		} catch (SQLException throwable) {
			System.out.println("Error: Cannot connect to database");
			throwable.printStackTrace();
		} finally {
			// connection is closed
			try {
				if (conn != null)
					conn.close();
				System.out.println("Connection Closed!");
			} catch (SQLException e) {
				// close failed
				System.err.println(e.getMessage());
			}
		}
	}

	// create a new player record
	public static void insertPlayerInfo(String firstName, String lastName, String address, String postalCode,
			String province, String phoneNumber) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DATABASE_URL, USER, PASS);
			Statement st = conn.createStatement();
			String insertSt = String.format(
					"INSERT INTO player (first_name, last_name, address, postal_code, province, phone_number) VALUES('%s','%s','%s','%s','%s','%s')",
					firstName, lastName, address, postalCode, address, phoneNumber);
			st.executeUpdate(insertSt);
		} catch (SQLException throwable) {
			System.out.println("Error: Cannot connect to database");
			throwable.printStackTrace();
		} finally {
			// connection is closed
			try {
				if (conn != null)
					conn.close();
				System.out.println("Connection Closed!");
			} catch (SQLException e) {
				// close failed
				System.err.println(e.getMessage());
			}
		}
	}

	// READ players from DB
	public static String getPlayersList() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DATABASE_URL, USER, PASS);
			String sql = "SELECT * FROM player";
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery(sql);
			String contents = "";
			while (result.next()) {
				int id = result.getInt("player_id");
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String address = result.getString("address");
				String postalCode = result.getString("postal_code");
				String province = result.getString("province");
				String phoneNumber = result.getString("phone_number");

				contents += id + " | " + firstName + " | " + lastName + " | " + address + " | " + postalCode + " | "
						+ province + " | " + phoneNumber + "\n";
			}
			return contents;
		} catch (SQLException throwable) {
			System.out.println("Error: Cannot connect to database");
			throwable.printStackTrace();
			return "";
		} finally {
			// ensure database connection is closed
			try {
				if (conn != null)
					conn.close();
				System.out.println("Connection Closed!");
			} catch (SQLException e) {
				// connection close failed
				System.err.println(e.getMessage());
			}
		}
	}

	// READ games from database
	public static String getGames() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DATABASE_URL, USER, PASS);
			String sql = "SELECT * FROM game";
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery(sql);
			String contents = "";
			while (result.next()) {
				// TODO: need to be able to get for either player or game queries
				int gameId = result.getInt("game_id");
				String title = result.getString("game_title");

				contents += gameId + " | " + title + "\n";
			}
			return contents;
		} catch (SQLException throwable) {
			System.out.println("Error: Cannot connect to database");
			throwable.printStackTrace();
			return "";
		} finally {
			// ensure database connection is closed
			try {
				if (conn != null)
					conn.close();
				System.out.println("Connection Closed!");
			} catch (SQLException e) {
				// connection close failed
				System.err.println(e.getMessage());
			}
		}
	}

	// READ player information from database based on gamerId selected
	public static ObservableList<String> getPlayerInfoById(int gamerId) {
		ObservableList<String> playerInfo = FXCollections.observableArrayList();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DATABASE_URL, USER, PASS);
			String sql = String.format(
					"SELECT first_name, last_name, address, postal_code, province, phone_number FROM player WHERE player_id = %d",
					gamerId);
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery(sql);
			result.next();
			String firstName = result.getString("first_name");
			String lastName = result.getString("last_name");
			String address = result.getString("address");
			String postalCode = result.getString("postal_code");
			String province = result.getString("province");
			String phoneNumber = result.getString("phone_number");
			playerInfo.addAll(firstName, lastName, address, postalCode, province, phoneNumber);
			//debug
			//System.out.println(playerInfo);
			return playerInfo;
			
		} catch (SQLException throwable) {
			System.out.println("Error: Cannot connect to database");
			throwable.printStackTrace();
			return playerInfo;
		} finally {
			// ensure database connection is closed
			try {
				if (conn != null)
					conn.close();
				System.out.println("Connection Closed!");
			} catch (SQLException e) {
				// connection close failed
				System.err.println(e.getMessage());
			}
		}
	}

	// READ all  id from database
	public static ObservableList<Integer> getPlayersIds() {
		ObservableList<Integer> playerIds = FXCollections.observableArrayList();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DATABASE_URL, USER, PASS);
			String sql = "SELECT * FROM player";
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery(sql);
			while (result.next()) {
				int id = result.getInt("player_id");
				playerIds.add(id);
			}
			return playerIds;
		} catch (SQLException throwable) {
			System.out.println("Error: Cannot connect to database");
			throwable.printStackTrace();
			return playerIds;
		} finally {
			// closing connection
			try {
				if (conn != null)
					conn.close();
				System.out.println("Connection Closed!");
			} catch (SQLException e) {
				// close failed
				System.err.println(e.getMessage());
			}
		}
	}

	//PLAYER AND GAME TABLE
	//insert values to create relationship between games and players tables
		public static void insertPlayerAndGameInfo(int gameId, int playerId, String playDate, int score) {
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(DATABASE_URL, USER, PASS);
				Statement st = conn.createStatement();
				//debug
				//System.out.printf("%d %d %s %d",gameId, playerId, playDate, score);
				String insertSt = String.format(
						"INSERT INTO playerandgame (game_id, player_id, playing_date, score) VALUES( %d, %d,TO_DATE('%s','DD-MM-YYYY'),%d)",
						gameId, playerId, playDate, score);
				
				st.executeUpdate(insertSt);
				System.out.println("Game and player added database!");
			} catch (SQLException throwable) {
				System.out.println("Error: Cannot connect to database");
				throwable.printStackTrace();
			} finally {
				// connection is closed
				try {
					if (conn != null)
						conn.close();
					System.out.println("Connection Closed!");
				} catch (SQLException e) {
					// close failed
					System.err.println(e.getMessage());
				}
			}
		}

	// READ player and game information
	public static ObservableList<PlayerAndGame> GetPlayerGameReport() {

		ObservableList<PlayerAndGame> playerInfo = FXCollections.observableArrayList();
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DATABASE_URL, USER, PASS);
			String sql = String.format(
					"SELECT player_game_id, game_id, player_id, TO_DATE(playing_date, 'DD-MM-YYYY') as playing_date, score FROM playerandgame");
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {

				int playerGameId = result.getInt("player_game_id");
				int gameId = result.getInt("game_id");
				int playerId = result.getInt("player_id");
				Date playDate = result.getDate("playing_date");
				int score = result.getInt("score");
				playerInfo.addAll(new PlayerAndGame(playerGameId, gameId, playerId, playDate, score));
			}
			return playerInfo;
		} catch (SQLException throwable) {
			System.out.println("Error: Cannot connect to database");
			throwable.printStackTrace();
			return playerInfo;
		} finally {
			// ensure database connection is closed
			try {
				if (conn != null)
					conn.close();
				System.out.println("Connection Closed!");
			} catch (SQLException e) {
				// connection close failed
				System.err.println(e.getMessage());
			}
		}
	}
	

	// READ player and game information for a specific player
	public static ObservableList<PlayerAndGame> getPlayerGameReportById(int id) {

		ObservableList<PlayerAndGame> playerInfo = FXCollections.observableArrayList();
		Connection conn = null;

		try {
			
			conn = DriverManager.getConnection(DATABASE_URL, USER, PASS);
			String sql = String.format(
					"SELECT player_game_id, game_id, player_id, playing_date, score FROM playerandgame where player_id = %d",
					id);
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery(sql);

			while (result.next()) {

				int playerGameId = result.getInt("player_game_id");
				int gameId = result.getInt("game_id");
				int playerId = result.getInt("player_id");
				Date playDate = result.getDate("playing_date");
				int score = result.getInt("score");
				playerInfo.addAll(new PlayerAndGame(playerGameId, gameId, playerId, playDate, score));
			}
			return playerInfo;
		} catch (SQLException throwable) {
			System.out.println("Error: Cannot connect to database");
			throwable.printStackTrace();
			return playerInfo;
		} finally {
			// ensure database connection is closed
			try {
				if (conn != null)
					conn.close();
				System.out.println("Connection Closed!");
			} catch (SQLException e) {
				// connection close failed
				System.err.println(e.getMessage());
			}
		}
	}
	
	
}
