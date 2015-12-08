package Utils.MyUtils
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException
//import test.groovy.platformservices.utils.dataUtils.user.ListofUsers

import javax.activation.DataHandler
import javax.activation.DataSource
import javax.activation.FileDataSource
import javax.mail.Address
import javax.mail.Multipart
import javax.mail.Session
import org.jsoup.nodes.Document
import org.jsoup.Jsoup
import javax.mail.Message
import javax.mail.Folder
import javax.mail.Flags;
import javax.mail.PasswordAuthentication

import spock.lang.Shared

import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMessage
import javax.mail.internet.MimeMultipart
import java.nio.charset.Charset
import java.security.NoSuchProviderException

/**
 * Created by subrahmanayamv on 5/27/14.
 */
class EmailUtil {

   // def userDetails = new ListofUsers().getUserDetails("shareuser")
    @Shared def gmailServer = "imap.gmail.com"
    @Shared def affinnovaServer = "afiexchange1.affinnova.com"
    @Shared def afiMail = "afi1"
    @Shared def folderName = "INBOX"
    @Shared def imaps = "imaps"
    @Shared def pop3 = "pop3"
    @Shared def protocol
    Properties props = new Properties();
    def session, store, folder
    int latest = 0


    /**
     * This function will log in to the mail and opens the required folder
     * and returns true if the connection to the given mail server as well as specified folder is open
     * @param mailserver  The mail server which user email is associated with  , by default it accesses gmail server
     * @param username    Username of the user associated with that mail server , by default it accesses shareuser
     * @param password    Password of the email account for the Username passed ,by default it accesses shareuser password
     * @param foldername  Folder from which user is planning to access the emails , by default it accesses INBOX
     * If it is required to access any other mailServer we just need to send the mail server as a param in the calling method.
     */

