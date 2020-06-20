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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
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
			title.setBounds(70,-5, 150,50);	
			jP.add(title);
			
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
			JButton jbExit = new JButton("     �˳���¼");
			
			jbInfo.setBounds(0,55, 230,35);	   // ����λ�ü���С
			jbInfo.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			jbInfo.setHorizontalAlignment(SwingConstants.LEFT);
			jbInfo.setBackground(Color.decode("#222222"));
			jbInfo.setContentAreaFilled(false); 	 // ȥ������
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
						// ����
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
						// ����
						SysClass.printLog("������Ϣ�����£�");
						pageCard.show(jPC, "info");
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
						// ����
						SysClass.printLog("�ɼ���Ϣ�����£�");
						pageCard.show(jPC, "score");
					}
				}
			});
			
			jbExit.setBounds(0,160, 230,35);	   // ����λ�ü���С
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
						// �˳�
						SysClass.printLog("�˳���¼�����£�");
						new run.JPanelTest();
						dispose();
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
	    	            	if(!data.getColumnLabel(i).equals("uid")) {
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
			 listBoxTitle.setBackground(Color.decode("#EEEEEE"));
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
			 listBoxThings.setBackground(Color.decode("#EEEEEE"));
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
			JLabel bg=new JLabel(new ImageIcon("src\\ImgPic\\SysStuInfo_V3.png"));
			jPInfo.add(bg);
			bg.setBounds(-50, 0, 725, 540);
			
			
			/*******************************************************************/
			// �ڶ�ҳ
			JPanel jPScore = new JPanel();
			jPScore.setOpaque(false);
			jPScore.setLayout(null);
			
			// �����б��
			DefaultListModel<String> listScID = new DefaultListModel<String>();
			listScID.addElement("���");
			DefaultListModel<String> listScTime = new DefaultListModel<String>();
			listScTime.addElement("ѧ��");
			DefaultListModel<String> listScName = new DefaultListModel<String>();
			listScName.addElement("�γ�");
			DefaultListModel<String> listScScore = new DefaultListModel<String>();
			listScScore.addElement("�ɼ�");
			
			JLabel titleList=new JLabel("�ɼ��б�");
			titleList.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			titleList.setForeground(Color.white);
			titleList.setBounds(50,45,150,50);
			jPScore.add(titleList);
			
			SysClass.printLog("���ڳ�ʼ���ɼ���Ϣ����");
			try {
				Statement stmt = DBUtil.createConnection("jdbc:mysql://system.chuhelan.com:3306/score?"+"characterEncoding=utf8&useUnicode=true&useSSL=false").createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM uid"+ SysClass.SysData.uid +";");
				while(rs.next()) {
					listScID.addElement("");
					listScID.addElement(rs.getInt("���") + "");
					listScTime.addElement("");
					listScTime.addElement(rs.getString("ѧ��"));
					listScName.addElement("");
					listScName.addElement(rs.getString("�γ�"));
					listScScore.addElement("");
					listScScore.addElement(rs.getInt("�ɼ�") + "");
				}
			}
            catch (SQLException e1) {
				SysClass.printErr("���ݿ��ѯ����");
				e1.printStackTrace();
			}
			SysClass.printLog("��ʼ���ɼ���Ϣ��ɣ�");
			
			JList<String> listBoxScID = new JList<String>(listScID); 
			listBoxScID.setBounds(50,95,60,195);
			listBoxScID.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			listBoxScID.setFocusable(false);			// ȥ�������
			jPScore.add(listBoxScID);
			listBoxScID.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					listBoxScID.clearSelection();
				}
	        });
			listBoxScID.setOpaque(false); 
			listBoxScID.setCellRenderer(new DefaultListCellRenderer() {
			            /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

						@Override
			            public Component getListCellRendererComponent(JList<?> jlist, Object o, int i, boolean bln, boolean bln1) {
			                Component listCellRendererComponent = super.getListCellRendererComponent(jlist, o, i, bln, bln1);
			                JLabel label=(JLabel) listCellRendererComponent;
			                label.setOpaque(false);
			                return label;
			            }
			        });
			JList<String> listBoxScTime = new JList<String>(listScTime); 
			listBoxScTime.setBounds(110,95, 230,195);
			listBoxScTime.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			listBoxScTime.setBackground(Color.white);
			listBoxScTime.setFocusable(false);			// ȥ�������
			jPScore.add(listBoxScTime);
			listBoxScTime.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					listBoxScTime.clearSelection();
				}
	        });
			listBoxScTime.setOpaque(false); 
			listBoxScTime.setCellRenderer(new DefaultListCellRenderer() {
			            /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

						@Override
			            public Component getListCellRendererComponent(JList<?> jlist, Object o, int i, boolean bln, boolean bln1) {
			                Component listCellRendererComponent = super.getListCellRendererComponent(jlist, o, i, bln, bln1);
			                JLabel label=(JLabel) listCellRendererComponent;
			                label.setOpaque(false);
			                return label;
			            }
			        });
			JList<String> listBoxScName = new JList<String>(listScName); 
			listBoxScName.setBounds(340,95, 190,195);
			listBoxScName.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			listBoxScName.setBackground(Color.white);
			listBoxScName.setFocusable(false);			// ȥ�������
			jPScore.add(listBoxScName);
			listBoxScName.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					listBoxScName.clearSelection();
				}
	        });
			listBoxScName.setOpaque(false); 
			listBoxScName.setCellRenderer(new DefaultListCellRenderer() {
			            /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

						@Override
			            public Component getListCellRendererComponent(JList<?> jlist, Object o, int i, boolean bln, boolean bln1) {
			                Component listCellRendererComponent = super.getListCellRendererComponent(jlist, o, i, bln, bln1);
			                JLabel label=(JLabel) listCellRendererComponent;
			                label.setOpaque(false);
			                return label;
			            }
			        });
			JList<String> listBoxScScore = new JList<String>(listScScore); 
			listBoxScScore.setBounds(530,95, 50,195);
			listBoxScScore.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			listBoxScScore.setBackground(Color.white);
			listBoxScScore.setFocusable(false);			// ȥ�������
			jPScore.add(listBoxScScore);
			listBoxScScore.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					listBoxScScore.clearSelection();
				}
	        });
			listBoxScScore.setOpaque(false); 
			listBoxScScore.setCellRenderer(new DefaultListCellRenderer() {
			            /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

						@Override
			            public Component getListCellRendererComponent(JList<?> jlist, Object o, int i, boolean bln, boolean bln1) {
			                Component listCellRendererComponent = super.getListCellRendererComponent(jlist, o, i, bln, bln1);
			                JLabel label=(JLabel) listCellRendererComponent;
			                label.setOpaque(false);
			                return label;
			            }
			        });
			
			// ���ǵ�ͼ
			JLabel bga=new JLabel(new ImageIcon("src\\ImgPic\\SysStuScore_V2.png"));
			jPScore.add(bga);
			bga.setBounds(-50, 0, 725, 540);
			
			/*******************************************************************/
			// ��ӽ�CardLayout
			jPC.add("info", jPInfo);				// ��һҳ
			jPC.add("score", jPScore);		// �ڶ�ҳ
			
			
			/*******************************************************************/
			// ��������ͼ
			JLabel bgm=new JLabel(new ImageIcon("src\\ImgPic\\SysUI_V2.png"));
			 jP.add(bgm);
			bgm.setBounds(0, 0, 956, 513);
			
			return jP;
		}
	}
}
