package cn.microboat.Spring50Errors.controller;

import cn.microboat.Spring50Errors.annotation.ValidCustomized;
import cn.microboat.Spring50Errors.pojo.Friend;
import cn.microboat.Spring50Errors.pojo.Teacher;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.Nullable;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

/**
 * @author zhouwei
 */
@RestController
@Slf4j
public class HiController {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @RequestMapping(value = "/hi/{name}", method = RequestMethod.GET)
    public String hi(@PathVariable("name") String name) {
        return name;
    }

    @RequestMapping(value = "/hi2/**", method = RequestMethod.GET)
    public String hi2(HttpServletRequest request) {
        return request.getRequestURI().split("/hi2/")[1];
    }

    @RequestMapping(value = "/hi3/**", method = RequestMethod.GET)
    public String hi3(HttpServletRequest request) {
        String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        String matchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
        return antPathMatcher.extractPathWithinPattern(matchPattern, path);
    }

    /**
     * localhost:7777/hi4?name=zhangsan&name=lisi
     * 当参数有多个 name 时，会解析到 String[] 中，再用 "," 拼接
     * RequestParam 对应 ?a=1&b=2
     * RequestBody 对应 body
     */
    @RequestMapping(value = "/hi4", method = RequestMethod.GET)
    public String hi4(@RequestParam("name") String name, @RequestBody Hi hi) {
        return name + "," + hi.hi;
    }

    @Data
    static class Hi {
        private String hi;
    }


    /**
     * 当请求参数 RequestParam 的值为空，可：
     * 1、required = false，改为非必填
     * 2、defaultValue = ""，增加默认值
     * 3、@Nullable，增加可为空注解
     * 4、将参数类型改为 Optional<T>
     */
    @RequestMapping(value = "/hi5", method = RequestMethod.GET)
    public Optional<String> hi5(@RequestParam(value = "name", required = false, defaultValue = "ZhangSan") @Nullable Optional<String> name) {
        return name;
    }

    /**
     * Date 型参数，如果格式不正确，无法转换成功
     * 1、使用正确的格式：?date=Sat, 12 Aug 1995 13:30:00 GMT
     * 2、添加 @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
     */
    @RequestMapping(value = "/hi6", method = RequestMethod.GET)
    public String hi6(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
        return date.toString();
    }

    /**
     * 直接用 Map 接收 RequestHeader，相同 header key 的只会接收第一个
     */
    @RequestMapping(value = "/hi7", method = RequestMethod.GET)
    public String hi7(@RequestHeader() Map map) {
        return map.toString();
    }

    /**
     * 1、直接用 HttpHeaders 接收 RequestHeader，相同 header key 的都会接收，比如 {myHeader: "1", "2"}
     * 2、直接用 MultiValueMap 接收 RequestHeader，相同 header key 的都会接收，并组成一个数组，比如 {myHeader=[1, 2]}
     * 推荐使用 HttpHeaders
     */
    @RequestMapping(value = "/hi8", method = RequestMethod.GET)
    public String hi8(@RequestHeader() HttpHeaders map) {
        return map.toString();
    }

    /**
     * 通过 produces = {"application/json"}
     * 显式地将返回类型设置为 application/json
     */
    @RequestMapping(value = "/hi9", method = RequestMethod.GET, produces = {"application/json"})
    public String hi9() {
        return "ok";
    }

    /**
     * spring-boot-starter-web 中的 spring-boot-starter-web-json 包含 jackson
     * 对于 RequestBody 是 {"name": "lisi"} 的参数传入时，会以 {"name": "lisi", "age": "null"} 返回
     * <p>
     * 在实体类上，加上 @JsonInclude(JsonInclude.Include.NON_NULL) 注解，
     * 就可以让 Jackson 对 null 的处理 和 Gson 一致
     */
    @PostMapping("/hi10")
    public Teacher hi10(@RequestBody Teacher teacher) {
        return teacher;
    }

    /**
     * 引入 spring-boot-starter-validation
     * 在参数前加上注解 @Valid 或者 @Validated 或者 Valid 开头的注解，比如 @ValidCustomized
     */
    @PostMapping("/friend/add")
    public void addFriend(@ValidCustomized @RequestBody Friend friend) {
        log.info("add new Friend: {}", friend.toString());
    }
}
