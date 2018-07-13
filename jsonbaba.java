package demo;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;



import org.json.JSONException;
import org.json.JSONObject;



public class jsonbaba {

	
	private static final String FILENAME = "C:\\\\Users\\\\Dell\\\\eclipse-workspace\\\\demo\\\\empcode.txt";
	
	public static void main(String[] args)
	{
		
		BufferedReader br = null;
		FileReader fr = null;

		try {

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;
			long max=0;
			int min=100;
			ArrayList<String> list=new ArrayList<>(); 

			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				String output  = getUrlContents("https://afternoon-oasis-93157.herokuapp.com/Employee/Search/5eb63bbbe01eeed093cb22bb8f5acdc3/"+sCurrentLine);
				//System.out.println(output);
				//System.out.println(output);
				
				try {
					JSONObject obj=new JSONObject(output);
					String status=obj.get("status")+"";
					if(status.equals("true"))
					{
					JSONObject j=new JSONObject(obj.get("employee")+"");
					String name=j.get("empname")+"";
					String sal=j.get("empsalary")+"";
					String age1=j.get("empage")+"";
					int age2=Integer.parseInt(age1);
					long cur_sal=Long.parseLong(sal);
					System.out.println(cur_sal);
					if(cur_sal>max)
					{
						max=cur_sal;
						list.clear();
						list.add(name);
					}
					else if(cur_sal==max)
					{
						list.add(name);
					}
					if(age2<min)
					{
						min=age2;
						list.clear();
						list.add(name);
					}
					else if(age2==min)
					{
						list.add(name);
					}
					
					
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			
			System.out.println("max"+max);
			System.out.println("minimum"+min);
			
			for(int i=0;i<list.size();i++)
			{
				System.out.println(list.get(i));
			}
			
			
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		
		 //String output  = getUrlContents("https://afternoon-oasis-93157.herokuapp.com/Employee/Search/5eb63bbbe01eeed093cb22bb8f5acdc3/263");
		 //System.out.println(output);

		 
		 
	}
	
	private static String getUrlContents(String theUrl)
	  {
	    StringBuilder content = new StringBuilder();

	    // many of these calls can throw exceptions, so i've just
	    // wrapped them all in one try/catch statement.
	    try
	    {
	      // create a url object
	      URL url = new URL(theUrl);

	      // create a urlconnection object
	      URLConnection urlConnection = url.openConnection();

	      // wrap the urlconnection in a bufferedreader
	      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

	      String line;

	      // read from the urlconnection via the bufferedreader
	      while ((line = bufferedReader.readLine()) != null)
	      {
	        content.append(line + "\n");
	      }
	      bufferedReader.close();
	    }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	    }
	    return content.toString();
	  }
	
}

