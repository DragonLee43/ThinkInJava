## 一、JAVA流式输入/输出原理

　　![img](\img\12.png)

　　流是用来读写数据的，java有一个类叫File，它封装的是文件的文件名，只是内存里面的一个对象，真正的文件是在硬盘上的一块空间，在这个文件里面存放着各种各样的数据，我们想读文件里面的数据怎么办呢？是通过一个流的方式来读，咱们要想从程序读数据，对于计算机来说，无论读什么类型的数据都是以010101101010这样的形式读取的。怎么把文件里面的数据读出来呢？你可以把文件想象成一个小桶，文件就是一个桶，文件里面的数据就相当于是这个桶里面的水，那么我们怎么从这个桶里面取水呢，也就是怎么从这个文件读取数据呢。

　　常见的取水的办法是我们用一根管道插到桶上面，然后在管道的另一边打开水龙头，桶里面的水就开始哗啦哗啦地从水龙头里流出来了，桶里面的水是通过这根管道流出来的，因此这根管道就叫流，JAVA里面的流式输入/输出跟水流的原理一模一样，当你要从文件读取数据的时候，一根管道插到文件里面去，然后文件里面的数据就顺着管道流出来，这时你在管道的另一头就可以读取到从文件流出来的各种各样的数据了。当你要往文件写入数据时，也是通过一根管道，让要写入的数据通过这根管道哗啦哗啦地流进文件里面去。除了从文件去取数据以外，还可以通过网络，比如用一根管道把我和你的机子连接起来，我说一句话，通过这个管道流进你的机子里面，你马上就可以看得到，而你说一句话，通过这根管道流到我的机子里面，我也马上就可以看到。有的时候，一根管道不够用，比方说这根管道流过来的水有一些杂质，我们就可以在这个根管道的外面再包一层管道，把杂质给过滤掉。从程序的角度来讲，从计算机读取到的原始数据肯定都是010101这种形式的，一个字节一个字节地往外读，当你这样读的时候你觉得这样的方法不合适，没关系，你再在这根管道的外面再包一层比较强大的管道，这个管道可以把010101帮你转换成字符串。这样你使用程序读取数据时读到的就不再是010101这种形式的数据了，而是一些可以看得懂的字符串了。

##  二、输入输出流分类

![img](\img\13.png)

　　io包里面定义了所有的流，所以一说流指的就是io包里面的

　　什么叫输入流？什么叫输出流？用一根管道一端插进文件里程序里面，然后开始读数据，那么这是输入还是输出呢？如果站在文件的角度上，这叫输出，如果站在程序的角度上，这叫输入。

　　**记住，以后说输入流和输出流都是站在程序的角度上来说。**

## **三、节点流和处理流**

　　**![img](\img\14.png)**

 　你要是对原始的流不满意，你可以在这根管道外面再套其它的管道，套在其它管道之上的流叫处理流。为什么需要处理流呢？这就跟水流里面有杂质，你要过滤它，你可以再套一层管道过滤这些杂质一样。



### 3.1.节点流类型

　　![img](\img\15.png)

　　节点流就是一根管道直接插到数据源上面，直接读数据源里面的数据，或者是直接往数据源里面写入数据。典型的节点流是文件流：文件的字节输入流（FileInputStream），文件的字节输出流（FileOutputStream），文件的字符输入流（FileReader），文件的字符输出流（FileWriter）。

### 3.2.处理流类型 

　　![img](\img\16.png)

　　处理流是包在别的流上面的流，相当于是包到别的管道上面的管道。



##  四、InputStream(输入流)

　　![img](\img\17.png)

　　我们看到的具体的某一些管道，凡是以InputStream结尾的管道，都是以字节的形式向我们的程序输入数据。

### 4.1.InputStream的基本方法

