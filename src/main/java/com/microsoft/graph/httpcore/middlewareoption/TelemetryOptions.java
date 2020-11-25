package com.microsoft.graph.httpcore.middlewareoption;

import java.util.UUID;

import javax.annotation.Nonnull;

public class TelemetryOptions {

	public static final int NONE_FLAG = 0;
	public static final int REDIRECT_HANDLER_ENABLED_FLAG = 1;
	public static final int RETRY_HANDLER_ENABLED_FLAG = 2;
	public static final int AUTH_HANDLER_ENABLED_FLAG = 4;
	public static final int DEFAULT_HTTPROVIDER_ENABLED_FLAG = 8;
	public static final int LOGGING_HANDLER_ENABLED_FLAG = 16;

	private int featureUsage = NONE_FLAG;
	private String clientRequestId;

	public void setFeatureUsage(int flag) {
		featureUsage = featureUsage | flag;
	}

	public int getFeatureUsage() {
		return featureUsage;
	}

	@Nonnull
	public String getSerializedFeatureUsage() {
		return Integer.toHexString(featureUsage);
	}

	public void setClientRequestId(@Nonnull final String clientRequestId) {
		this.clientRequestId = clientRequestId;
	}

	@Nonnull
	public String getClientRequestId() {
		if(clientRequestId == null) {
			clientRequestId = UUID.randomUUID().toString();
		}
		return clientRequestId;
	}

}
