package stage;

import java.util.Map;

import textRpg.GameManager;
import units.UnitManager;

public class StageSetting implements Stage {
	private Map<String, Stage> stageList;

	public static String nextStage = "";
	public static String currentStage = "";

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

	@Override
	public void activateStage() {
		Stage stage = stageList.get(currentStage);
		if (stage != null) {
			stage.activate();
		} else {
			System.err.println("잘못된 스테이지 이름: " + currentStage);
		}
	}

}
