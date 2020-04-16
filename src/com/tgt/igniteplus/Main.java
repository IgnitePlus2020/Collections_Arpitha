package com.tgt.igniteplus;

import java.util.*;

public class Main {
   public static Map<String, List<IgniteMembers>> map = new HashMap<>();

    //   A method to display all the departments.
    public static void DisplayDepartment() {

        System.out.println("Displaying all the departments------ ");
        System.out.println("The Departments are : ");

        for (String key : map.keySet())
            System.out.println(key);

        System.out.println("---------------------------------------------");

    }

    //  A method to create a new department.
    public static void CreateDepartment() {

        Scanner in = new Scanner(System.in);
        System.out.println("Creating a new department-------- ");
        System.out.println("Enter the name of the new department ");
        String new_department = in.nextLine();

        //check if department already exists.
        if(map.containsKey(new_department)) {
            System.out.println("Department already exists.");
            return;
        }

        //if new department is being created.
        System.out.println("Adding the new department-------- ");
        List<IgniteMembers> ignite = new ArrayList<>();
        map.put(new_department, ignite);
        System.out.println("New department added. ");
        System.out.println("---------------------------------------------");

    }

    //  A method to delete a department.
    public static void DeleteDepartment() {

        Scanner in = new Scanner(System.in);
        System.out.println("Deleting a department-------- ");
        System.out.println("Enter the name of the department to be deleted ");
        String department = in.nextLine();
        System.out.println("Deleting the department-------- ");
        map.remove(department);
        System.out.println("Department deleted. ");
        System.out.println("---------------------------------------------");

    }

    //  A method to display all the members in all departments.
    public static void DisplayAllMembers() {

        System.out.println("Displaying all the members in each department-------- ");

        for (String dept : map.keySet()) {
            System.out.println("---------------------------------------------");
            System.out.println("Department : " + dept);
            for (IgniteMembers im : map.get(dept))
                System.out.println(im.getName());
            System.out.println("---------------------------------------------");
        }

        System.out.println("---------------------------------------------");

    }

    //  A method to add a new member.
    public static void AddMember() {

        Scanner in = new Scanner(System.in);

        System.out.println("Adding new member--------- ");
        System.out.println("Choose the department of the new member");

        //Display of existing departments for the user to choose department of new member.
        int dept_count = 1;
        for (String dept : map.keySet()) {
            System.out.println(dept_count + ". " + dept);
            dept_count++;
        }
        String department = null;
        int deptChoice = in.nextInt();
        int k = 1;
        for (String dept : map.keySet()) {
            if (k == deptChoice) {
                department = dept;
                break;
            }
            k++;
        }

        in.nextLine();
        String name;
        int flag;
        //  Taking details of the member.
        //  The member name must be unique.
        do {
            flag = 0;
            System.out.println("Enter the name of the member");
            name = in.nextLine();
            for (String dept : map.keySet()) {
                for (IgniteMembers im : map.get(dept)) {
                    if (im.getName().contains(name)) {
                        System.out.println("Name already exists.Enter unique name. ");
                        flag = 1;
                    }
                }
            }

        } while (flag == 1);

        System.out.println("Enter the age of the member");
        int age = in.nextInt();
        in.nextLine();
        System.out.println("Enter the name of college of the member");
        String college = in.nextLine();
        System.out.println("Enter the skills of the member and done after entering");
        Set<String> skills = new HashSet<>();
        String skill;
        while (!(skill = in.nextLine()).equalsIgnoreCase("done")) {
            skills.add(skill);
        }


        System.out.println("Adding the new member to "+department+"--------");
        List<IgniteMembers> IgniteMember = map.get(department);
        IgniteMember.add(new IgniteMembers(name, age, college, skills));
        System.out.println("Member added.");
        System.out.println("---------------------------------------------");
    }

