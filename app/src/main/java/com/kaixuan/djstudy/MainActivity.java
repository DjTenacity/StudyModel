package com.kaixuan.djstudy;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.kaixuan.djstudy.abstractfactory.BlueFactory;
import com.kaixuan.djstudy.abstractfactory.IFactory;
import com.kaixuan.djstudy.buildermodel.Build;
import com.kaixuan.djstudy.buildermodel.Designer;
import com.kaixuan.djstudy.buildermodel.Room;
import com.kaixuan.djstudy.buildermodel.WorkBuilder;
import com.kaixuan.djstudy.buildmodel2.Room2;
import com.kaixuan.djstudy.buildmodel2.WorkBuider2;
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
//AOP就是将编译时的代码替换成想要的代码,编译后的代码和非aop的是一样的代码
    //就是打一个注解,在class文件里面做一个替换

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


    //原型模式
    void Prototype() {
        //保留存根
        OrderDealFactory factory = new OrderDealFactory();
        PersonOrder order = new PersonOrder();
        order.setOrderName("对象");
        order.setOrderNumber(3200);
        factory.dealOrder(order);
    }

    //建造者模式
    void builderModle() {

        Build build = new WorkBuilder();
        Designer designer = new Designer();

        Room room = designer.builder(build);
        Log.w("builderModle", room.toString());
        (new WorkBuider2()).makeCateen("呵呵").makeFllor("松木").makeWindow("镂空").build().show();

        Room2 room2 = (new WorkBuider2()).makeCateen("呵呵").makeFllor("松木").makeWindow("镂空").build();
        Log.w("builderModle", room2.toString());


        //*******************系统*********************
        //AlertDialog不是create创建了两次,create是 build里面的方法,,,954行的create();返回的是build所持有的dialog
        //AlertDialog show方法调用的是Dialog里面的方法,因为链式调用前面返回的是dialog对象,如上

        // P.apply(dialog.mAlert);  把P里面的数据给mAlert,在创建dialog方法的同时创建了mAlet

        //Dialog有生命周期

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("22").setIcon(R.mipmap.ic_launcher_round)
                .setMessage("333")
                .setNegativeButton("heheh", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("hahhh", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create().show();
    }

}
