
 class TimeException extends Exception{
	private String time;
	
	public TimeException(String t, int line) {
		super(line+"\t"+t+"\tTime Exception");
		time = line+"\t"+t+"\tTime Exception" ;
	}



	public String toString() {
		return time;
	}

}