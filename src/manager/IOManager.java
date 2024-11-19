package manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOManager {
	public static StringBuilder buffer;
	public static BufferedReader reader;
	public static BufferedWriter writer;

	private IOManager() {
		buffer = new StringBuilder();
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new BufferedWriter(new OutputStreamWriter(System.out));
	}

	private static IOManager instance = new IOManager();

	public static IOManager getInstance() {
		return instance;
	}

	public static void printString(String msg) {
		buffer.setLength(0);
		buffer.append(msg);
		try {
			writer.append(buffer);
			writer.flush();
		} catch (IOException e) {
			return;
		}
	}

	public static Object selMenu(Object type, String msg) {
	    printString(msg);
	    try {
	        String input = reader.readLine(); 
	        
	        if (type == Integer.class) {
	            try {
	                return Integer.parseInt(input);  
	            } catch (NumberFormatException e) {
	                System.err.println("잘못된 입력! 숫자를 입력해야 합니다.");
	                return null; 
	            }
	        }
	        
	        else if (type == String.class) {
	            return input; 
	        }
	        
	        return null; 

	    } catch (IOException e) {
	        System.err.println("입력 오류: " + e.getMessage());
	        return null; 
	    }
	}
}