package LinkedList;

import com.sun.org.apache.xpath.internal.patterns.NodeTest;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Iterable<E>{

    private Node<E> last;
    private Node<E> first;
    private int size = 0;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public void setNext(Node<E> next){
            this.next = next;
        }

        public void setPrev(Node<E> prev){
            this.prev = prev;
        }

        public void setItem(E item){
            this.item = item;
        }
        Node<E> getNext(){
            return next;
        }
        E getItem(){
            return item;
        }
        Node<E> getPrev() {
            return prev;
        }
    }

    public void add(E e) {
        Node<E> tail = last;
        last.setItem(e);
        if (first == null) {
            first.setItem(e);
        }
        else {
            last.setNext(null);
            last.setPrev(tail);
        }
        size++;
    }

    public void add(int index, E element) {
        if (index>size || index<0) {
            throw new IndexOutOfBoundsException();
        }
        if (index ==0) {
            add(element);
        }
        Node<E> head = first;
        if(index<size&&index!=0){
            for(int i = 0; i<index; ){
                head = head.getNext();
            }
            head.setItem(element);
        }
    }

    public E get(int index){
        Node<E> head = first;
        for(int i = 0; i<index; ){
            head = head.getNext();
        }
        return head.getItem();
    }

    public E remove(int index){
        Node<E> head = first;
        for(int i = 0; i<index; ){
            head = head.getNext();
        }
        Node<E> next = head.getNext();
        Node<E> prev = head.getPrev();
        next.setPrev(prev);
        prev.setNext(next);
        return head.getItem();
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            public void remove() {
            }

            Node<E> node = first;

            public boolean hasNext() {
                return node != null;
            }

            public E next() {
                Node<E> nodenext = node.getNext();
                return node.getNext().getItem();
            }
        };
    }

    public boolean addAll(Collection<? extends E> collection){
        Iterator<? extends E> colletionIterator = collection.iterator();
        while (colletionIterator.hasNext()){
            add(colletionIterator.next());
        }
        return true;
    }
}
