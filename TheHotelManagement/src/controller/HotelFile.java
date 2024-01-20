package controller;
import controller.Validation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import thehotelmanagement.Hotel;

public class HotelFile {

    private ArrayList<Hotel> listOfHotel;
    public static Scanner sc = new Scanner(System.in);

    public HotelFile() {
        listOfHotel = new ArrayList<>();
        try {
            ReadFile();
        } catch (IOException ex) {
            Logger.getLogger(HotelFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeFile(){
        try {  
            File f = new File("E:\\Project Hotel\\TheHotelManagement\\Hotel.txt");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutput o = new ObjectOutputStream(fos);        
            for(Hotel i : listOfHotel) {
                o.writeObject(i.toString()+"\n");
            }
            fos.close();
            o.close();                            
        }catch(Exception e) {
            System.err.println("Error write");
        }
               
    }
    public void ReadFile() throws IOException {
        FileReader fr = new FileReader("E:\\Project Hotel\\TheHotelManagement\\Hotel.txt");
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s = br.readLine()) != null) {
            String[] t = s.split("=");
            String id = t[1].split(",")[0];
            String name = t[2].split(",")[0];
            String room = t[3].split(",")[0];
            String address = t[4].split(",")[0] + t[4].split(",")[1]
                    + t[4].split(",")[2] + t[4].split(",")[3];
            String phone_number = t[5].split(",")[0];
            String rating = t[6].split("}")[0];
            listOfHotel.add(new Hotel(id, name, Integer.parseInt(room), address, phone_number, rating));
        }
    }
    
    public boolean checkExisted(String id){        
        for (int i = 0; i<listOfHotel.size(); i++){
            if(id.equalsIgnoreCase(listOfHotel.get(i).getHotel_ID())){
                return true;
            }
        }
        return false;
    }
    
    public void F6_ShowList() {
        System.out.println("List of hotel descending by name: ");
        Collections.sort(listOfHotel, new Comparator<Hotel>() {
            @Override
            public int compare(Hotel o1, Hotel o2) {
                return (o2.getHotel_Name().compareTo(o1.getHotel_Name()));
            }
        });
        for (Hotel hotel : listOfHotel) {
            System.out.println(hotel.toString());
        }
    }

    Validation a = new Validation();
    public void F1_Add() {
        String r = null;
        String id ;
        while(true){
            id = a.inputID();
            if(checkExisted(id)){
                System.out.println("Hotel already existed !");
                continue;
            }
            else if(!a.checkFormatID(id)){
                System.out.println("Wrong Format");
                continue;
            }else {
                break;
            }
        }        
        do {                        
            String name = a.inputHotel_Name();
            int room = a.inputHotel_Room_Available(0,99);
            String address = a.inputAddress();
            String phone = a.inputPhone();
            String rating = a.inputHotel_Rating();
            Hotel h = new Hotel(id, name, room, address, phone, rating);
            listOfHotel.add(h);
            System.out.println("Added successfully !");
            System.out.println("Do you want to add a new Hotel or go back to menu ? ");
            System.out.println("1 = add more || 2 = back to menu");
            System.out.print("Your choice : ");
        } while (a.checkinputYN(r) && !checkExisted(id));
        writeFile();
    }

    public void F2_checkHotelExist() {
        String r = null;        
        String id;
        do {
            boolean flag = false;
            id = a.inputID();
            for (Hotel hotel : listOfHotel) {
                if (id.equalsIgnoreCase(hotel.getHotel_ID())) {
                    flag = true;
                    System.out.println("Hotel existed !");
                    break;
                }
            }                     
            if (flag == false) {
                System.out.println("No hotel found !");
            }
            System.out.println("Do you want to come back to menu ?");
            System.out.println("1 = no || 2 = yes");
            System.out.print("Your choice: ");
        } while (a.checkinputYN(r));
    }

    public void F3_UpdateHotel() {
        String id = a.inputID();
        boolean flag = false;
        for (int i = 0; i < listOfHotel.size(); i++) {
            if (id.equalsIgnoreCase(listOfHotel.get(i).getHotel_ID())) {
                flag = true;
                System.out.println("***ENTER DATA TO UPDATE.***");
                System.out.println("***LEAVE IT BLANK IF YOU DON'T WANT TO CHANGE.***");
                System.out.print("Please enter Hotel's name: ");
                String name = sc.nextLine();
                if (!a.checkBlank(name)) {
                    listOfHotel.get(i).setHotel_Name(name);
                }else if(a.checkBlank(name)){
                    listOfHotel.get(i).getHotel_Name();
                }
                System.out.print("Please enter Hotel's address: ");
                String addr = sc.nextLine();
                if (!a.checkBlank(addr)) {
                    listOfHotel.get(i).setHotel_Address(addr);
                }else if (a.checkBlank(addr)){
                    listOfHotel.get(i).getHotel_Address();
                }
                System.out.print("Please enter Hotel's Room available: ");
                boolean check = false;
                do{
                    int r = -1;                
                    try{
                        String input = sc.nextLine();
                        r = Integer.parseInt(input);
                    }catch(NumberFormatException e){
                        r = -1;
                    }if(r != -1){
                        if(a.checkMinMax(r, 0, 99)){
                            listOfHotel.get(i).setHotel_Room_Available(r);
                            check = true;
                        }
                    }else if(r == -1){
                        listOfHotel.get(i).getHotel_Room_Available();
                        check = true;
                    }
                }while(false);                    
                System.out.print("Please enter Hotel's phone: ");
                String p = sc.nextLine();
                if (!a.checkBlank(p)) {
                    listOfHotel.get(i).setHotel_Phone(p);
                }else if (a.checkBlank(p)){
                    listOfHotel.get(i).getHotel_Phone();
                }               
                System.out.print("Please enter Hotel's Rating: ");
                String rate = sc.nextLine();
                if (!a.checkBlank(rate)) {
                    listOfHotel.get(i).setHotel_Rating(rate);
                }else if (a.checkBlank(rate)){
                    listOfHotel.get(i).getHotel_Rating();
                }                
                System.out.println("Update successfully");
            }
        }
        if (flag == false) {
            System.out.println("Hotel does not existed !");
        }
        writeFile();
    }

    public void F4_DeleteHotel() {
        String id = a.inputID();
        boolean flag = false;
        for (int i = 0; i < listOfHotel.size(); i++) {
            if (id.equalsIgnoreCase(listOfHotel.get(i).getHotel_ID())) {
                flag = true;
                System.out.println("Do you ready to delete this hotel ?(1 = yes || 2 = no)");
                String r = sc.nextLine();
                if (r.equals("1")) {
                    listOfHotel.remove(listOfHotel.get(i));
                    System.out.println("Delete successfully !");
                } else {
                    System.out.println("Return to main menu !");
                }
            }
        }
        if (flag == false) {
            System.out.println("Hotel not existed !");
        }
        writeFile();
    }

    public void F5_searchByID() {
        String id = a.inputID();
        boolean flag = false;
        for (int i = 0; i < listOfHotel.size(); i++) {
            if (id.equalsIgnoreCase(listOfHotel.get(i).getHotel_ID())) {
                flag = true;
                System.out.println(listOfHotel.get(i));
                break;
            }
        }
        if (flag == false) {
            System.out.println("Hotel not existed !");
        }
    }

    public void F5_searchByName() {
        String name = a.inputHotel_Name();
        boolean flag = false;
        for (int i = 0; i < listOfHotel.size(); i++) {
            if (name.equalsIgnoreCase(listOfHotel.get(i).getHotel_Name())) {
                flag = true;
                System.out.println(listOfHotel.get(i));
            }
        }
        if (flag == false) {
            System.out.println("Hotel not existed !");
        }
    }
}
