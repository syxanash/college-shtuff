package patterns.arch.appservice.reflection;

import java.lang.reflect.Method;

public class TVCommand extends Command {

	private ApplicationService appserv;
	private String method;
	
	public TVCommand(ApplicationService appserv, String method) {
		this.appserv = appserv;
		this.method = method;
	}
	
	public Object execute() {
		Class<?>[] parameters = {};
		Object[] pars = {};
		
		Object result = null;
		
		try {
			Class<?> asClass = appserv.getClass();
			Method asMethod = asClass.getMethod(method, parameters);
			
			result = asMethod.invoke(appserv, pars);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
