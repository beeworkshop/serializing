package demo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author beeworkshop 这是一个POJO
 */
public class Alien implements Serializable {

	/**
	 * 系统生成的serialVersionUID
	 */
	private static final long serialVersionUID = -2275858790201255513L;

	private String name;
	private String gender;
	private int age;
	private transient String lover; // 你能暴露情人吗
	private Date date = new Date();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLover() {
		return lover;
	}

	public void setLover(String lover) {
		this.lover = lover;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Alien [name=" + name + ", gender=" + gender + ", age=" + age + ", lover=" + lover + ", date=" + date
				+ "]";
	}

}
