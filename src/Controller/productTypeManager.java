package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Model.ProductType;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.commons.lang.ArrayUtils;

import Model.Model;
import Model.Product;
import Views.productTypeManage;

public class productTypeManager implements Model{
	 private File f =new File("C:\\Users\\ZXYan\\eclipse-workspace\\ICF\\Product.txt");
	 private static productTypeManager u = new productTypeManager();
	 private List<ProductType> productTypeData;
	 private List<Product> productData = new ArrayList<>();
	 private Object[][] array;
	 private productTypeManager() {
		 
	 }
	 public void setData() throws FileNotFoundException, IOException {
		    productData = productModel.getProductModel().loadProduct();
		    productTypeData = new ArrayList<>();
		    Iterator<Product> it = productData.iterator();
		    List<Object[]> productProps = new ArrayList<>();
		    int num = 1;
		    while (it.hasNext()) {
		        ProductType t = new ProductType();
		        Product h = it.next();
		        boolean isNew = true; // 添加isNew标记

		        for (ProductType i : productTypeData) {
		            if (h.getProductType().equals(i.getProductType())) {
		                isNew = false; // 如果存在相同的ProductType对象，将isNew标记设为false
		                break;
		            }
		        }

		        if (isNew) {
		            t.setProductId("" + num);
		            t.setProductType(h.getProductType());
		            productTypeData.add(t);
		            num++;

		            Object[] props = new Object[]{t.getProductId(),t.getProductType()};
		            productProps.add(props);
		        }
		    }
		    Object[][] propsArr = productProps.toArray(new Object[0][]);
		    this.array = propsArr;
		}



	 public void nameSearch(String name) {
        List<Object[]> productProps = new ArrayList<>();
        for (ProductType i : productTypeData) {
            Object[] props = new Object[]{i.getProductId(), i.getProductType()};
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
        
	 	
	 	public void safeData(List<Product> product) throws IOException, FileNotFoundException {
			PrintWriter writer = new PrintWriter(f, "UTF-8");
			for(Product i : product) {
				writer.print(i);
			}
			writer.close();
			new productTypeManage();
			}
	 	public void safeTypeData(List<ProductType> product) throws IOException, FileNotFoundException {
			productData = productModel.getProductModel().loadProduct();
	 		PrintWriter writer = new PrintWriter(f, "UTF-8");
			for(Product i:productData) {
				writer.print(i);
			}
			for(ProductType i : product) {
				writer.print(i);
			}
			writer.close();
			new productTypeManage();
		}
	 	public void safeNew(JTable table) throws FileNotFoundException, IOException {
	 		TableModel model = table.getModel();
	        List<ProductType> products = new ArrayList<>();
	        for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
	        	ProductType p = new ProductType();
	            p.setProductId(""+(rowIndex+1));
	            p.setProductType((String)model.getValueAt(rowIndex, 1));
	            products.add(p);
	        }
	      safeTypeData(products);
	   }
	 	public void readDataFromJTable(JTable table) throws FileNotFoundException, IOException {
		    TableModel model = table.getModel();
		    productData = productModel.getProductModel().loadProduct();
	        List<Product> products = new ArrayList<>();
	        List<String> newType = new ArrayList<>();
	        List<String> oldType = new ArrayList<>();
	        for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
	        	newType.add((String)model.getValueAt(rowIndex,1));
	        }
	        for(ProductType i:productTypeData) {
	        	oldType.add(i.getProductType());
	        }
	        for (int i = 0; i < newType.size(); i++) {
	            for (Product p : productData) {
	               if (p.getProductType().equals(oldType.get(i))) {
	                    p.setProductType(newType.get(i));
	                    products.add(p);
	               }
	            }
	        }
	      safeData(products);
	   }

	 	public void deleteData(JTable table, int row) throws FileNotFoundException, IOException {
	 	    DefaultTableModel model =  (DefaultTableModel) table.getModel();
	 	    String type = (String) model.getValueAt(row, 1);
	 	    List<Product> productData = productModel.getProductModel().loadProduct();
	 	    synchronized (productData) {
	 	        for (Iterator<Product> iterator = productData.iterator(); iterator.hasNext();) {
	 	            Product p = iterator.next();
	 	            if (p.getProductType().equals(type)) {
	 	                iterator.remove();
	 	            }
	 	        }
	 	    }
				safeData(productData);
		}
	 	

	 	
public Object[][] getProductManager() throws FileNotFoundException, IOException {
     setData();
     return array;
 }
	public static productTypeManager getU() {
		return u;
	}
	 
}
