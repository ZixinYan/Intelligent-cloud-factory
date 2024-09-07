package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Model.Device;
import Model.Factory;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.apache.commons.lang.ArrayUtils;

import Model.Model;
import Model.Product;
import Views.deviceDeleteError;
import Views.deviceManageSuccessful;
import Views.devicePersonalDeleteError;
import Views.devicePersonalManageSuccessful;
import Views.productInformationManagerSuccessful;

public class devicePersonalManager implements Model{
	 private File f =new File("C:\\Users\\ZXYan\\eclipse-workspace\\ICF\\Device.txt");
	 private static devicePersonalManager u = new devicePersonalManager();
	 private List<Device> deviceData = new ArrayList<>();
	 private Object[][] array;
	 private Object[][] rentArray;
	 private devicePersonalManager() {
		 
	 }

	@Override
	public void nameSearch(String name) {
		// TODO Auto-generated method stub
		try {
 			deviceData=deviceModel.getdeviceModel().loadDevice();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
         List<Object[]> deviceProps = new ArrayList<>();
         for (Device i : deviceData) {
             Object[] props = new Object[]{i.getDeviceId(), i.getDeviceCode(), i.getDeviceName(),
             		i.getDeviceType(), i.getDeviceStandard(),i.getDeviceState(),
             		i.getDeviceIntroduction(),i.getDeviceRent(),i.getDeviceFactory()};
             if(i.getDeviceType().equals(name)) {
                 deviceProps.add(props);
             }
         }
             Object[][] propsArr = deviceProps.toArray(new Object[0][]);
             for (int i = 0; i < propsArr.length; i++) {
                 propsArr[i] = ArrayUtils.add(propsArr[i], 0, " ");
             }
             this.array = propsArr;
         }

	@Override
	public void deleteData(JTable table, int i) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		List<Device> deviceData = deviceModel.getdeviceModel().loadDevice();
		TableModel model = table.getModel();
		String code = (String)model.getValueAt(i,3);
		synchronized(deviceData) {
			  Iterator<Device> it = deviceData.iterator();
			  while (it.hasNext()) {
				  Device s = it.next();
			    if (s.getDeviceCode().equals(code)&&s.getDeviceRent().equals("工厂设备")) {
			    	it.remove();
			    }else if(s.getDeviceCode().equals(code)&&s.getDeviceRent().equals("已被租用")){
			    	s.setDeviceRent("未被租用");
			    	s.setDeviceFactory("");
			    }else {
			    	new devicePersonalDeleteError();
			    }
			  }
		}
		safeData(deviceData);	
		
	}

