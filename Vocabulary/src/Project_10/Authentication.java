package Project_10;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Authentication extends Authenticator {
    
    PasswordAuthentication pa;
  
    public Authentication(){  //�����ڸ� ���� ���� ID/PW ����
          
        String id = "darrun45@gmail.com";       // ���� ID
        String pw = "12277777";          // ���� ��й�ȣ
  
        // ID�� ��й�ȣ�� �Է��Ѵ�.
        pa = new PasswordAuthentication(id, pw);
    }
  
    // �ý��ۿ��� ����ϴ� ��������
    public PasswordAuthentication getPasswordAuthentication() {
        return pa;
    }
}
