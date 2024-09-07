package Model;

public class ProductType {
	private String dataType = "ProductType";
	private String productId;
	private String productType;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}


	public String toString() {
		return "{\n"+ "\"dataType\""+":"+"\""+dataType+"\","+
	            "\n"+ "\"productId\""+":"+"\""+productId+"\","+
				"\n \"productType\""+":"+"\""+productType+"\","+
	            "\n} /";
	}
}
