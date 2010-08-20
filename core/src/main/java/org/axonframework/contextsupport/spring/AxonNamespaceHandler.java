/*
 * Copyright (c) 2010. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.axonframework.contextsupport.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * The Axon namespace handler is responsible for parsing the elements of the
 * Axon namespace and adjusting the Spring context configuration accordingly.
 * However, in reality the namespace handler really just delegates to specific
 * parser classes for each element. Please refer to <a href=
 * "http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/extensible-xml.html"
 * >Appendix D</a> of the Spring Framework Reference Documentation for more
 * information.
 * 
 * @author Ben Z. Tels
 * 
 */
public class AxonNamespaceHandler extends NamespaceHandlerSupport {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init() {
		registerBeanDefinitionParser("annotation-configuration", new AnnotationConfigurationBeanDefinitionParser());
		registerBeanDefinitionParser("commandBus", new SimpleCommandBusBeanDefinitionParser());
		registerBeanDefinitionParser("eventBus", new EventBusBeanDefinitionParser());
		registerBeanDefinitionParser("eventStore", new EventStoreBeanDefinitionParser());
		registerBeanDefinitionParser("repository", new RepositoryBeanDefinitionParser());
	}

}
