package org.jsp.cars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CrudOpration {

	static Scanner sc = new Scanner(System.in);
	
    // main menu

    public static void main(String[] args) {
		
        System.out.println("Press 1 to add car details :->");
        System.out.println("Press 2 to Update car details :->");
        System.out.println("Press 3 to delete car details :->");
        System.out.println("Press 4 to create table :->");
        System.out.println("Press 5 to Fetch the record from table :->");
        System.out.println("Press 0 to exit :->");
        System.out.println("");
        System.out.print("Enter number :-> ");
        System.out.println("");

		int n = sc.nextInt();

        switch (n) {
            case 1: {
                car();
                break;
            }
            case 2: {
                updateMenu();
                break;
            }
            case 3: {
                deleteMenu();
                break;
            }
            case 4: {
            		createTable();
            	break;
            }
            case 5: {
            	fetchRecordMenu();
            	break;
            }
            case 0: {
                System.exit(0);
                break;
            }
            default:
                main(null);
                break;
        }
    }

   

	public static void car() {
        System.out.println("Enter car id");
		int id = sc.nextInt();

        System.out.println("Enter car name");
		String name = sc.next();

        System.out.println("Enter car price");
		double price = sc.nextDouble();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			
			PreparedStatement ps = con.prepareStatement("insert into car.carsdetail value(?,?,?)");

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.execute();
            System.out.println("Data Inserted");
            System.out.println("");


        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        main(null);
        
    }

    // to update details

    public static void updateMenu() {

        System.out.println("============= Update Data =============");
        System.out.println("");
        System.out.println("Press 1 to update via id to update name");
        System.out.println("Press 2 to update via id to update price");
        System.out.println("Press 3 to update via name to update id");
        System.out.println("Press 4 to update via name to update price");
        System.out.println("Press 5 to update via price to update id");
        System.out.println("Press 6 to update via price to update name");
        System.out.println("Press 0 to back to menu");
        System.out.println("");
    	
    	int n = sc.nextInt();

        switch (n) {
            case 1: {
                updateViaIdToName();
                break;
            }
            case 2: {
                updateViaIdToPrice();
                break;
            }
            case 3: {
                updateViaNameToId();
                break;
            }
            case 4: {
                updateViaNameToPrice();
                break;
            }
            case 5: {
                updateViaPriceToId();
                break;
            }
            case 6: {
                updateViaPriceToName();
                break;
            }
            default: {
                updateMenu();
                break;
            }

        }

    }

    public static void updateViaIdToName() {

        System.out.print("Enter car name : ");
       	String name = sc.next();

        System.out.print("Enter car id : ");
		int id = sc.nextInt();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		PreparedStatement ps = con.prepareStatement("update car.carsdetail set cname=? where cid=?");
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.execute();
        } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        System.out.println("Enter 1 to update more : ");
        System.out.println("Enter 0 to back to update menu : ");
        
        int n = sc.nextInt();

        switch (n) {
            case 1: {
                updateViaIdToName();
            }
            case 0: {
                updateMenu();
            }
            default:
                System.out.println("Enter Currect Number");
                updateViaIdToName();
        }
    }

    public static void updateViaIdToPrice() {

        System.out.println("Enter car price");
		double price = sc.nextDouble();

        System.out.print("Enter car id : ");
		int id = sc.nextInt();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		PreparedStatement ps = con.prepareStatement("update car.carsdetail set cprice=? where cid=?");

            ps.setDouble(1, price);
            ps.setInt(2, id);
            ps.execute();

        } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        System.out.println("Enter 1 to update more : ");
        System.out.println("Enter 0 to back to update menu : ");
        
        int n = sc.nextInt();

        switch (n) {
            case 1: {
                updateViaIdToPrice();
            }
            case 0: {
                updateMenu();
            }
            default:
                System.out.println("Enter Currect Number");
                updateViaIdToPrice();
        }
    }

    public static void updateViaNameToId() {

        System.out.println("Enter car price");
		String name = sc.nextLine();

        System.out.print("Enter car id : ");
		int id = sc.nextInt();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		PreparedStatement ps = con.prepareStatement("update car.carsdetail set cid=? where cname=?");

            ps.setString(1, name);
            ps.setInt(2, id);
            ps.execute();

        } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        System.out.println("Enter 1 to update more : ");
        System.out.println("Enter 0 to back to update menu : ");
        
        int n = sc.nextInt();

        switch (n) {
            case 1: {
                updateViaNameToId();
            }
            case 0: {
                updateMenu();
            }
            default:
                System.out.println("Enter Currect Number");
                updateViaNameToPrice();
        }
    }

    public static void updateViaNameToPrice() {

        System.out.println("Enter car name : ");
		String name = sc.nextLine();

        System.out.print("Enter car price : ");
		double price = sc.nextDouble();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		PreparedStatement ps = con.prepareStatement("update car.carsdetail set cprice=? where cname=?");

            ps.setDouble(1, price);
            ps.setString(2, name);
            ps.execute();

        } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        System.out.println("Enter 1 to update more : ");
        System.out.println("Enter 0 to back to update menu : ");
        
        int n = sc.nextInt();

        switch (n) {
            case 1: {
                updateViaNameToPrice();
            }
            case 0: {
                updateMenu();
            }
            default:
                System.out.println("Enter Currect Number");
                updateViaNameToPrice();
        }
    }

    public static void updateViaPriceToId() {

        System.out.print("Enter car id : ");
		int id = sc.nextInt();

        System.out.println("Enter car price");
		double price = sc.nextDouble();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		PreparedStatement ps = con.prepareStatement("update car.carsdetail set cid=? where cprice=?");

            ps.setDouble(1, price);
            ps.setInt(2, id);
            ps.execute();

        } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        System.out.println("Enter 1 to update more : ");
        System.out.println("Enter 0 to back to update menu : ");
        
        int n = sc.nextInt();

        switch (n) {
            case 1: {
                updateViaPriceToId();
            }
            case 0: {
                updateMenu();
            }
            default:
                System.out.println("Enter Currect Number");
                updateViaIdToName();
        }
    }

    public static void updateViaPriceToName() {

        System.out.print("Enter car price : ");
		double price = sc.nextDouble();

        System.out.print("Enter car name : ");
       	String name = sc.next();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		PreparedStatement ps = con.prepareStatement("update car.carsdetail set cname=? where cprice=?");
            ps.setString(1, name);
            ps.setDouble(2, price);

            ps.execute();
        } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        System.out.println("Enter 1 to update more : ");
        System.out.println("Enter 0 to back to update menu : ");
        
        int n = sc.nextInt();

        switch (n) {
            case 1: {
                updateViaIdToName();
            }
            case 0: {
                updateMenu();
            }
            default:
                System.out.println("Enter Currect Number");
                updateViaIdToName();
        }
    }

    // to delete the data

    public static void deleteMenu() {

        System.out.println("Press 1 to Delete Via Id");
        System.out.println("Press 2 to Delete Via name");
        System.out.println("Press 3 to Delete Via price");
		
		int n = sc.nextInt();

        switch (n) {
            case 1: {
                deleteViaId();
            }

            case 2: {
                deleteViaName();
            }

            case 3: {
                deleteViaPrice();
            }
            default:
                deleteMenu();
        }



    }

    public static void deleteViaId() {

        System.out.println("Enter car id : ");
		int id = sc.nextInt();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		
		PreparedStatement ps = con.prepareStatement("delete from car.carsdetail where id=?");

            ps.setInt(1, id);
            ps.execute();

        }
        catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Press 1 to delete more ");
        System.out.println("press 0 to delete menu");
        
        int n = sc.nextInt();

        switch (n) {
            case 1: {
                deleteViaId();
                break;
            }
            case 0: {
                deleteMenu();
                break;
            }
            default:
                deleteViaId();
        }
    }

    public static void deleteViaName() {

        System.out.println("Enter car name");
        		String name = sc.next();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		
		PreparedStatement ps = con.prepareStatement("delete from car.carsdetail where name=?");

            ps.setString(1, name);
            ps.execute();

        }
        catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Press 1 to delete more ");
        System.out.println("press 0 to delete menu");
        
        int n = sc.nextInt();

        switch (n) {
            case 1: {
                deleteViaName();
                break;
            }
            case 0: {
                deleteMenu();
                break;
            }
            default:
                deleteViaName();
        }
    }

    public static void deleteViaPrice() {

        System.out.println("Enter car price");
        double price = sc.nextDouble();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		
		PreparedStatement ps = con.prepareStatement("delete from car.carsdetail where price=?");

            ps.setDouble(1, price);
            ps.execute();

        }
        catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Press 1 to delete more ");
        System.out.println("press 0 to delete menu");
        
        int n = sc.nextInt();

        switch (n) {
            case 1: {
                deleteViaPrice();
                break;
            }
            case 0: {
                deleteMenu();
                break;
            }
            default:
                deleteViaPrice();
        }
    }

    public static void createTable()
    {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			Statement stml = con.createStatement();
			stml.execute("create table car.carsdetail(cid int , cname varchar(45) , cprice double)");
			System.out.println("Table created");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void fetchRecordMenu() {

    	System.out.println("press 1 to fetch usring id");
    	System.out.println("press 2 to fetch usring name");
    	System.out.println("press 3 to fetch usring peice");
    	
    	
    	int n = sc.nextInt();
    	
    	switch (n) {
		case 1: {
			fetchUsingId();
			break;
		}
		case 2: {
			fetchUsingName();
			break;
		}
		case 3: {
			fetchUsingPrice();
			break;
		}
		default:
			fetchRecordMenu();
		}
		
	}
    
    public static void fetchUsingId() {
    	
    	int cid = sc.nextInt();
    	
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement ps = con.prepareStatement("select * from car.carsdetail where cid=?");
			ps.setInt(1, cid);
			
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double price= rs.getDouble(3);
				System.out.println("id : " + id + " name : " + name + " price : " +price );
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
 public static void fetchUsingName() {
    	
    	String cname = sc.next();
    	
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement ps = con.prepareStatement("select * from car.carsdetail where cname=?");
			ps.setString(1, cname);
			
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double price= rs.getDouble(3);
				System.out.println("id : " + id + " name : " + name + " price : " + price );
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
 public static void fetchUsingPrice() {
 	
 	double cprice = sc.nextDouble();
 	
 	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement ps = con.prepareStatement("select * from car.carsdetail where cprice=?");
			ps.setDouble(1, cprice);
			
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double price= rs.getDouble(3);
				System.out.println("id : " + id + " name : " + name + " price : " + price);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }

}