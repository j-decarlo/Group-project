package library_system;

import java.sql.Date;

public class Fine {

    private int fineId;
    private int overdueDays;
    private double fineAmount;
    private int returnId;

    private Date returnDay;
    private String bookcopyName;

    public Date getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(Date returnDay) {
        this.returnDay = returnDay;
    }

    public String getBookcopyName() {
        return bookcopyName;
    }

    public void setBookcopyName(String bookcopyName) {
        this.bookcopyName = bookcopyName;
    }

    public int getSetId() {
        return setId;
    }

    public void setSetId(int setId) {
        this.setId = setId;
    }
    
    
    
    public Fine(){}
    
    int setId = 0;

    public Fine(int fineId, int overdueDays, double fineAmount, int returnId) {
        this.fineId = fineId;
        this.overdueDays = overdueDays;
        this.fineAmount = fineAmount;
        this.returnId = returnId;
    }

    public int getFineId() {
        return fineId;
    }

    public void setFineId(int fineId) {
        this.fineId = fineId;
    }

    public int getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(int overdueDays) {
        this.overdueDays = overdueDays;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public int getReturnId() {
        return returnId;
    }

    public void setReturnId(int returnId) {
        this.returnId = returnId;
    }

}