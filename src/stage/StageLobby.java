package stage;

import manager.IOManager;

public class StageLobby implements Stage {

	private final int BATTLE = 1;
	private final int MENU = 2;
	private final int EXIT = 3;

	@Override
	public boolean update() {
		printLobby();

		try {

			int sel = (int) IOManager.selMenu(Integer.class, "메뉴를 선택하세요");
			switch (sel) {
			case BATTLE -> StageSetting.setNextStage("BATTLE");
			case MENU -> StageSetting.setNextStage("MENU");
			case EXIT -> StageSetting.setNextStage("EXIT");
			default -> System.err.println("올바르지 않은 선택입니다. 다시 입력하세요.");
			}

		} catch (NumberFormatException e) {
			System.err.println("숫자를 입력해주세요!");
		} catch (Exception e) {
			System.err.println("입력 오류가 발생했습니다.");
		}
		return false;

	}

	private void printLobby() {
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

	}

}
