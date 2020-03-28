package huffmanCode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class huffmanCode {

	private static final boolean String = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * //测试压缩文件代码 
		 * String srcFile = "e://test.png";
		 *  String dstFile = "e://test.zip";
		 * zipFile(srcFile,dstFile);
		 * 
		 * System.out.println("压缩文件成功！");
		 */
		
		//测试解压文件
		String zipFile = "e://test.zip";
		String dstFile="e://005.png";
		unZipFile(zipFile,dstFile);
		System.out.println("文件解压成功！");
		
		
		/*
		String content = "i like like like java do you like a java";
		byte[] contentByte = content.getBytes();
		System.out.println(contentByte.length);

		byte[] heffmanCodesBytes = huffmanzip(contentByte);
		System.out.println("压缩后的结果是："+Arrays.toString(heffmanCodesBytes));
		
		//测试一把byteToByteString方法
		//System.out.println("str="+byteToByteString((byte)-1));
		
		byte[] sourceBytes = decode(huffmanCodes,heffmanCodesBytes);
		System.out.println("原来的字符串="+new String(sourceBytes));
		
		*/
		
		
		//分步过程
		/*
		List<Node> nodes = getNodes(contentByte);
		System.out.println("nodes：" + nodes);

		// 测试一把创建的二叉树
		System.out.println("赫夫曼树");
		Node huffmanTreeRoot = createHuffmanTree(nodes);
		System.out.println("前序遍历~~~");
		huffmanTreeRoot.preOrder();
		
		//测试是否生成对应的哈夫曼编码
		Map<Byte,String> huffmanCode =getCodes(huffmanTreeRoot);
		System.out.println("生成的哈夫曼编码表："+huffmanCode);
		
		//测试
		byte[] huffmanCodeBytes= zip(contentByte,huffmanCode);
		System.out.println("huffmanCodeBytes："+Arrays.toString(huffmanCodeBytes));
		
		//发送huffmanCodeBytes数组
	
		 */

	}
	
	//编写一个方法，完成对于压缩文件的解压
	public static void unZipFile(String zipFile,String dstFile) {
		//定义一个文件输入流
		InputStream is = null;
		//定义一个对象输入流
		ObjectInputStream ois = null;
		//定义文件的输出流
		OutputStream os = null;
		try {
			//创建文件的输入流
			is = new FileInputStream(zipFile);
			//创建一个和is关联的对象输入流
			ois = new ObjectInputStream(is);
			//读取byte数组
			byte[] huffmanBytes = (byte[])ois.readObject();
			//读取赫夫曼编码表
			Map<Byte,String> huffmancodes = (Map<Byte,String>)ois.readObject();
			
			//解码
			byte[] bytes = decode(huffmancodes,huffmanBytes);
			//将bytes写入到目标文件
			os = new FileOutputStream(dstFile);
			//写数据到文件中
			os.write(bytes);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			try {
				
			os.close();
			ois.close();
			is.close();
			
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
		}
		
	}
	
	//编写一个方法，将一个文件进行压缩
	/**
	 * 
	 * @param srcFile	传入的希望压缩的文件路径
	 * @param dstFile	压缩文件输出到哪个目录
	 */
	public static void zipFile(String srcFile,String dstFile) {
		
		//创建输出流
		OutputStream os = null;
		ObjectOutputStream oos =null;
		//创建一个文件的输入流
		FileInputStream is =null;
		try {
		    is =new FileInputStream(srcFile);
			//创建一个和源文件一大小的byte[]
			byte[] b= new byte[is.available()];
			//读取文件
			is.read(b);
			//使用赫夫曼编码进行编码，获取到文件对应的赫夫曼编码表
			byte[] heffmanBytes = huffmanzip(b);
			//创建文件的输出流，存放压缩文件
			 os=new FileOutputStream(dstFile);
			//创建一个和文件输出流关联的objectOutputStream
			 oos =new  ObjectOutputStream(os);
			
			 oos.writeObject(heffmanBytes);
			 
			 //这里我们以对象流的方式写入赫夫曼编码，为了以后回复源文件的时使用
			 oos.writeObject(huffmanCodes);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			try {
				is.close();
				oos.close();
				os.close();
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	

	//完成数据的解压
	//思路：
	//1.将huffmanCodeBytes：[-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
	//	转成赫夫曼对应的二进制字符串"1010101011"
	//2.将赫夫曼对应的二进制字符串对照赫夫曼编码转成“i like like like java do you like a java”
	
	
	//编写一个方法，完成对压缩数据的解码
	/**
	 * 
	 * @param huffmanCodes 	哈夫曼编码表
	 * @param huffmanBytes	处理过的数组[-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
	 * @return	原来字符串对应的数组
	 */
	private static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes) {
		
		//1.先得到huffmanBytes对应的字符串
		StringBuilder stringBuilder = new StringBuilder();
		//将byte数组转成二进制字符串
		for(int i = 0;i<huffmanBytes.length;i++) {
			byte b = huffmanBytes[i];
			//判断是不是最后一个字节
			boolean flag = (i == huffmanBytes.length-1);
			stringBuilder.append(byteToByteString(!flag,b));
		}
		
		//把字符串按照指定的赫夫曼编码进行解码
		//把赫夫曼编码表进行变换，因为反向查询
		Map<String,Byte> map = new HashMap<String,Byte>();
		for(HashMap.Entry<Byte,String> entry:huffmanCodes.entrySet()) {
			map.put(entry.getValue(),entry.getKey());
		}


		//创建一个集合，存放byte
		List<Byte> list=new ArrayList<>();
		for(int i = 0;i<stringBuilder.length();) {
			//
			int count = 1;//小的计数器
			boolean flag = true;
			Byte b =null;
			while(flag) {
				//取出一个1或者0
				String key = stringBuilder.substring(i,i+count);//i不动，让count移动，指定匹配到一个字符
				b = map.get(key);
				if(b ==null) {//说明没有匹配到
					count++;
				}else {
					//匹配到
					flag= false;
				}
			}
			list.add(b);
			i += count;//i直接移动到count位置
		}
		
		//当for循环结束后我们list中存放了所有的字符
		//把list中的数据放入到一个byte[] 并返回
		byte[] b = new byte[list.size()];
		for(int i=0;i<b.length;i++) {
			b[i] = list.get(i);
		}
		return b;
		
	}
	/**
	 * 将一个byte转成二进制的字符串
	 * @param b
	 * @return flag	表示需要补高位,如果最后一个字节无需补高位
	 * @return	返回的是改b对应的二进制的字符串（注意是以补码的方式返回）
	 * 
	 */
	private static String byteToByteString(boolean flag,byte b) {
		
		//使用一个变量保存b
		int temp =b;//转换成b
		//如果是正数还存在补高位的问题
		if(flag) {
			temp |= 256;//按位与
		}
		
		String str = Integer.toBinaryString(temp);//返回的是temp对应的二进制补码
		if(flag) {
			return str.substring(str.length()-8);
		}else {
			return str;
		}
		
	}
	
	//使用一个方法吧前面的方法封装，便于调用
	/**
	 * 
	 * @param bytes	原始的字符串对应的字节数组
	 * @return	经过赫夫曼编码处理后的字节数组
	 */
	private static byte[] huffmanzip(byte[] bytes) {
		List<Node> nodes = getNodes(bytes);
		//根据nodes创建赫夫曼树
		Node huffmanTreeRoot = createHuffmanTree(nodes);
		//生成对应的哈夫曼编码
		Map<Byte,String> huffmanCode =getCodes(huffmanTreeRoot);
		//根据生成的赫夫曼编码压缩，得到压缩后的赫夫曼编码字节数组
		byte[] huffmanCodeBytes= zip(bytes,huffmanCode);
		
		return huffmanCodeBytes;
		
		
	}
	
	//编写一个方法，将一个字符串对应的byte[]数组，通过生成的赫夫曼编码变，返回一个赫夫曼编码压缩有的数组
	/**
	 * 
	 * @param bytes	原始字符串对应byte数组
	 * @param huffmanCodes	生成的赫夫曼编码map
	 * @return	返回赫夫曼编码处理后的byte[]
	 * 
	 */
	private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes) {
		
		//1.先利用赫夫曼编码表将bytes转成赫夫曼编码对应的字符串
		StringBuilder stringBuilder = new StringBuilder();
		//遍历bytes数组
		for(byte b:bytes) {
			stringBuilder.append(huffmanCodes.get(b));
		}
		
		//System.out.println("测试："+stringBuilder.toString());
		
		//统计返回的huffmanCodesBytes长度
		int len;
		if(stringBuilder.length() % 8 ==0) {
			len = stringBuilder.length() / 8;
		}else {
			len = stringBuilder.length() / 8 + 1;
		}
		
		//创建一个存储压缩后的byte数组
		byte[] huffmanCodeBytes = new byte[len];
		int index = 0;//记录是第几个byte
		for(int i = 0;i < stringBuilder.length();i+=8) {//因为每8位对应一个byte，所以步长为8
			String strByte;
			if(i+8 >stringBuilder.length()) {//不够8位
				strByte = stringBuilder.substring(i);
			}else {
				strByte = stringBuilder.substring(i,i+8);
			}
			
			//将strByte转成byte数组,放到huffmanCodeBytes
			huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte,2);
			index++;
		}
		return huffmanCodeBytes;
	}
	
	//生成赫夫曼树对应的赫夫曼编码
	//思路：
	//1.将赫夫曼编码表放在一个Map中<Byte,string>，形式
	//=01 a=100 d=11000 u=11001 e=1110 v=11011 i=101 y=11010 j=0010 k=1111 l=000 o=0011
	static Map<Byte,String> huffmanCodes = new HashMap<Byte,String>();
	//2.在生成赫夫曼编码表的时候需要去拼接路径，定义一个stringBulider存储某个叶子结点的路径
	static StringBuilder stringBulider = new StringBuilder();
	
	//为了调用方便，我们重载getCodes()
	private static Map<Byte,String> getCodes(Node root){
		if(root == null) {
			return null;
		}
		//处理左子树
		getCodes(root.left,"0",stringBulider);
		//处理右子树
		getCodes(root.right,"1",stringBulider);
		
		return huffmanCodes;
	}
	/**
	 * 	功能：将传图的node的结点的所有叶子结点的赫夫曼编码得到，并放入到huffmanCodes
	 * @param node	传入的结点
	 * @param code 路径:左子节点为0，右子节点为1
	 * @param stringBulider	用于拼接路径
	 */
	private static void getCodes(Node node,String code,StringBuilder stringBulider ) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBulider);
		//将code加入到stringBuilder2
		stringBuilder2.append(code);
		if(node !=null) {//如果node ==null不处理
			//判断当前node是叶子结点还是非叶子结点
			if(node.data ==null) {//非叶子结点
				//递归处理
				//向左递归
				getCodes(node.left,"0",stringBuilder2);
				//向右递归
				getCodes(node.right,"1",stringBuilder2);
			}else {//说明是叶子结点
				//表示就找到了某个叶子结点的最后
				huffmanCodes.put(node.data,stringBuilder2.toString());
				
			}
		}
	}
	// 前序遍历的方法
	private static void preOrder(Node root) {
		if (root != null) {
			root.preOrder();
		} else {
			System.out.println("赫夫曼树为空！");
		}
	}

	/**
	 * 
	 * @param bytes 接收字符数组
	 * @return 返回list 形式 [Node[date=97 ,weight = 5], Node[]date=32,weight =
	 *         9]......]
	 */
	private static List<Node> getNodes(byte[] bytes) {
		// 1.创建一个ArrayList
		ArrayList<Node> nodes = new ArrayList();

		// 2.遍历bytes，通统计每个byte出现的次数-》map[key,value]
		Map<Byte, Integer> counts = new HashMap<>();
		for (byte b : bytes) {
			Integer count = counts.get(b);
			if (count == null) {// map还没有字符数据
				counts.put(b, 1);
			} else {
				counts.put(b, count + 1);
			}
		}

		// 把每个键值对转成一个node对象，并加入到Node集合
		// 遍历map
		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}

		return nodes;
	}

	// 可以通过List创建对应的赫夫曼树
	private static Node createHuffmanTree(List<Node> nodes) {
		// 排序，从小到大
		while (nodes.size() > 1) {
			Collections.sort(nodes);
			// 取出第一棵最小的二叉树
			Node leftNode = nodes.get(0);
			// 取出第二棵最小的二叉树
			Node rightNode = nodes.get(1);

			// 创建一棵新的二叉树
			// 他的更结点没有data，只有权值
			Node parent = new Node(null, leftNode.weight + rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;

			// 将处理过后的二叉树从Node删除
			nodes.remove(leftNode);
			nodes.remove(rightNode);

			// 将新的二叉树加入到nodes
			nodes.add(parent);

		}
		// 返回结点，最后的结点就是哈夫曼树的根节点
		return nodes.get(0);
	}

}



//创建Node，带数据和权值
class Node implements Comparable<Node> {
	Byte data;// 存放数据
	int weight;// 权值，表示数据的出现次数
	Node left;
	Node right;

	public Node(Byte data, int weight) {
		super();
		this.data = data;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}

	// 前序遍历
	public void preOrder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}

}