　　![img](\img\18.png)

 　read()方法是一个字节一个字节地往外读，每读取一个字节，就处理一个字节。read(byte[] buffer)方法读取数据时，先把读取到的数据填满这个byte[]类型的数组buffer(buffer是内存里面的一块缓冲区)，然后再处理数组里面的数据。这就跟我们取水一样，先用一个桶去接，等桶接满水后再处理桶里面的水。如果是每读取一个字节就处理一个字节，这样子读取也太累了。



## 五、OutputStream(输出流)

　　![img](\img\19.png)

### 5.1.OutputStream的基本方法

　　![img](\img\20.png)

## 六、Reader流

**![img](\img\35.png)**

### 6.1.Reader的基本方法

　　![img](\img\21.png)

## 七、Writer流

　　![img](\img\22.png)

### 7.1.Writer的基本方法

　　![img](\img\23.png)

## 八、节点流讲解

　　以File(文件)这个类型作为讲解节点流的典型代表

　　![img](\img\24.png)

 **范例：使用FileInputStream流来读取FileInputStream.java文件的内容**


```
 1 package cn.galc.test;
 2 
 3 import java.io.*;
 4 
 5 public class TestFileInputStream {
 6     public static void main(String args[]) {
 7         int b = 0;// 使用变量b来装调用read()方法时返回的整数
 8         FileInputStream in = null;
 9         // 使用FileInputStream流来读取有中文的内容时，读出来的是乱码，因为使用InputStream流里面的read()方法读取内容时是一个字节一个字节地读取的，而一个汉字是占用两个字节的，所以读取出来的汉字无法正确显示。
10         // FileReader in = null;//使用FileReader流来读取内容时，中英文都可以正确显示，因为Reader流里面的read()方法是一个字符一个字符地读取的，这样每次读取出来的都是一个完整的汉字，这样就可以正确显示了。
11         try {
12             in = new FileInputStream("D:\\Java\\MyEclipse 10\\Workspaces\\AnnotationTest\\src\\cn\\galc\\test\\FileInputStream.java");
13             // in = new FileReader("D:/java/io/TestFileInputStream.java");
14         } catch (FileNotFoundException e) {
15             System.out.println("系统找不到指定文件！");
16             System.exit(-1);// 系统非正常退出
17         }
18         long num = 0;// 使用变量num来记录读取到的字符数
19         try {// 调用read()方法时会抛异常，所以需要捕获异常
20             while ((b = in.read()) != -1) {
21                 // 调用int read() throws Exception方法时，返回的是一个int类型的整数
22                 // 循环结束的条件就是返回一个值-1，表示此时已经读取到文件的末尾了。
23                 // System.out.print(b+"\t");//如果没有使用“(char)b”进行转换，那么直接打印出来的b就是数字，而不是英文和中文了
24                 System.out.print((char) b);
25                 // “char(b)”把使用数字表示的汉字和英文字母转换成字符输入
26                 num++;
27             }
28             in.close();// 关闭输入流
29             System.out.println();
30             System.out.println("总共读取了" + num + "个字节的文件");
31         } catch (IOException e1) {
32             System.out.println("文件读取错误！");
33         }
34     }
35 }
```

**范例：使用FileOutputStream流往一个文件里面写入数据**

```
 1 package cn.galc.test;
 2 
 3 import java.io.*;
 4 
 5 public class TestFileOutputStream {
 6     public static void main(String args[]) {
 7         int b = 0;
 8         FileInputStream in = null;
 9         FileOutputStream out = null;
10         try {
11             in = new FileInputStream("D:\\Java\\MyEclipse 10\\Workspaces\\AnnotationTest\\src\\cn\\galc\\test\\MyMouseAdapter.java");
12             out = new FileOutputStream("D:/java/TestFileOutputStream1.java");
13             // 指明要写入数据的文件，如果指定的路径中不存在TestFileOutputStream1.java这样的文件，则系统会自动创建一个
14             while ((b = in.read()) != -1) {
15                 out.write(b);
16                 // 调用write(int c)方法把读取到的字符全部写入到指定文件中去
17             }
18             in.close();
19             out.close();
20         } catch (FileNotFoundException e) {
21             System.out.println("文件读取失败");
22             System.exit(-1);// 非正常退出
23         } catch (IOException e1) {
24             System.out.println("文件复制失败！");
25             System.exit(-1);
26         }
27         System.out
28                 .println("TestFileInputStream.java文件里面的内容已经成功复制到文件TestFileOutStream1.java里面");
29     }
30 }
```

