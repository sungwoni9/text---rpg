package stage;

import java.util.HashMap;
import java.util.Map;

import textRpg.GameManager;
import units.UnitManager;

public class StageSetting implements Stage {
	private Map<String, Stage> stageList =  new HashMap<>();

	public static String nextStage = "";
	public static String currentStage = "";

	public static Object instance;

	@Override
	public void init() {
		UnitManager.getInstance();
		stageList.put("TITLE", new StageInit());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("MENU", new StageMenu());
		stageList.put("GUILDMENU", new Guild());
		stageList.put("STOREMENU", new Shop());
		stageList.put("INVENMENU", new Inventory());
		nextStage = "TITLE";
	}

	@Override
	public boolean activate() {
		if (nextStage != null && !nextStage.isEmpty()) {
			currentStage = nextStage;
			nextStage = "";
			return true;
		}
		return false;
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

	public boolean changeStage() {
		try {
			GameManager.writer.write("스테이지 변경 중...\n");
			GameManager.writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (currentStage.equals(nextStage)) {
			return true;
		}

		currentStage = nextStage;
		Stage stage = stageList.get(currentStage);
		if (stage != null) {
			stage.init();
			while (stage.activate()) {
			}
		} else {
			System.err.println("잘못된 스테이지: " + currentStage);
			return false;
		}

		return !nextStage.isEmpty();
	}

	@Override
	public void activateStage() {
		Stage stage = stageList.get(currentStage);
		if (stage != null) {
			stage.activate();
		} else {
			System.err.println("잘못된 스테이지 : " + currentStage);
		}
	}

}
