import java.time.ZonedDateTime;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-3-2 9:58
 * @see: PACKAGE_NAME
 * @Version: 1.0
 */
public class T2 {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();  //默认时区
        System.out.println(now);
    }
}
