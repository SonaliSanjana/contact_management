import java.util.*;
import java.time.*;
class Contactlist{
	private Contacts[] contactArray;
	private int nextIndex;
	private int size;
	private int loadfactor;
	
	Contactlist(int size,int loadfactor){
		contactArray=new Contacts[size];
		nextIndex=0;
		this.size=size;
		this.loadfactor=loadfactor;
	}
	
	private boolean isFull(){
		return nextIndex>=size;
	}
	
	private void extendArrays(){
		Contacts[] tempcontactArray=new Contacts[loadfactor];
		for (int i=0;i<nextIndex;i++){
			tempcontactArray[i]=contactArray[i];
			}
		contactArray=tempcontactArray;
		}
	
	public void add(Contacts contact){
		if(isFull()){
			extendArrays();
		}
		contactArray[nextIndex++]=contact; 	
	}
	public int search(String nameOrPhone){
		for(int i=0;i<nextIndex;i++){
			if(contactArray[i].getname().equals(nameOrPhone) || contactArray[i].getphoneNumber().equals(nameOrPhone)){
				return i;
				}
			}
		return -1;
		}
	public Contacts[]toArray(){
		Contacts[] tempContactArray=new Contacts[size];
		for(int i=0;i<nextIndex;i++){
			tempContactArray[i]=contactArray[i];
			}
		contactArray=tempContactArray;
		return tempContactArray;
	}
	public void updateName(int index,String name){
		contactArray[index].setname(name);
	}
	public void updatePhoneNumber(int index,String p_no){
		contactArray[index].setphoneNumber(p_no);
	}
	public void updateCompanyName(int index,String companyName){
		contactArray[index].setcompanyName(companyName);
	}
	public void updateSalary(int index,double salary){
		contactArray[index].setSalary(salary);
	}
	public int getsize(){
		return nextIndex;
	}
	public boolean isEmpty(){
		return nextIndex<=0;
	}
	public boolean isValidindex(int index){
		return index < 0 || index >= nextIndex;
		}
	public void delete(int index) {
		if (isValidindex(index)) {
			System.out.println("Invalid index. Cannot delete contact.");
			return;
		}
		for (int i = index; i < nextIndex - 1; i++) {
			contactArray[i] = contactArray[i + 1];
		}
		nextIndex--;
	}
}
class Contacts{
	private String id;
    private String name;
    private String phoneNumber;
    private String companyName;
    private double salary;
    private String birthday;
    
    Contacts(String id,String name,String phoneNumber,String companyName,double salary,String birthday){
		this.id=id;
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.companyName=companyName;
		this.salary=salary;
		this.birthday=birthday;
	}
	public String getId() {
        return id;
        }
	public void setId(String id) {
        this.id = id;
        }
	public String getname(){
	   return name;
	   }
	public void setname(String name) {
        this.name = name;
        }
	public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        }
    public String getphoneNumber(){
	   return phoneNumber;
	   }
	public void setcompanyName(String companyName) {
        this.companyName = companyName;
       }
    public String getcompanyName(){
	   return companyName;
	   }
	public void setSalary(double salary) {
        this.salary = salary;
        }
    public double getsalary(){
	   return salary;
	   }
	public void setbirthday(String birthday) {
        this.birthday = birthday;
        }
    public String getbirthday(){
	   return birthday;
	   }
	}
class Example{
    //-------------------CREATE AN ARRAYS ----------------
    //public static Contacts[] contactArray = new Contacts[0];
    public static Contactlist contactlist=new Contactlist(100,50);
    public static String sp8="        ";
    
