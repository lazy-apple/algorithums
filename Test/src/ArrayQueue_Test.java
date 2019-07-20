/**
 * @author LaZY(李志一)
 * @create 2019-07-20 9:51
 */
public class ArrayQueue_Test {
    private int[] array;
    private int frist;
    private int size;
    private int end;

    public ArrayQueue_Test(int l){
        array = new int[l];
        frist = 0;
        end = 0;
        size = 0;
    }

    public void push(int num) throws Exception {
        if(size == array.length){
            throw new Exception("wrong");
        }
        size++;
        end = end == array.length - 1 ? 0 : ++end;
    }

    public int poll() throws Exception {
        if(size == 0){
            throw new Exception("wrong");
        }
        size --;
        int tem = frist;
        frist = array[frist] == array.length - 1 ? 0 : --frist;
        return array[frist];
    }
}