　　FileInputStream和FileOutputStream这两个流都是字节流，都是以一个字节为单位进行输入和输出的。所以对于占用2个字节存储空间的字符来说读取出来时就会显示成乱码。

 **范例：使用FileWriter（字符流）向指定文件中写入数据**

```
 1 package cn.galc.test;
 2 
 3 /*使用FileWriter（字符流）向指定文件中写入数据
 4 写入数据时以1个字符为单位进行写入*/
 5 import java.io.*;
 6 public class TestFileWriter{
 7     public static void main(String args[]){
 8         /*使用FileWriter输出流从程序把数据写入到Uicode.dat文件中
 9         使用FileWriter流向文件写入数据时是一个字符一个字符写入的*/
10         FileWriter fw = null;
11         try{
12                 fw = new FileWriter("D:/java/Uicode.dat");
13                 //字符的本质是一个无符号的16位整数
14                 //字符在计算机内部占用2个字节
15                 //这里使用for循环把0～60000里面的所有整数都输出
16                 //这里相当于是把全世界各个国家的文字都0～60000内的整数的形式来表示
17                 for(int c=0;c<=60000;c++){
18                     fw.write(c);
19                     //使用write(int c)把0～60000内的整数写入到指定文件内
20                     //调用write()方法时，我认为在执行的过程中应该使用了“(char)c”进行强制转换，即把整数转换成字符来显示
21                     //因为打开写入数据的文件可以看到，里面显示的数据并不是0～60000内的整数，而是不同国家的文字的表示方式
22             }
23             /*使用FileReader(字符流)读取指定文件里面的内容
24             读取内容时是以一个字符为单位进行读取的*/
25                 int b = 0;
26                 long num = 0;
27                 FileReader fr = null;
28                 fr = new FileReader("D:/java/Uicode.dat");
29                 while((b = fr.read())!= -1){
30                     System.out.print((char)b + "\t");
31                     num++;
32                 }
33                 System.out.println();
34                 System.out.println("总共读取了"+num+"个字符");
35         }catch(Exception e){
36             e.printStackTrace();
37         }
38     }
39 }
```

　　FileReader和FileWriter这两个流都是字符流，都是以一个字符为单位进行输入和输出的。所以读取和写入占用2个字节的字符时都可以正常地显示出来，以上是以File(文件)这个类型为例对节点流进行了讲解，所谓的节点流指定就是直接把输入流或输出插入到数据源上，直接往数据源里面写入数据或读取数据。

## 九、处理流讲解

### **9.1.第一种处理流——缓冲流(Buffering)**

**![img](\img\25.png)**

带有缓冲区的，缓冲区(Buffer)就是内存里面的一小块区域，读写数据时都是先把数据放到这块缓冲区域里面，减少io对硬盘的访问次数，保护我们的硬盘。可以把缓冲区想象成一个小桶，把要读写的数据想象成水，每次读取数据或者是写入数据之前，都是先把数据装到这个桶里面，装满了以后再做处理。这就是所谓的缓冲。先把数据放置到缓冲区上，等到缓冲区满了以后，再一次把缓冲区里面的数据写入到硬盘上或者读取出来，这样可以有效地减少对硬盘的访问次数，有利于保护我们的硬盘。

**缓冲流测试代码：**

