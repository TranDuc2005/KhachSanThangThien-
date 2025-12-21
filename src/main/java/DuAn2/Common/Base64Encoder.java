package DuAn2.Common;

import org.apache.commons.codec.binary.Base64;

/**
 * Concrete implementation dùng Base64 (tương tự Common.encode/decode hiện có).
 */
public class Base64Encoder implements Encoder {

    @Override
    public String encode(String input) {
        if (input == null) return null;
        Base64 base64 = new Base64();
        return new String(base64.encode(input.getBytes()));
    }

    @Override
    public String decode(String input) {
        if (input == null) return null;
        Base64 base64 = new Base64();
        return new String(base64.decode(input.getBytes()));
    }
}
