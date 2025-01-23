import static org.junit.jupiter.api.Assertions.*;

class CISQueueTest {
  private CISQueue cisQueue;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    cisQueue = new CISQueue(20);
  }

  @org.junit.jupiter.api.AfterEach
  void tearDown() {
    cisQueue = null;
  }

  @org.junit.jupiter.api.Test
  void enqueue() {
    assertEquals(null, cisQueue.dequeue());
    assertEquals(0, cisQueue.size());
    cisQueue.enqueue(4);
    assertEquals(1, cisQueue.size());
    cisQueue.enqueue(7);
    assertEquals(2, cisQueue.size());
    cisQueue.enqueue(10);
    assertEquals(3, cisQueue.size());
    cisQueue.enqueue(2);
    assertEquals(4, cisQueue.size());
    assertEquals(4, cisQueue.dequeue());
    assertEquals(7, cisQueue.dequeue());
    assertEquals(10, cisQueue.dequeue());
    assertEquals(2, cisQueue.dequeue());
  }

  @org.junit.jupiter.api.Test
  void dequeue() {
    assertEquals(null, cisQueue.dequeue());
    assertEquals(0, cisQueue.size());
    cisQueue.enqueue(4);
    assertEquals(1, cisQueue.size());
    cisQueue.enqueue(7);
    assertEquals(2, cisQueue.size());
    cisQueue.enqueue(10);
    assertEquals(3, cisQueue.size());
    cisQueue.enqueue(2);
    assertEquals(4, cisQueue.size());
    assertEquals(4, cisQueue.dequeue());
    assertEquals(3, cisQueue.size());
    assertEquals(7, cisQueue.dequeue());
    assertEquals(2, cisQueue.size());
    assertEquals(10, cisQueue.dequeue());
    assertEquals(1, cisQueue.size());
    assertEquals(2, cisQueue.dequeue());
    assertEquals(0, cisQueue.size());
  }

  @org.junit.jupiter.api.Test
  void isEmpty() {
    assertEquals(null, cisQueue.dequeue());
    assertTrue(cisQueue.isEmpty());
    cisQueue.enqueue(4);
    assertFalse(cisQueue.isEmpty());
    assertEquals(1, cisQueue.size());
    cisQueue.enqueue(7);
    assertEquals(2, cisQueue.size());
    cisQueue.enqueue(10);
    assertEquals(3, cisQueue.size());
    cisQueue.enqueue(2);
    cisQueue.dequeue();
    assertFalse(cisQueue.isEmpty());
    cisQueue.dequeue();
    assertFalse(cisQueue.isEmpty());
    cisQueue.dequeue();
    assertFalse(cisQueue.isEmpty());
    cisQueue.dequeue();
    assertTrue(cisQueue.isEmpty());
  }

  @org.junit.jupiter.api.Test
  void testToString() {
    assertEquals("CISQueue{queue=[null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], size=0, pointer=-1}", cisQueue.toString());
    cisQueue.enqueue(7);
    assertEquals("CISQueue{queue=[7, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], size=1, pointer=0}", cisQueue.toString());
    cisQueue.enqueue(11);
    assertEquals("CISQueue{queue=[7, 11, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], size=2, pointer=1}", cisQueue.toString());
    cisQueue.enqueue(23);
    assertEquals("CISQueue{queue=[7, 11, 23, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], size=3, pointer=2}", cisQueue.toString());
  }
}