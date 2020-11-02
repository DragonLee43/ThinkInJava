## 一、什么是HTTP协议

　　HTTP是hypertext transfer protocol（超文本传输协议）的简写，它是TCP/IP协议的一个应用层协议，用于定义WEB浏览器与WEB服务器之间交换数据的过程。客户端连上web服务器后，若想获得web服务器中的某个web资源，需遵守一定的通讯格式，HTTP协议用于定义客户端与web服务器通迅的格式。

## 二、HTTP协议的版本

　　HTTP协议的版本：HTTP/1.0、HTTP/1.1

## 三、HTTP1.0和HTTP1.1的区别

　　在HTTP1.0协议中，客户端与web服务器建立连接后，只能获得一个web资源。
　　在HTTP1.1协议，允许客户端与web服务器建立连接后，在一个连接上获取多个web资源。

## 四、HTTP请求

### 4.1、HTTP请求包括的内容

　　**客户端连上服务器后，向服务器请求某个web资源，称之为客户端向服务器发送了一个HTTP请求**。

一个完整的HTTP请求包括如下内容：**一个请求行、若干消息头、以及实体内容**
范例：

　　**![img](\img\36.png)**

### 4.2、HTTP请求的细节——请求行

　　请求行中的GET称之为请求方式，请求方式有：POST、GET、HEAD、OPTIONS、DELETE、TRACE、PUT，常用的有： GET、 POST
　　用户如果没有设置，默认情况下浏览器向服务器发送的都是get请求，例如在浏览器直接输地址访问，点超链接访问等都是get，用户如想把请求方式改为post，可通过更改表单的提交方式实现。
　　不管POST或GET，都用于向服务器请求某个WEB资源，这两种方式的区别主要表现在数据传递上：如果请求方式为GET方式，则可以在请求的URL地址后以?的形式带上交给服务器的数据，多个数据之间以&进行分隔，例如：GET /mail/1.html?name=abc&password=xyz HTTP/1.1
　　GET方式的特点：在URL地址后附带的参数是有限制的，其数据容量通常不能超过1K。
　　如果请求方式为POST方式，则可以在请求的实体内容中向服务器发送数据，Post方式的特点：传送的数据量无限制。

### 4.3、HTTP请求的细节——消息头

　　HTTP请求中的常用消息头

　　accept:浏览器通过这个头告诉服务器，它所支持的数据类型
　　Accept-Charset: 浏览器通过这个头告诉服务器，它支持哪种字符集
　　Accept-Encoding：浏览器通过这个头告诉服务器，支持的压缩格式
　　Accept-Language：浏览器通过这个头告诉服务器，它的语言环境
　　Host：浏览器通过这个头告诉服务器，想访问哪台主机
　　If-Modified-Since: 浏览器通过这个头告诉服务器，缓存数据的时间
　　Referer：浏览器通过这个头告诉服务器，客户机是哪个页面来的 防盗链
　　Connection：浏览器通过这个头告诉服务器，请求完后是断开链接还是何持链接

例如：

```
1 Accept: application/x-ms-application, image/jpeg, application/xaml+xml, image/gif, image/pjpeg, 
2     application/x-ms-xbap, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*
3 Referer: http://localhost:8080/JavaWebDemoProject/Web/2.jsp
4 Accept-Language: zh-CN
5 User-Agent: Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E; InfoPath.3)
6 Accept-Encoding: gzip, deflate
7 Host: localhost:8080
8 Connection: Keep-Alive
```

## 五、HTTP响应

### 5.1、HTTP响应包括的内容

　　**一个HTTP响应代表服务器向客户端回送的数据**，它包括： 一个状态行、若干消息头、以及实体内容 。

　　![img](\img\37.png)
范例：

```java
 1 HTTP/1.1 200 OK
 2 Server: Apache-Coyote/1.1
 3 Content-Type: text/html;charset=ISO-8859-1
 4 Content-Length: 105
 5 Date: Tue, 27 May 2014 16:23:28 GMT
 6 
 7 <html>
 8     <head>
 9         <title>Hello World JSP</title>
10     </head>
11     <body>
12         Hello World!
13 
14     </body>
15 </html>
```

### 5.2、HTTP响应的细节——状态行

　  状态行格式： **HTTP版本号　状态码　原因叙述<CRLF>**
   举例：HTTP/1.1 200 OK
　　状态码用于表示服务器对请求的处理结果，它是一个三位的十进制数。响应状态码分为5类，如下所示：
　　**![img](\img\38.png)**

### 5.3、HTTP响应细节——常用响应头

