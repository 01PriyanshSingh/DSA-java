
/*

✅ Java Programming Question 2: Photographer

Problem Statement:
Create a Java program to manage photographers, with functionality to:
1. Count photographers by specialization.
2. Find the second highest rated photographer.

📌 Requirements:

1. Create a class Photographer with these attributes:
- id (int)
- name (String)
- specialization (String)
- rating (double)

Include:
- A parameterized constructor (in the order above),
- Getters and Setters for all attributes.

2. Create a class Solution with a main method.

Inside Solution, implement these two static methods:

a. countPhotographersBySpecialization(Photographer[] arr, String specialization)
- Takes an array of Photographer objects and a specialization string (case-insensitive).
- Returns the count of photographers whose specialization matches.
- Return 0 if none match.

b. getSecondHighestRatedPhotographer(Photographer[] arr)
- Returns the Photographer with the second highest rating.
- If multiple photographers have the same rating, return the one that appears first in the input.
- If fewer than two unique ratings exist, return null.

🔄 Input and Output:

From main:
- Read inputs for all attributes.
- Call countPhotographersBySpecialization() and print:
  - Number of photographers in <specialization>: <value> if count > 0
  - No photographers found for the given specialization if count is 0

- Then call getSecondHighestRatedPhotographer() and print:
  - If a photographer is found:
    id-<id>
    name-<name>
    specialization-<specialization>
    rating-<rating>
  - If not found:
    Second highest rated photographer not available

📘 Notes:
- Use case-insensitive comparison for specialization.
- Preserve input order when resolving ties.

📥 Sample Input 1:
4
101
Meera
Wildlife
4.1
102
Raj
Portrait
4.2
103
Anita
wildlife
4.5
104
Veer
Fashion
4.8
Wildlife

📤 Sample Output 1:
Number of photographers in Wildlife: 2
id-103
name-Anita
specialization-wildlife
rating-4.5

📥 Sample Input 2:
4
101
Meera
Wildlife
4.1
102
Raj
Portrait
4.2
103
Anita
Wildlife
4.5
104
Veer
Fashion
4.8
Home Decor

📤 Sample Output 2:
No photographers found for the given specialization
id-104
name-Veer
specialization-Fashion
rating-4.8

*/

import java.util.Scanner;

public class PhotographerS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Photographer[] arr = new Photographer[sc.nextInt()];
        sc.nextLine(); // clear newline after number input

        for (int i = 0; i < arr.length; i++) {
            int id = Integer.parseInt(sc.nextLine());
            String name = sc.nextLine();
            int experience = Integer.parseInt(sc.nextLine());
            String specialization = sc.nextLine();
            arr[i] = new Photographer(id, name, experience, specialization);
        }

        String searchSpecialization = sc.nextLine();
        int searchId = sc.nextInt();

        double avg = findAverageExperienceBySpecialization(arr, searchSpecialization);
        if (avg > 0) {
            System.out.println("Average experience: " + avg);
        } else {
            System.out.println("No Photographer found with the given specialization.");
        }

        Photographer result = searchPhotographerById(arr, searchId);
        if (result != null) {
            System.out.println("id-" + result.getId());
            System.out.println("name-" + result.getName());
            System.out.println("experience-" + result.getExperience());
            System.out.println("specialization-" + result.getSpecialization());
        } else {
            System.out.println("No Photographer found with the given id.");
        }

        sc.close();
    }

    public static double findAverageExperienceBySpecialization(Photographer[] arr, String specialization) {
        int totalExperience = 0;
        int count = 0;
        for (Photographer p : arr) {
            if (p.getSpecialization().equalsIgnoreCase(specialization)) {
                totalExperience += p.getExperience();
                count++;
            }
        }
        if (count > 0) {
            return (double) totalExperience / count;
        }
        return 0;
    }

    public static Photographer searchPhotographerById(Photographer[] arr, int id) {
        for (Photographer p : arr) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}

class Photographer {
    private int id;
    private String name;
    private int experience;
    private String specialization;

    public Photographer(int id, String name, int experience, String specialization) {
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public String getSpecialization() {
        return specialization;
    }
}
