package Rkc.List;

import java.util.function.Predicate;

/**
 * Interface IList que define uma lista genérica de elementos do tipo T.
 *
 * @param <T> o tipo de elementos contidos na lista.
 */
public interface IList<T> {

    /**
     * Remove todos os elementos da lista.
     */
    public void clear();

    /**
     * Adiciona um elemento à lista.
     *
     * @param t o elemento a ser adicionado à lista.
     */
    public void add(T t);

    /**
     * Adiciona um elemento à lista em uma posição específica.
     *
     * @param t o elemento a ser adicionado à lista.
     * @param pos a posição na lista onde o elemento será adicionado.
     * @throws IndexOutOfBoundsException se a posição for inválida.
     */
    public void add(T t, int pos);

    /**
     * Remove o elemento da lista na posição especificada.
     *
     * @param pos a posição do elemento a ser removido.
     * @return o número de elementos restantes na lista após a remoção.
     * @throws IndexOutOfBoundsException se a posição for inválida.
     */
    public boolean remove(int pos);

    /**
     * Verifica se a lista está vazia.
     *
     * @return true se a lista estiver vazia, false caso contrário.
     */
    public boolean isEmpty();

    /**
     * Define o elemento na posição especificada.
     *
     * @param t o novo elemento a ser definido.
     * @param pos a posição onde o elemento será definido.
     * @throws IndexOutOfBoundsException se a posição for inválida.
     */
    public void setData(T t, int pos);

    /**
     * Retorna o elemento na posição especificada.
     *
     * @param pos a posição do elemento a ser retornado.
     * @return o elemento na posição especificada.
     * @throws IndexOutOfBoundsException se a posição for inválida.
     */
    public T getData(int pos);

    /**
     * Retorna o número de elementos na lista.
     *
     * @return o tamanho da lista.
     */
    public int getSize();

    /**
     * Encontra o índice da primeira ocorrência de um elemento na lista.
     *
     * @param t o elemento a ser encontrado.
     * @return o índice da primeira ocorrência do elemento, ou -1 se não for encontrado.
     */
    public int findIndex(T t);

    /**
     * Encontra o índice do primeiro elemento que satisfaz o predicado fornecido.
     *
     * @param func o predicado que será aplicado aos elementos da lista.
     * @return o índice do primeiro elemento que satisfaz o predicado, ou -1 se nenhum elemento satisfizer.
     */
    public int findIndex(Predicate<T> func);
}
