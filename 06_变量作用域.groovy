def x = 10 //def x 会将x放到反编译java代码的run函数里
y = 20
def func(){

    // println x //error;不能访问
    println y //可以访问
}

func()
