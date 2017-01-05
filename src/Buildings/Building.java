package Buildings;

public abstract class Building {
	private int upgradeValue;

	protected Building(int upgradeValue) {
		this.upgradeValue = upgradeValue;
	}

	public int getUpgradeValue(){
		return this.upgradeValue;
	}
}
