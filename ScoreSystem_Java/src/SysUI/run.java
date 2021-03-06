/*******************************************************************/
/*    ██████ ╗████████ ╗ █████ ╗   ██████ ╗      ██  ╗   ██  ╗      */
/*    ██ ╔══════╝ ╚════██ ╔════╝██ ╔══██ ╗ ██ ╔═════██ ╗ ╚ ██ ╗ ██ ╔  ╝     */
/*    ██████ ╗         ██ ║        ██████ ║ ██████ ╔ ╝       ╚ ███ ╔ ╝         */
/*    ╚══════██ ║         ██ ║        ██ ╔══██ ║ ██ ╔══════╝          ██ ╔ ██ ╗        */
/*    ██████ ║         ██ ║        ██ ║   ██ ║ ██ ║                    ██ ╔ ╝ ██ ╗       */
/*    ╚══════════╝           ╚══╝          ╚══╝     ╚══╝   ╚══╝                      ╚══╝      ╚══╝       */
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

import javax.swing.Icon;
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
		super("登录 - 学生管理系统");
		Container c = this.getContentPane();
 
		c.add(getMain());
 
		ImageIcon imageIcon = new ImageIcon("src\\ImgPic\\SSSIcon.png"); 
		
        this.setIconImage(imageIcon.getImage());  
		this.setSize(320,430);
		this.setUndecorated(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.decode("#F9F9F9"));
	}
 
	public JPanel getMain() {
		JLabel bg=new JLabel(new ImageIcon("src\\ImgPic\\MainUI_V1.png"));
		
		JPanel jP = new JPanel();
		jP.setOpaque(false);
		jP.setLayout(null);									// 设置空布局，即绝对布局

		System.out.println("Hey，欢迎使用 ScoreSystem！这是 Stapx Steve 写了好久的实训作业 ——");
		System.out.println("虽然代码康起来乱七八糟的，但它真的消耗了我好多好多的精力的 QAQ");
		System.out.println("好了 —— 下面开始加载！");
		System.out.println("");
		System.out.println("*****************************************************************");
		System.out.println("    ██████ ╗████████ ╗ █████ ╗   ██████ ╗      ██  ╗   ██  ╗      ");
		System.out.println("    ██ ╔══════╝ ╚════██ ╔════╝██ ╔══██ ╗ ██ ╔═════██ ╗ ╚ ██ ╗ ██ ╔  ╝     ");
		System.out.println("    ██████ ╗         ██ ║        ██████ ║ ██████ ╔ ╝       ╚ ███ ╔ ╝         ");
		System.out.println("    ╚══════██ ║         ██ ║        ██ ╔══██ ║ ██ ╔══════╝          ██ ╔ ██ ╗       ");
		System.out.println("    ██████ ║         ██ ║        ██ ║   ██ ║ ██ ║                    ██ ╔ ╝ ██ ╗       ");
		System.out.println("    ╚══════════╝           ╚══╝          ╚══╝     ╚══╝   ╚══╝                      ╚══╝      ╚══╝       ");
		System.out.println("*****************************************************************");
		System.out.println("");

		Boolean[] isEnd = { false };
		JTextField inUser=new JTextField();
		JPasswordField inPass=new JPasswordField();
		
		 // 按钮监听线程方法
		 class MyThread extends Thread {
			    public void run() {
			    	while(!isEnd[0]) {
			    		if(new String(inPass.getPassword()).trim() == null || new String(inPass.getPassword()).trim().length() == 0 || inUser.getText().trim() == null || inUser.getText().trim().length() == 0) {
			    			Icon icon=new ImageIcon("src\\\\ImgPic\\\\MainUI_V1.png");
			    			bg.setIcon(icon);
			    		}
			    		else {
			    			Icon icon=new ImageIcon("src\\\\ImgPic\\\\MainUI_V2.png");
			    			bg.setIcon(icon);
			    		}
			    	}
			    	SysClass.printLog("按钮监控结束。");
			    }
			}
		SysClass.printLog("按钮监控运行中……");
		MyThread buttonchanger = new MyThread();
		buttonchanger.start();
		
		
		JLabel title=new JLabel("登 录");
		title.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 20));
		title.setForeground(Color.white);
		title.setBounds(133,40, 50,50);	
		jP.add(title);
		
		JLabel subtitle=new JLabel("登录您的帐户");
		subtitle.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 14));
		subtitle.setBounds(110,95, 330,50);
		jP.add(subtitle);
		
		JLabel inusubtitle=new JLabel();
		JLabel inpsubtitle=new JLabel();
		
		inUser.setOpaque(false);
		inUser.setFont(new Font("Microsoft Yahei UI Light",Font.PLAIN,13));    //修改字体样式
		inUser.setText("");
		inUser.setBounds(32,150, 255, 35);	
		jP.add(inUser);
		
		inUser.addFocusListener(new FocusListener(){
   			//获得焦点
   			@Override
   			public void focusGained(FocusEvent e) {
   				inusubtitle.setText(" ");
   			}
   			//失去焦点
   			@Override
   			public void focusLost(FocusEvent e) {
   				if(inUser.getText().trim() == null || inUser.getText().trim().length() == 0) {
   					inusubtitle.setText("账户");
				}
   			}
   		});
		
		inusubtitle.setText("账户");
		inusubtitle.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 14));
		inusubtitle.setBounds(35,150, 255, 35);
		jP.add(inusubtitle);
		
		inPass.setOpaque(false);
		inPass.setFont(new Font("Microsoft Yahei UI Light",Font.PLAIN,13));    //修改字体样式
		inPass.setText("");
		inPass.setBounds(32,197, 255, 35);
		jP.add(inPass);
		
		inPass.addFocusListener(new FocusListener(){
   			//获得焦点
   			@Override
   			public void focusGained(FocusEvent e) {
   				inpsubtitle.setText(" ");
   			}
   			//失去焦点
   			@Override
   			public void focusLost(FocusEvent e) {
   				if(new String(inPass.getPassword()).trim() == null || new String(inPass.getPassword()).trim().length() == 0) {
   					inpsubtitle.setText("密码");
				}
   			}
   		});
		
		inpsubtitle.setText("密码");
		inpsubtitle.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 14));
		inpsubtitle.setBounds(35,197, 255, 35);
		jP.add(inpsubtitle);
		
		JButton jbLogin = new JButton("");
		jbLogin.setBounds(133,267, 50,50);	// 设置位置及大小
		jbLogin.setContentAreaFilled(false); 	// 去除背景
		jbLogin.setFocusPainted(false);			// 去除焦点框
		jbLogin.setBorderPainted(false);		// 去除边框
		jP.add(jbLogin);

		jbLogin.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbLogin) {
				SysClass.printLog("登录被按下！");
				if(inUser.getText().trim() == null || inUser.getText().trim().length() == 0 || new String(inPass.getPassword()).trim() == null || new String(inPass.getPassword()).trim().length() == 0) {
					SysClass.printErr("存在空白输入框！");
					JOptionPane.showMessageDialog(null, "Err - 请输入完整内容。");
				}
				else {
					try {
						String loginBack = Login.getPassport(inUser.getText().trim(), new String(inPass.getPassword()).trim());
						System.out.println(">>" + loginBack);
						if(loginBack.indexOf("Err") >= 0) {
							JOptionPane.showMessageDialog(null,loginBack);
						}
						else {
							isEnd[0] =true;
							if(loginBack.indexOf("学生") >= 0) {
								SysClass.printLog("学生登录。");
								new SysStudent.JPanelSysSud();
							}
							else if(loginBack.indexOf("教师") >= 0) {
								SysClass.printLog("教师登录。");
								new SysTeacher.JPanelSysTec();
							}
							else {
								SysClass.printErr("用户类型验证错误！");
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
		
		 this.getRootPane().setDefaultButton(jbLogin);		// 设置界面默认按钮
		
		JButton jbReg = new JButton("<html><u>创建一个账户</u></html>");
		jbReg.setBounds(10,360, 300,20);	// 设置位置及大小
		jbReg.setFont(new java.awt.Font("Microsoft Yahei UI Light",Font.PLAIN,13));
		jbReg.setContentAreaFilled(false); 	// 去除背景
		jbReg.setFocusPainted(false);			// 去除焦点框
		jbReg.setBorderPainted(false);		// 去除边框
		jP.add(jbReg);

		jbReg.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbReg) {
				SysClass.printLog(" 注册被按下！");
		    	try {
		            Runtime.getRuntime().exec(
		                    "cmd /c start http://system.chuhelan.com/reg");
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
		    }
		}});
		
		JButton jbFind = new JButton("无法登录?");
		jbFind.setBounds(10,335, 300,20);	// 设置位置及大小
		jbFind.setFont(new java.awt.Font("Microsoft Yahei UI Light",Font.PLAIN,13));
		jbFind.setContentAreaFilled(false); 	// 去除背景
		jbFind.setFocusPainted(false);			// 去除焦点框
		jbFind.setBorderPainted(false);		// 去除边框
		jP.add(jbFind);

		jbFind.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbFind) {
				SysClass.printLog("找回被按下！");
		    	try {
		            Runtime.getRuntime().exec(
		                    "cmd /c start http://system.chuhelan.com/ret");
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
		    }
		}});
		
		// 这是底图
		 jP.add(bg);
		bg.setBounds(0, 0, 315, 353);
		
		return jP;
	}
 
	public static void main(String[] args) {
		new JPanelTest();
	}
}
}
