package org.turing.designpattern.examples.iterator.lang;

public interface Iterator<E> {

    boolean hasNext();

    E next();

}