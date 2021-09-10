package com.lc.struct;



/**
 * @Classname Facade
 * @Date 2021/9/10 下午4:18
 * @Created by liuchao58
 * @Description 外观模式(Facade Pattern)：外观模式定义了一个高层接口，为子系统中的一组接口提供一个统一的接口。
 * 外观模式又称为门面模式，它是一种结构型设计模式模式。外观模式将一些复杂的逻辑都隐藏
 * 例子：
 * 我们将创建一个 MyShape 接口和实现了 MyShape 接口的实体类。下一步是定义一个外观类 ShapeMaker。
 * ShapeMaker 类使用实体类来代表用户对这些类的调用。Facade 类使用 ShapeMaker 类来显示结果。
 *
 * 优点：
 * 实现了客户端与子系统间的解耦：客户端无需知道子系统的接口，简化了客户端调用子系统的调用过程，使得子系统使用起来更加容易。同时便于子系统的扩展和维护。
 * 符合迪米特法则（最少知道原则）：子系统只需要将需要外部调用的接口暴露给外观类即可，而且他的接口则可以隐藏起来。
 *
 * 缺点：
 * 违背了开闭原则：在不引入抽象外观类的情况下，增加新的子系统可能需要修改外观类或客户端的代码。
 */
public class Facade {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
/**
 * 创建一个接口
 */
interface MyShape {
    void draw();
}
/**
 * 创建实现接口的实体类 Rectangle
 */
class Rectangle implements MyShape {
    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}

/**
 * 创建实现接口的实体类 Square
 */
class Square implements MyShape {
    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}

/**
 * 创建一个外观类
 */
class ShapeMaker {
    private MyShape rectangle;
    private MyShape square;

    public ShapeMaker() {
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }
}