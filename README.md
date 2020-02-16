## 要求
1. 使用hsqldb数据库，用已定义的dbStart启动数据库。
1. 不要在build.gradle中增加无关的库，特别是用不到的数据库驱动之类的库。
1. 使用gretty插件的appRun运行，在jsp或java文件改变后可以自动重新部署。

## 提交记录

```properties
设置上传文件功能，并设置只能够是图片上传 TabEsc 2019/4/27 10:49
设置一个用来登陆的界面，修改StuDAO接口实现此功能，成功后可以添加电影信息，查看所有电影信息，查看某个电影详细信息 TabEsc 2019/4/27 10:41
定义所需action，对IOException配置全局异常处理，并实现在保存成功后3秒内跳转信息 TabEsc 2019/4/27 9:57
实现增加新电影的功能，如果成功的话，显示成功页面及插入的信息，暂不考虑图片上传的问题 TabEsc 2019/4/27 9:35
实现在表格后超链接的功能，点击可以显示此电影的详细信息 TabEsc 2019/4/27 9:23
注册成功后，显示所有电影信息，并附上超链接以便实现之后的功能 TabEsc 2019/4/27 9:09
构建一个movie实体类，并且设计一个连接池使用db.properties内的数据 TabEsc 2019/4/27 8:48
 实现注册功能，可以将信息保存于数据库 TabEsc 2019/4/27 8:37
设置国际化显示错误信息，修改validation实现此功能 TabEsc 2019/4/27 7:56
设置页面，输入帐号密码进行验证，密码输入两次 TabEsc 2019/4/27 7:32
```

## 第一题



### index.jsp

```jsp
<s:form action="CheckAction" >
    <s:textfield name="username" label="账号"/>
    <s:textfield name="password" label="密码"/>
    <s:textfield name="reapeat" label="重复密码"/>
    <s:submit/>
</s:form>
```

## 第二题

### control/CheckAction-validation.xml

```xml
 <field name="username">
        <field-validator type="requiredstring">
            <param name="trim">true</param>
            <message key="UsernameError"/>
        </field-validator>
    </field>

    <field name="password">
        <field-validator type="stringlength">
            <param name="minLength">6</param>
            <message key="PasswordError"/>
        </field-validator>
    </field>
    
    <field name="reapeat">
    <field-validator type="fieldexpression">
        <param name="expression">reapeat.equals(password)</param>
        <message key="reapeat"/>
    </field-validator>
    </field>
```

### control/CheckAction.java

``` java
 	public class CheckAction extends ActionSupport {
    private String username;
    private String password;
    private String reapeat;
    }
```

### struts.xml

```xml
<package name="hzw" extends="struts-default">
<action name="CheckAction" class="control.CheckAction">
        <result>/SetupSuc.jsp</result>
        <result name="input">/index.jsp</result>
</action>
</package>
```

### SetupSuc.jsp

```jsp
注册成功
```

### msg_en_US.properties

```properties
UsernameError=The username is Null!
PasswordError=The password is more than 6!
reapeat=Two inconsistencies in the password!
```

### msg_zh_CN.properties

```properties
UsernameError=用户名不能为空！
PasswordError=密码长度最低为6！
reapeat=两次输入的密码不一致！
```

## 第三题

### control/CheckAction.java

```java
public class CheckAction extends ActionSupport {
    private String username;
    private String password;
    private String reapeat;
     public String execute() throws Exception {
        StuDAO stu = new StuDAOImp();
        int flags = stu.add(username,password);
        if(flags!=0) {
            addFieldError("username","Add Error" );
            return "input";
        }
        else
            return SUCCESS;
    }
}

```

### index.jsp

```jsp
<s:form action="CheckAction" >
    <s:textfield name="username" label="账号"/>
    <s:textfield name="password" label="密码"/>
    <s:textfield name="reapeat" label="重复密码"/>
    <s:submit/>
</s:form>
```

### struts.xml

```xml
<action name="CheckAction" class="control.CheckAction">
            <result>/SetupSuc.jsp</result>
            <result name="input">/index.jsp</result>
        </action>
```

### dao/StuDAO.java

```java
public interface StuDAO {
    int add(String username,String password) throws Exception;
    }
```

### dao/StuDAOImp.java

```java
connect db = new connect();
Connection con=db.getConnection();
public class StuDAOImp implements StuDAO {
 public int add(String username,String password) throws Exception {

        int flags = 0;


        String sqladd = "insert into USERTABLE VALUES(?,?)";
        try {
    
            PreparedStatement pres = con.prepareStatement(sqladd);
            pres.setString(1, username);
            pres.setString(2, password);
            pres.execute();
            flags = pres.executeUpdate(sqladd);
    
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception");
        }
        return flags;
    }
}
```

