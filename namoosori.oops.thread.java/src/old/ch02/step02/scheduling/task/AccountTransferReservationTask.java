package old.ch02.step02.scheduling.task;

import old.ch02.step02.scheduling.logging.SchedulingLogger;
import old.ch02.step02.scheduling.type.SchedulingType;

public class AccountTransferReservationTask implements SchedulingTask {
	//
	@Override
	public SchedulingType getSchedulingType() {
		return SchedulingType.Once;
	}

	@Override
	public int getSchedulingTime() {
		return 10;
	}
	
	@Override
	public boolean isDaemon() {
		return true;
	}
	
	@Override
	public void execute() {
		//
		System.out.println("Execute AccountTransferReservationTask -> daemon: " + Thread.currentThread().isDaemon() + ", name: " + Thread.currentThread().getName());
		
		SchedulingLogger.log("Monitoring account transfer reservation");
	}

}
