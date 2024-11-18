package stage;

import textRpg.GameManager;

public class StageInit extends Stage{

	@Override
	public boolean update() {
		try {
			buffer.setLength(0);
			
			buffer.append("\n==== TEXT RPG ====");
			buffer.append("\n[시작] 을 입력하세요\n☞");
			
			writer.write(buffer.toString());
			writer.flush();

			String input = reader.readLine();
			if (input != null && input.equals("시작")) {
				GameManager.nextStage = "LOBBY";
				return false;
			}
		} catch (Exception e) {
			System.out.println("다시 입력해주세요");

		}
		return false;
	}

	@Override
	public void init() {

	}

}
