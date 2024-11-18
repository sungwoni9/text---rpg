package stage;

import textRpg.GameManager;

public class StageMenu extends Stage {

	private final int GUILD = 1;
	private final int SHOP = 2;
	private final int INVENTORY = 3;

	public void printAndSelMenu() {
		buffer.append("[1.길드] [2.상점] [3.인벤토리]");
		try {
			writer.write(buffer.toString());
			writer.flush();

			String input = reader.readLine();
			int sel = Integer.parseInt(input);
			
			if (input == GUILD)
				GameManager.nextStage = "GUILD";
			else if (input.equals(SHOP))
				GameManager.nextStage = "SHOP";
			else if (input.equals(INVENTORY))
				GameManager.nextStage = "INVENTORY";

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
