package com.company;

import java.util.*;
public class  Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.print("Welcome to the ENTER_HOTEL_NAME_HERE!\n");
        Hotel hotel = new Hotel();
        String userInput;
        boolean inLoop = true;
        while (inLoop)
        {
            System.out.print("""
                Please enter A to add a new customer to a room, V to view all rooms
                E to view all empty rooms, D to delete customer from room,
                F to find room from customer name, S to store program data into file
                L to load program data from file, O to view guests ordered alphabetically
                or T to terminate the program:""");
            userInput = in.next();

            switch (userInput.toUpperCase())
            {
                case "E" -> displayE(hotel);
                case "A" -> addCustomer(hotel);
                case "V" -> displayAll(hotel);
                case "T" -> inLoop = false;
                case "D" -> deleteCustomer(hotel);
                case "F" -> findCustomer(hotel);
                /*case "O" -> showAlphabetical(hotel);
                case "L" -> readFromFile(hotel);
                case "S" -> writeToFile(hotel);*/
                default -> System.out.println("Please try again!\n");
            }
        }
    }
    static void displayE(Hotel hotel)
    {
        hotel.displayE();
    }
    static void displayAll(Hotel hotel)
    {
        hotel.displayAll();
    }
    static void addCustomer(Hotel hotel)
    {
        hotel.addCustomer();
    }
    static void deleteCustomer(Hotel hotel)
    {
        hotel.deleteCustomer();
    }
    static void findCustomer(Hotel hotel)
    {
        hotel.findCustomer();
    }
}
