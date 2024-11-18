package textRpg;

public class Main {
	
		public static void main(String[] args) {
			boolean run = true;
			GameManager.instance.init();
			while (true) {
				run = GameManager.instance.changeStage();
				if (run == false) {
					break;
				}
			}
			System.out.println("게임 종료");
		}

}
