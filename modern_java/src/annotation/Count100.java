package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) //실행시 jvm이 감지할 수 있는 annotation
public @interface Count100 {

}
