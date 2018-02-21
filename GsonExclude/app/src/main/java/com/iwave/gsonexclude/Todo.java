package com.iwave.gsonexclude;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

/**
 * Created by user on 2/21/2018.
 */
class Todo {


    private PropertyChangeSupport changes = new PropertyChangeSupport(this);


    public static final String FIELD_ID = "Id";

    public static final String FIELD_SUMMARY = "Summary";

    public static final String FIELD_DESCRIPTION = "Description";

    public static final String FIELD_DONE = "Done";

    public static final String FIELD_DUEDATE = "DueDate";

    public final long mId;
    private String mSummary ="" ;
    private String mDescription ="";
    private boolean mDone = false;
    private Date mDueDate;

    public Todo(long i) {
        mId = i;
    }

    public Todo(long i, String summary, String description, boolean b, Date date) {
        this.mId = i;
        this.mSummary = summary;
        this.mDescription = description;
        this.mDone = b;
        this.mDueDate = date;
    }



    public long getId() {
        return mId;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        changes.firePropertyChange(FIELD_SUMMARY, this.mSummary,
                this.mSummary = summary);
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        changes.firePropertyChange(FIELD_DESCRIPTION, this.mDescription,
                this.mDescription = description);
    }

    public boolean isDone() {
        return mDone;
    }

    public void setDone(boolean isDone) {
        changes.firePropertyChange(FIELD_DONE, this.mDone, this.mDone = isDone);
    }

    public Date getDueDate() {
        return mDueDate;
    }

    public void setDueDate(Date dueDate) {
        changes.firePropertyChange(FIELD_DUEDATE, this.mDueDate,
                this.mDueDate = dueDate);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (mId ^ (mId >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Todo other = (Todo) obj;
        if (mId != other.mId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Todo [id=" + mId + ", summary=" + mSummary + "]";
    }

    public Todo copy() {
        return new Todo(mId, mSummary, mDescription, mDone, mDueDate);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        changes.removePropertyChangeListener(l);
    }
}