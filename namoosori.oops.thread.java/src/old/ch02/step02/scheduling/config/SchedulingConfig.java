package old.ch02.step02.scheduling.config;

import java.util.ArrayList;
import java.util.List;

import old.ch02.step02.scheduling.SchedulingTaskWrapper;
import old.ch02.step02.scheduling.task.AccountTransferPeriodicTask;
import old.ch02.step02.scheduling.task.AccountTransferReservationTask;
import old.ch02.step02.scheduling.task.SchedulingTask;

public class SchedulingConfig implements Runnable {
	//
	private static final SchedulingConfig instance = new SchedulingConfig();
	
	private List<SchedulingTaskWrapper> taskWrappers; 
	
	
	private SchedulingConfig() {
		// Nothing to do.
	}
	
	public static SchedulingConfig getInstance() {
		//
		return instance;
	}

	@Override
	public void run() {
		//
		loadSchedulingConfig();
//		somethingWrong();
	}
	
	private void loadSchedulingConfig() {
		//
		this.taskWrappers = new ArrayList<>();
		
		SchedulingTask task1 = new AccountTransferReservationTask();
		taskWrappers.add(new SchedulingTaskWrapper(task1));
		
		SchedulingTask task2 = new AccountTransferPeriodicTask();
//		taskWrappers.add(new SchedulingTaskWrapper(task2));
	}
	
	public void somethingWrong() {
		while(true) {
			String str = "wrong";
		}
	}

	public List<SchedulingTaskWrapper> getTaskWrappers() {
		return taskWrappers;
	}
}
