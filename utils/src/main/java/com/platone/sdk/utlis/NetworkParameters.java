package com.platone.sdk.utlis;

public class NetworkParameters {

	public final static long MAIN_NET_CHAIN_ID = 100L;
	public final static long TEST_NET_CHAIN_ID = 102L;

	private NetworkParameters() {
	}

	public static String getHrp(long chainId) {
		if (chainId == MAIN_NET_CHAIN_ID) {
			return Hrp.LAT.getHrp();
		}

		return Hrp.LAX.getHrp();
	}

	public static String getHrp() {
		// Use lax by default in the platONE
		return Hrp.LAX.getHrp();
	}

	public static String getMainNetHrp() {
		return Hrp.LAT.getHrp();
	}

	public static String getTestNetHrp() {
		return Hrp.LAX.getHrp();
	}

	public enum Hrp {
		LAT("lat"), 
		LAX("lax");

		private String hrp;

		Hrp(String hrp) {
			this.hrp = hrp;
		}

		public String getHrp() {
			return this.hrp;
		}
	}
}
