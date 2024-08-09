package Rkc.Stack;

/**
 * A generic interface representing a stack data structure.
 *
 * @param <T> the type of elements held in this stack
 */
public interface IStack<T> {

    /**
     * Returns the number of elements currently in the stack.
     *
     * @return the number of elements in the stack
     */
    public int currentSize();

    /**
     * Adds a new item to the top of the stack.
     *
     * @param item the item to be added to the stack
     */
    public void push(T item);

    /**
     * Removes and returns the item at the top of the stack.
     *
     * @return the item that was removed from the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public T pop();

    /**
     * Removes all items from the stack.
     */
    public void clear();

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Returns the item at the top of the stack without removing it.
     *
     * @return the item at the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public T peek();

    /**
     * Adds a range of items to the top of the stack.
     *
     * @param items an array of items to be added to the stack
     * @return the last item added from the range
     */
    public void pushRange(T[] items);
}
