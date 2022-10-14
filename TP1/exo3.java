package TP1;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class exo3 {

	public static void main(String[] args) throws Exception {
		
		ArrayList<user> newusers = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		boolean x = true, y = true, z=true;
		System.out.println("Do You want to add user ? enter true/false to continue");
		x = sc.nextBoolean();
		sc.nextLine();
		while (x) {
			System.out.println("Enter the user infos :");
			System.out.println("fname :");
			String fname = sc.nextLine();
			System.out.println("lname :");
			String lname = sc.nextLine();
			System.out.println("username :");
			String username = sc.nextLine();
			System.out.println("password :");
			String password = sc.nextLine();
			System.out.println("phonenumber :");
			String phonenumber = sc.nextLine();
			newusers.add(new user(fname,lname,username,password,phonenumber));
			System.out.println("Do You want to add another user ? enter true/false to continue");
			x = sc.nextBoolean();
			y = x;
			sc.nextLine();
		}
		sc.close();
		if (!y) {
			ArrayList<user> users = new ArrayList<>();
			if (testFile.test()) {
				users = deserialize.des();
				users.addAll(newusers);
			}
			else users = newusers;
			
			try
	        {
	            FileOutputStream fos = new FileOutputStream("C:\\Users\\helei\\eclipse-workspace\\PJA\\src\\TP1\\users.ser");
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	           
	            for (user u : users) {
	            	oos.writeObject(u);
	            }
	            oos.writeObject(new endoffile());
	            z = true;
	            oos.close();
	            fos.close();
	        } 
	        catch (IOException ioe) 
	        {
	            ioe.printStackTrace();
	        }
		}
		ArrayList<user> ulist = new ArrayList<>();
		if (testFile.test()) {
			ulist = deserialize.des();
			System.out.println("deserialization result : \n");
			for (user u : ulist) {
				System.out.println(u.fname+" , "+u.lname+" , "+u.username+" , "+u.password+" , "+u.phonenumber+" \n");
			}
		}
		else System.out.println("File is empty");
		
	}

}

class user implements Serializable {
	
	String fname,lname,username,password,phonenumber;
	
	public user (String fname,String lname,String username,String password,String phonenumber) {
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.phonenumber = phonenumber;
	}
	

}

class endoffile implements Serializable {
	
}

class testFile {
	public static boolean test() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\helei\\eclipse-workspace\\PJA\\src\\TP1\\users.ser"));     
		if (br.readLine() == null) {
			br.close();
		    return false;
		}
		br.close();
		return true;
	}
}

class deserialize {
	public static ArrayList<user> des() {
		ArrayList<user> userslist = new ArrayList<>();
        
        try
        {
            FileInputStream fis = new FileInputStream("C:\\Users\\helei\\eclipse-workspace\\PJA\\src\\TP1\\users.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            	Object obj = null;
                while ((obj=ois.readObject()) instanceof endoffile == false) {
                	userslist.add((user)obj);
                }
                ois.close();
                fis.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
            
        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class not found");
            c.printStackTrace();
            
        }
        
        return userslist;
	}
}
