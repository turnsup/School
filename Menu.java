package ATM;
import javax.swing.*; 
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.sql.*;
/*
 *���������� 
 */

public class Menu extends JFrame implements ActionListener {
	private JPanel mp1,mp2;//�������
	private JButton inqury;  //��ѯ
	private JButton outmoney;  //ȡ�� 
	private JButton inmoney;  //���
	private JButton changepassword;  //��������
	private JButton exit;//�˿�
	private Account currentAccount;//�������˻�
	
	//����˵�����
	public Menu(Account account){
		super("ATM�Զ�ȡ���ϵͳ");
		currentAccount=account;
		setLayout(new GridLayout(3,1));//���ô���Ϊ3*1�����񲼾�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���尴ť
		inqury=new JButton("��ѯ");
		outmoney=new JButton("ȡ��");  
		inmoney=new JButton("���");  
		changepassword=new JButton("��������");  
		exit=new JButton("�˿�");  
		inqury.setFont(new Font("����",Font.BOLD,30));
		outmoney.setFont(new Font("����",Font.BOLD,30));
    	inmoney.setFont(new Font("����",Font.BOLD,30));
		changepassword.setFont(new Font("����",Font.BOLD,30));
		exit.setFont(new Font("����",Font.BOLD,30));
		
		mp1=new JPanel(new BorderLayout());//��mp1�������Ϊ�߽粼��
		JLabel jlb1=new JLabel("ATMҵ��ѡ��",JLabel.CENTER);//�����ǩ����ǩ����
		jlb1.setFont(new Font("����",Font.BOLD,60));
		jlb1.setForeground(Color.blue);//���ñ�ǩ��������ɫΪ��ɫ
		mp1.add(jlb1,BorderLayout.CENTER);//����ǩ��ӵ���岼�ֵ��м�λ��
		
		mp2=new JPanel();
		mp2.add(inqury); 
		mp2.add(inmoney);
		mp2.add(outmoney);   
		mp2.add(changepassword);  
		mp2.add(exit); 
		mp2.setLayout(new GridLayout(5,1));  //�������mp2Ϊ5*1�����񲼾�
		
		add(mp1);
		add(mp2);		
		setVisible(true);//���ÿɼ�
		setSize(800, 600);//���ô�С
		setLocationRelativeTo(null);//����
		setResizable(false);//���ô����С�̶�
		
		
		//�󶨼�����
		inqury.addActionListener(this);  
		inmoney.addActionListener(this);  
		outmoney.addActionListener(this);  
		changepassword.addActionListener(this);  
		exit.addActionListener(this);  
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd=e.getActionCommand();//cmd��ֵΪ����İ�ť�ı������� 
		if(cmd.equals("��ѯ")){
			new Inqury(currentAccount);
		}
		else if(cmd.equals("ȡ��")){
			new OutMoney(currentAccount);
		}
	    else if(cmd.equals("���")){  
			new InMoney(currentAccount);  
		}
	    else if(cmd.equals("��������")){  
			new ChangePassword(currentAccount);  
		}  
		else if(cmd.equals("�˿�")){				
			JOptionPane.showMessageDialog(null,"��ǵ�ȡ���������п�");//����
			dispose();//�رմ���
			new Login(currentAccount);  //�ٴδ򿪵�¼����			  
		}  
	}
}