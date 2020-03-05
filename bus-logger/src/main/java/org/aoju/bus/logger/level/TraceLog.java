/*********************************************************************************
 *                                                                               *
 * The MIT License                                                               *
 *                                                                               *
 * Copyright (c) 2015-2020 aoju.org and other contributors.                      *
 *                                                                               *
 * Permission is hereby granted, free of charge, to any person obtaining a copy  *
 * of this software and associated documentation files (the "Software"), to deal *
 * in the Software without restriction, including without limitation the rights  *
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell     *
 * copies of the Software, and to permit persons to whom the Software is         *
 * furnished to do so, subject to the following conditions:                      *
 *                                                                               *
 * The above copyright notice and this permission notice shall be included in    *
 * all copies or substantial portions of the Software.                           *
 *                                                                               *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR    *
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,      *
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE   *
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER        *
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, *
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN     *
 * THE SOFTWARE.                                                                 *
 ********************************************************************************/
package org.aoju.bus.logger.level;

/**
 * TRACE级别日志接口
 *
 * @author Kimi Liu
 * @version 5.6.6
 * @since JDK 1.8+
 */
public interface TraceLog {

    /**
     * @return TRACE 等级是否开启
     */
    boolean isTraceEnabled();

    /**
     * 打印 TRACE 等级的日志
     *
     * @param t 错误对象
     */
    void trace(Throwable t);

    /**
     * 打印 TRACE 等级的日志
     *
     * @param format    消息模板
     * @param arguments 参数
     */
    void trace(String format, Object... arguments);

    /**
     * 打印 TRACE 等级的日志
     *
     * @param t         错误对象
     * @param format    消息模板
     * @param arguments 参数
     */
    void trace(Throwable t, String format, Object... arguments);

    /**
     * 打印 TRACE 等级的日志
     *
     * @param fqcn      完全限定类名(Fully Qualified Class Name),用于定位日志位置
     * @param t         错误对象
     * @param format    消息模板
     * @param arguments 参数
     */
    void trace(String fqcn, Throwable t, String format, Object... arguments);

}
