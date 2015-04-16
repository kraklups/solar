package net.kraklups.modelutil.exceptions;

@SuppressWarnings("serial")
public class AlarmNotFoundException extends InstanceException {

	public AlarmNotFoundException(Object key, String className) {
		super(String.format("No todo entry found with id: <%s>"), key, className);
	}

}
