package srs.main.java.fullcode;

import java.util.ArrayList;

public class Enquiry {
    String enquiryID;
    String subject;
    ArrayList<Message> messages;
    String status;

    // generate a new enquiry
    public void generateNewEnquiry(String subject, Message message) {
        this.status = "open";
        this.subject = subject;
        this.enquiryID = generateUniqueEnquiryID();
        this.messages.add(message);
    }

    // generate a unique enquiry ID
    public String generateUniqueEnquiryID() {
        // generate dummy ID
        String randomID = "e1";
        return randomID;
    }

    // attach response
    public void sendResponse(Message response) {
        this.messages.add(response);
    }

    // return enquiry details as string
    public String getEnquiry() {
        StringBuilder sb = new StringBuilder();
        sb.append("Enquiry ID: ").append(this.enquiryID).append("\n");
        sb.append("Subject: ").append(this.subject).append("\n");
        sb.append("Messages: ").append("\n");
        for (Message message : this.messages) {
            sb.append("\t").append(message.toString()).append("\n");
        }
        sb.append("Status: ").append(this.status).append("\n");
        return sb.toString();
    }

}
