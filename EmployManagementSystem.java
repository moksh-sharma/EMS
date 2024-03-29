
import java.util.*;
import java.io.*;

class MainMenu { // Main Menu Class
  public void menu() { // Method to display the Main Menu
    System.out.println("\n"); // Printing a new line
    System.out.println("EMPLOYEE MANAGEMENT SYSTEM");
    System.out.println("\n\nPress '1' >>> To Add Employee Details");
    System.out.println("Press '2' >>> To See Employee Details ");
    System.out.println("Press '3' >>> To Remove an Employee");
    System.out.println("Press '4' >>> To Update Employee Details");
    System.out.println("Press '5' >>> To Exit the EMS Portal");

  }
}

class Employee_Add { // Class to Add Employee Details
  public void createFile() { // Method to Create a File
    Scanner sc = new Scanner(System.in); // Creating an object of Scanner Class

    EmployDetail emp = new EmployDetail(); // Creating an object of EmployDetail Class
    emp.getInfo(); // Calling the getInfo Method
    try { // Try Block
      File f1 = new File("file" + emp.employ_id + ".txt"); // Creating a new File
      if (f1.createNewFile()) { // If the File is created
        FileWriter myWriter = new FileWriter("file" + emp.employ_id + ".txt"); // Creating an object of FileWriter Class
        myWriter.write("Employee ID       >>> " + emp.employ_id + "\n" + "Employee Name     >>> " + emp.name +
            "\n" + "Employee Contact  >>> " + emp.employ_contact + "\n" +
            "Email Information >>> " + emp.email + "\n" + "Employee position >>> " + emp.position + "\n" +
            "Employee Salary   >>> " + emp.employ_salary); // Writing the Employee Details in the File
        myWriter.close(); // Closing the File
        System.out.println("\nEmployee has been Added :)\n");

        System.out.print("\nPress Enter to Continue...");
        sc.nextLine();
      } else {
        System.out.println("\nEmployee already exists :(");
        System.out.print("\nPress Enter to Continue...");
        sc.nextLine();
      }
    } catch (Exception e) {
      System.out.println(e); // Printing the Exception
    }

  }
}

class EmployDetail { // Class to get Employee Details
  String name;
  String email;
  String position;
  String employ_id;
  String employ_salary;
  String employ_contact;

  public void getInfo() { // Method to get Employee Details
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Employee's name >>> ");
    name = sc.nextLine();
    System.out.print("Enter Employee's ID >>> ");
    employ_id = sc.nextLine();
    System.out.print("Enter Employee's Email ID >>> ");
    email = sc.nextLine();
    System.out.print("Enter Employee's Position >>> ");
    position = sc.nextLine();
    System.out.print("Enter Employee contact Info >>> ");
    employ_contact = sc.nextLine();
    System.out.print("Enter Employee's Salary >>> ");
    employ_salary = sc.nextLine();

  }
}

class Employee_Show { // Class to View Employee Details
  public void viewFile(String s) throws Exception { // Method to View the File
    File file = new File("file" + s + ".txt"); // Creating a new File
    Scanner sc = new Scanner(file);

    while (sc.hasNextLine()) { // While the File has next Line
      System.out.println(sc.nextLine()); // Print the Line
    }

  }
}

class Employee_Remove { // Class to Remove Employee Details
  public void removeFile(String ID) { // Method to Remove the File

    File file = new File("file" + ID + ".txt"); // Creating a new File
    if (file.exists()) { // If the File Exists
      if (file.delete()) // If the File is Deleted
        ;
      {
        System.out.println("\nEmployee has been removed Successfully");
      }
    } else { // If the File does not Exists
      System.out.println("\nEmployee does not exists :( ");
    }
  }
}

class Employee_Update { // Class to Update Employee Details
  public void updateFile(String s, String o, String n) throws IOException { // Method to Update the File
    File file = new File("file" + s + ".txt"); // Creating a new File
    Scanner sc = new Scanner(file);
    String fileContext = ""; // Creating a new String
    while (sc.hasNextLine()) { // While the File has next Line
      fileContext = fileContext + "\n" + sc.nextLine(); // Add the Line to the String
    }
    FileWriter myWriter = new FileWriter("file" + s + ".txt"); // Creating an object of FileWriter Class
    fileContext = fileContext.replaceAll(o, n); // Replacing the Old Info with New Info
    myWriter.write(fileContext); // Writing the Updated Info in the File
    myWriter.close(); // Closing the File

  }
}

class CodeExit { // Class to Exit the Code
  public void out() { // Method to Exit the Code

    System.out.println("Thank You for using :) "); // Printing a Message

    System.exit(0); // Exiting the Code
  }
}

class EmployManagementSystem { // Main Class
  public static void main(String arv[]) { // Main Method
    /** To clear the output Screen **/
    System.out.print("\033[H\033[2J"); // Clearing the Output Screen

    Scanner sc = new Scanner(System.in);
    Employee_Show epv = new Employee_Show(); // Creating an object of Employee_Show Class

    int i = 0;

    MainMenu obj1 = new MainMenu(); // Creating an object of MainMenu Class
    obj1.menu(); // Calling the menu Method

    while (i < 6) {

      System.out.print("\nPlease Enter choice >>> ");
      i = Integer.parseInt(sc.nextLine()); // Taking the Input from the User

      switch (i) { // Switch Case
        case 1: {

          Employee_Add ep = new Employee_Add(); // Creating an object of Employee_Add Class
          ep.createFile();

          System.out.print("\033[H\033[2J"); // Clearing the Output Screen
          obj1.menu();
          break;
        }
        case 2: {
          System.out.print("\nPlease Enter Employee's ID >>> ");
          String s = sc.nextLine();
          try {
            epv.viewFile(s);
          } catch (Exception e) {
            System.out.println(e);
          }

          System.out.print("\nPress Enter to Continue...");
          sc.nextLine();
          System.out.print("\033[H\033[2J");
          obj1.menu();
          break;
        }

        case 3: {
          System.out.print("\nPlease Enter Employee's ID >>> ");
          String s = sc.nextLine();
          Employee_Remove epr = new Employee_Remove();
          epr.removeFile(s);

          System.out.print("\nPress Enter to Continue...");
          sc.nextLine();
          System.out.print("\033[H\033[2J");
          obj1.menu();
          break;
        }
        case 4: {
          System.out.print("\nPlease Enter Employee's ID >>> ");
          String I = sc.nextLine();
          try {
            epv.viewFile(I); // Viewing the File
          } catch (Exception e) { // Catch Block
            System.out.println(e); // Printing the Exception
          }
          Employee_Update epu = new Employee_Update();
          System.out.print("Please Enter the detail you want to Update >>> ");
          System.out.print("\nFor Example :\n");
          System.out.println(
              "If you want to Change the Name, then Enter Current Name and Press Enter. Then write the new Name then Press Enter. It will Update the Name.\n");
          String s = sc.nextLine();
          System.out.print("Please Enter the Updated Info >>> ");
          String n = sc.nextLine();
          try {
            epu.updateFile(I, s, n); // Updating the File

            System.out.print("\nPress Enter to Continue...");
            sc.nextLine();
            System.out.print("\033[H\033[2J");
            obj1.menu();
            break;
          } catch (IOException e) { // Catch Block
            System.out.println(e); // Printing the Exception
          }
        }
        case 5: {
          CodeExit obj = new CodeExit(); // Creating an object of CodeExit Class
          obj.out(); // Calling the out Method
        }
      }
    }

  }
}
