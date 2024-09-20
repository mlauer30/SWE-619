/**
 * Matthew Lauer - 100%
 * Dan Le - 100%
 * Sophia Nadasy - 100%
 * Sri Teja Kale - 100%
 * Sri Bhuvan Madipuddi - 100%
 */
import java.util.*;

public final class Queue<E> {

  private final List<E> elements;

  public Queue() {
    this.elements = Collections.unmodifiableList(new ArrayList<>());
  }

  private Queue(List<E> elements) {
    ArrayList<E> newList = new ArrayList<>(elements);
    this.elements = Collections.unmodifiableList(newList);
  }

  public Queue<E> enQueue(E e) { //Observer
    List<E> newList = new ArrayList<>(this.elements);
    newList.add(e);
    return new Queue<>(newList);
  }

  public Queue<E> deQueue() {
    if (isEmpty()) {
      throw new IllegalStateException("Queue.deQueue");
    }
    List<E> newList = new ArrayList<>(this.elements);
    newList.remove(0);
    return new Queue<>(newList);
  }

  public E peek() {
    if (isEmpty()) {
      throw new IllegalStateException("Queue.peek");
    }
    E result = elements.get(0); //observer
    return result; //observer
  }

  public boolean isEmpty() {
    return this.elements.isEmpty();
  }

  public static void main(String[] args) {
    // Simple exercise to enQueue/deQueue cmd line args
    // Usage:  java Queue item1 item2 item3 ...
    Queue<String> q = new Queue<>();
    for (String arg : args) q = q.enQueue(arg);
    while (!q.isEmpty()) {
      System.out.println(q.peek());
      q = q.deQueue();
    }
  }
}
