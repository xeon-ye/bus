package org.aoju.bus.goalie.reactor;

import com.alibaba.fastjson.JSON;
import org.aoju.bus.base.consts.ErrorCode;
import org.aoju.bus.base.spring.Controller;
import org.aoju.bus.core.lang.exception.BusinessException;
import org.aoju.bus.core.toolkit.RuntimeKit;
import org.aoju.bus.core.toolkit.StringKit;
import org.aoju.bus.logger.Logger;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

import java.net.ConnectException;
import java.util.Map;

/**
 * 异常处理
 *
 * @author Justubborn
 * @since 2020/10/27
 */
public class GlobalExceptionHandler extends Controller implements ErrorWebExceptionHandler {


  @NonNull
  @Override
  public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {

    ServerHttpResponse response = exchange.getResponse();
    response.setStatusCode(HttpStatus.BAD_REQUEST);
    response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
    Map<String, String> map = ExchangeContext.get(exchange).getRequestMap();
    String method = null;
    if (null != map) {
      method = map.get(Constant.METHOD);
    }
    Logger.error("request: {},error:{}", method, RuntimeKit.getMessage(ex));
    Object message;
    if (ex instanceof ConnectException) {
      message = Controller.write(ErrorCode.EM_FAILURE);
    } else if (ex instanceof BusinessException) {
      BusinessException e = (BusinessException) ex;
      if (StringKit.isNotBlank(e.getErrcode())) {
        message = Controller.write(e.getErrcode());
      } else {
        message = Controller.write(ErrorCode.EM_100513, e.getMessage());
      }
    } else {
      message = Controller.write(ErrorCode.EM_100513);
    }
    DataBuffer db = response.bufferFactory().wrap(JSON.toJSONString(message).getBytes());
    return response.writeWith(Mono.just(db));
  }
}
