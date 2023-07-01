'''
    定义函数时函数返回类型可以不指定,不指定返回类型必须使用def关键字

    函数调用时可以不写括号
'''
println '-------------1.定义完整的函数-----------------'
//如果指定了函数返回类型，则可不必加def关键字来定义函数
def String fun1(arg1, arg2) { //无需指定参数类型
    println 'fun1 called'
    return 'this is fun1'
}
// println fun1.getClass() //error,这样拿不到函数的类型
fun1(1, 2)
fun1 1,2 //调用时,可以不带括号

println '\n-------------2.无def关键字的函数-----------------'
//定义了返回类型,但可以不返回值
String fun2(arg1, arg2) {
    println 'fun2 called'
}
ret = fun2(1, 2)
println 'ret: ' + ret //null;fun2()无返回值,所以ret=null

println '\n-------------3.无返回类型,无return的函数-----------------'
//无返回类型的函数定义，必须使用def关键字;
//最后一行执行的结果就是函数的返回值
def fun3() {
    a = 3
    b = 4
    c = 'fun3 last line' //返回最后一行的值
}
ret = fun3()
println 'ret: ' + ret //4; 返回最后一行

println '\n-------------4.定义lambda匿名函数-----------------'
// def func = { a, b -> return a + b } //ok
func = { a, b -> return a + b }//goovy可以省略def关键字，但在gradle里不可省略def
println 'func(3,4) = ' + func(3, 4)

println '\n-------------5.1参数含有闭包的函数-----------------'
//Groovy中，当函数的最后一个参数是闭包的话，调用时可以省略圆括号。
def fun4(int a, String b, Closure closure) {
    // println 'closure type: ' + closure.getClass() //class 04_函数$_run_closure2
    // closure(a,b) //调用闭包
    closure a,b //调用时也可以不带括号
}
func = { a, b -> println a + ' ' + b }
fun4(4, 'test1', func)
fun4 4, 'test2', func //调用时免括号
// fun4(4, 'test3')func//error，报错
fun4(4, 'test3') { a, b -> println a + ' ' + b } //ok

println'\n-------------5.2参数只有闭包的函数-----------------'
def fun5(Closure closure) {
    closure() //调用闭包
}

fun5({  println'i am in closure1' }) //传入函数(闭包？)
fun5 {  println'i am in closure2' } //可以不用带括号，直接调用

println '\n-------------6.注意事项-----------------'
/*
1.def 和函数返回必有一个,否则报错
fun6(){
    println "fun6 called"
}
*/

/*
2.函数定义要带括号,否则报错
String fun7{
    println "fun7"
    return "fun7"
}
*/
