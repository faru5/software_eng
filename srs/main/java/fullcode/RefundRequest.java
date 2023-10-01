package srs.main.java.fullcode;

import java.time.LocalDateTime;

public class RefundRequest {
    String ID;
    student student;
    enrollment enrollment;
    LocalDateTime requestDate;
    String status;

    public RefundRequest(String ID, student student, enrollment enrollment) {
        this.ID = ID;
        this.student = student;
        this.enrollment = enrollment;
        this.requestDate = LocalDateTime.now();
        this.status = "Pending";
    }

    public class RefundRequestDetails {

    }

    public void createRefundRequest(String studentID, String courseID) {
    }

    public RefundRequestDetails getRefundDetails(String refundID) {
        if (this.ID.equals(refundID)) {
            return new RefundRequestDetails();
        }
        return null;
    }
}
