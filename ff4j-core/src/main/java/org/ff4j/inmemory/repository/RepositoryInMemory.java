package org.ff4j.inmemory.repository;

/*-
 * #%L
 * ff4j-core
 * %%
 * Copyright (C) 2013 - 2017 FF4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.ff4j.FF4jEntity;
import org.ff4j.conf.XmlConfigV1;
import org.ff4j.conf.XmlParserV1;
import org.ff4j.test.AssertUtils;

/**
 * Repository of entities
 *
 * @author Cedrick LUNVEN (@clunven)
 *
 * @param <E>
 *      ff4j entity
 */
public class RepositoryInMemory <E extends FF4jEntity<?> > implements Map< String, E >{
    
    /** XML Parser V1. */
    private static final XmlParserV1 PARSER_V1 = new XmlParserV1();
    
    /** XML Parser V2. */
    //private static final XmlParserV2 PARSER_V2 = new XmlParserV2();
    
    /** InMemory Feature Map */
    private Map<String, E> mapOfEntities = new ConcurrentHashMap<String, E>();
    
    /** XML Configuration. */
    private XmlConfigV1 xmlConfigV1;

    /** FileName used to retrieve properties. */
    private String fileName;
    
    /**
     * Default constructor.
     */
    public RepositoryInMemory() {
    }
    
    /**
     * Init by providing the initial map of entities.
     * 
     * @param maps
     */
    public RepositoryInMemory(Map<String, E> maps) {
        this.mapOfEntities = maps;
    }
    
    /**
     * Provide an xml file to initialize.
     *
     * @param fileName
     *          target fileName
     */
    public RepositoryInMemory(String fileName) {
        AssertUtils.assertHasLength(fileName, "fileName");
    }

    /**
     * Getter accessor for attribute 'fileName'.
     *
     * @return
     *       current value of 'fileName'
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Setter accessor for attribute 'fileName'.
     * @param fileName
     *      new value for 'fileName '
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Getter accessor for attribute 'mapOfEntities'.
     *
     * @return
     *       current value of 'mapOfEntities'
     */
    public Map<String, E> getMapOfEntities() {
        return mapOfEntities;
    }

    /**
     * Setter accessor for attribute 'mapOfEntities'.
     * @param mapOfEntities
     * 		new value for 'mapOfEntities '
     */
    public void setMapOfEntities(Map<String, E> mapOfEntities) {
        this.mapOfEntities = mapOfEntities;
    }

    /**
     * Getter accessor for attribute 'xmlConfigV1'.
     *
     * @return
     *       current value of 'xmlConfigV1'
     */
    public XmlConfigV1 getXmlConfigV1() {
        if (xmlConfigV1 == null) {
            AssertUtils.assertHasLength(fileName);
            InputStream fileStream = getClass().getClassLoader().getResourceAsStream(fileName);
            AssertUtils.assertNotNull(fileStream, "Cannot open '" + fileName + "' please check location");
            xmlConfigV1 = PARSER_V1.parseConfigurationFile(fileStream);
        }
        return xmlConfigV1;
    }

    /**
     * Setter accessor for attribute 'xmlConfigV1'.
     * @param xmlConfigV1
     * 		new value for 'xmlConfigV1 '
     */
    public void setXmlConfigV1(XmlConfigV1 xmlConfigV1) {
        this.xmlConfigV1 = xmlConfigV1;
    }

    /** {@inheritDoc} */
    @Override
    public void clear() {
        mapOfEntities.clear();
    }

    /** {@inheritDoc} */
    @Override
    public boolean containsKey(Object key) {
        return mapOfEntities.containsKey(key);
    }

    /** {@inheritDoc} */
    @Override
    public boolean containsValue(Object value) {
        return mapOfEntities.containsValue(value);
    }

    /** {@inheritDoc} */
    @Override
    public Set<Entry<String, E>> entrySet() {
        return mapOfEntities.entrySet();
    }

    /** {@inheritDoc} */
    @Override
    public E get(Object key) {
        return mapOfEntities.get(key);
    }

    /** {@inheritDoc} */
    @Override
    public boolean isEmpty() {
        return mapOfEntities.isEmpty();
    }

    /** {@inheritDoc} */
    @Override
    public Set<String> keySet() {
        return mapOfEntities.keySet();
    }

    /** {@inheritDoc} */
    @Override
    public E put(String key, E value) {
        return mapOfEntities.put(key, value);
    }

    /** {@inheritDoc} */
    @Override
    public void putAll(Map<? extends String, ? extends E> m) {
        mapOfEntities.putAll(m);
    }

    /** {@inheritDoc} */
    @Override
    public E remove(Object key) {
        return mapOfEntities.remove(key);
    }

    /** {@inheritDoc} */
    @Override
    public int size() {
        return mapOfEntities.size();
    }

    /** {@inheritDoc} */
    @Override
    public Collection<E> values() {
        return mapOfEntities.values();
    }
    
}
