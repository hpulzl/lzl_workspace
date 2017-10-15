##ArrayList
list集合是使用数组的方式来存储的。

list集合中主要关注的源码实现包括

* 容器中的add、get、remove方法如何实现，源码底层是用什么作为容器的。
* 容器是如何扩容的
* 容器的添加的有序性等

1. ArrayList的构造方法

```

```

2. ArrayList的add方法


3. ArrayList的remove方法

4. get方法

5. arrayList为什么用transient修饰elementData

* 重写writeObject方法，只序列化有用的数据
* 序列化elementData中存在的数据，而不是将整个数组进行序列化

##Vector
vector的实现与arrayList实现类似，在一些add和remove方法中加入了synchronized来实现线程安全
## LinkedList
是基于双向链表进行实现的
双向链表的插入过程是怎样的？

###插入方法
1. 从后面插入过程

```
void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }
```

2. 从前面插入过程

```
private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
        modCount++;
    }
```

3. 从指定位置插入过程

```
 void linkBefore(E e, Node<E> succ) {
        // assert succ != null;
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
        modCount++;
    }
    
```
###remove删除方法

1. 删除指定位置元素

假设item为指定节点，prev为前置节点,next为后置节点，
分为两种情况。

* 只有一个元素的时候，item的prev和next都为空。分别将其执行first和last节点
* 有多个元素的时候，将item的prev执行item的next，将item设置为null

```
//查找元素的方法
//根据index，找出Node对象
Node<E> node(int index) {
		//如果index < size/2 从前往后找
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
        //从后往前找
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
    
E unlink(Node<E> x) {
        // assert x != null;
        //找出该元素的前置对象和后置对象
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;
		
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }
```

