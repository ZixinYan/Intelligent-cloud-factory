package Model;

public class DeviceType {
	private String dataType = "DeviceType";
	private String deviceId;
	private String deviceType;
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String toString() {
		return "{\n"+ "\"dataType\""+":"+"\""+dataType+"\","+
	            "\n"+ "\"deciveId\""+":"+"\""+deviceId+"\","+
				"\n \"deviceType\""+":"+"\""+deviceType+"\","+
	            "\n} /";
	}
}
