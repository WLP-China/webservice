# 1. WebService 简介
Web Service 也叫 XML Web Service WebService 是一种可以接收从 Internet 上的其它系统中传递过来的请求，轻量级的独立的通讯技术。是通过 SOAP 在 Web 上提供的软件服务，使用 WSDL 文件进行说明，并通过 UDDI 进行注册。WebService 是一种跨编程语言和跨操作系统平台的远程调用技术。

## 1.1 使用场景
1. 跨平台调用
2. 跨语言调用
3. 远程调用

解决企业内部异构系统的整合问题  
解决一些公共资源的复用问题

## 1.2 JAVA 三种WebService规范
1. JAX-WS(Java API for XML-Based Webservices)  
早期的基于SOAP的JAVA的Web服务规范JAX-RPC(Java API For XML-Remote Procedure Call)目前已经被JAX-WS规范取代，JAX-WS是JAX-RPC的演进版本，但JAX-WS并不完全向后兼容JAX-RPC。
JAX-WS（JSR 224）规范的API位于javax.xml.ws.*包，提供API操作Web服务（通常在客户端使用的较多，由于客户端可以借助SDK生成，因此这个包中的API我们较少会直接使用）。WS-MetaData（JSR 181）是JAX-WS的依赖规范，其API位于javax.jws.*包，使用注解配置公开的Web服务的相关信息和配置SOAP消息的相关信息。

2. JAXM&SAAJ：
JAXM（JAVA API For XML Message）主要定义了包含了发送和接收消息所需的API，相当于Web 服务的服务器端，其API 位于javax.messaging.*包。SAAJ（SOAP With Attachment API For Java，JSR 67）是与JAXM搭配使用的API，为构建SOAP包和解析SOAP包提供了重要的支持，支持附件传输等.其API 位于javax.xml.soap.*包
JAXM&SAAJ与JAX-WS都是基于SOAP的Web服务，相比之下JAXM&SAAJ暴漏了SOAP更多的底层细节，编码比较麻烦，而JAX-WS更加抽象，隐藏了更多的细节，更加面向对象，实现起来你基本上不需要关心SOAP的任何细节。那么如果你想控制SOAP消息的更多细节，可以使用JAXM&SAAJ

3. JAX-RS
JAVA针对REST(Representation State Transfer)风格制定的一套Web服务规范.

# 2. WebService三要素
## 2.1 SOAP协议
1. SOAP（Simple Object Access Protocal，简单对象访问协议）是一种网络通信协议。
2. SOAP协议定义了SOAP消息的格式，SOAP协议是基于HTTP协议的，XML是SOAP的数据编码方式。
3. SOAP = 在HTTP的基础上 + XML数据（SOAP作为一个基于XML语言的协议用于网上传输数据）
4. SOAP 允许您跨越防火墙

