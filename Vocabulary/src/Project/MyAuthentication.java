package Project;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthentication extends Authenticator {
    
    PasswordAuthentication pa;
  
    public MyAuthentication(){  //�����ڸ� ���� ���� ID/PW ����
          
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
