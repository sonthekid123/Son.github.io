
package view;

import controller.HotelFile;
import java.util.Scanner;

public class Main {
    private static HotelFile h = new HotelFile();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choose ;
        boolean exit = false;
        showMenu();        
        while(exit == false){           
            while(true){
                String s = sc.nextLine();
                try{
                    choose = Integer.parseInt(s); 
                }catch(Exception e){
                    System.out.println("Wrong format");
                    System.out.print("Please enter from 1 to 7: ");
                    continue;
                }
                if(choose > 7 || choose < 1){
                    System.out.print("Please enter from 1 to 7: ");
                    continue;
                }
                break;
            }
            switch(choose){
                case 1: 
                    h.F1_Add();
                    break;
                case 2:
                    h.F2_checkHotelExist();
                    break;
                case 3:
                    h.F3_UpdateHotel();
                    break;
                case 4:
                    h.F4_DeleteHotel();
                    break;
                case 5:                   
                    System.out.println("Search by id or Search by name ? (1 = id || 2 = name)");
                    System.out.print("Your choice: ");
                    int r = sc.nextInt();                    
                    if(r == 1){
                        h.F5_searchByID();
                    }
                    else if (r == 2){
                        h.F5_searchByName();
                    }
                    break;
                case 6:
                    h.F6_ShowList();
                    break;
                case 7:  
                    System.out.println("The program is Quitted !");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid ! Please try again !");
                    break;
            }
                if(exit == false) showMenu();
        }
    }
    
    public static void showMenu(){      
        System.out.println("============Hotel management program============");
        System.out.println("1. Add new Hotel.");
        System.out.println("2. Check exits Hotel.");
        System.out.println("3. Update Hotel information.");
        System.out.println("4. Delete Hotel.");
        System.out.println("5. Search Hotel.");
        System.out.println("  5.1 Search by Hotel_ID.");
        System.out.println("  5.2 Search by Hotel_Name.");
        System.out.println("6. Display Hotel list");
        System.out.println("7. Quit ");
        System.out.println("=============================");
        System.out.print("Please choose (1 => 7): ");
    }
}
