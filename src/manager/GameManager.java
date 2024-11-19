package manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import stage.Stage;
import units.Player;

public class GameManager {

	public static final GameManager instance = new GameManager();
	public static final Map<String, Stage> stageList = new HashMap<>();
	public static final Random random = new Random();

	public static BufferedReader reader;
	public static BufferedWriter writer;
	public static Player player;

	private GameManager() {
	}

	public static void setPlayer(Player player) {
		GameManager.player = player;
	}

	public static BufferedReader getReader() {
		return reader;
	}

	public static BufferedWriter getWriter() {
		return writer;
	}

	public static void delay() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
	}

	public void init() {

	}

}
