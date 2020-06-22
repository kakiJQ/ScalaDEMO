package com.atguigu.scala.chapter07

/**
  * @Description
  * @Author kaki
  * @create 2020-05-28-9:23 AM
  */
object Scala19_Collection_Method2 {

  def main(args: Array[String]): Unit = {

    //val list: List[Int] = List(1,2,3,4)

    /*def transform(i:Int) = {
      i*2
    }*/

    /*val newList: List[Int] = list.map((i:Int)=>{i*2})
    val newList: List[Int] = list.map((i:Int)=>i*2)
    val newList: List[Int] = list.map((i)=>i*2)
    val newList: List[Int] = list.map(i=>i*2)*/
    //val newList: List[Int] = list.map(_*2)

    //println(newList)

    /*val list1: List[List[Any]] = List(
      List(0, 0), List("kaki", "Jayme")
    )

    println(list1.length)

    println(list1.flatten)*/

    /*val list2: List[List[Int]] = List(
      List(1, 2),
      List(3, 7)
    )*/

    //println(list2.flatten.map(_*2))

    /*def transfer(list:List[Int]) = {
      list.map(_*2)

    }*/

    //println(list2.flatMap(transfer))
    /*println(list2.flatMap((list:List[Int])=>{list.map(_*2)}))
    println(list2.flatMap((list)=>{list.map(_*2)}))
    println(list2.flatMap(list=>list.map(_*2)))*/
    //println(list2.flatMap(_.map(_*2)))

    //val strings: List[String] = List("hello scala", "hello spark")

    //strings.flatMap((s:String)=>{s.split(" ")})
    //println(strings.flatMap(_.split(" ")))

    /*val list3 = List(3,7,8,0)
    println(list3.flatMap((num: Int) => {
      List(num * 2)
    }))*/

    /*val list5 = List(1,2,3,4,5)
    println(list5.filter((num: Int) => {
      num % 2 == 0
    }))*/

    /*val strings = List("scala","spark","java","hadoop")
    println(strings.filter((s: String) => {
      s.startsWith("s")
    }))*/

    /*val list = List(1,2,3,4)
    val map: Map[Int, List[Int]] = list.groupBy((i: Int) => {
      i % 2
    })

    println(map)*/

    /*val strings = List("word","scala","word","scala")
    val map: Map[String, List[String]] = strings.groupBy((word:String)=>{word})
    println(map)*/

    //val ls = List(9,3,1,5,6,2)
    /*println(ls.sortBy((i: Int) => {
      i
    }))*/
//    val reverse: List[Int] = ls.sortBy((num:Int)=>{num}).reverse
//    println(reverse)
//    println(ls.sortBy(num=>num)(Ordering.Int.reverse))

    /*val strings = List("1","2","3","4")
    val os: List[String] = strings.sortBy((s:String)=>{s})
    println(os)*/

    val user1 = new User()
    val user2 = new User()
    val user3 = new User()

    user1.age = 10
    user1.name = "kk"
    user2.age = 20
    user2.name = "ll"
    user3.age = 20
    user3.name = "pp"




    val users = List(user1,user2,user3)
    println(users.sortBy((u:User) => {(u.age,u.name)}))

//    val strings = List("hello java","hello world","hello scala")
//    println(strings.flatMap((word: String) => {
//      word.map(s=>{s+"str"})
//    }))



  }

  class User {
    var age : Int = _
    var name : String = _

    override def toString: String = {
      s"User[$age $name]"
    }
  }

}
