package srs.main.java.fullcode;

public class Message {
    String messageID;
    String sender;
    String content;
    String timestamp;

    public void setMessage(String sender, String content) {
        this.messageID = generateUniqueMessageID();
        this.sender = sender;
        this.content = content;
        this.timestamp = getTimestamp();
    }

    // generate a unique message ID
    public String generateUniqueMessageID() {
        // generate dummy ID
        String randomID = "m1";
        return randomID;
    }

    // get message timestamp
    public String getTimestamp() {
        // generate dummy timestamp
        String msgTimestamp = "10:30:34";
        return msgTimestamp;
    }
}