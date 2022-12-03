package com.chainerist.web3j.example.test;


import org.junit.jupiter.api.*;
import org.web3j.EVMTest;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

@EVMTest
@Tag("StoreNumberValueContract")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StoreNumberValueContract {
    private static com.chainerist.web3j.example.generated.StoreNumberValueContract contract;

    @Test
    @Order(1)
    public void deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider gasProvider) throws Exception {
        contract = com.chainerist.web3j.example.generated.StoreNumberValueContract.deploy(web3j, transactionManager, gasProvider).send();
        assertTrue(contract.getContractAddress().startsWith("0x"));
        Assertions.assertEquals(contract.getContractBinary(), com.chainerist.web3j.example.generated.StoreNumberValueContract.BINARY);
    }

    @Test
    @Order(2)
    public void storeValue() throws Exception {
        TransactionReceipt response = contract.store(BigInteger.ONE).send();
        assertTrue(response.getStatus().startsWith("0x1"));
    }

    @Test
    @Order(3)
    public void storeValue_fail() throws Exception {
        TransactionException e = null;
        try {
            contract.store(BigInteger.ZERO).send();
        } catch (TransactionException exception) {
            e = exception;
        } finally {
            assertNotNull(e);
        }
    }

    @Test
    @Order(4)
    public void getValue() throws Exception {
        BigInteger retrieveValue = contract.retrieve().send();
        assertEquals(BigInteger.ONE, retrieveValue);
    }
}
