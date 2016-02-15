package be.sonck.itunes.bridge.api.service;

import be.sonck.itunes.bridge.impl.service.DefaultITunesBridge;

public final class ITunesBridgeFactory {
	
	public static ITunesBridge create() {
		return new DefaultITunesBridge();
	}
}
