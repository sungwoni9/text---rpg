package stage;

import manager.GameManager;
import units.UnitManager;

public class StageMenu implements Stage {

	private final int GUILD = 1;
	private final int SHOP = 2;
	private final int INVENTORY = 3;

	public boolean update() {
		buffer.append("\n=====[MENU]=====\n");
		buffer.append("[1.길드] [2.상점] \n[3.인벤토리]\n☞");
		
		try {
			writer.write(buffer.toString());
			writer.flush();

			String input = reader.readLine();
			int sel = Integer.parseInt(input);

			if (sel == GUILD)
				GameManager.nextStage = "GUILD";
			else if (sel == SHOP)
				GameManager.nextStage = "SHOP";
			else if (sel == INVENTORY)
				GameManager.nextStage = "INVENTORY";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
