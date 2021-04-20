package com.company;

import java.util.*;

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

    }

}