### conn/connect.java

```java
public class connect {
    private static String dirver;
    private static String url;
    private static String username;
    private static String password;

    static{
        try {
    
            InputStream inputStream = connect.class.getClassLoader()
                    .getResourceAsStream("db.properties");
            Properties properties = new Properties();
    
            properties.load(inputStream);
    
            dirver = properties.getProperty("db.driver");
            url = properties.getProperty("db.url");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");
    
            Class.forName(dirver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    
    }


    public static Connection getConnection() {
        Connection conn=null;
        try {
            conn=DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    public static void main(String[] args) {
        connect.getConnection();
    }
}
```

## 第四题

### dao/StuDAO.java

```java
public interface StuDAO {
    int add(String username,String password) throws Exception;
    }
```

### dao/StuDAOImp.java

```java
public class StuDAOImp implements StuDAO {

    connect db = new connect();
    Connection con=db.getConnection();
    
    public int add(String username,String password) throws Exception {
    
        int flags = 0;


        String sqladd = "insert into USERTABLE VALUES(?,?)";
        try {
    
            PreparedStatement pres = con.prepareStatement(sqladd);
            pres.setString(1, username);
            pres.setString(2, password);
            pres.execute();
            flags = pres.executeUpdate(sqladd);
    
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception");
        }
        return flags;
    }
    }
```

## 第五题

### bean/movie.java

```java
public class movie implements Serializable {
 private String moviename;
    private String showtime;
    private String shortinfo;
    private String picturepath;
    public movie(){}
    public movie(String moviename,String showtime,String shortinfo,String picturepath){
        super();
        this.moviename=moviename;
        this.showtime=showtime;
        this.shortinfo=shortinfo;
        this.picturepath=picturepath;


    }
    
    public String toString() {
        return "user{" +
                "username='" + moviename + '\'' +
                ", userid=" + showtime +
                ", userroom='" + shortinfo + '\'' +
                ", userage=" + picturepath +
                '}';
    }
    }

```

## 第六题

### ShowAllMovie.jsp

```jsp
<s:action name="show" executeResult="true"/>
```

### struts.xml

```xml
<action name="show" class="control.ShowAllMovie">
            <result name="success">/ShowAllSuc.jsp</result>
            <result name="error">/ShowAllErr.jsp</result>
</action>
```

### ShowAllSuc.jsp

```jsp
<table border="1">
    <tr align="center">
        <td>电影名称</td>
        <td>上映时间 </td>
        <td>简介</td>
        <td colspan ="1">操作</td>
    </tr>
    <s:iterator  value="StudentList"  var="ux">
        <tr>
            <td><s:property value="#ux.getMoviename()"/></td>
            <td><s:property value="#ux.getShowtime()"/></td>
            <td><s:property value="#ux.getShortinfo()"/></td>

            <td>
                <a href="select.action?moviename=<s:property value="#ux.getMoviename()"/>">查看详细信息</a>
            </td>
    
        </tr>
    </s:iterator>
</table>

    <a href="AddMovie.jsp"/>添加新电影信息</a><br>
```

### ShowAllErr.jsp

```jsp
显示失败!
```

### dao/StuDAO.java

```java
public interface StuDAO {
    List show( ) throws Exception;
}
```

### dao/StuDAOImp.java

```java
public class StuDAOImp implements StuDAO {

    connect db = new connect();
    Connection con=db.getConnection();
     public List show() throws Exception {
        List StudentList = new ArrayList();
    
        String sqlshow = "select * from MOVIEINFO";
        try {
    
            PreparedStatement pref = con.prepareStatement(sqlshow);
            ResultSet rs = pref.executeQuery();
            while (rs.next()) {
                movie uk = new movie();
                uk.setMoviename(rs.getString("moviename"));
                uk.setShowtime(rs.getString("showtime"));
                uk.setShortinfo(rs.getString("shortinfo"));
                uk.setPicturepath(rs.getString("picturepath"));
                StudentList.add(uk);
            }
            return StudentList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception");
        }
        return StudentList;
    
    }
    }
```

## 第七题

### struts.xml

```xml
<action name="select" class="control.SelectByName">
            <result name="success">/SelectNameSuc.jsp</result>
            <result name="error">/ShowAllErr.jsp</result>
</action>
```

### SelectNameSuc.jsp

