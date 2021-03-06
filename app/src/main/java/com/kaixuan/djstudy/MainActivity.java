package com.kaixuan.djstudy;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.kaixuan.djstudy.abstractfactory.BlueFactory;
import com.kaixuan.djstudy.abstractfactory.IFactory;
import com.kaixuan.djstudy.buildermodel.Build;
import com.kaixuan.djstudy.buildermodel.Designer;
import com.kaixuan.djstudy.buildermodel.Room;
import com.kaixuan.djstudy.buildermodel.WorkBuilder;
import com.kaixuan.djstudy.buildmodel2.Room2;
import com.kaixuan.djstudy.buildmodel2.WorkBuider2;
import com.kaixuan.djstudy.decorate.simple1.PersonEat;
import com.kaixuan.djstudy.decorate.simple1.TeacherEat;
import com.kaixuan.djstudy.handler.AbstractRequest;
import com.kaixuan.djstudy.handler.Handler;
import com.kaixuan.djstudy.handler.Handler1;
import com.kaixuan.djstudy.handler.Handler2;
import com.kaixuan.djstudy.handler.Handler3;
import com.kaixuan.djstudy.handler.Request3;
import com.kaixuan.djstudy.interpretor.Caculator;
import com.kaixuan.djstudy.observer.AbstractSubject;
import com.kaixuan.djstudy.observer.ConcreteObserver;
import com.kaixuan.djstudy.observer.Observer;
import com.kaixuan.djstudy.prototype.OrderDealFactory;
import com.kaixuan.djstudy.prototype.PersonOrder;
import com.kaixuan.djstudy.simplefactory1.ExportTextOperator;
import com.kaixuan.djstudy.simplefactory2.Factory;
import com.kaixuan.djstudy.strategy.MemberContext;
import com.kaixuan.djstudy.strategy.Strategy;
import com.kaixuan.djstudy.strategy.Strategy1;
import com.kaixuan.djstudy.template.simple1.Game;
import com.kaixuan.djstudy.template.simple1.LoLGame;
import com.kaixuan.djstudy.templotor.TVStatusControl;
import com.kaixuan.djstudy.templotor.TvControl;

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
        //内有枚举 Status  只能执行一次
       // new Task().execute();

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

    public class Task extends AsyncTask<Void,Integer,String>{
        @Override
        protected String doInBackground(Void... voids) {
            //做耗时的操作 子线程   是在线程池中运行的
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            //执行完成 主线程 用handler切换过来
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            //更新部分 主线程
            super.onProgressUpdate(values);
        }
    }

    //观察者模式   一对多   onTouchEvent也是观察者模式,不过是一对一
    public void observer(View view) {
        //建立被观察者
        AbstractSubject abstractSubject = new AbstractSubject();

        //建立观察者
        Observer observer1 = new ConcreteObserver("观察者  1");
        Observer observer2 = new ConcreteObserver("观察者  2");
        Observer observer3 = new ConcreteObserver("观察者  3");
        Observer observer4 = new ConcreteObserver("观察者  4");

        //建立联系
        abstractSubject.attach(observer1);
        abstractSubject.attach(observer2);
        abstractSubject.attach(observer3);
        abstractSubject.attach(observer4);

        //开始通知观察者
        abstractSubject.notify("国庆假期结束了");
        //注销掉
        abstractSubject.detach(observer1);
        abstractSubject.detach(observer2);
        abstractSubject.detach(observer3);
        abstractSubject.detach(observer4);
    }

    //状态模式   可以与策略模式互换
    public void templotor() {
        //遥控器-->不用状态模式
        TvControl tvControl = new TvControl();
        tvControl.powerOff();

        //使用状态模式
        TVStatusControl tvStatusControl = new TVStatusControl();
        tvStatusControl.powerOn();
        tvStatusControl.nextChannel();
        tvStatusControl.powerOff();

        /**
         * TVStatusControl在这里setState(...)并进行相应的操作就是策略模式
         */
    }

    //策略模式
    public void Strategy(View v) {
        Strategy strategy = new Strategy1();
        MemberContext memberContext = new MemberContext(strategy);
        System.out.print("打折后" + memberContext.caculetor(100.00));

//     策略模式之动画框架
        ValueAnimator alpha = ObjectAnimator.ofFloat(v, "ScaleX", 0f, 1f);
        alpha.setDuration(2000);
        alpha.setInterpolator(new DecelerateInterpolator());//设置动画插入器,减速
        alpha.setRepeatCount(-1);//无线
        alpha.start();

        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f, 0, 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f, 0, 1f);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(v, pvhY, pvhZ);
        animator.setDuration(2000);
        animator.setRepeatCount(-1);//无线
        animator.start();
    }

    //装饰模式   不调用继承就扩展一个类的功能,使其更加强大  一般的写法new对象调用方法
    public void decorte(){
        PersonEat eat= new PersonEat();
        TeacherEat teacherEat =new TeacherEat(eat);
        teacherEat.eat();


        //装饰设计模式的写法::一般都是把类对象作为构造参数传递

        //RecycleView 利用装饰设计模式来添加头部和底部  ,可以参考ListView的 addHeardView方法  --->heardViewListAdapter
        //

    }


}
//正则表达式"^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$"  ^是开始,$是结束