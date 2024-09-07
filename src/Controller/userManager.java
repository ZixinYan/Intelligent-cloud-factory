package Controller;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
import Model.User;
import Views.registerError;
import Views.registerSuccessful;
import Views.userManagerSuccessful;

public class userManager {
	private File f =new File("C:\\Users\\ZXYan\\eclipse-workspace\\ICF\\User.txt");
	private static userManager userManager = new userManager();
	private List<User> userData = new ArrayList<>();
	private List<Factory> factoryData = new ArrayList<>();
	private Object[][] array;
	private User user = new User();
	private userManager() {
	}
	public void nameSearch(String name) {
        try {
			userData=userModel.getUserModel().loadUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        List<Object[]> userProps = new ArrayList<>();
        int num = 1;
        for (User i : userData) {
            Object[] props = new Object[]{num, i.getUserName(), i.getRealName(), i.getEmail(), i.getType()};
            if(name.equals(i.getUserName())) {
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
	public Object[][] getUserManagerData(String name) throws FileNotFoundException, IOException {
	nameSearch(name);
    return array;
}

	public void readDataFromJTable(JTable table) throws FileNotFoundException, IOException {
	        TableModel model = table.getModel();
	        List<User> UserData = userModel.getUserModel().loadUser();
	        List<User> users = new ArrayList<>();
	        for (int rowIndex = 0; rowIndex <model.getRowCount(); rowIndex++) {
	            user.setUserName((String)model.getValueAt(rowIndex, 2));
	            user.setRealName((String)model.getValueAt(rowIndex, 3));
	            user.setEmail((String) model.getValueAt(rowIndex, 4));
	            users.add(user);
	        }
	        for(User i : users) {
	        	for(User n : UserData) {
	        	if(i.getRealName().equals(n.getRealName())){
	        		n.setDataType(n.getDataType());
	        		n.setPassword(n.getPassword());
	        		n.setRealName(n.getRealName());
	        		n.setType(n.getType());
	        		n.setUserName(i.getUserName());
	        		n.setEmail(i.getEmail());
	        	}
	        }
	      }
	      safeData(UserData);
	   }
	public void safeData(List<User> user) throws IOException, FileNotFoundException {
		PrintWriter writer = new PrintWriter(f, "UTF-8");
		for(User i : user) {
			writer.print(i);
		}
		for(Factory i :factoryData) {
			i.setDataType(i.getDataType());
			i.setFcBriefIntroduction(i.getFcBriefIntroduction());
			i.setFcName(i.getFcName());
			i.setRealName(i.getRealName());
			writer.print(i);
		}
		writer.close();
		new userManagerSuccessful();
		}
	
	public void deleteData(JTable table,int i) throws FileNotFoundException, IOException{
		userData = userModel.getUserModel().loadUser();
		TableModel model = table.getModel();
		String userName = (String)model.getValueAt(i,2);
		synchronized(userData) {
			  Iterator<User> it = userData.iterator();
			  while (it.hasNext()) {
			    User s = it.next();
			    if (s.getUserName().equals(userName)) {
			      it.remove();
			    }
			  }
		}
		factoryData = userModel.getUserModel().loadFactory();
		synchronized(factoryData) {
			  Iterator<Factory> it1 = factoryData.iterator();
			  while (it1.hasNext()) {
				  Factory h = it1.next();
			    if (h.getUserName().equals(userName)) {
			      it1.remove();
			    }
			  }
		}
			safeData(userData);	
	}
	public static userManager getUserManager() {
		return userManager;
	}
}
