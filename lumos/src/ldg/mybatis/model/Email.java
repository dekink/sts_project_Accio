package ldg.mybatis.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Email implements Serializable{
	 
    private String subject;
    private String content;
    private String receiver;
     
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
 
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
