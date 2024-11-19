package textRpg;

import stage.StageSetting;

public class TextRPG {

	private StageSetting stageSetting;
	private boolean isRun = false;

	private static TextRPG instance;

	public TextRPG() {
		stageSetting = new StageSetting();
	}

	public static TextRPG getInstance() {
		if (instance == null) {
			instance = new TextRPG();
		}
		return instance;
	}

}
