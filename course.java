package kean;

public class course {
	
	private String cName, cDays, cTime, credits, cCode;
	
	public course(String cName, String cDays, String cTime, String credits, String cCode) {
		
		this.cName=cName;
		this.cDays=cDays.replaceAll(" ", "");
		this.cTime=cTime.replaceAll(" ", "");
		this.credits=credits;
		this.cCode=cCode;
		
	}
	
	public String getName() {
		return cName;
	}

	public String getDays() {
		return cDays;
	}
	
	public String getTime() {
		return cTime;
	}
	
	public String getCredits() {
		return credits;
	}
	
	public String getCode() {
		return cCode;
	}

}
