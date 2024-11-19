package units;

import stage.Item;

public abstract class Unit {

	protected String name;
	protected int level;
	protected int hp;
	protected int maxHp;
	protected int att;
	protected int def;
	protected int luck;
	protected int exp;
	protected boolean party;

	protected Item weapon;
	protected Item armor;
	protected Item ring;
	private static StringBuffer buffer = new StringBuffer();

	public Unit(String name, int level, int hp, int att, int def, int luck, int exp) {
		this.name = name;
		this.level = level;
		this.maxHp = hp;
		this.hp = maxHp;
		this.att = att;
		this.def = def;
		this.luck = luck;
		this.exp = exp;
		this.party = false;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}

	public Unit(String name, int level, int hp, int att, int def, int luck, int exp, boolean party) {
		this(name, level, hp, att, def, luck, exp);
		this.party = party;
	}

	public void setItem(Item weapon, Item armor, Item ring) {
		this.weapon = weapon;
		this.armor = armor;
		this.ring = ring;
	}

	public int getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}

	public int getAtt() {
		return att;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getStatus() {
		int extraHp = armor == null ? 0 : ring.getPower();
		int extraAtt = weapon == null ? 0 : weapon.getPower();
		int extraDef = armor == null ? 0 : armor.getPower();
		int extraluck = ring == null ? 0 : ring.getPower();

		buffer.setLength(0);
		buffer.append(" [이름 : ").append(name).append("]");
		buffer.append(" [레벨 : ").append(level).append("]");
		buffer.append(" [체력 : ").append(maxHp).append(" + ").append(extraHp).append("]");
		buffer.append(" [공격력 : ").append(att).append(" + ").append(extraAtt).append("]");
		buffer.append(" [방어력 : ").append(def).append(" + ").append(extraDef).append("]");
		buffer.append(" [행운 : ").append(luck).append(" + ").append(extraluck).append("]");
		buffer.append(" [파티중 : ").append(party).append("]");

		return buffer.toString();
	}

	public boolean isGuild() {
		return false;
	}

}
