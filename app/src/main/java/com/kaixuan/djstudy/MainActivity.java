package com.kaixuan.djstudy;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.kaixuan.djstudy.abstractfactory.BlueFactory;
import com.kaixuan.djstudy.abstractfactory.IFactory;
import com.kaixuan.djstudy.buildermodel.Build;
import com.kaixuan.djstudy.buildermodel.Designer;
import com.kaixuan.djstudy.buildermodel.Room;
import com.kaixuan.djstudy.buildermodel.WorkBuilder;
import com.kaixuan.djstudy.buildmodel2.Room2;
import com.kaixuan.djstudy.buildmodel2.WorkBuider2;
import com.kaixuan.djstudy.handler.AbstractRequest;
import com.kaixuan.djstudy.handler.Handler;
import com.kaixuan.djstudy.handler.Handler1;
import com.kaixuan.djstudy.handler.Handler2;
import com.kaixuan.djstudy.handler.Handler3;
import com.kaixuan.djstudy.handler.Request3;
import com.kaixuan.djstudy.interpretor.Caculator;
import com.kaixuan.djstudy.prototype.OrderDealFactory;
import com.kaixuan.djstudy.prototype.PersonOrder;
import com.kaixuan.djstudy.simplefactory1.ExportTextOperator;
import com.kaixuan.djstudy.simplefactory2.Factory;
import com.kaixuan.djstudy.template.Game;
import com.kaixuan.djstudy.template.LoLGame;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //AOP就是将编译时的代码替换成想要的代码,编译后的代码和非aop的是一样的代码
    //就是打一个注解,在class文件里面做一个替换

    //工厂模式:构建一个对象
    void simpleFactory(View view) {
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
    void Prototype(View view) {
        //保留存根
        OrderDealFactory factory = new OrderDealFactory();
        PersonOrder order = new PersonOrder();
        order.setOrderName("对象");
        order.setOrderNumber(3200);
        factory.dealOrder(order);
    }

    //建造者模式 :对象特别复杂,扩展性很强,,,表示和构建分离
    //
    void builderModle(View view) {

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

    /**
     * 责任链模式.....单链表
     * <p>
     * 事件分发机制:首先获取事件的是activity---->window---->decorlView
     * 广播BroadcastReceiver的原理:
     */
    public void handlerModle(View view) {
        //确定链式关系
        Handler handler1 = new Handler1();
        Handler handler2 = new Handler2();
        Handler handler3 = new Handler3();
        handler1.nextHandler = handler2;
        handler2.nextHandler = handler3;

        AbstractRequest request3 = new Request3("请求1");

        handler1.handleRequest(request3);
    }

    //解释器模式   对于大量重复性操作是十分友好的
    //必须要有一个抽象接口  ;;;;;  必须要构建语法树
    //每个语法都要产生一个非终结符表达式,语法规则比较复杂时,就可能产生大量的类文件,为维护带来了麻烦
    //
    //递归调用的方法,只能一层一层的剥茧,
    public void interpretor(View view) {
        String contentString = "3 * 5 * 7 / 3  %  36";
        Caculator caculator = new Caculator();
        int result = caculator.build(contentString);

    }

    //模板模式         AsyncTask
    public void template(View view) {
        Game game = new LoLGame();
        game.play();

        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected void onPreExecute() {//准备
                super.onPreExecute();
            }

            @Override
            protected Object doInBackground(Object[] params) {//进行
                return null;
            }

            @Override
            protected void onProgressUpdate(Object[] values) {//更新
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPostExecute(Object o) {//结束
                super.onPostExecute(o);
            }
        }.execute();
    }

}
//正则表达式"^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$"  ^是开始,$是结束