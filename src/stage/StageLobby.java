package stage;

import textRpg.GameManager;
import units.UnitManager;

public class StageLobby extends Stage {
	private final int BATTLE = 1;
	private final int MENU = 2;
	private final int EXIT = 3;

	@Override
	public boolean update() {
		buffer.setLength(0);
		buffer.append("=====[LOBBY]=====\n");
		buffer.append("[1. 전투] [2. 메뉴] [3. 종료]\n☞");

		try {
			GameManager.writer.write(buffer.toString());
			GameManager.writer.flush();

			String input = GameManager.reader.readLine();
			int sel = Integer.parseInt(input);

			if (sel == BATTLE) {
				GameManager.nextStage = "BATTLE";
			}

			else if (sel == MENU) {
				GameManager.nextStage = "MENU";
			}

			else if (sel == EXIT) {
				GameManager.nextStage = "EXIT";
			}

		} catch (Exception e) {
			System.err.println("입력값 오류!!");

		}

		return false;
	}

	@Override
	public void init() {
		UnitManager.instance.init();
	}

}
