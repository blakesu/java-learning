package zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * Created by sublake on 16/2/6.
 */
public class Main{

        public static void main(String[] args) throws Exception {
            String path = "/test_path";
            CuratorFramework client = CuratorFrameworkFactory.builder().connectString("192.168.2.155:2181").namespace("brokers").retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 1000)).connectionTimeoutMs(5000).build();
            // 启动 上面的namespace会作为一个最根的节点在使用时自动创建
            client.start();

            // 创建一个节点
            //client.create().forPath("/head", new byte[0]);

            // 异步地删除一个节点
            //client.delete().inBackground().forPath("/head");

            // 创建一个临时节点
            //client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/head/child", new byte[0]);

            // 取数据
            //client.getData().watched().inBackground().forPath("/test");

            // 检查路径是否存在
            //client.checkExists().forPath(path);

            // 异步删除
            //client.delete().inBackground().forPath("/head");


            // 注册观察者，当节点变动时触发

                client.getData().usingWatcher(new Watcher() {

                    public void process(WatchedEvent event) {
                        System.out.println("node is changed");

                    }
                }).inBackground().forPath("/test");

            // 结束使用
            //client.close();

            while(true){

            }
        }

}
