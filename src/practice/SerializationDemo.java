package practice;

import java.io.*;

public class SerializationDemo {
	public static void main(String args[]) {
		//定义一个文件输出流对象FileOutputStream和对象输出流对象ObjectOutputStream
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			//实例化上面定义的io流对象
			fos = new FileOutputStream("C:/Users/27378/Desktop/customer.txt");
			oos = new ObjectOutputStream(fos);
			//定义要序列化的具体对象
			Customer c1 = new Customer("Dingdang", 10, "kangfu", 200.0);
			Customer c2 = new Customer("Kenan", 7, "xiaolan", 2000.0);
			System.out.println("对象序列化...");
			//使用处理流ObjectOutputStream的writeObject方法来进行序列化
			oos.writeObject(c1);
			oos.writeObject(c2);
			//强制io流输出到文件
			oos.flush();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		getFxlh();
	}

	private static void getFxlh() {
		ObjectInputStream ois = null;
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:/Users/27378/Desktop/customer.txt");
			ois = new ObjectInputStream(fis);
			
			System.out.println("对象反序列化...");
			Object c = null;
			while ((c = ois.readObject()) != null) {
				Customer c1 = (Customer) c;
				System.out.println(c1.age + " " + c1.name + " " + c1.password);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			// TODO Auto-generated catch block
			  System.err.println("读取完毕");  
		} 	
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ois !=null){
					ois.close();
				}
				if(fis !=null){
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}