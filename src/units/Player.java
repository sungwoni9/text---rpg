package units;

import java.util.ArrayList;
import java.util.Vector;

import playerSystem.Guild;
import playerSystem.Inventory;
import playerSystem.Item;

public class Player extends Unit {

	public static int money;

	public static Guild guild = new Guild();
	public static Inventory inven = new Inventory();

	Player() {

	}

	void init() {
		money = 10000;
		Guild.setGuild();
	}

	public Player(String name, int level, int hp, int att, int def, int luck, int exp) {
		super(name, level, hp, att, def, luck, exp);
	}

	public Player(String name, int level, int maxhp, int att, int def, int luck, int exp, boolean party) {
		super(name, level, maxhp, att, def, luck, exp, false);
	}

	void skill() {

	}

	public void inventoryMenu() {
		inven.inventoryMenu();
	}

	static public Vector<Player> getGuildList() {
		return Guild.guildList;
	}

	static public ArrayList<Item> getItemList() {
		return inven.itemList;
	}

	static public Player getGuildUnit(int num) {
		return Guild.getGuildUnit(num);
	}

	static public int getGuildSize() {
		return Guild.guildList.size();
	}

	static public int getItemSize() {
		return inven.itemList.size();
	}

}