```
 1 package cn.gacl.test;
 2 
 3 import java.io.*;
 4 
 5 public class TestBufferStream {
 6     public static void main(String args[]) {
 7         FileInputStream fis = null;
 8         try {
 9             fis = new FileInputStream("D:/java/TestFileInputStream.java");
10             // 在FileInputStream节点流的外面套接一层处理流BufferedInputStream
11             BufferedInputStream bis = new BufferedInputStream(fis);
12             int c = 0;
13             System.out.println((char) bis.read());
14             System.out.println((char) bis.read());
15             bis.mark(100);// 在第100个字符处做一个标记
16             for (int i = 0; i <= 10 && (c = bis.read()) != -1; i++) {
17                 System.out.print((char) c);
18             }
19             System.out.println();
20             bis.reset();// 重新回到原来标记的地方
21             for (int i = 0; i <= 10 && (c = bis.read()) != -1; i++) {
22                 System.out.print((char) c);
23             }
24             bis.close();
25         } catch (FileNotFoundException e) {
26             e.printStackTrace();
27         } catch (Exception e1) {
28             e1.printStackTrace();
29         }
30     }
31 }
```

```
 1 package cn.gacl.test;
 2 
 3 import java.io.*;
 4 public class TestBufferStream1{
 5     public static void main(String args[]){
 6         try{
 7         BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\java\\dat.txt"));
 8             //在节点流FileWriter的外面再套一层处理流BufferedWriter
 9             String s = null;
10             for(int i=0;i<100;i++){
11                 s = String.valueOf(Math.random());//“Math.random()”将会生成一系列介于0～1之间的随机数。
12                 // static String valueOf(double d)这个valueOf()方法的作用就是把一个double类型的数转换成字符串
13                 //valueOf()是一个静态方法，所以可以使用“类型.静态方法名”的形式来调用 
14                 bw.write(s);//把随机数字符串写入到指定文件中
15                 bw.newLine();//调用newLine()方法使得每写入一个随机数就换行显示
16             }
17             bw.flush();//调用flush()方法清空缓冲区
18             
19         BufferedReader br = new BufferedReader(new FileReader("D:/java/dat.txt"));
20                 //在节点流FileReader的外面再套一层处理流BufferedReader
21             while((s = br.readLine())!=null){
22                 //使用BufferedReader处理流里面提供String readLine()方法读取文件中的数据时是一行一行读取的
23                 //循环结束的条件就是使用readLine()方法读取数据返回的字符串为空值后则表示已经读取到文件的末尾了。
24                 System.out.println(s);
25                 
26             }
27         bw.close();
28         br.close();
29         }catch(Exception e){
30             e.printStackTrace();
31         }
32     }
33 }
```

**![img](\img\26.png)**

程序的输入指的是把从文件读取到的内容存储到为程序分配的内存区域里面去。流，什么是流，流无非就是两根管道，一根向里，一根向外，向里向外都是对于我们自己写的程序来说，流分为各种各样的类型，不同的分类方式又可以分为不同的类型，根据方向来分，分为输入流和输出流，根据读取数据的单位的不同，又可以分为字符流和字节流，除此之外，还可以分为节点流和处理流，节点流就是直接和数据源连接的流，处理流就是包在其它流上面的流，处理流不是直接和数据源连接，而是从数据源读取到数据以后再通过处理流处理一遍。缓冲流也包含了四个类：BufferedInputStream、BufferedOutputStream、BufferedReader和BufferedWriter。流都是成对的，没有流是是不成对的，肯定是一个in，一个out。

### 9.2.第二种处理流——转换流

**![img](\img\27.png)**

​		转换流非常的有用，它可以把一个字节流转换成一个字符流，转换流有两种，一种叫InputStreamReader，另一种叫OutputStreamWriter。InputStream是字节流，Reader是字符流，InputStreamReader就是把InputStream转换成Reader。OutputStream是字节流，Writer是字符流，OutputStreamWriter就是把OutputStream转换成Writer。把OutputStream转换成Writer之后就可以一个字符一个字符地通过管道写入数据了，而且还可以写入字符串。我们如果用一个FileOutputStream流往文件里面写东西，得要一个字节一个字节地写进去，但是如果我们在FileOutputStream流上面套上一个字符转换流，那我们就可以一个字符串一个字符串地写进去。

转换流测试代码：

