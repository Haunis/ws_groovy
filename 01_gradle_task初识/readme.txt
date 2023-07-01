gradle官网:https://gradle.org/
gradle文档:https://docs.gradle.org/current/dsl/index.html

安装gradle:
    要求jdk版本1.8以上,不指定版本的话默认安装最近版本
    sdk install gradle 6.8.1


gradle常用命令:
    gradle projects : 查看multi projects到底包含多少个子Project
    gradle abcmodule:tasks :查看abcmodule下有多少人个task
    gradle tasks  如果已经在abcmodule下了,直接执行
    gradle properties: 用来查看所有属性信息。

执行某个task: gradle task_name,如:
    gradle assemble: 编译该project
    gradle app:assemble
    gradle hellolib:assemble
    gradle clean:删除build目录

在gradle xxx中指定什么任务，gradle就会将这个xxx任务链上的所有任务全部按依赖顺序执行一遍

gradle和gradlew的区别:
gradlew是android studio对gradle的包装
gradle版本会不断更新，每个人使用的版本可能会不同，而gradlew（wrapper）可以算是gradle的一层包装
gradlew命令会根据gradle/wrapper/gradle-wrapper.properties来使用对应的gradle进行构建，没有则会下载