package com.pivotal.demo.loader;

import org.springframework.beans.factory.annotation.Autowired;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.LoaderHelper;

import com.pivotal.demo.model.Person;

public class PersonCacheLoader implements CacheLoader<String, Person> {

	@Override
	public void close() {
		// NOOP
	}

	@Override
	public Person load(LoaderHelper<String, Person> helper) throws CacheLoaderException {
		Person dummyPerson = new Person();
		dummyPerson.setId(helper.getKey());
		dummyPerson.setName("WhatsInAName");
		dummyPerson.setEmail("BilboSwaggins@hobbits.com");
		return dummyPerson;
	}
}
