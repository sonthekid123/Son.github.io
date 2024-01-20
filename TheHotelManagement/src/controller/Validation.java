
package controller;

import static controller.HotelFile.sc;
import controller.HotelFile;
public class Validation {
    
     public boolean checkFormatID(String name){
        if(name.matches("H\\d{2}"))
            return true;
        return false;
    }
     public boolean checkinputYN(String r) {
        boolean cond = true;
        while (cond) {
            r = sc.nextLine();
            if (r.equalsIgnoreCase("1")) {
                return cond;
            } else if (r.equalsIgnoreCase("2")) {
                cond = false;
                System.out.println("Return to menu !");
            }
        }
        return cond;
    }
     public boolean checkBlank(String msg) {
//        boolean r = false;
//        if (msg.isEmpty()) {
//            r = true;
//            System.out.println("Try again !");
//        }
//        return r;
        return msg.isEmpty();
    }
     
    public String inputID() {
        String id;
        do {
            System.out.print("Please enter Hotel ID[Hxx](xx from 0-999999): ");
            id = sc.nextLine();
        } while (checkBlank(id));
        return id;
    }

    public String inputHotel_Name() {
        String n;
        do {
            System.out.print("Please enter Hotel's name: ");
            n = sc.nextLine();
        } while (checkBlank(n));
        return n;
    }

    public int inputHotel_Room_Available(int min, int max) {
        System.out.print("Please enter Hotel's Room Available: ");        
        while(true){
            String input = sc.nextLine();
            try{
                int n = Integer.parseInt(input);
                if(n < min || max < n){
                    System.out.print("Please input from "+min+" to "+max+": ");
                    continue;
                }return n;
            }catch(Exception e){
                System.out.print("Please input an integer number: ");
            }
        }
    }
    public boolean checkMinMax(int input, int min, int max) {
        int result = input;
        if(result < min || max < result) {
            System.err.print("Please input between from " + min + "to " + max + "please : ");
            return false;
        }
        return true;
    }

    public String inputAddress() {
        String addr;
        do {
            System.out.print("Please enter Hotel's address:");
            addr = sc.nextLine();
        } while (checkBlank(addr));
        return addr;
    }

    public String inputPhone() {
        System.out.print("Please enter Hotel's phone (0xxxxxxxxx): ");
        String phone = null;
        do {
            phone = sc.nextLine();
            if (!phone.matches("0\\d{9}")) {
                System.out.println("Invalid phone number! ");
                System.out.print("Please enter Hotel's phone again: ");
            }
        } while (!phone.matches("0\\d{9}"));
        return phone;
    }
    public String inputHotel_Rating() {
        String r;
        do {
            System.out.print("Please enter Hotel's Rating :");
            r = sc.nextLine();
        } while (checkBlank(r));
        return r;
    }
}
