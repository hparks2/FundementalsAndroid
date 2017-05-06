package com.harrisonparks.project3;


public interface ITask {
    String getTitle();
    void setTitle(String title);

    String getDescription();
    void setDescription(String description);

    int getPriority();
    void setPriority(int priority);
}
