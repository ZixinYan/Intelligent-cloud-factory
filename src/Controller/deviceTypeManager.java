package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Model.Device;
import Model.DeviceType;
import Model.Model;
import Model.Product;
import Model.ProductType;
import Views.deviceTypeManage;
import Views.productTypeManage;

public class deviceTypeManager implements Model{
	 private File f =new File("C:\\Users\\ZXYan\\eclipse-workspace\\ICF\\Device.txt");
	 private static deviceTypeManager u = new deviceTypeManager();
	 private List<DeviceType> deviceTypeData;
	 private List<Device> deviceData = new ArrayList<>();
	 private Object[][] array;
	 private deviceTypeManager() {
		 
	 }
	@Override
	public void nameSearch(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteData(JTable table, int row) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		DefaultTableModel model =  (DefaultTableModel) table.getModel();
 	    String type = (String) model.getValueAt(row, 1);
 	    List<Device> deviceData = deviceModel.getdeviceModel().loadDevice();
 	    synchronized (deviceData) {
 	        for (Iterator<Device> iterator = deviceData.iterator(); 
 	        	iterator.hasNext();) {
 	            Device p = iterator.next();
 	            if (p.getDeviceType().equals(type)) {
 	                iterator.remove();
 	            }
 	        }
 	    }
			safeData(deviceData);	
		
	}

	@Override
	public void readDataFromJTable(JTable table) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		 TableModel model = table.getModel();
		    deviceData = deviceModel.getdeviceModel().loadDevice();
	        List<Device> device = new ArrayList<>();
	        List<String> newType = new ArrayList<>();
	        List<String> oldType = new ArrayList<>();
	        for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
	        	newType.add((String)model.getValueAt(rowIndex,1));
	        }
	        for(DeviceType i: deviceTypeData) {
	        	oldType.add(i.getDeviceType());
	        }
	        for (int i = 0; i < newType.size(); i++) {
	            for (Device p : deviceData) {
	               if (p.getDeviceType().equals(oldType.get(i))) {
	                    p.setDeviceType(newType.get(i));
	                    device.add(p);
	               }
	            }
	        }
	      safeData(device);
	   }

	
	
	@Override
	public void setData() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		deviceData = deviceModel.getdeviceModel().loadDevice();
	    deviceTypeData = new ArrayList<>();
	    Iterator<Device> it = deviceData.iterator();
	    List<Object[]> deviceProps = new ArrayList<>();
	    int num = 1;
	    while (it.hasNext()) {
	        DeviceType t = new DeviceType();
	        Device h = it.next();
	        boolean isNew = true; // 添加isNew标记

	        for (DeviceType i : deviceTypeData) {
	            if (h.getDeviceType().equals(i.getDeviceType())) {
	                isNew = false; // 如果存在相同的ProductType对象，将isNew标记设为false
	                break;
	            }
	        }

	        if (isNew) {
	            t.setDeviceId("" + num);
	            t.setDeviceType(h.getDeviceType());
	            deviceTypeData.add(t);
	            num++;

	            Object[] props = new Object[]{t.getDeviceId(),t.getDeviceType()};
	            deviceProps.add(props);
	        }
	    }
	    Object[][] propsArr = deviceProps.toArray(new Object[0][]);
	    this.array = propsArr;
	}
	
	public void safeTypeData(List<DeviceType> device) throws IOException, FileNotFoundException {
		deviceData = deviceModel.getdeviceModel().loadDevice();
 		PrintWriter writer = new PrintWriter(f, "UTF-8");
		for(Device i:deviceData) {
			writer.print(i);
		}
		for(DeviceType i : device) {
			writer.print(i);
		}
		writer.close();
		new deviceTypeManage();
	}
	public void safeNew(JTable table) throws FileNotFoundException, IOException {
 		TableModel model = table.getModel();
        List<DeviceType> devices = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
        	DeviceType p = new DeviceType();
            p.setDeviceId(""+(rowIndex+1));
            p.setDeviceType((String)model.getValueAt(rowIndex, 1));
            devices.add(p);
        }
      safeTypeData(devices);
   }
	public void safeData(List<Device> device) throws IOException, FileNotFoundException {
		PrintWriter writer = new PrintWriter(f, "UTF-8");
		for(Device i : device) {
			writer.print(i);
		}
		writer.close();
		new deviceTypeManage();
	}
 	public Object[][] getDeviceData(String name) throws FileNotFoundException, IOException {
	 	 nameSearch(name);
	     return array;
	 }
   
	public Object[][] getDeviceManager() throws FileNotFoundException, IOException {
	     setData();
	     return array;
	 }
	public static deviceTypeManager getU() {
		return u;
	}

}
