package stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import manager.IOManager;

public class StageInit implements Stage {
	StringBuilder bf = IOManager.buffer;
	BufferedReader br = IOManager.reader;
	BufferedWriter wr = IOManager.writer;

	@Override
	public boolean update() {
		printMainMenuGuide();
		try {
			String input = (String) IOManager.selMenu(String.class, "☞");
			
			if ("시작".equals(input)) {
				StageSetting.nextStage = "LOBBY";
				return true;
			} else if ("종료".equals(input))
				printExitMessage();

		} catch (Exception e) {
			System.out.println("다시 입력해주세요");

		}
		return false;

	}

	@Override
	public void init() {

	}

	private void printMainMenuGuide() {
		String msg = """
				=========================
				=         TEXT PG       =
				=      시작하려면 "시작",    =
				=      종료하려면 "종료"를    =
				=         입력하세세요.     =
				=========================
				""";
		IOManager.printString(msg);
	}

	private void printExitMessage() {
		String msg = """
				=======================
				=   게임을 를 종료합니다    =
				=======================
				""";
		IOManager.printString(msg);
	}

}
