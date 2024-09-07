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

import Model.Device;
import Model.Product;
import Views.registerSuccessful;
import net.sf.json.JSONObject;

public class deviceModel {
	private File f =new File("C:\\Users\\ZXYan\\eclipse-workspace\\ICF\\Device.txt");
	private static deviceModel deviceModel = new deviceModel();
	private deviceModel() {
		}
		
	public void safeDevice(Device device) throws IOException, FileNotFoundException {
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
			writer.println(device);
			writer.close();
			new registerSuccessful();
}
		
	public List<Device> loadDevice() throws IOException, FileNotFoundException {
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
			List<Device> entity = new ArrayList();
			
			for (String string : b) {
				if(string.startsWith("{\"dataType\":\"Device\",")) {
				JSONObject temp = JSONObject.fromObject(string);
				Device temp2 = (Device)JSONObject.toBean(temp, Device.class);
				entity.add(temp2);
				}
             }
		return entity;
	}
	

	public static deviceModel getdeviceModel() {
		return deviceModel;
	}
}
