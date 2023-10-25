package kr.co.kgc.smsb.bo.batch.task;

import org.springframework.stereotype.Component;

import com.gsitm.ustra.java.batch.model.TaskInstance;
import com.gsitm.ustra.java.batch.task.UstraBatchSimpleTask;

@Component("BAT_TSK_001")
public class SampleTask extends UstraBatchSimpleTask {
	private long count = 0;

	@Override
	protected void execute(TaskInstance taskInstance) {
		for(int i=0; i<count; i++) {
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("(%d/%d)", i + 1, count));
        }
		System.out.println(String.format("count=%d", count));
   }
}