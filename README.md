# guabridge
Starting with Java 8, the Java language has introduced features, 
primarily functional interfaces, that Guava also provides. While these 
features perform effectively the same function, they are not the same and 
are not currently compatible with each other.

While it is ideal to migrate Guava code to use the common classes 
included in the Java language whenever possible, this is not always possible 
or desirable.
  
The guabridge project provides a solution for when it is necessary or 
desired to use Guava in a project that allows one to maximize the amount
of code written using the Java language equivalent of Guava classes.

There are two common use cases for guabridge:
- When it is not feasible or possible to migrate Guava code to use the
classes built into Java.
- When it is desirable to use features in Guava that are not present in 
the Java language that use classes that have a Java language equivalent. 
An example of this would be the methods in the MultiMaps utility class 
that use functional interfaces.

Most of the classes responsible for achieving compatibility are in the
com.jfisherdev.guabridge.adapters package. The classes follow the naming
convention of the name of the class in Guava, which are usually the
same in the Java language, followed by "Adapter." For example, the class
for adapting the Function interface is FunctionAdapter. These adapter 
classes typically consist of two static factory methods, one for converting 
the Java language class to the Guava equivalent called "toGuava" and one 
called "fromGuava" for the opposite conversion. Documentation is typically
limited in these classes and methods, as they are generally self-describing.