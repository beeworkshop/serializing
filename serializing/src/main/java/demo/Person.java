package demo;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

public class Person {
	private String first, last;

	public Person(String first, String last) {
		this.first = first;
		this.last = last;
	}

	public Element getXML() {
		Element person = new Element("person");
		Element firstName = new Element("first");
		firstName.appendChild(first);
		Element lastName = new Element("last");
		lastName.appendChild(last);
		person.appendChild(firstName);
		person.appendChild(lastName);
		return person;
	}

	public Person(Element person) {
		first = person.getFirstChildElement("first").getValue();
		last = person.getFirstChildElement("last").getValue();
	}

	@Override
	public String toString() {
		return first + " " + last;
	}

	public static void format(OutputStream os, Document doc) throws Exception {
		Serializer serializer = new Serializer(os, "UTF-8");
		serializer.setIndent(4);
		serializer.setMaxLength(60);
		serializer.write(doc);
		serializer.flush();
	}

	public static void main(String[] args) throws Exception {
		List<Person> people = Arrays.asList(new Person("呼保义", "宋江"), new Person("玉麒麟", "卢俊义"), new Person("智多星", "吴用"),
				new Person("入云龙", "公孙胜"), new Person("大刀", "关胜"), new Person("豹子头", "林冲"), new Person("霹雳火", "秦明"),
				new Person("双鞭", "呼延灼"), new Person("小李广", "花荣"), new Person("小旋风", "柴进"), new Person("扑天雕", "李应"),
				new Person("美髯公", "朱仝"));
		System.out.println(people);
		System.out.println("===========================");

		Element root = new Element("people");
		for (Person p : people) {
			root.appendChild(p.getXML());
		}

		Document doc = new Document(root);
		format(System.out, doc);
		format(new BufferedOutputStream(new FileOutputStream("F:/tmp/people.xml")), doc);

	}

}
