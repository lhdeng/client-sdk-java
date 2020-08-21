package org.platone.inner.contracts;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;
import org.platone.common.AuditStatusEnum;
import org.platone.common.ErrorCodeEnum;
import org.platone.common.ParseUtils;
import org.platone.common.RoleEnum;
import org.platone.common.UserStatusEnum;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;

public class UserManagerTest extends BaseTest {

	@Before
	public void init() {
		super.init();
	}

	public void parseRecepit(TransactionReceipt receipt) {
		String data = receipt.getLogs().get(0).getData();
		BigInteger code = ParseUtils.parseResponseData(data, CHAIN_ID).getValue();
		System.err.println("code >>> " + code.intValue());
		System.err.println("msg >>> " + ErrorCodeEnum.getByCode(code.intValue()).getMsg());
	}

	@Test
	public void registerTest() throws Exception {
		Credentials credentials = Credentials.create(USER_PRIVATEKEY_1);
		TransactionManager tm = new RawTransactionManager(web3j, credentials, CHAIN_ID);
		UserManager userManager = UserManager.load(web3j, tm, contractGasProvider, CHAIN_ID);
		String name = "Oliver";
		String mobile = "15821777777";
		String email = "15821777777@platone.net";
		String desc = "";
		BigInteger roles = RoleEnum.ChainAdmin.value();
		TransactionReceipt receipt = userManager.Register(name, mobile, email, desc, roles).send();
		parseRecepit(receipt);

		String result = userManager.PageAll(BigInteger.ZERO, BigInteger.valueOf(100L)).send();
		System.err.println("pageAll result >>> " + result);
	}

	@Test
	public void auditTest() throws Exception {
		TransactionManager tm = new RawTransactionManager(web3j, creatorCredentials, CHAIN_ID);
		UserManager userManager = UserManager.load(web3j, tm, contractGasProvider, CHAIN_ID);
		String addr = USER_ADDRESS_1;
		TransactionReceipt receipt = userManager.Audit(addr, BigInteger.valueOf(AuditStatusEnum.Passed.getStatus()), "").send();
		parseRecepit(receipt);
	}

	@Test
	public void addTest() throws Exception {
		TransactionManager tm = new RawTransactionManager(web3j, creatorCredentials, CHAIN_ID);
		UserManager userManager = UserManager.load(web3j, tm, contractGasProvider, CHAIN_ID);
		String addr = USER_ADDRESS_1;
		String name = "Oliver";
		String mobile = "15821777777";
		String email = "15821777777@platone.net";
		String desc = "";
		BigInteger roles = RoleEnum.ChainAdmin.value();
		TransactionReceipt receipt = userManager.Add(addr, name, mobile, email, desc, roles).send();
		parseRecepit(receipt);
	}

	@Test
	public void updateTest() throws Exception {
		TransactionManager tm = new RawTransactionManager(web3j, creatorCredentials, CHAIN_ID);
		UserManager userManager = UserManager.load(web3j, tm, contractGasProvider, CHAIN_ID);
		String addr = USER_ADDRESS_1;
		String mobile = "15821777777";
		String email = "15821777777@platone.net";
		String desc = "";
		TransactionReceipt receipt = userManager.Update(addr, mobile, email, desc).send();
		parseRecepit(receipt);
	}

	@Test
	public void deleteTest() throws Exception {
		TransactionManager tm = new RawTransactionManager(web3j, creatorCredentials, CHAIN_ID);
		UserManager userManager = UserManager.load(web3j, tm, contractGasProvider, CHAIN_ID);
		String addr = USER_ADDRESS_1;
		TransactionReceipt receipt = userManager.Delete(addr).send();
		parseRecepit(receipt);
	}

	@Test
	public void disableTest() throws Exception {
		TransactionManager tm = new RawTransactionManager(web3j, creatorCredentials, CHAIN_ID);
		UserManager userManager = UserManager.load(web3j, tm, contractGasProvider, CHAIN_ID);
		String addr = USER_ADDRESS_1;
		TransactionReceipt receipt = userManager.Disable(addr).send();
		parseRecepit(receipt);
	}

	@Test
	public void enableTest() throws Exception {
		TransactionManager tm = new RawTransactionManager(web3j, creatorCredentials, CHAIN_ID);
		UserManager userManager = UserManager.load(web3j, tm, contractGasProvider, CHAIN_ID);
		String addr = USER_ADDRESS_1;
		TransactionReceipt receipt = userManager.Enable(addr).send();
		parseRecepit(receipt);
	}

