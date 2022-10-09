package ArrayList;

public class MyArrayList<E> {

    private final int SIZE_ARRAY = 16;
    private Object[] array = new Object[SIZE_ARRAY];
    private int pointer = 0;

    /*
    Добавление элемента в конец списка
     */
    public void add(E item) {
        if (pointer == array.length - 1) {
            resize(array.length * 2); //Увеличение списка в два раз если дошли до предела!
            array[pointer++] = item;
        }
    }

    /*
    Возврат элемента по индексу
     */
    public E get(int index) {
        return (E) array[index];
    }

    /*
    Удаление элемента из списка
    Если размер списка достиг значения
    CUT_RATE = 4, сокращаем лист в два раза
     */

    public void remove(int index) {
        for (int i = 0; i < pointer; i++) {
            array[i] = array[i + 1];
            array[pointer] = null;
            pointer--;
            int CUT_RATE = 4;
            if (array.length > SIZE_ARRAY && pointer < array.length / CUT_RATE) resize(array.length / 2);
        }
    }
    //Возвращаем размер листа

    public int size() {
        return pointer;
    }
    //Сокращение листа
    private void resize(int i) {
        Object [] newArray = new Object[i];
        System.arraycopy(array,0,newArray,0,pointer);
        array = newArray;
    }
    
}
