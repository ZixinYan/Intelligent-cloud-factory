package Controller;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//import java.util.StringTokenizer;

//import javax.swing.JFrame;

//import Model.Factory;
//import Model.User;
//import Views.registerError;
//import Views.registerSuccessful;
/*
public class safeData<T> {
	private File f = new File("C:\\Users\\ZXYan\\eclipse-workspace\\ICF\\User.txt");
	public safeData() {
		
	}
	public safeData(T data) throws IOException {
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
			writer.println(data);
			writer.close();
		}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void JudgeUsers(JFrame frame,String username,User user) throws IOException {
		    ArrayList<String> name = new ArrayList<>();
			InputStreamReader isr = new InputStreamReader(new FileInputStream(f),"UTF-8");
			try (BufferedReader bufferedReader = new BufferedReader(isr)) {
				boolean judge = true;
				String line = bufferedReader.readLine();
				while(line!=null) {
				StringTokenizer i1 = new StringTokenizer(line,"_");
				if(i1.hasMoreTokens()) {
					i1.nextToken();
					name.add(i1.nextToken());
				}
				line =  bufferedReader.readLine();
				}

				
				
				for(int n = 0; n <name.size();n++) {
					if((name.get(n).equals(username))){
						judge =false;
					}
				}
				
				if(judge) {
					new safeData(user);
					frame.dispose();
		        	new registerSuccessful();
				}else {
			    	frame.dispose();
					new registerError();
				}
			}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void JudgeFactory(JFrame frame,Factory factory) throws IOException {
		    new safeData(factory);
			frame.dispose();
			}

}
*/
