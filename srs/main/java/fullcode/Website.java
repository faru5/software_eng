package srs.main.java.fullcode;

import java.util.ArrayList;
import java.util.List;

public class Website {
    user currentUser;
    List<Course> displayedCourses;
    List<RefundRequest> displayedRefunds;
    public List<enrollment> enrollments;
    public List<RefundRequest> refundRequests;
    public List<payment> payments;
    List<Enquiry> enquiries;
    List<Enquiry> openEnquiries;

    public Website() {
        this.enrollments = new ArrayList<>();
        this.refundRequests = new ArrayList<>();
        this.payments = new ArrayList<>();
        this.displayedCourses = new ArrayList<>();
        this.displayedRefunds = new ArrayList<>();
    }

    // authenticate the user logging in
    public boolean authenticate(user user, String username, String password) {
        if (user.authenticate(username, password)) {
            this.currentUser = user;
            return true;
        }
        return false;
    }

    // display enrolled courses
    public void displayEnrolledCourses() {
        if (currentUser instanceof student) {
            displayedCourses = new ArrayList<>();
            for (enrollment enrollment : currentUser.enrollments) {
                displayedCourses.add(enrollment.course);
            }
            System.out.println("Displaying enrolled courses for " + currentUser.username);
        }
    }

    // select course
    public void selectCourse(String courseID) {
        for (enrollment enrollment : enrollments) {
            if (enrollment.course.courseID.equals(courseID)) {
                displayedCourses.add(enrollment.course);
                System.out.println("Course selected: " + courseID);
            }
        }
    }

    // create a refund request
    public void createRefundRequest(String studentID, String courseID, String paymentID) {
        for (enrollment enrollment : enrollments) {
            if (enrollment.cancelenrollment(studentID, courseID)) {
                RefundRequest refundRequest = new RefundRequest(paymentID, enrollment.student, enrollment);
                refundRequests.add(refundRequest);
                System.out.println("Refund request created.");
                return;
            }
        }
        System.out.println("No such enrollment found.");
    }

    // get the refund details of refund request
    public void getRefundDetails(String refundID) {
        for (RefundRequest refundRequest : refundRequests) {
            if (refundRequest.ID.equals(refundID)) {
                System.out.println("Refund request details: " + refundRequest);
                return;
            }
        }
        System.out.println("No such refund request found.");
    }

    // process refund
    public void processRefund(String refundID) {
        for (payment payment : payments) {
            if (payment.paymentID.equals(refundID)) {
                payment.processRefund();
                System.out.println("Refund processed.");
                return;
            }
        }
        System.out.println("No such payment found.");
    }

    // display refund request status
    public void displayRefundRequestStatus(String refundID) {
        for (RefundRequest refundRequest : refundRequests) {
            if (refundRequest.ID.equals(refundID)) {
                System.out.println("Refund request status: " + refundRequest.status);
                return;
            }
        }
        System.out.println("No such refund request found.");
    }

    // display pending refunds
    public void displayPendingRefunds() {
        displayedRefunds.clear();
        for (RefundRequest refundRequest : refundRequests) {
            if (refundRequest.status.equals("pending")) {
                displayedRefunds.add(refundRequest);
            }
        }
        System.out.println("Displaying pending refunds.");
    }

    // display refund details
    public void displayRefundDetails(String refundID) {
        for (RefundRequest refundRequest : refundRequests) {
            if (refundRequest.ID.equals(refundID)) {
                System.out.println("Refund details: " + refundRequest.toString());
                return;
            }
        }
        System.out.println("No such refund request found.");
    }

    // display payment status
    public void displayPaymentStatus(String paymentID) {
        for (payment payment : payments) {
            if (payment.paymentID.equals(paymentID)) {
                System.out.println("Payment status: " + payment.paymentStatus);
                return;
            }
        }
        System.out.println("No such payment found.");
    }

    // create an enquiry
    public void createEnquiry() {
        this.displayEnquiryInfo();
    }

    // display enquiry info
    public void displayEnquiryInfo() {
        System.out.println("Enquiry has been created, please type the enquiry subject and message to be sent.");
    }

    // send the enquiry
    public void sendEnquiry(String ID, String subject, String msg) {
        // initialise enquiry and message objects
        Enquiry enquiry = new Enquiry();
        Message message = new Message();
        // set message object with sender detail and message content;
        message.setMessage(currentUser.email, msg);
        // generate new enquiry
        enquiry.generateNewEnquiry(subject, message);
        // add enquiry to list of enquiries
        enquiries.add(enquiry);
        // send to manager
        System.out.println("Enquiry sent to manager.");
    }

    // display open enquiries
    public void displayEnquiries() {
        openEnquiries.clear();
        // check enquiries for open status and add to open enquries list
        for (Enquiry enquiry : enquiries) {
            if (enquiry.status.equals("open")) {
                openEnquiries.add(enquiry);
            }
        }
        System.out.println("Displaying open enquiries.");
    }

    // select enquiry to view
    public void selectEnquiry(String enquiryID) {
        // check all enquiries to find one with matching ID and print its details
        for (Enquiry enquiry : openEnquiries) {
            if (enquiry.enquiryID.equals(enquiryID)) {
                System.out.println("Enquiry details: ");
                System.out.println(enquiry.getEnquiry());
                return;
            }
        }
        System.out.println("No such enquiry found.");
    }

    public void selectRefund(String string) {
    }
}
