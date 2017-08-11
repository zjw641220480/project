package cn.itcast.tom.service;

import cn.itcast.tom.pojo.Person;

public interface PersonService {
	public Person getPerson();

	public Person getPerson(String personname, String password);
}
