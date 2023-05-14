package cn.llynsyw.bigdata.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.permission.FsPermission;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;


/**
 * HadoopClient
 *
 * @author luolinyuan
 * @date 2023/1/17
 **/
public class HadoopClient {
	private FileSystem fs;
	public static final String NAME_NODE_URI = "hdfs://hadoop101:8020";
	public static final String USER_NAME = "root";

	@Before
	public void init() throws URISyntaxException, IOException, InterruptedException {
	// 连接NameNode地址URI
		URI uri = new URI(NAME_NODE_URI);
		// 创建配置类
		Configuration config = new Configuration();
		fs = FileSystem.get(uri, config, USER_NAME);
	}

	@After
	public void destroy() throws IOException {
		fs.close();
	}

	@Test
	public void testMkdir() throws IOException {
		fs.mkdirs(new Path("/test"), new FsPermission(777));
	}

	@Test
	/*
	* 配置文件优先级：
	*   Configuration > resources/hdfs-site.xml > etc/hadoop/hdfs-site.xml > hdfs-default.xml
	* */
	public void testPut() throws IOException {
		fs.copyFromLocalFile(false, false,
				new Path("put-file.txt"), new Path("/test"));
	}

	@Test
	public void testWrite() throws IOException {
		FSDataOutputStream out = fs.create(new Path("/test/write.txt"));
		out.write("hello world!".getBytes(StandardCharsets.UTF_8));
		out.close();
	}

	@Test
	public void testGet() throws IOException {
		fs.copyToLocalFile(false, new Path("/test/write.txt"), new Path("download.txt"),false );
	}

	@Test
	public void testRm() throws IOException {

		// 删除空目录
		//fs.delete(new Path("/xiyou"), false);

		// 删除非空目录
		fs.delete(new Path("/jinguo"), true);
	}

	// 文件的更名和移动
	@Test
	public void testmv() throws IOException {
		// 参数解读：参数1 ：原文件路径； 参数2 ：目标文件路径
		// 对文件名称的修改
		//fs.rename(new Path("/input/word.txt"), new Path("/input/ss.txt"));

		// 文件的移动和更名
		//fs.rename(new Path("/input/ss.txt"),new Path("/cls.txt"));

		// 目录更名
		fs.rename(new Path("/input"), new Path("/output"));

	}

	// 获取文件详细信息
	@Test
	public void fileDetail() throws IOException {

		// 获取所有文件信息
		RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);

		// 遍历文件
		while (listFiles.hasNext()) {
			LocatedFileStatus fileStatus = listFiles.next();

			System.out.println("==========" + fileStatus.getPath() + "=========");
			System.out.println(fileStatus.getPermission());
			System.out.println(fileStatus.getOwner());
			System.out.println(fileStatus.getGroup());
			System.out.println(fileStatus.getLen());
			System.out.println(fileStatus.getModificationTime());
			System.out.println(fileStatus.getReplication());
			System.out.println(fileStatus.getBlockSize());
			System.out.println(fileStatus.getPath().getName());

			// 获取块信息
			BlockLocation[] blockLocations = fileStatus.getBlockLocations();

			System.out.println(Arrays.toString(blockLocations));

		}
	}

	// 判断是文件夹还是文件
	@Test
	public void testFile() throws IOException {

		FileStatus[] listStatus = fs.listStatus(new Path("/"));

		for (FileStatus status : listStatus) {

			if (status.isFile()) {
				System.out.println("文件：" + status.getPath().getName());
			} else {
				System.out.println("目录：" + status.getPath().getName());
			}
		}
	}

}
