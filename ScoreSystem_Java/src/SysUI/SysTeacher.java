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
			JButton jbStudent = new JButton("     学生管理");
			JButton jbScore = new JButton("     成绩管理");
			JButton jbTabPass = new JButton("     工单处理");
			JButton jbTable = new JButton("     提交工单");
			JButton jbExit = new JButton("");
			
			jbInfo.setBounds(0,55, 230,35);	   // 设置位置及大小
			jbInfo.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			jbInfo.setHorizontalAlignment(SwingConstants.LEFT);
			jbInfo.setBackground(Color.decode("#4285f4"));
			jbInfo.setForeground(Color.white);
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
						jbTabPass.setBackground(Color.decode("#222222"));
						jbTabPass.setForeground(Color.black);
						jbTabPass.setContentAreaFilled(false);
						jbTable.setBackground(Color.decode("#222222"));
						jbTable.setForeground(Color.black);
						jbTable.setContentAreaFilled(false);
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
						jbTabPass.setBackground(Color.decode("#222222"));
						jbTabPass.setForeground(Color.black);
						jbTabPass.setContentAreaFilled(false);
						jbTable.setBackground(Color.decode("#222222"));
						jbTable.setForeground(Color.black);
						jbTable.setContentAreaFilled(false);
						// 功能
						SysClass.printLog("学生管理被按下！");
						pageCard.show(jPC, "student");
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
						jbTabPass.setBackground(Color.decode("#222222"));
						jbTabPass.setForeground(Color.black);
						jbTabPass.setContentAreaFilled(false);
						jbTable.setBackground(Color.decode("#222222"));
						jbTable.setForeground(Color.black);
						jbTable.setContentAreaFilled(false);
						// 功能
						SysClass.printLog("成绩信息被按下！");
						pageCard.show(jPC, "score");
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
						jbStudent.setBackground(Color.decode("#222222"));
						jbStudent.setForeground(Color.black);
						jbStudent.setContentAreaFilled(false);
						jbTabPass.setBackground(Color.decode("#222222"));
						jbTabPass.setForeground(Color.black);
						jbTabPass.setContentAreaFilled(false);
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
			
			jbTabPass.setBounds(0,160, 230,35);	   // 设置位置及大小
			jbTabPass.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			jbTabPass.setHorizontalAlignment(SwingConstants.LEFT);
			jbTabPass.setBackground(Color.decode("#222222"));
			jbTabPass.setContentAreaFilled(false); 	 // 去除背景
			jbTabPass.setFocusPainted(false);			// 去除焦点框
			jbTabPass.setBorderPainted(false);			// 去除边框
			jP.add(jbTabPass);
			
			jbTabPass .addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbTabPass) {
						// 显示
						jbTabPass.setBackground(Color.decode("#4285f4"));
						jbTabPass.setForeground(Color.white);
						jbTabPass.setContentAreaFilled(true);
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
						jbExit.setBackground(Color.decode("#222222"));
						jbExit.setForeground(Color.black);
						jbExit.setContentAreaFilled(false);
						jbTable.setBackground(Color.decode("#222222"));
						jbTable.setForeground(Color.black);
						jbTable.setContentAreaFilled(false);
						// 功能
						SysClass.printLog("工单处理被按下！");
						pageCard.show(jPC, "tableget");
					}
				}
			});
			
			jbTable.setBounds(0,195, 230,35);	   // 设置位置及大小
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
						// 功能
						SysClass.printLog("提交工单被按下！");
						pageCard.show(jPC, "table");
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
	    	            	if(!data.getColumnLabel(i).equals("uid") && !data.getColumnLabel(i).equals("班主任")) {
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
			 listBoxTitle.setOpaque(false);
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
			 listBoxThings.setOpaque(false);
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
			JPanel jPStudent = new JPanel();
			jPStudent.setOpaque(false);
			jPStudent.setLayout(null);
			
			JLabel stuList=new JLabel("学生列表");
			stuList.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			stuList.setForeground(Color.white);
			stuList.setBounds(33,48,150,50);
			jPStudent.add(stuList);
			
			JLabel stuAdd=new JLabel("添加学生");
			stuAdd.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			stuAdd.setForeground(Color.white);
			stuAdd.setBounds(363,48,150,50);
			jPStudent.add(stuAdd);
			
			JLabel stuDel=new JLabel("删除学生");
			stuDel.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			stuDel.setForeground(Color.white);
			stuDel.setBounds(363,215,150,50);
			jPStudent.add(stuDel);
			
			DefaultListModel<String> listName = new DefaultListModel<String>();
			 listName.addElement("姓名");
			DefaultListModel<String> listID = new DefaultListModel<String>();
			listID.addElement("学号");
			
			int uidall = 0;
			
			try {
				Statement stmt = SysClass.SysData.conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Student;");
				while(rs.next()) {
					uidall = rs.getInt("uid");
					String name = rs.getString("姓名");
					String id = rs.getString("学号");
					String master = rs.getString("班主任");
					
					if(master.equals(SysClass.SysData.uname)) {
						 listName.addElement(name);
						 listID.addElement(id + "");
					}
				}
			}
			catch (SQLException e1) {
				SysClass.printErr("数据库查询错误！");
				e1.printStackTrace();
			}
			
			JList<String> listBoxScID = new JList<String>(listName); 
			listBoxScID.setBounds(50,95,150,195);
			listBoxScID.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			listBoxScID.setFocusable(false);			// 去除焦点框
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
			listBoxScTime.setFocusable(false);			// 去除焦点框
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
			inName.setFont(new Font("Microsoft Yahei UI Light",Font.PLAIN,13));    //修改字体样式
			inName.setText("");
			inName.setBounds(363, 107, 233, 35);	
			jPStudent.add(inName);
			
			inName.addFocusListener(new FocusListener(){
	   			//获得焦点
	   			@Override
	   			public void focusGained(FocusEvent e) {
	   				subname.setText(" ");
	   			}
	   			//失去焦点
	   			@Override
	   			public void focusLost(FocusEvent e) {
	   				if(inName.getText().trim() == null || inName.getText().trim().length() == 0) {
	   					subname.setText("名字");
					}
	   			}
	   		});
			
			subname.setText("名字");
			subname.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 14));
			subname.setBounds(368, 107, 255, 35);
			jPStudent.add(subname);
			
			JLabel subid=new JLabel();
			
			JTextField inID=new JTextField();
			inID.setOpaque(false);
			inID.setFont(new Font("Microsoft Yahei UI Light",Font.PLAIN,13));    //修改字体样式
			inID.setText("");
			inID.setBounds(363, 153, 233, 35);	
			jPStudent.add(inID);
			
			inID.addFocusListener(new FocusListener(){
	   			//获得焦点
	   			@Override
	   			public void focusGained(FocusEvent e) {
	   				subid.setText(" ");
	   			}
	   			//失去焦点
	   			@Override
	   			public void focusLost(FocusEvent e) {
	   				if(inID.getText().trim() == null || inID.getText().trim().length() == 0) {
	   					subid.setText("学号");
					}
	   			}
	   		});
			
			subid.setText("学号");
			subid.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 14));
			subid.setBounds(368, 153, 255, 35);
			jPStudent.add(subid);
			
			JLabel subdel=new JLabel();
			
			JTextField inDel=new JTextField();
			inDel.setOpaque(false);
			inDel.setFont(new Font("Microsoft Yahei UI Light",Font.PLAIN,13));    //修改字体样式
			inDel.setText("");
			inDel.setBounds(363, 273, 233, 35);	
			jPStudent.add(inDel);
			
			inDel.addFocusListener(new FocusListener(){
	   			//获得焦点
	   			@Override
	   			public void focusGained(FocusEvent e) {
	   				subdel.setText(" ");
	   			}
	   			//失去焦点
	   			@Override
	   			public void focusLost(FocusEvent e) {
	   				if(inDel.getText().trim() == null || inDel.getText().trim().length() == 0) {
	   					subdel.setText("学号");
					}
	   			}
	   		});
			
			subdel.setText("学号");
			subdel.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 14));
			subdel.setBounds(368, 273, 255, 35);
			jPStudent.add(subdel);
			
			int uida = uidall +1;
			
			JButton jbAdd = new JButton("");
			jbAdd.setBounds(570,53, 35,40);	   // 设置位置及大小
			jbAdd.setContentAreaFilled(false); 	 // 去除背景
			jbAdd.setFocusPainted(false);			// 去除焦点框
			jbAdd.setBorderPainted(false);			// 去除边框
			jPStudent.add(jbAdd);
			jbAdd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbAdd) {
						SysClass.printLog("添加学生被按下！");
						if(inID.getText().trim() == null || inID.getText().trim().length() == 0 || inName.getText().trim() == null || inName.getText().trim().length() == 0) {
							SysClass.printErr("存在空白输入框！");
							JOptionPane.showMessageDialog(null, "Err - 请输入完整内容。");
						}
						else {
							try {
								DBUtil.runUpdate("INSERT INTO `test`.`student` (`uid`, `姓名`, `学号`, `年龄`, `号码`, `住址`, `班主任`) VALUES ('"+ (uida + 1) +"', '"+ inName.getText().trim() +"', '"+ inID.getText().trim() +"', NULL, NULL, NULL, '"+ SysClass.SysData.uname +"')", SysClass.SysData.mainurl + "test" + SysClass.SysData.mainurladd);
								 listName.addElement(inName.getText().trim());
								 listID.addElement(inID.getText().trim());
								 JOptionPane.showMessageDialog(null, "添加学生成功！");
							} 
							catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			});
			
			JButton jbDel = new JButton("");
			jbDel.setBounds(575,220, 35,40);	   // 设置位置及大小
			jbDel.setContentAreaFilled(false); 	 // 去除背景
			jbDel.setFocusPainted(false);			// 去除焦点框
			jbDel.setBorderPainted(false);			// 去除边框
			jPStudent.add(jbDel);
			jbDel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbDel) {
						SysClass.printLog("删除学生被按下！");
						if(inDel.getText().trim() == null || inDel.getText().trim().length() == 0) {
							SysClass.printErr("存在空白输入框！");
							JOptionPane.showMessageDialog(null, "Err - 请输入完整内容。");
						}
						else {
							Statement stmt;
							try {
								stmt = SysClass.SysData.conn.createStatement();
								ResultSet rs = stmt.executeQuery("SELECT * FROM Student;");
								while(rs.next()) {
									String id = rs.getString("学号");
									int uid = rs.getInt("uid");
									if(id.equals(inDel.getText().trim())) {
										int where = listID.indexOf(inDel.getText().trim());
										SysClass.printErr("检索学生：");
										SysClass.printErr(">>" + where);
										if(where >= 0) {
											DBUtil.runUpdate("DELETE FROM `test`.`student` WHERE `student`.`uid` = "+ uid +"", SysClass.SysData.mainurl + "test" + SysClass.SysData.mainurladd);
											listID.removeElementAt(where);
											listName.removeElementAt(where);
											JOptionPane.showMessageDialog(null, "移除学生成功！");
										}
										else {
											JOptionPane.showMessageDialog(null, "Err - 没有此学生！");
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
			
			// 这是底图
			JLabel bga=new JLabel(new ImageIcon("src\\ImgPic\\SysTechStuShow_V2.png"));
			jPStudent.add(bga);
			bga.setBounds(-50, 0, 725, 540);
			
			/*******************************************************************/
			// 第三页
			JPanel jPScore = new JPanel();
			jPScore.setOpaque(false);
			jPScore.setLayout(null);
			
			JLabel scoList=new JLabel("成绩列表");
			scoList.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			scoList.setForeground(Color.white);
			scoList.setBounds(33,48,150,50);
			jPScore.add(scoList);
			
			JLabel scoAdd=new JLabel("添加成绩");
			scoAdd.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			scoAdd.setForeground(Color.white);
			scoAdd.setBounds(33,255,150,50);
			jPScore.add(scoAdd);
			
			JLabel scoDel=new JLabel("删除成绩");
			scoDel.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			scoDel.setForeground(Color.white);
			scoDel.setBounds(33,375,150,50);
			jPScore.add(scoDel);
			
			JLabel suscobdel=new JLabel();
			
			JTextField inscoDel=new JTextField();
			inscoDel.setOpaque(false);
			inscoDel.setFont(new Font("Microsoft Yahei UI Light",Font.PLAIN,13));    //修改字体样式
			inscoDel.setText("");
			inscoDel.setBounds(33,435,233,35);	
			jPScore.add(inscoDel);
			
			inscoDel.addFocusListener(new FocusListener(){
	   			//获得焦点
	   			@Override
	   			public void focusGained(FocusEvent e) {
	   				suscobdel.setText(" ");
	   			}
	   			//失去焦点
	   			@Override
	   			public void focusLost(FocusEvent e) {
	   				if(inscoDel.getText().trim() == null || inscoDel.getText().trim().length() == 0) {
	   					suscobdel.setText("学号");
					}
	   			}
	   		});
			
			suscobdel.setText("学号");
			suscobdel.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 14));
			suscobdel.setBounds(35,435,150,35);
			jPScore.add(suscobdel);
			
			// 这是底图
			JLabel bgb=new JLabel(new ImageIcon("src\\ImgPic\\SysTechScoShow_V1.png"));
			jPScore.add(bgb);
			bgb.setBounds(-50, 0, 725, 540);
			
			/*******************************************************************/
			// 第四页
			
			JPanel jPTableSet = new JPanel();
			jPTableSet.setOpaque(false);
			jPTableSet.setLayout(null);
			
			JLabel tabList=new JLabel("工单列表");
			tabList.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			tabList.setForeground(Color.white);
			tabList.setBounds(33,48,150,50);
			jPTableSet.add(tabList);
			
			JLabel tabPass=new JLabel("处理工单");
			tabPass.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 17));
			tabPass.setForeground(Color.white);
			tabPass.setBounds(33,375,150,50);
			jPTableSet.add(tabPass);
			
			JLabel subtbdel=new JLabel();
			
			JTextField intbDel=new JTextField();
			intbDel.setOpaque(false);
			intbDel.setFont(new Font("Microsoft Yahei UI Light",Font.PLAIN,13));    //修改字体样式
			intbDel.setText("");
			intbDel.setBounds(33,435, 233, 35);	
			jPTableSet.add(intbDel);
			
			intbDel.addFocusListener(new FocusListener(){
	   			//获得焦点
	   			@Override
	   			public void focusGained(FocusEvent e) {
	   				subtbdel.setText(" ");
	   			}
	   			//失去焦点
	   			@Override
	   			public void focusLost(FocusEvent e) {
	   				if(intbDel.getText().trim() == null || intbDel.getText().trim().length() == 0) {
	   					subtbdel.setText("编号");
					}
	   			}
	   		});
			
			subtbdel.setText("编号");
			subtbdel.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 14));
			subtbdel.setBounds(35,435, 255, 35);
			jPTableSet.add(subtbdel);
			
			DefaultListModel<String> listTbThingsa = new DefaultListModel<String>();
			 listTbThingsa.addElement("内容");
			DefaultListModel<String> listTbSta = new DefaultListModel<String>();
			listTbSta.addElement("状态");
			DefaultListModel<String> listTbWhoa = new DefaultListModel<String>();
			listTbWhoa.addElement("处理人");
			DefaultListModel<String> listIDa = new DefaultListModel<String>();
			listIDa.addElement("ID");
			 
			try {
				Statement stmt = SysClass.SysData.conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Back");
				SysClass.printLog("正在初始化工单信息……");
				while(rs.next()) {
					int uid = rs.getInt("uid");
					String things = rs.getString("内容");
					int stat = rs.getInt("状态");
					String getter = rs.getString("处理人");
					int id = rs.getInt("id");
					
					Statement stmta = SysClass.SysData.conn.createStatement();
					ResultSet rsa = stmta.executeQuery("SELECT * FROM Student");
					while(rsa.next()) {
						int uidaa = rsa.getInt("uid");
						String teachername = rsa.getString("班主任");
						if(uid == uidaa && teachername.equals(SysClass.SysData.uname)) {
							listTbThingsa.addElement(things);
							listIDa.addElement(id + "");
							if(stat == 0) {
								listTbSta.addElement("未处理");
								listTbWhoa.addElement(" ");
							}
							else {
								listTbSta.addElement("已处理");
								listTbWhoa.addElement(getter);
							}
						}
					}
				}
			}
			catch (SQLException e1) {
				SysClass.printErr("数据库查询错误！");
				e1.printStackTrace();
			}
			SysClass.printLog("初始化工单信息完成。");
			
			JList<String> TbIDa = new JList<String>(listIDa); 
			TbIDa.setBounds(35,95,30,270);
			TbIDa.setFont(new Font ("Microsoft Yahei UI Light", Font.PLAIN, 15));
			TbIDa.setBackground(Color.white);
			TbIDa.setFocusable(false);			// 去除焦点框
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
			TbThingsa.setFocusable(false);			// 去除焦点框
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
			TbStata.setFocusable(false);			// 去除焦点框
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
			TbWhoa.setFocusable(false);			// 去除焦点框
			jPTableSet.add(TbWhoa );
			TbWhoa.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					TbWhoa.clearSelection();
				}
	        });
			
			JButton jbtDel = new JButton("");
			jbtDel.setBounds(245,385, 35,40);	   // 设置位置及大小
			jbtDel.setContentAreaFilled(false); 	 // 去除背景
			jbtDel.setFocusPainted(false);			// 去除焦点框
			jbtDel.setBorderPainted(false);			// 去除边框
			jPTableSet.add(jbtDel);
			jbtDel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==jbtDel) {
						SysClass.printLog("处理工单被按下！");
						if(intbDel.getText().trim() == null || intbDel.getText().trim().length() == 0) {
							JOptionPane.showMessageDialog(null, "Err - 请填写内容！");
						}
						else {
							try {
								DBUtil.runUpdate("UPDATE `test`.`back` SET `状态` = '1', `处理人` = '"+ SysClass.SysData.uname +"' WHERE `back`.`id` = " + intbDel.getText().trim(), SysClass.SysData.mainurl + "test" + SysClass.SysData.mainurladd);
								JOptionPane.showMessageDialog(null, "处理工单成功！");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			});
			
			// 这是底图
			JLabel bgd=new JLabel(new ImageIcon("src\\ImgPic\\SysTableGet_V1.png"));
			jPTableSet.add(bgd);
			bgd.setBounds(-50, 0, 725, 540);
			
			/*******************************************************************/
			// 第五页
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
			
			int[] id = { 0 };
			
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
							DBUtil.runUpdate("INSERT INTO `test`.`back` (`uid`,`id`, `内容`, `状态`, `处理人`) VALUES (' " + SysClass.SysData.uid + " ', '"+ (id[0]+1) +" ', ' " + inTable.getText().trim() + " ', '0', '')", SysClass.SysData.mainurl + "test" + SysClass.SysData.mainurladd);
							id[0] += 1;
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
				ResultSet rs = stmt.executeQuery("SELECT * FROM Back;");
				SysClass.printLog("正在初始化工单信息……");
				while(rs.next()) {
					id[0] = rs.getInt("id");
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
			JLabel bgc=new JLabel(new ImageIcon("src\\ImgPic\\SysStuTable_V1.png"));
			 jPTable.add(bgc);
			bgc.setBounds(-50, 0, 725, 540);
			
			/*******************************************************************/
			// 添加进CardLayout
			jPC.add("info", jPInfo);					// 第一页
			jPC.add("student", jPStudent);		// 第二页
			jPC.add("score", jPScore);			// 第三页
			jPC.add("tableget", jPTableSet);		// 第四页
			jPC.add("table", jPTable);				// 第五页
			
			
			/*******************************************************************/
			// 这是主底图
			JLabel bgm=new JLabel(new ImageIcon("src\\ImgPic\\SysUI_V2.png"));
			 jP.add(bgm);
			bgm.setBounds(0, 0, 956, 513);
			
			return jP;
		}
	}
}
