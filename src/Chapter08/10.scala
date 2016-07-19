class Stack[A] protected (protected val elems: List[A])

/*
来源: https://github.com/scala/scala/blob/2.12.x/src/library/scala/collection/immutable/Stack.scala#L50
第一个protected修饰主构造器的权限, 指明只有其子类才可以调用;
第二个protected修饰主构造器的参数elems的可见性, 指明elems字段对其子类可见。
 */