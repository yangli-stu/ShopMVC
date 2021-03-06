package com.demo.factory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

//自定义工厂类
public class MyObjectFactory extends DefaultObjectFactory {
	private static final long serialVersionUID = -4114845625429965832L;
	@Override
	public <T> T create(Class<T> type) {
		return super.create(type);
	}
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, 
                                           List<Object> constructorArgs) {
		return super.create(type, constructorArgTypes, constructorArgs);
	}
	public void setProperties(Properties properties) {
		super.setProperties(properties);
	}
	public <T> boolean isCollection(Class<T> type) {
		return Collection.class.isAssignableFrom(type);
	}
}

