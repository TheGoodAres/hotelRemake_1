package com.company;

import java.util.*;

public class Room
{
    static Scanner in = new Scanner(System.in);
    private int numberOfGuests;
    Person guest = new Person();

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }
    public void setNumberOfGuests()
    {
        boolean loop = true;
        int numGuests = 0;
        do
        {

            try{
                System.out.print("PLease enter the number of guests in the room(1-5): ");
                String Guests = in.next();
                numGuests = Integer.parseInt(Guests);
                if (numGuests <1 || numGuests >5)
                {
                    System.out.println("Please try again");
                }
                else
                {
                    loop = false;
                }

            }
            catch (NumberFormatException | InputMismatchException a){
                System.out.println("Please enter a number between 1 an 5!");
            }
        } while (loop);

        this.numberOfGuests = numGuests;
    }
    public void setFirstName(String firstName)
    {
        guest.setFirstName(firstName);
    }
    public void setLastName(String lastName)
    {
        guest.setLastName(lastName);
    }
    public void setCardNumber(long cardNumber)
    {
        guest.setCardNumber(cardNumber);
    }
    public void setFirstName()
    {
        guest.setFirstName();
    }
    public void setLastName()
    {
        guest.setLastName();
    }
    public void setCardNumber()
    {
        guest.setCardNumber();
    }
    public String getFirstName()
    {
        return guest.getFirstName();
    }
    public String getLastName()
    {
        return guest.getLastName();
    }
    public long getCardNumber()
    {
        return guest.getCardNumber();
    }
    public int getNumberOfGuests () {
        return numberOfGuests;
    }
    public void delete()
    {
        guest.delete();
    }
    public void add() {
        setFirstName();
        setLastName();
        setCardNumber();
    }

}
