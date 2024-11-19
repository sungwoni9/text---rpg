package stage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import textRpg.GameManager;
import units.Player;
import units.Unit;

public class Guild implements Stage {

	private static final int MAX_GUILD_MEMBERS = 10;
	private static final int COST = 5000;
	private static final String[] NAME = { "드", "레", "곤", "슬", "레", "이", "어" };

	final static int PARTY_SIZE = 3;
	public static Vector<Player> guildList = new Vector<>();
	private StringBuffer buffer = new StringBuffer();
	protected BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	Random random = new Random();
	static Unit[] partyList;

	private final int PRINT = 1;
	private final int ADD = 2;
	private final int REMOVE = 3;
	private final int CHANGEUNIT = 4;
	private final int CHANGEORDER = 5;
	private final int BACK = 0;

	public static void setGuild() {
		guildList.add(new Player("전사", 3, 300, 150, 100, 5, 0));
		guildList.add(new Player("법사", 8, 200, 300, 40, 10, 0));
		guildList.add(new Player("힐러", 3, 150, 100, 20, 15, 0));

		for (int i = 0; i < PARTY_SIZE; i++) {
			guildList.get(i).setGuild(true);
		}

		partyList = new Unit[PARTY_SIZE];

		int idx = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).isGuild() == true) {
				partyList[idx] = guildList.get(i);
				idx += 1;
			}
		}
	}

	@Override
	public void activateStage() {
		while (true) {
			buffer.append("=============== [길드관리] ================");
			buffer.append("[1.길드 목록]\t\t[2.길드원 추가]\t\t[3.길드원 삭제]");
			buffer.append("[4.길드원 교체]\t\t[5.순서 변경]\t\t[0.뒤로가기]");

			int sel = GameManager.selMenu("메뉴를 선택하세요");
		
			try {

				if (sel == PRINT) {
					printAllUnitStaus();
				} else if (sel == ADD) {
					buyUnit();
				} else if (sel == REMOVE) {
					removeUnit();
				} else if (sel == CHANGEUNIT) {
					changeGuildUnit();
				} else if (sel == CHANGEORDER) {
					changeGuildOrder();
				} else if (sel == BACK) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static Player getGuildUnit(int num) {
		return guildList.get(num);
	}

	public void printAllUnitStaus() {
		buffer.append("======================================");
		buffer.append("[골드 : " + Player.getMoney() + "]");
		buffer.append("============= [길드원] =================");
		for (int i = 0; i < guildList.size(); i++) {
			Player player = guildList.get(i);
			buffer.append("[").append(i + 1).append("번] [이름 : ").append(player.getName());
			buffer.append("] [레벨 : ").append(player.getLevel()).append("]");
			buffer.append(" [체력 : ").append(player.getMaxHp()).append("]");
			buffer.append(" [공격력 : ").append(player.getAtt()).append("]");
			buffer.append(" [방어력 : ").append(player.getDef()).append("]");
			buffer.append(" [행운 : ").append(player.getDef()).append("]");
			buffer.append(" [파티중 : ").append(player.isGuild()).append("]\n");
		}

		buffer.append("======================================");

		try {
			writer.write(buffer.toString());
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void printGuild() {
		System.out.println("===== 길드원 목록 =====");
		for (int i = 0; i < guildList.size(); i++) {
			Unit unit = guildList.get(i);
			System.out.println((i + 1) + ". " + unit.getName() + (unit.isGuild() ? " (파티)" : ""));
		}
	}

	public void buyUnit() {

	}

	private void removeUnit() {
		printGuild();
		int selection = GameManager.selMenu("삭제할 파티원을 선택하세요");

		if (selection > 0 && selection <= PARTY_SIZE) {
			Player playerToRemove = guildList.get(selection - 1);
			playerToRemove.setGuild(false);

			Player[] temp = new Player[PARTY_SIZE - 1];
			int tempIndex = 0;

			for (int i = 0; i < PARTY_SIZE; i++) {
				if (!partyList[i].equals(playerToRemove)) {
					temp[tempIndex] = guildList.get(i);
					tempIndex++;
				}
			}
			partyList = temp;

			buffer.append(playerToRemove.getName() + "님이 파티에서 제외되었습니다.");
		} else {
			return;
		}
	}

	public void changeGuildOrder() {

	}

	public void changeGuildUnit() {
		boolean isRun = true;
		while (isRun) {

			printGuild();
			int selection = GameManager.selMenu("교체할 길드원을 선택하세요(종료:0)") - 1;

			if (selection == -1) {
				break;
			}

			if (selection >= 0 && selection < guildList.size()) {
				Unit selectedUnit = guildList.get(selection);

				if (!selectedUnit.isGuild()) {
					addToGuild(selectedUnit);
					buffer.setLength(0);
					buffer.append(selectedUnit.getName() + "을/를 파티에 추가했습니다.");
				} else {
					buffer.append("이미 파티에 포함된 유닛입니다.");
				}

			} else {
				buffer.append("잘못된 선택입니다.");
			}
			try {
				writer.write(buffer.toString());
				writer.flush();

				Thread.sleep(1000);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void addToGuild(Player selectedUnit) {
		if (selectedUnit != null) {
			guildList.add(selectedUnit);
			buffer.append(selectedUnit.getName() + "을/를 길드에 추가했습니다.");

		} else {
			System.out.println("잘못된 유닛입니다.");
		}
	}

	public void printUnitStaus(int selUnit) {
		guildList.get(selUnit);
		Player.getStatus();
	}

	public void printUnitItem(int selUnit) {
		guildList.get(selUnit);
		Player.printEquitedItem();
	}

}
