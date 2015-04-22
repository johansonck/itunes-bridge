package be.sonck.itunes.api.service;

import be.sonck.itunes.impl.service.DefaultITunesBridge;

public final class ITunesBridgeFactory {
	
	private static Class<? extends ITunesBridge> implementationClass = DefaultITunesBridge.class;
	
	
	public static void setImplementationClass(Class<? extends ITunesBridge> implementationClass) {
		ITunesBridgeFactory.implementationClass = implementationClass;
	}

	public static ITunesBridge create() {
		try {
			return implementationClass.newInstance();
			
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
