package com.lc.builder;

/**
 * @author liuchaoOvO on 2020/4/14
 * @Description builder 模式
 */
public class MyEntity {
    private int id;
    private String name;

    public MyEntity(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    static class Builder {
        private int id;
        private String name;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public MyEntity build() {
            return new MyEntity(this);
        }
    }

}
