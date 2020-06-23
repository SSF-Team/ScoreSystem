/*******************************************************************/
/*    ������������ �[���������������� �[ ���������� �[   ������������ �[      ����  �[   ����  �[      */
/*    ���� �X�T�T�T�T�T�T�a �^�T�T�T�T���� �X�T�T�T�T�a���� �X�T�T���� �[ ���� �X�T�T�T�T�T���� �[ �^ ���� �[ ���� �X  �a     */
/*    ������������ �[         ���� �U        ������������ �U ������������ �X �a       �^ ������ �X �a         */
/*    �^�T�T�T�T�T�T���� �U         ���� �U        ���� �X�T�T���� �U ���� �X�T�T�T�T�T�T�a          ���� �X ���� �[        */
/*    ������������ �U         ���� �U        ���� �U   ���� �U ���� �U                    ���� �X �a ���� �[       */
/*    �^�T�T�T�T�T�T�T�T�T�T�a           �^�T�T�a          �^�T�T�a     �^�T�T�a   �^�T�T�a                      �^�T�T�a      �^�T�T�a       */
/*******************************************************************/

package SysUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Features.DBUtil;
import Features.SysClass;


public class SysTeacher {
	public static class JPanelSysTec extends JFrame {
		 
		private static final long serialVersionUID = -6740703588976621222L;
	 
		public JPanelSysTec() {
			super("��ʦ - ѧ������ϵͳ");
			Container c = this.getContentPane();
	 
			c.add(getMain());
	 
			this.setSize(870,520);
			this.setUndecorated(false);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.getContentPane().setBackground(Color.white);
		}
		
		boolean isChanging = false;
		CardLayout pageCard  = new CardLayout();
		JPanel jPC = new JPanel();
	 
		public JPanel getMain() {
			SysClass.printLog("�����ʦ������档");
			JPanel jP = new JPanel();
			jP.setOpaque(false);
			jP.setLayout(null);									// ���ÿղ��֣������Բ���
			
			JLabel title=new JLabel("��ʦ����");
			title.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			title.setBounds(75,-5, 150,50);	
			jP.add(title);
			
			JLabel version=new JLabel(SysClass.SysData.version);
			version.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 13));
			version.setBounds(15,446, 150,50);	
			jP.add(version);
			
			// ��Ƭ���
			jPC.setOpaque(false);
			jPC.setLayout(null);
			jPC = new JPanel(pageCard);
			jPC.setBounds(240, -25, 725, 540);
			jP.add(jPC);
			
			/*******************************************************************/
			
			/*
			 * ������������б�ť��
			 * ��Ϊ��ť�Զ�����ʽ����һ��
			 * ����û��JList
			 */
			JButton jbInfo = new JButton("     ������Ϣ");
			JButton jbStudent = new JButton("     ѧ������");
			JButton jbScore = new JButton("     �ɼ�����");
			JButton jbTabPass = new JButton("     ��������");
			JButton jbTable = new JButton("     �ύ����");
			JButton jbExit = new JButton("");
			
			jbInfo.setBounds(0,55, 230,35);	   // ����λ�ü���С
			jbInfo.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			jbInfo.setHorizontalAlignment(SwingConstants.LEFT);
			jbInfo.setBackground(Color.decode("#4285f4"));
			jbInfo.setForeground(Color.white);
			jbInfo.setFocusPainted(false);			// ȥ�������
			jbInfo.setBorderPainted(false);			// ȥ���߿�
			jP.add(jbInfo);
			
