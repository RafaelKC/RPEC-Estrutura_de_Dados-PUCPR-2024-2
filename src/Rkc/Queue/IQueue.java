package Rkc.Queue;

/**
 * A interface {@code IQueue<T>} define um contrato para uma estrutura de dados do tipo fila (queue) genérica.
 * A fila segue o princípio FIFO (First-In, First-Out), onde o primeiro elemento adicionado é o primeiro a ser removido.
 *
 * @param <T> O tipo dos elementos armazenados na fila.
 */
public interface IQueue<T> {

    /**
     * Adiciona um item à fila.
     *
     * @param item O item a ser adicionado à fila. Deve ser do tipo {@code T}.
     * @throws NullPointerException Se o item for {@code null} e a fila não suporta elementos nulos.
     */
    public void add(T item);

    /**
     * Adiciona uma matriz de itens à fila.
     *
     * @param items Um array contendo os itens a serem adicionados à fila. Cada item deve ser do tipo {@code T}.
     * @throws NullPointerException Se o array for {@code null} ou se algum item dentro do array for {@code null} e a fila não suporta elementos nulos.
     */
    public void addRange(T[] items);

    /**
     * Remove e retorna o item da frente da fila.
     *
     * @return O item que estava na frente da fila.
     * @throws NoSuchElementException Se a fila estiver vazia.
     */
    public T remove();

    /**
     * Remove todos os itens da fila, deixando-a vazia.
     */
    public void clear();

    /**
     * Verifica se a fila está vazia.
     *
     * @return {@code true} se a fila não contiver itens, {@code false} caso contrário.
     */
    public boolean isEmpty();

    /**
     * Retorna o número de itens presentes na fila.
     *
     * @return O número de itens atualmente na fila.
     */
    public int currentSize();
}
