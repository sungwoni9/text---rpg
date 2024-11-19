package stage;

import java.util.Map;

import units.UnitManager;

public class StageSetting implements Stage {
	private Map<String, Stage> stageList;
	@Override
	void init() {
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
	public void activateStage() {

	}

}
