package com.iwave.gson;


public class Task {
    private long mId;
    private String mSummary;
    private String mDescription;
    private Status mStatus;
    private int mPriority;

    public enum Status {
        CREATED, ASSIGNED, CANCELED, COMPLETED
    }

    public Task(long id, String summary, String description, Status status, int priority) {
        this.mId = id;
        this.mSummary = summary;
        this.mDescription = description;
        this.mStatus = status;
        this.mPriority = priority;
    }

    public long getId() {
        return mId;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        this.mSummary = summary;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        this.mStatus = status;
    }

    public int getPriority() {
        return mPriority;
    }

    public void setPriority(int priority) {
        this.mPriority = priority;
    }

    @Override
    public String toString() {
        return "Task [id=" + mId + ", summary=" + mSummary + ", description=" + mDescription + ", status=" + mStatus
                + ", priority=" + mPriority + "]";
    }

}