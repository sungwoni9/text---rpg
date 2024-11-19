package manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOManager {
	public static StringBuilder sb;
	public static BufferedReader br;
	public static BufferedWriter bw;

	private IOManager() {
		sb = new StringBuilder();
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}

	private static IOManager instance = new IOManager();

	public static IOManager getInstance() {
		return instance;
	}

	public static void printString(String msg) {
		sb.setLength(0);
		sb.append(msg);
		try {
			bw.append(sb);
			bw.flush();
		} catch (IOException e) {
			return;
		}
	}

	public static int selMenu(String msg) {
		sb.append(msg + "\n ☞ ");
		int num = -1;

		try {
			String input = br.readLine();
			num = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.err.println("숫자로 입력하세요");
		} catch (Exception e) {
			System.err.println("입력 오류 발생");
		}
		return num;
	}
}