WebService通过HTTP协议发送请求和接收结果时，发送的请求内容和结果内容都采用XML格式封装，并增加了一些特定的HTTP消息头，以说明HTTP消息的内容格式，这些特定的HTTP消息头和XML内容格式就是SOAP协议。SOAP提供了标准的RPC(远程调用技术）方法来调用WebService。

## 2.2 WSDL说明书
WSDL(WebService Definition Language Web服务描述语言)即用机器能够阅读的方式提供一个正式描述文档而基于XMl的语言。用于描述WebService的服务地址以及WebService的服务接口、参数、返回值。应为是基于XML的，所以WSDL既是机器可阅读的，又是人可阅读的

## 2.3 UDDI
UDDIUDDI 的目的是为电子商务建立标准；UDDI是一套基于Web的、分布式的、为Web Service提供的、信息注册中心的实现标准规范，同时也包含一组使企业能将自身提供的Web Service注册，以使别的企业能够发现的访问协议的实现标准。简单说，就是一套规则，方便使用；

1.UDDI是一个跨产业、跨平台的开放性技术，可以帮助Web服务提供商在互联网上发布web服务  
2.UDDI是一种目录服务，企业可以通过UDDI来注册和搜索Web服务(简单说，UDDI就是一个目录，其中存放的是一些Web服务信息)




# 3. wsimport命令
wsimport就是jdk（1.6版本之后）提供的的一个工具，他的作用就是根据WSDL地址生成客户端代码；位置再JAVA_HOME/bin  

>wsimport常用的参数：  
* -s，生成java文件  
* -d，生成class文件，默认的参数  
* -p，指定包名的，如果不加该参数，默认包名就是wsdl文档中的命名空间的倒序;
```
例:
远程地址方式:
E:\IdeaProjects\my\webservice\jaxws\src\main\java>wsimport -s . -p com.ifun.wsdl.mobilecode http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl
xml文件方式:
E:\IdeaProjects\my\webservice\jaxws\src\main\java\com\ifun\wsdl>wsimport -s . -p com.ifun.wsdl.weather E:\IdeaProjects\my\webservice\jaxws\src\main\java\com\ifun\wsdl\WeatherWS.wsdl

注:
如果wsdl中有如下标签导致解析失败(可能是因为此服务是.NET开发的)
<s:element ref="s:schema" /><s:any />
改为
<s:any minOccurs="2" maxOccurs="2" />
```

# 4. JWS主要注解
>@WebService
 
1. serviceName： 对外发布的服务名，指定 Web Service 的服务名称：wsdl:service。缺省值为 Java 类的简单名称 + Service。（字符串） 
2. endpointInterface： 服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口 
3. name：此属性的值包含XML Web Service的名称。在默认情况下，该值是实现XML Web Service的类的名称，wsdl:portType 的名称。缺省值为 Java 类或接口的非限定名称。（字符串 
4. portName： wsdl:portName。缺省值为 WebService.name+Port。 
5. targetNamespace：指定你想要的名称空间，默认是使用接口实现类的包名的反缀 
6. wsdlLocation：指定用于定义 Web Service 的 WSDL 文档的 Web 地址。Web 地址可以是相对路径或绝对路径。（字符串）

注意：实现类上可以不添加Webservice注解

>@WebMethod

注释表示作为一项 Web Service 操作的方法，将此注释应用于客户机或服务器服务端点接口（SEI）上的方法，或者应用于 JavaBeans 端点的服务器端点实现类。 
要点： 仅支持在使用 @WebService 注释来注释的类上使用 @WebMethod 注释 
1. operationName：指定与此方法相匹配的wsdl:operation 的名称。缺省值为 Java 方法的名称。（字符串） 
2. action：定义此操作的行为。对于 SOAP 绑定，此值将确定 SOAPAction 头的值。缺省值为 Java 方法的名称。（字符串） 
3. exclude：指定是否从 Web Service 中排除某一方法。缺省值为 false。（布尔值） 。

> @WebParam 

注释用于定制从单个参数至 Web Service 消息部件和 XML 元素的映射。 
将此注释应用于客户机或服务器服务端点接口（SEI）上的方法，或者应用于 JavaBeans 端点的服务器端点实现类。 
1. name ：参数的名称。如果操作是远程过程调用（RPC）类型并且未指定partName 属性，那么这是用于表示参数的 wsdl:part 属性的名称。   
如果操作是文档类型或者参数映射至某个头，那么 -name 是用于表示该参数的 XML 元素的局部名称。如果操作是文档类型,参数类型为 BARE 并且方式为 OUT 或 INOUT，那么必须指定此属性。（字符串） 
2. partName：定义用于表示此参数的 wsdl:part属性的名称。仅当操作类型为 RPC 或者操作是文档类型并且参数类型为BARE 时才使用此参数。（字符串） 
3. targetNamespace：指定参数的 XML 元素的 XML 名称空间。当属性映射至 XML 元素时，仅应用于文档绑定。缺省值为 Web Service 的 targetNamespace。（字符串） 
4. mode：此值表示此方法的参数流的方向。有效值为 IN、INOUT 和 OUT。（字符串） 
5. header：指定参数是在消息头还是消息体中。缺省值为 false。（布尔值）

>@WebResult
 
注释用于定制从返回值至 WSDL 部件或 XML 元素的映射。将此注释应用于客户机或服务器服务端点接口（SEI）上的方法，或者应用于 JavaBeans 端点的服务器端点实现类。 
1. name：当返回值列示在 WSDL 文件中并且在连接上的消息中找到该返回值时，指定该返回值的名称。对于 RPC 绑定，这是用于表示返回值的 wsdl:part属性的名称。对于文档绑定，-name参数是用于表示返回值的 XML 元素的局部名。对于 RPC 和 DOCUMENT/WRAPPED 绑定，缺省值为 return。对于 DOCUMENT/BARE 绑定，缺省值为方法名 + Response。（字符串） 
2. targetNamespace：指定返回值的 XML 名称空间。仅当操作类型为 RPC 或者操作是文档类型并且参数类型为 BARE 时才使用此参数。（字符串） 
3. header：指定头中是否附带结果。缺省值为false。（布尔值） 
4. partName：指定 RPC 或 DOCUMENT/BARE 操作的结果的部件名称。缺省值为@WebResult.name。（字符串）

> @HandlerChain
 
注释用于使 Web Service 与外部定义的处理程序链相关联。只能通过对 SEI 或实现类使用 @HandlerChain 注释来配置服务器端的处理程序。 
但是可以使用多种方法来配置客户端的处理程序。可以通过对生成的服务类或者 SEI 使用 @HandlerChain 注释来配置客户端的处理程序。此外，可以按程序在服务上注册您自己的 HandlerResolver 接口实现，或者按程序在绑定对象上设置处理程序链。 
1. file：指定处理程序链文件所在的位置。文件位置可以是采用外部格式的绝对 java.net.URL，也可以是类文件中的相对路径。（字符串） 
2. name：指定配置文件中处理程序链的名称。