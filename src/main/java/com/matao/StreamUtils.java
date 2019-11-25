package com.matao;

import java.io.Closeable;
import java.io.IOException;
/**
 * 
    * @ClassName: StreamUtils
    * @Description: 流的工具类
    * @author 马涛
    * @date 2019年11月17日
    *
 */
public class StreamUtils {
	
	/**
	 * 关闭所有的流
	 * @param n
	 * @param streams
	 * @throws IOException
	 */
	public static void closeStream(Closeable ... streams) throws IOException {
		
		for (int i = 0; i < streams.length; i++) {
			streams[i].close();
		}
		
	}

}
