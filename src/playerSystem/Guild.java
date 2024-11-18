package playerSystem;

import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import stage.Stage;
import textRpg.GameManager;
import units.Player;
import units.Unit;

abstract public class Guild extends Stage {

	final int PARTY_SIZE = 3;
	Vector<Player> guildList = new Vector<>();
	private StringBuffer buffer = new StringBuffer();

	Random random = new Random();
	Unit[] partyList;

	private final int PRINT = 1;
	private final int ADD = 2;
	private final int REMOVE = 3;
	private final int CHANGEPARTY = 4;
	private final int CHANGEORDER = 5;
	private final int BACK = 6;

	public void setGuild() {
		guildList.add(new Player("전사", 3, 300, 150, 45, 55, 0));
		guildList.add(new Player("법사", 8, 200, 300, 60, 20, 0));
		guildList.add(new Player("힐러", 3, 150, 250, 45, 10, 0));

		for (int i = 0; i < PARTY_SIZE; i++) {
			guildList.get(i).member = true;
		}

		partyList = new Unit[PARTY_SIZE];

		int idx = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).member == true) {
				partyList[idx] = guildList.get(i);
				idx += 1;
			}
		}
	}

	public void printAllUnitStaus() {
		buffer.append("======================================");
		buffer.append("[골드 : " + Player.money + "]");
		buffer.append("============= [길드원] =================");
		for (int i = 0; i < guildList.size(); i++) {
			buffer.append("[" + (i + 1) + "번]");
			buffer.append(" [이름 : " + guildList.get(i).name + "]");
			buffer.append(" [레벨 : " + guildList.get(i).level + "]");
			buffer.append(" [체력 : " + guildList.get(i).hp);
			buffer.append(" / " + guildList.get(i).maxHp + "]");
			buffer.append("[공격력 : " + guildList.get(i).att + "]");
			buffer.append(" [방어력 : " + guildList.get(i).def + "]");
			buffer.append(" [파티중 : " + guildList.get(i).party + "]");
		}
		buffer.append("======================================");

		try {
			writer.write(buffer.toString());
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void guildMenu() {
		while (true) {
			buffer.append("=============== [길드관리] ================");
			buffer.append("[1.길드 목록]\t\t[2.길드원 추가]\t\t[3.길드원 삭제]");
			buffer.append("[4.길드원 교체]\t\t[5.순서 변경]\t\t[0.뒤로가기]");

			String input;
			try {
				input = reader.readLine();
				int sel = Integer.parseInt(input);

				if (sel == PRINT) {
					printAllUnitStaus();
				} else if (sel == ADD) {
					addUnit();
				} else if (sel == REMOVE) {
					removeUnit();
				} else if (sel == CHANGEPARTY) {
					partyChange();
				} else if (sel == CHANGEORDER) {
					changeOrder();
				} else if (sel == BACK) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void changeOrder() {

	}

	private void partyChange() {

	}

	private void removeUnit() {

	}

	private void addUnit() {

	}

	static public Player getGuildUnit(int num) {
		return Guild.getGuildUnit(num);
	}

	public void printUnitStaus(int selUnit) {
		guildList.get(selUnit);
		Player.printStatus();
	}

	public void printUnitItem(int selUnit) {
		guildList.get(selUnit);
		Player.printEquitedItem();
	}

}
