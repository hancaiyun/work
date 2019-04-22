package com.nicehancy.work.common.utils;

import com.nicehancy.work.common.constant.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     fastdfs工具类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/19 9:14
 **/
@Slf4j
public class FastDFSUtil {
    //配置路径
    private static final String FASTDFS_CONFIG = "fdfs/fdfs.properties";

    /**
     * 初始化
     */
    @PostConstruct
    public static void init(){

        try{
            ClassLoader calssLoader = Thread.currentThread().getContextClassLoader();
            String path = calssLoader.getResource(FASTDFS_CONFIG).getPath();
            //ClientGlobal.init(path);
            log.info("FastDFS init success");
        }catch (Exception e){
            log.error("FastDFS init error, Exception:{}", e);
        }
    }

    /**
     * 上传文件到FastDFS服务器
     * @param filePath                  文件路径
     * @return                          远程返回的文件名称和group名称
     */
    public static Map<String, String> uploadStream(String filePath) {

        //初始化
        init();
        Map<String, String> dfsMap = new HashMap<String, String>();
        //TrackerServer trackerServer = null;
        //StorageServer storageServer = null;
        RandomAccessFile randomFile = null;
        try {
            //TrackerClient trackerClient = new TrackerClient();
            //trackerServer = trackerClient.getConnection();
            //StorageClient storageClient = new StorageClient(trackerServer, storageServer);

            File file = new File(filePath);
            //打开一个随机访问文件流，按读方式
            randomFile = new RandomAccessFile(file, "r");
            //文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件头
            randomFile.seek(0);

            byte[] buffer = new byte[(int) fileLength];

            randomFile.read(buffer);

            //上传文件
            //String[] results = storageClient.upload_file(buffer, CommonConstant.CSV_FORMAT, null);

            //if (results == null) {
            //    log.error("FastDFS上传错误，错误码:{}", storageClient.getErrorCode());
           // }

           // dfsMap.put(CommonConstant.DFS_GROUP_NAME_KEY, results[0]);
            //dfsMap.put(CommonConstant.DFS_REMOTE_FILE_NAME_KEY, results[1]);

            log.info("file upload to FastDFS success");
        } catch (Exception e) {
            log.error("FastDFS上传错误:{}" , e);
        } finally {
            //关闭连接
            //closeTrackerServer(trackerServer);
            //关闭文件访问流
            try {
                if(randomFile != null) {
                    randomFile.close();
                }
            }catch (Exception e){
                log.debug("randomFile close fail, information：{}", e);
            }
        }
        return dfsMap;
    }

    /**
     * 下载文件(文件删除测试用)
     *
     * @param groupName         下载组，默认为Group1
     * @param remoteFilename    DFS上面的文件名
     * @param localFileName     下载到本地的文件名
     * @return int              文件下载结果
     */
    public static int download(String groupName, String remoteFilename, String localFileName) {
        int result = -1;
        //TrackerServer trackerServer = null;
        init();
        try {
            //TrackerClient trackerClient = new TrackerClient();
            //trackerServer = trackerClient.getConnection();
            //StorageClient storageClient = new StorageClient(trackerServer, null);
            // 下载文件
            groupName = StringUtils.isEmpty(groupName) ? "group1" : groupName;
           // result = storageClient.download_file(groupName, remoteFilename, localFileName);
            System.out.println("download result: group_name:" + groupName);
            System.out.println("remoteFilename:" + remoteFilename);
            System.out.println("localFileName:" + localFileName);
            System.out.println("download success");
        } catch (Exception e) {
            System.out.println("下载文件失败， remoteFilename:" + remoteFilename);
            System.out.println("localFileName:" + localFileName);
            e.printStackTrace();
        } finally {
            ///closeTrackerServer(trackerServer);
        }
        return result;
    }

    /**
     * 删除文件
     *
     * @param groupName         组名
     * @param remoteFilename    文件名
     * @return                  执行结果
     */
    public static int delete(String groupName, String remoteFilename) {

        //初始化
        init();
        int result = -1;
        //TrackerServer trackerServer = null;
        try {
            //TrackerClient trackerClient = new TrackerClient();
           // trackerServer = trackerClient.getConnection();
            //StorageClient storageClient = new StorageClient(trackerServer, null);
            //删除文件
            groupName = StringUtils.isEmpty(groupName) ? "group1" : groupName;
            //result = storageClient.delete_file(groupName, remoteFilename);
        } catch (Exception e) {
            log.error("删除文件失败， remoteFilename:" + remoteFilename);
        } finally {
            //closeTrackerServer(trackerServer);
        }
        return result;
    }

    /**
     * 关闭FastDFS连接
     * @param trackerServer             FastDFS连接
     */
//    private static void closeTrackerServer(TrackerServer trackerServer) {
//
//        try {
//            if(trackerServer != null) {
//                trackerServer.close();
//            }
//        } catch (IOException e) {
//            log.error("FastDFS连接关闭失败,失败信息:{}", e);
//        }
//    }

    /**
     * 关闭数据服务
     *
     * @param storageServer storageServer数据服务
     */
//    public void closeStorageServer(StorageServer storageServer) {
//        // 退出前,一定要将数据服务关闭
//        try {
//            if (storageServer != null)
//                storageServer.close();
//        } catch (Exception e) {
//            System.out.println("关闭数据服务异常");
//            e.printStackTrace();
//        }
//    }

    /**
     * 关闭DFS服务
     *
     * @param trackerServer 队列服务
     * @param storageServer 数据服务
     */
//    public void closeDFSServer(TrackerServer trackerServer, StorageServer storageServer) {
//        try {
//            closeTrackerServer(trackerServer);
//            closeStorageServer(storageServer);
//        } catch (Exception ioe) {
//            System.out.println("DFS关闭连接异常:" + ioe.getStackTrace());
//        }
//    }
}