　　HTTP响应中的常用响应头(消息头)
　　Location: 服务器通过这个头，来告诉浏览器跳到哪里
　　Server：服务器通过这个头，告诉浏览器服务器的型号
　　Content-Encoding：服务器通过这个头，告诉浏览器，数据的压缩格式
　　Content-Length: 服务器通过这个头，告诉浏览器回送数据的长度
　　Content-Language: 服务器通过这个头，告诉浏览器语言环境
　　Content-Type：服务器通过这个头，告诉浏览器回送数据的类型
　　Refresh：服务器通过这个头，告诉浏览器定时刷新
　　Content-Disposition: 服务器通过这个头，告诉浏览器以下载方式打数据
　　Transfer-Encoding：服务器通过这个头，告诉浏览器数据是以分块方式回送的
　　Expires: -1 控制浏览器不要缓存
　　Cache-Control: no-cache  
　　Pragma: no-cache

## 六、在服务端设置响应头来控制客户端浏览器的行为

### 6.1、设置Location响应头，实现请求重定向

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```java
 1 package gacl.http.study;
 2 import java.io.IOException;
 3 import javax.servlet.ServletException;
 4 import javax.servlet.http.HttpServlet;
 5 import javax.servlet.http.HttpServletRequest;
 6 import javax.servlet.http.HttpServletResponse;
 7 /**
 8  * @author gacl
 9  *
10  */
11 public class ServletDemo01 extends HttpServlet {
12     public void doGet(HttpServletRequest request, HttpServletResponse response)
13             throws ServletException, IOException {
14 
15         response.setStatus(302);//设置服务器的响应状态码
16         /**
17          *设置响应头，服务器通过 Location这个头，来告诉浏览器跳到哪里，这就是所谓的请求重定向
18          */
19         response.setHeader("Location", "/JavaWeb_HttpProtocol_Study_20140528/1.jsp");
20     }
21     public void doPost(HttpServletRequest request, HttpServletResponse response)
22             throws ServletException, IOException {
23         this.doGet(request, response);
24     }
25 }
```

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

　　当在浏览器中使用URL地址"http://localhost:8080/JavaWeb_HttpProtocol_Study_20140528/servlet/ServletDemo01"访问ServletDemo01时，就可以看到服务器作出响应后发送到浏览器的状态码和响应头信息，如下图所示：

　　![img](\img\39.png)

　　服务器返回一个302状态码告诉浏览器，你要的资源我没有，但是我通过Location响应头告诉你哪里有，而浏览器解析响应头Location后知道要跳转到/JavaWeb_HttpProtocol_Study_20140528/1.jsp页面，所以就会自动跳转到1.jsp，如下图所示：

　　![img](\img\40.png)

### 6.2、设置Content-Encoding响应头，告诉浏览器数据的压缩格式

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```java
 1 package gacl.http.study;
 2 
 3 import java.io.ByteArrayOutputStream;
 4 import java.io.IOException;
 5 import java.util.zip.GZIPOutputStream;
 6 import javax.servlet.ServletException;
 7 import javax.servlet.http.HttpServlet;
 8 import javax.servlet.http.HttpServletRequest;
 9 import javax.servlet.http.HttpServletResponse;
10 /**
11  * @author gacl
12  *这个小程序是用来演示以下两个小知识点
13  *1、使用GZIPOutputStream流来压缩数据
14  *2、设置响应头Content-Encoding来告诉浏览器，服务器发送回来的数据压缩后的格式
15  */
16 public class ServletDemo02 extends HttpServlet {
17 
18     public void doGet(HttpServletRequest request, HttpServletResponse response)
19             throws ServletException, IOException {
20         String data = "abcdabcdabcdabcdabcdabcdab" +
21                 "cdabcdabcdabcdabcdabcdabcdabcdabc" +
22                 "dabcdabcdabcdabcdabcdabcdabcdabc" +
23                 "dabcdabcdabcdabcdabcdabcdabcdabcdab" +
24                 "cdabcdabcdabcdabcdabcdabcdabcdabcdab" +
25                 "cdabcdabcdabcdabcdabcdabcdabcdabcdab" +
26                 "cdabcdabcdabcdabcdabcdabcdabcdabcdab" +
27                 "cdabcdabcdabcdabcdabcdabcdabcdabcdabcd";
28         System.out.println("原始数据的大小为：" + data.getBytes().length);
29         
30         ByteArrayOutputStream bout = new ByteArrayOutputStream();
31         GZIPOutputStream gout = new GZIPOutputStream(bout); //buffer
32         gout.write(data.getBytes());
33         gout.close();
34         //得到压缩后的数据
35         byte g[] = bout.toByteArray();
36         response.setHeader("Content-Encoding", "gzip");
37         response.setHeader("Content-Length",g.length +"");
38         response.getOutputStream().write(g);
39     }
40 
41     public void doPost(HttpServletRequest request, HttpServletResponse response)
42             throws ServletException, IOException {
43         this.doGet(request, response);
44     }
45 }
```

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

