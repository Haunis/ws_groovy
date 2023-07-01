'''
Groovy中的数据类型我们就介绍两种和Java不太一样的：
    1.一个是Java中的基本数据类型。
    2.另外一个是Groovy中的容器类。
    3.最后一个非常重要的是闭包。

1.基本数据类型:
    作为动态语言，Groovy世界中的所有事物都是对象。
    所以，int，boolean这些Java中的基本数据类型，在Groovy代码中其实对应的是它们的包装数据类型。
    比如int对应为Integer，boolean对应为Boolean。

2.Groovy中的容器类很简单，就三种：
    List：链表，其底层对应Java中的List接口，一般用ArrayList作为真正的实现类。
    Map：键-值表，其底层对应Java中的LinkedHashMap。
    Range：范围，它其实是List的一种拓展。
'''

println '------------1.基础数据类型Integer--------------'
// def x = 18
x = 18 //和python一样,定义变量可以不指定类型,不用def
println x.getClass().getCanonicalName() //java.lang.Integer

println '------------2.String--------------'
x = '188'
println x.getClass().getCanonicalName() //String
println "${x}" //188

println '------------2.1.String 转int--------------'
x = '188'
// y = x.parseInt() #弃用error
x = Integer.parseInt(x)
println x.getClass().getCanonicalName()  //Integer
println '------------2.2 int 转String--------------'
x = 188
// x = x + ''//ok
x = String.valueOf(x) //ok
println x.getClass().getCanonicalName()

println '\n------------3.1 容器之List--------------'
//变量定义：List变量由[]定义，其元素可以是任何对象
def aList = [5, 'string', true]
//变量存取：可以直接通过索引存取，而且不用担心索引越界。如果索引超过当前链表长度，List会自动
//往该索引添加元素
assert aList[1] == 'string'
assert aList[5] == null //第6个元素为空
aList[100] = 100 //设置第101个元素的值为10
assert aList[100] == 100
//列表大小
println 'aList.size: ' + aList.size

println '\n------------3.2 容器之Map--------------'

"""
    变量定义：Map变量由[:]定义
        冒号左边是key，右边是Value。
        key必须是字符串，value可以是任何对象。
        另外，key可以用''或""包起来，也可以不用引号包起来。
"""
def aMap = ['key1':'value1', 'key2':true]

//其中的key1和key2默认被处理成字符串"key1"和"key2"
def aNewMap = [key1:'value', key2:true]
//不过Key要是不使用引号包起来的话，也会带来一定混淆，比如
def key1 = 'wowo'
def aConfusedMap = [key1:'who am i?'] //这里的key是 "key1"
println 'aConfusedMap.key1: ' + aConfusedMap.key1 //who am i?
println 'aConfusedMap.wowo: ' + aConfusedMap.wowo //null

//如果要是"wowo"的话，则aConfusedMap的定义必须设置成：
def aConfusedMap2 = [(key1):'who am i?']

//Map中元素的存取更加方便，它支持多种方法：
println aMap.key1    //<==这种表达方法好像key就是aMap的一个成员变量一样
println aMap['key1'] //<==这种表达方法更传统一点,像python

//添加新元素
aMap.anotherkey = 'i am map'

println '\n------------3.3 容器之Range--------------'
//Range类型的变量 由begin值+两个点+end值表示
//左边这个aRange包含1,2,3,4,5这5个值
def aRange = 1..5

//如果不想包含最后一个元素，则1..<5
def aRangeWithoutEnd = 1..<5
println aRange.from
println aRange.to
