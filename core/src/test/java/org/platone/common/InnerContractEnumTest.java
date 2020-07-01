package org.platone.common;

import org.junit.Test;

import com.platon.sdk.utlis.Bech32;
import com.platon.sdk.utlis.NetworkParameters;

public class InnerContractEnumTest {
	String NodeRegister = "0x1000000000000000000000000000000000000001";
	String NodeManager = "0x1000000000000000000000000000000000000002";
	String UserRegister = "0x1000000000000000000000000000000000000003";
	String UserManager = "0x1000000000000000000000000000000000000004";
	String RoleApply = "0x1000000000000000000000000000000000000005";
	String RoleManager = "0x1000000000000000000000000000000000000006";
	String ParamManager = "0x1000000000000000000000000000000000000007";
	String Cns = "0x1000000000000000000000000000000000000008";

	@Test
	public void testCreateBech32Addr() {
		System.err.println("NodeRegister >>> " + Bech32.addressEncode(NetworkParameters.getHrp(), NodeRegister));
		System.err.println("NodeManager >>> " + Bech32.addressEncode(NetworkParameters.getHrp(), NodeManager));
		System.err.println("UserRegister >>> " + Bech32.addressEncode(NetworkParameters.getHrp(), UserRegister));
		System.err.println("UserManager >>> " + Bech32.addressEncode(NetworkParameters.getHrp(), UserManager));
		System.err.println("RoleApply >>> " + Bech32.addressEncode(NetworkParameters.getHrp(), RoleApply));
		System.err.println("RoleManager >>> " + Bech32.addressEncode(NetworkParameters.getHrp(), RoleManager));
		System.err.println("ParamManager >>> " + Bech32.addressEncode(NetworkParameters.getHrp(), ParamManager));
		System.err.println("Cns >>> " + Bech32.addressEncode(NetworkParameters.getHrp(), Cns));
	}
}
