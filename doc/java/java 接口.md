# 权限关系

```
					同类   同包    子类     其他包
public 			 √     √       √        √ 
protected			 √     √       √ 
默认		        √     √ 
private.          √ 

```
# 继承与接口
在类的声明中，通过关键词extends声明一个类的子类。

* 方法重写 子类通过重写隐藏已继承的实例方法
* super 使用super操作被隐藏的成员变量和方法
* final 修饰类、成员变量与方法中的局部变量。final类不允许被继承，final方法不允许被重写，final常量声明时必须指定该常量的值，而且不能再发生变化
# abstract类和abstract方法

* abstract类可以有abstract方法，也可以有非abstract方法。
* abstract类不能用new运算符创建对象。
* 如果一个非抽象类是某个抽象类的子类，必须重写父类所有的抽象方法。
* abstract类可以没有abstract方法
* 如果一个abstract类是abstract类的子类，它可可以重写父类的abstract方法，也可以继承这个abstract方法。


# 接口
同一个类只能有一个父类，一个类可以实现多个接口。

接口中只有抽象方法，没有普通的方法。

* 接口中所有的常量的访问权限一定都是public（允许省略public final修饰符）
* 接口中的所有抽象方法的访问权限都是public （允许省略public abstract修饰符）

如果一个类实现了某个接口，那么这个类必须重写该接口的所有方法。重写接口方法时，接口中的方法一定是public abstract方法，类在重写方法时不仅要去掉abstract修饰，而且方法的访问权限一定要明显地用public修饰。

类重写的接口方法及接口中的常量可以被类的对象调用，而常量也可以被类名或接口名直接调用。

接口声明时，如果关键字interface前面加上public，这样的接口是一个public接口。public接口可以被人以类实现。如果一个接口不加public修饰，为友好接口类，友好接口可以被与该接口在同一个包中的类声明实现。

如果父类实现了某个接口，那么子类自然实现了该接口，子类不必再显式地使用关键词字implements声明实现这个接口。

如果一个类声明实现一个接口，但是没有重写接口中的所有方法，那么这个类必须是abstract类

接口回调是指可以实现某一接口的类创建的对象的引用赋给该接口声明的接口变量中，那么该接口变量就可以调用被类重写的接口方法。实际上，当接口变量调用被类重写的接口方法时，就是通知相应的对象调用这个方法。

```
public class Main {
    public static void main(String[] args) {
        ShowMessage sm;
        sm =new A();
        sm.Show("A");
        sm =new B();
        sm.Show("B");
        System.out.println(sm.Max);
        System.out.println(ShowMessage.Max);
    }
}

interface ShowMessage{
    int Max = 100;
    void Show(String s);
}

class A implements ShowMessage{
    public void Show(String s){
        System.out.println(s);
    }
}
class B implements ShowMessage{
    public void Show(String s){
        System.out.println(s);
    }
}
```
# 接口和abstract类对比
* abstract类和接口都可以有abstract方法
* 接口中只可以有常量，不能有变量；而abstract类中既可以有常量也可以有变量
* abstract类中可以有非abstract方法，接口都是abstract方法