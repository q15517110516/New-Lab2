package pokerBase;

import java.util.ArrayList;
import java.util.UUID;
import pokerBase.Player;

public class Table {
	private UUID TableID = UUID.randomUUID();
	private ArrayList<Player> players = new ArrayList();

	public Table AddPlayerToTable(Player p) {
		this.players.add(p);
		return this;
	}
}