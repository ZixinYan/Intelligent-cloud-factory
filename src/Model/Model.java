package Model;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JTable;

public interface Model {
	//按照某项特征查找
	void nameSearch(String name);
	//删除数据
	void  deleteData(JTable table,int i) throws FileNotFoundException, IOException;
	//表格中修改数据后更改数据
	void readDataFromJTable(JTable table) throws FileNotFoundException, IOException;
	//初始化表格数据
	void setData() throws FileNotFoundException, IOException;

}
