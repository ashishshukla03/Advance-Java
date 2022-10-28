package com.AdvanceJAVA.MavenProject;
import java.util.Scanner;
import com.AdvanceJAVA.MavenProject.DataSearch.EmptyFileException;
public class App 
{
	static String colour;
	static String size;
    static String gender;
    public static void main( String[] args ) throws EmptyFileException 
    {
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String colour, size, gender;
		int enterChoice;
		System.out.print("Enter Colour Of The T-Shirt : ");
		colour = sc.nextLine().toUpperCase();
		System.out.print("Enter Size Of T-Shirt : ");
		size = sc.nextLine().toUpperCase();
		System.out.print("Enter Gender:(M/F/U) : ");
		gender = sc.nextLine().toUpperCase();
		System.out.print("Enter Output Preference : 1. Sorted by Price \t 2. Sorted by Rating \nEnter Preference Choice (1/2) : ");
		enterChoice = sc.nextInt();
		
		DataSearch ds = new DataSearch();
		Thread t = new Thread();
        t.run();
        System.out.println("Thread name :"+t.getName());
        System.out.println("Thread Id :"+t.getId());
        System.out.println("Thread Priority :"+t.getPriority());
        System.out.println();

		ds.searchData("csvFile\\Puma.csv", colour, size, gender);
		ds.searchData("csvFile\\Nike.csv", colour, size, gender);
		ds.searchData("csvFile\\Adidas.csv", colour, size, gender);
		ds.preferenceSort(enterChoice);
		
    }
}
