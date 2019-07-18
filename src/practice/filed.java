package practice;
import java.io.File;
import java.io.IOException;

/**
 * 创建文件
 */
public class filed {

    public static void main(String[] args) {
        //创建文件的4种方法
        //通过路径名
        File f1 = new File("D:/test/test1.txt");
        isEmpty(f1);
        //默认创建到当前工程目录下
        File f2 = new File("test2.txt");
        System.out.println(f2.getPath());
        isEmpty(f2);
        //根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例
        File f3 = new File("D:/test", "test3.txt");
        isEmpty(f3);
        //根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例
        File f = new File("D:/test");
        File f4 = new File(f, "test4.txt");
        isEmpty(f4);
    }

    private static void isEmpty(File file) {
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("创建文件成功");
                } else {
                    System.out.println("创建文件失败");
                }
            }
            catch (IOException e) {
                e.printStackTrace();
                System.out.println("创建文件报错;可能输路径不存在");
            }
        }
    }
}