服务器发给浏览器的响应信息如下：

![img](\img\41.png)

### 6.3、设置content-type响应头，指定回送数据类型

测试内容：ServletDemo03

```java
 1 package gacl.http.study;
 2 import java.io.IOException;
 3 import java.io.InputStream;
 4 import java.io.OutputStream;
 5 import javax.servlet.ServletException;
 6 import javax.servlet.http.HttpServlet;
 7 import javax.servlet.http.HttpServletRequest;
 8 import javax.servlet.http.HttpServletResponse;
 9 public class ServletDemo03 extends HttpServlet {
10     public void doGet(HttpServletRequest request, HttpServletResponse response)
11             throws ServletException, IOException {
12         /**
13          * 浏览器能接收(Accept)的数据类型有: 
14          * application/x-ms-application, 
15          * image/jpeg, 
16          * application/xaml+xml, 
17          * image/gif, 
18          * image/pjpeg, 
19          * application/x-ms-xbap, 
20          * application/vnd.ms-excel, 
21          * application/vnd.ms-powerpoint, 
22          * application/msword, 
23          */
24         response.setHeader("content-type", "image/jpeg");//使用content-type响应头指定发送给浏览器的数据类型为"image/jpeg"
25         //读取位于项目根目录下的img文件夹里面的WP_20131005_002.jpg这张图片，返回一个输入流
26         InputStream in = this.getServletContext().getResourceAsStream("/img/WP_20131005_002.jpg");
27         byte buffer[] = new byte[1024];
28         int len = 0;
29         OutputStream out = response.getOutputStream();//得到输出流
30         while ((len = in.read(buffer)) > 0) {
			   //读取输入流(in)里面的内容存储到缓冲区(buffer)
31             out.write(buffer, 0, len);//将缓冲区里面的内容输出到浏览器
32         }
33     }
34     public void doPost(HttpServletRequest request, HttpServletResponse response)
35             throws ServletException, IOException {
36         this.doGet(request, response);
37     }
38 }
```

服务器发给浏览器的响应信息如下：

![img](\img\42.png)

ServletDemo03的运行结果如下图所示：

![img](\img\43.png)

在浏览器中显示出了图片

### 6.4、设置refresh响应头，让浏览器定时刷新

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```java
 1 package gacl.http.study;
 2 
 3 import java.io.IOException;
 4 import javax.servlet.ServletException;
 5 import javax.servlet.http.HttpServlet;
 6 import javax.servlet.http.HttpServletRequest;
 7 import javax.servlet.http.HttpServletResponse;
 8 
 9 public class ServletDemo04 extends HttpServlet {
10     public void doGet(HttpServletRequest request, HttpServletResponse response)
11             throws ServletException, IOException {
12         /**
13          * 设置refresh响应头，让浏览器每隔3秒定时刷新
14          */
15         // response.setHeader("refresh", "3");
16         /**
17          * 设置refresh响应头，让浏览器3秒后跳转到http://www.baidu.com
18          */
19         response.setHeader("refresh", "3;url='http://www.baidu.com'");
20         response.getWriter().write("gacl");
21     }
22 
23     public void doPost(HttpServletRequest request, HttpServletResponse response)
24             throws ServletException, IOException {
25         this.doGet(request, response);
26     }
27 
28 }
```

### 6.5、设置content-disposition响应头，让浏览器下载文件

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```java
 1 package gacl.http.study;
 2 
 3 import java.io.IOException;
 4 import java.io.InputStream;
 5 import java.io.OutputStream;
 6 
 7 import javax.servlet.ServletException;
 8 import javax.servlet.http.HttpServlet;
 9 import javax.servlet.http.HttpServletRequest;
10 import javax.servlet.http.HttpServletResponse;
11 
12 public class ServletDemo05 extends HttpServlet {
13     public void doGet(HttpServletRequest request, HttpServletResponse response)
14             throws ServletException, IOException {
15         /**
16          * 设置content-disposition响应头，让浏览器下载文件
17          */
18         response.setHeader("content-disposition", "attachment;filename=xxx.jpg");
19         InputStream in = this.getServletContext().getResourceAsStream("/img/1.jpg");
20         byte buffer[] = new byte[1024];
21         int len = 0;
22         OutputStream out = response.getOutputStream();
23         while ((len = in.read(buffer)) > 0) {
24             out.write(buffer, 0, len);
25         }
26     }
27 
28     public void doPost(HttpServletRequest request, HttpServletResponse response)
29             throws ServletException, IOException {
30         this.doGet(request, response);
31     }
32 
33 }
```

在浏览器中访问ServletDemo05就会弹出文件下载框，如下图所示：

　　![img](\img\44.png)