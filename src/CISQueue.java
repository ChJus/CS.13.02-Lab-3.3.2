import java.util.Arrays;

public class CISQueue {
  // Array property.
  Object[] array;

  // Size property.
  int size = 0;

  // Index pointer. Indicates the index of the most recently added element.
  int tail = -1;

  // Constructor.
  public CISQueue(int size) {
    array = new Object[size];
  }

  // Enqueue. This method adds a node to the end of the array.
  public void enqueue(Object value) {
    tail++;
    if (tail == array.length) {
      Object[] temp = array;
      array = Arrays.copyOf(temp, temp.length + 1);
    }
    size++;
    array[tail] = value;
  }

  // Dequeue. This method removes a node from the beginning of the linked list.
  public Object dequeue() {
    if (isEmpty()) return null;
    Object result = array[0];
    reshuffle();
    size--;
    tail--;
    return result;
  }

  // isEmpty. Returns a boolean indicating whether the linked list is empty.
  public boolean isEmpty() {
    return size == 0;
  }

  // size. Returns the size of the queue.
  public int size() {
    return size;
  }

  // reshuffle. Moves each element down one index. Called whenever we dequeue.
  private void reshuffle() {
    for (int i = 1; i < size; i++) {
      array[i - 1] = array[i];
    }
    array[size - 1] = null;
  }

  // toString. Returns a description of the queue in, for example, the following format:
  // CISQueue{queue=[7, 11], size=2, pointer=1}
  @Override
  public String toString() {
    String result = "CISQueue{queue=[";

    for (int i = 0; i < array.length; i++) {
      result += array[i] + (i == array.length - 1 ? "" : ", ");
    }

    result += "], size=" + size + ", pointer=" + tail + "}";
    return result;
  }
}
