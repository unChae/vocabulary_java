package Project_9;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import Project.MyAuthentication;

public class GmailSend{
	//전역변수 사용안함.
	     
	    //action
	    public void GmailSet(String user, String text, String content){
	        Properties p = System.getProperties();
	        p.put("mail.smtp.starttls.enable", "true");    
	        p.put("mail.smtp.host", "smtp.gmail.com");      // smtp 서버 호스트
	        p.put("mail.smtp.auth","true");
	        p.put("mail.smtp.port", "587");                 // gmail 포트
	            
	        Authenticator auth = new MyAuthentication();    //구글 계정 인증
	          
	        //session 생성 및  MimeMessage생성
	        Session session = Session.getDefaultInstance(p, auth);
	        MimeMessage msg = new MimeMessage(session);
	        String fromName = "System";
	        String charSet = "UTF-8";
	         
	        try{
	            // 편지보낸시간 설정
	            msg.setSentDate(new Date());
	              
	            // 송신자 설정
	            InternetAddress from = new InternetAddress() ;
	            from = new InternetAddress(new String(fromName.getBytes(charSet), "8859_1") + "<darrun45@gmail.com>");
	            msg.setFrom(from);
	              
	            // 수신자 설정
	            InternetAddress to = new InternetAddress(user);
	            msg.setRecipient(Message.RecipientType.TO, to);
	             
	            // 제목 설정
	            msg.setSubject(text, "UTF-8");
	             
	            msg.setText(content, "UTF-8");  //내용 설정
	             
	            // 메일 송신
	            Transport.send(msg);   

	        }catch (AddressException addr_e) {  //예외처리 주소를 입력하지 않을 경우
	            JOptionPane.showMessageDialog(null, "Insert your email", "", JOptionPane.ERROR_MESSAGE);
	            addr_e.printStackTrace();
	        }catch (MessagingException msg_e) { //메시지에 이상이 있을 경우
	            JOptionPane.showMessageDialog(null, "Enter correct email", "", JOptionPane.ERROR_MESSAGE);
	            msg_e.printStackTrace();
	        } catch (UnsupportedEncodingException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	}