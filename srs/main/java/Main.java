package srs.main.java;

import java.time.LocalDateTime;

public class Main {

}

public class Main {
  public static void main(String[] args) {
    // create example objects
    Trainee trainee = new Trainee("trainee1", "password", "t1");
    Course course = new Course("c1", LocalDateTime.now().plusDays(2)); // course starts 2 days later
    Enrollment enrollment = new Enrollment("e1", trainee, course);
    trainee.EnrolledCourses.add(enrollment);
    RefundRequest refundRequest = new RefundRequest("r1", trainee, enrollment);
    FinanceManager financeManager = new FinanceManager("financeManager1", "password");
    Payment payment = new Payment("p1", trainee, 100);
    Manager manager = new Manager("manager1", "password", "m1");

    // create a website object and add all the objects
    Website website = new Website();
    website.enrollments.add(enrollment);
    website.refundRequests.add(refundRequest);
    website.payments.add(payment);

    // trainee logs in and requests a refund
    if (website.authenticate(trainee, "trainee1", "password")) {
      website.displayEnrolledCourses();
      website.selectCourse("c1");
      website.createRefundRequest("t1", "c1");
      website.displayRefundRequestStatus("r1");
    }

    // finance manager logs in and processes the refund request
    if (website.authenticate(financeManager, "financeManager1", "password")) {
      website.displayPendingRefunds();
      website.selectRefund("r1");
      website.displayRefundDetails("r1");
      financeManager.confirmRefund(website, "r1");
      website.processRefund("r1");
      website.displayPaymentStatus("p1");
    }

    // user logs in and sends an enquiry (trainee as example)
    if (website.authenticate(trainee, "trainee1", "password")) {
      trainee.makeEnquiry(website);
      website.sendEnquiry("t1", "subject", "enquiry message");
    }

    // manager logs in and responds to an enquiry
    if (website.authenticate(manager, "manager1", "password")) {
      website.displayEnquiries();
      website.selectEnquiry("e1");
      manager.respondEnquiry(website, "e1", "response message");
    }

  }
}
