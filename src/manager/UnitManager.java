package manager;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import units.Monster;
import units.Player;

public class UnitManager {

	public static Random random;

	private static ArrayList<Monster> monsterList;

	String pate = "";
	String mons[] = { "MonsterWolf", "MonsterGolam", "MonsterOak" };

	private UnitManager() {
		UnitManager.random = new Random();
		monsterList = new ArrayList<Monster>();
	}

	private static UnitManager instance = new UnitManager();

	public static UnitManager getInstance() {
		return instance;
	}

	public ArrayList<Monster> getMonsterList() {
		return monsterList;
	}

	private static void generateRandomMoster(int size) {
	}

	public static ArrayList<Monster> getMonster() {
		return monsterList;
	}

}
