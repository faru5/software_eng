package srs.main.java.fullcode;

public abstract class user {
  String username;
  String password;
  String email;
  String fullName;
  String address;
  String dateOfBirth;
  String contactNumber;
  String emergencyContact;
  public enrollment[] enrollments;

  public user(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public boolean authenticate(String username, String password) {
    return this.username.equals(username) && this.password.equals(password);
  }

  public void updateProfile() {
  }

  public void register() {
  }

  public void login() {
  }

  // user makes an enquiry
  public void makeEnquiry(Website website) {
    website.createEnquiry();
  }

  public void requestITSupport() {
  }
}
