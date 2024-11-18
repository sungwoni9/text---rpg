package stage;

import java.util.Random;
import java.util.Vector;

import textRpg.GameManager;
import units.Monster;
import units.Player;
import units.UnitManager;

public class StageBattle extends Stage {

	UnitManager unit = null;
	Vector<Monster> monsterList = null;
	Random random;
	int monsterDead = 0;
	int playerDead = 0;

	public StageBattle() {
		unit = UnitManager.instance;
		random = new Random();
	}

	@Override
	public boolean update() {
		boolean run = true;
		int player_N = 0;
		int monster_N = 0;
		boolean turn = true;

		while (run) {
			if (turn) {
				print_character();
				if (player_N < Player.getGuildSize()) {
					player_attack(player_N);
					player_N += 1;
				} else {
					turn = !turn;
					player_N = 0;
				}
			} else if (!turn) {
				if (monster_N < monsterList.size()) {
					monster_attack(monster_N);
					monster_N += 1;
				} else {
					turn = !turn;
					monster_N = 0;
				}
			}

			check_live();
			if (monsterDead <= 0 || playerDead <= 0)
				break;
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {
		unit.getMon_list().clear();
		unit.monster_rand_set(4);
		unit.Player = null;
		monsterList = null;
		monsterList = unit.getMon_list();
		monsterDead = monsterList.size();
		playerDead = Player.getGuildSize();

	}

	void print_character() {
		buffer.setLength(0);
		buffer.append("======[BATTLE]======\n");
		buffer.append(playerDead + "\t : \t" + monsterDead);
		buffer.append("\n======[PLAYER]======");

		for (int i = 0; i < Player.getGuildSize(); i++) {
			Player.getGuildUnit(i).printData();
		}
		buffer.append("\n======[MONSTER]======");
		for (int i = 0; i < monsterList.size(); i++) {
			monsterList.get(i).printData();
		}

		try {
			writer.write(buffer.toString());
			writer.flush();
		} catch (Exception e) {
		}
	}

	void player_attack(int index) {
		Player player = Player.getGuildUnit(index);

		if (player.getCurrentHp() <= 0)
			return;

		buffer.append("======[메뉴 선택]=====");
		buffer.append("[" + player.name() + "] [1.어택] [2.스킬]");

		try {
			writer.write(buffer.toString());
			writer.flush();

			String input = reader.readLine();
			int sel = Integer.parseInt(input);
			if (sel == 1) {
				while (true) {
					int idx = random.nextInt(monsterList.size());
					if (monsterList.get(idx).currentHp > 0) {
						player.attack(monsterList.get(idx));
						break;
					}
				}
			} else if (sel == 2) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void monster_attack(int index) {
		Monster monster = monsterList.get(index);
		if (monster.getCurrentHp() <= 0)
			return;
		while (true) {
			int idx = random.nextInt(Player.getGuildSize());
			if (monster.getCurrentHp() > 0) {
				monster.attack(Player.getGuildUnit(idx));
				break;
			}
		}
	}

	void check_live() {
		int num = 0;
		for (int i = 0; i < Player.getGuildSize(); i++) {
			if (Player.getGuildUnit(i).getCurrentHp() <= 0) {
				num += 1;
			}
		}
		playerDead = Player.getGuildSize() - num;

		for (int i = 0; i < monsterList.size(); i++) {
			if (monsterList.get(i).getCurrentHp() <= 0) {
				num += 1;
			}
		}
		monsterDead = monsterList.size() - num;
	}
}
