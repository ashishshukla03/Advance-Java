package com.AdvanceJAVA.MavenProject;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import com.AdvanceJAVA.MavenProject.DataSearch.EmptyFileException;
public class MyThread extends App{
	App app= new App();
	Timer timer= new Timer();
	TimerTask task= new TimerTask() {
	
	public void run()
	{
		File file=new File("src/main/java/com/AdvanceJava/csvFile");
		String contents[]=file.list();
		if(contents.length>3)
		{
			for(int i=0;i<contents.length;i++)
			{
				if(contents[i].equals("Adidas.csv") && contents[i].equals("Puma.csv") && contents[i].equals("Nike.csv") )
				{
					String file1=contents[i];
					System.out.println();
					System.out.println("New File :"+file1);
					DataSearch ds = new DataSearch();
					try 
					{
						ds.searchData(file1, colour, size, gender);
					} 
					catch (EmptyFileException e) 
					{
						e.printStackTrace();
					}
				}
			 }
		 }
	  }
	};
}