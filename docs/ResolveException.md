# Resolve Exception

- Spring framework와 Spring Boot에서 사용하는 `ExceptionResolver`에서 4가지 Resolver에서 사용하는 `resolveException` method에 대해 알아본다.

## HandlerExceptionResolver & AbstractHandlerExceptionResolver

- Spring framework에서 제공하는 `HandlerExceptionResolver` 인터페이스와 그것을 상속하여 예외처리에 대한 로직을 구현한 추상 클래스인 `AbstractHandlerExceptionResolver`가 있다.

```java
    /**
     * Try to resolve the given exception that got thrown during handler execution,
     * returning a {@link ModelAndView} that represents a specific error page if appropriate.
     * <p>The returned {@code ModelAndView} may be {@linkplain ModelAndView#isEmpty() empty}
     * to indicate that the exception has been resolved successfully but that no view
     * should be rendered, for instance by setting a status code.
     * @param request current HTTP request
     * @param response current HTTP response
     * @param handler the executed handler, or {@code null} if none chosen at the
     * time of the exception (for example, if multipart resolution failed)
     * @param ex the exception that got thrown during handler execution
     * @return a corresponding {@code ModelAndView} to forward to,
     * or {@code null} for default processing in the resolution chain
     */
    @Nullable
    ModelAndView resolveException(
            HttpServletRequest request, HttpServletResponse response, @Nullable Object handler, Exception ex);
```

- 인터페이스인 `HandlerExceptionResolver`에는 예외가 발생하는 경우 해결하기 위한 단 한가지 메서드가 존재한다.

```java
	/**
	 * Check whether this resolver is supposed to apply (i.e. if the supplied handler
	 * matches any of the configured {@linkplain #setMappedHandlers handlers} or
	 * {@linkplain #setMappedHandlerClasses handler classes}), and then delegate
	 * to the {@link #doResolveException} template method.
	 */
	@Override
	@Nullable
	public ModelAndView resolveException(
			HttpServletRequest request, HttpServletResponse response, @Nullable Object handler, Exception ex) {

		if (shouldApplyTo(request, handler)) {
			prepareResponse(ex, response);
			ModelAndView result = doResolveException(request, response, handler, ex);
			if (result != null) {
				// Print debug message when warn logger is not enabled.
				if (logger.isDebugEnabled() && (this.warnLogger == null || !this.warnLogger.isWarnEnabled())) {
					logger.debug(buildLogMessage(ex, request) + (result.isEmpty() ? "" : " to " + result));
				}
				// Explicitly configured warn logger in logException method.
				logException(ex, request);
			}
			return result;
		}
		else {
			return null;
		}
	}
```

- 추상 클래스인 `AbstractHandlerExceptionResolver`에서 인터페이스를 구현하여 메서드를 오버라이드한다. 내용을 간단히 살펴보자.
- `shouldApplyTo(request, handler)`를 통해서 `handler`를 `request`에 적용할 수 있는 지 판단하여 로직을 수행한다.
- `prepareResponse(ex, response)`에서 `response`의 헤더에 예외에 대한 내용을 추가한다.
- 이제 반환하기에 적절한 형태로 `ModelAndView` 객체를 생성하고 return 해준다.
- 해당 메서드는 전역 Controller인 DispatcherServlet에서 호출되어 실행된다.
- 각 `Resolver`에서 `doResolveException`을 오버라이드하여 상이하게 구현되는 부분이 존재한다.