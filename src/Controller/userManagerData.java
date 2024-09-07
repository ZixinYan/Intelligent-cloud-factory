package Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.JTable;

import org.apache.commons.lang.ArrayUtils;

import Model.Model;
import Model.User;

import java.util.ArrayList;

public class userManagerData extends User{
    private int Id;
    private static userManagerData u = new userManagerData();
    private String userName;
    private String realName;
    private String email;
    private String type;        
    private List<User> userData;
	private Object[][] array;

    private userManagerData() {}

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        this.Id = id;
    }

    public void setData() throws FileNotFoundException, IOException {
            userData=userModel.getUserModel().loadUser();
            List<Object[]> userProps = new ArrayList<>();
            int num = 1;
            for (User i : userData) {
                Object[] props = new Object[]{num, i.getUserName(), i.getRealName(), i.getEmail(), i.getType()};
                userProps.add(props);
                num++;
            }
            Object[][] propsArr = userProps.toArray(new Object[0][]);
            for (int i = 0; i < propsArr.length; i++) {
                propsArr[i] = ArrayUtils.add(propsArr[i], 0, " ");
            }
            this.array = propsArr;
    }
   
        		
     public Object[][] getUserManagerData() throws FileNotFoundException, IOException {
        setData();
        return array;
    }

    public static userManagerData getU() {
        return u;
    }
    
    public String toString() {
        return "{"+"  "+","+Id+","+userName+","+realName+","+
                email+","+type+"}";
    }

}