    //  A method to Swap a member from original department to another.
    public static void SwapAMember() {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of the member to be swapped");
        String name = in.nextLine();

        String old_department = "";

        //  Getting old department name of the member to be swapped.
        int index = -1;
        for (String dept : map.keySet()) {
            index = 0;
            for (IgniteMembers im : map.get(dept)) {
                if (im.getName().compareTo(name) == 0) {
                    old_department = dept;
                    break;
                }
                index++;
            }
        }
        //  to check if member exists.
        if (old_department.equals("")) {
            System.out.println("member does not exist to swap.");
            return;
        }

        System.out.println("Choose the department of the new member");
        //  Display of departments for the user to choose the new department of the member.
        int dept_count = 1;
        for (String dept : map.keySet()) {
            System.out.println(dept_count + ". " + dept);
            dept_count++;
        }

        String new_department = null;
        int deptChoice = in.nextInt();
        int k = 1;
        for (String dept : map.keySet()) {
            if (k == deptChoice) {
                new_department = dept;
                break;
            }
            k++;
        }

        System.out.println("Swapping the member-------- ");
        List<IgniteMembers> igniteMembers1 = map.get(old_department);
        List<IgniteMembers> igniteMembers2 = map.get(new_department);
        igniteMembers2.add(new IgniteMembers(igniteMembers1.get(index)));
        igniteMembers1.remove(index);
        System.out.println("Done swapping the member. ");

        System.out.println("---------------------------------------------");

    }

    //  A method to add skill set to a particular department members.
    public static void AddSkillSet() {

        Scanner in = new Scanner(System.in);
        System.out.println("Choose the department");
        //  Displaying all the department names for the user to choose.
        int dept_count = 1;
        for (String dept : map.keySet()) {
            System.out.println(dept_count + ". " + dept);
            dept_count++;
        }

        String department = null;
        int deptChoice = in.nextInt();
        int k = 1;
        for (String dept : map.keySet()) {
            if (k == deptChoice) {
                department = dept;
                break;
            }
            k++;
        }

        // Taking input of all the skills to be added to a department.
        System.out.println("Enter the skillset to be added to members of " + department + " and done after entering");
        Set<String> skills1 = new HashSet<>();
        String skill1;
        while (!(skill1 = in.next()).equalsIgnoreCase("done")) {
            skills1.add(skill1);
        }


        System.out.println("Adding Skillset to the department-------- ");
        List<IgniteMembers> ignitemembers = map.get(department);
        for (IgniteMembers im : ignitemembers)
            im.getSkillSet().addAll(skills1);
        System.out.println("Done Adding Skillset. ");

        System.out.println("---------------------------------------------");

    }

    //  A method to list members with particular skill.
    public static void ListMembers_SkillWise() {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the skill");
        String Skill = in.next();

        System.out.println("Listing members with skill : "+Skill);
        System.out.println("Department\t\t\tName");
        for (String department : map.keySet()) {
            for (IgniteMembers im : map.get(department))
                if(im.getSkillSet().contains(Skill))
                    System.out.println(department + "\t\t" + im.getName());
        }
        System.out.println("Done listing. ");
        System.out.println("---------------------------------------------");

    }

//--------------------------------------------------------------------------------------------------------------------//

