package asunboy.service.lock.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.expression.AnnotatedElementKey;
import org.springframework.expression.EvaluationContext;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * @author LiPengJu
 * @date: 2019/12/13
 */
public class AspectSupportUtils {
    private static ExpressionEvaluator evaluator = new ExpressionEvaluator();

    public static Object getKeyValue(JoinPoint joinPoint, String keyExpression) {
        return getKeyValue(joinPoint.getTarget(), joinPoint.getArgs(), joinPoint.getTarget().getClass(),
                ((MethodSignature) joinPoint.getSignature()).getMethod(), keyExpression);
    }

    private static Object getKeyValue(Object object, Object[] args, Class<?> clazz, Method method,
                                      String keyExpression) {
        if (StringUtils.hasText(keyExpression)) {
            if (!keyExpression.contains("#"))
                return keyExpression;
            EvaluationContext evaluationContext = evaluator.createEvaluationContext(object, clazz, method, args);
            AnnotatedElementKey methodKey = new AnnotatedElementKey(method, clazz);
            return evaluator.key(keyExpression, methodKey, evaluationContext);
        }
        StringBuilder generateKey = new StringBuilder(clazz.getName());
        generateKey.append(".");
        generateKey.append(method.getName());
        generateKey.append("-");
        generateKey.append(SimpleKeyGenerator.generateKey(args));
        return generateKey.toString();
    }
}
