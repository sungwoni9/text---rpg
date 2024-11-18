package units;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	public static UnitManager instance = null;
	private Vector<Player> player_list = new Vector<Player>();
	private Vector<Monster> mon_list = new Vector<>();
	Random random = new Random();
	Player player = new Player();

	String pate = "";
	String mons[] = { "MonsterWolf", "MonsterGolam", "MonsterOak" };
	public Object Player;

	public static UnitManager getInstance() {
		if (instance == null) {
			instance = new UnitManager();
		}
		return instance;
	}

	private UnitManager() {
	}

	public void init() {
	}

	public Vector<Monster> getMon_list() {
		return mon_list;
	}

	public void setMon_list(Vector<Monster> mon_list) {
		this.mon_list = mon_list;
	}

	public void monster_rand_set(int size) {
	}

	public Vector<Monster> getMonsterList() {
		return getMonsterList();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Vector<Player> getPlayer_list() {
		return player_list;
	}

	public void setPlayer_list(Vector<Player> player_list) {
		this.player_list = player_list;
	}

}
