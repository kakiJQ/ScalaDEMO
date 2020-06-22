package com.atguigu.scala.chapter05

/**
  * @Description
  * @Author kaki
  * @create 2020-05-20-9:54 PM
  */
object Scala05_Function4 {

  def main(args: Array[String]): Unit = {

    /*def fun(i:Int*) : Unit = {
      println(i(1))
    }*/

    //fun()
    //fun(1,2)
    //fun(1,2,3,4)

    /*def fun1(age:Int,i:Int*) : Unit = {
      println("age: " + age + " " + i)
    }

    fun1(1)
    fun1(1,1,2)
    fun1(1,2,2,2)*/

    /*def fun2(
            i1 : Int,
            i2 : Int,
            i3 : Int,
            i4 : Int,
            i5 : Int,
            i6 : Int,
            i7 : Int,
            i8 : Int,
            i9 : Int,
            i10 : Int,
            i11 : Int,
            i12 : Int,
            i13 : Int,
            i14 : Int,
            i15 : Int,
            i16 : Int,
            i17 : Int,
            i18 : Int,
            i19 : Int,
            i20 : Int,
            i21 : Int,
            i22 : Int,
            i23 : Int,
            i24 : Int,

            ) : Unit = {

    }

    val a = fun2(1,2,3,4,5,6,7,8,
      9,10,11,12,13,14,15,16,
      17,18,19,20,21,22,23,25)_*/

    def user(ID:String, password:String = "000000", gender:String) : Unit = {
      println("ID=" + ID + " Password=" + password + " Gender=" + gender)
    }

    //user("kaki")
    user(ID="kaki", gender="Man")

  }

}
