package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args)
			throws FileNotFoundException, IOException, ClassNotFoundException, InterruptedException {
		Alien alien = new Alien();
		alien.setAge(31);
		alien.setGender("男");
		alien.setName("王宝强");
		alien.setLover("春花");
		System.out.println("内存中的对象：" + alien);
		System.out.println("======================");

		// 将对象输出到外存
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("F:/tmp/Alien.obj"));
		out.writeObject(alien);
		out.close();
		System.out.println("输出到外存文件：F:/tmp/Alien.obj");
		System.out.println("======================");

		TimeUnit.SECONDS.sleep(5);

		// 从外部文件载入对象
		System.out.println("从外存文件F:/tmp/Alien.obj载入对象");
		ObjectInput in = new ObjectInputStream(new FileInputStream(new File("F:/tmp/Alien.obj")));
		Object obj = in.readObject();
		in.close();
		System.out.println("载入的类类型：");
		System.out.println(obj.getClass());

		Alien alien2 = (Alien) obj;
		alien2.setDate(new Date());
		System.out.println("======================");
		System.out.println("强转载入后的对象：");
		System.out.println(alien2);

	}

}
