package mela.model;

import java.util.ArrayList;

public class Location {

	private String name;
	private int locationIndex;    
	
    public Location(String name, int locationIndex) {
		super();
		this.name = name;
		this.locationIndex = locationIndex;
	}

	public String getName() {
		return name;
	}
    
    public int getIndex( ) {
    	return locationIndex;
    }

	@Override
	public int hashCode() {
		return locationIndex;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (locationIndex != other.locationIndex)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", locationIndex=" + locationIndex + "]";
	}
   
   
   //FIXME: this class might not be useful at all!
}
   
