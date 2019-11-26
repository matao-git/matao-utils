package com.matao;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
    * @ClassName: StringUtils
    * @Description: 字符串工具类
    * @author 马涛
    * @date 2019年11月17日
    *
 */
public class StringUtils {
	

	/**
	 * 验证全为字母
	 * @param str
	 * @return
	 */
	public static boolean isLetter(String str) {
		String pattern = "^[a-zA-Z]+$";
		return str.matches(pattern);
	}
	
	
	/**
	 * 生成一个随机的中文字符串 
	 * @return
	 */
	private static char getRandomCn() {
		
		String str = "";
        int hightPos; //
        int lowPos;
        Random random = new Random();

        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("出现异常");
        }

        return str.charAt(0);
	}
	
	
	/**
	 * 生成长度为n 的中文字符串
	 * @return
	 */
	public static String getRandomCn(int n ) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(getRandomCn());
		}
		return sb.toString();
	}
	
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		
		return (str == null|| str.trim().equals(""));
	}
	
	public static String generateChineseName() {
		return getRandomCn(3);
	}
	
	/**
	 * 
	 */
	public static char cs[] = new char[36] ;
	// 初始化数组
	static {
		int index=0;
		for (char i = 'a'; i <='z' ; i++) {
			cs[(int)index ++]=i;
		}
		
		for (char i = '0'; i <='9' ; i++) {
			cs[(int)index ++]=i;
		}
		
	}
	/**
	 * 
	    * @Title: randomNum
	    * @Description: 获取单个随机数字
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	public static int randomNum() {
		Random random = new Random(); 
		int a=random.nextInt(10);
		return a;
		 
	}
	public static int randomNumSize(int n) {
		int a = 0 ;
		for (int i = 0; i < n; i++) {
			int randomNum = StringUtils.randomNum();
			System.out.print(randomNum);
			a=randomNum;
		}
		return a;
	}
	/**
	 * 随机生成常见的汉字
	 * 
	 * @author xuliugen
	 * 
	 */
	  public static void getCommonChinese() {
	    for (int i = 1; i < 3; i++) {
	      System.out.print(getRandomChar() + " ");
	    }
	  }
	  private static char getRandomChar() {
	    String str = "";
	    int hightPos; //
	    int lowPos;
	    Random random = new Random();
	    hightPos = (176 + Math.abs(random.nextInt(39)));
	    lowPos = (161 + Math.abs(random.nextInt(93)));
	    byte[] b = new byte[2];
	    b[0] = (Integer.valueOf(hightPos)).byteValue();
	    b[1] = (Integer.valueOf(lowPos)).byteValue();
	    try {
	      str = new String(b, "GBK");
	    } catch (UnsupportedEncodingException e) {
	      e.printStackTrace();
	      System.out.println("错误");
	    }
	    return str.charAt(0);
	  }

	  /**
	      * 汉字以两个字节存储，称为“区位码”，高位叫区码，低位叫位码，有这俩字节组成汉字
	      *获取单个汉字
	      * @return
	      */
	     public static char getRandomChar2() {
	         String str = "";
	  
	         //随机数对象
	         Random random = new Random();
	  
	         ///区码，0xA0打头，从第16区开始，即0xB0=11*16=176,16~55一级汉字，56~87二级汉字
	         int hightPos = (176 + Math.abs(random.nextInt(39)));
	  
	         //位码，0xA0打头，范围第1~94列
	         int lowPos = (161 + Math.abs(random.nextInt(93)));
	  
	         //字节码
	         byte[] b = new byte[2];
	         b[0] = (Integer.valueOf(hightPos)).byteValue();
	         b[1] = (Integer.valueOf(lowPos)).byteValue();
	  
	         try {
	             //区位码组合成汉字
	             str = new String(b, "GBK");
	  
	         } catch (UnsupportedEncodingException e) {
	             e.printStackTrace();
	             System.out.println("错误");
	         }
	         //根据索引返回对应的字符
	         return str.charAt(0);
	     }
	
	  
	  /**
	   * 
	      * @Title: main
	      * @Description:生成名字
	      * @param @param args    参数
	      * @return void    返回类型
	      * @throws
	   */
	public static String getChineseName() {
		Random random=new Random(System.currentTimeMillis());
		/* 598 百家姓 */
		String[] Surname= {"赵","钱","孙","李","周","吴","郑","王","冯","陈","褚","卫","蒋","沈","韩","杨","朱","秦","尤","许",
				  "何","吕","施","张","孔","曹","严","华","金","魏","陶","姜","戚","谢","邹","喻","柏","水","窦","章","云","苏","潘","葛","奚","范","彭","郎",
				  "鲁","韦","昌","马","苗","凤","花","方","俞","任","袁","柳","酆","鲍","史","唐","费","廉","岑","薛","雷","贺","倪","汤","滕","殷",
				  "罗","毕","郝","邬","安","常","乐","于","时","傅","皮","卞","齐","康","伍","余","元","卜","顾","孟","平","黄","和",
				  "穆","萧","尹","姚","邵","湛","汪","祁","毛","禹","狄","米","贝","明","臧","计","伏","成","戴","谈","宋","茅","庞","熊","纪","舒",
				  "屈","项","祝","董","梁","杜","阮","蓝","闵","席","季","麻","强","贾","路","娄","危","江","童","颜","郭","梅","盛","林","刁","钟",
				  "徐","邱","骆","高","夏","蔡","田","樊","胡","凌","霍","虞","万","支","柯","昝","管","卢","莫","经","房","裘","缪","干","解","应",
				  "宗","丁","宣","贲","邓","郁","单","杭","洪","包","诸","左","石","崔","吉","钮","龚","程","嵇","邢","滑","裴","陆","荣","翁","荀",
				  "羊","于","惠","甄","曲","家","封","芮","羿","储","靳","汲","邴","糜","松","井","段","富","巫","乌","焦","巴","弓","牧","隗","山",
				  "谷","车","侯","宓","蓬","全","郗","班","仰","秋","仲","伊","宫","宁","仇","栾","暴","甘","钭","厉","戎","祖","武","符","刘","景",
				  "詹","束","龙","叶","幸","司","韶","郜","黎","蓟","溥","印","宿","白","怀","蒲","邰","从","鄂","索","咸","籍","赖","卓","蔺","屠",
				  "蒙","池","乔","阴","郁","胥","能","苍","双","闻","莘","党","翟","谭","贡","劳","逄","姬","申","扶","堵","冉","宰","郦","雍","却",
				  "璩","桑","桂","濮","牛","寿","通","边","扈","燕","冀","浦","尚","农","温","别","庄","晏","柴","瞿","阎","充","慕","连","茹","习",
				  "宦","艾","鱼","容","向","古","易","慎","戈","廖","庾","终","暨","居","衡","步","都","耿","满","弘","匡","国","文","寇","广","禄",
				  "阙","东","欧","殳","沃","利","蔚","越","夔","隆","师","巩","厍","聂","晁","勾","敖","融","冷","訾","辛","阚","那","简","饶","空",
				  "曾","毋","沙","乜","养","鞠","须","丰","巢","关","蒯","相","查","后","荆","红","游","郏","竺","权","逯","盖","益","桓","公","仉",
				  "督","岳","帅","缑","亢","况","郈","有","琴","归","海","晋","楚","闫","法","汝","鄢","涂","钦","商","牟","佘","佴","伯","赏","墨",
				  "哈","谯","篁","年","爱","阳","佟","言","福","南","火","铁","迟","漆","官","冼","真","展","繁","檀","祭","密","敬","揭","舜","楼",
				  "疏","冒","浑","挚","胶","随","高","皋","原","种","练","弥","仓","眭","蹇","覃","阿","门","恽","来","綦","召","仪","风","介","巨",
				  "木","京","狐","郇","虎","枚","抗","达","杞","苌","折","麦","庆","过","竹","端","鲜","皇","亓","老","是","秘","畅","邝","还","宾",
				  "闾","辜","纵","侴","万俟","司马","上官","欧阳","夏侯","诸葛","闻人","东方","赫连","皇甫","羊舌","尉迟","公羊","澹台","公冶","宗正",
				  "濮阳","淳于","单于","太叔","申屠","公孙","仲孙","轩辕","令狐","钟离","宇文","长孙","慕容","鲜于","闾丘","司徒","司空","兀官","司寇",
				  "南门","呼延","子车","颛孙","端木","巫马","公西","漆雕","车正","壤驷","公良","拓跋","夹谷","宰父","谷梁","段干","百里","东郭","微生",
				  "梁丘","左丘","东门","西门","南宫","第五","公仪","公乘","太史","仲长","叔孙","屈突","尔朱","东乡","相里","胡母","司城","张廖","雍门",
				  "毋丘","贺兰","綦毋","屋庐","独孤","南郭","北宫","王孙"};
		
		int index=random.nextInt(Surname.length-1);		
		String name = Surname[index]; //获得一个随机的姓氏
		
		/* 从常用字中选取一个或两个字作为名 */
		if(random.nextBoolean()){
			name+=getChinese()+getChinese();
		}else {
			name+=getChinese();
		}
		return name;
	}
	
	public static String getChinese() {
		String str = null;
		int highPos, lowPos;
		Random random = new Random();
		highPos = (176 + Math.abs(random.nextInt(71)));//区码，0xA0打头，从第16区开始，即0xB0=11*16=176,16~55一级汉字，56~87二级汉字
		random=new Random();
		lowPos = 161 + Math.abs(random.nextInt(94));//位码，0xA0打头，范围第1~94列
 
		byte[] bArr = new byte[2];
		bArr[0] = (new Integer(highPos)).byteValue();
		bArr[1] = (new Integer(lowPos)).byteValue();
		try {
			str = new String(bArr, "GB2312");	//区位码组合成汉字
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
			return str;
 
	}
	
	/**
	 * 验证是否是URL
	 * @param url
	 * @return
	 */
	public static boolean isHttpUrl(String str){
		
		 //转换为小写
        str = str.toLowerCase();
        String regex = "^((https|http|ftp|rtsp|mms)?://)"  //https、http、ftp、rtsp、mms
                + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@  
               + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 例如：199.194.52.184               
                 + "|" // 允许IP和DOMAIN（域名） 或单域名
                 + "[0-9a-z]*"  // 或单域名
                 + "|" // 允许IP和DOMAIN（域名） 或单域名
                 + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.  
                 + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名  
                + "[a-z]{2,6})" // first level domain- .com or .museum  
                + "(:[0-9]{1,5})?" // 端口号最大为65535,5位数
                + "((/?)|" // a slash isn't required if there is no file name  
                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
        return  str.matches(regex);	
	}
	  
	/**
	 * 随机获取N个字符串  调用获取字符串的方法每次只能获取一个  那么 获取N字符串就需要调用N次方法就行组合
	 */
	public static String getCharByN(int n) {
		StringBuilder sb = new StringBuilder();
		StringBuilder str1 = null;
		for(int i = 0; i < n; i++) {
			char str = getChineseStr();
			str1 = sb.append(str);
		}
		return str1.toString();
	}
	/**
	 * 获取n个随机中文字符串
	 * @return
	 */
	private  static char getChineseStr() {
		String str = "";

		int hightPos; //

		int lowPos;

		Random random = new Random();

		hightPos = (176 + Math.abs(random.nextInt(39)));

		lowPos = (161 + Math.abs(random.nextInt(93)));

		byte[] b = new byte[2];

		b[0] = (Integer.valueOf(hightPos)).byteValue();

		b[1] = (Integer.valueOf(lowPos)).byteValue();

		try {
		
			str = new String(b, "GBK");
		
			} catch (Exception e) {
		
			e.printStackTrace();
			
			System.out.println("错误");
		
			}
		return str.charAt(0);
	}
	
	
	/**
	 * 判断是否是空的字符串
	 */
	public static boolean isNullString(String src) {
		if(src == null || src.trim().equals("")) {
			return false;
		} else {
			return true;
		}
	}
	  
	public static void main(String[] args) {
		String str = randomChar(10);
		System.out.println("10个随机的字符是" + str);
		
		
		/*String s = StringUtils.randomCharAndNumber(20);
		System.out.println("s is " + s);
		
		System.out.println("扩展名是："  + StringUtils.getFileSuffix("朱志广-1706E-补课计划.xlsx"));
		
		System.out.println(" reg 234 " + StringUtils.isNumber("234") );

		System.out.println(" reg 2a34 " + StringUtils.isNumber("2a34") );
		System.out.println(" reg kong  " + StringUtils.isNumber("") );
		
		
		System.out.println(" is email  ? zhuzh@qq.com " + StringUtils.isEmail("zhuzh@qq.com"));
		System.out.println(" is email ? zhuzg@qq.c1n  " + StringUtils.isEmail("zhuzg@qq.c1n") );
		
		System.out.println(" type2 is email  ? zhuzh@qq.com " + StringUtils.isEmail2("zhuzh@qq.com"));
		System.out.println(" type2   email ? zhuzg@qq.c1n  " + StringUtils.isEmail2("zhuzg@qq.c1n") );
		
		
		String str = "张三\r\n李四";
		String dst = toHtml(str);
		System.out.println("dst is " + dst);
		*/
		
		//String str = "9.5";
		//System.out.println(isNumber(str));
		
		
		
	}
	
	/**
	 * 特定区间内的随机数
	 */
	public static int getRandomNum(int Max,int Min) {
		int result = Min + (int)(Math.random() * ((Max - Min) + 1));
		return result;
	}
	
	/**
	 * 判断源字符串是否为空，空引号也算没有值；
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		
		//return (str==null|| "".equals(str.trim()));
		return (str==null || 0== str.trim().length());
	}
	
	/**
	 * 判断源字符串是否有值，空引号也算没值；
	 * @param str
	 * @return 
	 * @return
	 */
	public static  boolean hasText(String str) {
		//return !(str==null || 0== str.trim().length());
		return str!=null && 0 < str.trim().length();   
	
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static String randomChar(int n) {
		Random random = new Random();
		String str = "";
		for (int i = 0; i < n; i++) {
			 char c = (char)('a' + 	random.nextInt(26));// a - z
			str += c;
		}
		return str;
		
	}
	
	/**
	 * 随机生成长度为n的字符串，其中包含字母和数字
	 * @param n
	 * @return
	 */
	public static String randomCharAndNumber(int n) {
		
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			sb.append(cs[random.nextInt(36)]);
		}
		return sb.toString();
		
	}
	
	/**
	  *获取一个文件名称的扩展名
	  * 例如： mytest/mynewFile.txt return .txt
	 * @param fileName
	 * @return
	 */
	public static String getFileSuffix(String fileName) {
		
		//return ".txt";
		int dotIndex = fileName.lastIndexOf('.');
		if(dotIndex==-1)
			return "";
		
		return fileName.substring(fileName.lastIndexOf('.'));
		
	}
	
	/**
	 * 判断是否为字符串
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		
		String reg = "[0-9]+[.]?[0-9]+";
		return str.matches(reg);
	}
	
	/**
	 * 验证代码
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
		String reg = "^[0-9a-zA-Z]+@[0-9a-zA-Z]+\\.[a-z]{2,3}";
		return str.matches(reg);
		
	}
	
	public static boolean isEmail2(String str) {
		
		String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"; 
        Pattern p = Pattern.compile(regEx1);
        Matcher m = p.matcher(str);
        return m.find();

	}
	
	/**
	 * 校验一个字符串是否为正确的电话号码
	 * @param mobile
	 * @return
	 */
	public  static boolean isMobile(String mobile) {
		
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mobile);
		boolean isMatch = m.matches();
		return isMatch;
	}
	
	/**
	 * (1)利用Html的<p>标签来保留文本的换行。
	   (2)Windows系统换行符是“\r\n”,Linux系统是“\n”，因此要将\n\r替换成一个\n。
	   (3)再将\n结尾的这行文本用<p></p>标签包起来。 张三\n李四      <p>张三</p><p>李四</p>
	   (4)如果遇到单个\r字符要使用<br/>标签替换。
	 * @param src
	 * @return
	 */
	public static String toHtml(String src) {
		//Windows系统换行符是“\r\n”,Linux系统是“\n”，因此要将\n\r替换成一个\n。
		String dst = src.replaceAll("\r\n", "\n");
				
		//再将\n结尾的这行文本用<p></p>标签包起来。 张三\n李四      <p>张三</p><p>李四</p>
		dst=dst.replaceAll("\n", "</p><p>");
		dst="<p>" + dst + "</p>";
		//如果遇到单个\r字符要使用<br/>标签替换。
		dst=dst.replaceAll("\r", "<br/>");
		return dst;
	}
	
	
	/**
	 * 
	 * 获取n位随机英文字符串
	 * @param n
	 * @return
	 */
	public String randomLetterStr(int n) {
		
		if(n<=0)
			return "";
		Random random = new Random();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			char letter = (char)('A' + random.nextInt(26));
			sb.append(letter);
		}		
		return sb.toString();
	}

	/*方法功能：将字符串转换成html文本，如果遇到“\n”换行换符，则要将这一段文本使用<p></p>标签
	 * @ContextConfiguration("classpath:spring.xml")
	*@RunWith(SpringRunner.class)
	* 包起来。如果遇到“\n\r”两个在一起按上面\n处理。如果只遇到一个“\r”则替换成<br/>标签。
	* 使用场景：网页文本框传到后台的字符串就可能就会回车换行。*/
	public static String toHtml1(String src){
		String[] strings = src.split("\\\n");
		StringBuilder sb = new StringBuilder();
		for (String string : strings) {
			sb.append("<p>").append(string).append("</p>");
		}
		return sb.toString();
	}
	
	/**
	 * 获取n位随机英文和数字字符串
	 * @param n
	 * @return
	 */
	public String randomStr(int n) {
		
		char chars[]= {'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N'};
		
		// 定义个随机对象
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			// 随机得到一个下标，根据下标从数组当中获取值，拼接到字符串上
			
			// 随机获取一个下标
			int index = random.nextInt(chars.length);
			char c = chars[index];
			sb.append(c);//向后拼接
			
			/*sb.append( chars[random.nextInt(chars.length)]
					);*/
			
		}
		return sb.toString();
		
	}
	
	public static String getRandomNumtoStr(Integer len){
		Random random = new Random();
		String str="";
		for (int i = 0; i < len; i++) {
			int randomint = random.nextInt(9);
			str+=String.valueOf(randomint);
		}
		return str;
	}
	
	//获取n个随机中文字符串
		public static String getRandonCnStr(int n) {
			
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<n;i++) {
				sb.append(getOneCn());
			}
			return sb.toString();
			
		} 
		

		/**
		 * 随机获取一个中文字符
		 * @return
		 */
		private static String getOneCn(){
			
			String str = "";
	        int hightPos; //
	        int lowPos;
	        Random random = new Random();

	        hightPos = (176 + Math.abs(random.nextInt(39)));
	        lowPos = (161 + Math.abs(random.nextInt(93)));

	        byte[] b = new byte[2];
	        b[0] = (Integer.valueOf(hightPos)).byteValue();
	        b[1] = (Integer.valueOf(lowPos)).byteValue();

	        try {
	            str = new String(b, "GBK");
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("错误");
	        }

	        return str;
		}
		
}