    public static void main(String[] args) {
	// write your code here

        // Creating a list of members of datascience department.
        List<IgniteMembers> datascience = new ArrayList<>();

        Set<String> SkillSet1 = new HashSet<>();
        SkillSet1.add("java");
        SkillSet1.add("sql");
        SkillSet1.add("ds");

        //Adding member gautham to datascience list.
        datascience.add(new IgniteMembers("gautham",28, "vtu", SkillSet1));

        Set<String> SkillSet2 = new HashSet<>();
        SkillSet2.add("java");
        SkillSet2.add("nosql");
        SkillSet2.add("ml");

        //Adding member divya to datascience list.
        datascience.add(new IgniteMembers("divya", 26, "tgt", SkillSet2));

        //Adding to map with key containing department name "data science" and value containing the list of members.
        map.put("data science", datascience );

        // Creating a list of members of infrastructure department.
        List<IgniteMembers> infrastructure = new ArrayList<>();

        Set<String> SkillSet3 = new HashSet<>();
        SkillSet3.add("linux");
        SkillSet3.add("psql");
        SkillSet3.add("scripting");

        //Adding member amit to infrastructure list.
        infrastructure.add(new IgniteMembers("amit",25, "tmt", SkillSet3));

        Set<String> SkillSet4 = new HashSet<>();
        SkillSet4.add("chef");
        SkillSet4.add("react");
        SkillSet4.add("ai");

        //Adding member naveen to infrastructure list.
        infrastructure.add(new IgniteMembers("naveen", 22, "dojo", SkillSet4));

        //Adding to map with key containing department name "infrastructure" and value containing the list of members.
        map.put("infrastructure", infrastructure );

        Scanner in = new Scanner(System.in);
        int option;

        do {
            //  Displaying Menu.
            System.out.println("Choose the Option : \n" +
                    "1. Display the Departments \n " +
                    "2. Create new Department \n " +
                    "3. Delete a department \n " +
                    "4. Display all members in each department \n " +
                    "5. Create a member and add him to a dept \n " +
                    "6. Swapping members from one department to another department \n " +
                    "7. Adding skill set to a department \n " +
                    "8. Display the members having a particular skill " );

            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    DisplayDepartment();
                    break;
                case 2:
                    CreateDepartment();
                    break;
                case 3:
                    DeleteDepartment();
                    break;
                case 4:
                    DisplayAllMembers();
                    break;
                case 5:
                    AddMember();
                    break;
                case 6:
                    SwapAMember();
                    break;
                case 7:
                    AddSkillSet();
                    break;
                case 8:
                    ListMembers_SkillWise();
                    break;
                default:
                    System.out.println("Invalid choice.");
                    System.exit(1);
            }

            System.out.println("Do you wanna continue?Press 0 for No and 1 for Yes");
            option = in.nextInt();

        } while (option == 1);
        in.close();
    }
}
//-------------------------------------------------------------------------------------------------------------------//
/*  OUTPUT
Choose the Option :
1. Display the Departments
 2. Create new Department
 3. Delete a department
 4. Display all members in each department
 5. Create a member and add him to a dept
 6. Swapping members from one department to another department
 7. Adding skill set to a department
 8. Display the members having a particular skill
1
Displaying all the departments------
The Departments are :
data science
infrastructure
---------------------------------------------
Do you wanna continue?Press 0 for No and 1 for Yes
1
Choose the Option :
1. Display the Departments
 2. Create new Department
 3. Delete a department
 4. Display all members in each department
 5. Create a member and add him to a dept
 6. Swapping members from one department to another department
 7. Adding skill set to a department
 8. Display the members having a particular skill
2
Creating a new department--------
Enter the name of the new department
security
Adding the new department--------
New department added.
---------------------------------------------
Do you wanna continue?Press 0 for No and 1 for Yes
1
Choose the Option :
1. Display the Departments
 2. Create new Department
 3. Delete a department
 4. Display all members in each department
 5. Create a member and add him to a dept
 6. Swapping members from one department to another department
 7. Adding skill set to a department
 8. Display the members having a particular skill
1
Displaying all the departments------
The Departments are :
security
data science
infrastructure
---------------------------------------------
Do you wanna continue?Press 0 for No and 1 for Yes
1
Choose the Option :
1. Display the Departments
 2. Create new Department
 3. Delete a department
 4. Display all members in each department
 5. Create a member and add him to a dept
 6. Swapping members from one department to another department
 7. Adding skill set to a department
 8. Display the members having a particular skill
3
Deleting a department--------
Enter the name of the department to be deleted
security
Deleting the department--------
Department deleted.
---------------------------------------------
Do you wanna continue?Press 0 for No and 1 for Yes
1
Choose the Option :
1. Display the Departments
 2. Create new Department
 3. Delete a department
 4. Display all members in each department
 5. Create a member and add him to a dept
 6. Swapping members from one department to another department
 7. Adding skill set to a department
 8. Display the members having a particular skill
1
Displaying all the departments------
The Departments are :
data science
infrastructure
---------------------------------------------
Do you wanna continue?Press 0 for No and 1 for Yes
1
Choose the Option :
1. Display the Departments
 2. Create new Department
 3. Delete a department
 4. Display all members in each department
 5. Create a member and add him to a dept
 6. Swapping members from one department to another department
 7. Adding skill set to a department
 8. Display the members having a particular skill
4
Displaying all the members in each department--------
---------------------------------------------
Department : data science
gautham
divya
---------------------------------------------
---------------------------------------------
Department : infrastructure
amit
naveen
---------------------------------------------
---------------------------------------------
Do you wanna continue?Press 0 for No and 1 for Yes
1
Choose the Option :
1. Display the Departments
 2. Create new Department
 3. Delete a department
 4. Display all members in each department
 5. Create a member and add him to a dept
 6. Swapping members from one department to another department
 7. Adding skill set to a department
 8. Display the members having a particular skill
5
Adding new member---------
Choose the department of the new member
1. data science
2. infrastructure
1
Enter the name of the member
ajay
Enter the age of the member
25
Enter the name of college of the member
nit
Enter the skills of the member and done after entering
java
ai
done
Adding the new member to data science--------
Member added.
---------------------------------------------
Do you wanna continue?Press 0 for No and 1 for Yes
1
Choose the Option :
1. Display the Departments
 2. Create new Department
 3. Delete a department
 4. Display all members in each department
 5. Create a member and add him to a dept
 6. Swapping members from one department to another department
 7. Adding skill set to a department
 8. Display the members having a particular skill
5
Adding new member---------
Choose the department of the new member
1. data science
2. infrastructure
2
Enter the name of the member
kavya
Enter the age of the member
30
Enter the name of college of the member
mit
Enter the skills of the member and done after entering
java
nosql
done
Adding the new member to infrastructure--------
Member added.
---------------------------------------------
Do you wanna continue?Press 0 for No and 1 for Yes
1
Choose the Option :
1. Display the Departments
 2. Create new Department
 3. Delete a department
 4. Display all members in each department
 5. Create a member and add him to a dept
 6. Swapping members from one department to another department
 7. Adding skill set to a department
 8. Display the members having a particular skill
4
Displaying all the members in each department--------
---------------------------------------------
Department : data science
gautham
divya
ajay
---------------------------------------------
---------------------------------------------
Department : infrastructure
amit
naveen
kavya
---------------------------------------------
---------------------------------------------
Do you wanna continue?Press 0 for No and 1 for Yes
1
Choose the Option :
1. Display the Departments
 2. Create new Department
 3. Delete a department
 4. Display all members in each department
 5. Create a member and add him to a dept
 6. Swapping members from one department to another department
 7. Adding skill set to a department
 8. Display the members having a particular skill
6
Enter the name of the member to be swapped
kavya
Choose the department of the new member
1. data science
2. infrastructure
1
Swapping the member--------
Done swapping the member.
---------------------------------------------
Do you wanna continue?Press 0 for No and 1 for Yes
1
Choose the Option :
1. Display the Departments
 2. Create new Department
 3. Delete a department
 4. Display all members in each department
 5. Create a member and add him to a dept
 6. Swapping members from one department to another department
 7. Adding skill set to a department
 8. Display the members having a particular skill
6
Enter the name of the member to be swapped
ajay
Choose the department of the new member
1. data science
2. infrastructure
2
Swapping the member--------
Done swapping the member.
---------------------------------------------
Do you wanna continue?Press 0 for No and 1 for Yes
1
Choose the Option :
1. Display the Departments
 2. Create new Department
 3. Delete a department
 4. Display all members in each department
 5. Create a member and add him to a dept
 6. Swapping members from one department to another department
 7. Adding skill set to a department
 8. Display the members having a particular skill
4
Displaying all the members in each department--------
---------------------------------------------
Department : data science
gautham
divya
kavya
---------------------------------------------
---------------------------------------------
Department : infrastructure
amit
naveen
ajay
---------------------------------------------
---------------------------------------------
Do you wanna continue?Press 0 for No and 1 for Yes
1
Choose the Option :
1. Display the Departments
 2. Create new Department
 3. Delete a department
 4. Display all members in each department
 5. Create a member and add him to a dept
 6. Swapping members from one department to another department
 7. Adding skill set to a department
 8. Display the members having a particular skill
7
Choose the department
1. data science
2. infrastructure
2
Enter the skillset to be added to members of infrastructure and done after entering
ruby
javascript
done
Adding Skillset to the department--------
Done Adding Skillset.
---------------------------------------------
Do you wanna continue?Press 0 for No and 1 for Yes
1
Choose the Option :
1. Display the Departments
 2. Create new Department
 3. Delete a department
 4. Display all members in each department
 5. Create a member and add him to a dept
 6. Swapping members from one department to another department
 7. Adding skill set to a department
 8. Display the members having a particular skill
8
Enter the skill
ruby
Listing members with skill : ruby
Department			Name
infrastructure		amit
infrastructure		naveen
infrastructure		ajay
Done listing.
---------------------------------------------
Do you wanna continue?Press 0 for No and 1 for Yes
1
Choose the Option :
1. Display the Departments
 2. Create new Department
 3. Delete a department
 4. Display all members in each department
 5. Create a member and add him to a dept
 6. Swapping members from one department to another department
 7. Adding skill set to a department
 8. Display the members having a particular skill
8
Enter the skill
java
Listing members with skill : java
Department			Name
data science		gautham
data science		divya
data science		kavya
infrastructure		ajay
Done listing.
---------------------------------------------
Do you wanna continue?Press 0 for No and 1 for Yes
0

Process finished with exit code 0
 */