package textRpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import stage.Stage;
import stage.StageBattle;
import stage.StageInit;
import stage.StageLobby;
import units.Player;

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

	public static GameManager getInstance() {
		return instance;
	}

	public static void setInstance(GameManager instance) {
		GameManager.instance = instance;
	}

	public static StringBuilder getBuffer() {
		return buffer;
	}

	public static void setBuffer(StringBuilder buffer) {
		GameManager.buffer = buffer;
	}

	public Map<String, Stage> getStageList() {
		return stageList;
	}

	public void setStageList(Map<String, Stage> stageList) {
		this.stageList = stageList;
	}

	public static void setReader(BufferedReader reader) {
		GameManager.reader = reader;
	}

	public static void setWriter(BufferedWriter writer) {
		GameManager.writer = writer;
	}

	public static GameManager instance() {
		return instance;
	}

	public static BufferedReader getReader() {
		return reader;
	}

	public static BufferedWriter getWriter() {
		return writer;
	}

	void init() {
		stageList.put("TITLE", new StageInit());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("BATTLE", new StageBattle());
		nextStage = "TITLE";
	}

	public static boolean changeStage() {
		buffer.setLength(0);
		buffer.append("\ncurrentStage : " + currentStage);
		buffer.append("\nnextStage : " + nextStage);
		try {
			GameManager.writer.write(buffer.toString());
			GameManager.writer.flush();
		} catch (Exception e) {
		}

		if (currentStage.equals(nextStage))
			return true;

		currentStage = nextStage;
		Stage stage = stageList.get(currentStage);

		if (stage == null) {
			buffer.setLength(0);
			buffer.append("잘못된 스테이지입니다: " + currentStage);
			return false;
		}

		stage.init();

		boolean run = true;
		while (run) {
			run = stage.update();
			if (run == false)
				break;
		}
		if (nextStage.equals(""))
			return false;
		else
			return true;
	}

}