```jsp
<table border="1">
    <tr align="center">
        <td>电影名称</td>
        <td>上映时间 </td>
        <td>简介</td>
        <td>图片保存地址</td>
    </tr>
    <s:iterator  value="StudentList"  var="ux">
        <tr>
            <td><s:property value="#ux.getMoviename()"/></td>
            <td><s:property value="#ux.getShowtime()"/></td>
            <td><s:property value="#ux.getShortinfo()"/></td>
            <td><s:property value="#ux.getPicturepath()"/></td>
        </tr>
    </s:iterator>
</table>
<p>
```

### SelectByName.java

```java
public class SelectByName extends ActionSupport {
    private List<movie> StudentList;
    private  String moviename;
    public String execute() throws Exception {
        StuDAO stu = new StuDAOImp();
        System.out.println(moviename);
        StudentList=stu.selectbyname(moviename);
        ActionContext.getContext().put("StudentList",StudentList);
        return SUCCESS;
    }
}
```

### ShowAllErr.jsp

```jsp
显示失败!
```

### dao/StuDAO.java

```java
public interface StuDAO {
List selectbyname(String moviename) throws Exception;
}
```

### dao/StuDAOImp.java

```java
public class StuDAOImp implements StuDAO {
 public List selectbyname(String moviename) throws Exception {

        List st = new ArrayList();
        String sqlselect = "select * from MOVIEINFO where MOVIENAME='" + moviename + "'";
        PreparedStatement pref = con.prepareStatement(sqlselect);
        ResultSet rst = pref.executeQuery();
    
        while (rst.next())
        {
            movie use= new movie();
            use.setMoviename(rst.getString("moviename"));
            use.setShowtime(rst.getString("showtime"));
            use.setShortinfo(rst.getString("shortinfo"));
            use.setPicturepath(rst.getString("picturepath"));
            st.add(use);
        }
        return st;
    
    }
    }
```

## 第八题

### AddMovie.java

```java
public class AddMovie extends ActionSupport {
    private movie uk;
    private movie us;

    public String execute() throws Exception {
        StuDAO stu = new StuDAOImp();
        us =stu.mlz(uk);
        return SUCCESS;
    }
}
```

### struts.xml

```xml
<action name="movie" class="control.AddMovie">
            <result name="success">/AddMovieSuc.jsp</result>
            <result name="error">/ShowAllErr.jsp</result>
        </action>
```

### dao/StuDAO.java

```java
public interface StuDAO {
 movie mlz(movie uk) throws Exception;
}
```

### dao/StuDAOImp.java

```java
public class StuDAOImp implements StuDAO {

    connect db = new connect();
    Connection con=db.getConnection();
     public movie mlz(movie uk) throws Exception {
    
        String sqlmlz = "insert into MOVIEINFO VALUES(?,?,?,?)";
        try {
            PreparedStatement pret = con.prepareStatement(sqlmlz);
    
            pret.setString(1, uk.getMoviename());
            pret.setString(2, uk.getShowtime());
            pret.setString(3, uk.getShortinfo());
            pret.setString(4, uk.getPicturepath());
            pret.execute();
    
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception");
        }
        return uk;
    
    }
    }
```

## 第九题

### StuDAO.java

```java
public interface StuDAO {
    int add(String username,String password) throws Exception;
}
```

### StuDAOImp.java

```java
public class StuDAOImp implements StuDAO {

    connect db = new connect();
    Connection con=db.getConnection();

    public int add(String username,String password) throws Exception {

        int flags = 0;


        String sqladd = "insert into USERTABLE VALUES(?,?)";
        try {

            PreparedStatement pres = con.prepareStatement(sqladd);
            pres.setString(1, username);
            pres.setString(2, password);
            pres.execute();
            flags = pres.executeUpdate(sqladd);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception");
        }
        return flags;
    }
}
```

###  struts.xml

```xml
<action name="movie" class="control.AddMovie">
            <result name="success">/AddMovieSuc.jsp</result>
            <result name="error">/ShowAllErr.jsp</result>
        </action>
```

### AddMovieSuc.jsp

```jsp
电影信息插入成功！<br>
电影名称：<s:property value="uk.moviename"/><br>
上映时间：<s:property value="uk.showtime"/><br>
简介：<s:property value="uk.shortinfo"/><br>
图片地址：<s:property value="uk.picturepath"/><br>
<%  response.setHeader("refresh","3;URL=ShowAllMovie.jsp");%>
```



## 第十题

### struts.xml

```xml
 <package name="hzw" extends="struts-default">
        <global-results>
            <result name="io_Exception">/Exception_io.jsp</result>
        </global-results>
        <global-exception-mappings>
            <exception-mapping exception="java.io.IOException" result="io_Exception"/>
        </global-exception-mappings>
</package>
```


