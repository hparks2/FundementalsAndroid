package com.harrisonparks.project3;

import java.util.Scanner;

public class Main {

    //Menu prompt
    static void mainMenuSetup() {
        System.out.println("Please choose an option:");
        System.out.println("(1) Add a task.");
        System.out.println("(2) Remove a task.");
        System.out.println("(3) Update a task.");
        System.out.println("(4) List all tasks.");
        System.out.println("(5) List all tasks of a specific priority.");
        System.out.println("(6) Sort the tasks based on priority/title.");
        System.out.println("(0) Exit.");
    }

    //For when the user selects a task
    static TaskCollection runSelectedTask(int selectedTask, TaskCollection tasks, Scanner scanner) {
        int index;

        //Execute task based on selected task number
        switch(selectedTask) {
            case 0:
                //Exit the program
                break;
            case 1:
                //Add a task
                tasks = addTask(tasks, scanner);

                break;
            case 2:
                //Remove a task
                System.out.println("Enter the index of the task to remove.");
                try
                {
                    index = Integer.parseInt(scanner.nextLine());
                    tasks.getTasks().remove(index);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Please enter a number.");
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.println("Please pick an index currently in the list.");
                }
                catch (Exception e)
                {
                    System.out.println("An error was encountered, please try again.");
                }
                break;
            case 3:
                //Update a task
                updateTask(tasks, scanner);
                break;
            case 4:
                //List all tasks
                list(tasks);
                break;

            case 5:
                //List tasks of a certain priority
                listByPriority(tasks, scanner);
                break;

            case 6:
                tasks.sort();
                System.out.println("Tasks have been sorted. Listing tasks:");
                list(tasks);
                break;
        }
        return tasks;
    }
    //Menu option for listin1g by priority, also has try catch for when the user enters a letter for the priority.
    //Also, if the user enters a number lower than 0 or greater than 5, it puts it at a 0 if it's lower than 0
    //or it puts it at a 5 if it's greater than 5
    private static void listByPriority(TaskCollection tasks, Scanner scanner) {
        int priority;

        System.out.println("Enter a priority.");

        try {

            priority = Integer.parseInt(scanner.nextLine());

            if (priority < 0)
            {
                priority = 0;
            } else if (priority > 5)
            {
                priority = 5;
            }

            int i = 0;
            for (Task task : tasks)
            {
                if (task.getPriority() == priority) {
                    System.out.println(i + ". " + task.getTitle() + " (Priority " + task.getPriority() + "): " + task.getDescription());
                    i++;
                }
            }

        }
        catch (NumberFormatException e)
        {
            System.out.println("Please enter a number.");
        }
        catch(Exception e)
        {
            System.out.println("An error was encountered, please try again.");
        }

    }
    //For when the user wants to update a task
    private static TaskCollection updateTask(TaskCollection tasks, Scanner scanner) {

        int index;
        Task currentTask = new Task();
        String title;
        String description;
        int priority;

        //Has a try catch for a general error and if the user enters a letter
        try {

            System.out.println("Enter the index of the task to update.");
            index = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter a new title.");
            title = scanner.nextLine();
            currentTask.setTitle(title);

            System.out.println("Enter a new description.");
            description = scanner.nextLine();
            currentTask.setDescription(description);

            System.out.println("Enter a new priority.");
            priority = Integer.parseInt(scanner.nextLine());

            if (priority < 0)
            {
                priority = 0;
            } else if (priority > 5)
            {
                priority = 5;
            }

            currentTask.setPriority(priority);
            tasks.getTasks().set(index, currentTask);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Please enter a number.");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Please pick an index currently in the list.");
        }
        catch(Exception e)
        {
            System.out.println("An error was encountered, please try again.");
        }

        return tasks;
    }
    //Prompt for adding a new task
    private static TaskCollection addTask(TaskCollection tasks, Scanner scanner) {

        Task currentTask = new Task();
        String title;
        String description;
        int priority;


        System.out.println("Enter a title of the new task.");
        title = scanner.nextLine();
        currentTask.setTitle(title);

        System.out.println("Enter a description of the new task.");
        description = scanner.nextLine();
        currentTask.setDescription(description);

        //Has a try catch for the priority incase the user enters a letter instead of a number
        System.out.println("Enter a priority of the new task.");
        try {
            priority = Integer.parseInt(scanner.nextLine());
            if (priority < 0)
            {
                priority = 0;
            } else if (priority > 5)
            {
                priority = 5;
            }
            currentTask.setPriority(priority);

            tasks.getTasks().add(currentTask);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Please enter a number.");
        }
        catch(Exception e)
        {
            System.out.println("An error was encountered, please try again.");
        }

        return tasks;
    }

    //For listing all tasks
    static void list(TaskCollection tasks) {
        int i = 0;
        for (Task task : tasks) {
            System.out.println(i + ". " + task.getTitle() + " (Priority " + task.getPriority() + "): " + task.getDescription());
            i++;
        }

    }
    public static void main(String[] args) {
        //List of tasks
        TaskCollection tasks = new TaskCollection();
        Boolean continueLoop = Boolean.valueOf(true);
        Scanner scanner = new Scanner(System.in);

        //Menu loop
        while(continueLoop.booleanValue()) {
            //List main menu
            mainMenuSetup();

            //Read line
            String input = scanner.nextLine();

            try {
                int selectedTask = Integer.parseInt(input);

                // Perform task
                tasks = runSelectedTask(selectedTask, tasks, scanner);

                //Update continue
                continueLoop = selectedTask != 0;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a number.");
            }
        }
    }
}