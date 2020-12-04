import java.util.Arrays;

/**
 * 手写数组，支持插入到开头或者结尾，或者任意位置
 * 源文件：https://blog.csdn.net/c_ym_ww/article/details/88836979
 */
public class Array {
    private int[] data;
    private int size;

    /**
     * 构造函数
     * @param capacity 数组的长度
     */
    public Array(int capacity){
        data = new int[capacity];
        size =0;
    }

    /**
     * 无参的构造函数
     */
    public Array(){
        this(10);
    }

    /**
     * 在数组中插入一个新的元素
     * @param index 新增的索引
     * @param e 新增的值
     */
    public void insert(int index,int e){
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed.Array is full.");
        }
        if (index < 0 || index >size) {
            throw new IllegalArgumentException("Add failed.Require index >=0 is full.");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 向数组最后添加一个元素
     * @param e 添加的值
     */
    public void addLast(int e){
        insert(size,e);
    }

    /**
     * 数组开头添加值
     * @param e 添加的值
     */
    public void addFirst(int e){
        insert(0,e);
    }

    /**
     * 根据索引获取数组的值
     * @param index
     * @return
     */
    public int getValue(int index){
        if(index < 0 || index >size){
            throw new ArrayIndexOutOfBoundsException("查询的索引越界");
        }
        return data[index];
    }

    /**
     * 查找数组中是否包含元素e
     * @param e 包含的元素
     * @return true 包含 false 不包含
     */
    public boolean contains(int e){
        for(int val:data){
            if(val == e){
               return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在则返回索引为-1
     * @param e
     * @return
     */
    public int find(int e){
        for(int i =0;i< size;i++){
            if(data[i] == e){
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     * @param index 要删除的元素索引
     * @return 删除的元素值
     */
    public int remove(int index){
        if(index<0 || index>size){
            throw new ArrayIndexOutOfBoundsException("删除的索引越界");
        }
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        return data[index];
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size=%d , capacity=%d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        Array arr = new Array(10);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.remove(2);
        //[-1,0,1,2,3,4,5,6,7,8,9]
        System.out.println(arr);

    }
}