```
 1 package cn.gacl.test;
 2 
 3 import java.io.*;
 4 
 5 public class TestTransform1 {
 6     public static void main(String args[]) {
 7         try {
 8             OutputStreamWriter osw = new OutputStreamWriter(
 9                     new FileOutputStream("D:/java/char.txt"));
10             osw.write("MircosoftsunIBMOracleApplet");// 把字符串写入到指定的文件中去
11             System.out.println(osw.getEncoding());// 使用getEncoding()方法取得当前系统的默认字符编码
12             osw.close();
13             osw = new OutputStreamWriter(new FileOutputStream(
14                     "D:\\java\\char.txt", true), "ISO8859_1");
15             // 如果在调用FileOutputStream的构造方法时没有加入true，那么新加入的字符串就会替换掉原来写入的字符串，在调用构造方法时指定了字符的编码
16             osw.write("MircosoftsunIBMOracleApplet");// 再次向指定的文件写入字符串，新写入的字符串加入到原来字符串的后面
17             System.out.println(osw.getEncoding());
18             osw.close();
19 
20         } catch (Exception e) {
21             e.printStackTrace();
22         }
23     }
24 }
```

![img](\img\28.png)

```
package cn.gacl.test;
 2 
 3 import java.io.*;
 4 public class TestTransform2{
 5     public static void main(String args[]){
 6         try{
 7             InputStreamReader isr = new InputStreamReader(System.in);
 8             //System.in这里的in是一个标准的输入流，用来接收从键盘输入的数据
 9             BufferedReader br = new BufferedReader(isr);
10             String s = null;
11             s = br.readLine();//使用readLine()方法把读取到的一行字符串保存到字符串变量s中去
12             while(s != null){
13                 System.out.println(s.toUpperCase());//把保存在内存s中的字符串打印出来
14                 s = br.readLine();//在循环体内继续接收从键盘的输入
15                 if(s.equalsIgnoreCase("exit")){
16                     //只要输入exit循环就结束，就会退出
17                     break;
18                 }
19             }
20         }catch(Exception e){
21             e.printStackTrace();
22         }
23     }
24 }
```

**![img](\img\29.png)**

### 9.3.第三种处理流——数据流

**![img](\img\30.png)**

数据流测试代码：

```
 1 package cn.gacl.test;
 2 
 3 import java.io.*;
 4 public class TestDataStream{
 5     public static void main(String args[]){
 6         ByteArrayOutputStream baos = new ByteArrayOutputStream();
 7         //在调用构造方法时，首先会在内存里面创建一个ByteArray字节数组
 8         DataOutputStream dos = new DataOutputStream(baos);
 9         //在输出流的外面套上一层数据流，用来处理int，double类型的数
10         try{
11             dos.writeDouble(Math.random());//把产生的随机数直接写入到字节数组ByteArray中
12             dos.writeBoolean(true);//布尔类型的数据在内存中就只占一个字节
13         ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
14             System.out.println(bais.available());
15             DataInputStream dis = new DataInputStream(bais);
16             System.out.println(dis.readDouble());//先写进去的就先读出来，调用readDouble()方法读取出写入的随机数
17             System.out.println(dis.readBoolean());//后写进去的就后读出来，这里面的读取顺序不能更改位置，否则会打印出不正确的结果
18             dos.close();
19             bais.close();
20         }catch(Exception e){
21                 e.printStackTrace();
22             }
23     }
24 }
```

​		通过bais这个流往外读取数据的时候，是一个字节一个字节地往外读取的，因此读出来的数据无法判断是字符串还是bool类型的值，因此要在它的外面再套一个流，通过dataInputStream把读出来的数据转换就可以判断了。注意了：读取数据的时候是先写进去的就先读出来，因此读ByteArray字节数组数据的顺序应该是先把占8个字节的double类型的数读出来，然后再读那个只占一个字节的boolean类型的数，因为double类型的数是先写进数组里面的，读的时候也要先读它。这就是所谓的先写的要先读。如果先读Boolean类型的那个数，那么读出来的情况可能就是把double类型数的8个字节里面的一个字节读了出来。 

