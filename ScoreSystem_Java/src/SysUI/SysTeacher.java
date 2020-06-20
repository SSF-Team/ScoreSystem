/*******************************************************************/
/*    ██████ ╗████████ ╗ █████ ╗   ██████ ╗      ██  ╗   ██  ╗      */
/*    ██ ╔══════╝ ╚════██ ╔════╝██ ╔══██ ╗ ██ ╔═════██ ╗ ╚ ██ ╗ ██ ╔  ╝     */
/*    ██████ ╗         ██ ║        ██████ ║ ██████ ╔ ╝       ╚ ███ ╔ ╝         */
/*    ╚══════██ ║         ██ ║        ██ ╔══██ ║ ██ ╔══════╝          ██ ╔ ██ ╗        */
/*    ██████ ║         ██ ║        ██ ║   ██ ║ ██ ║                    ██ ╔ ╝ ██ ╗       */
/*    ╚══════════╝           ╚══╝          ╚══╝     ╚══╝   ╚══╝                      ╚══╝      ╚══╝       */
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
			super("教师 - 学生管理系统");
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
			SysClass.printLog("载入教师管理界面。");
			JPanel jP = new JPanel();
			jP.setOpaque(false);
			jP.setLayout(null);									// 设置空布局，即绝对布局
			
			JLabel title=new JLabel("教师管理");
			title.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			title.setBounds(70,-5, 150,50);	
			jP.add(title);
			
			// 卡片框架
			jPC.setOpaque(false);
			jPC.setLayout(null);
			jPC = new JPanel(pageCard);
			jPC.setBounds(240, -25, 725, 540);
			jP.add(jPC);
			
			/*******************************************************************/
			
			/*
			 * 这是三个左侧列表按钮（
			 * 因为按钮自定义样式容易一点
			 * 所以没用JList
			 */
			JButton jbInfo = new JButton("     基础信息");
			JButton jbStudent = new JButton("     学生管理");
			JButton jbScore = new JButton("     成绩管理");
			JButton jbExit = new JButton("     退出登录");
			
			jbInfo.setBounds(0,55, 230,35);	   // 设置位置及大小
			jbInfo.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			jbInfo.setHorizontalAlignment(SwingConstants.LEFT);
			jbInfo.setBackground(Color.decode("#222222"));
			jbInfo.setContentAreaFilled(false); 	 // 去除背景
			jbInfo.setFocusPainted(false);			// 去除焦点框
			jbInfo.setBorderPainted(false);			// 去除边框
			jP.add(jbInfo);
			
			jbInfo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbInfo) {
						// 显示
						jbInfo.setBackground(Color.decode("#4285f4"));
						jbInfo.setForeground(Color.white);
						jbInfo.setContentAreaFilled(true);
						// 去除
						jbScore.setBackground(Color.decode("#222222"));
						jbScore.setForeground(Color.black);
						jbScore.setContentAreaFilled(false);
						jbExit.setBackground(Color.decode("#222222"));
						jbExit.setForeground(Color.black);
						jbExit.setContentAreaFilled(false);
						jbStudent.setBackground(Color.decode("#222222"));
						jbStudent.setForeground(Color.black);
						jbStudent.setContentAreaFilled(false);
						// 功能
						SysClass.printLog("基础信息被按下！");
						pageCard.show(jPC, "info");
					}
				}
			});
			
			jbStudent.setBounds(0,90, 230,35);	   // 设置位置及大小
			jbStudent.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			jbStudent.setHorizontalAlignment(SwingConstants.LEFT);
			jbStudent.setBackground(Color.decode("#222222"));
			jbStudent.setContentAreaFilled(false); 	 // 去除背景
			jbStudent.setFocusPainted(false);			// 去除焦点框
			jbStudent.setBorderPainted(false);			// 去除边框
			jP.add(jbStudent);
			
			jbStudent.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbStudent) {
						// 显示
						jbStudent.setBackground(Color.decode("#4285f4"));
						jbStudent.setForeground(Color.white);
						jbStudent.setContentAreaFilled(true);
						// 去除
						jbScore.setBackground(Color.decode("#222222"));
						jbScore.setForeground(Color.black);
						jbScore.setContentAreaFilled(false);
						jbExit.setBackground(Color.decode("#222222"));
						jbExit.setForeground(Color.black);
						jbExit.setContentAreaFilled(false);
						jbInfo.setBackground(Color.decode("#222222"));
						jbInfo.setForeground(Color.black);
						jbInfo.setContentAreaFilled(false);
						// 功能
						SysClass.printLog("基础信息被按下！");
						pageCard.show(jPC, "info");
					}
				}
			});
			
			jbScore.setBounds(0,125, 230,35);	   // 设置位置及大小
			jbScore.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			jbScore.setHorizontalAlignment(SwingConstants.LEFT);
			jbScore.setBackground(Color.decode("#222222"));
			jbScore.setContentAreaFilled(false); 	 // 去除背景
			jbScore.setFocusPainted(false);			// 去除焦点框
			jbScore.setBorderPainted(false);			// 去除边框
			jP.add(jbScore);
			
			jbScore.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbScore) {
						// 显示
						jbScore.setBackground(Color.decode("#4285f4"));
						jbScore.setForeground(Color.white);
						jbScore.setContentAreaFilled(true);
						// 去除
						jbInfo.setBackground(Color.decode("#222222"));
						jbInfo.setForeground(Color.black);
						jbInfo.setContentAreaFilled(false);
						jbExit.setBackground(Color.decode("#222222"));
						jbExit.setForeground(Color.black);
						jbExit.setContentAreaFilled(false);
						jbStudent.setBackground(Color.decode("#222222"));
						jbStudent.setForeground(Color.black);
						jbStudent.setContentAreaFilled(false);
						// 功能
						SysClass.printLog("成绩信息被按下！");
						pageCard.show(jPC, "score");
					}
				}
			});
			
			jbExit.setBounds(0,160, 230,35);	   // 设置位置及大小
			jbExit.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			jbExit.setHorizontalAlignment(SwingConstants.LEFT);
			jbExit.setBackground(Color.decode("#222222"));
			jbExit.setContentAreaFilled(false); 	 // 去除背景
			jbExit.setFocusPainted(false);			// 去除焦点框
			jbExit.setBorderPainted(false);			// 去除边框
			jP.add(jbExit);
			
			jbExit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbExit) {
						// 显示
						jbExit.setBackground(Color.decode("#4285f4"));
						jbExit.setForeground(Color.white);
						jbExit.setContentAreaFilled(true);
						// 去除
						jbInfo.setBackground(Color.decode("#222222"));
						jbInfo.setForeground(Color.black);
						jbInfo.setContentAreaFilled(false);
						jbScore.setBackground(Color.decode("#222222"));
						jbScore.setForeground(Color.black);
						jbScore.setContentAreaFilled(false);
						jbStudent.setBackground(Color.decode("#222222"));
						jbStudent.setForeground(Color.black);
						jbStudent.setContentAreaFilled(false);
						// 退出
						SysClass.printLog("退出登录被按下！");
						new run.JPanelTest();
						dispose();
					}
				}
			});
			
			/*******************************************************************/
			// 第一页
			JPanel jPInfo = new JPanel();
			jPInfo.setOpaque(false);
			jPInfo.setLayout(null);
			
			// 创建列表框
			DefaultListModel<String> listModeTitle = new DefaultListModel<String>();
			DefaultListModel<String> listModeThings = new DefaultListModel<String>();
			
			SysClass.printLog("正在初始化个人信息……");
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
	    		            		listModeThings.addElement("Err - 数据类型错误");
	    		            	}
	    	            	}
	    	            }
	            	}
	            }
				if(!has) {
					SysClass.printErr("用户UID比对错误！");
					dispose();
					new run.JPanelTest();
					return jPInfo;
				}
			} catch (SQLException e1) {
				SysClass.printErr("数据库查询错误！");
				e1.printStackTrace();
			}
			SysClass.printLog("初始化个人信息完成！");
			
			JList<String> listBoxTitle = new JList<String>(listModeTitle); 
			 listBoxTitle.setBounds(294,146, 100,195);
			 listBoxTitle.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			 listBoxTitle.setBackground(Color.decode("#EEEEEE"));
			 listBoxTitle.setFocusable(false);			// 去除焦点框
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
			 listBoxThings.setFocusable(false);			// 去除焦点框
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
			
			JButton jbRep = new JButton("修改信息");
			jbRep.setBounds(290, 355, 185, 35);	  	 // 设置位置及大小
			jbRep.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			jbRep.setForeground(Color.white);
			jbRep.setBackground(Color.decode("#4285f4"));
			jbRep.setFocusPainted(false);			// 去除焦点框
			jbRep.setBorderPainted(false);		// 去除边框
			jPInfo.add(jbRep);
			
			jbRep.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbRep) {
						SysClass.printLog("修改被按下！");
						if(!isChanging) {
							isChanging = true;
							jbRep.setText("确认信息");
							listBoxThings.clearSelection();
							jbRep.setBounds(290, 355, 130, 35);
						}
						else {
							isChanging = false;
							jbRep.setText("修改信息");
							listBoxThings.clearSelection();
							jbRep.setBounds(290, 355, 185, 35);
						}
				    }
				}});
			
			JButton jbTru = new JButton("X");
			jbTru.setBounds(430, 355, 45, 35);	  	 // 设置位置及大小
			jbTru.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			jbTru.setForeground(Color.white);
			jbTru.setBackground(Color.decode("#4285f4"));
			jbTru.setFocusPainted(false);			// 去除焦点框
			jbTru.setBorderPainted(false);		// 去除边框
			jPInfo.add(jbTru);
			
			jbTru.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbTru) {
						SysClass.printLog("取消被按下！");
							isChanging = false;
							jbRep.setText("修改信息");
							listBoxThings.clearSelection();
							jbRep.setBounds(290, 355, 185, 35);
				    }
				}});
			
			// 这是底图
			JLabel bg=new JLabel(new ImageIcon("src\\ImgPic\\SysStuInfo_V3.png"));
			jPInfo.add(bg);
			bg.setBounds(-50, 0, 725, 540);
			
			
			/*******************************************************************/
			// 第二页
			JPanel jPScore = new JPanel();
			jPScore.setOpaque(false);
			jPScore.setLayout(null);
			
			// 创建列表框
			DefaultListModel<String> listScID = new DefaultListModel<String>();
			listScID.addElement("编号");
			DefaultListModel<String> listScTime = new DefaultListModel<String>();
			listScTime.addElement("学年");
			DefaultListModel<String> listScName = new DefaultListModel<String>();
			listScName.addElement("课程");
			DefaultListModel<String> listScScore = new DefaultListModel<String>();
			listScScore.addElement("成绩");
			
			JLabel titleList=new JLabel("成绩列表");
			titleList.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			titleList.setForeground(Color.white);
			titleList.setBounds(50,45,150,50);
			jPScore.add(titleList);
			
			SysClass.printLog("正在初始化成绩信息……");
			try {
				Statement stmt = DBUtil.createConnection("jdbc:mysql://system.chuhelan.com:3306/score?"+"characterEncoding=utf8&useUnicode=true&useSSL=false").createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM uid"+ SysClass.SysData.uid +";");
				while(rs.next()) {
					listScID.addElement("");
					listScID.addElement(rs.getInt("序号") + "");
					listScTime.addElement("");
					listScTime.addElement(rs.getString("学年"));
					listScName.addElement("");
					listScName.addElement(rs.getString("课程"));
					listScScore.addElement("");
					listScScore.addElement(rs.getInt("成绩") + "");
				}
			}
            catch (SQLException e1) {
				SysClass.printErr("数据库查询错误！");
				e1.printStackTrace();
			}
			SysClass.printLog("初始化成绩信息完成！");
			
			JList<String> listBoxScID = new JList<String>(listScID); 
			listBoxScID.setBounds(50,95,60,195);
			listBoxScID.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			listBoxScID.setFocusable(false);			// 去除焦点框
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
			listBoxScTime.setFocusable(false);			// 去除焦点框
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
			listBoxScName.setFocusable(false);			// 去除焦点框
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
			listBoxScScore.setFocusable(false);			// 去除焦点框
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
			
			// 这是底图
			JLabel bga=new JLabel(new ImageIcon("src\\ImgPic\\SysStuScore_V2.png"));
			jPScore.add(bga);
			bga.setBounds(-50, 0, 725, 540);
			
			/*******************************************************************/
			// 添加进CardLayout
			jPC.add("info", jPInfo);				// 第一页
			jPC.add("score", jPScore);		// 第二页
			
			
			/*******************************************************************/
			// 这是主底图
			JLabel bgm=new JLabel(new ImageIcon("src\\ImgPic\\SysUI_V2.png"));
			 jP.add(bgm);
			bgm.setBounds(0, 0, 956, 513);
			
			return jP;
		}
	}
}
