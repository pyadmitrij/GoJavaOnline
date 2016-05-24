import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LogAspect implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Logger logger = Logger.getLogger("CalculatorLog");
        logger.info("Before execution " + methodInvocation.getMethod().getName());
        Object result = methodInvocation.proceed();
        logger.info("After execution " + methodInvocation.getMethod().getName());
        return result;
    }
}