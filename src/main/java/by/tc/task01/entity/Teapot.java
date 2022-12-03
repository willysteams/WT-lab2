package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;

/**
 * Represents the Speakers appliance
 */
public class Teapot extends Appliance{
	public int powerConsumption;
	public int Height;
	public int Width;
	public int cordLength;

	@Override
	public String toString() {
		return String.format("Teatop : POWER_CONSUMPTION=%d, Height=%d, Width=%s, CORD_LENGTH=%d",
				powerConsumption, Height, Width, cordLength);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean matches(String key, Object value) {
		return switch (SearchCriteria.Teapot.valueOf(key)){
			case POWER_CONSUMPTION -> powerConsumption == (Integer) value;
			case HEIGHT -> Height ==  (Integer) value;
			case WIDTH -> Width == (Integer) value;
			case CORD_LENGTH -> cordLength == (Integer) value;
		};
	}
}
