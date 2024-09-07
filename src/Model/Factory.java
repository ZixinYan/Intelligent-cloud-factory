package Model;

public class Factory{
	private String dataType = "Factory";
	private String fcName;
	private String fcBriefIntroduction;
	private String realName;
	private String userName;
	private String email;
	private String type;
	public Factory() {
	}
	public String getFcName() {
		return fcName;
	}
	public void setFcName(String fcName) {
		this.fcName = fcName;
	}
	public String getFcBriefIntroduction() {
		return fcBriefIntroduction;
	}
	public void setFcBriefIntroduction(String fcBriefIntroduction) {
		this.fcBriefIntroduction = fcBriefIntroduction;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	

	public String toString() {
		return "{\n"+"\"dataType\""+":"+"\""+getDataType()+"\","+
				"\n \"fcName\""+":"+"\""+fcName+"\","+
				"\n \"fcBriefIntroduction\""+":"+"\""+fcBriefIntroduction+"\","+
				"\n \"realName\"" +":" +"\""+realName+"\","+
				"\n \"userName\"" +":"+"\"" +userName+"\","+
				"\n \"email\"" +":" +"\""+email+"\","+
				"\n \"type\"" +":" +"\""+type+"\""+
				"\n} /";
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
}
