package srs.main.java.fullcode;

import java.util.ArrayList;

public class student extends user {
  String studentID;
  public ArrayList<enrollment> EnrolledCourses;

  public student(String username, String password, String studentID) {
    super(username, password);
    this.studentID = studentID;
    this.EnrolledCourses = new ArrayList<>();
  }

  public void requestRefund(Website website, String courseID) {
    website.createRefundRequest(this.studentID, courseID, courseID);
  }

  public void enrollCourse() {
  }

  public void viewCourseContent() {
  }

  public void takeExam() {
  }

  public void attendLiveSession() {
  }

  public void submitExam() {
  }

  public void submitFeedback() {
  }

  public void submitAssignment() {
  }
}
