package com.ahmetvatansever;

public class Main {

    /*
        String ilkel bir veri tipi değil bir sınıftır ve kendine ait özellikleri vardır.
        Stringler immutable yani değiştirilemezdir. Bu değiştirilemezlik durumu String değişken oluşturup değer
        atamayı değil heap'te tutulan alanı ifade etmektedir. String için her değer ataması yapıldığında heap'te yeni
        bir alan açılır. Her defasında hafızada bir alan açılıyor olması zaman ve performans açısından kayıplara sebep olur.
        Bu durumda StringBuilder ve StringBuffer kullanılır.

        StringBuilder mutable yani değiştirilebilirdir. Stringte olduğu gibi her değişiklikte heap'te yeni bir alan açmaz,
        heap'te tutulan bir alan var ise orada değişiklik yapar. Fakat StringBuilder tread-safe değildir ve synchronized çalışmaz.
        Yani threadli bir işlem için kullanılacak ise StringBuilder kullanılması güvenli/tutarlı olamayacaktır.
        Bunun sebebi StringBuilder üzerinde birden fazla thread değişiklik yapmaya çalıştığında bunu engelleyememesidir.
        Bir mail templatinde "Merhaba <AD> <SOYAD>" gibi bir metinde birden fazla thread çalıştığı durumda bir theadin
        yaptığı değişikliği farlı bir thread işlem yapmak istediğinde ezmiş olur.


        StringBuffer, StringBuilder ile aynı metodlara sahiptir. Aralarındaki fark ise thread-safe yani synchronized çalışır.
        StringBuffer bu özelliğinden dolayı threadli işlemlerde kullanılır.
        Thread-safe olması durumu StringBuilderdan daha yavaş çalışmasına sebep olmaktadır.

        String icin gecen sure : 3265ms
        StringBuilder icin gecen sure : 5ms
        StringBuffer icin gecen sure : 6ms

    * */

    public static void main(String[] args) {
        Integer count = 100000;

        long startTime = System.currentTimeMillis();
        String myString = "";
        for (int i = 0; i < count; i++) {
            myString += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("String icin gecen sure : " + (endTime - startTime) + "ms");


        startTime = System.currentTimeMillis();
        StringBuilder myStringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            myStringBuilder.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder icin gecen sure : " + (endTime - startTime) + "ms");


        startTime = System.currentTimeMillis();
        StringBuffer myStringBuffer = new StringBuffer();
        for (int i = 0; i < count; i++) {
            myStringBuffer.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer icin gecen sure : " + (endTime - startTime) + "ms");
    }
}
