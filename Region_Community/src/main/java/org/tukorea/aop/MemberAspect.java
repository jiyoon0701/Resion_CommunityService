package org.tukorea.aop;
import java.util.Arrays;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.tukorea.project.domain.UserVO;

import com.google.protobuf.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class MemberAspect {
	private static final Logger logger = LoggerFactory.getLogger(MemberAspect.class);

	@Before("execution(* org.tukorea.project.service..*Service.*(..))")
	public void startLog(JoinPoint jp) {
		
		logger.info("        ------- AOP -------          ");
		logger.info("-------------------------------------");
		logger.info("-------------------------------------");

		logger.info("1:" + Arrays.toString(jp.getArgs()));
		logger.info("2:" + jp.getKind());
		logger.info("3:" + jp.getSignature().getName());
		logger.info("4:" + jp.getTarget().toString());
		logger.info("5:" + jp.getThis().toString());
	}
}