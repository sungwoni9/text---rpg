package stage;

import manager.IOManager;
import textRpg.GameManager;

public class StageLobby implements Stage {
	

	private final int BATTLE = 1;
	private final int MENU = 2;
	private final int EXIT = 3;

	@Override
	public void update() {
		.setLength(0);
		System.out.println();
		GameManager.writer.append("=====[LOBBY]=====\n");
		GameManager.writer.append("[1. 전투] [2. 메뉴] [3. 종료]\n☞");

		try {
			GameManager.writer.write(buffer.toString());
			GameManager.writer.flush();

			String input = GameManager.reader.readLine();
			int sel = Integer.parseInt(input);

			if (sel == BATTLE) {
				StageSetting.nextStage = "BATTLE";
			}

			else if (sel == MENU) {
				StageSetting.nextStage = "MENU";
			}

			else if (sel == EXIT) {
				StageSetting.nextStage = "EXIT";
			}

		} catch (Exception e) {
			System.err.println("입력값 오류!!");

		}

	}

	private void printMainStage() {
		String msg = """

				========================
				=       < Lobby >     =
				=       1. 전투 	      =
				=       2. 메뉴	      =
				=       3. 종료        =
				=                     =
				= (원하는 메뉴를 입력하세요) =
				=======================
				""";
		IOManager.printString(msg);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
