package exercise1;

import java.sql.Date;

public class PlayerAndGame {

	int playerGameId;
	int gameId;
	int playerId;
	Date playDate;
	int score;

	public PlayerAndGame(int playerGameId, int gameId, int playerId, Date playDate, int score) {
		this.playerGameId = playerGameId;
		this.gameId = gameId;
		this.playerId = playerId;
		this.playDate = playDate;
		this.score = score;
	}
}
