package com.harrisonparks;

import java.util.Scanner;

public class project1 {

    static void mainMenuSetup() {
        System.out.println("Please choose an option:");
        System.out.println("(1) Add a task.");
        System.out.println("(2) Remove a task.");
        System.out.println("(3) Update a task.");
        System.out.println("(4) List all tasks.");
        System.out.println("(0) Exit.");
    }

    static String[] runSelectedTask(int selectedTask, String[] tasks, Scanner scanner) {
        int index;
        String description;

        //Execute task based on selected task number
        switch(selectedTask) {
            case 0:
                //Exit the program
                break;
            case 1:
                //Add a task
                System.out.println("Enter a description of the new task.");
                description = scanner.nextLine();
                tasks = add(tasks, description);
                break;
            case 2:
                //Remove a task
                System.out.println("Enter the index of the task to remove.");
                index = Integer.parseInt(scanner.nextLine());
                tasks = remove(tasks, index);
                break;
            case 3:
                //Update a task
                System.out.println("Enter the index of the task to update.");
                index = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter the new description of the task.");
                description = scanner.nextLine();
                update(tasks, index, description);
                break;
            case 4:
                //List all tasks
                list(tasks);
                break;
        }
        return tasks;
    }

    static String[] add(String[] tasks, String newTask) {
        String[] newTasks = new String[tasks.length + 1];

        for(int i = 0; i < tasks.length; ++i) {
            newTasks[i] = tasks[i];
        }
        newTasks[newTasks.length - 1] = newTask;
        return newTasks;
    }
    static String[] remove(String[] tasks, int index) {
        if(index >= 0 && index < tasks.length) {
            String[] newTasks = new String[tasks.length - 1];
            for(int i = 0; i < tasks.length; ++i) {
                if(i < index) {
                    newTasks[i] = tasks[i];
                } else if(i != index) {
                    newTasks[i - 1] = tasks[i];
                }
            }
            return newTasks;
        } else {
            return tasks;
        }
    }
    static void update(String[] tasks, int index, String newTask) {
        if(index >= 0 && index < tasks.length) {
            tasks[index] = newTask;
        }
    }
    static void list(String[] tasks) {
        for(int i = 0; i < tasks.length; ++i) {
            System.out.println(i + ". " + tasks[i]);
        }

    }
    public static void main(String[] args) {
        //List of tasks
        String[] tasks = new String[0];
        Boolean continueLoop = Boolean.valueOf(true);
        Scanner scanner = new Scanner(System.in);

        //Menu loop
        while(continueLoop.booleanValue()) {
            //List main menu
            mainMenuSetup();

            //Read line
            String input = scanner.nextLine();
            int selectedTask = Integer.parseInt(input);

            // Perform task
            tasks = runSelectedTask(selectedTask, tasks, scanner);

            //Update continue
            continueLoop = selectedTask != 0;

        }

    }

}

