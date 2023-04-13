package com.example.apptrochuyenv3.Messages;

public class MessageList {
    private String name, mobile,lastMessage,profilePic;
    private int unseenMessage;
    public MessageList(String name, String mobile, String lastMessage, int unseenMessage) {
        this.name = name;
        this.mobile = mobile;
        this.lastMessage = lastMessage;
        this.unseenMessage = unseenMessage;
        this.profilePic = profilePic;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public int getUnseenMessage() {
        return unseenMessage;
    }
    public String getProfilePic() {
        return profilePic;
    }
}
