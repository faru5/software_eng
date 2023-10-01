package srs.main.java;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import srs.main.java.fullcode.Course;
import srs.main.java.fullcode.FinanceManager;
import srs.main.java.fullcode.Manager;
import srs.main.java.fullcode.RefundRequest;
import srs.main.java.fullcode.Website;
import srs.main.java.fullcode.enrollment;
import srs.main.java.fullcode.payment;
import srs.main.java.fullcode.student;

public class Main {
  public static void main(String[] args) {
    // example objects
    student student = new student("student1", "password", "t1");
    Course course = new Course("c1", LocalDateTime.now().plusDays(2)); // course starts 2 days later
    enrollment enrollment = new enrollment("e1", student, course);
    student.EnrolledCourses.add(enrollment);
    RefundRequest refundRequest = new RefundRequest("r1", student, enrollment);
    FinanceManager financeManager = new FinanceManager("financeManager1", "password");
    payment payment = new payment("p1", student, 100);
    Manager manager = new Manager("manager1", "password");

    // create a website object and add all the objects
    Website website = new Website();
    class Website {
      private List<enrollment> enrollments = new ArrayList<>();

      public List<enrollment> getEnrollments() {
        return enrollments;
      }

      // rest of the code
    }
    website.refundRequests.add(refundRequest);
    website.payments.add(payment);

    // student logs in and requests a refund
    if (website.authenticate(student, "student1", "password")) {
      website.displayEnrolledCourses();
      website.selectCourse("c1");
      website.createRefundRequest("t1", "c1", null);
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

    // user logs in and sends an enquiry (student as example)
    if (website.authenticate(student, "student1", "password")) {
      student.makeEnquiry(website);
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