### 9.4.打印流——Print

![img](\img\31.png)

```
package cn.gacl.test;
 2 
 3 /*这个小程序是重新设置打印输出的窗口，
 4  * 把默认在命令行窗口输出打印内容设置成其他指定的打印显示窗口
 5  */
 6 import java.io.*;
 7 public class TestPrintStream{
 8     public static void main(String args[]){
 9         PrintStream ps = null;
10         try{
11                 FileOutputStream fos = new FileOutputStream("D:/java/log.txt");
12                 ps = new PrintStream(fos);//在输出流的外面套接一层打印流，用来控制打印输出
13                 if(ps != null){
14                     System.setOut(ps);//这里调用setOut()方法改变了输出窗口，以前写System.out.print()默认的输出窗口就是命令行窗口.
15                     //但现在使用System.setOut(ps)将打印输出窗口改成了由ps指定的文件里面，通过这样设置以后，打印输出时都会在指定的文件内打印输出
16                     //在这里将打印输出窗口设置到了log.txt这个文件里面，所以打印出来的内容会在log.txt这个文件里面看到
17                 }
18             for(char c=0;c<=60000;c++){
19                     System.out.print(c+"\t");//把世界各国的文字打印到log.txt这个文件中去
20                 }
21         }catch(Exception e){
22             e.printStackTrace();
23         }
24     }
25 }
```

**![img](\img\32.png)**

### 9.5. 对象流——Object

![img](\img\33.png)

测试代码：

```
 1 package cn.gacl.test;
 2 
 3 import java.io.*;
 4 
 5 public class TestObjectIo {
 6     public static void main(String args[]) {
 7         T t = new T();
 8         t.k = 8;// 把k的值修改为8
 9         try {
10             FileOutputStream fos = new FileOutputStream(
11                     "D:/java/TestObjectIo.txt");
12             ObjectOutputStream oos = new ObjectOutputStream(fos);
13             // ObjectOutputStream流专门用来处理Object的，在fos流的外面套接ObjectOutputStream流就可以直接把一个Object写进去
14             oos.writeObject(t);// 直接把一个t对象写入到指定的文件里面
15             oos.flush();
16             oos.close();
17             FileInputStream fis = new FileInputStream(
18                     "D:/java/TestObjectIo.txt");
19             ObjectInputStream ois = new ObjectInputStream(fis);
20             // ObjectInputStream专门用来读一个Object的
21             T tRead = (T) ois.readObject();
22             // 直接把文件里面的内容全部读取出来然后分解成一个Object对象，并使用强制转换成指定类型T
23             System.out.print(tRead.i + "\t" + tRead.j + "\t" + tRead.d + "\t"
24                     + tRead.k);
25             ois.close();
26         } catch (Exception e) {
27             e.printStackTrace();
28         }
29     }
30 }
31 
32 /*
33  * 凡是要将一个类的对象序列化成一个字节流就必须实现Serializable接口
34  * Serializable接口中没有定义方法，Serializable接口是一个标记性接口，用来给类作标记，只是起到一个标记作用。
35  * 这个标记是给编译器看的，编译器看到这个标记之后就可以知道这个类可以被序列化 如果想把某个类的对象序列化，就必须得实现Serializable接口
36  */
37 class T implements Serializable {
38     // Serializable的意思是可以被序列化的
39     int i = 10;
40     int j = 9;
41     double d = 2.3;
42     int k = 15;
43     // transient int k = 15;
44     // 在声明变量时如果加上transient关键字，那么这个变量就会被当作是透明的，即不存在。
45 }
```

​		直接实现Serializable接口的类是JDK自动把这个类的对象序列化，而如果实现public interface Externalizable extends Serializable的类则可以自己控制对象的序列化，建议能让JDK自己控制序列化的就不要让自己去控制。

## 十、IO流总结

![img](\img\34.png)