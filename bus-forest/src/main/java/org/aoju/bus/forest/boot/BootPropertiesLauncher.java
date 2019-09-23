/*
 * The MIT License
 *
 * Copyright (c) 2017 aoju.org All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.aoju.bus.forest.boot;

import org.aoju.bus.forest.Launcher;
import org.springframework.boot.loader.PropertiesLauncher;
import org.springframework.boot.loader.archive.Archive;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

/**
 * Spring-Boot Properties 启动器
 *
 * @author Kimi Liu
 * @version 3.5.6
 * @since JDK 1.8
 */
public class BootPropertiesLauncher extends PropertiesLauncher {
    private final Launcher launcher;

    public BootPropertiesLauncher(String... args) throws Exception {
        this.launcher = new Launcher(args);
    }

    public static void main(String[] args) throws Exception {
        new BootPropertiesLauncher(args).launch();
    }

    public void launch() throws Exception {
        launch(launcher.args);
    }

    @Override
    protected ClassLoader createClassLoader(List<Archive> archives) throws Exception {
        URLClassLoader classLoader = (URLClassLoader) super.createClassLoader(archives);
        URL[] urls = classLoader.getURLs();
        return new BootClassLoader(urls, this.getClass().getClassLoader(), launcher.decryptorProvider, launcher.encryptorProvider, launcher.key);
    }
}
