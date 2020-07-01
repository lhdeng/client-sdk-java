package org.platone.inner.contracts;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.platone.common.ErrorCodeEnum;
import org.platone.common.KeyUtils;
import org.platone.common.KeyUtils.BlsKey;
import org.platone.common.KeyUtils.NodeKey;
import org.platone.common.ParseUtils;
import org.platone.inner.contracts.dto.NodeRegReq;
import org.web3j.abi.datatypes.generated.Int32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.RawTransactionManager;

import com.alibaba.fastjson.JSON;

public class NodeRegisterTest extends BaseTest {

	private NodeRegister nodeRegister;

	@Before
	public void init() {
		super.init();

		Credentials credentials = Credentials.create(PRIVATEKEY_2);
		transactionManager = new RawTransactionManager(web3j, credentials, CHAIN_ID);
		nodeRegister = NodeRegister.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);

	}

	public static String getKeytoolPath() {
		String os = System.getProperty("os.name");

		String path;
		if (os.startsWith("Windows")) {
			path = KeyUtils.class.getClassLoader().getResource("win/keytool.exe").getPath();
		} else if (os.startsWith("Linux") || os.startsWith("Mac OS")) {
			path = KeyUtils.class.getClassLoader().getResource("linux/keytool").getPath();
		} else {
			throw new UnsupportedOperationException("Unsupported operating system,os.name: " + os);
		}

		File file = new File(path);
		return file.getAbsolutePath();
	}

	@Test
	public void testRegisterNode() throws IOException {
		String keytoolPath = getKeytoolPath();
		BlsKey blsKey = KeyUtils.createBlsKey(keytoolPath);
		NodeKey nodeKey = KeyUtils.createNodeKey(keytoolPath);

		String blsPubKey = blsKey.getPublicKey();
		String pubKey = nodeKey.getPublicKey();

		NodeRegReq nodeRegReq = new NodeRegReq();
		nodeRegReq.setBlsPubKey(blsPubKey);
		nodeRegReq.setDesc("Hello，这是一个节点");
		nodeRegReq.setExternalIp("127.0.0.1");
		nodeRegReq.setInternalIp("127.0.0.1");
		nodeRegReq.setName("测试节点");
		nodeRegReq.setNodeType((byte) 2);
		nodeRegReq.setP2pPort(16789);
		nodeRegReq.setPublicKey(pubKey);
		nodeRegReq.setRpcPort(6789);
		String registerJson = JSON.toJSONString(nodeRegReq);

		try {
			TransactionReceipt receipt = nodeRegister.Register(registerJson).send();
			String data = receipt.getLogs().get(0).getData();
			Int32 value = ParseUtils.parseResponseData(data, CHAIN_ID);

			ErrorCodeEnum code = ErrorCodeEnum.getByCode(value.getValue().intValue());
			if (null != code) {
				logger.info("code >>> {}", code.getCode());
				logger.info("msg >>> {}", code.getMsg());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