	@Test
	public void removeRolesTest() throws Exception {
		TransactionManager tm = new RawTransactionManager(web3j, creatorCredentials, CHAIN_ID);
		UserManager userManager = UserManager.load(web3j, tm, contractGasProvider, CHAIN_ID);
		String addr = USER_ADDRESS_1;
		BigInteger roles = RoleEnum.ChainAdmin.value();
		TransactionReceipt receipt = userManager.RemoveRoles(addr, roles).send();
		parseRecepit(receipt);
	}

	@Test
	public void addRolesTest() throws Exception {
		TransactionManager tm = new RawTransactionManager(web3j, creatorCredentials, CHAIN_ID);
		UserManager userManager = UserManager.load(web3j, tm, contractGasProvider, CHAIN_ID);
		String addr = USER_ADDRESS_1;
		BigInteger roles = RoleEnum.ChainAdmin.value();
		TransactionReceipt receipt = userManager.AddRoles(addr, roles).send();
		parseRecepit(receipt);
	}

	@Test
	public void setRolesTest() throws Exception {
		TransactionManager tm = new RawTransactionManager(web3j, creatorCredentials, CHAIN_ID);
		UserManager userManager = UserManager.load(web3j, tm, contractGasProvider, CHAIN_ID);
		String addr = USER_ADDRESS_1;
		BigInteger roles = RoleEnum.ChainAdmin.value();
		TransactionReceipt receipt = userManager.SetRoles(addr, roles).send();
		parseRecepit(receipt);
	}

	@Test
	public void hasRolesTest() throws Exception {
		TransactionManager tm = new RawTransactionManager(web3j, creatorCredentials, CHAIN_ID);
		UserManager userManager = UserManager.load(web3j, tm, contractGasProvider, CHAIN_ID);
		String addr = USER_ADDRESS_1;
		BigInteger roles = RoleEnum.ChainAdmin.value();
		String result = userManager.HasRoles(addr, roles).send();
		System.err.println("has roles >>> " + result);
	}

	@Test
	public void getByAddrTest() throws Exception {
		TransactionManager tm = new RawTransactionManager(web3j, creatorCredentials, CHAIN_ID);
		UserManager userManager = UserManager.load(web3j, tm, contractGasProvider, CHAIN_ID);
		String addr = USER_ADDRESS_1;
		String result = userManager.GetByAddr(addr).send();
		System.err.println("getByAddr result >>> " + result);
	}

	@Test
	public void getByNameTest() throws Exception {
		TransactionManager tm = new RawTransactionManager(web3j, creatorCredentials, CHAIN_ID);
		UserManager userManager = UserManager.load(web3j, tm, contractGasProvider, CHAIN_ID);
		String name = "";
		String result = userManager.GetByName(name).send();
		System.err.println("getByName result >>> " + result);
	}

	@Test
	public void pageAllTest() throws Exception {
		TransactionManager tm = new RawTransactionManager(web3j, creatorCredentials, CHAIN_ID);
		UserManager userManager = UserManager.load(web3j, tm, contractGasProvider, CHAIN_ID);
		BigInteger pageNum = BigInteger.valueOf(0L);
		BigInteger pageSize = BigInteger.valueOf(100L);
		String result = userManager.PageAll(pageNum, pageSize).send();
		System.err.println("pageAll result >>> " + result);
	}

	@Test
	public void pageByStatTest() throws Exception {
		TransactionManager tm = new RawTransactionManager(web3j, creatorCredentials, CHAIN_ID);
		UserManager userManager = UserManager.load(web3j, tm, contractGasProvider, CHAIN_ID);
		BigInteger pageNum = BigInteger.valueOf(0L);
		BigInteger pageSize = BigInteger.valueOf(100L);
		BigInteger status = BigInteger.valueOf(UserStatusEnum.Valid.getStatus());
		String result = userManager.PageByStat(status, pageNum, pageSize).send();
		System.err.println("pageByStat result >>> " + result);
	}

	@Test
	public void pageByRolesTest() throws Exception {
		TransactionManager tm = new RawTransactionManager(web3j, creatorCredentials, CHAIN_ID);
		UserManager userManager = UserManager.load(web3j, tm, contractGasProvider, CHAIN_ID);
		BigInteger pageNum = BigInteger.valueOf(0L);
		BigInteger pageSize = BigInteger.valueOf(100L);
		BigInteger roles = RoleEnum.ChainAdmin.value();
		String result = userManager.PageByRoles(roles, pageNum, pageSize).send();
		System.err.println("pageByRoles result >>> " + result);
	}
}
