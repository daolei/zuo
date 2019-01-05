package champter1;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by daolei.su on 2018/11/24
 */
public class CuratorHelloworld {
    private static final String CONNECT_ADDR = "127.0.0.1:2181";
    private static final int SESSION_TIMEOUT = 5000;

    public static void main(String[] args) throws Exception {
        RetryPolicy policy = new ExponentialBackoffRetry(1000, 10);
        CuratorFramework curator = CuratorFrameworkFactory.builder().connectString(CONNECT_ADDR).sessionTimeoutMs(SESSION_TIMEOUT).retryPolicy(policy).build();

        curator.start();
        call c = new call();
        ExecutorService executor = Executors.newCachedThreadPool();
        curator.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL)
                .forPath("/super", "c1内容".getBytes());
        Thread.sleep(5000); //为了能够看到回调信息
        String data = new String(curator.getData().forPath("/super")); //获取节点数据
        System.out.println(data);
        Stat stat = curator.checkExists().forPath("/super"); //判断指定节点是否存在
        System.out.println(stat);
        curator.setData().forPath("/super", "c1新内容".getBytes()); //更新节点数据
        data = new String(curator.getData().forPath("/super/c1"));
        System.out.println("date:" + data);
        List<String> children = curator.getChildren().forPath("/super"); //获取子节点
        for (String child : children) {
            System.out.println(child);
        }

        try {
            curator.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/super", "c1".getBytes());
        }catch (KeeperException.UnimplementedException e){
            System.out.println("node exits!");
        }
        System.out.println("start to sleep");

      //  Thread.sleep(100000);

        //放心的删除节点，deletingChildrenIfNeeded()方法表示如果存在子节点的话，同时删除子节点
        System.out.println("end to sleep");

  //      curator.delete().guaranteed().deletingChildrenIfNeeded().forPath("/super");


        curator.close();


    }
}

class call implements BackgroundCallback{

    @Override
    public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
        if (curatorEvent.getResultCode() != 0 ) {
            System.out.println("oh no!!! 应该抛出异常！！");
            throw new Exception("oh no!!!");
        }
    }
}
