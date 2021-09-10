package com.lc.create.builder;

/**
 * @author liuchaoOvO on 2020/4/14
 * @Description builder 模式
 * 生成器模式(Builder Pattern)：也叫创建者模式，它将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * <p>
 * 举例：
 * 步骤
 * 创建一个实体类BuilderPattern，里面有个和实体类（只能获取变量值）相同变量的静态内部类Builder（设置变量值） 。在实体类通过构造函数来构造一个Builder，通过调用build（）来建造一个具体的实体对象。
 */
public class BuilderPattern {

    public String patternId;
    public String patternName;
    public String patternDesc;

    //构造方法
    public BuilderPattern() {
        this(new Builder());
    }

    //构造方法
    public BuilderPattern(Builder builder) {
        this.patternId = builder.patternId;
        this.patternName = builder.patternName;
        this.patternDesc = builder.patternDesc;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "BuilderPattern{" +
                "patternId='" + patternId + '\'' +
                ", patternName='" + patternName + '\'' +
                ", patternDesc='" + patternDesc + '\'' +
                '}';
    }

    public static class Builder {
        public String patternId;
        public String patternName;
        public String patternDesc;

        //构造方法
        public Builder() {
            patternId = patternId;
            patternName = patternName;
            patternDesc = patternDesc;
        }

        //构造方法
        public Builder(BuilderPattern builderPattern) {
            this.patternId = builderPattern.patternId;
            this.patternName = builderPattern.patternName;
            this.patternDesc = builderPattern.patternDesc;
        }

        public Builder patternId(String patternId) {
            this.patternId = patternId;
            return this;
        }

        public Builder patternName(String patternName) {
            this.patternName = patternName;
            return this;
        }

        public Builder patternDesc(String patternDesc) {
            this.patternDesc = patternDesc;
            return this;
        }

        //构建一个实体
        public BuilderPattern build() {
            return new BuilderPattern(this);
        }
    }
   /*
   //@Test
    public static void main(String[] args) {
        BuilderPattern builderPattern = BuilderPattern.builder().patternDesc("desc").patternName("testName").patternId("1").build();
        System.out.println(builderPattern);
    }
    */
}