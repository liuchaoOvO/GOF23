package com.lc.create.abstractfactory;


/**
 * 可乐抽象类
 */
interface Cola {

}

/**
 * 瓶子抽象类
 */
interface Bottle {

}

/**
 * 箱子抽象类
 */
interface Box {

}


/**
 * 工厂抽象类
 */
interface Factory {

    Cola createCola();

    Bottle createBottle();

    Box createBox();
}

/**
 * @Classname AbstractFactory
 * @Date 2021/9/10 上午11:03
 * @Created by liuchao58
 * @Description 抽象工厂模式(Abstract Factory Pattern)：提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。
 * <p>
 * 举例：
 * 抽象工厂和工厂方法不同的地方在于，生产产品的工厂是抽象的。
 * 举例，可口可乐公司生产可乐的同时，也需要生产装可乐的瓶子和箱子，瓶子和箱子也是可口可乐专属定制的，同样百事可乐公司也会有这个需求。
 * 这个时候我们的工厂不仅仅是生产可乐饮料的工厂，还必须同时生产同一主题的瓶子和箱子，所以它是一个抽象的主题工厂，专门生产同一主题的不同商品。
 * <p>
 * 优点：
 * 当系统中加入新产品时，不需要修改抽象工厂和抽象产品提供的接口，也无须修改客户端和其他的具体工厂和具体产品，而只要添加一个具体工厂和与其对应的具体产品就可以了，符合了开闭原则。
 * <p>
 * 缺点：
 * 规定了所有可能被创建的产品集合，产品族中扩展新的产品困难，需要修改抽象工厂的接口。
 */
public class AbstractFactory {
    public static void main(String[] args) {
        Cola CocaCola = new CocaColaFactory().createCola();
        Bottle CocaColaBottle = new CocaColaFactory().createBottle();
        Box CocaColaBox = new CocaColaFactory().createBox();

        Cola PesiCola = new PesiColaFactory().createCola();
        Bottle PesiColaBottle = new PesiColaFactory().createBottle();
        Box PesiColaBox = new PesiColaFactory().createBox();
    }
}


/**
 * 可口可乐产品类
 */
class CocaCola implements Cola {

}

/**
 * 百事可乐产品类
 */
class PesiCola implements Cola {

}

/**
 * 可口可乐瓶子产品类
 */
class CocaColaBottle implements Bottle {

}

/**
 * 百事可乐瓶子产品类
 */
class PesiColaBottle implements Bottle {

}

/**
 * 可口可乐箱子产品类
 */
class CocaColaBox implements Box {

}

/**
 * 百事可乐箱子产品类
 */
class PesiColaBox implements Box {

}

/**
 * 百事可乐工厂类
 * 百事可乐工厂专门生产百事可乐
 */
class PesiColaFactory implements Factory {
    /**
     * 百事可乐工厂专门生产百事可乐
     */
    @Override
    public Cola createCola() {
        return new PesiCola();
    }

    /**
     * 百事可乐工厂专门生产百事可乐瓶子
     */
    @Override
    public Bottle createBottle() {
        return new PesiColaBottle();
    }

    /**
     * 百事可乐工厂专门生产百事可乐箱子
     */
    @Override
    public Box createBox() {
        return new PesiColaBox();
    }
}

/**
 * 可口可乐工厂类
 */
class CocaColaFactory implements Factory {
    /**
     * 可口可乐工厂专门生产可口可乐
     */
    @Override
    public Cola createCola() {
        return new CocaCola();
    }

    /**
     * 百事可乐工厂专门生产百事可乐瓶子
     */
    @Override
    public Bottle createBottle() {
        return new CocaColaBottle();
    }

    /**
     * 百事可乐工厂专门生产百事可乐箱子
     */
    @Override
    public Box createBox() {
        return new CocaColaBox();
    }
}