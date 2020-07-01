package org.platone.common;

import java.util.ArrayList;
import java.util.List;

import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Int32;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ParseUtils {
	public static Int32 parseResponseData(String data, long chainId) {
		List<TypeReference<Type>> outputParameters = new ArrayList<>();
		TypeReference<?> p = new TypeReference<Int32>() {
		};

		outputParameters.add((TypeReference<Type>) p);
		List<Type> list = FunctionReturnDecoder.decode(data, outputParameters, chainId);
		if (null != list && !list.isEmpty()) {
			return (Int32) list.get(0);
		}

		return null;
	}
}
