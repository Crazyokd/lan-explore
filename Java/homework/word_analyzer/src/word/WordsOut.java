package word;

import java.io.BufferedReader;
import java.io.FileReader;

public class WordsOut {
	// java中的50个关键字；
		public static String[] keyWords = { "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
				"class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "fianlly",
				"float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
				"new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
				"switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while" };
		// 算术运算符
		public static String[] arithmeticOperation = { "+", "-", "*", "/", "%", "++", "--" };
		// 关系运算符
		public static String[] relationOperation = { "<", ">", "<=", ">=", "==", "!=" };
		// 位运算符
		public static String[] bitOperation = { "&", "|", "^", "~", "<<", ">>", ">>>" };
		// 逻辑运算符
		public static String[] logicOperation = { "&&", "||", "!" };
		// 赋值运算符
		public static String[] assignmentOperation = { "=", "+=", "-=", "/=", "*=", "%=", "<<=", ">>=", "&=", "^=", "|=" };
		//标识符由不是数字开头，$、_、字母（区分大小写）和数字组成（true、false、null和关键字不是标识符）不限长度的字符串。
		public static String[] noIdentifier = { "true", "false", "null" };
		// 分界符 (\"在此指的是"，java中用转义字符输出原字符)
		public static String[] limiterWords = { ".", ",", ";", "[", "]", "{", "}", "(", ")", "\"", "'", ":" };
		// 单元运算符
		public static String[] unaryOperation = { "+", "-", "*", "/", "%", "<", ">", "&", "|", "^", "~", "!", "=" };
		// 双元运算符
		public static String[] binaryOperation = { "++", "--", "<=", ">=", "==", "!=", "<<", ">>", "&&", "||", "+=", "-=",
				"/=", "*=", "%=", "&=", "^=", "|=" };
		// 三元运算符
		public static String[] ternaryOperation = { ">>>", "<<=", ">>=" };
		
