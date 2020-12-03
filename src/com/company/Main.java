package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> citiesToVisit = new LinkedList<>();
        addCityInOrder(citiesToVisit, "Tampa");
        addCityInOrder(citiesToVisit, "Daytona");
        addCityInOrder(citiesToVisit, "Miami");
        addCityInOrder(citiesToVisit, "Orlando");

        addCityInOrder(citiesToVisit, "Jacksonville");
        addCityInOrder(citiesToVisit, "Tampa");
        addCityInOrder(citiesToVisit, "Z");
        searchCitiesList(citiesToVisit);





    }
    private static void printList(LinkedList<String> linkedList){
        for (String s : linkedList) {
            System.out.println("Now visiting " + s);
        }
        System.out.println("===============================");
    }
    //create method to add city in order
    private static boolean addCityInOrder(LinkedList<String> linkedList, String newCity){
        //using listiterator for more flexibility
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()){
            //getting the value from compareTo function
            int comparison = stringListIterator.next().compareTo(newCity);

            //we add multiple conditional statements
            if (comparison == 0){
                //means the the city already in list
                System.out.println("The city already added as destination.");
                return false;
            }else if (comparison > 0){
                // we need to go back to previous city in the list first
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }else if (comparison < 0){
                //we need to compare new city to the next city in the list
                //move to next city
            }
        }
        //if value is not equal to anything then we need to add it to the end of the list
        stringListIterator.add(newCity);
        return true;
    }

    private static void searchCitiesList(LinkedList<String > cities){
        Scanner scanner = new Scanner(System.in);
        ListIterator<String> listIterator = cities.listIterator();
        boolean quit = false;
        boolean goingForward = true;
        if (cities.isEmpty()){
            System.out.println("The list is empty.");
        }else {
            System.out.println("Now visiting " + listIterator.next());
            printMenue();
        }
        while (!quit){
            int options = scanner.nextInt();
            scanner.nextLine();

            switch (options){
                case 0:
                    System.out.println("You have exited the list.");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now visiting " + listIterator.next());
                    }else {
                        System.out.println("Reached the end of the list.");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now visiting " + listIterator.previous());
                    }else {
                        System.out.println("Reach the start of the list.");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenue();
                    break;
                default:
                    System.out.println("This option is not available.");
            }
        }
    }
    private static void printMenue(){
        System.out.println("Available options: \n" +
                "*: Press 1 to go forward in the list.\n" +
                "*: Press 2 to move backward in the list.\n" +
                "*: Press 3 to print the options menu again.\n" +
                "*: Press 0 to quit the program.");
    }
}
