/*******************************************************************/
/*    ������������ �[���������������� �[ ���������� �[   ������������ �[      ����  �[   ����  �[      */
/*    ���� �X�T�T�T�T�T�T�a �^�T�T�T�T���� �X�T�T�T�T�a���� �X�T�T���� �[ ���� �X�T�T�T�T�T���� �[ �^ ���� �[ ���� �X  �a     */
/*    ������������ �[         ���� �U        ������������ �U ������������ �X �a       �^ ������ �X �a         */
/*    �^�T�T�T�T�T�T���� �U         ���� �U        ���� �X�T�T���� �U ���� �X�T�T�T�T�T�T�a          ���� �X ���� �[        */
/*    ������������ �U         ���� �U        ���� �U   ���� �U ���� �U                    ���� �X �a ���� �[       */
/*    �^�T�T�T�T�T�T�T�T�T�T�a           �^�T�T�a          �^�T�T�a     �^�T�T�a   �^�T�T�a                      �^�T�T�a      �^�T�T�a       */
/*******************************************************************/

package SysUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Features.Login;
import Features.SysClass;

public class run {

public static class JPanelTest extends JFrame {
 
	private static final long serialVersionUID = -6740703588976621222L;
 
	public JPanelTest() {
		super("��¼ - ѧ������ϵͳ");
		Container c = this.getContentPane();
 
		c.add(getMain());
 
		this.setSize(320,430);
		this.setUndecorated(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.decode("#F9F9F9"));
	}
 
	public JPanel getMain() {
		JPanel jP = new JPanel();
		jP.setOpaque(false);
		jP.setLayout(null);									// ���ÿղ��֣������Բ���

		System.out.println("Hey����ӭʹ�� ScoreSystem������ Stapx Steve д�˺þõ�ʵѵ��ҵ ����");
		System.out.println("��Ȼ���뿵�������߰���ģ���������������Һö�ö�ľ����� QAQ");
		System.out.println("���� ���� ���濪ʼ���أ�");
		System.out.println("");
		System.out.println("*****************************************************************");
		System.out.println("    ������������ �[���������������� �[ ���������� �[   ������������ �[      ����  �[   ����  �[      ");
		System.out.println("    ���� �X�T�T�T�T�T�T�a �^�T�T�T�T���� �X�T�T�T�T�a���� �X�T�T���� �[ ���� �X�T�T�T�T�T���� �[ �^ ���� �[ ���� �X  �a     ");
		System.out.println("    ������������ �[         ���� �U        ������������ �U ������������ �X �a       �^ ������ �X �a         ");
		System.out.println("    �^�T�T�T�T�T�T���� �U         ���� �U        ���� �X�T�T���� �U ���� �X�T�T�T�T�T�T�a          ���� �X ���� �[       ");
		System.out.println("    ������������ �U         ���� �U        ���� �U   ���� �U ���� �U                    ���� �X �a ���� �[       ");
		System.out.println("    �^�T�T�T�T�T�T�T�T�T�T�a           �^�T�T�a          �^�T�T�a     �^�T�T�a   �^�T�T�a                      �^�T�T�a      �^�T�T�a       ");
		System.out.println("*****************************************************************");
		System.out.println("");
		
		JLabel title=new JLabel("�� ¼");
		title.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 20));
		title.setForeground(Color.white);
		title.setBounds(133,40, 50,50);	
		jP.add(title);
		
