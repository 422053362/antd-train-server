/**
 * %HEADER%
 */
package be.abeel.concurrency;

import java.util.concurrent.ThreadFactory;
/**
 * 
 * @author Thomas Abeel
 *
 */
public class DaemonThreadFactory implements ThreadFactory {
	public Thread newThread(Runnable r) {
		Thread thread =new DaemonThread(r);
		return thread;
	}
}