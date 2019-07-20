/**
 * @author LaZY(李志一)
 * @create 2019-07-20 9:25
 */
public class Array_To_Stack_Queue_Test {

    private int[] array;
    private int size = 0;

    public Array_To_Stack_Queue_Test(int l) throws Exception {
        if(l < 0){
            throw new Exception("wrong");
        }
        array = new int[l];
    }

    public void push(int num) throws Exception {
        if(size == array.length){
            throw new Exception("wrong");
        }
        array[size++] = num;
    }
    public int pop() throws Exception {
        if(size == 0){
            throw new Exception("wrong");
        }
        return array[--size];
    }

    public int peek() throws Exception {
        if(size == 0){
            throw new Exception("wrong");
        }
        return array[size];
    }
}
