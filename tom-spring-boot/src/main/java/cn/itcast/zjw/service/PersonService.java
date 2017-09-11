package cn.itcast.zjw.service;

import cn.itcast.zjw.pojo.Person;

public interface PersonService {
	public Person getPerson();

	public Person getPerson(String personname, String password);
}
