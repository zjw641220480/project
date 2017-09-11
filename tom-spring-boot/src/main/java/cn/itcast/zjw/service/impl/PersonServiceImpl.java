package cn.itcast.zjw.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.zjw.pojo.Person;
import cn.itcast.zjw.service.PersonService;

@Service(value="personServiceImple")
public class PersonServiceImpl implements PersonService{
	@Resource(name="person")
	private Person person ;
	public Person getPerson() {
		return person;
	}

	public Person getPerson(String personname, String password) {
		return person;
	}

}
