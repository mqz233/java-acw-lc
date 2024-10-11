package _24oct;

class MyCircularQueue {

    int[] arr;
    int size;
    int l;
    int r;
    public MyCircularQueue(int k) {
        arr = new int[k];
        size = 0;
        l = 0;
        r = 0;
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        arr[r++] = value;
        size++;
        if(r == arr.length){
            r = 0;
        }
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        l++;
        size--;
        if(l == arr.length){
            l = 0;
        }
        return true;
    }

    public int Front() {
        return isEmpty()?-1:arr[l];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        int last = r == 0?arr.length-1:r-1;
        return arr[last];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
