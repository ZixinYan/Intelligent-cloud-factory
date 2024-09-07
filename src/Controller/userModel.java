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
import Model.User;
import Views.registerError;
import Views.registerSuccessful;
import net.sf.json.JSONObject;
public class userModel{
	private static userModel usermodel = new userModel();
	private File f =new File("C:\\Users\\ZXYan\\eclipse-workspace\\ICF\\User.txt");
	private userModel() {
		}
		
	public void safeUser(User user) throws IOException, FileNotFoundException {
		    List<User> userData = new ArrayList<>();
			ArrayList<String> Line = new ArrayList<>();
			InputStreamReader isr = new InputStreamReader(new FileInputStream(f),"UTF-8");
			BufferedReader bufferedReader = new BufferedReader(isr);
			String line = bufferedReader.readLine();
			while(line!=null) {
				Line.add(line);
				line = bufferedReader.readLine();
				}
			boolean judge = true;
			bufferedReader.close();
			userData = loadUser();
			PrintWriter writer = new PrintWriter(f, "UTF-8");
			for(User i : userData) {
				if(user.getRealName().equals(i.getRealName()) || user.getUserName().equals(i.getUserName())){
			    judge = false;
				}
			}
		if(judge) {
		    for(String l : Line) {
			writer.println(l);
		    }
			writer.println(user);
			writer.close();
			new registerSuccessful();
		}else{
		new registerError();
		}
}
	public void safeFactory(Factory factory) throws IOException{
		List<Factory> factoryData = new ArrayList<>();
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
		factoryData = loadFactory();
		boolean judge = true;
		for(Factory i : factoryData) {
			if(factory.getRealName().equals("\""+i.getRealName()+"\",") || 
					factory.getRealName().equals("\""+i.getRealName()+"\",")){
		    judge= false;
			}
		}
		if(judge) {
		    for(String l : Line) {
			writer.println(l);
		    }
			writer.println(factory);
			writer.close();
		}
	}
		
	public List<User> loadUser() throws IOException, FileNotFoundException {
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
			List<User> entity = new ArrayList();
			
			for (String string : b) {
				if(string.startsWith("{\"dataType\":\"User\",")) {
				JSONObject temp = JSONObject.fromObject(string);
				User temp2 = (User)JSONObject.toBean(temp, User.class);
				entity.add(temp2);
				}
             }
		return entity;
	}
	
	public List<Factory> loadFactory() throws IOException, FileNotFoundException {
		String Line = "";
		InputStreamReader isr = new InputStreamReader(new FileInputStream(f),"UTF-8");
		try (BufferedReader bufferedReader = new BufferedReader(isr)) {
			String line = bufferedReader.readLine();
			while(line != null) {
				Line = Line + line;
				line =  bufferedReader.readLine();
			}
		}
			String b[] = Line.split("/");
			List<Factory> entity = new ArrayList();
			for (String string : b) {
				if(string.startsWith("{\"dataType\":\"Factory\",")) {
				JSONObject temp = JSONObject.fromObject(string);
				Factory temp2 = (Factory) JSONObject.toBean(temp, Factory.class);
				entity.add(temp2);
				}
             }
		return entity;
	}
	
	public static userModel getUserModel() {
		return usermodel;
	}
}
