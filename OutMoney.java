package ATM;

import javax.swing.*;
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener; 

/*
 * ȡ�����
 */

public class OutMoney implements ActionListener{
	
	//�������
	public JTextField money;
	public JFrame oframe;
	public JPanel op0,op1,op2,op3,op4;
	public JButton confirm,cancel,exit;
	public JLabel id,yue,qu,tishi;
	boolean flag1=false;
	boolean flag2=false;
	private Account currentAccount;
	
	//����ȡ�����
	public OutMoney(Account account){
		oframe=new JFrame("ȡ��");
		oframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		currentAccount=account;
		op0=new JPanel();
		id=new JLabel("�˺ţ�"+currentAccount.id);
		id.setFont(new Font("����",Font.BOLD,25));
		op0.add(id);
		
		op1=new JPanel();
		yue=new JLabel("�˻���"+currentAccount.money);
		yue.setFont(new Font("����",Font.BOLD,25));
		op1.add(yue);
		
		op2=new JPanel();
		qu=new JLabel("ȡ���");
		qu.setFont(new Font("����",Font.BOLD,25));
		money=new JTextField(20);
		money.setFont(new Font("����",Font.BOLD,25));
		
		op2.add(qu);
		op2.add(money);
		
		op3=new JPanel();  
	    confirm=new JButton("ȷ��");  
	    confirm.setFont(new Font("����",Font.PLAIN,25));
	    op3.add(confirm);  
	    cancel=new JButton("����"); 
        cancel.setFont(new Font("����",Font.PLAIN,25));
	    op3.add(cancel);  

	    oframe.add(op0);  
	    oframe.add(op1);  
	    oframe.add(op2); 
	    oframe.add(op3);
	    
	    oframe.setLayout(new FlowLayout());  
	    oframe.setVisible(true);  
	    oframe.setSize(450, 200);//�����С 
	    oframe.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)  
	    oframe.setResizable(false);
	      
	    confirm.addActionListener(this);  
	    cancel.addActionListener(this);  		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ȷ��")){
			flag1=false;
        	flag2=false;
            try { 
            	int money1=Integer.parseInt(money.getText());
            	if(money1%100==0) {//ȡ����Ϊ���ٵ���
            		flag1=true;
            	}
            	if(money1<=5000&&money1>0) {//ȡ�������5000
            		flag2=true;
            	}
            	if(flag1&&flag2) {            		
            		currentAccount.outMoney(Integer.parseInt(money.getText()));  	
            		JOptionPane.showMessageDialog(null, "ȡ��ɹ�");//����  
            		yue.setText("�˻����:"+currentAccount.money);//���������ʾ
            		money.setText("");//����ı���
            	}
            	if(!flag1) {
            		JOptionPane.showMessageDialog(null, "ϵͳ��֧�ַ�100Ԫ����ȡ��\n ����������ȡ���� �� ");//���� 
            		money.setText("");
            	}
            	if(!flag2){
            		JOptionPane.showMessageDialog(null, "ϵͳ��֧��ȡ���5000Ԫ\n ����������ȡ���� �� ");//���� 
            		money.setText("");
            	}
            	if(money1>currentAccount.money){
            		JOptionPane.showMessageDialog(null, "���㣬����������ȡ���� �� ");//���� 
            		money.setText("");
            	}
            }  
            catch (ClassCastException e1){
                JOptionPane.showMessageDialog(null, "�����������ʹ�������������");//����Test����outmoney�������쳣
            }  
            catch (Exception e1){  
                JOptionPane.showMessageDialog(null, e1.getMessage());  
            }  
        }  
		else if(e.getActionCommand().equals("����")){
				oframe.dispose();//�ر�ȡ�����
		}
	}
}
