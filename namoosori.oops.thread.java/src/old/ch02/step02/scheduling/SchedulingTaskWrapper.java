package old.ch02.step02.scheduling;

import java.util.ArrayList;
import java.util.List;

import old.ch02.step02.scheduling.task.SchedulingTask;
import old.ch02.step02.scheduling.type.SchedulingType;

public class SchedulingTaskWrapper implements Runnable {
	//
	private final SchedulingTask task;
	
	// task options
	private final SchedulingType schedulingType;
	private final int schedulingTime;
	private final boolean daemon;
	
	private int lastExecutionTime;
	private boolean willRemovable;
	
	
	public SchedulingTaskWrapper(SchedulingTask task) {
		//
		this.task = task;
		this.schedulingType = task.getSchedulingType();
		this.schedulingTime = task.getSchedulingTime();
		this.daemon = task.isDaemon();
	}

	public static List<SchedulingTaskWrapper> getActiveSchedulingTaskWrappers(List<SchedulingTaskWrapper> prevTaskWrappers) {
		//
		List<SchedulingTaskWrapper> newTaskWrappers = new ArrayList<>();
		
		for (SchedulingTaskWrapper taskWrapper: prevTaskWrappers) {
			if (!taskWrapper.willRemovable) {
				newTaskWrappers.add(taskWrapper);
			}
		}
		return newTaskWrappers;
	}
	
	@Override
	public void run() {
		//
		task.execute();
	}

	public boolean isExecutable(int currentTimeSecond) {
		//
		if ( lastExecutionTime <= (currentTimeSecond - schedulingTime) ) {
			this.lastExecutionTime = currentTimeSecond;
			return true;
		}
		return false;
	}
	
	public SchedulingType getSchedulingType() {
		//
		return schedulingType;
	}
	
	public boolean isDaemon() {
		return daemon;
	}
	
	public String getThreadName(int sequence) {
		return "TaskWrapper-" + this.task.getClass().getSimpleName() + "-" + sequence;
	}

	public void setWillRemovable(boolean willRemovable) {
		this.willRemovable = willRemovable;
	}
	
}
