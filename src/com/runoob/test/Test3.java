package com.runoob.test;

import javax.swing.JOptionPane;

public class Test3 {
	public static void main(String[] args) {
		  //弹出消息对话框
		  JOptionPane.showMessageDialog(null, "hello world !");
		  //弹出确认对话框
		  int  option=JOptionPane.showConfirmDialog(null, "1+1=2?");
		  if(option==JOptionPane.YES_OPTION)
		   System.out.println("你选择的是Yes");
		  else
		   System.out.println("你选择的是No");
		  String name=JOptionPane.showInputDialog("请输入你的名字：");
		  int    age =Integer.parseInt(JOptionPane.showInputDialog("请输入你的年龄："));
		  JOptionPane.showMessageDialog(null, "你好，"+name+"\n你今年"+age+"岁了");
		 }
}
