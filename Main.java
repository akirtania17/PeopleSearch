import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SearchPrint search = new SearchPrint();
        Person[] allPersons;
        try {
            System.out.println("How many People will you enter?");
            int totalPeople = scanner.nextInt();
            allPersons = new Person[totalPeople];
            for (int i = 0; i < totalPeople; i++) {
                String name;
                System.out.println("Enter Student " + (i + 1) + " name: ");
                scanner.nextLine();
                name = scanner.nextLine();
                name = name.trim();
                System.out.println("Enter Student " + (i + 1) + " age: ");
                int age = scanner.nextInt();
                while (age < 0){
                    System.out.println("Try again");
                    age = scanner.nextInt();
                }
                Person newPerson = new Person(name, age);
                allPersons[i] = newPerson;
            }
            while (true) {
                System.out.println("Enter 1 to sequential search.\nEnter 2 to binary search\nEnter 3 to print all people alphabetically.\nEnter 4 to add a person.\nEnter 0 to stop the program.");
                int userDesire = scanner.nextInt();
                while (userDesire > 4 || userDesire < 0) {
                    System.out.println("Try Again: ");
                    userDesire = scanner.nextInt();
                }
                if (userDesire == 0) {
                    System.out.println("Thank you");
                    System.exit(0);
                } else if (userDesire == 1) {
                    scanner.nextLine();
                    System.out.println("Enter the name you would like to search: ");
                    String searchName = scanner.nextLine();
                    searchName = searchName.trim();
                    int location = search.sequentialSearch(allPersons,searchName);
                    if (location != -1) {
                        System.out.println("Enter 1 to edit name.\nEnter 2 to edit age.\nEnter 3 to delete person.\nEnter 0 to do nothing.");
                        int whatNext = scanner.nextInt();
                        while (whatNext > 3 || whatNext < 0) {
                            System.out.println("Try Again: ");
                            whatNext = scanner.nextInt();
                        }
                        if (whatNext == 1) {
                            scanner.nextLine();
                            System.out.println("What would you like to change it to: ");
                            String newName = scanner.nextLine();
                            allPersons[location].setName(newName);
                        } else if (whatNext == 2) {
                            scanner.nextLine();
                            System.out.println("What would you like to change it to: ");
                            int newAge = scanner.nextInt();
                            while (newAge < 0) {
                                System.out.println("Try again");
                                newAge = scanner.nextInt();
                            }
                                allPersons[location].setAge(newAge);
                        } else if (whatNext == 3) {
                            Person[] newPeople = new Person[totalPeople - 1];
                            if (location == 0) System.arraycopy(allPersons, 1, newPeople, 0, newPeople.length);
                            else if (location == allPersons.length - 1)
                                System.arraycopy(allPersons, 0, newPeople, 0, newPeople.length);
                            else {
                                System.arraycopy(allPersons, 0, newPeople, 0, location);
                                System.arraycopy(allPersons, location + 1, newPeople, location, newPeople.length);
                            }
                            allPersons = new Person[newPeople.length];
                            allPersons = newPeople;
                            totalPeople = allPersons.length;
                        }
                    }
                } else if (userDesire == 2) {
                    scanner.nextLine();
                    System.out.println("Enter the name you would like to search: ");
                    String searchName = scanner.nextLine();
                    searchName = searchName.trim();
                    Person[] temp = new Person[totalPeople];
                    temp = search.printAlphabetically(allPersons, totalPeople);
                    allPersons = new Person[totalPeople];
                    allPersons = temp;
                    int location = search.binarySearch(allPersons,searchName);
                    search.binaryPrint(allPersons, location);
                    if (location != -1) {
                        System.out.println("Enter 1 to edit name.\nEnter 2 to edit age.\nEnter 3 to delete person.\nEnter 0 to do nothing.");
                        int whatNext = scanner.nextInt();
                        while (whatNext > 3 || whatNext < 0) {
                            System.out.println("Try Again: ");
                            whatNext = scanner.nextInt();
                        }
                        if (whatNext == 1) {
                            scanner.nextLine();
                            System.out.println("What would you like to change it to: ");
                            String newName = scanner.nextLine();
                            allPersons[location].setName(newName);
                        } else if (whatNext == 2) {
                            scanner.nextLine();
                            System.out.println("What would you like to change it to: ");
                            int newAge = scanner.nextInt();
                            while (newAge < 0) {
                                System.out.println("Try again");
                                newAge = scanner.nextInt();
                            }
                            allPersons[location].setAge(newAge);
                        } else if (whatNext == 3) {
                            Person[] newPeople = new Person[totalPeople - 1];
                            if (location == 0) System.arraycopy(allPersons, 1, newPeople, 0, newPeople.length);
                            else if (location == allPersons.length - 1)
                                System.arraycopy(allPersons, 0, newPeople, 0, newPeople.length);
                            else if (allPersons.length == 3 && location == 1){
                                newPeople[0] = allPersons[0];
                                newPeople[1] = allPersons[2];
                            } else {
                                System.arraycopy(allPersons, 0, newPeople, 0, location);
                                System.arraycopy(allPersons, location + 1, newPeople, location, newPeople.length);
                            }
                            allPersons = new Person[newPeople.length];
                            allPersons = newPeople;
                            totalPeople = allPersons.length;
                        }
                    }
                } else if (userDesire == 3) {
                    Person[] temp = new Person[totalPeople];
                    temp = search.printAlphabetically(allPersons, totalPeople);
                    allPersons = new Person[totalPeople];
                    allPersons = temp;
                    for (int i = 0; i < totalPeople; i++) System.out.println(allPersons[i] + "\n");
                } else if (userDesire == 4) {
                    System.out.println("How many people will you add?");
                    int newTotalPeople = scanner.nextInt();
                    Person[] temp = new Person[newTotalPeople];
                    for (int i = 0; i < newTotalPeople; i++) {
                        String name;
                        System.out.println("Enter Student " + (i + 1) + " name: ");
                        scanner.nextLine();
                        name = scanner.nextLine();
                        System.out.println("Enter Student " + (i + 1) + " age: ");
                        int age = scanner.nextInt();
                        Person newPerson = new Person(name, age);
                        temp[i] = newPerson;
                    }
                    Person[] newPeople = new Person[totalPeople + newTotalPeople];
                    System.arraycopy(allPersons, 0, newPeople, 0, totalPeople);
                    System.arraycopy(temp, 0, newPeople, totalPeople, newTotalPeople);
                    allPersons = new Person[newPeople.length];
                    allPersons = newPeople;
                    totalPeople = allPersons.length;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Please Enter a valid Integer value! ");
            System.out.println("Program is exiting! ");
            System.exit(0);
        } catch (NullPointerException e) {
            System.out.println("Please Enter a valid Integer value! ");
            System.out.println("Program is exiting! ");
            System.exit(0);
        }
    }
}