	@Override
	public void readDataFromJTable(JTable table) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		    TableModel model = table.getModel();
	        List<Device> devices = new ArrayList<>();
	        List<Device> oldDeviceData = new ArrayList<>();
	        oldDeviceData = deviceModel.getdeviceModel().loadDevice();
	        for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
	        	boolean judge = true;
	        	Device p = new Device();
	            p.setDeviceId(""+(oldDeviceData.size()+1));
	            p.setDeviceName((String)model.getValueAt(rowIndex, 2));
	            p.setDeviceCode((String)model.getValueAt(rowIndex, 3));
	            p.setDeviceType((String)model.getValueAt(rowIndex, 4));
	            p.setDeviceStandard((String)model.getValueAt(rowIndex, 5));
	            p.setDeviceState((String)model.getValueAt(rowIndex,6));
	            p.setDeviceIntroduction((String)model.getValueAt(rowIndex,7));
	            p.setDeviceRent((String)model.getValueAt(rowIndex, 8));
	            p.setDeviceFactory((String)model.getValueAt(rowIndex, 9));
	            for(Device i :oldDeviceData) {
	            	if(i.getDeviceCode().equals(p.getDeviceCode())) {
	            		judge = false;
	            	}
	            }
	            if(judge) {
	               devices.add(p);
	            }
	        }
	      for(Device i:oldDeviceData) {
	    	  devices.add(i);
	      }
	      safeData(devices);
	   }
	 
		public void safeData(List<Device> device) throws IOException, FileNotFoundException {
			deviceData = deviceModel.getdeviceModel().loadDevice();
			PrintWriter writer = new PrintWriter(f, "UTF-8");
			for(Device i : device) {
				writer.print(i);
			}
			writer.close();
			new devicePersonalManageSuccessful();
		}

	@Override
	public void setData() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		deviceData=deviceModel.getdeviceModel().loadDevice();
        List<Object[]> deviceProps = new ArrayList<>();
        for (Device i : deviceData) {
            Object[] props = new Object[]{i.getDeviceId(),  i.getDeviceName(),i.getDeviceCode(),
            		i.getDeviceType(), i.getDeviceStandard(),i.getDeviceState(),
            		i.getDeviceIntroduction(),i.getDeviceRent(),i.getDeviceFactory()};
            if(i.getDeviceFactory().equals(logInJudge.getL().getFactoryName())) {
                deviceProps.add(props);
        }
      }
        Object[][] propsArr = deviceProps.toArray(new Object[0][]);
        for (int i = 0; i < propsArr.length; i++) {
            propsArr[i] = ArrayUtils.add(propsArr[i], 0, " ");
        }
        this.array = propsArr;
	}
	public Object[][] getDeviceManager() throws FileNotFoundException, IOException {
	     setData();
	     return array;
	 }
	
	
	public void changeType(JTable table,int i) throws FileNotFoundException, IOException {
		    TableModel model = table.getModel();
		    deviceData = deviceModel.getdeviceModel().loadDevice();
		    List<Device> deviceData2 = new ArrayList<>();
	        String code = (String)model.getValueAt(i, 3);
	        for(Device n : deviceData) {
	        	if(n.getDeviceCode().equals(code)){
	        		if(n.getDeviceState().equals("开机")) {
	        			n.setDeviceState("关机");
	        	}else {
	        		n.setDeviceState("开机");
	        	}
	        		deviceData2.add(n);
	        }else {
	        	deviceData2.add(n);
	        }
	      }
	      safeData(deviceData2);
	}
	
	public void rentDevice(JTable table,int row) throws FileNotFoundException, IOException {
		List<Device> deviceData = deviceModel.getdeviceModel().loadDevice();
		TableModel model = table.getModel();
		String code = (String)model.getValueAt(row,3);
		synchronized(deviceData) {
			  Iterator<Device> it = deviceData.iterator();
			  while (it.hasNext()) {
				  Device s = it.next();
			    if (s.getDeviceCode().equals(code)) {
			      s.setDeviceFactory(logInJudge.getL().getFactoryName());
			      s.setDeviceRent("已被租用");
			    }else{
			    	new devicePersonalDeleteError();
			    }
			  }
		}
		safeData(deviceData);
	}
	public void setRentData() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		deviceData=deviceModel.getdeviceModel().loadDevice();
        List<Object[]> deviceProps = new ArrayList<>();
        for (Device i : deviceData) {
            Object[] props = new Object[]{i.getDeviceId(),  i.getDeviceName(),i.getDeviceCode(),
            		i.getDeviceType(), i.getDeviceStandard(),i.getDeviceState(),
            		i.getDeviceIntroduction(),i.getDeviceRent(),i.getDeviceFactory()};
            if(i.getDeviceRent().equals("未被租用")) {
                deviceProps.add(props);
            }
        }
          Object[][] propsArr = deviceProps.toArray(new Object[0][]);
          for (int i = 0; i < propsArr.length; i++) {
              propsArr[i] = ArrayUtils.add(propsArr[i], 0, " ");
          }
          this.rentArray = propsArr;
  	}
	public Object[][] getDeviceManager(int p) throws FileNotFoundException, IOException{
		setRentData();
		return rentArray;
	}
	public Object[][] getDeviceData(String name) throws FileNotFoundException, IOException {
	 	 nameSearch(name);
	     return array;
	 }
	public static devicePersonalManager getU() {
		return u;
	}
}
