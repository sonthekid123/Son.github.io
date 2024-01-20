
package thehotelmanagement;

public class Hotel {
    private String hotel_ID;
    private String hotel_Name;
    private int hotel_Room_Available;
    private String hotel_Address;
    private String hotel_Phone;
    private String hotel_Rating;
    
    public Hotel(){}

    public Hotel(String hotel_ID, String hotel_Name, int hotel_Room_Available, String hotel_Address, String hotel_Phone, String hotel_Rating) {
        this.hotel_ID = hotel_ID;
        this.hotel_Name = hotel_Name;
        this.hotel_Room_Available = hotel_Room_Available;
        this.hotel_Address = hotel_Address;
        this.hotel_Phone = hotel_Phone;
        this.hotel_Rating = hotel_Rating;
    }

    public String getHotel_ID() {
        return hotel_ID;
    }

    public void setHotel_ID(String hotel_ID) {
        this.hotel_ID = hotel_ID;
    }

    public String getHotel_Name() {
        return hotel_Name;
    }

    public void setHotel_Name(String hotel_Name) {
        this.hotel_Name = hotel_Name;
    }

    public int getHotel_Room_Available() {
        return hotel_Room_Available;
    }

    public void setHotel_Room_Available(int hotel_Room_Available) {
        this.hotel_Room_Available = hotel_Room_Available;
    }

    public String getHotel_Address() {
        return hotel_Address;
    }

    public void setHotel_Address(String hotel_Address) {
        this.hotel_Address = hotel_Address;
    }

    public String getHotel_Phone() {
        return hotel_Phone;
    }

    public void setHotel_Phone(String hotel_Phone) {
        this.hotel_Phone = hotel_Phone;
    }

    public String getHotel_Rating() {
        return hotel_Rating;
    }

    public void setHotel_Rating(String hotel_Rating) {
        this.hotel_Rating = hotel_Rating;
    }

    @Override
    public String toString() {
        return "Hotel{" + "hotel_ID=" + hotel_ID + ", hotel_Name=" + hotel_Name + ", hotel_Room_Available=" + hotel_Room_Available + ", hotel_Address=" + hotel_Address + ", hotel_Phone=" + hotel_Phone + ", hotel_Rating=" + hotel_Rating + '}';
    }
    
}
