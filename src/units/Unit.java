package units;

import playerSystem.Item;

public abstract class Unit {

	private String name;
	private int level;
	private int hp;
	private int maxHp;
	private int att;
	private int def;
	private int luck;
	private int exp;
	private boolean party;

	Item weapon;
	Item armor;
	Item ring;
	String state = "노말";

	Unit() {
	}

	public Unit(String name, int level, int hp, int att, int def, int luck, int exp) {
		this.name = name;
		this.level = level;
		this.maxHp = hp;
		this.hp = maxHp;
		this.att = att;
		this.luck = luck;
		this.def = def;
		this.exp = exp;
		party = false;
		weapon = null;
		armor = null;
		ring = null;
	}

	public Unit(String name, int level, int hp, int att, int def, int luck, int exp, boolean party) {
		super();
		this.name = name;
		this.level = level;
		this.maxHp = hp;
		this.hp = maxHp;
		this.att = att;
		this.luck = luck;
		this.def = def;
		this.exp = exp;
		this.party = party;
		weapon = null;
		armor = null;
		ring = null;
	}

	private StringBuffer buffer = new StringBuffer();

	public void setItem(Item weapon, Item armor, Item ring) {
		this.weapon = weapon;
		this.armor = armor;
		this.ring = ring;
	}

	public String getStatus() {
		int extraHp = armor == null ? 0 : ring.getPower();
		int extraAtt = weapon == null ? 0 : weapon.getPower();
		int extraDef = armor == null ? 0 : armor.getPower();
		int extraluck = ring == null ? 0 : ring.getPower();

		buffer.setLength(0);
		buffer.append("[이름 : ").append(name).append("]");
		buffer.append(" [레벨 : ").append(level).append("]");
		buffer.append(" [체력 : ").append(maxHp).append(" + ").append(extraHp).append("]");
		buffer.append(" [공격력 : ").append(att).append(" + ").append(extraAtt).append("]");
		buffer.append(" [방어력 : ").append(def).append(" + ").append(extraDef).append("]");
		buffer.append(" [행운 : ").append(luck).append(" + ").append(extraluck).append("]");
		buffer.append(" [파티중 : ").append(party).append("]");

		return buffer.toString();
	}

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

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
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

	public int getLuck() {
		return luck;
	}

	public void setLuck(int luck) {
		this.luck = luck;
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

	public Item getWeapon() {
		return weapon;
	}

	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}

	public Item getArmor() {
		return armor;
	}

	public void setArmor(Item armor) {
		this.armor = armor;
	}

	public Item getRing() {
		return ring;
	}

	public void setRing(Item ring) {
		this.ring = ring;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
