package com.company;

import java.util.Scanner;

public class Hotel
{
    final String ADD = "a";
    final String DELETE = "d";
    static Scanner in = new Scanner(System.in);
    final int ROOM_NUMBER = 8;
    private final Room[] rooms = new Room[ROOM_NUMBER];

    public Hotel()
    {
        for(int i = 0; i < this.rooms.length; i++)
        {
            this.rooms[i] = new Room();
        }
    }

    private int userGetRoomNumber(String a)
    {
        int roomNum = 0;
        boolean loop = true;
        do
        {
            System.out.print("PLease enter a room number(1-8 or 9 to cancel): ");
            try {
                roomNum = Integer.parseInt(in.next());
                if (roomNum > 9 || roomNum < 1)
                {
                    System.out.println("Please try again, enter a number between 1 and 8!\n");
                }
                else if(roomNum == 9)
                {
                    loop = false;
                }
                else if(a.equals("a"))
                {

                    if (!rooms[roomNum-1].getFirstName().equals(""))
                    {
                        System.out.println("This room is already occupied, please try another room!");
                    }
                    else
                    {
                        loop = false;
                    }
                }
                else if(a.equals("d"))
                {
                    if (rooms[roomNum-1].getFirstName().equals("e"))
                    {
                        System.out.println("This room is already empty!");
                    }
                    else
                    {
                        loop = false;
                    }
                }
                } catch (NumberFormatException e)
                {
                    System.out.println("Please enter a number between 1 an 8!");
                }
        }
        while (loop);

        return roomNum -1;
    }

    public void displayE()
    {
        for(int i = 0; i < ROOM_NUMBER; i++)
        {
            if(rooms[i].getFirstName().equals(""))
            {
                System.out.printf("Room %d is empty!\n", i+1);
            }
        }
        System.out.println();
    }
    public void displayAll()
    {
        for(int i = 0; i < ROOM_NUMBER; i++)
        {
            String firstName = rooms[i].getFirstName();
            String lastName = rooms[i].getLastName();
            if(rooms[i].getFirstName().equals(""))
            {
                System.out.printf("Room %d is empty!\n", i+1);
            }
            else
            {
                System.out.printf("Room %d is occupied by %s %s!\n", i+1, firstName, lastName);
            }
        }
    }
    public void addCustomer()
    {

        int roomNumber = userGetRoomNumber(ADD);
        if(roomNumber != ROOM_NUMBER)
        {
            rooms[roomNumber].add();
        }
        System.out.println();
    }
    public void deleteCustomer()
    {
        int roomNumber = userGetRoomNumber(DELETE);
        rooms[roomNumber].delete();
    }
    public void findCustomer()
    {
        String firstName = firstName();
        String lastName = lastName();
        boolean found = false;
        for (int i = 0; i < ROOM_NUMBER; i++){
            if(firstName.equals(rooms[i].getFirstName()) && lastName.equals(rooms[i].getLastName())) {
                System.out.printf("%s %s is in room %d.\n", firstName, lastName, i + 1);
                found = true;
                boolean loop = true;
                do {
                    System.out.print("Would you like to see the credit card details for the guest?");
                    String answer = in.next();
                    if (answer.equalsIgnoreCase("yes")) {
                        System.out.println("Card Number: " + rooms[i].getCardNumber());
                        loop = false;
                    }
                    if (answer.equalsIgnoreCase("no")) {
                        loop = false;
                    }
                } while (loop);
            }

        }
        if(!found){
            System.out.println("The guest wasn't found!");
        }
        System.out.println();
    }
    private String firstName()
    {
        String firstName;
        boolean loop = true;
        do
        {
            System.out.print("Please enter the first name of the person:");
            firstName  = in.next();
            if (!(firstName.length() <2) && !firstName.matches(".*\\d.*"))
            {
                loop = false ;
            }
        } while(loop);
        return firstName;
    }
    private String lastName(){
        String lastName;
        boolean loop = true;
        do
        {
            System.out.print("Please enter the last name of the person:");
            lastName  = in.next();
            if (!(lastName.length() <2) && !lastName.matches(".*\\d.*"))
            {
                loop = false ;
            }
        } while(loop);
        return lastName;
    }
}
