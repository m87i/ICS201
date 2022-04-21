
public class City implements Comparable<City> {
	private String cityName;
	private int temperature;
	
	City (String cityName , int temperature ){
		this.cityName = cityName;
		this.temperature = temperature;
		
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	
	
	@Override
	public int compareTo(City Ci) {
		if(getTemperature() > Ci.getTemperature())
			return 1;
		else if(getTemperature()<Ci.getTemperature())
			return -1;
		else
		return 0;
	}
	
//	public int compareTo(City Ci) {
//		return getCityName().compareToIgnoreCase(Ci.getCityName());
//		
//	}
	
	public String toString() {
		return "The City is: "+getCityName()+"\tand its temperature: "+ getTemperature();
	}


}
