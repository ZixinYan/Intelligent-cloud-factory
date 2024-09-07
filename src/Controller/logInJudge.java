package Controller;
import java.io.*;
import java.util.*;

import Model.Factory;
import Model.User;
import Views.logIn;
import Views.menu;
import Views.personalFactory;

public class logInJudge extends User{
	private String factoryName;
	private static logInJudge l = new logInJudge();
	private logInJudge() {
		
	}
	public void logInJudge(String name,String password) throws IOException, FileNotFoundException {
		List<User> userdata = new ArrayList<>();
		userdata = userModel.getUserModel().loadUser();
		boolean judge = false;
		for(User i : userdata) {
			if(i.getUserName().equals(name)) {
				judge = true;
				if(i.getPassword().equals(password)) {
					if(i.getType().equals("系统管理员")) {
					    new menu();
					}else if(i.getType().equals("云工厂")){
						new personalFactory();
						
					}				
				}else {
					new logIn(true);
					
				}
			}
		}
		
		if(!judge) {
			new logIn(true);
		}
	}
	public void getName(String name) throws FileNotFoundException, IOException {
		List<Factory> factorys = userModel.getUserModel().loadFactory();
		for(Factory f:factorys) {
			if(f.getUserName().equals(name)){
		    logInJudge.getL().setFactoryName(name);
			}
		}
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public static logInJudge getL() {
		return l;
	}
}
