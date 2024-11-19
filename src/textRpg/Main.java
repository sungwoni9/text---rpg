package textRpg;

import manager.GameManager;
import stage.StageSetting;

public class Main {

	public static void main(String[] args) {
		boolean run = true;
		GameManager.instance.init();
		while (true) {
			run = StageSetting.changeStage();
			if (!run) {
				break;
			}
		}
		System.out.println("게임 종료");
	}
}
