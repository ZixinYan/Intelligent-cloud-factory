package Controller;

import Model.Product;
import Model.User;
import Views.factoryManageSuccessful;
import Views.productInformationManagerSuccessful;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.commons.lang.ArrayUtils;

import Model.Factory;
import Model.Model;

public class productManager implements Model{
	 private File f =new File("C:\\Users\\ZXYan\\eclipse-workspace\\ICF\\Product.txt");
	 private static productManager u = new productManager();
	 private List<Product> productData = new ArrayList<>();
	 private Object[][] array;
	 private productManager() {
		 
	 }
	 public void setData() throws FileNotFoundException, IOException {
         productData=productModel.getProductModel().loadProduct();
         List<Object[]> productProps = new ArrayList<>();
         for (Product i : productData) {
             Object[] props = new Object[]{i.getProductId(), i.getProductCode(), i.getProductName(),
             		i.getProductType(), i.getProductStandard(),i.getProductbriefIntroduction()};
             productProps.add(props);
         }
         Object[][] propsArr = productProps.toArray(new Object[0][]);
         for (int i = 0; i < propsArr.length; i++) {
             propsArr[i] = ArrayUtils.add(propsArr[i], 0, " ");
         }
         this.array = propsArr;
 }
	 public void nameSearch(String name) {
         try {
 			productData=productModel.getProductModel().loadProduct();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
         List<Object[]> productProps = new ArrayList<>();
         for (Product i : productData) {
             Object[] props = new Object[]{i.getProductId(), i.getProductCode(), i.getProductName(),
             		i.getProductType(), i.getProductStandard(),i.getProductbriefIntroduction()};
             if(i.getProductType().equals(name)) {
                 productProps.add(props);
             }
         }
             
         
         Object[][] propsArr = productProps.toArray(new Object[0][]);
         for (int i = 0; i < propsArr.length; i++) {
             propsArr[i] = ArrayUtils.add(propsArr[i], 0, " ");
         }
         this.array = propsArr;
 	}
	 
	 	public Object[][] getProductData(String name) throws FileNotFoundException, IOException {
		 	 nameSearch(name);
		     return array;
		 }
	 
	 public void readDataFromJTable(JTable table) throws FileNotFoundException, IOException {
		    TableModel model = table.getModel();
	        List<Product> products = new ArrayList<>();
	        for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
	        	Product p = new Product();
	            p.setProductId(""+(rowIndex+1));
	            p.setProductCode((String)model.getValueAt(rowIndex, 2));
	            p.setProductName((String)model.getValueAt(rowIndex, 3));
	            p.setProductType((String)model.getValueAt(rowIndex, 4));
	            p.setProductStandard((String)model.getValueAt(rowIndex, 5));
	            p.setProductbriefIntroduction((String)model.getValueAt(rowIndex, 6));
	            products.add(p);
	        }
	      safeData(products);
	   }
	 
		public void safeData(List<Product> product) throws IOException, FileNotFoundException {
			productData = productModel.getProductModel().loadProduct();
			PrintWriter writer = new PrintWriter(f, "UTF-8");
			for(Product i : product) {
				writer.print(i);
			}
			writer.close();
			new productInformationManagerSuccessful();
			}
		

		public void deleteData(JTable table,int i) throws FileNotFoundException, IOException{
			List<Product> productData = productModel.getProductModel().loadProduct();
			TableModel model = table.getModel();
			String id = (String)model.getValueAt(i,1);
			synchronized(productData) {
				  Iterator<Product> it = productData.iterator();
				  while (it.hasNext()) {
					  Product s = it.next();
				    if (s.getProductId().equals(id)) {
				      it.remove();
				      
				    }
				  }
			}
				safeData(productData);	
			
		}
  public Object[][] getProductManager() throws FileNotFoundException, IOException {
     setData();
     return array;
 }
public static productManager getU() {
	return u;
}
}
