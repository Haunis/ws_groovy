'''
1.闭包的定义和使用:
    定义:
        方式1:def xxx = {paramters -> code} 
        方式2: def xxx = {无参数纯code} 这种case不需要->符号
    使用:
        xxx.call("this is string1",100)  
        xxx("this is string2", 200)
        
2.闭包默认参数it
    如果闭包没定义参数的话，则隐含有一个参数，这个参数名字叫it
    和this的作用类似。it代表闭包的参数。
    def greeting = { "Hello, $it!" }
    def greeting2 = { it -> "Hello, $it!"}//和上面greeting等价
    def greeting3 = { -> true } //闭包没有参数

3.闭包作为函数参数
    如: public static <T> List<T>each(List<T> self, Closure closure)

    上面这个函数表示针对List的每一个元素都会调用closure做一些处理。
    在使用这个each函数的时候，直接传闭包代码就行了

    list.each({println it})
    括号可以省略,可以改为如下调用:
    list.each{println it}
'''


println "\n--------------1.闭包的定义和使用----------------"

def aClosure = {//闭包是一段代码，所以需要用花括号括起来..
    str_arg, int_arg ->  //这个箭头很关键。箭头前面是参数定义，箭头后面是代码
    println"this is code:"+str_arg+", "+int_arg //这是代码，最后一句是返回值，
   //也可以使用return，和Groovy中普通函数一样
}
println aClosure.getClass() //class 03_闭包$_run_closure1

//闭包的调用
aClosure.call("this is string1",100)  
aClosure("this is string2", 200)

println "\n--------------2.闭包默认参数it----------------"
def greeting = { "Hello, $it!" }
def greeting2 = { it -> "Hello, $it!"}//和上面greeting等价
def greeting3 = { -> true } //闭包没有参数
assert greeting('Patrick') == 'Hello, Patrick!' //ok
assert greeting2('Patrick') == 'Hello, Patrick!' //ok
assert greeting3() == true //ok
// assert greeting3('hh')  //error,闭包没有参数,不能传参



println "\n--------------3. 闭包作为函数参数之List.each()----------------"
// public static <T> List<T>each(List<T> self, Closure closure)

def pri = { //定义一个闭包
    it->println "pri :$it"
}

def li = [1,2,3,4,5]  //定义一个List
li.each (pri) //直接传入闭包
li.each pri //闭包作为最后一个参数的话,可以省略括号

li.each({ print it })
li.each{ print it } //闭包作为最后一个参数的话,可以省略括号
