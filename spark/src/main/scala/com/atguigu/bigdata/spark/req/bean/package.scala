package com.atguigu.bigdata.spark.req

/**
  * @Description
  * @Author kaki
  * @create 2020-06-09-10:34 PM
  */
package object bean {

  case class HotCategory(
                          categoryId : String,
                          var clickCount : Int,
                          var orderCount : Int,
                          var payCount   : Int
                        )

  case class UserVisitAction(
                              date: String,//用户点击行为的日期
                              user_id: Long,//用户的ID
                              session_id: String,//Session的ID
                              page_id: Long,//某个页面的ID
                              action_time: String,//动作的时间点
                              search_keyword: String,//用户搜索的关键词
                              click_category_id: Long,//某一个商品品类的ID
                              click_product_id: Long,//某一个商品的ID
                              order_category_ids: String,//一次订单中所有品类的ID集合
                              order_product_ids: String,//一次订单中所有商品的ID集合
                              pay_category_ids: String,//一次支付中所有品类的ID集合
                              pay_product_ids: String,//一次支付中所有商品的ID集合
                              city_id: Long
                            )//城市 id

}
