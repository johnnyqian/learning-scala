package chapter08 {
  class Person(val name: String) {
    override def toString = getClass.getName + "[name=" + name+ "]"
  }

  class SecretAgent(codename: String) extends Person(codename) {
    override val name = "secret"
    override def toString = "secret"
  }

  object Test08 extends App {
    val p = new Person("johnny")
    println(p.name)
    println(p.toString)

    val s = new SecretAgent("007")
    println(s.name)
    println(s.toString)
  }
}

/*
javap -private Person
Compiled from "08.scala"
public class chapter08.Person {
private final java.lang.String name;
public java.lang.String name();
public java.lang.String toString();
public chapter08.Person(java.lang.String);
}
*/

/*
javap -private SecretAgent
Warning: Binary file SecretAgent contains chapter08.SecretAgent
Compiled from "08.scala"
public class chapter08.SecretAgent extends chapter08.Person {
private final java.lang.String name;
public java.lang.String name();
public java.lang.String toString();
public chapter08.SecretAgent(java.lang.String);
}
*/

/*
javap -c Person.class
Compiled from "08.scala"
public class chapter08.Person {
public java.lang.String name();
Code:
0: aload_0
1: getfield      #13                 // Field name:Ljava/lang/String;
4: areturn

public java.lang.String toString();
Code:
0: new           #18                 // class scala/collection/mutable/StringBuilder
3: dup
4: invokespecial #22                 // Method scala/collection/mutable/StringBuilder."<init>":()V
7: aload_0
8: invokevirtual #26                 // Method java/lang/Object.getClass:()Ljava/lang/Class;
11: invokevirtual #31                 // Method java/lang/Class.getName:()Ljava/lang/String;
14: invokevirtual #35                 // Method scala/collection/mutable/StringBuilder.append:(Ljava/lang/Object;)Lscala/collection/mutable/StringBuilder;
17: ldc           #37                 // String [name=
19: invokevirtual #35                 // Method scala/collection/mutable/StringBuilder.append:(Ljava/lang/Object;)Lscala/collection/mutable/StringBuilder;
22: aload_0
23: invokevirtual #39                 // Method name:()Ljava/lang/String;
26: invokevirtual #35                 // Method scala/collection/mutable/StringBuilder.append:(Ljava/lang/Object;)Lscala/collection/mutable/StringBuilder;
29: ldc           #41                 // String ]
31: invokevirtual #35                 // Method scala/collection/mutable/StringBuilder.append:(Ljava/lang/Object;)Lscala/collection/mutable/StringBuilder;
34: invokevirtual #43                 // Method scala/collection/mutable/StringBuilder.toString:()Ljava/lang/String;
37: areturn

public chapter08.Person(java.lang.String);
Code:
0: aload_0
1: aload_1
2: putfield      #13                 // Field name:Ljava/lang/String;
5: aload_0
6: invokespecial #45                 // Method java/lang/Object."<init>":()V
9: return
}
*/

/*
javap -c SecretAgent.class
Compiled from "08.scala"
public class chapter08.SecretAgent extends chapter08.Person {
public java.lang.String name();
Code:
0: aload_0
1: getfield      #13                 // Field name:Ljava/lang/String;
4: areturn

public java.lang.String toString();
Code:
0: ldc           #18                 // String secret
2: areturn

public chapter08.SecretAgent(java.lang.String);
Code:
0: aload_0
1: aload_1
2: invokespecial #22                 // Method chapter08/Person."<init>":(Ljava/lang/String;)V
5: aload_0
6: ldc           #18                 // String secret
8: putfield      #13                 // Field name:Ljava/lang/String;
11: return
}
*/

/*
Answer: There are 2 getter methods of name field. The getter method of name field in Person class retrieve it's value
        from constructor parameter while the getter method of name field in SecretAgent class retrieve it's value from
        literal string 'secret'.
*/