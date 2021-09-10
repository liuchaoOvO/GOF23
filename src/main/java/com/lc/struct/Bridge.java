package com.lc.struct;

interface DrawAPI {
    public void drawCircle(int radius, int x, int y);
}

/**
 * @Classname Bridge
 * @Date 2021/9/10 下午5:15
 * @Created by liuchao58
 * @Description 桥接模式(Simple Factory Pattern)：将抽象部分与它的实现部分分离,使它们都可以独立地变化。
 * <p>
 * 例子：
 * 我们有一个作为桥接实现的 DrawAPI 接口和实现了 DrawAPI 接口的实体类 RedCircle、GreenCircle。
 * MyBridgeShape 是一个抽象类，将使用 DrawAPI 的对象。
 * Bridge 类 main方法使用 MyBridgeShape 类来画出不同颜色的圆。
 */
public class Bridge {
    public void main(String[] args) {
        MyBridgeShape redCircle = new MyCircle(100, 100, 10, new RedCircle());
        MyBridgeShape greenCircle = new MyCircle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}

/**
 * 使用 DrawAPI 接口创建抽象类 MyBridgeShape。
 */
abstract class MyBridgeShape {
    protected DrawAPI drawAPI;

    protected MyBridgeShape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}

class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius + ", x: " + x + ", " + y + "]");
    }
}

class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + radius + ", x: " + x + ", " + y + "]");
    }
}

/**
 * 创建实现了 MyBridgeShape 抽象类的实体类。
 */
class MyCircle extends MyBridgeShape {
    private int x, y, radius;

    public MyCircle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}