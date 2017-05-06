package com.harrisonparks.project3;

public class Task implements Comparable<Task>{

    private String title;
    private String description;
    private int priority;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }


    @Override
    public int compareTo(Task o) {

        if (this.getPriority() > o.getPriority())
        {
            return 1;
        }
        else if (this.getPriority() < o.getPriority())
        {
            return -1;
        }
        else
        {
            return this.getTitle().compareTo(o.getTitle());
        }

    }
}
