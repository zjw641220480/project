package cn.itcast.zjw.design.builder;

/**
 * @Description <p>
 *              Builder设计模式
 *              </p>
 * @author TOM
 * @date 2016年5月20日 下午3:58:20
 * @version V1.3.1
 */
public class StudentBuilderDemo {
	private String name;
	private int age;
	private String sex;

	private StudentBuilderDemo(Builder builder) {
		this.age = builder.age;
		this.name = builder.name;
		this.sex = builder.sex;
	}

	@Override
	public String toString() {
		return "StudentBuilderClass [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

	public static class Builder {
		private String name;
		private int age;
		private String sex;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder age(int age) {
			this.age = age;
			return this;
		}

		public Builder sex(String sex) {
			this.sex = sex;
			return this;
		}

		public StudentBuilderDemo builder() {
			return new StudentBuilderDemo(this);
		}
	}

}
