package old.ch02.step02.scheduling;

import java.util.List;

import old.ch02.step02.scheduling.config.SchedulingConfig;
import old.ch02.step02.scheduling.type.SchedulingType;

public class TaskScheduler {
	//
	private SchedulingConfig schedulingConfig;
	private Thread schedulingConfigThread;
	
	public static void main(String[] args) {
		//
		TaskScheduler scheduler = new TaskScheduler();
		scheduler.runApplication();
	}
	
	private void runApplication() {
		//
		System.out.println("Run job scheduler..");
		
		// 스케줄링 잡 설정 로드 쓰레드
		schedulingConfig = SchedulingConfig.getInstance();
		this.schedulingConfigThread = new Thread(schedulingConfig, "schedulingConfig");
		schedulingConfigThread.start();
		
		// 리소스 로딩 쓰레드가 완료 될 때까지 대기 
		waitForLoadResource();
		System.out.println("All thread count: " + Thread.activeCount());
		 
		// JobScheduler 시작
		startTaskScheduler();
	}
	
	private void startTaskScheduler() {
		//
		List<SchedulingTaskWrapper> taskWrappers = schedulingConfig.getTaskWrappers();
		int currentTime = 0;
		int taskSequence = 1;
		
		while (true) {
			taskWrappers = SchedulingTaskWrapper.getActiveSchedulingTaskWrappers(taskWrappers);
			
			if (currentTime % 5 == 0) {
				System.out.println(Thread.currentThread().getName() + " -> currentTime: " + currentTime + "s, standbyTaskCount: " + taskWrappers.size());
			}
			
			for (SchedulingTaskWrapper taskWrapper : taskWrappers) {
				boolean executable = taskWrapper.isExecutable(currentTime);
				
				if (executable) {
					Thread taskThread = new Thread(taskWrapper, taskWrapper.getThreadName(taskSequence++));
					taskThread.setDaemon(taskWrapper.isDaemon());
					taskThread.start();
					
					if (taskWrapper.getSchedulingType() == SchedulingType.Once) {
						taskWrapper.setWillRemovable(true);
					}
				}
			}
			
			try {
				if (taskWrappers.size() == 0) {
					Thread.currentThread().interrupt();
					System.out.println("Stop TaskScheduler..");
				}
				Thread.sleep(1000);
				currentTime++;
			} catch (InterruptedException e) {
				System.out.println("Exit TaskScheduler..");
				break;
			}
		}
	}
	
	private void waitForLoadResource() {
		//
		try {
			this.schedulingConfigThread.join(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
