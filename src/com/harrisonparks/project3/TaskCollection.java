package com.harrisonparks.project3;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class TaskCollection implements Iterable<Task> {

    private List<Task> tasks = new ArrayList<>();

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator();
    }

    public void sort()
    {
        Collections.sort(tasks);
    }

}
