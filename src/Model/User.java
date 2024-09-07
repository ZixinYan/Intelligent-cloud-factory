package Model;


public class User {
	private String dataType = "User";
	private String userName;
	private String password;
	private String realName;
	private String email;
    private String type;
    public User() {
    	
    }

	public  String getDataType() {
		return dataType;
	}


	public  void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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
	
	@Override
	public String toString() {
		return "{\n"+ "\"dataType\""+":"+"\""+dataType+"\","+
				"\n \"userName\""+":"+"\""+userName+"\","+
				"\n \"password\""+":"+"\""+password+"\","+
				"\n \"realName\""+":"+"\""+realName+"\","+
				"\n \"email\""+":"+"\""+email+"\","+
				"\n \"type\""+":"+"\""+type+"\""
				+"\n} /";
	}

}
