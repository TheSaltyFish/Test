package com.runoob.test;

import javax.swing.JOptionPane;

public class Test3 {
	public static void main(String[] args) {
		  //������Ϣ�Ի���
		  JOptionPane.showMessageDialog(null, "hello world !");
		  //����ȷ�϶Ի���
		  int  option=JOptionPane.showConfirmDialog(null, "1+1=2?");
		  if(option==JOptionPane.YES_OPTION)
		   System.out.println("��ѡ�����Yes");
		  else
		   System.out.println("��ѡ�����No");
		  String name=JOptionPane.showInputDialog("������������֣�");
		  int    age =Integer.parseInt(JOptionPane.showInputDialog("������������䣺"));
		  JOptionPane.showMessageDialog(null, "��ã�"+name+"\n�����"+age+"����");
		 }
}
