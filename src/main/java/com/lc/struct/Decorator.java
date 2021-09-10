package com.lc.struct;




/**
 * @Classname Decorator
 * @Date 2021/9/10 下午2:24
 * @Created by liuchao58
 * @Description 装饰模式(Decorator Pattern) ：不改变原有对象的前提下，动态地给一个对象增加一些额外的功能。
 * 装饰模式贴合开闭原则，在不改变原有类的情况下，对父类进行改造或新增功能。
 * 举例：
 * 我们将创建一个 Shape 接口和实现了 Shape 接口的实体类ShapeImpl。然后我们创建一个实现了 Shape 接口的抽象装饰类 ShapeDecorator，并把 Shape 对象作为它的实例变量。
 * RedShapeDecorator 是实现了 ShapeDecorator 的实体类。
 * DecoratorPatternDemo 类使用 RedShapeDecorator 来装饰 Shape 对象。
 */
public class Decorator {
}
interface Shape {
    void draw();
}
/**
 * 创建实现Shape接口的实体类ShapeImpl
 */
class ShapeImpl implements Shape {

    @Override
    public void draw() {
        System.out.println("ShapeImpl Shape");
    }
}

/**
 * 创建实现了 Shape 接口的抽象装饰类ShapeDecorator。
 */
abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void draw() {
        decoratedShape.draw();
    }
}

/**
 * 创建扩展了 ShapeDecorator 类的实体装饰类。
 */
class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }
}