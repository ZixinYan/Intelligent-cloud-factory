package Model;

public class Product extends ProductType{
	private String dataType = "Product";
	private String productName;
	private String productStandard;
	private String productCode;
	private String productbriefIntroduction;

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductStandard() {
		return productStandard;
	}
	public void setProductStandard(String productStandard) {
		this.productStandard = productStandard;
	}
	public String getProductbriefIntroduction() {
		return productbriefIntroduction;
	}
	public void setProductbriefIntroduction(String productbriefIntroduction) {
		this.productbriefIntroduction = productbriefIntroduction;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	@Override
	public String toString() {
		return "{\n"+ "\"dataType\""+":"+"\""+dataType+"\","+
				"\n"+ "\"productId\""+":"+"\""+getProductId()+"\","+
				"\n \"productCode\""+":"+"\""+productCode+"\","+
				"\n \"productName\""+":"+"\""+productName+"\","+
				"\n \"productType\""+":"+"\""+getProductType()+"\","+
				"\n \"productStandard\""+":"+"\""+productStandard+"\","+
				"\n \"productbriefIntroduction\""+":"+"\""+ productbriefIntroduction+"\""
				+"\n} /";
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

}
