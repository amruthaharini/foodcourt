/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.foodcourt.beverages;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import java.util.List;

@Repository
public class BeveragesBean {

    @PersistenceContext
    private EntityManager entityManager;

    public Beverage find(Long id) {
        return entityManager.find(Beverage.class, id);
    }

    @Transactional
    public void addBeverage(Beverage beverage) {
        entityManager.persist(beverage);
    }

    @Transactional
    public void editBeverage(Beverage beverage) {
        entityManager.merge(beverage);
    }

    @Transactional
    public void deleteBeverage(Beverage beverage) {
        entityManager.remove(beverage);
    }

    @Transactional
    public void deleteBeverageId(long id) {
        Beverage beverage = entityManager.find(Beverage.class, id);
        deleteBeverage(beverage);
    }

    public List<Beverage> getBeverages() {
        CriteriaQuery<Beverage> cq = entityManager.getCriteriaBuilder().createQuery(Beverage.class);
        cq.select(cq.from(Beverage.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public List<Beverage> findAll(int firstResult, int maxResults) {
        CriteriaQuery<Beverage> cq = entityManager.getCriteriaBuilder().createQuery(Beverage.class);
        cq.select(cq.from(Beverage.class));
        TypedQuery<Beverage> q = entityManager.createQuery(cq);
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
        return q.getResultList();
    }

    public int countAll() {
        CriteriaQuery<Long> cq = entityManager.getCriteriaBuilder().createQuery(Long.class);
        Root<Beverage> rt = cq.from(Beverage.class);
        cq.select(entityManager.getCriteriaBuilder().count(rt));
        TypedQuery<Long> q = entityManager.createQuery(cq);
        return (q.getSingleResult()).intValue();
    }

    public int count(String field, String searchTerm) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        Root<Beverage> root = cq.from(Beverage.class);
        EntityType<Beverage> type = entityManager.getMetamodel().entity(Beverage.class);

        Path<String> path = root.get(type.getDeclaredSingularAttribute(field, String.class));
        Predicate condition = qb.like(path, "%" + searchTerm + "%");

        cq.select(qb.count(root));
        cq.where(condition);

        return entityManager.createQuery(cq).getSingleResult().intValue();
    }

    public List<Beverage> findRange(String field, String searchTerm, int firstResult, int maxResults) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Beverage> cq = qb.createQuery(Beverage.class);
        Root<Beverage> root = cq.from(Beverage.class);
        EntityType<Beverage> type = entityManager.getMetamodel().entity(Beverage.class);

        Path<String> path = root.get(type.getDeclaredSingularAttribute(field, String.class));
        Predicate condition = qb.like(path, "%" + searchTerm + "%");

        cq.where(condition);
        TypedQuery<Beverage> q = entityManager.createQuery(cq);
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
        return q.getResultList();
    }

    @Transactional
    public void clean() {
        entityManager.createQuery("delete from Beverage").executeUpdate();
    }
}