//package org.springcloud.turing.biz.task;
//
//import com.jd.platform.async.callback.ICallback;
//import com.jd.platform.async.callback.IWorker;
//import com.jd.platform.async.executor.timer.SystemClock;
//import com.jd.platform.async.worker.WorkResult;
//import com.jd.platform.async.wrapper.WorkerWrapper;
//
//import java.util.Map;
//
///**
// * @descri
// *
// * @author lj.michale
// * @date 2023-10-12
// */
//public class ParWorker implements IWorker<String, String>, ICallback<String, String> {
//
//    @Override
//    public String action(String s, Map<String, WorkerWrapper> map) {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "result = " + SystemClock.now() + "---param = " + s + " from 1";
//    }
//
//    @Override
//    public String defaultValue() {
//        return "worker0--default";
//    }
//
//    @Override
//    public void begin() {
//        //System.out.println(Thread.currentThread().getName() + "- start --" + System.currentTimeMillis());
//    }
//
//    @Override
//    public void result(boolean success, String param, WorkResult<String> workResult) {
//        if (success) {
//            System.out.println("callback worker0 success--" + SystemClock.now() + "----" + workResult.getResult()
//                    + "-threadName:" +Thread.currentThread().getName());
//        } else {
//            System.err.println("callback worker0 failure--" + SystemClock.now() + "----"  + workResult.getResult()
//                    + "-threadName:" +Thread.currentThread().getName());
//        }
//    }
//
//}