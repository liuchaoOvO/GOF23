package com.lc.create.prototype;

/**
 * @Classname Prototype
 * @Date 2021/9/10 下午2:16
 * @Created by liuchao58
 * @Description 原型模式（Prototype Pattern）: 使用原型实例指定待创建对象的类型，并且通过复制这个原型来创建新的对象。
 * 原型模式主要用于对象的复制,Prototype类需要具备以下两个条件：
 * 1.实现Cloneable接口。在java语言有一个Cloneable接口，它的作用只有一个，就是在运行时通知虚拟机可以安全地在实现了此接口的类上使用clone方法。在java虚拟机中，只有实现了这个接口的类才可以被拷贝，否则在运行时会抛出CloneNotSupportedException异常。
 * 2.重写Object类中的clone方法。Java中，所有类的父类都是Object类，Object类中有一个clone方法，作用是返回对象的一个拷贝，但是其作用域protected类型的，一般的类无法调用，因此，Prototype类需要将clone方法的作用域修改为public类型。
 * <p>
 * 优点：
 * 使用原型模式创建对象比直接new一个对象在性能上要好的多，因为Object类的clone方法是一个本地方法，它直接操作内存中的二进制流，特别是复制大对象时，性能的差别非常明显。
 * <p>
 * 缺点：
 * 深拷贝与浅拷贝问题
 * Object类的clone方法只会拷贝对象中的基本的数据类型，对于数组、容器对象、引用对象等都不会拷贝，这就是浅拷贝。如果要实现深拷贝，必须将原型模式中的数组、容器对象、引用对象等另行拷贝。
 */
public class Prototype implements Cloneable {
    public Prototype clone() {
        Prototype prototype = null;
        try {
            prototype = (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototype;
    }
}


class ConcretePrototype extends Prototype {
    public void show() {
        System.out.println("原型模式实现类");
    }
}

class Main {
    public static void main(String[] args) {
        ConcretePrototype cp = new ConcretePrototype();
        for (int i = 0; i < 10; i++) {
            ConcretePrototype clonecp = (ConcretePrototype) cp.clone();
            clonecp.show();
        }
    }
}