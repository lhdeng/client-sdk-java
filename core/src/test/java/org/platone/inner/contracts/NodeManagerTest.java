package org.platone.inner.contracts;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.platone.common.AuditStatusEnum;
import org.platone.common.ErrorCodeEnum;
import org.platone.common.NodeStatusEnum;
import org.platone.common.NodeTypeEnum;
import org.platone.common.ParseUtils;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

public class NodeManagerTest extends BaseTest {
	@Before
	public void init() {
		super.init();
	}

	public void parseRecepit(TransactionReceipt receipt) {
		String data = receipt.getLogs().get(0).getData();
		BigInteger code = ParseUtils.parseResponseData(data).getValue();
		System.err.println("code >>> " + code.intValue());
		System.err.println("msg >>> " + ErrorCodeEnum.getByCode(code.intValue()).getMsg());
	}

	@Test
	@Ignore
	public void applyTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String name = "";
		String desc = "";
		String publicKey = "";
		String blsPubKey = "";
		String hostAddress = "";
		BigInteger rpcPort = BigInteger.valueOf(6789);
		BigInteger p2pPort = BigInteger.valueOf(16789);
		TransactionReceipt receipt = nodeManager.Apply(name, desc, publicKey, blsPubKey, hostAddress, rpcPort, p2pPort).send();
		parseRecepit(receipt);
	}

	@Test
	@Ignore
	public void auditTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String name = "";
		BigInteger auditStat = BigInteger.valueOf(AuditStatusEnum.Passed.getStatus());
		String auditReason = "";
		TransactionReceipt receipt = nodeManager.Audit(name, auditStat, auditReason).send();
		parseRecepit(receipt);
	}

	@Test
	@Ignore
	public void addTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String name = "node-2";
		String owner = "lax1kwu5qpqjrhdkln42ayzrnw3rg3nqj3xnkn4wmd";
		String desc = "";
		String publicKey = "babd99766a36246e46bda65aed84a849e685db5bd0a0d920e2e59a11250d4d6e6c5293da9c1b0f2b1ca76760071f88973a0fa29dfb497c49424a21cbf79c18dc";
		String blsPubKey = "67ce9a72d589e467f9e9138a7a09ac571b703e66ceedc09897d556dc55766b8ac95d8f4c0ae21ff2569f08110657d619a0952325654cb3bd326ae809eec687c840db7daddeee703ff68ef453b60c2375a312f2e16de30e4d0cba67ea88a8d396";
		String hostAddress = "127.0.0.1";
		BigInteger rpcPort = BigInteger.valueOf(7789);
		BigInteger p2pPort = BigInteger.valueOf(26789);
		TransactionReceipt receipt = nodeManager.Add(name, owner, desc, publicKey, blsPubKey, hostAddress, rpcPort, p2pPort).send();
		parseRecepit(receipt);
	}

	@Test
	@Ignore
	public void updateTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String name = "";
		String desc = "";
		String hostAddress = "";
		BigInteger rpcPort = BigInteger.valueOf(6789);
		BigInteger p2pPort = BigInteger.valueOf(16789);
		TransactionReceipt receipt = nodeManager.Update(name, hostAddress, rpcPort, p2pPort, desc).send();
		parseRecepit(receipt);
	}

	@Test
	@Ignore
	public void deleteTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String name = "";
		TransactionReceipt receipt = nodeManager.Delete(name).send();
		parseRecepit(receipt);
	}

	@Test
	@Ignore
	public void disableTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String name = "";
		TransactionReceipt receipt = nodeManager.Disable(name).send();
		parseRecepit(receipt);
	}

	@Test
	@Ignore
	public void enableTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String name = "";
		TransactionReceipt receipt = nodeManager.Enable(name).send();
		parseRecepit(receipt);
	}

	@Test
	@Ignore
	public void updateTypeTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String name = "";
		BigInteger nodeType = BigInteger.valueOf(NodeTypeEnum.ObserverNode.getType());
		TransactionReceipt receipt = nodeManager.UpdateType(name, nodeType).send();
		parseRecepit(receipt);
	}

	@Test
	@Ignore
	public void getByNameTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String name = "";
		String result = nodeManager.GetByName(name).send();
		System.err.println("getByName result >>> " + result);
	}

	@Test
	@Ignore
	public void getByPublicKeyTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String publicKey = "";
		String result = nodeManager.GetByPublicKey(publicKey).send();
		System.err.println("getByPublicKey result >>> " + result);
	}

	@Test
	@Ignore
	public void listAllTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String result = nodeManager.ListAll().send();
		System.err.println("listAll result >>> " + result);
	}

	@Test
	@Ignore
	public void listByStatTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		BigInteger status = BigInteger.valueOf(NodeStatusEnum.Valid.getStatus());
		String result = nodeManager.ListByStat(status).send();
		System.err.println("listByStat result >>> " + result);
	}

	@Test
	@Ignore
	public void listByTypeTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		BigInteger type = BigInteger.valueOf(NodeTypeEnum.ConsensusNode.getType());
		String result = nodeManager.ListByType(type).send();
		System.err.println("listByType result >>> " + result);
	}

	@Test
	@Ignore
	public void listByOwnerTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String owner = "";
		String result = nodeManager.ListByOwner(owner).send();
		System.err.println("listByType result >>> " + result);
	}

	@Test
	@Ignore
	public void listByHostAddressTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String hostAddress = "";
		String result = nodeManager.ListByHostAddress(hostAddress).send();
		System.err.println("listByType result >>> " + result);
	}
}
