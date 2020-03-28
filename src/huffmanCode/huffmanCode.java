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
		 * //����ѹ���ļ����� 
		 * String srcFile = "e://test.png";
		 *  String dstFile = "e://test.zip";
		 * zipFile(srcFile,dstFile);
		 * 
		 * System.out.println("ѹ���ļ��ɹ���");
		 */
		
		//���Խ�ѹ�ļ�
		String zipFile = "e://test.zip";
		String dstFile="e://005.png";
		unZipFile(zipFile,dstFile);
		System.out.println("�ļ���ѹ�ɹ���");
		
		
		/*
		String content = "i like like like java do you like a java";
		byte[] contentByte = content.getBytes();
		System.out.println(contentByte.length);

		byte[] heffmanCodesBytes = huffmanzip(contentByte);
		System.out.println("ѹ����Ľ���ǣ�"+Arrays.toString(heffmanCodesBytes));
		
		//����һ��byteToByteString����
		//System.out.println("str="+byteToByteString((byte)-1));
		
		byte[] sourceBytes = decode(huffmanCodes,heffmanCodesBytes);
		System.out.println("ԭ�����ַ���="+new String(sourceBytes));
		
		*/
		
		
		//�ֲ�����
		/*
		List<Node> nodes = getNodes(contentByte);
		System.out.println("nodes��" + nodes);

		// ����һ�Ѵ����Ķ�����
		System.out.println("�շ�����");
		Node huffmanTreeRoot = createHuffmanTree(nodes);
		System.out.println("ǰ�����~~~");
		huffmanTreeRoot.preOrder();
		
		//�����Ƿ����ɶ�Ӧ�Ĺ���������
		Map<Byte,String> huffmanCode =getCodes(huffmanTreeRoot);
		System.out.println("���ɵĹ����������"+huffmanCode);
		
		//����
		byte[] huffmanCodeBytes= zip(contentByte,huffmanCode);
		System.out.println("huffmanCodeBytes��"+Arrays.toString(huffmanCodeBytes));
		
		//����huffmanCodeBytes����
	
		 */

	}
	
	//��дһ����������ɶ���ѹ���ļ��Ľ�ѹ
	public static void unZipFile(String zipFile,String dstFile) {
		//����һ���ļ�������
		InputStream is = null;
		//����һ������������
		ObjectInputStream ois = null;
		//�����ļ��������
		OutputStream os = null;
		try {
			//�����ļ���������
			is = new FileInputStream(zipFile);
			//����һ����is�����Ķ���������
			ois = new ObjectInputStream(is);
			//��ȡbyte����
			byte[] huffmanBytes = (byte[])ois.readObject();
			//��ȡ�շ��������
			Map<Byte,String> huffmancodes = (Map<Byte,String>)ois.readObject();
			
			//����
			byte[] bytes = decode(huffmancodes,huffmanBytes);
			//��bytesд�뵽Ŀ���ļ�
			os = new FileOutputStream(dstFile);
			//д���ݵ��ļ���
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
	
	//��дһ����������һ���ļ�����ѹ��
	/**
	 * 
	 * @param srcFile	�����ϣ��ѹ�����ļ�·��
	 * @param dstFile	ѹ���ļ�������ĸ�Ŀ¼
	 */
	public static void zipFile(String srcFile,String dstFile) {
		
		//���������
		OutputStream os = null;
		ObjectOutputStream oos =null;
		//����һ���ļ���������
		FileInputStream is =null;
		try {
		    is =new FileInputStream(srcFile);
			//����һ����Դ�ļ�һ��С��byte[]
			byte[] b= new byte[is.available()];
			//��ȡ�ļ�
			is.read(b);
			//ʹ�úշ���������б��룬��ȡ���ļ���Ӧ�ĺշ��������
			byte[] heffmanBytes = huffmanzip(b);
			//�����ļ�������������ѹ���ļ�
			 os=new FileOutputStream(dstFile);
			//����һ�����ļ������������objectOutputStream
			 oos =new  ObjectOutputStream(os);
			
			 oos.writeObject(heffmanBytes);
			 
			 //���������Զ������ķ�ʽд��շ������룬Ϊ���Ժ�ظ�Դ�ļ���ʱʹ��
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
	
	

	//������ݵĽ�ѹ
	//˼·��
	//1.��huffmanCodeBytes��[-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
	//	ת�ɺշ�����Ӧ�Ķ������ַ���"1010101011"
	//2.���շ�����Ӧ�Ķ������ַ������պշ�������ת�ɡ�i like like like java do you like a java��
	
	
	//��дһ����������ɶ�ѹ�����ݵĽ���
	/**
	 * 
	 * @param huffmanCodes 	�����������
	 * @param huffmanBytes	�����������[-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
	 * @return	ԭ���ַ�����Ӧ������
	 */
	private static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes) {
		
		//1.�ȵõ�huffmanBytes��Ӧ���ַ���
		StringBuilder stringBuilder = new StringBuilder();
		//��byte����ת�ɶ������ַ���
		for(int i = 0;i<huffmanBytes.length;i++) {
			byte b = huffmanBytes[i];
			//�ж��ǲ������һ���ֽ�
			boolean flag = (i == huffmanBytes.length-1);
			stringBuilder.append(byteToByteString(!flag,b));
		}
		
		//���ַ�������ָ���ĺշ���������н���
		//�Ѻշ����������б任����Ϊ�����ѯ
		Map<String,Byte> map = new HashMap<String,Byte>();
		for(HashMap.Entry<Byte,String> entry:huffmanCodes.entrySet()) {
			map.put(entry.getValue(),entry.getKey());
		}


		//����һ�����ϣ����byte
		List<Byte> list=new ArrayList<>();
		for(int i = 0;i<stringBuilder.length();) {
			//
			int count = 1;//С�ļ�����
			boolean flag = true;
			Byte b =null;
			while(flag) {
				//ȡ��һ��1����0
				String key = stringBuilder.substring(i,i+count);//i��������count�ƶ���ָ��ƥ�䵽һ���ַ�
				b = map.get(key);
				if(b ==null) {//˵��û��ƥ�䵽
					count++;
				}else {
					//ƥ�䵽
					flag= false;
				}
			}
			list.add(b);
			i += count;//iֱ���ƶ���countλ��
		}
		
		//��forѭ������������list�д�������е��ַ�
		//��list�е����ݷ��뵽һ��byte[] ������
		byte[] b = new byte[list.size()];
		for(int i=0;i<b.length;i++) {
			b[i] = list.get(i);
		}
		return b;
		
	}
	/**
	 * ��һ��byteת�ɶ����Ƶ��ַ���
	 * @param b
	 * @return flag	��ʾ��Ҫ����λ,������һ���ֽ����貹��λ
	 * @return	���ص��Ǹ�b��Ӧ�Ķ����Ƶ��ַ�����ע�����Բ���ķ�ʽ���أ�
	 * 
	 */
	private static String byteToByteString(boolean flag,byte b) {
		
		//ʹ��һ����������b
		int temp =b;//ת����b
		//��������������ڲ���λ������
		if(flag) {
			temp |= 256;//��λ��
		}
		
		String str = Integer.toBinaryString(temp);//���ص���temp��Ӧ�Ķ����Ʋ���
		if(flag) {
			return str.substring(str.length()-8);
		}else {
			return str;
		}
		
	}
	
	//ʹ��һ��������ǰ��ķ�����װ�����ڵ���
	/**
	 * 
	 * @param bytes	ԭʼ���ַ�����Ӧ���ֽ�����
	 * @return	�����շ������봦�����ֽ�����
	 */
	private static byte[] huffmanzip(byte[] bytes) {
		List<Node> nodes = getNodes(bytes);
		//����nodes�����շ�����
		Node huffmanTreeRoot = createHuffmanTree(nodes);
		//���ɶ�Ӧ�Ĺ���������
		Map<Byte,String> huffmanCode =getCodes(huffmanTreeRoot);
		//�������ɵĺշ�������ѹ�����õ�ѹ����ĺշ��������ֽ�����
		byte[] huffmanCodeBytes= zip(bytes,huffmanCode);
		
		return huffmanCodeBytes;
		
		
	}
	
	//��дһ����������һ���ַ�����Ӧ��byte[]���飬ͨ�����ɵĺշ�������䣬����һ���շ�������ѹ���е�����
	/**
	 * 
	 * @param bytes	ԭʼ�ַ�����Ӧbyte����
	 * @param huffmanCodes	���ɵĺշ�������map
	 * @return	���غշ������봦����byte[]
	 * 
	 */
	private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes) {
		
		//1.�����úշ��������bytesת�ɺշ��������Ӧ���ַ���
		StringBuilder stringBuilder = new StringBuilder();
		//����bytes����
		for(byte b:bytes) {
			stringBuilder.append(huffmanCodes.get(b));
		}
		
		//System.out.println("���ԣ�"+stringBuilder.toString());
		
		//ͳ�Ʒ��ص�huffmanCodesBytes����
		int len;
		if(stringBuilder.length() % 8 ==0) {
			len = stringBuilder.length() / 8;
		}else {
			len = stringBuilder.length() / 8 + 1;
		}
		
		//����һ���洢ѹ�����byte����
		byte[] huffmanCodeBytes = new byte[len];
		int index = 0;//��¼�ǵڼ���byte
		for(int i = 0;i < stringBuilder.length();i+=8) {//��Ϊÿ8λ��Ӧһ��byte�����Բ���Ϊ8
			String strByte;
			if(i+8 >stringBuilder.length()) {//����8λ
				strByte = stringBuilder.substring(i);
			}else {
				strByte = stringBuilder.substring(i,i+8);
			}
			
			//��strByteת��byte����,�ŵ�huffmanCodeBytes
			huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte,2);
			index++;
		}
		return huffmanCodeBytes;
	}
	
	//���ɺշ�������Ӧ�ĺշ�������
	//˼·��
	//1.���շ�����������һ��Map��<Byte,string>����ʽ
	//=01 a=100 d=11000 u=11001 e=1110 v=11011 i=101 y=11010 j=0010 k=1111 l=000 o=0011
	static Map<Byte,String> huffmanCodes = new HashMap<Byte,String>();
	//2.�����ɺշ���������ʱ����Ҫȥƴ��·��������һ��stringBulider�洢ĳ��Ҷ�ӽ���·��
	static StringBuilder stringBulider = new StringBuilder();
	
	//Ϊ�˵��÷��㣬��������getCodes()
	private static Map<Byte,String> getCodes(Node root){
		if(root == null) {
			return null;
		}
		//����������
		getCodes(root.left,"0",stringBulider);
		//����������
		getCodes(root.right,"1",stringBulider);
		
		return huffmanCodes;
	}
	/**
	 * 	���ܣ�����ͼ��node�Ľ�������Ҷ�ӽ��ĺշ�������õ��������뵽huffmanCodes
	 * @param node	����Ľ��
	 * @param code ·��:���ӽڵ�Ϊ0�����ӽڵ�Ϊ1
	 * @param stringBulider	����ƴ��·��
	 */
	private static void getCodes(Node node,String code,StringBuilder stringBulider ) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBulider);
		//��code���뵽stringBuilder2
		stringBuilder2.append(code);
		if(node !=null) {//���node ==null������
			//�жϵ�ǰnode��Ҷ�ӽ�㻹�Ƿ�Ҷ�ӽ��
			if(node.data ==null) {//��Ҷ�ӽ��
				//�ݹ鴦��
				//����ݹ�
				getCodes(node.left,"0",stringBuilder2);
				//���ҵݹ�
				getCodes(node.right,"1",stringBuilder2);
			}else {//˵����Ҷ�ӽ��
				//��ʾ���ҵ���ĳ��Ҷ�ӽ������
				huffmanCodes.put(node.data,stringBuilder2.toString());
				
			}
		}
	}
	// ǰ������ķ���
	private static void preOrder(Node root) {
		if (root != null) {
			root.preOrder();
		} else {
			System.out.println("�շ�����Ϊ�գ�");
		}
	}

	/**
	 * 
	 * @param bytes �����ַ�����
	 * @return ����list ��ʽ [Node[date=97 ,weight = 5], Node[]date=32,weight =
	 *         9]......]
	 */
	private static List<Node> getNodes(byte[] bytes) {
		// 1.����һ��ArrayList
		ArrayList<Node> nodes = new ArrayList();

		// 2.����bytes��ͨͳ��ÿ��byte���ֵĴ���-��map[key,value]
		Map<Byte, Integer> counts = new HashMap<>();
		for (byte b : bytes) {
			Integer count = counts.get(b);
			if (count == null) {// map��û���ַ�����
				counts.put(b, 1);
			} else {
				counts.put(b, count + 1);
			}
		}

		// ��ÿ����ֵ��ת��һ��node���󣬲����뵽Node����
		// ����map
		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}

		return nodes;
	}

	// ����ͨ��List������Ӧ�ĺշ�����
	private static Node createHuffmanTree(List<Node> nodes) {
		// ���򣬴�С����
		while (nodes.size() > 1) {
			Collections.sort(nodes);
			// ȡ����һ����С�Ķ�����
			Node leftNode = nodes.get(0);
			// ȡ���ڶ�����С�Ķ�����
			Node rightNode = nodes.get(1);

			// ����һ���µĶ�����
			// ���ĸ����û��data��ֻ��Ȩֵ
			Node parent = new Node(null, leftNode.weight + rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;

			// ���������Ķ�������Nodeɾ��
			nodes.remove(leftNode);
			nodes.remove(rightNode);

			// ���µĶ��������뵽nodes
			nodes.add(parent);

		}
		// ���ؽ�㣬���Ľ����ǹ��������ĸ��ڵ�
		return nodes.get(0);
	}

}



//����Node�������ݺ�Ȩֵ
class Node implements Comparable<Node> {
	Byte data;// �������
	int weight;// Ȩֵ����ʾ���ݵĳ��ִ���
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

	// ǰ�����
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
