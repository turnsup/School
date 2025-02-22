package ATM;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener; 

/*
 * ATM�����������
 */

public class ChangePassword implements ActionListener {
	
	//�������
	public JPasswordField oldPassword,newPassword,checkPassword;
	public JFrame cframe;
	public JPanel cp0,cp1,cp2,cp3;
	public JLabel l1,l2,l3;
	public JButton confirm,cancel;
	private Account currentAccount;
	//��������������
	public ChangePassword(Account account){
		cframe=new JFrame("��������");
		cframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		currentAccount=account;
		cp0=new JPanel();
		l1=new JLabel("ԭ���룺");
		l1.setFont(new Font("����",Font.BOLD,25));
		cp0.add(l1);
		oldPassword=new JPasswordField(20);
		oldPassword.setFont(new Font("����",Font.BOLD,25));
		oldPassword.setEchoChar('*');
		cp0.add(oldPassword);
		
		cp1=new JPanel();
		l2=new JLabel("�����룺");
		l2.setFont(new Font("����",Font.BOLD,25));
		cp1.add(l2);
		newPassword=new JPasswordField(20);
		newPassword.setFont(new Font("����",Font.BOLD,25));
		newPassword.setEchoChar('*');
		cp1.add(newPassword);
		
		cp2=new JPanel();
		l3=new JLabel("�ٴ����������룺");
		l3.setFont(new Font("����",Font.BOLD,25));
		cp2.add(l3);
		checkPassword=new JPasswordField(20);
		checkPassword.setFont(new Font("����",Font.BOLD,25));
		checkPassword.setEchoChar('*');
		cp2.add(checkPassword);
		
		confirm=new JButton("ȷ��");  
		confirm.setFont(new Font("����",Font.PLAIN,25));
	    cancel=new JButton("����"); 
	    cancel.setFont(new Font("����",Font.PLAIN,25));
	    
	    cframe.add(cp0);  
	    cframe.add(cp1);  
	    cframe.add(cp2); 
	    cframe.add(confirm);  
	    cframe.add(cancel);  
	    cframe.setLayout(new FlowLayout());  
	    cframe.setVisible(true);  
	    cframe.setSize(550, 250);//�����С 
	    cframe.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)  
	    cframe.setResizable(false);
	    
	    //��Ӽ���
	    confirm.addActionListener(this);  
	    cancel.addActionListener(this);  	
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ȷ��")){
			if (currentAccount.password.equals(new String(oldPassword.getPassword()))) {  //ԭ����ƥ��
                try {  
                    if(newPassword.getText().equals(checkPassword.getText())) { //��������������ͬ
                    	if(newPassword.getText().length()>=6) { //�������6λ��
                    		currentAccount.ChangePassword(newPassword.getText());  
                    		JOptionPane.showMessageDialog(null, "��������ɹ�");  //����
                    		cframe.setVisible(false);  //�رո����������
                    }
                    	else {
                    		JOptionPane.showMessageDialog(null,"���벻������6λ��\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);//����
                    		//��������
                    		oldPassword.setText("");
        					newPassword.setText("");
        					checkPassword.setText("");
                    	}
                    }  
                    else{
                        JOptionPane.showMessageDialog(null, "������������벻һ��");  //����
                        //��������
                        oldPassword.setText("");
    					newPassword.setText("");
    					checkPassword.setText("");
                    }  
                }  
             catch (Exception e1) {//�����˻����и������뺯�����쳣��������ʾ  
                    JOptionPane.showMessageDialog(null, e1.getMessage()); 
                    oldPassword.setText("");
					newPassword.setText("");
					checkPassword.setText("");
                }  
            } 
			else { 
                JOptionPane.showMessageDialog(null, "ԭ�������");  
                oldPassword.setText("");
				newPassword.setText("");
				checkPassword.setText("");
            }  
        } 			
		if(e.getActionCommand().equals("����")){
			cframe.dispose();//�رո����������
		}
	}
}
