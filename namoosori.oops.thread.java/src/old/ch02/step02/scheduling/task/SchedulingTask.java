package old.ch02.step02.scheduling.task;

import old.ch02.step02.scheduling.type.SchedulingType;

public interface SchedulingTask {
	//
	SchedulingType getSchedulingType();
	int getSchedulingTime();
	boolean isDaemon();
	
	void execute();
}
