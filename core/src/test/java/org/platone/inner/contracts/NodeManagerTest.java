package org.platone.inner.contracts;

import java.math.BigInteger;

import org.junit.Before;
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
		BigInteger code = ParseUtils.parseResponseData(data, CHAIN_ID).getValue();
		System.err.println("code >>> " + code.intValue());
		System.err.println("msg >>> " + ErrorCodeEnum.getByCode(code.intValue()).getMsg());
	}

	@Test
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
	public void auditTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String name = "";
		BigInteger auditStat = BigInteger.valueOf(AuditStatusEnum.Passed.getStatus());
		String auditReason = "";
		TransactionReceipt receipt = nodeManager.Audit(name, auditStat, auditReason).send();
		parseRecepit(receipt);
	}

	@Test
	public void addTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String name = "";
		String owner = "";
		String desc = "";
		String publicKey = "";
		String blsPubKey = "";
		String hostAddress = "";
		BigInteger rpcPort = BigInteger.valueOf(6789);
		BigInteger p2pPort = BigInteger.valueOf(16789);
		TransactionReceipt receipt = nodeManager.Add(name, owner, desc, publicKey, blsPubKey, hostAddress, rpcPort, p2pPort).send();
		parseRecepit(receipt);
	}

	@Test
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
	public void deleteTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String name = "";
		TransactionReceipt receipt = nodeManager.Delete(name).send();
		parseRecepit(receipt);
	}

	@Test
	public void disableTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String name = "";
		TransactionReceipt receipt = nodeManager.Disable(name).send();
		parseRecepit(receipt);
	}

	@Test
	public void enableTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String name = "";
		TransactionReceipt receipt = nodeManager.Enable(name).send();
		parseRecepit(receipt);
	}

	@Test
	public void updateTypeTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String name = "";
		BigInteger nodeType = BigInteger.valueOf(NodeTypeEnum.ObserverNode.getType());
		TransactionReceipt receipt = nodeManager.UpdateType(name, nodeType).send();
		parseRecepit(receipt);
	}

	@Test
	public void getByNameTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String name = "";
		String result = nodeManager.GetByName(name).send();
		System.err.println("getByName result >>> " + result);
	}

	@Test
	public void getByPublicKeyTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String publicKey = "";
		String result = nodeManager.GetByPublicKey(publicKey).send();
		System.err.println("getByPublicKey result >>> " + result);
	}

	@Test
	public void listAllTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String result = nodeManager.ListAll().send();
		System.err.println("listAll result >>> " + result);
	}

	@Test
	public void listByStatTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		BigInteger status = BigInteger.valueOf(NodeStatusEnum.Valid.getStatus());
		String result = nodeManager.ListByStat(status).send();
		System.err.println("listByStat result >>> " + result);
	}

	@Test
	public void listByTypeTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		BigInteger type = BigInteger.valueOf(NodeTypeEnum.ConsensusNode.getType());
		String result = nodeManager.ListByType(type).send();
		System.err.println("listByType result >>> " + result);
	}

	@Test
	public void listByOwnerTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String owner = "";
		String result = nodeManager.ListByOwner(owner).send();
		System.err.println("listByType result >>> " + result);
	}

	@Test
	public void listByHostAddressTest() throws Exception {
		NodeManager nodeManager = NodeManager.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
		String hostAddress = "";
		String result = nodeManager.ListByHostAddress(hostAddress).send();
		System.err.println("listByType result >>> " + result);
	}
}
