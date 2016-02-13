package be.sonck.itunes.api.service;

import be.sonck.itunes.impl.service.DefaultITunesBridge;

public final class ITunesBridgeFactory {
	
	public static ITunesBridge create() {
		return new DefaultITunesBridge();
	}
}
