package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
public class MainController {


	@FXML
	private ListView le2;
	
	
	Main a=new Main();
	
	@SuppressWarnings("unchecked")
	public void b1Action(ActionEvent event)
	{
		FileChooser fc=new FileChooser();
		fc.setInitialDirectory(new File("C:/Users/admin/Desktop"));
		
		fc.getExtensionFilters().addAll(new ExtensionFilter("Text Files","*.txt")); //selects only text files
		List<File> SelectedFile=fc.showOpenMultipleDialog(null);
		for(int i=0;i<SelectedFile.size();i++)
		{
			le2.getItems().add(SelectedFile.get(i).getAbsolutePath());
		}
		
		FileRead(SelectedFile);
		
		System.exit(0);
			
	
	}
	@SuppressWarnings("resource")
	public int FileRead(List<File> l)
	{
		String ab="";
				for(int i=0;i<l.size();i++)
				{
					File fName=new File(l.get(i).getAbsolutePath());
					Scanner sc;
			 
					try {
						sc = new Scanner(fName);
						sc.useDelimiter("\\Z");
						ab=ab+"\n "+sc.next();
				
				 
					} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
						e.printStackTrace();
						return 1;	
					}
			  
			    }
				 System.out.println(ab);
				 File file = new File("C:/Users/admin/Desktop/MasterFile.txt");		  
				 FileWriter writer;
				try {
					writer = new FileWriter(file);
					System.out.println("Master file created");
					writer.write(ab);
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return 1;	
				}
			return 0;	 
	}
	

	
}
