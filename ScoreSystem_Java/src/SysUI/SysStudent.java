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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Features.DBUtil;
import Features.Login;
import Features.SysClass;


public class SysStudent {
	public static class JPanelSysSud extends JFrame {
		 
		private static final long serialVersionUID = -6740703588976621222L;
	 
		public JPanelSysSud() {
			super("学生 - 学生管理系统");
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
			SysClass.printLog("载入学生管理界面。");
			JPanel jP = new JPanel();
			jP.setOpaque(false);
			jP.setLayout(null);									// 设置空布局，即绝对布局
			
			JLabel title=new JLabel("学生管理");
			title.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			title.setBounds(75,-5, 150,50);	
			jP.add(title);
			
			JLabel version=new JLabel(SysClass.SysData.version);
			version.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 13));
			version.setBounds(15,446, 150,50);	
			jP.add(version);
			
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
			JButton jbScore = new JButton("     成绩信息");
			JButton jbTable = new JButton("     提交工单");
			JButton jbExit = new JButton("");
			
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
						jbTable.setBackground(Color.decode("#222222"));
						jbTable.setForeground(Color.black);
						jbTable.setContentAreaFilled(false);
						// 功能
						SysClass.printLog("基础信息被按下！");
						pageCard.show(jPC, "info");
					}
				}
			});
			
			jbScore.setBounds(0,90, 230,35);	   // 设置位置及大小
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
						jbTable.setBackground(Color.decode("#222222"));
						jbTable.setForeground(Color.black);
						jbTable.setContentAreaFilled(false);
						// 功能
						SysClass.printLog("成绩信息被按下！");
						pageCard.show(jPC, "score");
					}
				}
			});
			
			jbTable.setBounds(0,125, 230,35);	   // 设置位置及大小
			jbTable.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			jbTable.setHorizontalAlignment(SwingConstants.LEFT);
			jbTable.setBackground(Color.decode("#222222"));
			jbTable.setContentAreaFilled(false); 	 // 去除背景
			jbTable.setFocusPainted(false);			// 去除焦点框
			jbTable.setBorderPainted(false);			// 去除边框
			jP.add(jbTable);
			
			jbTable.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbTable) {
						// 显示
						jbTable.setBackground(Color.decode("#4285f4"));
						jbTable.setForeground(Color.white);
						jbTable.setContentAreaFilled(true);
						// 去除
						jbInfo.setBackground(Color.decode("#222222"));
						jbInfo.setForeground(Color.black);
						jbInfo.setContentAreaFilled(false);
						jbExit.setBackground(Color.decode("#222222"));
						jbExit.setForeground(Color.black);
						jbExit.setContentAreaFilled(false);
						jbScore.setBackground(Color.decode("#222222"));
						jbScore.setForeground(Color.black);
						jbScore.setContentAreaFilled(false);
						// 功能
						SysClass.printLog("提交工单被按下！");
						pageCard.show(jPC, "table");
					}
				}
			});
			
			jbExit.setBounds(187,455, 30,30);	   // 设置位置及大小
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
						jbTable.setBackground(Color.decode("#222222"));
						jbTable.setForeground(Color.black);
						jbTable.setContentAreaFilled(false);
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
			JLabel bg=new JLabel(new ImageIcon("src\\ImgPic\\SysStuInfo_V4.png"));
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
				Connection comstmt = DBUtil.createConnection(SysClass.SysData.mainurl + "score" + SysClass.SysData.mainurladd);
				Statement stmt = comstmt.createStatement();
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
				DBUtil.closeConnection(comstmt);
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
			// 第三页
			JPanel jPTable = new JPanel();
			 jPTable.setOpaque(false);
			 jPTable.setLayout(null);
			 
			 DefaultListModel<String> listTbThings = new DefaultListModel<String>();
			 listTbThings.addElement("内容");
			DefaultListModel<String> listTbSt = new DefaultListModel<String>();
			listTbSt.addElement("状态");
			DefaultListModel<String> listTbWho = new DefaultListModel<String>();
			listTbWho.addElement("处理人");
			 
			JLabel titleListTable=new JLabel("我的工单");
			titleListTable.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			titleListTable.setForeground(Color.white);
			titleListTable.setBounds(35,111,150,50);
			jPTable.add(titleListTable);
			 
			 JButton jbLogin = new JButton("");
			jbLogin.setBounds(545,51, 50,41);	// 设置位置及大小
			jbLogin.setContentAreaFilled(false); 	// 去除背景
			jbLogin.setFocusPainted(false);			// 去除焦点框
			jbLogin.setBorderPainted(false);		// 去除边框
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
		   			//获得焦点
		   			@Override
		   			public void focusGained(FocusEvent e) {
		   				inpsubtitle.setText(" ");
		   			}
		   			//失去焦点
		   			@Override
		   			public void focusLost(FocusEvent e) {
		   				if(inTable.getText().trim() == null || inTable.getText().trim().length() == 0) {
		   					inpsubtitle.setText("请输入工单内容");
						}
		   			}
		   		});
			 
			inpsubtitle.setText("请输入工单内容");
			inpsubtitle.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 14));
			inpsubtitle.setBounds(28, 51, 525, 43);
			jPTable.add(inpsubtitle);
			
			jbLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==jbLogin) {
					SysClass.printLog("发送被按下！");
					if(inTable.getText().trim() == null || inTable.getText().trim().length() == 0) {
						SysClass.printErr("存在空白输入框！");
						JOptionPane.showMessageDialog(null, "Err - 请输入内容。");
					}
					else {
						try {
							DBUtil.runUpdate("INSERT INTO `test`.`back` (`uid`, `内容`, `状态`, `处理人`) VALUES (' " + SysClass.SysData.uid + " ', ' " + inTable.getText().trim() + " ', '0', '')", SysClass.SysData.mainurl + "test" + SysClass.SysData.mainurladd);
							listTbThings.addElement(inTable.getText().trim());
							listTbWho.addElement(" ");
							listTbSt.addElement("未处理");
							SysClass.printLog("工单发送完毕！");
							JOptionPane.showMessageDialog(null, "提交工单成功！");
						}
						catch (SQLException e1) {
							SysClass.printErr("数据库查询错误！");
							e1.printStackTrace();
						}
					}
				}
			}});
			 
			try {
				Statement stmt = SysClass.SysData.conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Back");
				SysClass.printLog("正在初始化工单信息……");
				while(rs.next()) {
					int uid = rs.getInt("uid");
					String things = rs.getString("内容");
					int stat = rs.getInt("状态");
					String getter = rs.getString("处理人");
					
					if(uid == SysClass.SysData.uid) {
						listTbThings.addElement(things);
						if(stat == 0) {
							listTbSt.addElement("未处理");
							listTbWho.addElement(" ");
						}
						else {
							listTbSt.addElement("已处理");
							listTbWho.addElement(getter);
						}
					}
				}
			}
			catch (SQLException e1) {
				SysClass.printErr("数据库查询错误！");
				e1.printStackTrace();
			}
			SysClass.printLog("初始化工单信息完成。");
			
			JList<String> TbThings = new JList<String>(listTbThings); 
			TbThings.setBounds(35,160,400,320);
			TbThings.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			TbThings.setBackground(Color.white);
			TbThings.setFocusable(false);			// 去除焦点框
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
			TbStat.setFocusable(false);			// 去除焦点框
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
			TbWho.setFocusable(false);			// 去除焦点框
			jPTable.add(TbWho );
			TbWho.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					TbWho.clearSelection();
				}
	        });
			 
			// 这是底图
			JLabel bgb=new JLabel(new ImageIcon("src\\ImgPic\\SysStuTable_V1.png"));
			 jPTable.add(bgb);
			bgb.setBounds(-50, 0, 725, 540);
			
			/*******************************************************************/
			// 添加进CardLayout
			jPC.add("info", jPInfo);				// 第一页
			jPC.add("score", jPScore);		// 第二页
			jPC.add("table", jPTable);			// 第三页
			
			
			/*******************************************************************/
			// 这是主底图
			JLabel bgm=new JLabel(new ImageIcon("src\\ImgPic\\SysUI_V2.png"));
			 jP.add(bgm);
			bgm.setBounds(0, 0, 956, 513);
			
			return jP;
		}
	}
}
