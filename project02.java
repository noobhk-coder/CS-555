import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
/*
 * Name:Siddharth Shah
 * Batch:CS 555 Batch A
 * Program details: A simple gedcom parser which specifies valid and invalid tags. File is read using BufferedReader, use of hashmaps to store the valid tags and their levels
 * output is directed to a text file using eclispse configuration found on 'http://xmodulo.com/how-to-save-console-output-to-file-in-eclipse.html'
 * Have handled the FAM and INDI tags exception
 */
public class project02 {
	public static void main(String args[]) throws IOException
	{
		File file=new File("C:\\Users\\12012\\Desktop\\CS 555\\proj02test.ged");
		//File file=new File("C:\\Users\\12012\\Desktop\\CS 555\\My-Family-28-Jan-2020-170.ged");
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		Map<String,Integer> valid=new HashMap<String,Integer>();
		valid.put("INDI",0);
		valid.put("NAME",1);
		valid.put("SEX",1);
		valid.put("BIRT",1);
		valid.put("DEAT",1);
		valid.put("FAMC",1);
		valid.put("FAMS",1);
		valid.put("FAM",0);
		valid.put("MARR",0);
		valid.put("HUSB",1);
		valid.put("WIFE",1);
		valid.put("CHIL",1);
		valid.put("DIV",1);
		valid.put("DATE",2);
		valid.put("HEAD",0);
		valid.put("TRLR",0);
		valid.put("NOTE",0);
		char y='Y';
		char n='N';
		  String st; 
		  String key="";
		  int value=0;
		  int count=0;
		  while ((st = br.readLine()) != null) 
		  {
			System.out.print("-->");
		    System.out.println(st); 
		    String spl[]=st.split(" ",3);
		    if(spl.length==3)
		    {
		    //System.out.println("length 3 encountered "+spl[2]);
		    value=Integer.parseInt(spl[0]);
		    key=spl[1];
		    if(spl[1].equals("FAM")|| spl[1].equals("INDI"))
		    {
		    	count=-1;
		    }
		    //System.out.println(spl[2]);
		    if(spl[2].equals("FAM") || spl[2].equals("INDI"))
		    {
		    	//System.out.println(spl[2]+"is here");
		    	String temp=key;
		    	key=spl[2];
		    	spl[2]=temp;
		    	spl[1]=key;
		    	//System.out.println("the new key is "+key);
		    }
	}
		    else
		    {
		    	value=Integer.parseInt(spl[0]);
			    key=spl[1];
		    }
		    if(valid.containsKey(key)&&valid.get(key)==value)
		    {
		    	if(spl.length==3)
		    	{
		    		if(count==-1)
		    		{
		    			System.out.print("<--");
				    	System.out.println(spl[0]+"|"+spl[1]+"|"+n+"|"+spl[2]);
		    		}
		    		else
		    		{
		    	System.out.print("<--");
		    	System.out.println(spl[0]+"|"+spl[1]+"|"+y+"|"+spl[2]);
		    	}
		    	}
		    	else if(spl.length==2)
		    	{
		    		System.out.print("<--");
			    	System.out.println(spl[0]+"|"+spl[1]+"|"+y+"|");
		    	}
		    }
		    else
		    {
		    	if(spl.length==3)
		    	{
		    	System.out.print("<--");
		    	System.out.println(spl[0]+"|"+spl[1]+"|"+n+"|"+spl[2]);
		    	}
		    	else if(spl.length==2)
		    	{
		    		System.out.print("<--");
			    	System.out.println(spl[0]+"|"+spl[1]+"|"+n+"|");
		    	}
		    }
		  } 
		  PrintStream out=new PrintStream(new FileOutputStream("output.txt"));
		  System.setOut(out);
	}
		
	}


