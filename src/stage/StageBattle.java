package stage;

import java.util.Random;
import java.util.Vector;

import textRpg.GameManager;
import units.Monster;
import units.Player;
import units.UnitManager;

public class StageBattle extends Stage {

	UnitManager unit = null;
	Vector<Monster> monList = null;
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
				if (monster_N < monList.size()) {
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
		unit.Player = new Player();
		monList = null;
		monList = unit.getMon_list();
		monsterDead = monList.size();
		playerDead = Player.getGuildSize();

	}

	void print_character() {
		buffer.setLength(0);
		buffer.append("======[BATTLE]======");
		buffer.append(playerDead + " : " + monsterDead);
		buffer.append("======[PLAYER]======");

		try {
			writer.write(buffer.toString());
			writer.flush();
		} catch (Exception e) {
		}
		for (int i = 0; i < Player.getGuildSize(); i++) {
		}
		System.out.println("======[MONSTER]======");
		for (int i = 0; i < monList.size(); i++) {
		}
	}

	void check_live() {
		int num = 0;
		for (int i = 0; i < Player.getGuildSize(); i++) {
			if (Player.getGuildUnit(i).hp <= 0) {
				num += 1;
			}
		}
		playerDead = Player.getGuildSize() - num;

		num = 0;
		for (int i = 0; i < monList.size(); i++) {
			if (monList.get(i).currentHp <= 0) {
				num += 1;
			}
		}
		monsterDead = monList.size() - num;
	}

	private void monster_attack(int m_index) {

	}

	private void player_attack(int p_index) {

	}
}
