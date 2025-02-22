package ATM;

import javax.swing.*;  
import java.awt.*; 
import java.awt.event.*;
/*
 * ��¼����
 */

public class Login extends JFrame implements ActionListener{
	public Account currentAccount;//��¼���û�
	private JPanel p0,p1,p2,p3;//������壬����
	private JTextField userName;//�˺�
	private JPasswordField passWord;//����
	private JButton login,exit;  //��¼���˳���ť
	private JLabel jl1,jl2,jl3;	
	//�����¼����
	public Login(Account account){
		super("��¼ATM");//������� 
		currentAccount=account;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô��ڵĵ�����Ͻǵ�x�Ĵ���ʽ���������õ����˳�����  
		setLayout(new GridLayout(4,1));//���ô��岼��Ϊ4*1�����񲼾�
		
		p0=new JPanel();
		jl1=new JLabel("��ӭʹ��ATM��Ա��ϵͳ��");//���ñ�ǩ���ݣ���ͬ��
		jl1.setFont(new Font("����",Font.BOLD,40));//���ñ�ǩ���壬�Ӵ֣���С����ͬ��
		p0.add(jl1);//������������ǩ��ӵ���壨��ͬ��
		
		p1=new JPanel();
		jl2=new JLabel("���ţ�");
		jl2.setFont(new Font("����",Font.BOLD,25));
		p1.add(jl2);
		userName=new JTextField(20);//�����ı��򳤶�Ϊ20
		userName.setFont(new Font("����",Font.PLAIN,25));
		p1.add(userName);
		
		p2=new JPanel();
		jl3=new JLabel("���룺");
		jl3.setFont(new Font("����",Font.BOLD,25));
		p2.add(jl3);
		passWord=new JPasswordField(20);
		passWord.setFont(new Font("����",Font.PLAIN,25));
		passWord.setEchoChar('*');//�����������������ʱ��ʾΪ*
		p2.add(passWord);
		
		p3=new JPanel();
		p3.setLayout(null);//����������Ϊ���Բ��֣����λ�������С���Զ���
		login=new JButton("��¼");
		login.setBounds(350, 50, 60, 40);//���尴ť�����С
		exit=new JButton("�˳�");
		exit.setBounds(500, 50, 60, 40);
		p3.add(login);
		p3.add(exit);
		
		//�������ӵ�����
		add(p0);
		add(p1);
		add(p2);
		add(p3);		
		
		setVisible(true);//���ô���ɼ�
		setSize(900, 700);//���ô����С		
		setLocationRelativeTo(null);//����
		setResizable(false);//���ô����С�̶�
		
		//��ť��Ӽ���
		login.addActionListener(this);
		exit.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login){//����login��ť
			if(new String(userName.getText()).equals(currentAccount.id)) {//�˺���ȷ
				if(new String(passWord.getPassword()).equals(currentAccount.password)) {//������ȷ 
					JOptionPane.showMessageDialog(this, "��¼�ɹ�");  						
					new Menu(currentAccount);//ʵ�������������洰�� 
					dispose(); //�ͷŵ�¼����
				}
				else { 
					JOptionPane.showMessageDialog(this, "�������");
					passWord.setText("");//�����������
					passWord.requestFocus();//������ý���
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "���û�������");  	
				userName.setText("");//�����û������
				passWord.setText("");//�����������
				userName.requestFocus();//�û������ý���
			}		
			
		} 		
		
		if(e.getSource()==exit){//����exit��ť
			JOptionPane.showMessageDialog(null, "ȷ���˳���");
			dispose();//�رմ���
		}
	}  
	public static void main(String[] args){
		Account currentAccount=new Account("888888","123456","50000");
	    Login login = new Login(currentAccount);  //�������
	}  
}
