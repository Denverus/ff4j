package org.ff4j.conf;

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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.ff4j.security.domain.FF4jAcl;
import org.ff4j.security.domain.FF4jUser;

/**
 * Load settings for ff4j v2 with ACL and users management.
 *
 * @author Cedrick LUNVEN (@clunven)
 */
public class XmlConfigV2 extends XmlConfigV1 {

    /** Load Tag <ROLES>. */
    private Map < String, Set<String> > roles = new HashMap<>();
    
    /** Dedicated Parsing. */
    private Map <String, FF4jUser > users = new LinkedHashMap<String, FF4jUser>();
    
    /** InMemory Feature Map */
    private Map <String, FF4jAcl > acls = new LinkedHashMap<String, FF4jAcl>();

    /**
     * Getter accessor for attribute 'roles'.
     *
     * @return
     *       current value of 'roles'
     */
    public Map<String, Set<String>> getRoles() {
        return roles;
    }

    /**
     * Setter accessor for attribute 'roles'.
     * @param roles
     * 		new value for 'roles '
     */
    public void setRoles(Map<String, Set<String>> roles) {
        this.roles = roles;
    }

    /**
     * Getter accessor for attribute 'users'.
     *
     * @return
     *       current value of 'users'
     */
    public Map<String, FF4jUser> getUsers() {
        return users;
    }

    /**
     * Setter accessor for attribute 'users'.
     * @param users
     * 		new value for 'users '
     */
    public void setUsers(Map<String, FF4jUser> users) {
        this.users = users;
    }

    /**
     * Getter accessor for attribute 'acls'.
     *
     * @return
     *       current value of 'acls'
     */
    public Map<String, FF4jAcl> getAcls() {
        return acls;
    }

    /**
     * Setter accessor for attribute 'acls'.
     * @param acls
     * 		new value for 'acls '
     */
    public void setAcls(Map<String, FF4jAcl> acls) {
        this.acls = acls;
    }
    
}
