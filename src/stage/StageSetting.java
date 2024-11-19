package stage;

import java.util.HashMap;
import java.util.Map;

import manager.IOManager;

public class StageSetting implements Stage {
	private static Map<String, Stage> stageList;

	public static String nextStage = "";
	public static String currentStage = "";

	public static StageSetting instance;

	public static StageSetting getInstance() {
		if (instance == null) {
			instance = new StageSetting();
		}
		return instance;
	}

	@Override
	public void init() {
		stageList = new HashMap<String, Stage>();
		stageList.put("TITLE", new StageInit());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("MENU", new StageMenu());
		stageList.put("GUILDMENU", new Guild());
		stageList.put("STOREMENU", new Shop());
		stageList.put("INVENMENU", new Inventory());
		nextStage = "TITLE"; 
		currentStage = "";
	}

	public static boolean changeStage() {
		IOManager.buffer.append("현재 스테이지 :" + currentStage);
		try {
			IOManager.writer.write(IOManager.buffer.toString());
			IOManager.writer.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (currentStage.equals(nextStage))
			return false;

		currentStage = nextStage;
		Stage stage = stageList.get(currentStage);
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

	public static String getNextStage() {
		return nextStage;
	}

	public static void setNextStage(String nextStage) {
		StageSetting.nextStage = nextStage;
	}

	public static String getCurrentStage() {
		return currentStage;
	}

	@Override
	public boolean update() {
		return false;
	}

}
