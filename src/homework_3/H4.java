package homework_3;

import java.io.*;

public class H4 {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("d:/io/student.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Student s1 = new Student("10086", "����", "2000��1��1��");
		Student s2 = new Student("10086", "����", "2000��1��2��");
		oos.writeObject(s1);
		oos.writeObject(s2);
		oos.flush();
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("d:/io/student.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object c = null;
		try {
			while((c = ois.readObject()) != null) {
				System.out.println(c.toString());
				System.out.println("-------------------------------------------");
			}
		}catch(EOFException e) {
			System.out.println("��ȡ��ϣ�");
		}
		ois.close();
	}
}
class Student implements Serializable{
	/**
	 * ����ʲô��û�У�
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String birth;
	Student(String id, String name, String birth){
		this.id = id;
		this.name = name;
		this.birth = birth;
	}
	public String toString() {
		return "ѧ��idΪ��"+id +"\nѧ������Ϊ��"+ name +"\nѧ������Ϊ��"+ birth;
	}
}