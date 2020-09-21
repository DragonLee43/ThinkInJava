### 一.  java校验--javax.validation

​	javax.validation是jsr303规范。它定义了很多常用的**校验注解**，可以直接将这些注解加在我们的JavaBean的属性上(面向注解编程)

注解说明：

｀｀｀

```dart
1.@NotNull：不能为null，但可以为empty(""," ","   ")      
2.@NotEmpty：不能为null，而且长度必须大于0 (" ","  ")
3.@NotBlank：只能作用在String上，不能为null，而且调用trim()后，长度必须大于0("test")    即：必须有实际字符
```

　

| 注解                                         |                         作用数据类型                         |                                                         说明 |
| -------------------------------------------- | :----------------------------------------------------------: | -----------------------------------------------------------: |
| @AssertFalse                                 |                       Boolean,boolean                        |                                      验证注解的元素值是false |
| @AssertTrue                                  |                       Boolean,boolean                        |                                       验证注解的元素值是true |
| @NotNull                                     |                           任意类型                           |                                     验证注解的元素值不是null |
| @Null                                        |                           任意类型                           |                                       验证注解的元素值是null |
| @Min(value=值)                               | BigDecimal，BigInteger, byte,short, int, long，等任何Number或CharSequence（存储的是数字）子类型 |                    验证注解的元素值大于等于@Min指定的value值 |
| @Max（value=值）                             |                        和@Min要求一样                        |                    验证注解的元素值小于等于@Max指定的value值 |
| @DecimalMin(value=值)                        |                        和@Min要求一样                        |            验证注解的元素值大于等于@ DecimalMin指定的value值 |
| @DecimalMax(value=值)                        |                        和@Min要求一样                        |            验证注解的元素值小于等于@ DecimalMax指定的value值 |
| @Digits(integer=整数位数, fraction=小数位数) |                        和@Min要求一样                        |                     验证注解的元素值的整数位数和小数位数上限 |
| @Size(min=下限, max=上限)                    |               字符串、Collection、Map、数组等                | 验证注解的元素值的在min和max（包含）指定区间之内，如字符长度、集合大小 |
| @Past                                        |  java.util.Date,java.util.Calendar;Joda Time类库的日期类型   |                     验证注解的元素值（日期类型）比当前时间早 |
| @Future                                      |                       与@Past要求一样                        |                     验证注解的元素值（日期类型）比当前时间晚 |
| @NotBlank                                    |                      CharSequence子类型                      | 验证注解的元素值不为空（不为null、去除首位空格后长度为0），不同于@NotEmpty，@NotBlank只应用于字符串且在比较时会去除字符串的首位空格 |
| @Length(min=下限, max=上限)                  |                      CharSequence子类型                      |                         验证注解的元素值长度在min和max区间内 |
| @NotEmpty                                    |          CharSequence子类型、Collection、Map、数组           | 验证注解的元素值不为null且不为空（字符串长度不为0、集合大小不为0） |
| @Range(min=最小值, max=最大值)               | BigDecimal,BigInteger,CharSequence, byte, short, int, long等原子类型和包装类型 |                         验证注解的元素值在最小值和最大值之间 |
| @Email(regexp=正则表达式,flag=标志的模式)    |                CharSequence子类型（如String）                | 验证注解的元素值是Email，也可以通过regexp和flag指定自定义的email格式 |
| @Pattern(regexp=正则表达式,flag=标志的模式)  |               String，任何CharSequence的子类型               |                       验证注解的元素值与指定的正则表达式匹配 |
| @Valid                                       |                        任何非原子类型                        | 指定递归验证关联的对象如用户对象中有个地址对象属性，如果想在验证用户对象时一起验证地址对象的话，在地址对象上加@Valid注解即可级联验证 |
|                                              |                                                              |                                                              |

```java
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /*** 用户ID*/
    @NotNull(message = "用户id不能为空")
    private Long userId;

    /** 用户名*/
    @NotBlank(message = "用户名不能为空")
    @Length(max = 20, message = "用户名不能超过20个字符")
    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9\\*]*$", message = "用户昵称限制：最多20字符，包含文字、字母和数字")
    private String username;

    /** 手机号*/
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String mobile;

    /**性别*/
    private String sex;

    /** 邮箱*/
    @NotBlank(message = "联系邮箱不能为空")
    @Email(message = "邮箱格式不对")
    private String email;

    /** 密码*/
    private String password;

    /*** 创建时间 */
    @Future(message = "时间必须是将来时间")
    private Date createTime;

}
```

```java
// 在Controller的接口方法上通常会加@Valid注解，让Spring自己去校验对象中的属性。
// 在DfsRegisterCommitParam类中的属性上加了校验注解，Spring根据校验注解去校验属性
public DfsRegisterCommitView registerCommit(@Valid DfsRegisterCommitParam param)
```



-----



### 二、自定义Exception

 1. 自定义Exception要继承异常超类 Exception。 

 2. 一般情况下，自定义Exception中有 code(错误码)，错误msg。

    以BusinessException类为例。(业务异常)

    ```java
    public class BusinessException extends Exception{
        private static final long serialVersionUID = 7681137711192904911L;
        
        private long code;
    	private TypeEnum type;
        // 构造方法
        private BusinessException(TypeEnum type, long code, String msg, Throwable cause) {
            // 调用Exception中的构造方法
    		super(msg, cause);
    		this.type = type;// 错误类型
    		this.code = code;// 错误码
    	}
        // 属性的getter、setter方法
        public long getCode() {
    		return code;
    	}
    
    	public TypeEnum getType() {
    		return type;
    	}
        
        // 业务异常方法
        public static BusinessException notExpected(long code, String msg, Throwable cause) {
    		return new BusinessException(TypeEnum.NotExpected, code, msg, cause);
    	}
        
        // 静态内部类，异常类型
        public static enum TypeEnum{
    		NotExpected,// 非预期
    		InternalError,// 内部错误
    		Forbidden,// 禁止
    		NotFound // 未找到异常
    	}
    }
    ```

项目中的回滚异常类层级结构：

 		![blockchain](\img\rollback1.png)

项目中自定义回滚异常继承了父类MacawRuntimeException，而MacawRuntimeException又继承了运行时异常RuntimeException。这样的好处是便于后期项目代码扩展。代码如下

```java
/**MacawRuntimeException*/
public class MacawRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 3452831933237754055L;

	public MacawRuntimeException() {
        super();
    }

	public MacawRuntimeException(String message, Throwable cause) {super(message, cause);}

	public MacawRuntimeException(String message) {super(message);}
	public MacawRuntimeException(String formatString, Object... args) {super(String.format(formatString, args));
	}
	public MacawRuntimeException(Throwable cause) {super(cause);}	
}




/**MTransactionRollbackException*/

public class MTransactionRollbackException extends MacawRuntimeException {
	private static final long serialVersionUID = 1094393715679278731L;
	public MTransactionRollbackException() {
		super();
	}
	public MTransactionRollbackException(String message, Throwable cause) {super(message, cause);}

	public MTransactionRollbackException(String message) {super(message);}
	public MTransactionRollbackException(String formatString, Object... args) {super(String.format(formatString, args));}
	public MTransactionRollbackException(Throwable cause) {super(cause);}
}

```

