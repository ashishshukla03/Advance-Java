package com.AdvanceJAVA.MavenProject;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
public class DataSearch {
	ArrayList<CSVdetails> list = new ArrayList<CSVdetails>();
	ArrayList<String> arr;
	DataResult view = new DataResult();
	
	public void searchData(String file, String colour, String size, String gender) throws EmptyFileException {

		Scanner sc = null;
		try 
		{
			sc = new Scanner(new File(file));
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}		
		if(!sc.hasNextLine()) {
		    throw new EmptyFileException();
		}
		while (sc.hasNext())
		{
			String line = sc.nextLine().toUpperCase().toString();
			if (!line.isEmpty())
			{
				StringTokenizer token = new StringTokenizer(line, "|");
				arr = new ArrayList<>(line.length());
				while (token.hasMoreTokens())
				{
					arr.add(token.nextToken());
				}
				if (arr.get(2).equals(colour) && arr.get(4).equals(size) && arr.get(3).equals(gender)) {
					CSVdetails csv = new CSVdetails(arr.get(0), arr.get(1), arr.get(2), arr.get(3), arr.get(4),
							Float.parseFloat(arr.get(5)), Float.parseFloat(arr.get(6)), arr.get(7));
					list.add(csv);
				}
			}
		}
	}
	public void preferenceSort(int enterChoice) {
		if (enterChoice == 1) 
		{
			Collections.sort(list, new Comparator<CSVdetails>()
			{
				public int compare(CSVdetails o1, CSVdetails o2)
				{
					return ((int) (o1.getPrice()));
				}
			});
		} 
		else if (enterChoice == 2)
		{
			Collections.sort(list, new Comparator<CSVdetails>()
			{
				public int compare(CSVdetails o1,CSVdetails o2)
				{
					return ((int) (o1.getRating()));
				}
			});
		}
		else
		{
			System.out.println("Wrong Choice Entered....Try Again!!.");
			return;
		}
		view.viewTShirt(list);
	}
	@SuppressWarnings("serial")
	public class EmptyFileException extends Exception
	{
	    public EmptyFileException()
	    {
	    	System.out.println("File is Empty");
	    }

	}
	

}
