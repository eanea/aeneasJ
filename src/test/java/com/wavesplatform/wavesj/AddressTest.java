package com.wavesplatform.wavesj;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AddressTest {

    @Test
    public void default_address_import_3() {
        String seed = "yores yellowfish nondestruction puttered ydalir kulla juffer dribber kill-kid maneuverable displacer approximated thunderbearing goggle-nose fable busks untaciturnity transfd wrier prehnitic oppositenesses xysters dallin bsse";
        PrivateKeyAccount account = PrivateKeyAccount.fromSeed(seed, 0, (byte) 'A');

        assertArrayEquals(Base58.decode("BnqBkNkUYU3npaX787GDXyZQynRACrJJDrHvuZE4RzrDSXBK3HL"), Base58.decode(account.getAddress()));
    }

    @Test
    public void default_address_import_4() {
        String seed = "fullmouthedly tilburies accostable v-engine iridoconstrictor innovations amphierotic whomsoever zapateados pledgees victal self-dramatizing jedediah intentionalism hooplike kylander reduced vacuole unrun rightist herried precoccygeal thane yolanda";
        PrivateKeyAccount account = PrivateKeyAccount.fromSeed(seed, 0, (byte) 'A');

        assertArrayEquals(Base58.decode("BnTo9ZAr8yyvyPwxZviKA6rMX3Bra2LqdeCGBkqKach7q3rRLnb"), Base58.decode(account.getAddress()));
    }
}
