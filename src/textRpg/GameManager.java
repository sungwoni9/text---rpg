package textRpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import stage.Guild;
import stage.Inventory;
import stage.Shop;
import stage.Stage;
import stage.StageBattle;
import stage.StageInit;
import stage.StageLobby;
import stage.StageMenu;
import units.Player;
import units.UnitManager;

public class GameManager {

	public static BufferedReader reader;
	public static BufferedWriter writer;
	public static Random r = new Random();

	public static Player player;

	public static String nextStage = "";
	public static String currentStage = "";

	static GameManager instance = new GameManager();
	public static StringBuilder buffer = new StringBuilder();

	static Map<String, Stage> stageList = new HashMap<String, Stage>();

	private GameManager() {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new BufferedWriter(new OutputStreamWriter(System.out));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static GameManager getInstance() {
		return instance;
	}

	public static Player getPlayer() {
		return player;
	}

	public static void setPlayer(Player player) {
		GameManager.player = player;
	}

	public static String getNextStage() {
		return nextStage;
	}

	public static void setNextStage(String nextStage) {
		GameManager.nextStage = nextStage;
	}

	public static String getCurrentStage() {
		return currentStage;
	}

	public static void setCurrentStage(String currentStage) {
		GameManager.currentStage = currentStage;
	}

	public static BufferedReader getReader() {
		return reader;
	}

	public static BufferedWriter getWriter() {
		return writer;
	}

	void init() {
		UnitManager.getInstance();
		stageList.put("TITLE", new StageInit());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("MENU", new StageMenu());
		stageList.put("GUILDMENU", new Guild());
		stageList.put("STOREMENU", new Shop());
		stageList.put("INVENMENU", new Inventory());
		stageList.put("BATTLE", new StageBattle());
		nextStage = "TITLE";
	}

	boolean changeStage() {
		try {
			GameManager.writer.write(buffer.toString());
			GameManager.writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (currentStage.equals(nextStage))
			return true;

		currentStage = nextStage;
		Stage stage = stageList.get(currentStage);
		stage.init();

		boolean run = true;
		while (run) {
			run = stage.update();
		}

		if (nextStage.equals(""))
			return false;

		return true;
	}

	public static int selMenu(String msg) {
		buffer.append(msg + "\n ☞ ");
		int num = -1;

		try {
			String input = reader.readLine();
			num = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.err.println("숫자로 입력하세요");
		} catch (Exception e) {
			System.err.println("입력 오류 발생");
		}
		return num;
	}

	public static void show() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
	}

}
