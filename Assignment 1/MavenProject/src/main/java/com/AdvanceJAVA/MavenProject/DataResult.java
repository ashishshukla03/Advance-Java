package com.AdvanceJAVA.MavenProject;
import java.util.ArrayList;
public class DataResult {
	public void viewTShirt(ArrayList<CSVdetails> list) {
		System.out.println(" T-SHIRT INFORMATIONS: ");
		for (CSVdetails f : list) {
			System.out.println("ID :" + f.getID());
			System.out.println("NAME :" + f.getName());
			System.out.println("COLOUR :" + f.getColour());
			System.out.println("Gender :"+ f.getGender());
			System.out.println("SIZE :"+ f.getSize());
			System.out.println("PRICE :"+ f.getPrice());
			System.out.println("RATING :"+ f.getRating());
			System.out.println("AVAILABILITY :"+ f.getAvailability());
			System.out.println(" ");
			
		}
		if (list.isEmpty()) {
			System.out.println("T-Shirt Not Available.");
		}
	}

}
