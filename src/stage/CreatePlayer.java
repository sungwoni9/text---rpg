package stage;

public class CreatePlayer extends Stage {

	@Override
	public boolean update() {
		buffer.append("=== CREATE PLAYER ===");
		buffer.append("/n[1.전사]");
		buffer.append("/n[2.법사]");
		buffer.append("/n[3.궁수]");
		buffer.append("/n[4.도적]");
		buffer.append("/n[5.팔라딘]");
		buffer.append("\n☞");

		try {
			writer.write(buffer.toString());
			writer.flush();

			String input = reader.readLine();
			int sel = Integer.parseInt(input);

			if (sel == 1) {

			}

			else if (sel == 2) {

			}

			else if (sel == 3) {

			}

			else if (sel == 4) {

			}

			else if (sel == 5) {
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
