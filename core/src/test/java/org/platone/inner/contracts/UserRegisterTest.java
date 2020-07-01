package org.platone.inner.contracts;

import org.junit.Before;
import org.junit.Test;
import org.platone.common.ErrorCodeEnum;
import org.platone.common.ParseUtils;
import org.platone.common.RoleEnum;
import org.platone.inner.contracts.dto.UserRegReq;
import org.web3j.abi.datatypes.generated.Int32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.RawTransactionManager;

import com.alibaba.fastjson.JSON;

public class UserRegisterTest extends BaseTest {

	private UserRegister userRegister;

	@Before
	public void init() {
		super.init();

		userRegister = UserRegister.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);
	}

	@Test
	public void testRegisterUser() {
		Credentials credentials = Credentials.create(PRIVATEKEY_1);
		transactionManager = new RawTransactionManager(web3j, credentials, CHAIN_ID);
		userRegister = UserRegister.load(web3j, transactionManager, contractGasProvider, CHAIN_ID);

		UserRegReq userRegReq = new UserRegReq();
		userRegReq.setEmail("15888888888@163.com");
		userRegReq.setMobile("15888888888");
		userRegReq.setName("张三丰");
		userRegReq.setRemark("这里是描述");
		userRegReq.setRoles(RoleEnum.ChainAdmin.value());

		String userRegJson = JSON.toJSONString(userRegReq);

		try {
			TransactionReceipt receipt = userRegister.Register(userRegJson).send();
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
