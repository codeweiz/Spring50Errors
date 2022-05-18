## 1、ComponentScan
默认的 @ComponentScan() 扫描的是 Application.java 类相同文件夹的所有 Bean。
如果移动 Application.java 类的位置，就可能找不到有些 Bean。
这时可以使用 @ComponentScan() 显式地指定要扫描的路径：
```java
@ComponentScan("cn.microboat.Spring50Errors.controller")
public class Spring50ErrorsApplication{}
```
还可以使用 
@ComponentScans(value = {
@ComponentScan(), @ComponentScan()
}) 显式地指定多个要扫描的路径：
```java
@ComponentScans(value = {
        @ComponentScan("cn.microboat.Spring50Errors.controller"),
        @ComponentScan("cn.microboat.Spring50Errors.dao")
})
public class Spring50ErrorsApplication {}
```

## 2、
