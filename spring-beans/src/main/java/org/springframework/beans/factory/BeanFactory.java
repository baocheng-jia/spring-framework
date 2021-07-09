

package org.springframework.beans.factory;

import org.springframework.beans.BeansException;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;

/**
 *
 */
public interface BeanFactory {

	/**
	 * beadName的默认前缀
	 */
	String FACTORY_BEAN_PREFIX = "&";


	/**
	 * 通过name获取bean
	 */
	Object getBean(String name) throws BeansException;

	/**
	 * 通过 name + type 从IOC容器中获取bean
	 */
	<T> T getBean(String name, Class<T> requiredType) throws BeansException;

	/**
	 *
	 */
	Object getBean(String name, Object... args) throws BeansException;

	/**
	 *
	 */
	<T> T getBean(Class<T> requiredType) throws BeansException;

	/**
	 *
	 */
	<T> T getBean(Class<T> requiredType, Object... args) throws BeansException;

	/**
	 *
	 */
	<T> ObjectProvider<T> getBeanProvider(Class<T> requiredType);

	/**
	 *
	 */
	<T> ObjectProvider<T> getBeanProvider(ResolvableType requiredType);

	/**
	 * 判断Ioc容器中是否有名字为 name 的bean
	 */
	boolean containsBean(String name);

	/**
	 * 判断一个bean是不是单例 bean
	 */
	boolean isSingleton(String name) throws NoSuchBeanDefinitionException;

	/**
	 *
	 */
	boolean isPrototype(String name) throws NoSuchBeanDefinitionException;

	/**
	 *
	 */
	boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException;

	/**
	 *
	 */
	boolean isTypeMatch(String name, Class<?> typeToMatch) throws NoSuchBeanDefinitionException;

	/**
	 *
	 */
	@Nullable
	Class<?> getType(String name) throws NoSuchBeanDefinitionException;

	/**
	 *
	 */
	@Nullable
	Class<?> getType(String name, boolean allowFactoryBeanInit) throws NoSuchBeanDefinitionException;

	/**
	 * 获取bean的别名
	 */
	String[] getAliases(String name);

}
