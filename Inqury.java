package ATM;

import javax.swing.*;
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

/*
 * ��ѯ������
 */

public class Inqury extends JFrame{
	
	//�������
	private JLabel id,yue;
	private JButton ok;
	private Account currentAccount;
	
	//�����ѯ����
    public Inqury(Account account){
	    super("��ѯ");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new FlowLayout());
	    currentAccount=account;	 
	    
	    id=new JLabel("�˺ţ�"+currentAccount.id);
	    id.setFont(new Font("����",Font.BOLD,25));
	    yue=new JLabel("�˻���"+currentAccount.money);
	    yue.setFont(new Font("����",Font.BOLD,25));
	    ok=new JButton("ȷ��");
    	ok.setFont(new Font("����",Font.PLAIN,25)); 
	    add(id);
        add(yue);      	
    	add(ok);
    
	    	
    	setVisible(true);//���ô���ɼ�
    	setSize(400, 120);//���ô�С
    	setLocationRelativeTo(null);//����
    	setResizable(false);//���ô����С�̶�	
    	
    	ok.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			dispose();
    		}
    	});
    }	
}