		/**
		 * 		
		判断是否为数字串，是就返回种别码，否就返回0；		
		 */
		public int isNum(String s) {
			int flag = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
					flag = 98;
				//出现不是数字的字符，跳出循环；
				} else {
					flag = 0;
					break;
				}
			}
			return flag;
		}

		/**
		 * 		
		 * 判断是否为分界符，是就返回种别码，否就返回0；
		 
		 */
		public int isLimiterWords(String s) {
			int flag = 0;
			for (int i = 0; i < limiterWords.length; i++) {
				if (limiterWords[i].equals(s)) {
					flag = 85 + i;
					break;
				}
			}
			return flag;
		}
		
		/**
		 
		 判断是否为运算符，是就返回种别码，否就返回0；
		 
		 */
		public int isOperation(String s) {
			int flag = 0;
			// 判断是否为算数运算符
			for (int i = 0; i < arithmeticOperation.length; i++) {
				if (arithmeticOperation[i].equals(s)) {
					flag = 51 + i;
					break;
				}
			}
			// 判断是否为关系运算符
			for (int j = 0; j < relationOperation.length; j++) {
				if (relationOperation[j].equals(s)) {
					flag = 58 + j;
					break;
				}
			}
			// 判断是否为位运算符
			for (int l = 0; l < bitOperation.length; l++) {
				if (bitOperation[l].equals(s)) {
					flag = 64 + l;
					break;
				}
			}
			// 判断是否为逻辑运算符
			for (int m = 0; m < logicOperation.length; m++) {
				if (logicOperation[m].equals(s)) {
					flag = 71 + m;
					break;
				}
			}
			// 判断是否为赋值运算符
			for (int n = 0; n < assignmentOperation.length; n++) {
				if (assignmentOperation[n].equals(s)) {
					flag = 74 + n;
					break;
				}
			}
			return flag;
		}

		/**
		 
		 判断是否为关键字，是就返回种别码，否就返回0；
		
		 */
		public int isKeyWords(String s) {
			int flag = 0;
			for (int i = 0; i < keyWords.length; i++) {
				if (keyWords[i].equals(s)) {
					flag = i + 1;
					break;
				}
			}
			return flag;
		}

		/**
		 
		 判断该字符是否为标识符或者关键字，是就返回种别码，否就返回0；
		
		 */
		public int isIdentifier(String s) {
			int flag = 0;
			// 当该字符串全为字母时；
			if (s.matches("[a-zA-Z]+")) {
				// 关键字
				if (isKeyWords(s) > 0) {
					flag = isKeyWords(s);
				}
				else {
					for (int i = 0; i < noIdentifier.length; i++) {
						// 该字符串为"true","false","null";
						if (noIdentifier[i].equals(s)) {
							flag = 99 + i;
							break;
						}
						flag = 97;
					}
				}
			}
			// 判断字符串首字符是否为"$","_"或者字母；
			else if (s.indexOf("$") == 0 || s.indexOf("_") == 0
					|| (s.charAt(0) >= 'a' && s.charAt(0) <= 'z' 
					|| s.charAt(0) >= 'A' && s.charAt(0) <= 'Z')) {
				// 遍历字符串；
				for (int i = 1; i < s.length(); i++) {
					// 检查字符串中是否存在不是标识符组成元素；
					if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z' 
							|| s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
							|| s.charAt(i) >= '0' && s.charAt(i) <= '9' 
							|| s.charAt(i) == '$' || s.charAt(i) == '_') {
						flag = 97;
					// 存在不为标识符组成元素，即刻跳出循环；
					} else {
						flag = 0;
						break;
					}
				}
			} 
			return flag;
		}
		
		/**
		 
		 打印分析结果（二元式序列组成的中间文件）；
		 */
		public void codePrinting(int a, String s) {
			System.out.println("<" + a + "," + s + ">");
		}
		
		/**
		 深层分析未能直接解析的字符串。
		 
		 */
		public void splitString(String s) {
			int num = -1;
			String[] str = s.split("");
			for (int i = 0; i < str.length; i++) {
				if (i <= num) {
					continue;
				}
				num = -1;
				// 判断是否存在运算符
				for (int j = 0; j < unaryOperation.length; j++) {
					// 当匹配到为单元运算符时
					if (unaryOperation[j].equals(str[i])) {
						// 判断是否到字符串结尾部分
						if (i + 1 < s.length()) {
							for (int l = 0; l < binaryOperation.length; l++) {
								// 当匹配到为双元运算符时
								if (binaryOperation[l].equals(s.substring(i, i + 2))) {
									// 判断是否到字符串结尾部分
									if (i + 2 < s.length()) {
										for (int m = 0; m < ternaryOperation.length; m++) {
											// 当匹配到三元运算符时
											if (ternaryOperation[m].equals(s.substring(i, i + 3))) {
												codePrinting(isOperation(s.substring(i, i + 3)), s.substring(i, i + 3));
												num = i + 2;
												break;
											}
										}
										// 不是三元运算符输出双元运算符
										if (num != i + 2) {
											codePrinting(isOperation(s.substring(i, i + 2)), s.substring(i, i + 2));
											num = i + 1;
											break;
										}
									// 字符串长度到底，直接输出双元运算符
									} else {
										codePrinting(isOperation(s.substring(i, i + 2)), s.substring(i, i + 2));
										num = i + 1;
										break;
									}
								}
							}
							// 当没有匹配到双元或者三元运算符时，输出单元运算符
							if (num == -1) {
								codePrinting(isOperation(str[i]), str[i]);
								num = 0;
								break;
							}
						// 字符串长度到底，直接输出单元运算符
						} else {
							codePrinting(isOperation(str[i]), str[i]);
							num = 0;
							break;
						}
					} 
				}
				// 判断是否匹配到运算符，匹配到时值不为-1
				if (num != -1) {
					continue;
				}
			
				// 判断是否为分界符
				if (isLimiterWords(str[i]) > 0) {
					codePrinting(isLimiterWords(str[i]), str[i]);
					continue;
				}
				// 判断是否存在数字
				else if(s.charAt(i) <= '9' && s.charAt(i) >= '0') {
					int n = i;
					for(int j=i+1; j<str.length;j++) {
						if(s.charAt(j) <= '9' && s.charAt(j) >= '0') {
							n = j;
						}else {
							break;
						}
					}
					if(n>i) {
						codePrinting(98, s.substring(i, n+1));
						num = n;
						continue;
					}else {
						codePrinting(98, str[i]);
						continue;
					}
				// 判断是否存在标识符
				// 当字符为"$"、"_"开头时
				} else if (str[i] == "$" || str[i] == "_") {
					int n = i;
					for (int j = i + 1; j < s.length(); j++) {
						if (str[j] == "$" || str[j] == "_" 
								|| s.charAt(j) >= 'a' && s.charAt(j) <= 'z'
								|| s.charAt(j) >= 'A' && s.charAt(j) <= 'Z'
								|| s.charAt(j) <= '9' && s.charAt(j) >= '0') {
							n = j;
						} else {
							break;
						}
					}
					if (n > i) {
						codePrinting(97, s.substring(i, n + 1));
						num = n;
						continue;
					} else {
						codePrinting(97, str[i]);
						continue;
					}
				// 判断是否存在标识符、特殊字符或者关键字
				// 当字符是字母开头时
				} else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' 
						|| s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
					int n = i;
					for(int j = i+1; j<s.length();j++) {
						if (s.charAt(j) >= 'a' && s.charAt(j) <= 'z' || s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') {
							n = j;
						}else {
							break;
						}
					}
					if (n > i) {
						// 关键字
						if (isKeyWords(s.substring(i, n + 1)) > 0) {
							codePrinting(isKeyWords(s.substring(i, n + 1)), s.substring(i, n + 1));
							num = n;
							continue;
						} else {
							// 特殊字符
							for (int j = 0; j < noIdentifier.length; j++) {
								if (noIdentifier[j].equals(s.substring(i, n + 1))) {
									codePrinting(99 + j, noIdentifier[j]);
									num = n;
									break;
								}
							}
						}
						if (num != n) {
							// 标识符
							codePrinting(97, s.substring(i, n + 1));
							num = n;
							continue;
						} else {
							continue;
						}
					} else {
						// 标识符
						codePrinting(97, str[i]);
						continue;
					}
				}else {
					System.out.println("<未知字符！,"+str[i]+">");
				}
			}
		}
		
		/**
		 * 
		
		 运行分析器；
		 */
		
		
		public void runLexer() {
			String[] str;
			//输入测试文件的路径；
			String path = "F:\\GitDepository\\lan-explore\\Java\\Spring\\SpringMVC\\SpringMVC\\SpringMVC-demo1\\src\\main\\java\\oct\\rekord\\mvc\\controller\\HelloController.java";
			try {
				FileReader fileReader = new FileReader(path);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String strLine = null; // 存储每行的文件信息
				int lineIndex = -1, num = 0, lastIndex = -1, firstIndex = -1;
				// 一行一行打印文件信息
				while ((strLine = bufferedReader.readLine()) != null) {
					// firstIndex多行注释开始符号“/*”位置
					firstIndex = strLine.indexOf("/*");
					// lastInedx多行注释结束符号“*/”位置
					lastIndex = strLine.indexOf("*/");
					// 等于0时，代表“/*”不存在，不需要匹配“*/”。
					if(num == 0) {
						if(firstIndex >= 0) {
							strLine = strLine.substring(0, firstIndex);
							num =1;
						} else {
							strLine = strLine.substring(0);
						}
					// 等于1时，代表“/*”已经存在，匹配“*/”。
					}else if (num == 1) {
						// 匹配不成功，跳出循环
						if(lastIndex < 0) {
							continue;
						// 匹配成功，重新赋值0
						}else {
							strLine = strLine.substring(lastIndex+2);
							num = 0;
						}
					}
					// 判断该行字符串是不是空格
					if (strLine.length() <= 0) {
						continue;
					}
					// 单行注释符的位置，index之后的为注释
					lineIndex = strLine.trim().indexOf("//");
					if (lineIndex < 0) {
						str = strLine.trim().split("[ \\t\\n\\x0B\\f\\r]");
					// 注释符在开头直接跳出循环
					} else if (lineIndex == 0) {
						continue;
					} else {
						str = strLine.trim().substring(0, lineIndex).split("[ \\t\\n\\x0B\\f\\r]");
					}
					
					for (int i = 0; i < str.length; i++) {
						// 输出分界符
						if (isLimiterWords(str[i]) > 0) {
							codePrinting(isLimiterWords(str[i]), str[i]);
						// 输出数字串
						} else if (isNum(str[i]) > 0) {
							codePrinting(isNum(str[i]), str[i]);
						// 输出运算符
						} else if (isOperation(str[i]) > 0) {
							codePrinting(isOperation(str[i]), str[i]);
						// 输出标识符和关键字
						} else if (isIdentifier(str[i]) > 0) {
							codePrinting(isIdentifier(str[i]), str[i]);
						// 其他暂时未识别的字符串
						} else {
							splitString(str[i]);
						}
					}
				}
				bufferedReader.close();
			}  
			catch (Exception e) {
				//输出异常
				System.out.println(e);
			}
		}
	
}
