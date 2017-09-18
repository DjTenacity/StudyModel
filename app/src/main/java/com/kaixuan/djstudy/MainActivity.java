package com.kaixuan.djstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kaixuan.djstudy.abstractfactory.BlueFactory;
import com.kaixuan.djstudy.abstractfactory.IFactory;
import com.kaixuan.djstudy.prototype.OrderDealFactory;
import com.kaixuan.djstudy.prototype.PersonOrder;
import com.kaixuan.djstudy.simplefactory1.ExportTextOperator;
import com.kaixuan.djstudy.simplefactory2.Factory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    void simpleFactory() {
        //简单工厂
        Factory.create(1).show();

        ExportTextOperator textOperator = new ExportTextOperator();
        textOperator.export("hehe");

        //抽象工厂,
        //调用层既没有关心构建的过程,  调用和构建过程的分离---->MedioPlayFactory(cpp)
        IFactory factory = new BlueFactory();
        factory.create().show();

        //List Creator
        //ArrayList ConcreteCreator具体的创建者
        //List<String> list = new ArrayList<String>();
        //	list.iterator();

        //Iterator Product
        //ArrayListIterator ConcreteProduct具体的产品
        /**
         * 使用场景:创建对象
         * 简单工厂:
         * 提供创建对象的功能,不需要关心具体的实现
         * <p>
         * 降低客户端与模块之间的耦合度(最少支持原则)
         * 为了代码的重用
         * 把具体的生产实现放到子类里面去完成
         */
    }

    void Prototype() {
        //保留存根
        OrderDealFactory factory = new OrderDealFactory();
        PersonOrder order = new PersonOrder();
        order.setOrderName("对象");
        order.setOrderNumber(3200);
        factory.dealOrder(order);
    }


}
