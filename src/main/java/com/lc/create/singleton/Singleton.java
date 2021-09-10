package com.lc.create.singleton;

/**
 * @Classname Singleton
 * @Date 2021/9/10 下午12:32
 * @Created by liuchao58
 * @Description 单例模式(Singleton Pattern)：单例模式确保某一个类只有一个实例，并提供一个访问它的全剧访问点。
 * 单例模式下，对应类只能生成一个实例。就像一个王国只能有一个国王，一旦王国里的事务多起来，这唯一的国王也容易职责过重。
 *
 * 类型：
 *     懒汉式 、饿汉式 、双检锁double-checked locking 、静态内部类、枚举型
 *
 * <p>
 * 优点：
 * 提供了对唯一实例的受控访问。因为单例类封装了它的唯一实例，所以它可以严格控制客户怎样以及何时访问它。
 * 因为该类在系统内存中只存在一个对象，所以可以节约系统资源。
 * <p>
 * 缺点：
 * 由于单例模式中没有抽象层，因此单例类很难进行扩展。
 * 对于有垃圾回收系统的语言 Java，C# 来说，如果对象长时间不被利用，则可能会被回收。那么如果这个单例持有一些数据的话，在回收后重新实例化时就不复存在了
 */
public class Singleton {

    //1. 私有静态化单例实例成员变量 用于创建对象
    // volatile 关键字作用：1.防止指令重排 2.内存可见  原因：对象的创建过程 类初始化和类实例化是两个过程,需要volatile关键字控制
    private volatile static Singleton singletonInstance = null;

    //2.私有化构造方法 防止外部创建对象
    private Singleton() {
    }

    //3. 公有静态化获取方法 用于返回 单例实例
    public static Singleton getSingletonInstance() {
        if (singletonInstance == null) {
            synchronized (Singleton.class) {
                if (singletonInstance == null) {
                    singletonInstance = new Singleton();
                }
            }
        }
        return singletonInstance;
    }


    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingletonInstance();
    }
}
