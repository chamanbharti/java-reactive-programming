package functional.ds.linear.static_.array;

import java.util.Arrays;

public class CustomArrayList<T> {
    private static final int INITIAL_CAPACITY = 10;
    private int size = 0;
    private Object elementData[] = {};
    public CustomArrayList(){
        elementData = new Object[INITIAL_CAPACITY];
    }
    public void add(Object e){
        if(size==elementData.length){
            ensureCapacity();
        }
        elementData[size++] = e;
    }
    public Object remove(int index){
       if(index <0 || index >= size){
           throw new IndexOutOfBoundsException("Index:"+index+",Size "+size);
       }
       Object removedElement = elementData[index];
       for (int i=index;i<size-1;i++){
           elementData[i] = elementData[i+1];
       }
       size--;
       return removedElement;
    }
    public Object get(int index){
        if(index <0 || index >= size){
            throw new IndexOutOfBoundsException("Index:"+index+",Size "+size);
        }
        return elementData[index];
    }
    private void ensureCapacity(){
        int newIncreasedCapacity = elementData.length * 2;
        elementData = Arrays.copyOf(elementData,newIncreasedCapacity);
    }

    public void display(){
        for (int i=0;i< size;i++){
            System.out.print(elementData[i]+" ");
        }
    }
    public void clear(){
        elementData = new Object[0];
        size=0;
    }

    public static void main(String[] args) {
        CustomArrayList<String> arrayList = new CustomArrayList<>();
        arrayList.add("Chaman");
        arrayList.add("Bharti");
        arrayList.add("Aman");
        arrayList.add("Bharti");
        arrayList.add("Naman");
        arrayList.add("Bharti");
        arrayList.add("Sahil");
        arrayList.add("Bharti");
        arrayList.display();
        System.out.println(arrayList.size);
        System.out.println(arrayList.elementData.length);
        arrayList.clear();
        CustomArrayList<Integer>list = new CustomArrayList<>();

        list.add(1);
        list.add(2);
        list.display();
        System.out.println(list.size);
        System.out.println(list.elementData.length);


    }

}
