package org.platone.inner.contracts.dto;

import java.math.BigInteger;

public class SystemParameter {
	private BigInteger blockGasLimit;
	private BigInteger txGasLimit;
	private boolean isTxUseGas;
	private boolean isProduceEmptyBlock;
	private boolean enableDeploy;

	public BigInteger getBlockGasLimit() {
		return blockGasLimit;
	}

	public void setBlockGasLimit(BigInteger blockGasLimit) {
		this.blockGasLimit = blockGasLimit;
	}

	public BigInteger getTxGasLimit() {
		return txGasLimit;
	}

	public void setTxGasLimit(BigInteger txGasLimit) {
		this.txGasLimit = txGasLimit;
	}

	public boolean isTxUseGas() {
		return isTxUseGas;
	}

	public void setTxUseGas(boolean isTxUseGas) {
		this.isTxUseGas = isTxUseGas;
	}

	public boolean isProduceEmptyBlock() {
		return isProduceEmptyBlock;
	}

	public void setProduceEmptyBlock(boolean isProduceEmptyBlock) {
		this.isProduceEmptyBlock = isProduceEmptyBlock;
	}

	public boolean isEnableDeploy() {
		return enableDeploy;
	}

	public void setEnableDeploy(boolean enableDeploy) {
		this.enableDeploy = enableDeploy;
	}

}
