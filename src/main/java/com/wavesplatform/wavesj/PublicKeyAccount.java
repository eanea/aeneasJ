package com.wavesplatform.wavesj;

import java.nio.ByteBuffer;
import java.util.Arrays;

import static com.wavesplatform.wavesj.Hash.*;

public class PublicKeyAccount implements Account {

    private final byte chainId;
    private final byte[] publicKey;
    private final String address;
    private static final byte ADDRESS_VERSION = 1;
    private static final int CHECKSUM_LENGTH = 4;
    private static final int HASH_LENGTH = 32;
    private static final int AddressLength = 1 + 1/*2 for random UTF symbol in chainId*/ + HASH_LENGTH + CHECKSUM_LENGTH;

    public PublicKeyAccount(byte[] publicKey, byte chainId) {
        this.chainId = chainId;
        this.publicKey = publicKey;
        this.address = Base58.encode(address(publicKey, chainId));
    }

    public PublicKeyAccount(String publicKey, byte chainId) {
        this(Base58.decode(publicKey), chainId);
    }

    public final byte[] getPublicKey() {
        return Arrays.copyOf(publicKey, publicKey.length);
    }

    public final String getAddress() {
        return address;
    }

    public final byte getChainId() {
        return chainId;
    }

    private static byte[] address(byte[] publicKey, byte chainId) {
        byte[] bytes;
        if (chainId == Byte.MIN_VALUE) {
            ByteBuffer bytesWithVersion = ByteBuffer
                    .allocate(1 + publicKey.length)
                    .put(ADDRESS_VERSION)
                    .put(publicKey);

            byte[] checkSum = calcCheckSum(bytesWithVersion.array());

            bytes = ByteBuffer.allocate(bytesWithVersion.array().length + checkSum.length).put(bytesWithVersion.array()).put(checkSum).array();
        } else {
            byte[] withoutChecksum = ByteBuffer
                    .allocate(1 + 1 + HASH_LENGTH)
                    .put(ADDRESS_VERSION)
                    .put(chainId)
                    .put(secureHash(publicKey, 0, publicKey.length), 0, HASH_LENGTH)
                    .array();

            bytes = ByteBuffer
                    .allocate(AddressLength)
                    .put(withoutChecksum)
                    .put(calcCheckSum(withoutChecksum), 0, CHECKSUM_LENGTH)
                    .array();
        }

       return bytes;
    }

    private static byte[] calcCheckSum(byte[] bytes) {
        byte[] checkSum = hash(bytes, 0, bytes.length, BLAKE2B256);
        return Arrays.copyOf(checkSum, CHECKSUM_LENGTH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PublicKeyAccount that = (PublicKeyAccount) o;

        if (getChainId() != that.getChainId()) return false;
        if (!Arrays.equals(getPublicKey(), that.getPublicKey())) return false;
        return getAddress() != null ? getAddress().equals(that.getAddress()) : that.getAddress() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) getChainId();
        result = 31 * result + Arrays.hashCode(getPublicKey());
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        return result;
    }
}
