/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.collections.collection;

import java.io.Serializable;
import java.util.Collection;

/**
 * Decorates another <code>Collection</code> to provide additional behaviour
 * without guaranteeing that the provided <code>Collection</code> type is the
 * same as that of the decorated <code>Collection</code>.
 * <p>
 * Each untyped method call made on this <code>Collection</code> is forwarded to the
 * decorated <code>Collection</code>. This class is used as a framework on which
 * to build to extensions such as synchronized and unmodifiable behaviour. The
 * main advantage of decoration is that one decorator can wrap any
 * implementation of <code>Collection</code>, whereas sub-classing requires a
 * new class to be written for each implementation.
 * <p>
 * This implementation does not perform any special processing with
 * {@link #iterator()}. Instead it simply returns the value from the wrapped
 * collection. This may be undesirable, for example if you are trying to write
 * an unmodifiable implementation it might provide a loophole.
 *
 * @param <D> the type of the elements in the decorated collection
 * @param <E> the element type of the Collection implementation
 * @since Commons Collections 5
 * @version $Revision$ $Date$
 *
 * @author Stephen Colebourne
 * @author Paul Jack
 * @author Matt Benson
 */
public abstract class AbstractUntypedCollectionDecorator<E, D> implements Collection<E>, Serializable {

    /** Serialization version */
    private static final long serialVersionUID = -8016691444524268856L;

    /** The collection being decorated */
    protected Collection<D> collection;

    /**
     * Create a new AbstractUntypedCollectionDecorator.
     */
    public AbstractUntypedCollectionDecorator() {
        super();
    }

    /**
     * Gets the collection being decorated. All access to the decorated
     * collection goes via this method.
     * 
     * @return the decorated collection
     */
    protected Collection<D> decorated() {
        return collection;
    }

    public void clear() {
        decorated().clear();
    }

    public boolean contains(Object object) {
        return decorated().contains(object);
    }

    public boolean isEmpty() {
        return decorated().isEmpty();
    }

    public boolean remove(Object object) {
        return decorated().remove(object);
    }

    public int size() {
        return decorated().size();
    }

    public Object[] toArray() {
        return decorated().toArray();
    }

    public <T> T[] toArray(T[] object) {
        return decorated().toArray(object);
    }

    public boolean containsAll(Collection<?> coll) {
        return decorated().containsAll(coll);
    }

    public boolean removeAll(Collection<?> coll) {
        return decorated().removeAll(coll);
    }

    public boolean retainAll(Collection<?> coll) {
        return decorated().retainAll(coll);
    }

    public boolean equals(Object object) {
        return object == this || decorated().equals(object);
    }

    public int hashCode() {
        return decorated().hashCode();
    }

    public String toString() {
        return decorated().toString();
    }

}