package Model;

public class Device extends DeviceType{
	private String dataType = "Device";
	private String deviceName;
	private String deviceCode;
	private String deviceStandard;
	private String deviceState;
	private String deviceIntroduction;
	private String deviceRent;
	private String deviceFactory;
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceCode() {
		return deviceCode;
	}
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}
	public String getDeviceStandard() {
		return deviceStandard;
	}
	public void setDeviceStandard(String deviceStandard) {
		this.deviceStandard = deviceStandard;
	}
	public String getDeviceState() {
		return deviceState;
	}
	public void setDeviceState(String deviceState) {
		this.deviceState = deviceState;
	}
	public String getDeviceIntroduction() {
		return deviceIntroduction;
	}
	public void setDeviceIntroduction(String deviceIntroduction) {
		this.deviceIntroduction = deviceIntroduction;
	}
	public String getDeviceRent() {
		return deviceRent;
	}
	public void setDeviceRent(String deviceRent) {
		this.deviceRent = deviceRent;
	}
	public String getDeviceFactory() {
		return deviceFactory;
	}
	public void setDeviceFactory(String deviceFactory) {
		this.deviceFactory = deviceFactory;
	}
	
	public String toString() {
		return "{\n"+ "\"dataType\""+":"+"\""+dataType+"\","+
				"\n"+ "\"deviceId\""+":"+"\""+getDeviceId()+"\","+
				"\n \"deviceName\""+":"+"\""+deviceName+"\","+
				"\n \"deviceCode\""+":"+"\""+deviceCode+"\","+
				"\n \"deviceType\""+":"+"\""+getDeviceType()+"\","+
				"\n \"deviceStandard\""+":"+"\""+deviceStandard+"\","+
				"\n \"deviceState\""+":"+"\""+deviceState+"\","+
				"\n \"deviceIntroduction\""+":"+"\""+ deviceIntroduction+"\","+
				"\n \"deviceRent\""+":"+"\""+deviceRent+"\","+
				"\n \"deviceFactory\""+":"+"\""+ deviceFactory+"\""
				+"\n} /";
	}
}
