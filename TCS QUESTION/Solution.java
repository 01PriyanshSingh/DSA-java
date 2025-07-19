/*

✅ Java Programming Question 1: Journalist

Problem Statement:
You need to write a Java program that deals with a class of journalists and performs two key operations:
1. Find the average experience of journalists from a specific region.
2. Search for a journalist by ID.

📌 Requirements:

1. Create a class called Journalist with the following attributes:
- id (int)
- name (String)
- experience (int) – representing number of years
- region (String)

Include:
- A parameterized constructor (in the order above),
- Getters and Setters for all attributes.

2. Create another class called Solution with the main method.

Inside Solution, implement the following two static methods:

a. findAverageExperienceByRegion(Journalist[] arr, String region)
- Accepts an array of Journalist objects and a region string (case-insensitive).
- Returns the average experience of journalists from the specified region.
- If no journalist is found from the region, return 0.

b. searchJournalistById(Journalist[] arr, int id)
- Accepts the array and an ID.
- Returns the Journalist object whose id matches the provided ID.
- If not found, return null.

🔄 Input and Output:

From the main method:
- Read input values for all attributes.
- Call findAverageExperienceByRegion() and print:
  - Average experience:<value> if average > 0
  - No Journalist found from the given region if average is 0

- Then call searchJournalistById() and print:
  - If journalist found:
    id-<id>
    name-<name>
    experience-<experience>
    region-<region>
  - If not found:
    No Journalist found with the given id

📘 Notes:
- All string comparisons must be case-insensitive.
- Print the results directly; do not customize output format.

📥 Sample Input 1:
3
201
Ravi
10
South
202
Leena
6
North
203
Amit
8
South
202

📤 Sample Output 1:
Average experience: 9.0
id-202
name-Leena
experience-6
region-North

📥 Sample Input 2:
3
201
Ravi
10
South
202
Leena
6
North
203
Amit
8
South
209

📤 Sample Output 2:
Average experience: 9.0
No Journalist found with the given id

*/

import java.util.*;

class Journalist {
    private int journalistId;
    private String name;
    private double rating;
    private int salary;

    // Parameterized Constructor
    public Journalist(int journalistId, String name, double rating, int salary) {
        this.journalistId = journalistId;
        this.name = name;
        this.rating = rating;
        this.salary = salary;
    }

    // Getters
    public int getJournalistId() {
        return journalistId;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getSalary() {
        return salary;
    }

    // Setters
    public void setJournalistId(int journalistId) {
        this.journalistId = journalistId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Journalist[] arr = new Journalist[n];

        for (int i = 0; i < n; i++) {
            int journalistId = sc.nextInt();
            sc.nextLine(); // consume newline
            String name = sc.nextLine();
            double rating = sc.nextDouble();
            int salary = sc.nextInt();
            sc.nextLine(); // consume newline
            arr[i] = new Journalist(journalistId, name, rating, salary);
        }

        double inputRating = sc.nextDouble();
        sc.nextLine(); // consume newline
        String searchName = sc.nextLine();

        int avgSalary = findAvgSalaryOfJournalist(arr, inputRating);
        if (avgSalary > 0) {
            System.out.println("Average salary: " + avgSalary);
        } else {
            System.out.println("No Journalist with given rating");
        }

        Journalist found = searchJournalistByName(arr, searchName);
        if (found != null) {
            System.out.println("journalistId=" + found.getJournalistId());
            System.out.println("name=" + found.getName());
            System.out.println("rating=" + found.getRating());
            System.out.println("salary=" + found.getSalary());
        } else {
            System.out.println("Journalist not found");
        }
    }

    public static int findAvgSalaryOfJournalist(Journalist[] arr, double rating) {
        int sum = 0, count = 0;
        for (Journalist j : arr) {
            if (j.getRating() >= rating) {
                sum += j.getSalary();
                count++;
            }
        }
        return (count > 0) ? (sum / count) : 0;
    }

    public static Journalist searchJournalistByName(Journalist[] arr, String name) {
        for (Journalist j : arr) {
            if (j.getName().equalsIgnoreCase(name)) {
                return j;
            }
        }
        return null;
    }
}
