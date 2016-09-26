package pokerBase;

import java.util.UUID;

public class Player {
	private UUID PlayerID = UUID.randomUUID();
	private String PlayerName;

	public Player(String strPlayerName) {
		this.PlayerName = strPlayerName;
	}
}