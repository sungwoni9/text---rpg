package units;

import java.util.ArrayList;

import playerSystem.Guild;
import playerSystem.Inventory;
import playerSystem.Item;

public class Player extends Unit {

	private String name;
	private int level;
	private int maxHp;
	private int att;
	private int def;
	private int exp;
	private boolean party;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getAtt() {
		return att;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public boolean isParty() {
		return party;
	}

	public void setParty(boolean party) {
		this.party = party;
	}

	public static int getMoney() {
		return money;
	}

	public static void setMoney(int money) {
		Player.money = money;
	}

	public static Inventory getInven() {
		return inven;
	}

	public static void setInven(Inventory inven) {
		Player.inven = inven;
	}

	public boolean isMember() {
		return member;
	}

	public void setMember(boolean member) {
		this.member = member;
	}

	public static int money;

	static Inventory inven = new Inventory();

	public boolean member;

	public Player(String name, int level, int maxHp, int maxMp, int att, int def, int exp) {
		super(name, level, maxHp, maxMp, att, def, exp);
	}

	public Player(String name, int level, int maxHp, int att, int def, int exp, boolean party) {
		super(name, level, maxHp, att, def, exp, false);
	}

	public Player() {

	}

	void init() {
		money = 10000;
		Guild.setGuild();

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

	}

	public int getCurrentHp() {
		this.currentHp = currentHp;
	}

	public String name() {
		return null;
	}

	public void attack(Monster monster) {

	}

}
