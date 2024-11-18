package stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public abstract class Stage {

	public abstract boolean update();

	protected String curStage;

	public String getCurStage() {
		return curStage;
	}

	public void setCurStage(String curStage) {
		this.curStage = curStage;
	}

	protected String nextStage;

	protected StringBuffer buffer = new StringBuffer();
	protected BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	protected BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public String getNextStage() {
		return nextStage;
	}

	public void setNextStage(String nextStage) {
		this.nextStage = nextStage;
	}

	public StringBuffer getBuffer() {
		return buffer;
	}

	public void setBuffer(StringBuffer buffer) {
		this.buffer = buffer;
	}

	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}

	public void setWriter(BufferedWriter writer) {
		this.writer = writer;
	}

	public void init() {
	}

	public BufferedReader getReader() {
		return reader;
	}

	public BufferedWriter getWriter() {
		return writer;
	}

}