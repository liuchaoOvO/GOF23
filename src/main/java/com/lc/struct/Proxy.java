package com.lc.struct;

/**
 * 创建一个接口 Image
 */
interface Image {
    void display();
}

/**
 * @Classname Proxy
 * @Date 2021/9/10 下午4:29
 * @Created by liuchao58
 * @Description 代理模式(Proxy Pattern) ：为某个对象提供一个代理，并由这个代理对象控制对原对象的访问。
 * <p>
 * 例子：
 * 我们将创建一个 Image 接口和实现了 Image 接口的实体类。ProxyImage 是一个代理类，减少 RealImage 对象加载的内存占用。
 * <p>
 * 类使用 ProxyImage 来获取要加载的 Image 对象，并按照需求进行显示。
 * <p>
 * 优点：
 * 降低系统的耦合度：代理模式能够协调调用者和被调用者，在一定程度上降低了系统的耦合度。
 * 不同类型的代理可以对客户端对目标对象的访问进行不同的控制：
 * 远程代理,使得客户端可以访问在远程机器上的对象，远程机器 可能具有更好的计算性能与处理速度，可以快速响应并处理客户端请求。
 * 虚拟代理通过使用一个小对象来代表一个大对象，可以减少系统资源的消耗，对系统进行优化并提高运行速度。
 * 保护代理可以控制客户端对真实对象的使用权限。
 * <p>
 * 缺点：
 * 由于在客户端和被代理对象之间增加了代理对象，因此可能会让客户端请求的速度变慢。
 */
public class Proxy {
    public void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");
        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}

/**
 * 创建实现接口的实体类RealImage
 */
class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }
}

/**
 * 创建实现接口的代理类ProxyImage
 */
class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

