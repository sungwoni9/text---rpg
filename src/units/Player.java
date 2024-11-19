package units;

import java.util.ArrayList;
import java.util.Vector;

import stage.Guild;
import stage.Inventory;
import stage.Item;

public class Player extends Unit {

	private static int money;

	public static Guild guild = new Guild();

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

	public static int getMoney() {
		return money;
	}

	public static void setMoney(int money) {
		Player.money = money;
	}

	public static Guild getGuild() {
		return guild;
	}

	public static Guild setGuild(Guild guild) {
		return Player.guild = guild;
	}

	public static Inventory getInven() {
		return inven;
	}

	public static void setInven(Inventory inven) {
		Player.inven = inven;
	}

	public static Inventory inven = new Inventory();

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

	public static void printEquitedItem() {

	}

	public int getCurrentHp() {
		return 0;
	}

	public void attack(Monster monster) {

	}

	public void printData() {

	}

	public void setGuild(boolean b) {

	}

	public boolean isGuild() {
		return false;
	}

}