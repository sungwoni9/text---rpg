package units;

import java.util.ArrayList;

import playerSystem.Guild;
import playerSystem.Inventory;
import playerSystem.Item;

public class Player extends Unit {

	public static int money;

	static Guild guild = new Guild();
	static Inventory inven = new Inventory();

	public boolean member;

	public Player(String name, int level, int maxhp, int maxMp, int att, int def, int exp) {
		super(name, level, maxhp, maxMp, att, def, exp);
	}

	public Player(String name, int level, int maxhp, int att, int def, int exp, boolean party) {
		super(name, level, maxhp, att, def, exp, false);
	}

	public Player() {
		this("", 1, 100, 10, 5, 0, false);
	}

	void init() {
		money = 10000;
		guild.setGuild();

	}

	void skill() {

	}

	public static int getGuildSize() {
		return 0;
	}

	public void inventoryMenu() {
		inven.inventoryMenu();
	}

	static public ArrayList<Item> getItemList() {
		return inven.itemList;
	}

	static public Player getGuildUnit(int num) {
		return Guild.getGuildUnit(num);
	}

	public static void printEquitedItem() {

	}

	public static void printStatus() {

	}

	public void printData() {
		// TODO Auto-generated method stub
		
	}

	public int getCurrentHp() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

	public void attack(Monster monster) {
		// TODO Auto-generated method stub
		
	}

}