	    //----------------------CLEAR CONSOLE --------------------
		public final static void clearConsole() { 
			try {
			final String os = System.getProperty("os.name"); 
			if (os.contains("Windows")) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
			System.out.print("\033[H\033[2J"); 
			System.out.flush();
			}
			} catch (final Exception e) {
			e.printStackTrace();
			// Handle any exceptions.
			}
		}
    //-----------------MAIN METHOD--------------------
    public static void main(String[] args){
        homepage();
    }
    //-------------------GENERATE ID----------------
    public static String generateId(){
		if(contactlist.getsize()==0){
			return "C0001";
		}else{
			return String.format("C%04d",contactlist.getsize()+1);
		}
	}
    //-----------------HOME PAGE--------------------
    public static void homepage(){
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n\n            /$$ /$$$$$$$$ /$$$$$$$  /$$$$$$ /$$$$$$$$ /$$   /$$ /$$$$$$$                          "); 
		System.out.println("            |__/| $$_____/| $$__  $$|_  $$_/| $$_____/| $$$ | $$| $$__  $$                              "); 
		System.out.println("             /$$| $$      | $$  \\ $$  | $$  | $$      | $$$$| $$| $$  \\ $$                            "); 
		System.out.println("            | $$| $$$$$   | $$$$$$$/  | $$  | $$$$$   | $$ $$ $$| $$  | $$                              "); 
		System.out.println("            | $$| $$__/   | $$__  $$  | $$  | $$__/   | $$  $$$$| $$  | $$                              "); 
		System.out.println("            | $$| $$      | $$  \\ $$  | $$  | $$      | $$\\  $$$| $$  | $$                            "); 
		System.out.println("            | $$| $$      | $$  | $$ /$$$$$$| $$$$$$$$| $$ \\  $$| $$$$$$$/                             "); 
		System.out.println("            |__/|__/      |__/  |__/|______/|________/|__/  \\__/|_______/                          \n\n"); 
		System.out.println("   _____             _               _          ____                          _                         "); 
		System.out.println("  / ____|           | |             | |        / __ \\                        (_)                       "); 
		System.out.println(" | |      ___  _ __ | |__ ___ _  ___| |_ ___  | |  | |_ __ ___ _  ___ _ _ __  _ ______  _ ___           "); 
		System.out.println(" | |     / _ \\| '__\\| __ / _ ` |/ __| __/ __| | |  | | '__/ _ ` |/ _ ` | '_ \\| |_  / _ \\ ' __|      "); 
		System.out.println(" | |____| (_) | | | | | | |_|  | |__| |_\\__ \\ | |__| | | | |_|  | |_|  | | | | |/ /  __/  |           "); 
		System.out.println("  \\______\\___/|_| |_|\\___\\___,_|\\___|\\__|___/  \\____/|_|  \\___, |\\___,_|_| |_|_/___\\___||_|   "); 
		System.out.println("                                                           ___/ |                                       "); 
		System.out.println("                                                          |____/                                        "); 
		System.out.println("\n===============================================================================================   \n\n"); 
		System.out.printf("%s[01] ADD Contacts%n",sp8);
		System.out.printf("%s[02] UPDATE Contacts%n",sp8);
		System.out.printf("%s[03] DELETE Contacts%n",sp8);
		System.out.printf("%s[04] SEARCH Contacts%n",sp8);
		System.out.printf("%s[05] LIST Contacts%n",sp8);
		System.out.printf("%s[06] Exit%n%n%n",sp8);
        System.out.print("\nEnter option to continue : ");
        int option=input.nextInt();
        clearConsole();
        switch(option){
            case 1 : addContacts();break;
            case 2 : updateContacts();break;
            case 3 : deleteContacts();break;
            case 4 : searchContacts();break;
            case 5 : listContacts();break;
            case 6 : exit();break;
            default : System.out.println("Invalid option...");break;
        }

    }
    //------------------------VALIDATE PHONENUMBER---------------------------
    public static boolean isValidPhoneNumber(String phoneNumber){
        if(phoneNumber.length()==10 && phoneNumber.charAt(0)=='0'){
            for(int i=1; i<phoneNumber.length(); i++){
                if(!Character.isDigit(phoneNumber.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;

    }
    //-------------------VALIDATE SALARY----------------------
    public static boolean isValidSalary(double salary){
        return salary>0;
    }
    // -------------------BIRTHDAY VALIDATION----------------
	public static boolean isValidBirthday(String birthday){
        String y=birthday.substring(0,4);
		int year=Integer.parseInt(y);
		String m=birthday.substring(5,7);
		int month=Integer.parseInt(m);
		String d=birthday.substring(8,10);
		int day=Integer.parseInt(d);
		LocalDate currentDate = LocalDate.now();
		int currentMonthValue = currentDate.getMonthValue();
		int currentYear=currentDate.getYear();    
		int currentMonthDate=currentDate.getDayOfMonth();
			
		if(year%4!=0 & month==2){
			if(day>28){
				return false;
			}else{
				return true;
			}
		}
		if(year%4==0 & month==2){
			if(day>29){
				return false;
			}else{
				return true;
			}
		}
		if(month==4 || month==6 || month==9 || month==11){
			if(day>30){
				return false;					
			}
		}
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
			if(day>31){
				return false;
			}	
		}
		if(month>12){
			return false;
		}
		if(year<currentYear){
			return true;
			}else if(year==currentYear){
									
				if(month>currentMonthValue){
					return true;
				}else if(month==currentMonthValue){
									
					if(day<=currentMonthDate){
						return true;
					}
				}
			}
					return false;
    }

    //-----------------ADD CONTACTS--------------------
    public static void addContacts(){
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("+---------------------------------------------------------+");
			System.out.println("|                 ADD Contact to the list                 |");
			System.out.println("+---------------------------------------------------------+\n\n");
            String id = generateId();
            System.out.println("\n"+id);
            System.out.println("======");
            System.out.print("Name : ");
            String name=input.next();
            String phoneNumber;
            L1:do{
                System.out.print("Phone Number : ");
                phoneNumber  = input.next();
                if(!isValidPhoneNumber(phoneNumber)){
                    System.out.println("\n\tInvalid phone number...");
                    System.out.print("\nDo you want to input phone number again : ");
                    char ch = input.next().charAt(0);
                    if(ch=='Y'||ch=='y'){
                        System.out.print("\033[5A");
                        System.out.print("\033[0J");
                        continue L1;
                    }else if(ch=='N'||ch=='n'){
                        clearConsole();
                        homepage();
                    }
                }

            }while(!isValidPhoneNumber(phoneNumber));

            System.out.print("Company Name : ");
            String companyName  = input.next();
            double salary;

            L2:do{
                System.out.print("Salary : ");
                salary=input.nextDouble();
                if(!isValidSalary(salary)){
                    System.out.println("\n\tInvalid salary...");
                    System.out.print("\nDo you want to input salary again : ");
                    char ch=input.next().charAt(0);
                    if(ch=='Y'||ch=='y'){
                        System.out.print("\033[5A");
                        System.out.print("\033[0J");
                        continue L2;
                    }else if(ch=='N'||ch=='n'){
                        clearConsole();
                        homepage();
                    }
                }

            }while(!isValidSalary(salary));
            String birthday;

            L3:do{
                System.out.print("Birthday : ");
                birthday = input.next();
                if(!isValidBirthday(birthday)){
                    System.out.println("\n\tInvalid birthday...");
                    System.out.print("\nDo you want to input birthday again : ");
                    char ch=input.next().charAt(0);
                    if(ch=='Y'||ch=='y'){
                        System.out.print("\033[5A");
                        System.out.print("\033[0J");
                        continue L3;
                    }else if(ch=='N'||ch=='n'){
                        clearConsole();
                        homepage();
                    }
                }

            }while(!isValidBirthday(birthday));

            
            Contacts contact = new Contacts(id, name, phoneNumber, companyName, salary, birthday);
            contactlist.add(contact);

            System.out.println("\n\tContact has been added successfully...");
            System.out.print("\nDo you want to add another contact : ");
            char ch=input.next().charAt(0);
            if(ch=='Y'||ch=='y'){
                clearConsole();
                addContacts();
            }else if(ch=='N'||ch=='n'){
                clearConsole();
                homepage();
            }

        }while(true);

    }

    //--------------------------PRINT DETAILS---------------------------
    public static void printDetails(int index){
        System.out.println("Contact Id : "+contactlist.toArray()[index].getId());
        System.out.println("Name : "+contactlist.toArray()[index].getname());
        System.out.println("Phone Number : "+contactlist.toArray()[index].getphoneNumber());
        System.out.println("Company Name : "+contactlist.toArray()[index].getcompanyName());
        System.out.println("Salary : "+contactlist.toArray()[index].getsalary());
        System.out.println("Birthday : "+contactlist.toArray()[index].getbirthday());
    }
    //--------------------------SEARCH CONTACT-------------------------
    public static void searchContacts(){
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("+---------------------------------------------------------+");
			System.out .printf("|                     SEARCH Contacts                     |\n");
			System.out.println("+---------------------------------------------------------+\n\n");
            System.out.print("\nSearch contact by name or phone number : ");
            String nameOrPhone=input.next();
            int index = contactlist.search(nameOrPhone);

            if(index == -1){
                System.out.println("\n\tNo contact found for "+nameOrPhone);
                System.out.print("\nDo you want to try a new search : ");
                char ch=input.next().charAt(0);
                if(ch=='Y'||ch=='y'){
                    clearConsole();
                    searchContacts();
                }else if(ch=='N'||ch=='n'){
                    clearConsole();
                    homepage();
                }
            }else{
                printDetails(index);
                System.out.print("\nDo you want to search another contact : ");
                char ch=input.next().charAt(0);
                if(ch=='Y'||ch=='y'){
                    clearConsole();
                    searchContacts();
                }else if(ch=='N'||ch=='n'){
                    clearConsole();
                    homepage();
                }
            }

        }while(true);
    }
    //--------------------------UPDATE NAME----------------------------
    public static void updateName(int index){
        Scanner input=new Scanner(System.in);
        System.out.println("\n Update Name");
        System.out.println("===================");
        System.out.print("\nInput new name : ");
        String newName = input.next();
        contactlist.updateName(index,newName);
    }
    //--------------------------UPDATE NAME----------------------------
    public static void updatePhoneNumber(int index){
        Scanner input=new Scanner(System.in);
        System.out.println("\n Update Phonenumber");
        System.out.println("========================");
        System.out.print("\nInput new phone number : ");
        String newPhoneNumber = input.next();
        contactlist.updatePhoneNumber(index,newPhoneNumber);
    }
    //--------------------------UPDATE NAME----------------------------
    public static void updateCompanyName(int index){
        Scanner input=new Scanner(System.in);
        System.out.println("\n Update Company Name");
        System.out.println("===========================");
        System.out.print("\nInput new company name : ");
        String newCompanyName = input.next();
        contactlist.updateCompanyName(index,newCompanyName);
    }
    //--------------------------UPDATE NAME----------------------------
    public static void updateSalary(int index){
        Scanner input=new Scanner(System.in);
        System.out.println("\n Update Salary");
		System.out.println("================");
        System.out.print("\nInput new salary : ");
        double newSalary = input.nextDouble();
        contactlist.updateSalary(index,newSalary);
    }
    //--------------------------UPDATE CONTACTS-----------------------
    public static void updateContacts(){
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("+---------------------------------------------------------+");
		System.out .printf("|                     UPDATE Contacts                     |\n");
		System.out.println("+---------------------------------------------------------+\n\n");
            System.out.print("\nSearch contact by name or phone number : ");
            String nameOrPhone=input.next();
            int index = contactlist.search(nameOrPhone);

            if(index == -1){
                System.out.println("\n\tNo contact found for "+nameOrPhone);
                System.out.print("\nDo you want to try a new search : ");
                char ch=input.next().charAt(0);
                if(ch=='Y'||ch=='y'){
                    clearConsole();
                    updateContacts();
                }else if(ch=='N'||ch=='n'){
                    clearConsole();
                    homepage();
                }
            }
            else{
                printDetails(index);

                System.out.println("\nWhat do you want to update");
                System.out.println("\n\t[01] Name");
                System.out.println("\t[02] Phone number");
                System.out.println("\t[03] Company Name");
                System.out.println("\t[04] Salary");
                System.out.println("\nEnter an option to continue...");
                int option=input.nextInt();
                switch(option){
                    case 1 : updateName(index);break;
                    case 2 : updatePhoneNumber(index);break;
                    case 3 : updateCompanyName(index);break;
                    case 4 : updateSalary(index);break;
                    default : System.out.println("\n\tInvalid option...");
                }
                System.out.println("\nContact has been update successfully.");
                System.out.print("\nDo you want to update another contact : ");
                char ch=input.next().charAt(0);
                if(ch=='Y'||ch=='y'){
                    clearConsole();
                    updateContacts();
                }else if(ch=='N'|| ch=='n'){
                    clearConsole();
                    homepage();
                }
            }
        }while(true);
    }
    //--------------------------DELETE CONTACTS-----------------------
    public static void deleteContacts(){
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("+---------------------------------------------------------+");
		System.out .printf("|                     DELETE Contacts                     |\n");
		System.out.println("+---------------------------------------------------------+\n\n");
            System.out.print("\nSearch contact by name or phone number : ");
            String nameOrPhone=input.next();
            int index = contactlist.search(nameOrPhone);

            if(index == -1){
                System.out.println("\n\tNo contact found for "+nameOrPhone);
                System.out.print("\nDo you want to try a new search : ");
                char ch=input.next().charAt(0);
                if(ch=='Y'||ch=='y'){
                    clearConsole();
                    deleteContacts();
                }else if(ch=='N'||ch=='n'){
                    clearConsole();
                    homepage();
                }
            }else{
                printDetails(index);
                L1:do{
                    System.out.print("\nDo you want to delete this contact : ");
                    char ch=input.next().charAt(0);
                    if(ch=='Y'||ch=='y'){
                        contactlist.delete(index);
                        System.out.println("\nContact has been deleted successfully...");
                        break L1;
                    }else if(ch=='N'||ch=='n'){
                        break L1;
                    }

                }while(true);

                System.out.println("\nDo you want to delete another contact : ");
                char ch=input.next().charAt(0);
                if(ch=='Y'||ch=='y'){
                    clearConsole();
                    deleteContacts();
                }else if(ch=='N'||ch=='n'){
                    clearConsole();
                    homepage();
                }
                
            }

        }while(true);

    }
    //--------------------------LIST CONTACTS------------------------
    public static void listContacts(){
        Scanner input = new Scanner(System.in);
        System.out.println("+---------------------------------------------------------+");
		System.out .printf("|                     SEARCH Contacts                     |\n");
		System.out.println("+---------------------------------------------------------+\n\n");
        System.out.println("\n[01] Sorting by name");
        System.out.println("\n[02] Sorting by salary");
        System.out.println("\n[03] Sorting by birthday");
        System.out.print("\nEnter option to continue : ");
        int option=input.nextInt();
        switch(option){
            case 1 : sortByName();break;
            case 2 : sortBySalary();break;
            case 3 : sortByBirthday();break;
            default : System.out.println("\n\tInvalid option...");
        }

    }
    //--------------------------SORT BY NAME-------------------------
    public static void sortByName(){
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("               +----------------------------------------------------------------+");
			System.out .printf("               |                      LIST Contacts by Name                     |\n");
			System.out.println("               +----------------------------------------------------------------+\n\n");
			System.out.println("+-------------------------------------------------------------------------------------------------+");
			System.out.println("| Contact ID |     Name      |  Phone Number  |     Company     |     Salary     |    Birthday    |");
			System.out.println("+-------------------------------------------------------------------------------------------------+");

            sortingByName();

            System.out.println("+-------------------------------------------------------------------------------------------------+");
            
            
            System.out.print("\nDo you want to go homepage : ");
            char ch=input.next().charAt(0);
            if(ch=='Y'||ch=='y'){
                clearConsole();
                homepage();
            }else if(ch=='N'|| ch=='n'){
                clearConsole();
                listContacts();
            }


        }while(true);
    }
    //--------------------------SORT BY SALARY-------------------------
    public static void sortBySalary(){
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("               +----------------------------------------------------------------+");
			System.out .printf("               |                     LIST Contacts by Salary                    |\n");
			System.out.println("               +----------------------------------------------------------------+\n\n");
			System.out.println("+-------------------------------------------------------------------------------------------------+");
			System.out.println("| Contact ID |     Name      |  Phone Number  |     Company     |     Salary     |    Birthday    |");
			System.out.println("+-------------------------------------------------------------------------------------------------+");

            sortingBySalary();

            System.out.println("+-------------------------------------------------------------------------------------------------+");
            System.out.print("\nDo you want to go homepage : ");
            char ch=input.next().charAt(0);
            if(ch=='Y'||ch=='y'){
                clearConsole();
                homepage();
            }else if(ch=='N'|| ch=='n'){
                clearConsole();
                listContacts();
            }


        }while(true);
    }
    //--------------------------SORT BY BIRTHDAY-------------------------
    public static void sortByBirthday(){
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("               +----------------------------------------------------------------+");
			System.out .printf("               |                    LIST Contacts by Birthday                   |\n");
			System.out.println("               +----------------------------------------------------------------+\n\n");
			System.out.println("+-------------------------------------------------------------------------------------------------+");
			System.out.println("| Contact ID |     Name      |  Phone Number  |     Company     |     Salary     |    Birthday    |");
			System.out.println("+-------------------------------------------------------------------------------------------------+");

            sortingByBirthday();

            System.out.println("+-------------------------------------------------------------------------------------------------+");
            System.out.print("\nDo you want to go homepage : ");
            char ch=input.next().charAt(0);
            if(ch=='Y'||ch=='y'){
                clearConsole();
                homepage();
            }else if(ch=='N'|| ch=='n'){
                clearConsole();
                listContacts();
            }
        }while(true);
    }
    //-------------------------NAME SORT---------------------------
    public static void sortingByName(){
       Contacts[] tempcontactArray=new Contacts[contactlist.getsize()];

        for(int i=0; i<contactlist.getsize(); i++){
            tempcontactArray[i]=contactlist.toArray()[i];
        }
        for(int j=1; j<contactlist.getsize(); j++){
            for(int i=0; i<contactlist.getsize()-j; i++){
                if(tempcontactArray[i].getname().compareTo(tempcontactArray[i+1].getname())>0){
                    Contacts tempContact = tempcontactArray[i];
					tempcontactArray[i]=tempcontactArray[i+1];
					tempcontactArray[i+1]=tempContact;
                }
            }
        }

        for(int i=0; i<contactlist.getsize(); i++) {
            System.out.printf("|%-12s|%-15s|%-16s|%-17s|%-16.2f|%-16s|\n",tempcontactArray[i].getId(),tempcontactArray[i].getname(),tempcontactArray[i].getphoneNumber(),tempcontactArray[i].getcompanyName(),tempcontactArray[i].getsalary(),tempcontactArray[i].getbirthday());
        }

    }
    //-------------------------SALARY SORT---------------------------
    public static void sortingBySalary(){
        Contacts[] tempcontactArray=new Contacts[contactlist.getsize()];

        for(int i=0; i<contactlist.getsize(); i++){
            tempcontactArray[i]=contactlist.toArray()[i];
        }
        for(int j=1; j<contactlist.getsize(); j++){
            for(int i=0; i<contactlist.getsize()-j; i++){
                if(tempcontactArray[i].getsalary()>tempcontactArray[i+1].getsalary()){
                    Contacts tempContact = tempcontactArray[i];
					tempcontactArray[i]=tempcontactArray[i+1];
					tempcontactArray[i+1]=tempContact;
                }
            }
        }

         for(int i=0; i<contactlist.getsize(); i++) {
            System.out.printf("|%-12s|%-15s|%-16s|%-17s|%-16.2f|%-16s|\n",tempcontactArray[i].getId(),tempcontactArray[i].getname(),tempcontactArray[i].getphoneNumber(),tempcontactArray[i].getcompanyName(),tempcontactArray[i].getsalary(),tempcontactArray[i].getbirthday());
        }

    }

    //-------------------------BIRTHDAY SORT---------------------------
    public static void sortingByBirthday(){
        Contacts[] tempcontactArray=new Contacts[contactlist.getsize()];

        for(int i=0; i<contactlist.getsize(); i++){
            tempcontactArray[i]=contactlist.toArray()[i];
        }
        for(int j=1; j<contactlist.getsize(); j++){
            for(int i=0; i<contactlist.getsize()-j; i++){
                if(tempcontactArray[i].getbirthday().compareTo(tempcontactArray[i+1].getbirthday())>0){
                    Contacts tempContact = tempcontactArray[i];
					tempcontactArray[i]=tempcontactArray[i+1];
					tempcontactArray[i+1]=tempContact;
                }
            }
        }

        for(int i=0; i<contactlist.getsize(); i++) {
            System.out.printf("|%-12s|%-15s|%-16s|%-17s|%-16.2f|%-16s|\n",tempcontactArray[i].getId(),tempcontactArray[i].getname(),tempcontactArray[i].getphoneNumber(),tempcontactArray[i].getcompanyName(),tempcontactArray[i].getsalary(),tempcontactArray[i].getbirthday());
        }
    }
    //-----------------------EXIT--------------------------
    public static void exit(){
        System.exit(0);
    }

}

