package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Model.Factory;
import Model.Product;
import Model.User;
import Views.factoryManageSuccessful;
import Views.registerSuccessful;
import net.sf.json.JSONObject;

public class productModel {
	private File f =new File("C:\\Users\\ZXYan\\eclipse-workspace\\ICF\\Product.txt");
	private static productModel productModel = new productModel();
	private productModel() {
		}
		
	public void safeProduct(Product product) throws IOException, FileNotFoundException {
			ArrayList<String> Line = new ArrayList<>();
			InputStreamReader isr = new InputStreamReader(new FileInputStream(f),"UTF-8");
			BufferedReader bufferedReader = new BufferedReader(isr);
			String line = bufferedReader.readLine();
			while(line!=null) {
				Line.add(line);
				line = bufferedReader.readLine();
				}
			bufferedReader.close();
			PrintWriter writer = new PrintWriter(f, "UTF-8");
            for(String l : Line) {
			writer.println(l);
		    }
			writer.println(product);
			writer.close();
			new registerSuccessful();
}
		
	public List<Product> loadProduct() throws IOException, FileNotFoundException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream(f),"UTF-8");
		String Line = "";
		try (BufferedReader bufferedReader = new BufferedReader(isr)) {
			String line = bufferedReader.readLine();
			while(line != null) {
				Line =  Line + line;
				line =  bufferedReader.readLine();
			}
		}
			String b[] = Line.split("/");
			List<Product> entity = new ArrayList();
			
			for (String string : b) {
				if(string.startsWith("{\"dataType\":\"Product\",")) {
				JSONObject temp = JSONObject.fromObject(string);
				Product temp2 = (Product)JSONObject.toBean(temp, Product.class);
				entity.add(temp2);
				}
             }
		return entity;
	}
	

	public static productModel getProductModel() {
		return productModel;
	}
}

