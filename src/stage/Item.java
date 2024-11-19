package stage;

public class Item implements Stage {

	public static Item weapon;
	public static Item armor;
	public static Item ring;

	@Override
	public boolean update() {
		return false;
	}

	@Override
	public void init() {

	}

	public int getPower() {
		return 0;
	}

}