		JLabel subtitle=new JLabel("��¼�����ʻ�");
		subtitle.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 14));
		subtitle.setBounds(110,95, 330,50);
		jP.add(subtitle);
		
		JLabel inusubtitle=new JLabel();
		JLabel inpsubtitle=new JLabel();
		
		JTextField inUser=new JTextField();
		inUser.setOpaque(false);
		inUser.setFont(new Font("Microsoft Yahei UI Light",Font.PLAIN,13));    //�޸�������ʽ
		inUser.setText("");
		inUser.setBounds(32,150, 255, 35);	
		jP.add(inUser);
		
		inUser.addFocusListener(new FocusListener(){
   			//��ý���
   			@Override
   			public void focusGained(FocusEvent e) {
   				inusubtitle.setText(" ");
   			}
   			//ʧȥ����
   			@Override
   			public void focusLost(FocusEvent e) {
   				if(inUser.getText().trim() == null || inUser.getText().trim().length() == 0) {
   					inusubtitle.setText("�˻�");
				}
   			}
   		});
		
		inusubtitle.setText("�˻�");
		inusubtitle.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 14));
		inusubtitle.setBounds(35,150, 255, 35);
		jP.add(inusubtitle);
		
		JPasswordField inPass=new JPasswordField();
		inPass.setOpaque(false);
		inPass.setFont(new Font("Microsoft Yahei UI Light",Font.PLAIN,13));    //�޸�������ʽ
		inPass.setText("");
		inPass.setBounds(32,197, 255, 35);
		jP.add(inPass);
		
		inPass.addFocusListener(new FocusListener(){
   			//��ý���
   			@Override
   			public void focusGained(FocusEvent e) {
   				inpsubtitle.setText(" ");
   			}
   			//ʧȥ����
   			@Override
   			public void focusLost(FocusEvent e) {
   				if(new String(inPass.getPassword()).trim() == null || new String(inPass.getPassword()).trim().length() == 0) {
   					inpsubtitle.setText("����");
				}
   			}
   		});
		
		inpsubtitle.setText("����");
		inpsubtitle.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 14));
		inpsubtitle.setBounds(35,197, 255, 35);
		jP.add(inpsubtitle);
		
		JButton jbLogin = new JButton("");
		jbLogin.setBounds(133,267, 50,50);	// ����λ�ü���С
		jbLogin.setContentAreaFilled(false); 	// ȥ������
		jbLogin.setFocusPainted(false);			// ȥ�������
		jbLogin.setBorderPainted(false);		// ȥ���߿�
		jP.add(jbLogin);

		jbLogin.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbLogin) {
				SysClass.printLog("��¼�����£�");
				if(inUser.getText().trim() == null || inUser.getText().trim().length() == 0 || new String(inPass.getPassword()).trim() == null || new String(inPass.getPassword()).trim().length() == 0) {
					SysClass.printErr("���ڿհ������");
					JOptionPane.showMessageDialog(null, "Err - �������������ݡ�");
				}
				else {
					try {
						String loginBack = Login.getPassport(inUser.getText().trim(), new String(inPass.getPassword()).trim());
						System.out.println(">>" + loginBack);
						if(loginBack.indexOf("Err") >= 0) {
							JOptionPane.showMessageDialog(null,loginBack);
						}
						else {
							if(loginBack.indexOf("ѧ��") >= 0) {
								SysClass.printLog("ѧ����¼��");
								new SysStudent.JPanelSysSud();
							}
							else if(loginBack.indexOf("��ʦ") >= 0) {
								SysClass.printLog("��ʦ��¼��");
								new SysTeacher.JPanelSysTec();
							}
							else {
								SysClass.printErr("�û�������֤����");
							}
							dispose();
						}
					}
					catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}});
		
		JButton jbReg = new JButton("<html><u>����һ���˻�</u></html>");
		jbReg.setBounds(10,360, 300,20);	// ����λ�ü���С
		jbReg.setFont(new java.awt.Font("Microsoft Yahei UI Light",Font.PLAIN,13));
		jbReg.setContentAreaFilled(false); 	// ȥ������
		jbReg.setFocusPainted(false);			// ȥ�������
		jbReg.setBorderPainted(false);		// ȥ���߿�
		jP.add(jbReg);

		jbReg.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbReg) {
				SysClass.printLog(" ע�ᱻ���£�");
		    	try {
		            Runtime.getRuntime().exec(
		                    "cmd /c start http://system.chuhelan.com/reg");
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
		    }
		}});
		
		JButton jbFind = new JButton("�޷���¼?");
		jbFind.setBounds(10,335, 300,20);	// ����λ�ü���С
		jbFind.setFont(new java.awt.Font("Microsoft Yahei UI Light",Font.PLAIN,13));
		jbFind.setContentAreaFilled(false); 	// ȥ������
		jbFind.setFocusPainted(false);			// ȥ�������
		jbFind.setBorderPainted(false);		// ȥ���߿�
		jP.add(jbFind);

		jbFind.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbFind) {
				SysClass.printLog("�һر����£�");
		    	try {
		            Runtime.getRuntime().exec(
		                    "cmd /c start http://system.chuhelan.com/ret");
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
		    }
		}});
		
		// ���ǵ�ͼ
		JLabel bg=new JLabel(new ImageIcon("src\\ImgPic\\MainUI_V2.png"));
		 jP.add(bg);
		bg.setBounds(0, 0, 315, 353);
		
		return jP;
	}
 
	public static void main(String[] args) {
		new JPanelTest();
	}
}
}