    public boolean loginToEmail(String mailServer = gmailServer, String username = userDetails.username, String password = userDetails.password, String folderName = folderName) {

        /* ELVIS Operator to assign protocol*/
        protocol = (mailServer==gmailServer)? imaps:pop3

        /* If the mailServer is not gmail then assign the username and password form the sheet against the userDetails parameter.*/
        if(mailServer!=gmailServer){
          //  def user = new ListofUsers().getUserDetails(afiMail)
            username = user.username
            password = user.password
        }

        props.put("mail."+protocol+".ssl.checkserveridentity", "false")
        props.put("mail."+protocol+".ssl.trust", "*")
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", mailServer);
        props.setProperty("mail.store.protocol",protocol);
        session = Session.getDefaultInstance(props,  new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);}
        })
        store = session.getStore(protocol)
        store.connect(mailServer, username, password)
        folder = store.getFolder(folderName)
        folder.open(Folder.READ_WRITE)
        return store.isConnected()

    }

    /**
     * This function converts the UTF format content into a String format  /**
     * @param: Counter on which the function will get the content from.
     */
    public String getMailContentForPOP3(int counter){

        Object content = folder.messages[counter].getContent()
        StringBuilder string = new StringBuilder();
        if (content instanceof String)
        {
            return (String)content
        }
        else if (content instanceof Multipart)
        {
            Multipart mp = (Multipart)content;
            for (int i = 0; i < mp.getCount(); i++) {

                if (mp.getBodyPart(i).isMimeType("text/*")){
                    string.append((String)mp.getBodyPart(i).getContent());
                }
            }
            return string
        }
    }

    /**
     * This function closes the connection opened
     *
     */
    public void closeConnection(){
        if (store.isConnected())
            store.close()
    }


    /**
     * This function verifies if total number of mails/messages are increased from the previous count
     * @param previousCount
     *
     */
    public boolean verifyIncreasedMessageCount(int previousCount, int latest = getMessageCountIfFolderHaveMessages()) {
        return (latest > previousCount)
    }

    /**
     * This function returns the message count (or) the message/mail count at that time
     * @return the number of messages in the folder    *
     *
     */
    public int getMessageCount() {
        latest = folder.messageCount
        return latest
    }

    /**
     * This function returns the Unread message count/mail count at that time
     * @return the number of unread messages in the folder
     *
     */
    public int getUnreadMessageCount(){
        latest = folder.unreadMessageCount
        return latest
    }
    /**
     * This function returns the  message count/mail count at that time
     * @return the number of unread messages in the folder  if there are any existing messages
     * else returns zero specifying that there are no messages in that folder
     *
     */
    public int getMessageCountIfFolderHaveMessages() {

        latest = getMessageCount()
        if (latest == -1) {
            return latest = 0
        }
        else {
            return latest
        }
    }

    /**
     * This function gives the subject of the specified mail
     * @param Count of the message for which the subject has to be retrieved.
     * @return subject of the specified email
     *
     */
    public def getSubject(int latest = getMessageCountIfFolderHaveMessages()) {
        String subject = folder.messages[latest-1].subject
        return subject
    }

    /**
     * This function gives all the recipients in the To list of the specified mail
     * @param Count of the message for which the recipients has to be retrieved.
     * @return returns a List of users in the To List
     *
     */
    public def getToRecipients(int latest = getMessageCountIfFolderHaveMessages()) {
        String[] toRecipients = folder.messages[latest-1].getRecipients(Message.RecipientType.TO)
        List<String> recipients = Arrays.asList(toRecipients);
        return recipients
    }
    /**
     * This function gives all the recipients in the CC list of the specified mail
     * @param Count of the message for which the recipients has to be retrieved.
     * @return returns a List of users in the CC List
     *
     */
    public def getCCRecipients(int latest = getMessageCountIfFolderHaveMessages()) {
        String[] ccRecipients = folder.messages[latest-1].getRecipients(Message.RecipientType.CC)
        List<String> recipients = Arrays.asList(ccRecipients);
        return recipients
    }
    /**
     * This function gives all the Recipients in the From list of the specified mail
     * @param Count of the message for which the recipients has to be retrieved.
     * @return returns the From user Details
     */
    public String getFromDetails(int latest = getMessageCountIfFolderHaveMessages()) {
        String fromUserDetails = folder.messages[latest-1].from.toString()
        return fromUserDetails
    }

    /**
     * This function gives the received date and time  of the specified mail
     * @param Count of the message for which the date has to be retrieved.
     * @return returns the date as a Date class object
     *
     */
    public Date getReceivedDate(int latest = getMessageCountIfFolderHaveMessages()) {
        Date receivedDate = folder.messages[latest-1].receivedDate
        return receivedDate
    }
    /**
     * This function gives the received date and time  of the specified mail for IMAP
     * @param Count of the message for which the date has to be retrieved.
     * @return returns the date as a Date class object
     *
     */
    public Date getSentDateForIMAP(int latest = getMessageCountIfFolderHaveMessages()) {
        Date receivedDate = folder.messages[latest-1].sentDate
        return receivedDate
    }


    /**
     * This function gives Content of the specified mail
     * @param Count of the message for which the content has to be retrieved.
     * @return returns email content in plain text format
     *
     */
    public def getEmailContent(int latest = getMessageCountIfFolderHaveMessages()) {
        Document document = Jsoup.parse(folder.messages[latest-1].inputStream, null, '')
        def content = document.body().text()
        return content
    }

    /**
     * This function returns true if user receives the number of emails expected
     * @param previous count of the emails in the folder
     * @param Expected email count
     * @return true if the expected count matches the number of emails received else returns false
     *
     *
     */
    public boolean verifyEmailReceived(int previousCount, int expectedNewMails = 1) {

        latest = getMessageCountIfFolderHaveMessages()
        return expectedNewMails == latest - previousCount

    }

    /**
     * This function Stored the data from the email received  in a Map
     * @param previous count of the emails in the folder
     * @return Map with the data stored in it
     *
     *
     */
    public def getEmailDetails(int count) {
        if(verifyIncreasedMessageCount(count)){

            Map<String,String> data = new HashMap<String, String>()
            data.put("latestCount",getMessageCountIfFolderHaveMessages())
            data.put("subject",getSubject())
            data.put("toReciepients",getToRecipients())
            data.put("fromDetails",getFromDetails())
            data.put("receivedDate",getReceivedDate())
            data.put("emailContent",getEmailContent())
            return data
        }
        else {
            throw exception
        }
    }

    /**
     * This function helps to get the hyperlink from the email received to the user
     * @param emailContent   - content of the email received by the user
     * @return    - returns the hyperlink from the content of email
     */
    public def getLinkFromEmailReceived(String emailContent){
        def link = emailContent.find(/(?i)[\s+]http:\/\/.*?[\s+]/)
        if(link==null){
            link = emailContent.find(/(?i)[\s+]https:\/\/.*?[\s+]/)
        }
        return link.trim()
    }

    /**
     * Sends a mail message using the passed arguments.
     * @param toPeople - People to whom the mail have to be spent
     * @param subject - Subject line of the message
     * @param messageContent  - The email message content
     * @param attachment - Array list of file paths to be attached to the email
     * @throws Exception
     */
    public void sendMessage(String toPeople, String subject, String messageContent, List<String> attachment = new ArrayList<String>()){
        // Define the mail message
        MimeMessage message = new MimeMessage(session);

        //Creating an array of email addresses for sending the mail
        javax.mail.internet.InternetAddress[] addressTo = javax.mail.internet.InternetAddress.parse(toPeople);

        for (int i = 0; i < addressTo.length; i++)
            message.addRecipient(Message.RecipientType.TO, addressTo[i]);
        //Setting the subject of the mail
        message.setSubject(subject);

        // create the message part
        MimeBodyPart messageBodyPart =
                new MimeBodyPart();

        //fill message
        messageBodyPart.setText(messageContent);

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        // The below section is used to add attachments to the mail. A list String is sent with the apth of different files that needs to be attached.
        messageBodyPart = new MimeBodyPart();
        Iterator<String> itr = attachment.iterator();
        while (itr.hasNext()) {
            messageBodyPart = new MimeBodyPart();
            String filename = itr.next().toString();
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            filename = filename.substring((filename.lastIndexOf(File.separator)) + 1);
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
        }
        // Put parts in message
        message.setContent(multipart);

        // Send the message
        Transport.send(message);

    }

    /**
     * This function deletes the messages in a Folder
     * @param None
     * @return : None
     */

    public void deleteAllMessagesFromFolder() {

        /* Iterate over all the messages in the Folder and delete each one of them */
        try {
            Message[] messages = folder.getMessages();
            if (messages.length > 0) {
                for (int i = 0; i < messages.length; i++) {
                    Message message = messages[i];
                    message.setFlag(Flags.Flag.DELETED, true);
                }
            } else return
        }

        catch (NoSuchProviderException e) {
            Assert.fail("Mail delete operation was unsuccessful. NoSuch Provider Exception occured!!")
        } catch (MessagingException e) {
            Assert.fail("Mail delete operation was unsuccessful. Messaging Exception occured!!")

        } catch (IOException io) {
            Assert.fail("Mail delete operation was unsuccessful. IO Exception occured!!")

        }
        /*The messages marked DELETED are not actually deleted, until we call the expunge() method on the Folder object*/
        folder.expunge()
    }

    /**
     * This function deletes the messages in a Folder based on the subject
     * @param A String which will contain the Subject of the Email
     * @return : None
     */

    public void deleteAllMessagesFromFolderBasedOnSubject(String Subject) {

        /* Iterate over all the messages in the Folder and delete each one of them */
        try {
            /*Messages count will not include empty messages*/
            Message[] messages = folder.getMessages();
            if (messages.length > 0) {
                for (int i = 0; i < messages.length; i++) {
                    Message message = messages[i];
                    if (message.subject == Subject) {
                        message.setFlag(Flags.Flag.DELETED, true);
                    }
                }
            } else return
        }

        catch (NoSuchProviderException e) {
            Assert.fail("Mail delete operation was unsuccessful. NoSuch Provider Exception occured!!")
        } catch (MessagingException e) {
            Assert.fail("Mail delete operation was unsuccessful. Messaging Exception occured!!")
        } catch (IOException io) {
            Assert.fail("Mail delete operation was unsuccessful. IO Exception occured!!")
        }
        /*The messages marked DELETED are not actually deleted, until we call the expunge() method on the Folder object*/
        folder.expunge()
    }

}
