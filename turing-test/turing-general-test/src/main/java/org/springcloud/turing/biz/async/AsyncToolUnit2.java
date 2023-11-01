//package org.springcloud.turing.biz.async;
//
//import com.jd.platform.async.executor.Async;
//import com.jd.platform.async.executor.timer.SystemClock;
//import com.jd.platform.async.wrapper.WorkerWrapper;
//import org.springcloud.turing.biz.task.ParWorker;
//import org.springcloud.turing.biz.task.ParWorker1;
//import org.springcloud.turing.biz.task.ParWorker2;
//import org.springcloud.turing.biz.task.ParWorker3;
//
//import java.util.concurrent.ExecutionException;
//
///**
// * @descri 1个执行完毕后，开启另外两个，另外两个执行完毕后，开始第4个
// *
// * @author lj.michale
// * @date 2023-10-12
// */
//public class AsyncToolUnit2 {
//
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//
//        ParWorker w = new ParWorker();
//        ParWorker1 w1 = new ParWorker1();
//        ParWorker2 w2 = new ParWorker2();
//        ParWorker3 w3 = new ParWorker3();
//
//        WorkerWrapper<String, String> workerWrapper3 =  new WorkerWrapper.Builder<String, String>()
//                .worker(w3)
//                .callback(w3)
//                .param("3")
//                .build();
//
//        WorkerWrapper<String, String> workerWrapper2 =  new WorkerWrapper.Builder<String, String>()
//                .worker(w2)
//                .callback(w2)
//                .param("2")
//                .next(workerWrapper3)
//                .build();
//
//        WorkerWrapper<String, String> workerWrapper1 =  new WorkerWrapper.Builder<String, String>()
//                .worker(w1)
//                .callback(w1)
//                .param("1")
//                .next(workerWrapper3)
//                .build();
//
//        WorkerWrapper<String, String> workerWrapper =  new WorkerWrapper.Builder<String, String>()
//                .worker(w)
//                .callback(w)
//                .param("0")
//                .next(workerWrapper1, workerWrapper2)
//                .build();
//
//
//        long now = SystemClock.now();
//        System.out.println("begin-" + now);
//
//        Async.beginWork(3100, workerWrapper);
////        Async.beginWork(2100, workerWrapper);
//
//        System.out.println("end-" + SystemClock.now());
//        System.err.println("cost-" + (SystemClock.now() - now));
//
//        System.out.println(Async.getThreadCount());
//        Async.shutDown();
//
//    }
//}
