package Auto;

import java.util.Random;

public class myData {
	
	Random rand = new Random();
	
	String [] firstNames = {"Mansour","Ali","Moss","CR7ss","Leoss"};
	
	String [] lastNames = {"siss","Aliss","Moaa","CR7sd","Leosd"};
	
	int randomNumberFotTheEmail = rand.nextInt(10000);		
	
	
	String domain = "@gmail.com";
			
	
	int randomFirstNameIndex = rand.nextInt(firstNames.length);

	int randomLastNameIndex = rand.nextInt(firstNames.length);
	
	

	String TheFirstName = firstNames[randomFirstNameIndex];
	
	String TheLastName = lastNames[randomLastNameIndex];
	
	String TheEmail = TheFirstName+TheLastName+randomNumberFotTheEmail+domain;

    String TelePhonee = "962799702650";
    
    String TheFaxnum = "12345" ; 
    
    String TheAdressOne = "Jordan-Amman";
    
    int theSelectStateIndex = rand.nextInt(1,10) ;
    
    String postalCode = "1980";
    
    String LOGINAME = TheFirstName+TheLastName+randomNumberFotTheEmail;
    
    String Password = "P@$$w0rd";
   
	String ExpectedTextForTheSignUp = "YOUR ACCOUNT HAS BEEN CREATED!";
	
	String Welcomemessage = "Welcome back"+TheFirstName;



}


