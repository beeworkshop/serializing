package demo;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Elements;

public class People extends ArrayList<Person> {

	public People(String fileName) throws Exception {
		Document doc = new Builder().build(new FileInputStream(new File(fileName)));
		Elements elements = doc.getRootElement().getChildElements();
		for (int i = 0; i < elements.size(); i++) {
			add(new Person(elements.get(i)));
		}
	}

	public static void main(String[] args) throws Exception {
		People p = new People("F:/tmp/people.xml");
		System.out.println(p);
	}

}
