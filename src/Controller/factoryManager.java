package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.apache.commons.lang.ArrayUtils;

import Model.Factory;
import Model.Model;
import Model.User;
import Views.factoryManageSuccessful;
import Views.userManagerSuccessful;

public class factoryManager extends Factory {
	    private int Id;
	    private File f =new File("C:\\Users\\ZXYan\\eclipse-workspace\\ICF\\User.txt");
	    private static factoryManager u = new factoryManager();       
		private Object[][] array;
		private Factory factory = new Factory();
		private List<User> userData;
		private List<Factory> factoryData;
	    private factoryManager() {}

	    public int getId() {
	        return Id;
	    }
	    public void setId(int id) {
	        this.Id = id;
	    }

	    public void setData() throws FileNotFoundException, IOException {
	            factoryData=userModel.getUserModel().loadFactory();
	            List<Object[]> userProps = new ArrayList<>();
	            int num = 1;
	            for (Factory i : factoryData) {
	                Object[] props = new Object[]{num, i.getFcName(), i.getFcBriefIntroduction(),
	                		i.getRealName(), i.getEmail(),i.getUserName(),i.getType()};
	                userProps.add(props);
	                num++;
	            }
	            Object[][] propsArr = userProps.toArray(new Object[0][]);
	            for (int i = 0; i < propsArr.length; i++) {
	                propsArr[i] = ArrayUtils.add(propsArr[i], 0, " ");
	            }
	            this.array = propsArr;
	    }
	   
	        		
	     public Object[][] getFactoryManager() throws FileNotFoundException, IOException {
	        setData();
	        return array;
	    }
	     
	     public void nameSearch(String name) {
	         try {
	 			factoryData=userModel.getUserModel().loadFactory();
	 		} catch (IOException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	         List<Object[]> userProps = new ArrayList<>();
	         int num = 1;
	         for (Factory i : factoryData) {
	        	 Object[] props = new Object[]{num, i.getFcName(), i.getFcBriefIntroduction(),
	                		i.getRealName(), i.getEmail(),i.getUserName(),i.getType()};
	        	 if(i.getFcName().equals(name)) {
	                userProps.add(props);
	        	 }
	                num++;
	             }
	             
	         
	         Object[][] propsArr = userProps.toArray(new Object[0][]);
	         for (int i = 0; i < propsArr.length; i++) {
	             propsArr[i] = ArrayUtils.add(propsArr[i], 0, " ");
	         }
	         this.array = propsArr;
	 	}
	 	public Object[][] getFactoryData(String name) throws FileNotFoundException, IOException {
	 	 nameSearch(name);
	     return array;
	 }
	 	
	 	public void safeData(List<Factory> factory) throws IOException, FileNotFoundException {
	 		userData = userModel.getUserModel().loadUser();
			factoryData = userModel.getUserModel().loadFactory();
			PrintWriter writer = new PrintWriter(f, "UTF-8");
			for(Factory i : factory) {
				writer.print(i);
			}
			for(User i :userData) {
				i.setDataType(i.getDataType());
				i.setEmail(i.getEmail());
				i.setPassword(i.getPassword());
				i.setRealName(i.getRealName());
				writer.print(i);
			}
			writer.close();
			new factoryManageSuccessful();
			}
	 	
	 	
		public void changeType(JTable table,int i) throws FileNotFoundException, IOException {
			    TableModel model = table.getModel();
			    factoryData = userModel.getUserModel().loadFactory();
			    List<Factory> factoryData2 = new ArrayList<>();
		        factory.setRealName((String)model.getValueAt(i, 4));
		        for(Factory n : factoryData) {
		        	if(n.getRealName().equals(factory.getRealName())){
		        		if(n.getType().equals("开启")) {
		        			n.setType("关闭");
		        	}else {
		        		n.setType("开启");
		        	}
		        		factoryData2.add(n);
		        }else {
		        	factoryData2.add(n);
		        }
		      }
		      safeData(factoryData2);
		}

		public static factoryManager getU() {
			return u;
		}
	    
	    
}
