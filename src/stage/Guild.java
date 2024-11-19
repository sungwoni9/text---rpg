package stage;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import manager.IOManager;
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
	public boolean update() {
		while (true) {
			buffer.append("=============== [길드관리] ================");
			buffer.append("[1.길드 목록]\t\t[2.길드원 추가]\t\t[3.길드원 삭제]");
			buffer.append("[4.길드원 교체]\t\t[5.순서 변경]\t\t[0.뒤로가기]");

			int sel = (int) IOManager.selMenu(Integer.class, "☞");

			try {

				if (sel == PRINT) {
					printAllUnitStaus();
				} else if (sel == ADD) {
					buyUnit();
				} else if (sel == REMOVE) {
					removeUnit();
				} else if (sel == CHANGEUNIT) {
					changeGuildOrder();
				} else if (sel == CHANGEORDER) {
					removeAndAddGuildUnit();
				} else if (sel == BACK) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;

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
			buffer.append("] [레벨 : ").append(Unit.getLevel()).append("]");
			buffer.append(" [체력 : ").append(Unit.getMaxHp()).append("]");
			buffer.append(" [공격력 : ").append(Unit.getAtt()).append("]");
			buffer.append(" [방어력 : ").append(Unit.getDef()).append("]");
			buffer.append(" [행운 : ").append(Unit.getDef()).append("]");
			buffer.append(" [파티중 : ").append(Unit.isGuild()).append("]\n");
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

	public void addToGuild(Unit selectedUnit) {
		if (selectedUnit != null) {
			if (guildList.size() < MAX_GUILD_MEMBERS) {
				guildList.add((Player) selectedUnit);
				selectedUnit.setGuild(true);

				ArrayList<Player> tempPartyList = new ArrayList<>();
				for (int i = 0; i < guildList.size(); i++) {
					if (guildList.get(i).isGuild()) {
						tempPartyList.add(guildList.get(i));
					}
				}

				partyList = tempPartyList.toArray(new Player[PARTY_SIZE]);
				buffer.append(selectedUnit.getName() + "을/를 길드에 추가했습니다.");
			}
		} else {
			System.out.println("잘못된 유닛입니다.");
		}
	}

	private void removeUnit() {
		printGuild();

		int sel = (int) IOManager.selMenu(Integer.class, "삭제할 길드원을 선택하세요");

		if (sel > 0 && sel <= PARTY_SIZE) {
			Player playerToRemove = guildList.get(sel - 1);
			playerToRemove.setGuild(false);

			ArrayList<Player> tempGuildList = new ArrayList<>(guildList);
			tempGuildList.remove(playerToRemove);

			ArrayList<Player> tempPartyList = new ArrayList<>();
			for (int i = 0; i < tempGuildList.size(); i++) {
				if (tempGuildList.get(i).isGuild()) {
					tempPartyList.add(tempGuildList.get(i));
				}
			}

			partyList = tempPartyList.toArray(new Player[PARTY_SIZE]);

			buffer.append(playerToRemove.getName() + "님이 파티에서 제외되었습니다.");
		} else {
			buffer.append("잘못된 선택입니다.");
		}
	}

	public void changeGuildOrder() {

	}

	public void removeAndAddGuildUnit() {
		boolean isRun = true;
		while (isRun) {

			printGuild();
			int sel = (int) IOManager.selMenu(Integer.class, "☞");
			if (sel == -1) {
				break;
			}

			if (sel >= 0 && sel < guildList.size()) {
				Unit selectedUnit = guildList.get(sel);

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

	public void printUnitStaus(int selUnit) {
		guildList.get(selUnit);
		Player.getStatus();
	}

	public void printUnitItem(int selUnit) {
		guildList.get(selUnit);
		Player.printEquitedItem();
	}

	@Override
	public void init() {

	}

}
