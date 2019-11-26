package com.matao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;



/**
 * 
    * @ClassName: FileUtils
    * @Description: 文件工具类
    * @author 马涛
    * @date 2019年11月17日
    *
 */
public class FileUtils {
	
	private static File file;

		//上传文件
		public static String processFile(MultipartFile file,String uploadPath) throws IllegalStateException, IOException{
			
			//求扩展名
			String suffixName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
			String fileNamePre = UUID.randomUUID().toString();
			//新的名字
			String fileName=fileNamePre+suffixName;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String date = sdf.format(new Date());
			File pathFile = new File(uploadPath+"/"+date);
			if(!pathFile.exists()){
				pathFile.mkdirs();
			}
			//最后文件名称
			String newName=uploadPath+"/"+date+"/"+fileName;
			file.transferTo(new File(newName));
			//返回文件名字
			return date+"/"+fileName;
		}
	
	public static void main(String[] args) throws IOException {
		
		String readFileByLine = readFileByLine("D:\\1703A\\yunfu-parent\\pom.xml");
		System.out.println("filename is " + readFileByLine);
		//del("D:\\教学\\16.0\\小二 -副本");
		
		//file = new File("D:\\教学\\16.0\\小二 -副本");
		//file.delete();
		//copy("D:\\1703A\\groupparent\\groupparent.rar","D:\\1703A\\groupparent\\groupparent22.rar");
	}
	
	/**
	 * 删除文件或者文件夹，使用递归的算法
	 * @param path
	 */
	public static void del(String path) {
		
		File file = new File(path);
		//如果文件不存在
		if(!file.exists()) {
			System.out.println("不存在该路径" + path);
			return;
		}
		
		//如果是文�? 则删�?
		if(file.isFile()) {
			System.out.println("删除 文件  " + path);
			file.delete();
		}
		//如果是文件夹 则递归调用自己
		if(file.isDirectory()) {
			String[] list = file.list();
			for (int i = 0; i < list.length; i++) {
				String subFileName = path + "\\" + list[i];
				del(subFileName);
			}
			System.out.println("删除目录  " + path);
			file.delete();
		}
		
	}
	
	/**
	 * 拷贝文件
	 * @param src  源文件
	 * @param dst  目标文件
	 * @throws IOException 
	 */
	public static void copy(String src,String dst) throws IOException {
		File fileSrc = new File(src);
		if(!fileSrc.exists() || !fileSrc.isFile()) {
			System.out.println(src + " 文件不存在，不能复制！");
			return;
		}
		
		File fileDst = new File(dst);
		if(fileDst.exists()) {
			System.out.println("目标文件已经存在，不能复制！");
		}
		
		// 获取输入流
		FileInputStream fis = new FileInputStream(fileSrc);
		FileOutputStream fos = new FileOutputStream(fileDst);
		
		byte bs[] = new byte[1024];
		while(fis.read(bs)>=0) {
			fos.write(bs);
		}
		
		/*fis.close();
		fos.close();*/
		//调用流工具类 去关闭流
		StreamUtils.closeStream(fis,fos);
	}
	
	/**
	 * @return
	 * @throws IOException 
	 */
	public static String readFileByLine(String fileName) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(fis);
		BufferedReader  bufferedReader = new BufferedReader(reader);
		String str = null;
		while( (str=bufferedReader.readLine())!=null ) {
			sb.append(str).append("\r\n");// 追加
		}
		//关闭流
		StreamUtils.closeStream(fis);
		return sb.toString();
		
	} 
	
	
	public static List<String> readFile(String fileName) throws IOException {
		
		List<String> strList = new ArrayList();
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(fis,"utf-8");
		BufferedReader  bufferedReader = new BufferedReader(reader);
		String str = null;
		while( (str=bufferedReader.readLine())!=null ) {
			strList.add(str);
		}
		//关闭流
		StreamUtils.closeStream(fis);
		return strList;
		
	} 
	/**
	 * 
	 * @param 就是读取文件  然后将读取的内容返回到list集合中 直接调用修改
	 * @return
	 */
	public static List<String> ReadFileByLine(String filename) {
		List<String> list = new ArrayList<String>();
		File file = new File(filename);
		InputStream is = null;
		Reader reader = null;
		BufferedReader bufferedReader = null;
		try {
			is = new FileInputStream(file);
			reader = new InputStreamReader(is);
			bufferedReader = new BufferedReader(reader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
			list.add(line);
			System.out.println(line);
			}
			return list;
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != bufferedReader)
				bufferedReader.close();
				if (null != reader)
				reader.close();
				if (null != is)
				is.close();
			} catch (IOException e) {
					e.printStackTrace();
			}
			
		}
			return null;
	}
	/**
	* 按字节读取文件
	*
	* @param filename
	*/
	public static void ReadFileByBytes(String filename) {

	File file = new File(filename);

	InputStream is = null;

	try {

		is = new FileInputStream(file);
	
		int index = 0;
	
		while (-1 != (index = is.read())) {
	
		System.out.write(index);
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			if (null != is)
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		System.out.println("-----------------------------------");
		try {
			is = new FileInputStream(file);
			byte[] tempbyte = new byte[1000];
			int index = 0;
			while (-1 != (index = is.read(tempbyte))) {
			System.out.write(tempbyte, 0, index);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (null != is)
				is.close();
				} catch (IOException e) {
				e.printStackTrace();
				}
		}
	}
	
	/*
	 * @Value("${upload.path}") String uploadPath;
	 */
	/**
	 * 保存文件的相对路径
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	
	/*
	 * private String processFile(MultipartFile file) throws IllegalStateException,
	 * IOException { log.info("uploadPath is"+uploadPath);
	 * 
	 * //1.求扩展名“xxx.jsp” String suffixName =
	 * file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('
	 * .')); String fileNamePre = UUID.randomUUID().toString();
	 * 
	 * //计算出新的文件名称 String fileName = fileNamePre +suffixName;
	 * 
	 * SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd"); String
	 * path =simpleDateFormat.format(new Date()); File pathFile = new
	 * File(uploadPath+"/"+path); if(!pathFile.exists()) { pathFile.mkdirs(); }
	 * 
	 * //最终的新的文件名称 String newFileName = uploadPath +"/"+path+"/"+fileName;
	 * file.transferTo(new File(newFileName));
	 * 
	 * return path+"/"+fileName; }
	 */
}
