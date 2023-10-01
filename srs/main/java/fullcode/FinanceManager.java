package srs.main.java.fullcode;

import java.util.ArrayList;
import java.util.List;

import srs.main.java.fullcode.Manager.Report;

public class FinanceManager extends user {
    List<Report> reports;

    public FinanceManager(String username, String password) {
        super(username, password);
        this.reports = new ArrayList<>();
    }

    public void authenticate() {
    }

    public void selectRefund(Website website, String refundID) {
        website.getRefundDetails(refundID);
    }

    public void confirmRefund(Website website, String refundID) {
        website.processRefund(refundID);
    }

    public void createReport() {
    }
}
