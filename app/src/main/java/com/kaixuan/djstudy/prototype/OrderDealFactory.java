package com.kaixuan.djstudy.prototype;

/**
 * Comment:
 *
 * @author :DJ鼎尔东 / 1757286697@qq.cn
 * @version : Administrator1.0
 * @date : 2017/9/6
 */
public class OrderDealFactory {
    public void dealOrder(IOrder order) {
        int number = order.getOrderNumber();

        while (number > 0) {

//            if (order instanceof PersonOrder) {//个人
//                //原来的方法
//                System.out.print("y原始" + order.hashCode());
//                IOrder iOrder = null;
//                PersonOrder personOrder = (PersonOrder) order;
//                PersonOrder newPersonOrder = new PersonOrder();
//                newPersonOrder.setOrderName(personOrder.getOrderName());
//                newPersonOrder.setOrderNumber(number >= 1000 ? 1000 : number);
//                System.out.print(newPersonOrder.getOrderNum() + "" + newPersonOrder.getOrderName());
//                iOrder = personOrder;
//                number -= 1000;
//            } else {
//            }//公司
//
            IOrder iOrder = (IOrder) order.clonePrototype();

            iOrder.setOrderNumber(number >= 1000 ? 1000 : number);

            System.out.print(iOrder.getOrderNumber() + "");

            number -= 1000;

        }
    }

}
