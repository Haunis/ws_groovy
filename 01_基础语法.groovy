"""
这里不是注释,,是字符串....

注释:
  Groovy注释标记和Java一样，支持//或者/**/
  Groovy语句可以不用分号结尾。Groovy为了尽量减少代码的输入，确实煞费苦心

  Groovy中支持动态类型，即定义变量的时候可以不指定其类型。Groovy中，变量定义可以使用关键字def。
注意，虽然def不是必须的，但是为了代码清晰，建议还是使用def关键字



Groovy对字符串支持相当强大，充分吸收了一些脚本语言的优点：
1  单引号''中的内容严格对应Java中的String，不对$符号进行转义
   defsingleQuote='I am $ dolloar'  //输出就是I am $ dolloar
2  双引号""的内容则和脚本语言的处理有点像，如果字符中有$号的话，则它会$表达式先求值。
   defdoubleQuoteWithoutDollar = "I am one dollar" //输出 I am one dollar
   def x = 1
   defdoubleQuoteWithDollar = "I am $x dolloar" //输出I am 1 dolloar
3 三个引号'''xxx'''中的字符串支持随意换行 比如
   defmultieLines = '''
     begin
     line  1
     line  2
     end 
     '''
 
""" 

def var1 = 1   //可以不使用分号结尾
def var2 = "I ama person"
def  int x = 1  //变量定义时，也可以直接指定类型

println "var1: "+var1