			jbInfo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbInfo) {
						// ��ʾ
						jbInfo.setBackground(Color.decode("#4285f4"));
						jbInfo.setForeground(Color.white);
						jbInfo.setContentAreaFilled(true);
						// ȥ��
						jbScore.setBackground(Color.decode("#222222"));
						jbScore.setForeground(Color.black);
						jbScore.setContentAreaFilled(false);
						jbExit.setBackground(Color.decode("#222222"));
						jbExit.setForeground(Color.black);
						jbExit.setContentAreaFilled(false);
						jbStudent.setBackground(Color.decode("#222222"));
						jbStudent.setForeground(Color.black);
						jbStudent.setContentAreaFilled(false);
						jbTabPass.setBackground(Color.decode("#222222"));
						jbTabPass.setForeground(Color.black);
						jbTabPass.setContentAreaFilled(false);
						jbTable.setBackground(Color.decode("#222222"));
						jbTable.setForeground(Color.black);
						jbTable.setContentAreaFilled(false);
						SysClass.printLog("������Ϣ�����£�");
						pageCard.show(jPC, "info");
					}
				}
			});
			
			jbStudent.setBounds(0,90, 230,35);	   // ����λ�ü���С
			jbStudent.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			jbStudent.setHorizontalAlignment(SwingConstants.LEFT);
			jbStudent.setBackground(Color.decode("#222222"));
			jbStudent.setContentAreaFilled(false); 	 // ȥ������
			jbStudent.setFocusPainted(false);			// ȥ�������
			jbStudent.setBorderPainted(false);			// ȥ���߿�
			jP.add(jbStudent);
			
			jbStudent.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbStudent) {
						// ��ʾ
						jbStudent.setBackground(Color.decode("#4285f4"));
						jbStudent.setForeground(Color.white);
						jbStudent.setContentAreaFilled(true);
						// ȥ��
						jbScore.setBackground(Color.decode("#222222"));
						jbScore.setForeground(Color.black);
						jbScore.setContentAreaFilled(false);
						jbExit.setBackground(Color.decode("#222222"));
						jbExit.setForeground(Color.black);
						jbExit.setContentAreaFilled(false);
						jbInfo.setBackground(Color.decode("#222222"));
						jbInfo.setForeground(Color.black);
						jbInfo.setContentAreaFilled(false);
						jbTabPass.setBackground(Color.decode("#222222"));
						jbTabPass.setForeground(Color.black);
						jbTabPass.setContentAreaFilled(false);
						jbTable.setBackground(Color.decode("#222222"));
						jbTable.setForeground(Color.black);
						jbTable.setContentAreaFilled(false);
						// ����
						SysClass.printLog("ѧ���������£�");
						pageCard.show(jPC, "student");
					}
				}
			});
			
			jbScore.setBounds(0,125, 230,35);	   // ����λ�ü���С
			jbScore.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			jbScore.setHorizontalAlignment(SwingConstants.LEFT);
			jbScore.setBackground(Color.decode("#222222"));
			jbScore.setContentAreaFilled(false); 	 // ȥ������
			jbScore.setFocusPainted(false);			// ȥ�������
			jbScore.setBorderPainted(false);			// ȥ���߿�
			jP.add(jbScore);
			
			jbScore.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbScore) {
						// ��ʾ
						jbScore.setBackground(Color.decode("#4285f4"));
						jbScore.setForeground(Color.white);
						jbScore.setContentAreaFilled(true);
						// ȥ��
						jbInfo.setBackground(Color.decode("#222222"));
						jbInfo.setForeground(Color.black);
						jbInfo.setContentAreaFilled(false);
						jbExit.setBackground(Color.decode("#222222"));
						jbExit.setForeground(Color.black);
						jbExit.setContentAreaFilled(false);
						jbStudent.setBackground(Color.decode("#222222"));
						jbStudent.setForeground(Color.black);
						jbStudent.setContentAreaFilled(false);
						jbTabPass.setBackground(Color.decode("#222222"));
						jbTabPass.setForeground(Color.black);
						jbTabPass.setContentAreaFilled(false);
						jbTable.setBackground(Color.decode("#222222"));
						jbTable.setForeground(Color.black);
						jbTable.setContentAreaFilled(false);
						// ����
						SysClass.printLog("�ɼ���Ϣ�����£�");
						pageCard.show(jPC, "score");
					}
				}
			});
			
			jbExit.setBounds(187,455, 30,30);	   // ����λ�ü���С
			jbExit.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			jbExit.setHorizontalAlignment(SwingConstants.LEFT);
			jbExit.setBackground(Color.decode("#222222"));
			jbExit.setContentAreaFilled(false); 	 // ȥ������
			jbExit.setFocusPainted(false);			// ȥ�������
			jbExit.setBorderPainted(false);			// ȥ���߿�
			jP.add(jbExit);
			
			jbExit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbExit) {
						// ��ʾ
						jbExit.setBackground(Color.decode("#4285f4"));
						jbExit.setForeground(Color.white);
						jbExit.setContentAreaFilled(true);
						// ȥ��
						jbInfo.setBackground(Color.decode("#222222"));
						jbInfo.setForeground(Color.black);
						jbInfo.setContentAreaFilled(false);
						jbScore.setBackground(Color.decode("#222222"));
						jbScore.setForeground(Color.black);
						jbScore.setContentAreaFilled(false);
						jbStudent.setBackground(Color.decode("#222222"));
						jbStudent.setForeground(Color.black);
						jbStudent.setContentAreaFilled(false);
						jbTabPass.setBackground(Color.decode("#222222"));
						jbTabPass.setForeground(Color.black);
						jbTabPass.setContentAreaFilled(false);
						jbTable.setBackground(Color.decode("#222222"));
						jbTable.setForeground(Color.black);
						jbTable.setContentAreaFilled(false);
						// �˳�
						SysClass.printLog("�˳���¼�����£�");
						new run.JPanelTest();
						dispose();
					}
				}
			});
			
			jbTabPass.setBounds(0,160, 230,35);	   // ����λ�ü���С
			jbTabPass.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			jbTabPass.setHorizontalAlignment(SwingConstants.LEFT);
			jbTabPass.setBackground(Color.decode("#222222"));
			jbTabPass.setContentAreaFilled(false); 	 // ȥ������
			jbTabPass.setFocusPainted(false);			// ȥ�������
			jbTabPass.setBorderPainted(false);			// ȥ���߿�
			jP.add(jbTabPass);
			
			jbTabPass .addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbTabPass) {
						// ��ʾ
						jbTabPass.setBackground(Color.decode("#4285f4"));
						jbTabPass.setForeground(Color.white);
						jbTabPass.setContentAreaFilled(true);
						// ȥ��
						jbInfo.setBackground(Color.decode("#222222"));
						jbInfo.setForeground(Color.black);
						jbInfo.setContentAreaFilled(false);
						jbScore.setBackground(Color.decode("#222222"));
						jbScore.setForeground(Color.black);
						jbScore.setContentAreaFilled(false);
						jbStudent.setBackground(Color.decode("#222222"));
						jbStudent.setForeground(Color.black);
						jbStudent.setContentAreaFilled(false);
						jbExit.setBackground(Color.decode("#222222"));
						jbExit.setForeground(Color.black);
						jbExit.setContentAreaFilled(false);
						jbTable.setBackground(Color.decode("#222222"));
						jbTable.setForeground(Color.black);
						jbTable.setContentAreaFilled(false);
						// ����
						SysClass.printLog("�����������£�");
						pageCard.show(jPC, "tableget");
					}
				}
			});
			
			jbTable.setBounds(0,195, 230,35);	   // ����λ�ü���С
			jbTable.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			jbTable.setHorizontalAlignment(SwingConstants.LEFT);
			jbTable.setBackground(Color.decode("#222222"));
			jbTable.setContentAreaFilled(false); 	 // ȥ������
			jbTable.setFocusPainted(false);			// ȥ�������
			jbTable.setBorderPainted(false);			// ȥ���߿�
			jP.add(jbTable);
			
			jbTable.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbTable) {
						// ��ʾ
						jbTable.setBackground(Color.decode("#4285f4"));
						jbTable.setForeground(Color.white);
						jbTable.setContentAreaFilled(true);
						// ȥ��
						jbInfo.setBackground(Color.decode("#222222"));
						jbInfo.setForeground(Color.black);
						jbInfo.setContentAreaFilled(false);
						jbScore.setBackground(Color.decode("#222222"));
						jbScore.setForeground(Color.black);
						jbScore.setContentAreaFilled(false);
						jbStudent.setBackground(Color.decode("#222222"));
						jbStudent.setForeground(Color.black);
						jbStudent.setContentAreaFilled(false);
						jbExit.setBackground(Color.decode("#222222"));
						jbExit.setForeground(Color.black);
						jbExit.setContentAreaFilled(false);
						jbTabPass.setBackground(Color.decode("#222222"));
						jbTabPass.setForeground(Color.black);
						jbTabPass.setContentAreaFilled(false);
						// ����
						SysClass.printLog("�ύ���������£�");
						pageCard.show(jPC, "table");
					}
				}
			});
			
			/*******************************************************************/
			// ��һҳ
			JPanel jPInfo = new JPanel();
			jPInfo.setOpaque(false);
			jPInfo.setLayout(null);
			
			// �����б��
			DefaultListModel<String> listModeTitle = new DefaultListModel<String>();
			DefaultListModel<String> listModeThings = new DefaultListModel<String>();
			
			SysClass.printLog("���ڳ�ʼ��������Ϣ����");
			try {
				Statement stmt = SysClass.SysData.conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Student;");
				boolean has = false;
				while(rs.next()) {
	            	int uid = rs.getInt("uid");
	            	if(uid == SysClass.SysData.uid) {
	            		has = true;
	            		Statement stmta = SysClass.SysData.conn.createStatement();
	    				ResultSet rsa = stmta.executeQuery("SELECT * FROM Student;");
	    	            java.sql.ResultSetMetaData data = rsa.getMetaData();
	    	            for (int i = 1; i <= data.getColumnCount(); i++) {
	    	            	if(!data.getColumnLabel(i).equals("uid") && !data.getColumnLabel(i).equals("������")) {
	    	            		listModeTitle.addElement(data.getColumnLabel(i));
	    		            	if(data.getColumnTypeName(i).equals("INT")) {
	    		            		listModeThings.addElement(rs.getInt(data.getColumnLabel(i)) + "");
	    		            	}
	    		            	else if(data.getColumnTypeName(i).equals("VARCHAR")) {
	    		            		listModeThings.addElement(rs.getString(data.getColumnLabel(i)));
	    		            	}
	    		            	else {
	    		            		listModeThings.addElement("Err - �������ʹ���");
	    		            	}
	    	            	}
	    	            }
	            	}
	            }
				if(!has) {
					SysClass.printErr("�û�UID�ȶԴ���");
					dispose();
					new run.JPanelTest();
					return jPInfo;
				}
			} catch (SQLException e1) {
				SysClass.printErr("���ݿ��ѯ����");
				e1.printStackTrace();
			}
			SysClass.printLog("��ʼ��������Ϣ��ɣ�");
			
			JList<String> listBoxTitle = new JList<String>(listModeTitle); 
			 listBoxTitle.setBounds(294,146, 100,195);
			 listBoxTitle.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			 listBoxTitle.setOpaque(false);
			 listBoxTitle.setFocusable(false);			// ȥ�������
			jPInfo.add(listBoxTitle);
			listBoxTitle.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					listBoxTitle.clearSelection();
				}
	        });
			JList<String> listBoxThings = new JList<String>(listModeThings); 
			 listBoxThings.setBounds(394,146, 150,195);
			 listBoxThings.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			 listBoxThings.setOpaque(false);
			 listBoxThings.setFocusable(false);			// ȥ�������
			jPInfo.add(listBoxThings);
			listBoxThings.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					if(!isChanging) {
						listBoxThings.clearSelection();
					}
					else {
						
					}
				}
	        });
			
			JButton jbRep = new JButton("�޸���Ϣ");
			jbRep.setBounds(290, 355, 185, 35);	  	 // ����λ�ü���С
			jbRep.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			jbRep.setForeground(Color.white);
			jbRep.setBackground(Color.decode("#4285f4"));
			jbRep.setFocusPainted(false);			// ȥ�������
			jbRep.setBorderPainted(false);		// ȥ���߿�
			jPInfo.add(jbRep);
			
			jbRep.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbRep) {
						SysClass.printLog("�޸ı����£�");
						if(!isChanging) {
							isChanging = true;
							jbRep.setText("ȷ����Ϣ");
							listBoxThings.clearSelection();
							jbRep.setBounds(290, 355, 130, 35);
						}
						else {
							isChanging = false;
							jbRep.setText("�޸���Ϣ");
							listBoxThings.clearSelection();
							jbRep.setBounds(290, 355, 185, 35);
						}
				    }
				}});
			
			JButton jbTru = new JButton("X");
			jbTru.setBounds(430, 355, 45, 35);	  	 // ����λ�ü���С
			jbTru.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			jbTru.setForeground(Color.white);
			jbTru.setBackground(Color.decode("#4285f4"));
			jbTru.setFocusPainted(false);			// ȥ�������
			jbTru.setBorderPainted(false);		// ȥ���߿�
			jPInfo.add(jbTru);
			
			jbTru.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbTru) {
						SysClass.printLog("ȡ�������£�");
							isChanging = false;
							jbRep.setText("�޸���Ϣ");
							listBoxThings.clearSelection();
							jbRep.setBounds(290, 355, 185, 35);
				    }
				}});
			
			// ���ǵ�ͼ
			JLabel bg=new JLabel(new ImageIcon("src\\ImgPic\\SysStuInfo_V4.png"));
			jPInfo.add(bg);
			bg.setBounds(-50, 0, 725, 540);
			
			
			/*******************************************************************/
			// �ڶ�ҳ
			JPanel jPStudent = new JPanel();
			jPStudent.setOpaque(false);
			jPStudent.setLayout(null);
			
			JLabel stuList=new JLabel("ѧ���б�");
			stuList.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			stuList.setForeground(Color.white);
			stuList.setBounds(33,48,150,50);
			jPStudent.add(stuList);
			
			JLabel stuAdd=new JLabel("���ѧ��");
			stuAdd.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			stuAdd.setForeground(Color.white);
			stuAdd.setBounds(363,48,150,50);
			jPStudent.add(stuAdd);
			
			JLabel stuDel=new JLabel("ɾ��ѧ��");
			stuDel.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			stuDel.setForeground(Color.white);
			stuDel.setBounds(363,215,150,50);
			jPStudent.add(stuDel);
			
			DefaultListModel<String> listName = new DefaultListModel<String>();
			 listName.addElement("����");
			DefaultListModel<String> listID = new DefaultListModel<String>();
			listID.addElement("ѧ��");
			
			int uidall = 0;
			
			try {
				Statement stmt = SysClass.SysData.conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Student;");
				while(rs.next()) {
					uidall = rs.getInt("uid");
					String name = rs.getString("����");
					String id = rs.getString("ѧ��");
					String master = rs.getString("������");
					
					if(master.equals(SysClass.SysData.uname)) {
						 listName.addElement(name);
						 listID.addElement(id + "");
					}
				}
			}
			catch (SQLException e1) {
				SysClass.printErr("���ݿ��ѯ����");
				e1.printStackTrace();
			}
			
			JList<String> listBoxScID = new JList<String>(listName); 
			listBoxScID.setBounds(50,95,150,195);
			listBoxScID.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			listBoxScID.setFocusable(false);			// ȥ�������
			jPStudent.add(listBoxScID);
			listBoxScID.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					listBoxScID.clearSelection();
				}
	        });
			
			JList<String> listBoxScTime = new JList<String>(listID); 
			listBoxScTime.setBounds(200,95, 100,195);
			listBoxScTime.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			listBoxScTime.setBackground(Color.white);
			listBoxScTime.setFocusable(false);			// ȥ�������
			jPStudent.add(listBoxScTime);
			listBoxScTime.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					listBoxScTime.clearSelection();
				}
	        });
			
			JLabel subname=new JLabel();
			
			JTextField inName=new JTextField();
			inName.setOpaque(false);
			inName.setFont(new Font("Microsoft Yahei UI Light",Font.PLAIN,13));    //�޸�������ʽ
			inName.setText("");
			inName.setBounds(363, 107, 233, 35);	
			jPStudent.add(inName);
			
			inName.addFocusListener(new FocusListener(){
	   			//��ý���
	   			@Override
	   			public void focusGained(FocusEvent e) {
	   				subname.setText(" ");
	   			}
	   			//ʧȥ����
	   			@Override
	   			public void focusLost(FocusEvent e) {
	   				if(inName.getText().trim() == null || inName.getText().trim().length() == 0) {
	   					subname.setText("����");
					}
	   			}
	   		});
			
			subname.setText("����");
			subname.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 14));
			subname.setBounds(368, 107, 255, 35);
			jPStudent.add(subname);
			
			JLabel subid=new JLabel();
			
			JTextField inID=new JTextField();
			inID.setOpaque(false);
			inID.setFont(new Font("Microsoft Yahei UI Light",Font.PLAIN,13));    //�޸�������ʽ
			inID.setText("");
			inID.setBounds(363, 153, 233, 35);	
			jPStudent.add(inID);
			
			inID.addFocusListener(new FocusListener(){
	   			//��ý���
	   			@Override
	   			public void focusGained(FocusEvent e) {
	   				subid.setText(" ");
	   			}
	   			//ʧȥ����
	   			@Override
	   			public void focusLost(FocusEvent e) {
	   				if(inID.getText().trim() == null || inID.getText().trim().length() == 0) {
	   					subid.setText("ѧ��");
					}
	   			}
	   		});
			
			subid.setText("ѧ��");
			subid.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 14));
			subid.setBounds(368, 153, 255, 35);
			jPStudent.add(subid);
			
			JLabel subdel=new JLabel();
			
			JTextField inDel=new JTextField();
			inDel.setOpaque(false);
			inDel.setFont(new Font("Microsoft Yahei UI Light",Font.PLAIN,13));    //�޸�������ʽ
			inDel.setText("");
			inDel.setBounds(363, 273, 233, 35);	
			jPStudent.add(inDel);
			
			inDel.addFocusListener(new FocusListener(){
	   			//��ý���
	   			@Override
	   			public void focusGained(FocusEvent e) {
	   				subdel.setText(" ");
	   			}
	   			//ʧȥ����
	   			@Override
	   			public void focusLost(FocusEvent e) {
	   				if(inDel.getText().trim() == null || inDel.getText().trim().length() == 0) {
	   					subdel.setText("ѧ��");
					}
	   			}
	   		});
			
			subdel.setText("ѧ��");
			subdel.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 14));
			subdel.setBounds(368, 273, 255, 35);
			jPStudent.add(subdel);
			
			int uida = uidall +1;
			
			JButton jbAdd = new JButton("");
			jbAdd.setBounds(570,53, 35,40);	   // ����λ�ü���С
			jbAdd.setContentAreaFilled(false); 	 // ȥ������
			jbAdd.setFocusPainted(false);			// ȥ�������
			jbAdd.setBorderPainted(false);			// ȥ���߿�
			jPStudent.add(jbAdd);
			jbAdd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbAdd) {
						SysClass.printLog("���ѧ�������£�");
						if(inID.getText().trim() == null || inID.getText().trim().length() == 0 || inName.getText().trim() == null || inName.getText().trim().length() == 0) {
							SysClass.printErr("���ڿհ������");
							JOptionPane.showMessageDialog(null, "Err - �������������ݡ�");
						}
						else {
							try {
								DBUtil.runUpdate("INSERT INTO `test`.`student` (`uid`, `����`, `ѧ��`, `����`, `����`, `סַ`, `������`) VALUES ('"+ (uida + 1) +"', '"+ inName.getText().trim() +"', '"+ inID.getText().trim() +"', NULL, NULL, NULL, '"+ SysClass.SysData.uname +"')", SysClass.SysData.mainurl + "test" + SysClass.SysData.mainurladd);
								 listName.addElement(inName.getText().trim());
								 listID.addElement(inID.getText().trim());
								 JOptionPane.showMessageDialog(null, "���ѧ���ɹ���");
							} 
							catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			});
			
			JButton jbDel = new JButton("");
			jbDel.setBounds(575,220, 35,40);	   // ����λ�ü���С
			jbDel.setContentAreaFilled(false); 	 // ȥ������
			jbDel.setFocusPainted(false);			// ȥ�������
			jbDel.setBorderPainted(false);			// ȥ���߿�
			jPStudent.add(jbDel);
			jbDel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbDel) {
						SysClass.printLog("ɾ��ѧ�������£�");
						if(inDel.getText().trim() == null || inDel.getText().trim().length() == 0) {
							SysClass.printErr("���ڿհ������");
							JOptionPane.showMessageDialog(null, "Err - �������������ݡ�");
						}
						else {
							Statement stmt;
							try {
								stmt = SysClass.SysData.conn.createStatement();
								ResultSet rs = stmt.executeQuery("SELECT * FROM Student;");
								while(rs.next()) {
									String id = rs.getString("ѧ��");
									int uid = rs.getInt("uid");
									if(id.equals(inDel.getText().trim())) {
										int where = listID.indexOf(inDel.getText().trim());
										SysClass.printErr("����ѧ����");
										SysClass.printErr(">>" + where);
										if(where >= 0) {
											DBUtil.runUpdate("DELETE FROM `test`.`student` WHERE `student`.`uid` = "+ uid +"", SysClass.SysData.mainurl + "test" + SysClass.SysData.mainurladd);
											listID.removeElementAt(where);
											listName.removeElementAt(where);
											JOptionPane.showMessageDialog(null, "�Ƴ�ѧ���ɹ���");
										}
										else {
											JOptionPane.showMessageDialog(null, "Err - û�д�ѧ����");
										}
									}
								}
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			});
			
			// ���ǵ�ͼ
			JLabel bga=new JLabel(new ImageIcon("src\\ImgPic\\SysTechStuShow_V2.png"));
			jPStudent.add(bga);
			bga.setBounds(-50, 0, 725, 540);
			
			/*******************************************************************/
			// ����ҳ
			JPanel jPScore = new JPanel();
			jPScore.setOpaque(false);
			jPScore.setLayout(null);
			
			JLabel scoList=new JLabel("�ɼ��б�");
			scoList.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			scoList.setForeground(Color.white);
			scoList.setBounds(33,48,150,50);
			jPScore.add(scoList);
			
			JLabel scoAdd=new JLabel("��ӳɼ�");
			scoAdd.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			scoAdd.setForeground(Color.white);
			scoAdd.setBounds(33,255,150,50);
			jPScore.add(scoAdd);
			
			JLabel scoDel=new JLabel("ɾ���ɼ�");
			scoDel.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			scoDel.setForeground(Color.white);
			scoDel.setBounds(33,375,150,50);
			jPScore.add(scoDel);
			
			JLabel suscobdel=new JLabel();
			
			JTextField inscoDel=new JTextField();
			inscoDel.setOpaque(false);
			inscoDel.setFont(new Font("Microsoft Yahei UI Light",Font.PLAIN,13));    //�޸�������ʽ
			inscoDel.setText("");
			inscoDel.setBounds(33,435,233,35);	
			jPScore.add(inscoDel);
			
			inscoDel.addFocusListener(new FocusListener(){
	   			//��ý���
	   			@Override
	   			public void focusGained(FocusEvent e) {
	   				suscobdel.setText(" ");
	   			}
	   			//ʧȥ����
	   			@Override
	   			public void focusLost(FocusEvent e) {
	   				if(inscoDel.getText().trim() == null || inscoDel.getText().trim().length() == 0) {
	   					suscobdel.setText("ѧ��");
					}
	   			}
	   		});
			
			suscobdel.setText("ѧ��");
			suscobdel.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 14));
			suscobdel.setBounds(35,435,150,35);
			jPScore.add(suscobdel);
			
			// ���ǵ�ͼ
			JLabel bgb=new JLabel(new ImageIcon("src\\ImgPic\\SysTechScoShow_V1.png"));
			jPScore.add(bgb);
			bgb.setBounds(-50, 0, 725, 540);
			
			/*******************************************************************/
			// ����ҳ
			
			JPanel jPTableSet = new JPanel();
			jPTableSet.setOpaque(false);
			jPTableSet.setLayout(null);
			
			JLabel tabList=new JLabel("�����б�");
			tabList.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			tabList.setForeground(Color.white);
			tabList.setBounds(33,48,150,50);
			jPTableSet.add(tabList);
			
			JLabel tabPass=new JLabel("������");
			tabPass.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			tabPass.setForeground(Color.white);
			tabPass.setBounds(33,375,150,50);
			jPTableSet.add(tabPass);
			
			JLabel subtbdel=new JLabel();
			
			JTextField intbDel=new JTextField();
			intbDel.setOpaque(false);
			intbDel.setFont(new Font("Microsoft Yahei UI Light",Font.PLAIN,13));    //�޸�������ʽ
			intbDel.setText("");
			intbDel.setBounds(33,435, 233, 35);	
			jPTableSet.add(intbDel);
			
			intbDel.addFocusListener(new FocusListener(){
	   			//��ý���
	   			@Override
	   			public void focusGained(FocusEvent e) {
	   				subtbdel.setText(" ");
	   			}
	   			//ʧȥ����
	   			@Override
	   			public void focusLost(FocusEvent e) {
	   				if(intbDel.getText().trim() == null || intbDel.getText().trim().length() == 0) {
	   					subtbdel.setText("���");
					}
	   			}
	   		});
			
			subtbdel.setText("���");
			subtbdel.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 14));
			subtbdel.setBounds(35,435, 255, 35);
			jPTableSet.add(subtbdel);
			
			DefaultListModel<String> listTbThingsa = new DefaultListModel<String>();
			 listTbThingsa.addElement("����");
			DefaultListModel<String> listTbSta = new DefaultListModel<String>();
			listTbSta.addElement("״̬");
			DefaultListModel<String> listTbWhoa = new DefaultListModel<String>();
			listTbWhoa.addElement("������");
			DefaultListModel<String> listIDa = new DefaultListModel<String>();
			listIDa.addElement("ID");
			 
			try {
				Statement stmt = SysClass.SysData.conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Back");
				SysClass.printLog("���ڳ�ʼ��������Ϣ����");
				while(rs.next()) {
					int uid = rs.getInt("uid");
					String things = rs.getString("����");
					int stat = rs.getInt("״̬");
					String getter = rs.getString("������");
					int id = rs.getInt("id");
					
					Statement stmta = SysClass.SysData.conn.createStatement();
					ResultSet rsa = stmta.executeQuery("SELECT * FROM Student");
					while(rsa.next()) {
						int uidaa = rsa.getInt("uid");
						String teachername = rsa.getString("������");
						if(uid == uidaa && teachername.equals(SysClass.SysData.uname)) {
							listTbThingsa.addElement(things);
							listIDa.addElement(id + "");
							if(stat == 0) {
								listTbSta.addElement("δ����");
								listTbWhoa.addElement(" ");
							}
							else {
								listTbSta.addElement("�Ѵ���");
								listTbWhoa.addElement(getter);
							}
						}
					}
				}
			}
			catch (SQLException e1) {
				SysClass.printErr("���ݿ��ѯ����");
				e1.printStackTrace();
			}
			SysClass.printLog("��ʼ��������Ϣ��ɡ�");
			
			JList<String> TbIDa = new JList<String>(listIDa); 
			TbIDa.setBounds(35,95,30,270);
			TbIDa.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			TbIDa.setBackground(Color.white);
			TbIDa.setFocusable(false);			// ȥ�������
			jPTableSet.add(TbIDa);
			TbIDa.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					TbIDa.clearSelection();
				}
	        });
			
			JList<String> TbThingsa = new JList<String>(listTbThingsa); 
			TbThingsa.setBounds(65,95,370,270);
			TbThingsa.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			TbThingsa.setBackground(Color.white);
			TbThingsa.setFocusable(false);			// ȥ�������
			jPTableSet.add(TbThingsa);
			TbThingsa.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					TbThingsa.clearSelection();
				}
	        });
			
			JList<String> TbStata = new JList<String>(listTbSta); 
			TbStata.setBounds(435,95,50,270);
			TbStata.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			TbStata.setBackground(Color.white);
			TbStata.setFocusable(false);			// ȥ�������
			jPTableSet.add(TbStata);
			TbStata.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					TbStata.clearSelection();
				}
	        });
			
			JList<String> TbWhoa = new JList<String>(listTbWhoa); 
			TbWhoa.setBounds(535,95,50,270);
			TbWhoa.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			TbWhoa.setBackground(Color.white);
			TbWhoa.setFocusable(false);			// ȥ�������
			jPTableSet.add(TbWhoa );
			TbWhoa.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					TbWhoa.clearSelection();
				}
	        });
			
			JButton jbtDel = new JButton("");
			jbtDel.setBounds(245,385, 35,40);	   // ����λ�ü���С
			jbtDel.setContentAreaFilled(false); 	 // ȥ������
			jbtDel.setFocusPainted(false);			// ȥ�������
			jbtDel.setBorderPainted(false);			// ȥ���߿�
			jPTableSet.add(jbtDel);
			jbtDel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbtDel) {
						SysClass.printLog("�����������£�");
						if(intbDel.getText().trim() == null || intbDel.getText().trim().length() == 0) {
							JOptionPane.showMessageDialog(null, "Err - ����д���ݣ�");
						}
						else {
							try {
								DBUtil.runUpdate("UPDATE `test`.`back` SET `״̬` = '1', `������` = '"+ SysClass.SysData.uname +"' WHERE `back`.`id` = " + intbDel.getText().trim(), SysClass.SysData.mainurl + "test" + SysClass.SysData.mainurladd);
								JOptionPane.showMessageDialog(null, "�������ɹ���");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			});
			
			// ���ǵ�ͼ
			JLabel bgd=new JLabel(new ImageIcon("src\\ImgPic\\SysTableGet_V1.png"));
			jPTableSet.add(bgd);
			bgd.setBounds(-50, 0, 725, 540);
			
			/*******************************************************************/
			// ����ҳ
			JPanel jPTable = new JPanel();
			 jPTable.setOpaque(false);
			 jPTable.setLayout(null);
			 
			 DefaultListModel<String> listTbThings = new DefaultListModel<String>();
			 listTbThings.addElement("����");
			DefaultListModel<String> listTbSt = new DefaultListModel<String>();
			listTbSt.addElement("״̬");
			DefaultListModel<String> listTbWho = new DefaultListModel<String>();
			listTbWho.addElement("������");
			 
			JLabel titleListTable=new JLabel("�ҵĹ���");
			titleListTable.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			titleListTable.setForeground(Color.white);
			titleListTable.setBounds(35,111,150,50);
			jPTable.add(titleListTable);
			 
			 JButton jbLogin = new JButton("");
			jbLogin.setBounds(545,51, 50,41);	// ����λ�ü���С
			jbLogin.setContentAreaFilled(false); 	// ȥ������
			jbLogin.setFocusPainted(false);			// ȥ�������
			jbLogin.setBorderPainted(false);		// ȥ���߿�
			jPTable.add(jbLogin);

			JLabel inpsubtitle=new JLabel();

			JTextField inTable=new JTextField();
			inTable.setOpaque(false);
			 inTable.setFont(new Font("Microsoft Yahei UI Light",Font.PLAIN,13));
			 inTable.setText("");
			 inTable.setBounds(23,51, 525, 43);	
			 inTable.setBorder(new EmptyBorder(0,0,0,0));
			 jPTable.add(inTable);
			 
			 inTable.addFocusListener(new FocusListener(){
		   			//��ý���
		   			@Override
		   			public void focusGained(FocusEvent e) {
		   				inpsubtitle.setText(" ");
		   			}
		   			//ʧȥ����
		   			@Override
		   			public void focusLost(FocusEvent e) {
		   				if(inTable.getText().trim() == null || inTable.getText().trim().length() == 0) {
		   					inpsubtitle.setText("�����빤������");
						}
		   			}
		   		});
			 
			inpsubtitle.setText("�����빤������");
			inpsubtitle.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 14));
			inpsubtitle.setBounds(28, 51, 525, 43);
			jPTable.add(inpsubtitle);
			
			int[] id = { 0 };
			
			jbLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==jbLogin) {
					SysClass.printLog("���ͱ����£�");
					if(inTable.getText().trim() == null || inTable.getText().trim().length() == 0) {
						SysClass.printErr("���ڿհ������");
						JOptionPane.showMessageDialog(null, "Err - ���������ݡ�");
					}
					else {
						try {
							DBUtil.runUpdate("INSERT INTO `test`.`back` (`uid`,`id`, `����`, `״̬`, `������`) VALUES (' " + SysClass.SysData.uid + " ', '"+ (id[0]+1) +" ', ' " + inTable.getText().trim() + " ', '0', '')", SysClass.SysData.mainurl + "test" + SysClass.SysData.mainurladd);
							id[0] += 1;
							listTbThings.addElement(inTable.getText().trim());
							listTbWho.addElement(" ");
							listTbSt.addElement("δ����");
							SysClass.printLog("����������ϣ�");
							JOptionPane.showMessageDialog(null, "�ύ�����ɹ���");
						}
						catch (SQLException e1) {
							SysClass.printErr("���ݿ��ѯ����");
							e1.printStackTrace();
						}
					}
				}
			}});
			 
			try {
				Statement stmt = SysClass.SysData.conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Back;");
				SysClass.printLog("���ڳ�ʼ��������Ϣ����");
				while(rs.next()) {
					id[0] = rs.getInt("id");
					int uid = rs.getInt("uid");
					String things = rs.getString("����");
					int stat = rs.getInt("״̬");
					String getter = rs.getString("������");
					
					if(uid == SysClass.SysData.uid) {
						listTbThings.addElement(things);
						if(stat == 0) {
							listTbSt.addElement("δ����");
							listTbWho.addElement(" ");
						}
						else {
							listTbSt.addElement("�Ѵ���");
							listTbWho.addElement(getter);
						}
					}
				}
			}
			catch (SQLException e1) {
				SysClass.printErr("���ݿ��ѯ����");
				e1.printStackTrace();
			}
			SysClass.printLog("��ʼ��������Ϣ��ɡ�");
			
			JList<String> TbThings = new JList<String>(listTbThings); 
			TbThings.setBounds(35,160,400,320);
			TbThings.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			TbThings.setBackground(Color.white);
			TbThings.setFocusable(false);			// ȥ�������
			jPTable.add(TbThings);
			TbThings.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					TbThings.clearSelection();
				}
	        });
			
			JList<String> TbStat = new JList<String>(listTbSt); 
			TbStat.setBounds(435,160,50,320);
			TbStat.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			TbStat.setBackground(Color.white);
			TbStat.setFocusable(false);			// ȥ�������
			jPTable.add(TbStat );
			TbStat.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					TbStat.clearSelection();
				}
	        });
			
			JList<String> TbWho = new JList<String>(listTbWho); 
			TbWho.setBounds(535,160,50,320);
			TbWho.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			TbWho.setBackground(Color.white);
			TbWho.setFocusable(false);			// ȥ�������
			jPTable.add(TbWho );
			TbWho.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					TbWho.clearSelection();
				}
	        });
			 
			// ���ǵ�ͼ
			JLabel bgc=new JLabel(new ImageIcon("src\\ImgPic\\SysStuTable_V1.png"));
			 jPTable.add(bgc);
			bgc.setBounds(-50, 0, 725, 540);
			
			/*******************************************************************/
			// ��ӽ�CardLayout
			jPC.add("info", jPInfo);					// ��һҳ
			jPC.add("student", jPStudent);		// �ڶ�ҳ
			jPC.add("score", jPScore);			// ����ҳ
			jPC.add("tableget", jPTableSet);		// ����ҳ
			jPC.add("table", jPTable);				// ����ҳ
			
			
			/*******************************************************************/
			// ��������ͼ
			JLabel bgm=new JLabel(new ImageIcon("src\\ImgPic\\SysUI_V2.png"));
			 jP.add(bgm);
			bgm.setBounds(0, 0, 956, 513);
			
			return jP;
		}
	}
}
