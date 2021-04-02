public class Finder {

    int binaryComparison = 0;
    public int sequentialSearch(Person[] allPeople, String searchName) {
            int location = -1;
            for (int i = 0; i < allPeople.length; i++) {
                if (allPeople[i].getName().equals(searchName)) {
                    location = i;
                    break;
                }
            }
            if (location == -1) {
                System.out.println("The name you entered does not exist!\n");
                System.out.println("Number of comparisons: " + allPeople.length);
            } else {
                System.out.println(allPeople[location] + "\n");
                System.out.println("The number of comparisons: " + (location+1) + "\n");
            }
        return location;
    }

    public int binarySearch(Person[] allPeople, String searchName) {
        int location = -1;
        int right = allPeople.length - 1;
        while (location <= right) {
            int middle = location + (right - location) / 2;
            int check = searchName.compareTo(allPeople[middle].getName());
            if (check == 0) {
                location = middle;
                binaryComparison++;
                return location;
            }
            if (check > 0) {
                location = middle + 1;
                binaryComparison++;
            }else {
                right = middle - 1;
                binaryComparison++;
            }

        }
        return location;
    }

    public void binaryPrint(Person[] allPeople, int location){
        if (location == -1){
            System.out.println("The name you entered does not exist!\n");
            System.out.println("Number of comparisons: " + binaryComparison);
        }else{
            System.out.println(allPeople[location] + "\n");
            System.out.println("The number of comparisons: " + (binaryComparison) + "\n");
        }
    }

    public Person[] printAlphabetically(Person[] allPeople, int totalStudents) {
        for (int i = 0; i < totalStudents; i++) {
            int index = i;
            String name = allPeople[i].getName();
            for (int y = i + 1; y < totalStudents; y++) {
                if (allPeople[y].getName().compareTo(name) < 0) {
                    name = allPeople[y].getName();
                    index = y;
                }
            }
            if (index != i) {
                Person sorted = allPeople[index];
                allPeople[index] = allPeople[i];
                allPeople[i] = sorted;
            }
        }
        return allPeople;
    }

}
